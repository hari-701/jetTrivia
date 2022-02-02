package com.example.jettrivia.screens


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jettrivia.data.DataorException
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class QuestionsViewModel @Inject constructor (private val repository: QuestionRepository):ViewModel() {
     val data:MutableState<DataorException<ArrayList<QuestionItem>,
                        Boolean,Exception>> = mutableStateOf(
                         DataorException(null,true,Exception("")))

    init {
        getAllQuestions()
    }

           private fun getAllQuestions(){
                viewModelScope.launch {
                    data.value.loading = true
                    data.value = repository.getAllQuestions()
                    if(data.value.data.toString().isNotEmpty()){
                        data.value.loading = false
                    }
                }
               }

                      fun getTotalQuestionCount(): Int {
                          return data.value.data?.toMutableList()?.size!!
           }
}