package com.example.bianca.doasanca

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlideApp.with(this)
            .load("https://www.freepik.com/free-vector/illustration-of-helping-hands-support-icons_2606889.htm")
            .into(imgLogoApp)

        Handler().postDelayed({
            val listaLocais = Intent(this, Lista_locais::class.java)
            startActivity(Lista_locais)
            finish()
        }, 2000)
    }
}
