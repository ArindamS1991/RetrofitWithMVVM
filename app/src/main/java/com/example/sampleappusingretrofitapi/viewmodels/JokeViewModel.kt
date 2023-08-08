package com.example.sampleappusingretrofitapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleappusingretrofitapi.api.JokesApiService
import com.example.sampleappusingretrofitapi.api.RetrofitHelper
import com.example.sampleappusingretrofitapi.models.Jokes
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    private val jokesApiService = RetrofitHelper.getInstance().create(JokesApiService::class.java)

    private val _joke = MutableLiveData<Jokes>()
    val joke: LiveData<Jokes> = _joke

    fun fetchRandomJoke() {
        viewModelScope.launch {
            try {
                val response = jokesApiService.getRandomJoke()
                _joke.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
