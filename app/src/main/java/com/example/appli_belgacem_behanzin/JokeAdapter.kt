package com.example.appli_belgacem_behanzin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.appli_belgacem_behanzin.ListJokes.mocked
import com.example.appli_belgacem_behanzin.ListJokes.new_mocked


class JokeAdapter : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {
    inner class JokeViewHolder(val constraintLayout: ConstraintLayout) :
        RecyclerView.ViewHolder(constraintLayout) {
           fun updateText(text:String){
               constraintLayout.findViewById<TextView>(R.id.textView).text=text
           }
    }

    //créer la view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeAdapter.JokeViewHolder {
        val view: ConstraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_layout, parent, false) as ConstraintLayout
        return JokeViewHolder(view)
    }

    //utilsée pour afficher la prochaine view quand l'autre part
    override fun onBindViewHolder(holder: JokeAdapter.JokeViewHolder, position: Int) {
        holder.updateText(new_mocked[position].value)
    }

    override fun getItemCount() = new_mocked.size//prends la taille de la Joke


}