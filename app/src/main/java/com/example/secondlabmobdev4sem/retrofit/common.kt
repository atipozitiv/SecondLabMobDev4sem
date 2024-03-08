package com.example.secondlabmobdev4sem.retrofit

import com.example.secondlabmobdev4sem.RickAndMortyApp.Companion.BASE_URL

object Common {
    val retrofitService: RickAndMortyApiService
        get() = RetrofitClient.getClient(BASE_URL).create(RickAndMortyApiService::class.java)
}