package com.example.appli_belgacem_behanzin
import com.example.appli_belgacem_behanzin.ListJokes.mocked
import io.reactivex.Single
import retrofit2.http.GET

interface JokeApiService {
    @GET("/random")
    fun giveMeAJoke(): Single<Joke>
}