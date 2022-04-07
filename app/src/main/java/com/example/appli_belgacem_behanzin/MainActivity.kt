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
    val tag="mainActivity"//nom tu tag de la classe
    //ajout de la variable de type CompositeDisposable()
    val compositeDisposable = CompositeDisposable()

    //on clear le compositeDisposable quand l'activité est finie
    override fun onDestroy() {
        super.onDestroy()
        //Log avant le clear
        Log.i(tag,"composite avant le clear ${compositeDisposable.size()}")
        //clear du compositeDisposable
        compositeDisposable.clear()
        //Log après le clear
        Log.i(tag,"composite après le clear ${compositeDisposable.size()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Log de la liste de jokes
        Log.i(tag, ListJokes.mocked.toString())

        //on cherche l'ID de la recyclerView et on donne la valeur de sa layoutManager
        val myRV=findViewById<RecyclerView>(R.id.recyclerView)
        myRV.layoutManager = LinearLayoutManager(this)

        //On assigne la Joke adapter à l'adapteur de la Recycler View
        myRV.adapter = JokeAdapter()

        //création du service appelant function_api()
        val myService:JokeApiService=JokeApiServiceFactory.function_api()

        //valeur de type Disposable
        val jokeDisposable: Disposable =myService.giveMeAJoke()//retourne la Single Joke
            .subscribeOn(Schedulers.io())//permet d'éxécuter sur un autre thread
            .subscribeBy(
                onError = {Log.e(tag, "La Joke n'a pas été reçue.", it)},//cas d'échec
                onSuccess={Log.i(tag, it.toString())}//cas de succès
            )
        //ajout du jokeDisposable dans le compositeDisposable
        compositeDisposable.add(jokeDisposable)
    }
}
