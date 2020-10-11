package com.architectcoders.grupo2verano2020.data.server

import android.util.Log
import com.architectcoders.data.source.RemoteDataSource
import com.architectcoders.domain.Question


class QuestionDbDataSource:RemoteDataSource {

    override suspend fun getAllQuestions(): List<Question> {


        return TheQuestionDb.retrofit
            .listQuestionAsync()
            .map { it.toDomainQuestionAnswer() }

    }






}