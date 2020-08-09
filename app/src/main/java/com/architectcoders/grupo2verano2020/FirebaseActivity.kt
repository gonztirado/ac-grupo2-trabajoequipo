package com.architectcoders.grupo2verano2020

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_firebase.*


class FirebaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)

        val database = Firebase.database
        val myRef = database.getReference("Questions")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (singleSnapshot in dataSnapshot.children) {
                    val data = singleSnapshot.getValue(Test::class.java)
                    setSampleView(data)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException())
            }
        })
    }

    fun setSampleView(test: Test?) {
        test?.let {
            it.apply {
                quiz_name.text = quiz
                question_text.text = questions[0].question
                question_answer1.text = questions[0].answers[0].answer
                question_answer2.text = questions[0].answers[1].answer
            }

        }
    }
}