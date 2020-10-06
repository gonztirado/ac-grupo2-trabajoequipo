package com.architectcoders.data.repository

import com.architectcoders.data.source.LocalDataSource
import com.architectcoders.data.source.RemoteDataSource
import com.architectcoders.domain.QuestionsAnswers

class QuestionRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getQuestions():List<QuestionsAnswers>{
        if (localDataSource.isEmpty()){
            val questionsAnswers=remoteDataSource.getAllQuestions()

            localDataSource.saveQuestion(questionsAnswers)
        }
        return localDataSource.getQuestions()
    }

    suspend fun findById(id:String): QuestionsAnswers=localDataSource.findById(id)

    suspend fun update(question:QuestionsAnswers)=localDataSource.update(question)

}