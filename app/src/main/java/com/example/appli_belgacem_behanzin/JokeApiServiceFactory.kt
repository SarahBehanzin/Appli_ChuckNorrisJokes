package com.example.appli_belgacem_behanzin

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.create

//création de l'objet Factory
object JokeApiServiceFactory {
    fun function_api():JokeApiService=
        Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/")//on donne la base url
            //permet de convertir en Json
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            //permet d'adapter la Factory avec la fonction create(fonction statique)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //on build
            .build()
            //permet de retourner l'instance
            .create(JokeApiService::class.java)
}

fun main(){
    val v_service:JokeApiService=JokeApiServiceFactory.function_api()
    val single_joke=v_service.giveMeAJoke()
}