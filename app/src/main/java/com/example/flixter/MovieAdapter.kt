package com.example.flixter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import kotlin.math.abs

class MovieAdapter(private val movies : List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class MovieViewHolder(view : View, listener: onItemClickListener) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie : Movie){
            itemView.mvTitle.text = movie.title
            itemView.mvRelease.text = movie.release
            itemView.mvPopularity.text = movie.popularity.toString()
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.mvPoster)
        }
        init {

            view.setOnClickListener {

                listener.onItemClick(absoluteAdapterPosition)

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false), mListener
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }

}