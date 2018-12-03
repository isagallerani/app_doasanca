package com.example.bianca.doasanca.scenarios_main

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bianca.doasanca.GlideApp
import com.example.bianca.doasanca.R
import com.example.bianca.doasanca.entities.Local
import kotlinx.android.synthetic.main.activity_detalhes_local.*

class DetalhesLocalActivity : AppCompatActivity() {
    companion object {
        public const val LOCAL: String = "Local"
    }
    var local: Local? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_local)

        local = intent.getSerializableExtra(LOCAL) as Local?
        if(local != null){
            carregaDados()
        }

        map.setOnClickListener {
            mostraNoMapa()
        }
    }

    private fun mostraNoMapa() {
        val mostrarNoMapa = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q= ${detailsAddress.text}%2C+${detailsNumber.text}%2C+${detailsBairro.text}%2C+SãoCarlos%2C+SãoPaulo"))
        if (mostrarNoMapa.resolveActivity(packageManager) != null)
            startActivity(mostrarNoMapa)
        else
            Toast.makeText(this, "Não há como exibir no mapa", Toast.LENGTH_SHORT).show()
        }

    private fun carregaDados() {
        detailsName.setText(local?.nome_local)
        detailsAddress.setText(local?.rua_local)
        detailsNumber.setText(local?.num_local)
        detailsComplemento.setText(local?.complemento_local)
        detailsBairro.setText(local?.bairro_local)
        detailsCep.setText(local?.cep_local)
        detailsType.setText(local?.tipo_doacao)
        detailsPhone.setText(local?.telefone_local)
        detailsEmail.setText(local?.email_local)
        detailsObs.setText(local?.obs)


        GlideApp.with(this)
            .load(local?.caminhoFoto)
            .placeholder(R.drawable.ic_person)
            .centerCrop()
            .into(detailsImg)
    }
}
