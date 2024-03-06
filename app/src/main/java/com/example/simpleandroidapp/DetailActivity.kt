package com.example.simpleandroidapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.simpleandroidapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object{
        private var KEY_MOVIES = "key_movies"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataMovie = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_MOVIES, Movies::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_MOVIES)
        }

        Glide.with(this)
            .load(dataMovie?.photo)
            .into(binding.imageView2)
        binding.tvMoviename.text = dataMovie?.name
        binding.tvRatingDetail.text = dataMovie?.rating
        binding.tvSinopsisMovie.text = dataMovie?.description
        binding.tvListgendre.text = dataMovie?.genre


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Top Movies"

        binding.actionShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, binding.tvMoviename.text)
            shareIntent.putExtra(Intent.EXTRA_TEXT, binding.tvSinopsisMovie.text)
            startActivity(Intent.createChooser(shareIntent, "Share using :"))
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}