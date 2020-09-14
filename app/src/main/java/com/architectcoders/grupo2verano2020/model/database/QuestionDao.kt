package com.architectcoders.grupo2verano2020.model.database

import androidx.room.*


@Dao
interface QuestionDao {
    @Query("SELECT * FROM Questions")
    fun getAll(): List<Questions>

    @Query("SELECT *FROM Questions WHERE id= :id")
    fun findById(id: String): Questions

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUid(uid: List<Questions>)

    @Update
    fun updateUid(uid: Questions)

}