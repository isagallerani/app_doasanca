package com.example.bianca.doasanca
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Local (var nome_pessoa: String,
                  var email_pessoa: String,
                  var rua: String,
                  var num_casa: String,
                  var complemento: String? = null,
                  var bairro: String,
                  var cep: String,
                  var nome_local: String,
                  var rua_local: String,
                  var num_local: String,
                  var complemento_local: String? = null,
                  var bairro_local: String,
                  var cep_local: String,
                  var tipo_doacao: String,
                  var telefone_local: String,
                  var email_local: String? = null, //Campos não obrigatório do formulário
                  var obs: String? = null, //Campo não obrigatório do formulário
                  var caminhoFoto: String? = null,
                  var distancia: String? = null,
                  @PrimaryKey(autoGenerate = true)
                  val id: Int = 0) : Serializable
