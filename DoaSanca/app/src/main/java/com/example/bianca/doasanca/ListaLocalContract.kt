package com.example.bianca.doasanca

import android.content.Context

interface ListaLocalContract {
    interface View{
        fun exibeLista(lista: MutableList<Local>)
    }

    interface Presenter {
        fun onAtualizaLista(context: Context)
    }
}