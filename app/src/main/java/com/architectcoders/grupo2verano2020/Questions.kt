package com.architectcoders.grupo2verano2020

data class Questions(
    var id: String? = "",
    var question: String? = "",
    var answers: List<Answers> = emptyList()
)