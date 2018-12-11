package com.example.bianca.doasanca

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import com.example.bianca.doasanca.R.id.btnCadastrar
import com.example.bianca.doasanca.R.id.btnFoto
import kotlinx.android.synthetic.main.activity_formulario.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.File


class CadastraLocalActivity : AppCompatActivity(), CadastraLocalContract.View {

    companion object {
        public const val LOCAL: String = "Local"
        private const val REQUEST_FOTO: Int = 10
    }

    var caminhoFoto: String? = null //salva o caminho da foto tirada
    var local: Local? = null

    val presenter: CadastraLocalContract.Presenter = CadastraLocalPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        btnFoto.setOnClickListener() {
            Toast.makeText(this, "Insira uma foto do local", Toast.LENGTH_SHORT).show()
            capturaFoto()
        }
//
//        local = intent.getSerializableExtra(LOCAL) as Local?
//        if(local != null){
//            salvaLocais()
//        }
        btnCadastrar.setOnClickListener() {
            Toast.makeText(this, "Local cadastrado", Toast.LENGTH_SHORT).show()
            salvaLocais()
        }

        val option = arrayOf("Sangue", "Roupa", "Dinheiro", "Alimento", "Brinquedo", "Móveis") //Pega opcoes do BD

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, option)

        //Adapter for spinner
        selectDonation.adapter = adapter


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_FOTO && resultCode == Activity.RESULT_OK){

            GlideApp.with(this)
                .load(caminhoFoto)
                .placeholder(R.drawable.place)
                .centerCrop()
                .into(photoLocal)

           /* Glide.with(mContext)
                .load(new File(pictureUri.getPath())) // Uri of the picture
                .transform(new CircleTransform(..))
            .into(profileAvatar);*/
        }
    }


    private fun salvaLocais(){
        //verifica se os campos obrigatórios estão preenchidos
        val distanciacalculada= "0km"

        if(edtNomePessoa.text.isEmpty()){
            edtNomePessoa.requestFocus()
            edtNomePessoa.setError(getString(R.string.campo_obrigatorio))
            return
        }
        if(edtEmailPessoa.text.isEmpty()){
            edtEmailPessoa.requestFocus()
            edtEmailPessoa.setError(getString(R.string.campo_obrigatorio))
            return
        }

        if(edtEndLocal.text.isEmpty()){
            edtEndLocal.requestFocus()
            edtEndLocal.setError(getString(R.string.campo_obrigatorio))
            return
        }

        if(edtNumero.text.isEmpty()){
            edtNumero.requestFocus()
            edtNumero.setError(getString(R.string.campo_obrigatorio))
            return
        }
        if(edtCep.text.isEmpty()){
            edtCep.requestFocus()
            edtCep.setError(getString(R.string.campo_obrigatorio))
            return
        }
        if(edtBairro.text.isEmpty()){
            edtBairro.requestFocus()
            edtBairro.setError(getString(R.string.campo_obrigatorio))
            return
        }

        if(edtNomeLocal.text.isEmpty()){
            edtNomeLocal.requestFocus()
            edtNomeLocal.setError(getString(R.string.campo_obrigatorio))
            return
        }
        if(edtEndLocal.text.isEmpty()){
            edtEndLocal.requestFocus()
            edtEndLocal.setError(getString(R.string.campo_obrigatorio))
            return
        }
        if(edtNumeroLocal.text.isEmpty()){
            edtNumeroLocal.requestFocus()
            edtNumeroLocal.setError(getString(R.string.campo_obrigatorio))
            return
        }
        if(edtCepLocal.text.isEmpty()){
            edtCepLocal.requestFocus()
            edtCepLocal.setError(getString(R.string.campo_obrigatorio))
            return
        }
        if(edtBairroLocal.text.isEmpty()){
            edtBairroLocal.requestFocus()
            edtBairroLocal.setError(getString(R.string.campo_obrigatorio))
            return
        }
        if(edtTelLocal.text.isEmpty()){
            edtTelLocal.requestFocus()
            edtTelLocal.setError(getString(R.string.campo_obrigatorio))
            return
        }

        if(local==null) {
            local = Local(
                    edtNomePessoa.text.toString(),
                    edtEmailPessoa.text.toString(),
                    edtRua.text.toString(),
                    edtNumero.text.toString(),
                    edtComplemento.text.toString(),
                    edtBairro.text.toString(),
                    edtCep.text.toString(),
                    edtNomeLocal.text.toString(),
                    edtEndLocal.text.toString(),
                    edtNumeroLocal.text.toString(),
                    edtComplementoLocal.text.toString(),
                    edtBairroLocal.text.toString(),
                    edtCepLocal.text.toString(),
                    selectDonation.selectedItem.toString(),
                    edtTelLocal.text.toString(),
                    edtEmailLocal.text.toString(),
                    edtObsLocal.text.toString(),
                    caminhoFoto,
                    distancia = "0km")
        }else{

            local?.nome_pessoa = edtNomePessoa.text.toString()
            local?.email_pessoa=edtEmailPessoa.text.toString()
            local?.rua=edtRua.text.toString()
            local?.num_casa=edtNumero.text.toString()
            local?.complemento=edtComplemento.text.toString()
            local?.bairro=edtBairro.text.toString()
            local?.cep=edtCep.text.toString()
            local?.nome_local=edtNomeLocal.text.toString()
            local?.rua_local=edtEndLocal.text.toString()
            local?.num_local=edtNumeroLocal.text.toString()
            local?.complemento_local=edtComplementoLocal.text.toString()
            local?.bairro_local=edtBairroLocal.text.toString()
            local?.cep_local=edtCepLocal.text.toString()
            local?.tipo_doacao=selectDonation.selectedItem.toString()
            local?.telefone_local=edtTelLocal.text.toString()
            local?.email_local=edtEmailLocal.text.toString()
            local?.obs=edtObsLocal.text.toString()
            local?.caminhoFoto= caminhoFoto
            local?.distancia = distanciacalculada} //MUDAR A DISTANCIA


        local?.let { local ->
            presenter.onSalvaLocal(this, local)
        }

    }

    override fun salvoComSucesso(){
        Toast.makeText(this, getString(R.string.local_salvo), Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun capturaFoto() {
        val capturaFoto = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (capturaFoto.resolveActivity(getPackageManager()) != null) {
            val arquivoFoto = montaArquivoFoto()
            val uriFoto = FileProvider.getUriForFile(this, "${BuildConfig.APPLICATION_ID}.fileprovider", arquivoFoto)
            capturaFoto.putExtra(MediaStore.EXTRA_OUTPUT, uriFoto)
            startActivityForResult(capturaFoto, REQUEST_FOTO)
        } else
            Toast.makeText(this, "Não é possível tirar uma foto", Toast.LENGTH_SHORT).show()
    }

    //cria o arquivo para salvar a foto em alta resolução
    private fun montaArquivoFoto(): File {
        val nomeArquivo = "${System.currentTimeMillis()}"
        val diretorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val arquivoFoto = File.createTempFile(nomeArquivo, ".jpg", diretorio)

        caminhoFoto = arquivoFoto.absolutePath

        return  arquivoFoto
    }


}
