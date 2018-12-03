package com.example.bianca.doasanca.entities
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Local (var nome: String,
                  var rua: String,
                  var num: Int,
                  var complemento: String? = null,
                  var bairro: String,
                  var cep: Int,
                  var tipo_doacao: String,
                  var telefone: String,
                  var email: String? = null, //Campos não obrigatório do formulário
                  var obs: String? = null, //Campo não obrigatório do formulário
                  var caminhoFoto: String? = null,
                  var distancia: String? = null,
                  @PrimaryKey(autoGenerate = true)
                  val id: Int = 0) : Serializable
