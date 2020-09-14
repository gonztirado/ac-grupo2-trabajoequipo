package com.architectcoders.grupo2verano2020.model.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =[Questions::class,QuestionsAnswers::class,Answers::class],version = 1 )
abstract class QuestionDatabase :RoomDatabase(){
    abstract fun questionDao(): QuestionDao

}