package com.example.adventcalendarsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adventcalendarsample.R
import com.example.adventcalendarsample.databinding.ActivityMainBinding
import com.example.adventcalendarsample.model.Image
import com.example.adventcalendarsample.model.Movie
import com.example.adventcalendarsample.model.Music
import com.example.adventcalendarsample.ui.adapter.HeaderAdapter
import com.example.adventcalendarsample.ui.adapter.ImageListAdapter
import com.example.adventcalendarsample.ui.adapter.MovieListAdapter
import com.example.adventcalendarsample.ui.adapter.MusicListAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        val sampleMusics = Music.createSample()
        val sampleMovies = Movie.createSample()
        val sampleImages = Image.createSample()

        val musicHeaderAdapter = HeaderAdapter(
            getString(R.string.music),
            this@MainActivity
        )

        val musicListAdapter = MusicListAdapter(
            this@MainActivity,
            sampleMusics
        )

        val movieHeaderAdapter = HeaderAdapter(
            getString(R.string.movie),
            this@MainActivity
        )

        val movieListAdapter = MovieListAdapter(
            this@MainActivity,
            sampleMovies
        )

        val imageHeaderAdapter = HeaderAdapter(
            getString(R.string.image),
            this@MainActivity
        )

        val imageListAdapter = ImageListAdapter(
            this@MainActivity,
            sampleImages
        )

        val concatAdapter = ConcatAdapter(
            musicHeaderAdapter,
            musicListAdapter,
            movieHeaderAdapter,
            movieListAdapter,
            imageHeaderAdapter,
            imageListAdapter
        )

        with(binding) {
            rvContents.adapter = concatAdapter
            rvContents.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}