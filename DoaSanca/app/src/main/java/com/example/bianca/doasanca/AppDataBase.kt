package com.example.bianca.doasanca

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Local::class), version = 1)
public abstract class AppDataBase: RoomDatabase() {

    companion object {
        //constante nome do BD
        private val DB_NAME = "local.dao"
        //constante instancia do appdatabase
        private var instance:AppDataBase? = null

        //funcao que cria um obj appdatabase caso a instance seja null
        private fun create(context: Context):AppDataBase?{
            return Room.databaseBuilder(context, AppDataBase::class.java, DB_NAME).build()
        }

        //se instance nao for null
        public fun getInstance(context: Context):AppDataBase{
            if(instance == null){
                instance = create(context)
            }
            return instance!!
        }
    }

    public abstract fun localDao() : LocalDao
}