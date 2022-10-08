package com.example.flixter

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResults (
    @SerializedName("results")
    val movies: List<Movie>

)  : Parcelable {
    constructor() : this(mutableListOf())
}