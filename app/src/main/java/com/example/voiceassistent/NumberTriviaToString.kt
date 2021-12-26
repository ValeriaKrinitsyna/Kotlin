package com.example.voiceassistent

import android.util.Log
import androidx.core.util.Consumer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NumberTriviaToString {
    fun getTrivia(number: String?, callback: Consumer<String?>) {
        val api = NumberTriviaService.getApi()
        val call = number?.let { api.getNumberTrivia(it) }//"$number?json"
        call!!.enqueue(object : Callback<NumberTrivia?> {
            override fun onResponse(call: Call<NumberTrivia?>, response: Response<NumberTrivia?>) {

                val result = response.body()
                if (result != null) {
                    val temp = result.text
                    var answer = temp
                    callback.accept(answer.toString())
                } else callback.accept("Не могу найти факт response")
            }

            override fun onFailure(call: Call<NumberTrivia?>, t: Throwable) {
                Log.w("WEATHER", t.message)
                callback.accept("Не могу найти факт failure")
            }
        })
    }
}