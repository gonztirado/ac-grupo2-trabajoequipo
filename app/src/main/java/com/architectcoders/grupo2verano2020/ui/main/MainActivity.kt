package com.architectcoders.grupo2verano2020.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.RoomDatabase
import com.architectcoders.data.repository.QuestionRepository
import com.architectcoders.grupo2verano2020.*
import com.architectcoders.grupo2verano2020.data.database.RoomDataSource
import com.architectcoders.grupo2verano2020.data.server.QuestionDbDataSource
import com.architectcoders.usecases.GetQuestions
import com.architectcoders.grupo2verano2020.ui.common.app
import com.architectcoders.grupo2verano2020.ui.common.getViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG=MainActivity::class.java.simpleName

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gotoViewButton.setOnClickListener { startActivity<ViewActivity> {} }
        gotoDatabaseButton.setOnClickListener { startActivity<DatabaseActivity> {} }
        gotoFirebaseButton.setOnClickListener { startActivity<FirebaseActivity> {} }
        gotoOcrButton.setOnClickListener { startActivity<OcrActivity> {} }

        viewModel=getViewModel {
            MainViewModel(
                GetQuestions(
                    QuestionRepository(
                        RoomDataSource(app.db),
                        QuestionDbDataSource()
                    )
                )
            )
        }

        viewModel.question.observe(this, Observer(::getQuestionRemote))


        viewModel.onGetAllQuestions()

    }

    private fun getQuestionRemote(model: MainViewModel.UiModel?) {

        when(model){
            is MainViewModel.UiModel.Content -> {
                Log.d(TAG, "updateUi: thomy:: "+model.question[0].answers[0].answer)
            }
        }

    }
}