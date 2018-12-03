package com.example.bianca.doasanca.network

import com.example.bianca.doasanca.entities.LocalList
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("locais")
    fun getLocations(): Call<LocalList>

}