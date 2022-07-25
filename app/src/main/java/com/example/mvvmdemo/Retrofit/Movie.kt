package com.example.mvvmdemo.Retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(val Title: String,
                 val Poster: String,
                  val imdbID: String,
                   val Year: String):Serializable

/*using serializable*/

//data class Movie(@SerializedName("Title") val title: String,
//                 @SerializedName("Poster")val poster: String,
//                 val imdbID: String,
//                 @SerializedName("Year")val year: String)
