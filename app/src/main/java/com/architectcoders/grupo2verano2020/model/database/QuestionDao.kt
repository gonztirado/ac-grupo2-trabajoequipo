package com.architectcoders.grupo2verano2020.model.database

import androidx.room.*


@Dao
interface QuestionDao {
    @Query("SELECT * FROM QuestionsAnswers")
    fun getAll(): List<QuestionsAnswers>

    @Query("SELECT *FROM QuestionsAnswers WHERE id= :id")
    fun findById(id: String): QuestionsAnswers


    @Query("SELECT COUNT(id) FROM QuestionsAnswers")
    fun questionCount(): Int



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUid(uid: List<QuestionsAnswers>)

    @Update
    fun updateUid(uid: QuestionsAnswers)

}