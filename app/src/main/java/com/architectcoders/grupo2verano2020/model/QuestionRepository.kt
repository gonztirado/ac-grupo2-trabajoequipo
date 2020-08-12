package com.architectcoders.grupo2verano2020.model

import android.app.Application

class QuestionRepository(application: Application) {

    suspend fun questionsService() =
        QuestionDb.service
            .idAsync(
                "questions"
            )

}