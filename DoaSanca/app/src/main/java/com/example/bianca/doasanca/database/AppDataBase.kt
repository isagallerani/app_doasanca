package com.example.bianca.doasanca.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.bianca.doasanca.entidades.Local

@Database(entities = arrayOf(Local::class), version = 1)
public abstract class AppDataBase: RoomDatabase() {

    companion object {
        //constante nome do BD
        private val DB_NAME = "local.db"
        //constante instancia do appdatabase
        private var instance: AppDataBase? = null

        //funcao que cria um obj appdatabase caso a instance seja null
        private fun create(context: Context): AppDataBase?{
            return Room.databaseBuilder(context, AppDataBase::class.java,
                DB_NAME
            ).build()
        }

        //se instance nao for null
        public fun getInstance(context: Context): AppDataBase {
            if(instance == null){
                instance =
                        create(context)
            }
            return instance!!
        }
    }

    public abstract fun localDao() : LocalDao
}