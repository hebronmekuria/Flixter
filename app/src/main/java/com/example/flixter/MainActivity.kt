package com.example.flixter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val Movie_Extra = "MOVIE_EXTRA"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies.layoutManager = LinearLayoutManager(this)
        rvMovies.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            var adapter = MovieAdapter(movies)
            rvMovies.adapter = adapter

            adapter.setOnItemClickListener(object : MovieAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
                    var movie = movies[position]
                    //Toast.makeText(this@MainActivity, "You clicked on item no $position", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra("MovieTitle", movie.originalTitle)
                    intent.putExtra("MovieOverview", movie.overview)
                    intent.putExtra("MovieImage", movie.poster)
                    startActivity(intent)

                }


            })
        }
    }
    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieAPIService.getInstance()!!.create(MovieAPIInterface::class.java)
        apiService.getList().enqueue(object: Callback<MovieResults> {
            override fun onResponse(call: Call<MovieResults>, response: Response<MovieResults>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResults>, t: Throwable) {

            }

        })
    }
}