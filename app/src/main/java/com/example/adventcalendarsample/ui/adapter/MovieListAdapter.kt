package com.example.adventcalendarsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.adventcalendarsample.BindingViewHolder
import com.example.adventcalendarsample.R
import com.example.adventcalendarsample.databinding.ListItemDWeekMovieBinding
import com.example.adventcalendarsample.databinding.ListItemMerketMovieBinding
import com.example.adventcalendarsample.databinding.ListItemPraypassMovieBinding
import com.example.adventcalendarsample.model.DWeekMovieImpl
import com.example.adventcalendarsample.model.MerketMovieImpl
import com.example.adventcalendarsample.model.Movie
import com.example.adventcalendarsample.model.PraypassMovieImpl
import com.example.adventcalendarsample.model.TrachokuMovieImpl

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
            is DWeekMovieImpl -> R.layout.list_item_d_week_movie
            is PraypassMovieImpl -> R.layout.list_item_praypass_movie
            is MerketMovieImpl -> R.layout.list_item_merket_movie
            is TrachokuMovieImpl -> R.layout.list_item_trachoku_movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return BindingViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        when (val content = contents[position]) {
            is DWeekMovieImpl -> {
                (holder.binding as ListItemDWeekMovieBinding).textTitle.text = content.title
                holder.binding.textNumber.text = content.dNumber.toString()
            }
            is PraypassMovieImpl -> {
                (holder.binding as ListItemPraypassMovieBinding).textTitle.text = content.title
                holder.binding.textCompany.text = content.serviceCompany
            }
            is MerketMovieImpl -> {
                (holder.binding as ListItemMerketMovieBinding).textTitle.text = content.title
                holder.binding.textResolution.text = "${content.resolution}p"
                holder.binding.textCompany.text = content.serviceCompany
            }
            is TrachokuMovieImpl -> {
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
