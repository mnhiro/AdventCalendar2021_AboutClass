package com.example.adventcalendarsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.adventcalendarsample.BindingViewHolder
import com.example.adventcalendarsample.R
import com.example.adventcalendarsample.databinding.ListItemAnimeMovieBinding
import com.example.adventcalendarsample.databinding.ListItemIdolMovieBinding
import com.example.adventcalendarsample.databinding.ListItemGameMovieBinding
import com.example.adventcalendarsample.model.AnimeMovieImpl
import com.example.adventcalendarsample.model.GameMovieImpl
import com.example.adventcalendarsample.model.Movie
import com.example.adventcalendarsample.model.IdolMovieImpl
import com.example.adventcalendarsample.model.RockMovieImpl

class MovieListAdapter(
    private val lifecycleOwner: LifecycleOwner,
    initialItem: List<Movie> = emptyList()
) : RecyclerView.Adapter<BindingViewHolder>() {

    private var contents: MutableList<Movie> = initialItem.toMutableList()
        set(value) {
            updateListItem(value, field)
        }

    override fun getItemViewType(position: Int): Int {
        return when (contents[position]) {
            is AnimeMovieImpl -> R.layout.list_item_anime_movie
            is IdolMovieImpl -> R.layout.list_item_idol_movie
            is GameMovieImpl -> R.layout.list_item_game_movie
            is RockMovieImpl -> R.layout.list_item_rock_movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return BindingViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        when (val content = contents[position]) {
            is AnimeMovieImpl -> {
                (holder.binding as ListItemAnimeMovieBinding).textTitle.text = content.title
                holder.binding.textNumber.text = content.aNumber.toString()
            }
            is IdolMovieImpl -> {
                (holder.binding as ListItemIdolMovieBinding).textTitle.text = content.title
                holder.binding.textCompany.text = content.genreTitle
            }
            is GameMovieImpl -> {
                (holder.binding as ListItemGameMovieBinding).textTitle.text = content.title
                holder.binding.textResolution.text = "${content.resolution}p"
                holder.binding.textCompany.text = content.genreTitle
            }
            is RockMovieImpl -> {
                // Adapterから指定するものは特になし
            }
        }
        holder.binding.lifecycleOwner = lifecycleOwner
    }

    override fun getItemCount(): Int = contents.size

    private fun updateListItem(
        newContents: List<Movie>,
        contents: MutableList<Movie> = this.contents
    ) {
        contents.clear()
        contents.addAll(newContents)
    }
}
