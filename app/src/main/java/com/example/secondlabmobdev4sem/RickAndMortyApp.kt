package com.example.secondlabmobdev4sem

import android.app.Application
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RickAndMortyApp: Application() {
    companion object{
        const val BASE_URL = "https://rickandmortyapi.com/api/"
        const val EndPoint = "character"
    }
}