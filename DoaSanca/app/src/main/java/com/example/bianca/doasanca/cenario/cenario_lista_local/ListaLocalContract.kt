package com.example.bianca.doasanca.cenario.cenario_lista_local

import android.content.Context
import com.example.bianca.doasanca.entidades.Local

interface ListaLocalContract {
    interface View{
        fun exibeLista(lista: MutableList<Local>)
    }

    interface Presenter {
        fun onAtualizaLista(context: Context)
    }
}