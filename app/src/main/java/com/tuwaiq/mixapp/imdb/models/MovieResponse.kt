package com.tuwaiq.mixapp.imdb.models

import com.google.gson.annotations.SerializedName

class MovieResponse {

    @SerializedName("items")
    lateinit var movie:List<Movie>
}