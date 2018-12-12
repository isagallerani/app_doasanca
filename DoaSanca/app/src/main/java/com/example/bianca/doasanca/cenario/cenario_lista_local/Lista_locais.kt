package com.example.bianca.doasanca.cenario.cenario_lista_local
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.bianca.doasanca.*
import com.example.bianca.doasanca.cenario.cenario_cadastra_local.CadastraLocalActivity
import com.example.bianca.doasanca.cenario.cenario_detalhes_local.DetalhesLocalActivity
import com.example.bianca.doasanca.cenario.cenario_info_local.Info
import com.example.bianca.doasanca.entidades.Local
import kotlinx.android.synthetic.main.activity_lista_locais.*
import java.util.*

class Lista_locais : AppCompatActivity(), ListaLocalContract.View {



    companion object {
        private const val REQUEST_CADASTRO: Int = 1
        private const val LISTA = "Lista locais"
    }

    var localList: MutableList<Local> = mutableListOf()
//    var indexLocalClicado: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_locais)
        val presenter: ListaLocalContract.Presenter = ListaLocalPresenter(this)
        presenter.onLoadList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_listalocal,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val cadastraLocal = Intent(this, CadastraLocalActivity::class.java)
        val informacao = Intent (this, Info::class.java)

        when (item!!.itemId){
            R.id.menuadd -> startActivity(cadastraLocal)
            R.id.menuinfo -> startActivity(informacao)
        }

        return super.onOptionsItemSelected(item)
    }


 /*   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== REQUEST_CADASTRO && resultCode == Activity.RESULT_OK){
           val local: Local? = data?.getSerializableExtra(CadastraLocalActivity.LOCAL) as Local
           if (local != null) {
               localList.add(local)
           }
       }

    } */

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putSerializable(LISTA, localList as ArrayList<String>)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            localList = savedInstanceState.getSerializable(LISTA) as MutableList<Local>
        }

    }


    override fun onResume() {
        super.onResume()
        //chama o carregaLista sempre que a activity for atualizada
    }

    override fun showList(locais: List<Local>) {
        //localList = lista
        val adapter = LocaisAdapter(this, locais)

        adapter.setOnItemClickListener {local, indexLocalClicado ->
            //            this.indexLocalClicado = indexLocalClicado
            val abreDetalhes = Intent(this, DetalhesLocalActivity::class.java)
            abreDetalhes.putExtra(DetalhesLocalActivity.LOCAL, local) // confirmar
            startActivity(abreDetalhes)
        }

        val layoutManager = LinearLayoutManager(this)
        rvLocais.adapter = adapter
        rvLocais.layoutManager = layoutManager
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


}


