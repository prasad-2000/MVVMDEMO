package com.example.mvvmdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmdemo.Retrofit.Movie
import com.example.mvvmdemo.databinding.ItemBinding

class MainAdapter(var list: List<Movie>) : RecyclerView.Adapter<MainAdapter.VH>() {
    class VH(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: Movie) {
//            binding.titleTv.text = item.Title
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        var binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

//        holder.bind(list[position])
//        holder.bind(position, list)
        val movie = list[position]
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${movie.Title}", Toast.LENGTH_SHORT).show()
        }
//        holder.itemView.isClickable = false
        holder.binding.titleTv.text = movie.Title
        Glide.with(holder.itemView.context)
            .load(movie.Poster)
            .into(holder.binding.Iv)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}