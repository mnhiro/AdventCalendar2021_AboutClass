package com.example.adventcalendarsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.adventcalendarsample.BindingViewHolder
import com.example.adventcalendarsample.R
import com.example.adventcalendarsample.databinding.ListItemAnimeImageBinding
import com.example.adventcalendarsample.databinding.ListItemGameImageBinding
import com.example.adventcalendarsample.databinding.ListItemIdolImageBinding
import com.example.adventcalendarsample.databinding.ListItemRockImageBinding
import com.example.adventcalendarsample.model.AnimeImageImpl
import com.example.adventcalendarsample.model.Image
import com.example.adventcalendarsample.model.GameImageImpl
import com.example.adventcalendarsample.model.IdolImageImpl
import com.example.adventcalendarsample.model.RockImageImpl

class ImageHorizontalListAdapter(
    private val lifecycleOwner: LifecycleOwner,
    initialItem: List<Image> = emptyList()
) : RecyclerView.Adapter<BindingViewHolder>() {

    private var contents: MutableList<Image> = initialItem.toMutableList()
        set(value) {
            updateListItem(value, field)
        }

    override fun getItemViewType(position: Int): Int {
        return when (contents[position]) {
            // 今回は1つ、動画同様サービスごとに分けれる
            is AnimeImageImpl -> R.layout.list_item_anime_image
            is IdolImageImpl -> R.layout.list_item_idol_image
            is GameImageImpl -> R.layout.list_item_game_image
            is RockImageImpl -> R.layout.list_item_rock_image
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return BindingViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        when (val content = contents[position]) {
            is AnimeImageImpl -> {
                (holder.binding as ListItemAnimeImageBinding).textTitle.text = content.title
                holder.binding.textGenre.text = content.genreTitle
            }
            is IdolImageImpl -> {
                (holder.binding as ListItemIdolImageBinding).textTitle.text = content.title
                holder.binding.textGenre.text = content.genreTitle
            }
            is GameImageImpl -> {
                (holder.binding as ListItemGameImageBinding).textTitle.text = content.title
                holder.binding.textGenre.text = content.genreTitle
            }
            is RockImageImpl -> {
                (holder.binding as ListItemRockImageBinding).textTitle.text = content.title
                holder.binding.textGenre.text = content.genreTitle
            }
        }
        holder.binding.lifecycleOwner = lifecycleOwner
    }

    override fun getItemCount(): Int = contents.size

    fun updateListItem(
        newContents: List<Image>,
        contents: MutableList<Image> = this.contents
    ) {
        contents.clear()
        contents.addAll(newContents)
    }
}