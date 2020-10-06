package com.architectcoders.usecases

import com.architectcoders.data.repository.QuestionRepository
import com.architectcoders.domain.QuestionsAnswers

class GetQuestions(private val questionRepository: QuestionRepository) {

    suspend fun invoke():List<QuestionsAnswers> = questionRepository.getQuestions()

}