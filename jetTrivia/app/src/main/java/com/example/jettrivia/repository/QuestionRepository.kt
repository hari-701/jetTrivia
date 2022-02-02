package com.example.jettrivia.repository
import android.util.Log
import com.example.jettrivia.data.DataorException
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi) {
    private val dataOrException =
        DataorException<ArrayList<QuestionItem>,
                Boolean,
                Exception>()

    suspend fun getAllQuestions(): DataorException<ArrayList<QuestionItem>, Boolean, java.lang.Exception>
    {
    try
    {
        dataOrException.loading = true
        dataOrException.data = api.getAllQuestions()
        if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

    } catch (exception: Exception)
    {
          dataOrException.e = exception
          Log.d("EXC","getAllQuestions:${dataOrException.e!!.localizedMessage}")
    }
        return dataOrException
}
}





