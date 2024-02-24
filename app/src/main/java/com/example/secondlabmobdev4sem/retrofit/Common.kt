package com.example.secondlabmobdev4sem.retrofit

object Common {
    private val BASE_URL = "https://rickandmortyapi.com/api/"
    val retrofitService: RickAndMortyApiService
        get() = RetrofitClient.getClient(BASE_URL).create(RickAndMortyApiService::class.java)
}