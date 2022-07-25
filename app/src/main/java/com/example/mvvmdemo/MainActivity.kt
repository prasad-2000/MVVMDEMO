package com.example.mvvmdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.Retrofit.Movie
import com.example.mvvmdemo.Retrofit.Repository
import com.example.mvvmdemo.Retrofit.RetrofitBuild
import com.example.mvvmdemo.Retrofit.ViewMFactory
import com.example.mvvmdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val retrofitService = RetrofitBuild.getInstance()
    lateinit var mainBinding: ActivityMainBinding
    lateinit var adapter: MainAdapter
    lateinit var list: ArrayList<Movie>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initViewModel()
        list = ArrayList()

    }

    fun initViewModel() {
        var viewmodel = ViewModelProvider(this,
            ViewMFactory(Repository(retrofitService))).get(ViewM::class.java)
        viewmodel.movieList.observe(this, Observer {
//            Log.i("asdvfgnh", it[1].Title)
////            Log.i("asdvfgnh", it[1].title) -> serializable
//            it.forEach {
//                list.add(it)
//            }
//            for (i in it) {
//                adapter.setMoviesList(it)
//            }
            it.forEach {
                list.add(it)
            }
            adapter = MainAdapter(list)
            mainBinding.recy.adapter = adapter
//            adapter.setMoviesList(it)
        })
        viewmodel.errorMessage.observe(this, Observer {
            Log.i("Error", it)

        })
        viewmodel.getAllMovies()
    }
}
