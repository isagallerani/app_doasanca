package com.example.bianca.doasanca.cenario.cenario_cadastra_local

import android.content.Context
import com.example.bianca.doasanca.entidades.Local

interface CadastraLocalContract {
    interface View{
        fun salvoComSucesso()
    }

    interface Presenter{
        fun onSalvaLocal(context: Context, local: Local)
    }
}