package com.example.appli_belgacem_behanzin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("list_jokes", ListJokes.mocked.toString())
    }
}
