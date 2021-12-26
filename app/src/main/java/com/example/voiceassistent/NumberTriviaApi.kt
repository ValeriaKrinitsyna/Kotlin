package com.example.voiceassistent
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NumberTriviaApi {
    @GET("{text}?json") //?callback=showNumber
    fun getNumberTrivia(@Path("text") number: String): Call<NumberTrivia?>?
}