package com.architectcoders.grupo2verano2020.model

import retrofit2.http.GET
import retrofit2.http.Path

interface QuestionDbService {

    @GET("architectcoders/Questions/Jwf0Y4VAFsX0m8hBhBRP6f/{q}.json")
    suspend fun listQuestionAsync(
        @Path("q") level: String
    ): QuestionDbResult


    @GET("architectcoders/Questions/Jwf0Y4VAFsX0m8hBhBRP6f/{q}.json")
    suspend fun idAsync(
        @Path("q") level: String
    ): IdDbResult
}