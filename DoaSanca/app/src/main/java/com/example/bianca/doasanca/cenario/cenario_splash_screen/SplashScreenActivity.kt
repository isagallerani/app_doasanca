package com.example.bianca.doasanca.cenario.cenario_splash_screen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.bianca.doasanca.GlideApp
import com.example.bianca.doasanca.R
import com.example.bianca.doasanca.cenario.cenario_lista_local.Lista_locais
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlideApp.with(this)
            .load("https://image.flaticon.com/icons/svg/913/913116.svg")
            .placeholder(R.mipmap.logo)
            .into(imgLogoApp)

        Handler().postDelayed({
            val listaLocais = Intent(this, Lista_locais::class.java)
            //aqui deve-se iniciar a intent criada
            //startActivity(Lista_locais)
            startActivity(listaLocais)
            finish()
        }, 2000)
    }
}
