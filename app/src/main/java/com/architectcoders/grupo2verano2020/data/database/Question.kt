package com.architectcoders.grupo2verano2020.data.database


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.architectcoders.domain.Answers


//todo: Uid = Jwf0Y4VAFsXOm8hBRP6f

//esta es la identidad
@Entity
data class QuestionsAnswers(
    @PrimaryKey val id: String,
    val question: String?,
    @Embedded val answer: ArrayList<Answers>
)

