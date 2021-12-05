package com.tuwaiq.mixapp.UI.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuwaiq.mixapp.imdb.models.Movie
import com.tuwaiq.mixapp.imdb.repo.MovieRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val repo:MovieRepo = MovieRepo()

    fun getMovies():LiveData<List<Movie>>{
        var tempList:List<Movie> = emptyList()
        val moviesLiveData:MutableLiveData<List<Movie>> = MutableLiveData()
        viewModelScope.launch(Dispatchers.IO){
            tempList = repo.getMovie()
        }.invokeOnCompletion {
            viewModelScope.launch{
                moviesLiveData.value = tempList
            }
        }

        return moviesLiveData
    }
}