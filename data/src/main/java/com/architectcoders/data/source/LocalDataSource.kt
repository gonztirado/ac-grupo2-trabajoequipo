package com.architectcoders.data.source

import com.architectcoders.domain.QuestionsAnswers

interface LocalDataSource {

    suspend fun isEmpty():Boolean
    suspend fun saveQuestion(question:List<QuestionsAnswers>)
    suspend fun getQuestions():List<QuestionsAnswers>
    suspend fun findById(id: String):QuestionsAnswers
    suspend fun update(question:QuestionsAnswers)
}