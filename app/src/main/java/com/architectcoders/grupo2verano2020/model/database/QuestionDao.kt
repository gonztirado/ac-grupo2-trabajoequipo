package com.architectcoders.grupo2verano2020.model.database

import androidx.room.*


@Dao
interface QuestionDao {
    @Query("SELECT * FROM Uid")
    fun getAll(): List<Uid>

    @Query("SELECT *FROM uid WHERE id= :id")
    fun findById(id: String): Uid

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUid(uid: List<Uid>)

    @Update
    fun updateUid(uid: Uid)

}