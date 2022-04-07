package com.example.appli_belgacem_behanzin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    val tag="mainActivity"
    val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag,"composite avant le clear ${compositeDisposable.size()}")
        compositeDisposable.clear()
        Log.i(tag,"composite après le clear ${compositeDisposable.size()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(tag, ListJokes.mocked.toString())

        val myRV=findViewById<RecyclerView>(R.id.recyclerView)
        myRV.layoutManager = LinearLayoutManager(this)

        myRV.adapter = JokeAdapter()

        val myService:JokeApiService=JokeApiServiceFactory.function_api()

        val jokeDisposable: Disposable =myService.giveMeAJoke()
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                onError = {Log.e(tag, "La Joke n'a pas été reçue.", it)},
                onSuccess={Log.i(tag, it.toString())}
            )
        //ajout du jokeDisposable dans le compositeDisposable
        compositeDisposable.add(jokeDisposable)
    }
}
