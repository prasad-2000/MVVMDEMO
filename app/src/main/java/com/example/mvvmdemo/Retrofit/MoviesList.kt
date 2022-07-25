package com.example.mvvmdemo.Retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MoviesList(@SerializedName("Search") val list: List<Movie>)
