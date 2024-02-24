package com.example.secondlabmobdev4sem.retrofit


import com.example.secondlabmobdev4sem.Character
import com.example.secondlabmobdev4sem.Root
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET("character")
    fun getRickList(): Call<Root>
}