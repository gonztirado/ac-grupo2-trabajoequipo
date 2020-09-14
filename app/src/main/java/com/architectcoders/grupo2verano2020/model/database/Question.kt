package com.architectcoders.grupo2verano2020.model.database


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.architectcoders.grupo2verano2020.model.server.Questions

//todo: Uid = Jwf0Y4VAFsXOm8hBRP6f

@Entity
data class Questions(
    @PrimaryKey
    val id: String,
    val questions: List<QuestionsAnswers>,
    val questionCount: Int,
    val quiz: String
)

@Entity
data class QuestionsAnswers(

    val id: String,
    val question: String,
    val answer: List<Answers>
)

@Entity
data class Answers(
    val answer: String,
    val isCorrect: Boolean
)

