package com.example.bianca.doasanca
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_formulario.*
import kotlinx.android.synthetic.main.activity_item_lista_locais.*
import kotlinx.android.synthetic.main.activity_lista_locais.*




class Lista_locais : AppCompatActivity() {
    companion object {
        private const val REQUEST_CADASTRO: Int = 1
        private const val LISTA = "Lista locais"
    }

    private var localList: MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_locais)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_listalocal,menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val cadastraLocal = Intent(this, CadastraLocalActivity::class.java)
        val informacao = Intent (this,Info::class.java)

        when (item!!.itemId){
            R.id.menuadd -> startActivityForResult(cadastraLocal, 1)
            R.id.menuinfo -> startActivity(informacao)
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       if(requestCode== REQUEST_CADASTRO && resultCode == Activity.RESULT_OK){
           val novolocal: String? = data?.getStringExtra(CadastraLocalActivity.NOME_LOCAL)
           if (novolocal != null) {
               localList.add(novolocal)
           }
       }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putStringArrayList(LISTA, localList as ArrayList<String>)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        if(savedInstanceState != null){
            localList = savedInstanceState.getStringArrayList(LISTA).toMutableList()
        }
        super.onRestoreInstanceState(savedInstanceState)
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
