package com.architectcoders.grupo2verano2020.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.architectcoders.grupo2verano2020.model.QuestionRepository
import com.architectcoders.grupo2verano2020.ui.common.Scope
import kotlinx.coroutines.launch

class MainViewModel(private val questionRepository: QuestionRepository) : ViewModel(),
    Scope by Scope.Impl() {

    private val _model=MutableLiveData<UiModel>()
    val model:LiveData<UiModel>
    get() {
        return _model
    }

    sealed class UiModel {
        class Content(val id: String) : UiModel()
    }

    init {
        initScope()
    }

    fun onIdQuestion(){
        launch {
            _model.value=UiModel.Content(questionRepository.questionsService().resultId)
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}