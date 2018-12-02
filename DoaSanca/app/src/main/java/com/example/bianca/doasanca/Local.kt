package com.example.bianca.doasanca
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

@Entity
data class Local (val nome_pessoa: String,
                  val email_pessoa: String,
                  val rua: String,
                  val num_casa: String,
                  val complemento: String? = null,
                  val bairro: String,
                  val cep: String,
                  val nome_local: String,
                  val rua_local: String,
                  val num_local: String,
                  val complemento_local: String? = null,
                  val bairro_local: String,
                  val cep_local: String,
                  val tipo_doacao: String,
                  val telefone_local: String,
                  val email_local: String? = null, //Campos não obrigatório do formulário
                  val obs: String? = null, //Campo não obrigatório do formulário
                  val caminhoFoto: String? = null,
                  val distancia: String? = null,
                  @PrimaryKey(autoGenerate = true)
                  val id: Int) : Serializable, Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome_pessoa)
        parcel.writeString(email_pessoa)
        parcel.writeString(rua)
        parcel.writeString(num_casa)
        parcel.writeString(complemento)
        parcel.writeString(bairro)
        parcel.writeString(cep)
        parcel.writeString(nome_local)
        parcel.writeString(rua_local)
        parcel.writeString(num_local)
        parcel.writeString(complemento_local)
        parcel.writeString(bairro_local)
        parcel.writeString(cep_local)
        parcel.writeString(tipo_doacao)
        parcel.writeString(telefone_local)
        parcel.writeString(email_local)
        parcel.writeString(obs)
        parcel.writeString(caminhoFoto)
        parcel.writeString(distancia)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Local> {
        override fun createFromParcel(parcel: Parcel): Local {
            return Local(parcel)
        }

        override fun newArray(size: Int): Array<Local?> {
            return arrayOfNulls(size)
        }
    }
}