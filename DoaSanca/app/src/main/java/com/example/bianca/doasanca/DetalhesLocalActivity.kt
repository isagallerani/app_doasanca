package com.example.bianca.doasanca

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalhes_local.*
import kotlinx.android.synthetic.main.activity_formulario.*

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
