package com.example.secondlabmobdev4sem

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondlabmobdev4sem.retrofit.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rickList: MutableList<Character> = ArrayList()
        var mService = Common.retrofitService
        mService.getRickList().enqueue(object: Callback<Root> {
            override fun onFailure(call: Call<Root>, t: Throwable) {
                Log.d("ОшибкаРетрофит", t.toString())
            }
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                val answer = response.body() as Root
                for(person in answer.results!!) {
                    var personCharacter: Character = Character()
                    personCharacter.id = person.id!!
                    personCharacter.name = person.name!!
                    personCharacter.species = person.species!!
                    personCharacter.image = person.image!!
                    rickList.add(personCharacter)
                }
                val recyclerView: RecyclerView = findViewById(R.id.rView)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = CharacterAdapter(this@MainActivity, rickList)
            }
        })
    }
}