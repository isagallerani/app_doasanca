package com.example.bianca.doasanca
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_lista_locais.*
import java.util.ArrayList


class Lista_locais : AppCompatActivity() {

    private var localList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_locais)
        val myToolbar = findViewById(my_toolbar)as Toolbar;
        setSupportActionBar(myToolbar);

    }
    fun carregaLista(){
       val layoutManager = LinearLayoutManager(this)
       val adapter = LocaisAdapter(localList)
        rvLocais.adapter = adapter
        rvLocais.layoutManager = layoutManager
}
