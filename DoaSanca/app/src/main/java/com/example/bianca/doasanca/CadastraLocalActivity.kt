package com.example.bianca.doasanca

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_formulario.*
import android.widget.Spinner



class CadastraLocalActivity : AppCompatActivity() {
    companion object {
        public const val NOME_LOCAL:String = "nomeLocal"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        btnCadastrar.setOnClickListener() {
            Toast.makeText(this, "Local cadastrado", Toast.LENGTH_SHORT).show()
            salvaLocais()
        }

        val option = arrayOf("Sangue", "Roupa", "Dinheiro", "Alimento", "Brinquedo", "Móveis") //Pega opcoes do BD

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, option)

        //Adapter for spinner
        selectDonation.adapter = adapter

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
        val abrelista = Intent (this, Lista_locais::class.java)
        abrelista.putExtra(NOME_LOCAL, local.nome_local)
        setResult(Activity.RESULT_OK, abrelista)
        finish()
    }
}
