package com.architectcoders.grupo2verano2020.model.server

import retrofit2.http.GET

interface TheQuestionDbService {
    @GET("Questions/Jwf0Y4VAFsX0m8hBRP6f.json")
    suspend fun listQuestionAsync(): Questions

}