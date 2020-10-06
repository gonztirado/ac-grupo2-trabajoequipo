package com.architectcoders.data.source

import com.architectcoders.domain.QuestionsAnswers


interface RemoteDataSource {
    suspend fun getAllQuestions():List<QuestionsAnswers>
}