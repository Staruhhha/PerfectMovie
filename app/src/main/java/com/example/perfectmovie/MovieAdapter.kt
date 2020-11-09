package com.example.perfectmovie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.films_list.view.*

class MovieAdapter(
    private val context : Context?,
    private val movies: List<Movies>,
    val listener : (Movies) -> Unit
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder (view:View) : RecyclerView.ViewHolder(view)  {


        val title = view.findViewById<TextView>(R.id.tltFilm)
        val release_date = view.findViewById<TextView>(R.id.dtFilm)
        val vote_average = view.findViewById<TextView>(R.id.rtFilm)
        val poster_path = view.findViewById<ImageView>(R.id.imgFilm)
        val original_title = view.findViewById<TextView>(R.id.orgTltFilm)
        val vote_count = view.findViewById<TextView>(R.id.votes)
        val card_view = view.findViewById<CardView>(R.id.cardView)

        fun bindView(movies: Movies, listener: (Movies) -> Unit){
            title.text = movies.title
            release_date.text = "(${movies.release_date.substring(0,4)})"
            vote_average.text = movies.vote_average.toString()
            original_title.text = movies.original_title
            vote_count.text = movies.vote_count

            itemView.setOnClickListener { listener(movies) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.films_list, parent, false))

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.card_view.animation = AnimationUtils.loadAnimation(holder.card_view.context,R.anim.anim_item)

        var currentItem = movies.get(position)
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${currentItem.poster_path}").fit().centerInside()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground).fit().into(holder.poster_path)

        holder.bindView(movies[position], listener)
    }
}