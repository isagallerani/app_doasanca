package com.example.bianca.doasanca.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer {
    val retrofit= Retrofit.Builder()
        .baseUrl("https://polar-tor-40463.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun createLocalService() = retrofit.create(LocalService::class.java)

}