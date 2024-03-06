package com.example.simpleandroidapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simpleandroidapp.databinding.ItemRowMovieBinding

class ListMovieAdapter(private val listMovie: ArrayList<Movies>): RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemRowMovieBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,photo,rating) = listMovie[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgMoviePhoto)
        holder.binding.tvMovieName.text = name
        holder.binding.tvMovieRating.text = rating

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_movies", listMovie[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}