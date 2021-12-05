package com.tuwaiq.mixapp.imdb.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tuwaiq.mixapp.imdb.api.ImdbApi
import com.tuwaiq.mixapp.imdb.models.Movie
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepo {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.flickr.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val imdbApi = retrofit.create(ImdbApi::class.java)

    suspend fun getMovie(): LiveData<List<Movie>> {
        val responseLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
        var movies:List<Movie> =
            imdbApi.getMovies().await().movie
        responseLiveData.value = movies
        return responseLiveData
    }

}