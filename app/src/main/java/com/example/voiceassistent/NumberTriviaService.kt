package com.example.voiceassistent

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NumberTriviaService {
    @JvmName("getApi1")
    fun getApi(): NumberTriviaApi {
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://numbersapi.com").addConverterFactory(GsonConverterFactory.create(gson)).build(); //Базовая часть адреса
                //.addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                //.build()
        return retrofit.create(NumberTriviaApi::class.java) //Создание объекта, при помощи которого будут выполняться запросы

    }
}