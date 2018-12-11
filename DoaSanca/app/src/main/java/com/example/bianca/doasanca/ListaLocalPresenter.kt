package com.example.bianca.doasanca

import android.content.Context
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ListaLocalPresenter (val view : ListaLocalContract.View) : ListaLocalContract.Presenter {
    override fun onAtualizaLista(context: Context){
        val localDao = AppDataBase.getInstance(context).localDao()
        doAsync {
            val localList = localDao.getAll() as MutableList<Local>
            uiThread {
                view.exibeLista(localList)
            }
        }
}