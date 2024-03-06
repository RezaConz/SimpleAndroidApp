package com.example.simpleandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Movies>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()
        supportActionBar?.title = "Top Movies"
    }

    private fun showRecyclerList() {
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListMovieAdapter(list)
        binding.rvMovies.adapter = listHeroAdapter
    }

    private fun getListMovies(): ArrayList<Movies> {
        val movieName = resources.getStringArray(R.array.movie_name)
        val moviePhoto = resources.getStringArray(R.array.movie_photo)
        val movieRating = resources.getStringArray(R.array.movie_rating)
        val movieDesk = resources.getStringArray(R.array.movie_description)
        val movieGenre = resources.getStringArray(R.array.movie_gendre)
        val listMovie = ArrayList<Movies>()

        for (i in movieName.indices){
            val hero = Movies(movieName[i],moviePhoto[i],movieRating[i],movieDesk[i], movieGenre[i])
            listMovie.add(hero)
        }
        return listMovie
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.button_about,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page->{
                val intent = Intent(this,AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return false
    }
}