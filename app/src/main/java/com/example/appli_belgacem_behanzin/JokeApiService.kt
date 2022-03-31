package com.example.appli_belgacem_behanzin
import com.example.appli_belgacem_behanzin.ListJokes.mocked

interface JokeApiService {
    fun giveMeAJoke(){
        return mocked.single()
    }
}