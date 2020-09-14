package com.architectcoders.grupo2verano2020.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architectcoders.grupo2verano2020.model.server.QuestionsAnswers
import com.architectcoders.grupo2verano2020.repository.DataRepository
import com.example.trabajogrupo.ui.common.ScopedViewModel
import kotlinx.coroutines.launch

class MainViewModel(private val dataRepository: DataRepository) : ScopedViewModel() {


    private val _question = MutableLiveData<UiModel>()
    val question: LiveData<UiModel>
        get() {
            return _question
        }


    sealed class UiModel {
        class Content(val question: List<QuestionsAnswers>) : UiModel()


    }
    init {
        initScope()
    }

    fun onGetAllQuestions(){
        launch {
            _question.value=UiModel.Content(dataRepository.findQuestionRemote().questions)
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()

    }


}