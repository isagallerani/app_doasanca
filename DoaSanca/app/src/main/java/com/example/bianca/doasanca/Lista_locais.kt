package com.example.bianca.doasanca

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

class Lista_locais : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_locais)
    }
    fun carregaLista(){
       val layoutManager = LinearLayoutManager(this)
    }
}
