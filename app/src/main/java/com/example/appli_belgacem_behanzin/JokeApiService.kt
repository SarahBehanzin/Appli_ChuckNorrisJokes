package com.example.appli_belgacem_behanzin
import com.example.appli_belgacem_behanzin.ListJokes.mocked
import retrofit2.http.GET

interface JokeApiService {
    @GET("url_path_extension") fun giveMeAJoke(liste:List<Joke>): Joke {
        return liste.single()
    }
}