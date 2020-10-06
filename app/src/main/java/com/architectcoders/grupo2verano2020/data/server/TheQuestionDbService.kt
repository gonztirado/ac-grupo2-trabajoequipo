package com.architectcoders.grupo2verano2020.data.server

import com.architectcoders.domain.Questions
import retrofit2.http.GET

interface TheQuestionDbService {
    @GET("Questions/Jwf0Y4VAFsX0m8hBRP6f.json")
    suspend fun listQuestionAsync(): Questions

}