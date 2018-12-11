package com.example.bianca.doasanca

import android.content.Context

interface CadastraLocalContract {
    interface View{
        fun salvoComSucesso()
    }

    interface Presenter{
        fun onSalvaLocal(context: Context, local: Local)
    }
}