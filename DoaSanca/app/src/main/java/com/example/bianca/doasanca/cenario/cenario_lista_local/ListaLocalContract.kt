package com.example.bianca.doasanca.cenario.cenario_lista_local

import android.content.Context
import com.example.bianca.doasanca.entidades.Local

interface ListaLocalContract {
    interface View{
        fun showMessage(msg: String)
        fun showList(locais: List<Local>)
    }

    interface Presenter {
        fun onLoadList()
    }
}