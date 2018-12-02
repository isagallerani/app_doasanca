package com.example.bianca.doasanca

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detalhes_local.*

class DetalhesLocalActivity : AppCompatActivity() {
    companion object {
        public const val LOCAL: String = "Local"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_local)

        val local: Local? = intent.getSerializableExtra(DetalhesLocalActivity.LOCAL) as Local?
        if(local != null){
            carregaDados(local)
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

    private fun carregaDados(local: Local) {
        detailsName.setText(local.nome_local)
        detailsType.setText(local.tipo_doacao)
        detailsObs.setText(local.obs)
        detailsPhone.setText(local.telefone_local)
        detailsEmail.setText(local.email_local)
        detailsAddress.setText(local.rua_local)
        detailsNumber.setText(local.num_local)
        detailsComplemento.setText(local.complemento_local)
        detailsBairro.setText(local.bairro_local)
        detailsCep.setText(local.cep_local)
        detailsType.setText(local.tipo_doacao)

        GlideApp.with(this)
            .load(local.caminhoFoto)
            .placeholder(R.drawable.ic_person)
            .centerCrop()
            .into(detailsImg)
    }
}
