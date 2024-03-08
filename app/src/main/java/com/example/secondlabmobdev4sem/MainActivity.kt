package com.example.secondlabmobdev4sem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myViewModel: CharacterViewModel
        myViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        myViewModel.myCharacterList.observe(this, Observer {
            val recyclerView: RecyclerView = findViewById(R.id.rView)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            CharacterAdapter(this@MainActivity).submitList(it)
            recyclerView.adapter = CharacterAdapter(this@MainActivity)
        })

        //runBlocking{
            myViewModel.GetCharacters()
        //}
    }
}