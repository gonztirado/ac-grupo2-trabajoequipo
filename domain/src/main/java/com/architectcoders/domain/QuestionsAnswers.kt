package com.architectcoders.domain



data class Questions(
    val id: String,
    val questions: ArrayList<QuestionsAnswers>,
    val questionCount: Int,
    val quiz: String
)

data class QuestionsAnswers(
    val id: String,
    val question: String?,
    val answer: ArrayList<Answers>
)


data class Answers(
    val answer: String?,
    val isCorrect: Boolean?
)





