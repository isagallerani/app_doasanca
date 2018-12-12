package com.example.bianca.doasanca.cenario.cenario_detalhes_local

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bianca.doasanca.GlideApp
import com.example.bianca.doasanca.R
import com.example.bianca.doasanca.entidades.Local
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
        detailsName.setText(local?.name)
        detailsAddress.setText(local?.street)
        detailsNumber.setText(local?.number)
        detailsComplemento.setText(local?.opt)
        detailsBairro.setText(local?.bairro_local)
        detailsCep.setText(local?.zipcode)
        detailsType.setText(local?.type)
        detailsPhone.setText(local?.phone)
        detailsEmail.setText(local?.email)
        detailsObs.setText(local?.comment)


        GlideApp.with(this)
            .load(local?.pic_url)
            .placeholder(R.drawable.place)
            .centerCrop()
            .into(detailsImg)

    }
}
