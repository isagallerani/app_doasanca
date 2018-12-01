package com.example.bianca.doasanca

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_formulario.*
import java.io.File


class CadastraLocalActivity : AppCompatActivity() {
    companion object {
        public const val NOME_LOCAL:String = "nomeLocal"
        private const val REQUEST_FOTO: Int = 10
    }
    var caminhoFotoAtual: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        btnFoto.setOnClickListener() {
            Toast.makeText(this, "Insira uma foto do local", Toast.LENGTH_SHORT).show()
            capturaFoto()
        }

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
                .load(caminhoFotoAtual)
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
        val local = Local(edtNomeLocal.text.toString(),
            edtEmailPessoa.text.toString(),
            edtRua.text.toString(),
            edtNumero.text.toString(),
            edtComplemento.text.toString(),
            edtCep.text.toString(),
            edtBairro.text.toString(),
            edtNomeLocal.text.toString(),
            edtEndLocal.text.toString(),
            edtNumeroLocal.text.toString(),
            edtComplementoLocal.text.toString(),
            edtCepLocal.text.toString(),
            edtBairroLocal.text.toString(),
            edtTelLocal.text.toString(),
            edtEmailLocal.text.toString(),
            edtObsLocal.text.toString(),
            distancia = "0km")

        val abrelista = Intent (this, Lista_locais::class.java)
        abrelista.putExtra(NOME_LOCAL, local.nome_local)
        setResult(Activity.RESULT_OK, abrelista)
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

        caminhoFotoAtual = arquivoFoto.absolutePath

        return  arquivoFoto
    }


}
