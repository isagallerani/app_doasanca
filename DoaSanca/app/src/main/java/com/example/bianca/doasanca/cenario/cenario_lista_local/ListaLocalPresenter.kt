package com.example.bianca.doasanca.cenario.cenario_lista_local

import android.content.Context
import com.example.bianca.doasanca.database.AppDataBase
import com.example.bianca.doasanca.entidades.Local
import com.example.bianca.doasanca.entidades.LocalList
import com.example.bianca.doasanca.network.RetrofitInicializer
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaLocalPresenter (val view : ListaLocalContract.View) :
    ListaLocalContract.Presenter {
    override fun onLoadList(){

        val localService = RetrofitInicializer().createLocalService()

        val call = localService.getLocais()

        call.enqueue(object : Callback<LocalList> {
            override fun onFailure(call: Call<LocalList>, t: Throwable) {
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<LocalList>, response: Response<LocalList>) {
                if (response.body() != null) {
                    view.showList(response.body()!!.locais)
                } else {
                    view.showMessage("Sem notícias para hoje")
                }

            }
        })
    }
}
