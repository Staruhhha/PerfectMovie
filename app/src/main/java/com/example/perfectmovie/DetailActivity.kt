package com.example.perfectmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val item = intent.getParcelableExtra<Movies>("OBJECT_INTENT")
        val title = findViewById<TextView>(R.id.tltFilm2)
        val original_title = findViewById<TextView>(R.id.orgTltFilm2)
        val release_date = findViewById<TextView>(R.id.dtFilm2)
        val vote_average = findViewById<TextView>(R.id.rtFilm2)
        val poster_path = findViewById<ImageView>(R.id.imgFilm2)
        val vote_count = findViewById<TextView>(R.id.votes2)
        val overview = findViewById<TextView>(R.id.overview)
        val backdrop_path = findViewById<ImageView>(R.id.baner)


        title.text = item.title
        release_date.text = item.release_date
        original_title.text = item.original_title
        vote_average.text = item.vote_average.toString()
        vote_count.text = item.vote_count
        overview.text = item.overview

        Picasso.get().load("https://image.tmdb.org/t/p/w500/${item.backdrop_path}").fit().centerInside()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground).into(backdrop_path)
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${item.poster_path}").fit().centerInside()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground).into(poster_path)
    }
}
