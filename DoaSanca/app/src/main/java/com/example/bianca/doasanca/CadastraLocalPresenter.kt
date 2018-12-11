package com.example.bianca.doasanca

import android.content.Context
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CadastraLocalPresenter (val view: CadastraLocalContract.View) : CadastraLocalContract.Presenter{
    override fun onSalvaLocal(context: Context, local: Local){
        val localDao: LocalDao = AppDataBase.getInstance(context).localDao()
        doAsync {
            localDao.insert(local)
            uiThread {
                view.salvoComSucesso()
            }
        }
    }
}