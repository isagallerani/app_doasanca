package com.example.bianca.doasanca
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_formulario.*
import kotlinx.android.synthetic.main.activity_lista_locais.*




class Lista_locais : AppCompatActivity() {

    private var localList: MutableList<String> = mutableListOf()

    val cadastraLocal = Intent(this, Formulario::class.java)
    val informacao = Intent (this,Info::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_locais)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_listalocal,menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId){
            R.id.menuadd -> startActivity(cadastraLocal)
            R.id.menuinfo -> startActivity(informacao)
        }
        return super.onOptionsItemSelected(item)
    }



    private fun salvaLocais(){
        val local = Local(edtNomeLocal.text.toString(),
            edtEmailPessoa.text.toString(),
            edtTelPessoa.text.toString(),
            edtNomeLocal.text.toString(),
            edtEndLocal.text.toString(),
            edtTelLocal.text.toString(),
            edtEmailLocal.text.toString(),
            edtObsLocal.text.toString(),
            distancia = "0km")
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
