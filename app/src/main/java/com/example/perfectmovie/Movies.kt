package com.example.perfectmovie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    val title: String,
    val poster_path: String,
    val release_date : String,
    val vote_average: Double,
    val original_title : String,
    val vote_count : String,
    val overview : String,
    val backdrop_path : String
) : Parcelable
