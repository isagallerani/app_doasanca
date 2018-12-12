package com.example.bianca.doasanca.network

import com.example.bianca.doasanca.entidades.LocalList
import retrofit2.Call
import retrofit2.http.GET

interface LocalService {
    @GET("locais")
    fun getLocais(): Call<LocalList>

    @GET("usuarios")
    fun getUsuarios(): Call<LocalList>




}