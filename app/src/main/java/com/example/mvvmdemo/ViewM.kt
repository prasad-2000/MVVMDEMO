package com.example.mvvmdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.Retrofit.Movie
import com.example.mvvmdemo.Retrofit.MoviesList
import com.example.mvvmdemo.Retrofit.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewM(val repository: Repository) : ViewModel() {
    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<MoviesList?> {
            override fun onResponse(call: Call<MoviesList?>, response: Response<MoviesList?>) {
                movieList.postValue(response.body()?.list)
            }

            override fun onFailure(call: Call<MoviesList?>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}