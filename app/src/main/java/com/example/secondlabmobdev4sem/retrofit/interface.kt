package com.example.secondlabmobdev4sem.retrofit

import com.example.secondlabmobdev4sem.RickAndMortyApp.Companion.EndPoint
import com.example.secondlabmobdev4sem.Root

import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET(EndPoint)
    suspend fun getRickList(): Call<Root>
}
