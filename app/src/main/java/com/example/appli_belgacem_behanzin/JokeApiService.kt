package com.example.appli_belgacem_behanzin
import com.example.appli_belgacem_behanzin.ListJokes.mocked
import io.reactivex.Single
import retrofit2.http.GET

interface JokeApiService {//création de l'interface
    //permet de donner la fin de l'URL (le début est dans la Factory)
    @GET("/random")
    fun giveMeAJoke(): Single<Joke> //retourne la Single<Joke>
}