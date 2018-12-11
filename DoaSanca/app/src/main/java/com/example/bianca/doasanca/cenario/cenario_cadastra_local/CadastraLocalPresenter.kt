package com.example.bianca.doasanca.cenario.cenario_cadastra_local

import android.content.Context
import com.example.bianca.doasanca.database.AppDataBase
import com.example.bianca.doasanca.entidades.Local
import com.example.bianca.doasanca.database.LocalDao
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CadastraLocalPresenter (val view: CadastraLocalContract.View) :
    CadastraLocalContract.Presenter {
    override fun onSalvaLocal(context: Context, local: Local){
        val localDao: LocalDao = AppDataBase.getInstance(
            context
        ).localDao()
        doAsync {
            localDao.insert(local)
            uiThread {
                view.salvoComSucesso()
            }
        }
    }
}