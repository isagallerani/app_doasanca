package com.example.bianca.doasanca.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://polar-tor-40463.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun CreateAPIService() = retrofit.create(APIService::class.java)

}