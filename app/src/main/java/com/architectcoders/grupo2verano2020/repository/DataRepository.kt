package com.architectcoders.grupo2verano2020.repository

import android.app.Application
import com.architectcoders.grupo2verano2020.App
import com.architectcoders.grupo2verano2020.model.server.TheQuestionDb

import com.architectcoders.grupo2verano2020.model.database.Answers as DbAnswers
import com.architectcoders.grupo2verano2020.model.server.Answers as ServerAnswers

import com.architectcoders.grupo2verano2020.model.database.QuestionsAnswers as DbQuestionsAnswers
import com.architectcoders.grupo2verano2020.model.server.QuestionsAnswers as ServerQuestionsAnswers

class DataRepository(application: App) {


    suspend fun findQuestionRemote() =
        TheQuestionDb.retrofit
            .listQuestionAsync()


}

//private fun ServerAnswers.convertToDbQuestion() = DbAnswers(
//    answer,
//    isCorrect
//)
//
//private fun ServerQuestionsAnswers.convertToDbQuestionAnswer()=DbQuestionsAnswers(
//    id,
//    question,
//   answer
//)