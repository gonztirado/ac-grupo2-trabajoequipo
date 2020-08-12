package com.architectcoders.grupo2verano2020.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class QuestionDbResult(
    val result: List<Questions>
)

data class IdDbResult(
    @SerializedName("id")
    val resultId:String
)

@Parcelize
data class Questions(
    val answes: List<Answers>,
    val id: String,
    val question: String
) : Parcelable

@Parcelize
data class Answers(
    val answer: String,
    val isCorrect: Boolean
) : Parcelable