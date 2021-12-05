package com.tuwaiq.mixapp.imdb.api

import com.google.gson.annotations.SerializedName
import com.tuwaiq.mixapp.imdb.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImdbApi {

    @GET("/en/API/Top250Movies/k_i4tgzhw8")
    fun getMovies():Call<MovieResponse>

}