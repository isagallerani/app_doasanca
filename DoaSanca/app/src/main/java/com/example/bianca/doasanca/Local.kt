package com.example.bianca.doasanca


data class Local (val nome_pessoa: String,
                  val email_pessoa: String,
                  val telefone_pessoa: String,
                  val nome_local: String,
                  val endereco_local: String,
                  val tipo_doacao: String,
                  val telefone_local: String,
                  val email_local: String? = null,
                  val obs: String? = null,
                  val distancia: String)