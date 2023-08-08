package com.example.sampleappusingretrofitapi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.sampleappusingretrofitapi.viewmodels.JokeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(JokeViewModel::class.java)

        val jokeTextView: TextView = findViewById(R.id.jokeTextView)
        val getJokeButton: Button = findViewById(R.id.fetchButton)

        viewModel.joke.observe(this) { joke ->
            jokeTextView.text = joke.value
         //   Toast.makeText(this@MainActivity, joke.value, Toast.LENGTH_SHORT).show()
        }

        getJokeButton.setOnClickListener {
            viewModel.fetchRandomJoke()
        }
    }
}
