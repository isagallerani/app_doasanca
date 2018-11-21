package com.example.bianca.doasanca
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import kotlinx.android.synthetic.main.activity_lista_locais.*


class Lista_locais : AppCompatActivity() {

    private var localList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_locais)
        //não precisamos utilizar o findViewById no Kotlin, basta utilizar o mesmo id que colocamos no layout
        //val myToolbar = findViewById(my_toolbar)as Toolbar;

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_listalocal,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onResume() {
        super.onResume()
        //chama o carregaLista sempre que a activity for atualizada
        carregaLista()
    }

    fun carregaLista() {
        val layoutManager = LinearLayoutManager(this)
        val adapter = LocaisAdapter(localList)
        rvLocais.adapter = adapter
        rvLocais.layoutManager = layoutManager
    }
}
