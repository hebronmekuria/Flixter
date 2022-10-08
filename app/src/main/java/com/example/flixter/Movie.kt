package com.example.flixter

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
        @SerializedName("id")
        val id: String ?,

        @SerializedName("title")
        val title: String ?,

        @SerializedName("original_title")
        val originalTitle: String ?,

        @SerializedName("poster_path")
        val poster: String ?,

        @SerializedName("release_date")
        val release: String ?,

        @SerializedName("overview")
        val overview: String ?,

        @SerializedName("popularity")
        val popularity: Number ?,

        @SerializedName("original_language")
        val language: String ?,

        @SerializedName("adult")
        val adult: Boolean ?,

)  : Parcelable {
        constructor() : this("","","", "","","",0, "", true)
        }
