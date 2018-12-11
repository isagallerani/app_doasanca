package com.example.bianca.doasanca.database

import android.arch.persistence.room.*
import com.example.bianca.doasanca.entidades.Local

@Dao
interface LocalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(local: Local)

    @Query("SELECT * FROM local")
    fun getAll(): List<Local>

//    @Update
//    fun update(local: Local)

    @Delete
    fun delete(local: Local)
}