package com.example.mvvmdemo.Retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api?s=batman")
    fun getAllMovies():Call<MoviesList>
}
