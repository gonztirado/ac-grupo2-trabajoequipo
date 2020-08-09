package com.architectcoders.grupo2verano2020

data class Test(
    var quiz: String? = "",
    var questionsCount: Int? = null,
    var questions : List<Questions> = emptyList()
)