package com.architectcoders.grupo2verano2020.model.database


import androidx.room.Entity


//todo: Uid = Jwf0Y4VAFsXOm8hBRP6f

@Entity
data class Uid(
    val id: String,
    val question: List<Questions>,
    val questionCount:Int,
    val quiz:String
)


@Entity
data class Questions(
    val id: String,
    val question: String,
    val answer: List<Answers>
)

@Entity
data class Answers(
    val answer: String,
    val isCorrect: Boolean
)

