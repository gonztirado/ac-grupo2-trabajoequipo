package com.architectcoders.grupo2verano2020.data

import com.architectcoders.domain.QuestionsAnswers
import com.architectcoders.grupo2verano2020.data.database.QuestionsAnswers as DomainQuestion
import com.architectcoders.domain.QuestionsAnswers as ServerQuestion


fun QuestionsAnswers.toRoomQuestion(): DomainQuestion =
    DomainQuestion(
        id,
        question,
        answer
    )

fun DomainQuestion.toDomainQuestion(): QuestionsAnswers = QuestionsAnswers(
    id,
    question,
    answer
)

fun ServerQuestion.toDomainQuestion(): QuestionsAnswers = QuestionsAnswers(
    id,
    question,
    answer
)




