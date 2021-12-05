package com.tuwaiq.mixapp.imdb.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tuwaiq.mixapp.imdb.api.ImdbApi
import com.tuwaiq.mixapp.imdb.models.Movie
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MovieRepo"
class MovieRepo {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://imdb-api.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val imdbApi = retrofit.create(ImdbApi::class.java)

    suspend fun getMovie():List<Movie>{
        var movies:List<Movie> = emptyList()

        val response = imdbApi.getMovies().awaitResponse()
        if(response.isSuccessful){
            movies = response.body()?.movie ?: emptyList()
        }else{
//            when(response.errorBody().toString())
            Log.e(TAG , "the error is ${response.errorBody()}")
        }
        return movies
    }

}