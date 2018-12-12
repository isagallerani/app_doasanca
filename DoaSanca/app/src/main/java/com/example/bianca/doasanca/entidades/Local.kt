package com.example.bianca.doasanca.entidades
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Local (val name_pessoa: String,
                  val email_pessoa: String,
                  val latitude: String,
                  val longitude: String,
                  val name: String,
                  val street: String,
                  val number: String,
                  val opt: String? = null,
                  val zipcode: String,
                  val type: String,
                  val phone: String,
                  val email: String? = null, //Campos não obrigatório do formulário
                  val comment: String? = null, //Campo não obrigatório do formulário
                  val pic_url: String? = null,
                  val distancia: String? = null,
                  @PrimaryKey(autoGenerate = true)
                  val ID: Int = 0) : Serializable
