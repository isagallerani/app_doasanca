package com.example.bianca.doasanca.cenario.cenario_lista_local

import android.content.Context
import com.example.bianca.doasanca.database.AppDataBase
import com.example.bianca.doasanca.entidades.Local
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ListaLocalPresenter (val view : ListaLocalContract.View) :
    ListaLocalContract.Presenter {
    override fun onAtualizaLista(context: Context) {
        val localDao = AppDataBase.getInstance(context).localDao()
        doAsync {
            val localList = localDao.getAll() as MutableList<Local>
            uiThread {
                view.exibeLista(localList)
            }
        }
    }
}
