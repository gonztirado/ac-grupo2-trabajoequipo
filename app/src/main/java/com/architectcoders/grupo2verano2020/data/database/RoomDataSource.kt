package com.architectcoders.grupo2verano2020.data.database

import com.architectcoders.data.source.LocalDataSource
import com.architectcoders.domain.QuestionsAnswers
import com.architectcoders.grupo2verano2020.data.toDomainQuestion
import com.architectcoders.grupo2verano2020.data.toRoomQuestion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource (db:QuestionDatabase) : LocalDataSource{

    private val questionDao=db.questionDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO){questionDao.questionCount()<=0}

    override suspend fun saveQuestion(question: List<QuestionsAnswers>) {
        withContext(Dispatchers.IO){questionDao.insertUid(question.map { it.toRoomQuestion() })}
    }

    override suspend fun getQuestions(): List<QuestionsAnswers> =
        withContext(Dispatchers.IO){
            questionDao.getAll().map { it.toDomainQuestion() }
        }

    override suspend fun findById(id: String): QuestionsAnswers = withContext(Dispatchers.IO){
        questionDao.findById(id).toDomainQuestion()
    }

    override suspend fun update(question: QuestionsAnswers) {

        withContext(Dispatchers.IO){questionDao.updateUid(question.toRoomQuestion())}
    }

}