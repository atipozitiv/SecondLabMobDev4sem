package com.example.secondlabmobdev4sem

import android.util.Log
import com.example.secondlabmobdev4sem.retrofit.Common
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RickAndMortyApiClient {
    var newList: MutableList<Character> = ArrayList()
    fun getList() = runBlocking{
        var mService = Common.retrofitService
        launch {
            mService.getRickList().enqueue(object : Callback<Root> {
                override fun onFailure(call: Call<Root>, t: Throwable) {
                    Log.d("ОшибкаРетрофит", t.toString())
                }

                override fun onResponse(call: Call<Root>, response: Response<Root>) {
                    val answer = response.body() as Root
                    for (person in answer.results!!) {
                        var personCharacter = Character()
                        personCharacter.id = person.id!!
                        personCharacter.name = person.name!!
                        personCharacter.species = person.species!!
                        personCharacter.image = person.image!!
                        newList.add(personCharacter)
                    }
                    Log.i("dslgkfj",newList.toString())
                }
            })
        }
    }
}