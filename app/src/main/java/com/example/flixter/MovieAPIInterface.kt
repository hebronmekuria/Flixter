package com.example.flixter


import retrofit2.Call
import retrofit2.http.GET

interface MovieAPIInterface {
    @GET("/3/movie/upcoming?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed")
    fun getList(): Call<MovieResults>
}