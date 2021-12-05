package com.tuwaiq.mixapp.UI.movie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tuwaiq.mixapp.R
import com.tuwaiq.mixapp.databinding.FragmentMovieBinding
import com.tuwaiq.mixapp.databinding.MovieListItemBinding
import com.tuwaiq.mixapp.imdb.models.Movie

class MovieFragment : Fragment() {



    private val viewModel: MovieViewModel by lazy {ViewModelProvider(this).get(MovieViewModel::class.java)}
    private lateinit var binding:FragmentMovieBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMovies().observe(
            this, Observer {
                binding.movieRv.adapter =MoviesAdapter(it)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater)
        binding.movieRv.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    private inner class MovieHolder(val binding:MovieListItemBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.ratingBar.rating = movie.imDbRating.toFloat()
            binding.titleTv.text = movie.title
            binding.yearTv.text = movie.year
            binding.imageView.load(movie.img_url)
        }

    }

    private inner class MoviesAdapter(val movies:List<Movie>):
    RecyclerView.Adapter<MovieHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
            val binding = MovieListItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
            return MovieHolder((binding))
        }

        override fun onBindViewHolder(holder: MovieHolder, position: Int) {
            val movie =movies[position]
            holder.bind(movie)
        }

        override fun getItemCount(): Int {
            return  movies.size
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}