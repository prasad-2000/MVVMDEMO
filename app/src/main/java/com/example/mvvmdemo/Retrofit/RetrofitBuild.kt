package com.example.mvvmdemo.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuild {
    private var BASE_URL = "https://fake-movie-database-api.herokuapp.com/"
    var apiService: ApiService? = null
    var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    var okhttpcliet = OkHttpClient.Builder()
        .readTimeout(3000,TimeUnit.MILLISECONDS)
        .writeTimeout(3000,TimeUnit.MILLISECONDS)
        .connectTimeout(3000,TimeUnit.MILLISECONDS)
        .addInterceptor(logging)
        .build()



    fun getInstance(): ApiService {
        val retrofitbuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpcliet)
            .build()
        apiService = retrofitbuilder.create(ApiService::class.java)
        return apiService!!
    }

}