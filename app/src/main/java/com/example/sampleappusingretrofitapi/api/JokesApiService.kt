package com.example.sampleappusingretrofitapi.api

import com.example.sampleappusingretrofitapi.models.Joke
import com.example.sampleappusingretrofitapi.models.Jokes
import retrofit2.http.GET

interface JokesApiService {
    @GET("jokes/random")
    suspend fun getRandomJoke(): Jokes
}