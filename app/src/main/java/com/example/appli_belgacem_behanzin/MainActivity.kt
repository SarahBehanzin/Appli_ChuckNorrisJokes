package com.example.appli_belgacem_behanzin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("list_jokes", ListJokes.mocked.toString())

        val myRV=findViewById<RecyclerView>(R.id.recyclerView)
        myRV.layoutManager = LinearLayoutManager(this)

        myRV.adapter = JokeAdapter()

        val myService:JokeApiService=JokeApiServiceFactory.function_api()

        myService.giveMeAJoke()
            .subscribeOn(Schedulers.io())
            .subscribeBy(
            onError = {Log.e("Erreur", "La Joke n'a pas été reçue.", it)},
            onSuccess={Log.i("Joke reçue", it.toString())}
        )

    }
}
