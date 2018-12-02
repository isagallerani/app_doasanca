package com.example.bianca.doasanca

import android.arch.persistence.room.*

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