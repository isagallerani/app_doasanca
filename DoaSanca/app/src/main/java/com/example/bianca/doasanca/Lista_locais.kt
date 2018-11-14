package com.example.bianca.doasanca
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_lista_locais.*


class Lista_locais : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_locais)
        val myToolbar = findViewById(my_toolbar)as Toolbar;
        setSupportActionBar(myToolbar);

    }
    fun carregaLista(){
       val layoutManager = LinearLayoutManager(this)
    }
}
