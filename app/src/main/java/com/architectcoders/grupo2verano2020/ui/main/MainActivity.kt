package com.architectcoders.grupo2verano2020.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.architectcoders.grupo2verano2020.*
import com.architectcoders.grupo2verano2020.repository.DataRepository
import com.example.trabajogrupo.ui.common.app
import com.example.trabajogrupo.ui.common.getViewModel
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

        viewModel=getViewModel { MainViewModel(DataRepository(app))}

        viewModel.question.observe(this, Observer(::getQuestionRemote))


        viewModel.onGetAllQuestions()

    }

    private fun getQuestionRemote(model: MainViewModel.UiModel?) {

        when(model){
            is MainViewModel.UiModel.Content -> {
                Log.d(TAG, "getQuestionRemote: thomy  "+model.question.size)
            }
        }

    }
}