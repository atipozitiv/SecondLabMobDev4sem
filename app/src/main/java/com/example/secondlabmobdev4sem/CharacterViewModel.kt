package com.example.secondlabmobdev4sem

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class CharacterViewModel(application: Application) : AndroidViewModel(application) {
    var myCharacterList = MutableLiveData<MutableList<Character>>()

    fun GetCharacters() = runBlocking {
        val client = RickAndMortyApiClient()
        val job = launch{
            client.getList()
        }
        job.join()
        myCharacterList.value = client.newList
    }
}