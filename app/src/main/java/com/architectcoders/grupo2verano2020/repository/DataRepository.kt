package com.architectcoders.grupo2verano2020.repository

import android.app.Application
import com.architectcoders.grupo2verano2020.App
import com.architectcoders.grupo2verano2020.model.server.TheQuestionDb



import com.architectcoders.grupo2verano2020.model.database.Questions as DbQuestions
import com.architectcoders.grupo2verano2020.model.server.Questions as ServerQuestions

class DataRepository(application: App) {


    suspend fun findQuestionRemote() =
        TheQuestionDb.retrofit
            .listQuestionAsync()


}

private fun ServerQuestions.convertToDbQuestion() = DbQuestions(
    id,
    questions,
    questionCount,
    quiz
)
