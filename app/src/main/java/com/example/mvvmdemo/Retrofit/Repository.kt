package com.example.mvvmdemo.Retrofit

class Repository(val apiService: ApiService) {

    fun getAllMovies()=
        apiService.getAllMovies()
}