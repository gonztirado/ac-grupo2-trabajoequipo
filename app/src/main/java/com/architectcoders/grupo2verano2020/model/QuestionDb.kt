package com.architectcoders.grupo2verano2020.model

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object QuestionDb {

    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    val service:QuestionDbService=Retrofit.Builder()
        .baseUrl("https://architectcoders.firebaseio.com")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        // Moshi maps JSON to classes
        .addConverterFactory(MoshiConverterFactory.create())
        // The call adapter handles threads
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .run {
            create<QuestionDbService>(QuestionDbService::class.java)
        }

}