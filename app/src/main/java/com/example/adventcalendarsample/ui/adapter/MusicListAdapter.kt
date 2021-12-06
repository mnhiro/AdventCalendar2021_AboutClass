package com.example.adventcalendarsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.adventcalendarsample.BindingViewHolder
import com.example.adventcalendarsample.R
import com.example.adventcalendarsample.databinding.ListItemAnimeMusicBinding
import com.example.adventcalendarsample.databinding.ListItemGameMusicBinding
import com.example.adventcalendarsample.databinding.ListItemIdolMusicBinding
import com.example.adventcalendarsample.databinding.ListItemRockMusicBinding
import com.example.adventcalendarsample.model.AnimeMusicImpl
import com.example.adventcalendarsample.model.GameMusicImpl
import com.example.adventcalendarsample.model.IdolMusicImpl
import com.example.adventcalendarsample.model.Music
import com.example.adventcalendarsample.model.RockMusicImpl

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
            is AnimeMusicImpl -> R.layout.list_item_anime_music
            is IdolMusicImpl -> R.layout.list_item_idol_music
            is GameMusicImpl -> R.layout.list_item_game_music
            is RockMusicImpl -> R.layout.list_item_rock_music
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return BindingViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        when (val content = contents[position]) {
            is AnimeMusicImpl -> {
                (holder.binding as ListItemAnimeMusicBinding).textTitle.text = content.title
                holder.binding.textArtist.text = content.aNumber.toString()
            }
            is IdolMusicImpl -> {
                (holder.binding as ListItemIdolMusicBinding).textTitle.text = content.title
                holder.binding.textGenre.text = content.genreTitle
            }
            is GameMusicImpl -> {
                (holder.binding as ListItemGameMusicBinding).textTitle.text = content.title
                holder.binding.textBitrate.text = "${content.bitrate}kbps"
                holder.binding.textGenre.text = content.genreTitle
            }
            is RockMusicImpl -> {
                (holder.binding as ListItemRockMusicBinding).textTitle.text = content.title
            }
        }
        holder.binding.lifecycleOwner = lifecycleOwner
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