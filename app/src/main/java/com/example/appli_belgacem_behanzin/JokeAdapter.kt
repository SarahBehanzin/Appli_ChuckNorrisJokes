package com.example.appli_belgacem_behanzin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appli_belgacem_behanzin.ListJokes.mocked


class JokeAdapter : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>(){
    inner class JokeViewHolder(val jokeTextView:TextView) : RecyclerView.ViewHolder(jokeTextView)

    //créer la view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeAdapter.JokeViewHolder {
        return JokeViewHolder(TextView(parent.context))
    }

    //utilsée pour en gros la prochaine view quand l'autre part
    override fun onBindViewHolder(holder: JokeAdapter.JokeViewHolder, position: Int) {
        holder.jokeTextView.text= mocked[position]
    }

    override fun getItemCount() = mocked.size


}