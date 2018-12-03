package com.example.bianca.doasanca.entities

import android.arch.persistence.room.*
import com.example.bianca.doasanca.entities.Local

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