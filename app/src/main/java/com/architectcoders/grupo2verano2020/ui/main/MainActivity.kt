package com.architectcoders.grupo2verano2020.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.architectcoders.grupo2verano2020.*
import com.architectcoders.grupo2verano2020.model.QuestionRepository
import com.architectcoders.grupo2verano2020.ui.common.getViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val TAG=MainActivity::class.java.simpleName

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel=getViewModel { MainViewModel(QuestionRepository(application)) }

        viewModel.model.observe(this, Observer(::updateUi))

        gotoViewButton.setOnClickListener { startActivity<ViewActivity> {} }
        gotoDatabaseButton.setOnClickListener { startActivity<DatabaseActivity> {} }
        gotoFirebaseButton.setOnClickListener { startActivity<FirebaseActivity> {} }
        gotoOcrButton.setOnClickListener { startActivity<OcrActivity> {} }
    }

    private fun updateUi(model:MainViewModel.UiModel){

        when(model){
            is MainViewModel.UiModel.Content->
            Log.v(TAG,"test ID:: "+viewModel.onIdQuestion())
        }



    }

}