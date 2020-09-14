package com.architectcoders.grupo2verano2020.model.server

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize


@Entity
data class Questions(
    val id: String,
    val questions: List<QuestionsAnswers>,
    val questionCount: Int,
    val quiz: String
) {
    data class QuestionsAnswers(
        val id: String,
        val question: String,
        val answer: List<Answers>
    )


    data class Answers(
        val answer: String,
        val isCorrect: Boolean
    )

}






