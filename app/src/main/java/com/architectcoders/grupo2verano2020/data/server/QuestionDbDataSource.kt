package com.architectcoders.grupo2verano2020.data.server

import com.architectcoders.data.source.RemoteDataSource
import com.architectcoders.domain.QuestionsAnswers
import com.architectcoders.grupo2verano2020.data.toDomainQuestion

class QuestionDbDataSource:RemoteDataSource {
    override suspend fun getAllQuestions(): List<QuestionsAnswers> =

        TheQuestionDb.retrofit
            .listQuestionAsync()
            .questions
            .map{it.toDomainQuestion()}




}