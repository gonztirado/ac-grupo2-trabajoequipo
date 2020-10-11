package com.architectcoders.grupo2verano2020.data.database


import com.architectcoders.data.source.LocalDataSource
import com.architectcoders.domain.Question
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource (db:QuestionDatabase) : LocalDataSource {

    private val questionDao=db.questionDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO){questionDao.questionCount()<=0}

    override suspend fun saveQuestion(question: List<Question>) {
        withContext(Dispatchers.IO){questionDao.insertUid(question.map{it.toRoomQuestion()  })}
    }

    override suspend fun getQuestions(): List<Question> =
        withContext(Dispatchers.IO){
            questionDao.getAll().map { it.toDomainQuestion() }
        }

    override suspend fun findById(id: String): Question = withContext(Dispatchers.IO){
        questionDao.findById(id).toDomainQuestion()
    }

    override suspend fun update(question: Question) {

        withContext(Dispatchers.IO){questionDao.updateUid(question.toRoomQuestion())}
    }

}