package com.architectcoders.grupo2verano2020.model.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =[Uid::class],version = 1 )
abstract class QuestionDatabase :RoomDatabase(){
    abstract fun questionDao(): QuestionDao

}