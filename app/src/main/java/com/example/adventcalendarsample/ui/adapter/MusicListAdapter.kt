package com.example.adventcalendarsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.adventcalendarsample.BindingViewHolder
import com.example.adventcalendarsample.R
import com.example.adventcalendarsample.databinding.ListItemMusicBinding
import com.example.adventcalendarsample.model.DWeekMusicImpl
import com.example.adventcalendarsample.model.MerketMusicImpl
import com.example.adventcalendarsample.model.Music
import com.example.adventcalendarsample.model.PraypassMusicImpl
import com.example.adventcalendarsample.model.TrachokuMusicImpl

class MusicListAdapter(
    private val lifecycleOwner: LifecycleOwner,
    initialItem: List<Music> = emptyList()
) : RecyclerView.Adapter<BindingViewHolder>() {

    private var contents: MutableList<Music> = initialItem.toMutableList()
        set(value) {
            updateListItem(value, field)
        }

    override fun getItemViewType(position: Int): Int {
        return when (contents[position]) {
            is DWeekMusicImpl,
            is PraypassMusicImpl,
            is MerketMusicImpl,
            is TrachokuMusicImpl -> R.layout.list_item_music
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return BindingViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.binding.lifecycleOwner = lifecycleOwner
        (holder.binding as ListItemMusicBinding).textTitle.text = contents[position].title
        holder.binding.textArtist.text = contents[position].artist
    }

    override fun getItemCount(): Int = contents.size

    private fun updateListItem(
        newContents: List<Music>,
        contents: MutableList<Music> = this.contents
    ) {
        contents.clear()
        contents.addAll(newContents)
    }
}