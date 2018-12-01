package com.example.bianca.doasanca
import java.io.Serializable


data class Local (val nome_pessoa: String,
                  val email_pessoa: String,
                  val rua: String,
                  val num_casa: String,
                  val complemento: String,
                  val cep: String,
                  val bairro: String,
                  val nome_local: String,
                  val rua_local: String,
                  val num_local: String,
                  val bairro_local: String,
                  val complemento_local: String,
                  val cep_local: String,
                  val tipo_doacao: String,
                  val telefone_local: String,
                  val email_local: String? = null, //Campos não obrigatório do formulário
                  val obs: String? = null, //Campo não obrigatório do formulário
                  val distancia: String) : Serializable