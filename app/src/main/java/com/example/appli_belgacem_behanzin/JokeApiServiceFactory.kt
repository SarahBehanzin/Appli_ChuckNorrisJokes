package com.example.appli_belgacem_behanzin

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object JokeApiServiceFactory {
    fun function_api(joke:JokeApiService):JokeApiService{
        val builder=Retrofit.Builder()
            Json.asConverterFactory(MediaType.get("application/json"))
        return joke
    }
}