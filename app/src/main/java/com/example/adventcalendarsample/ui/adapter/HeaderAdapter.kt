package com.example.adventcalendarsample.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.adventcalendarsample.BindingViewHolder
import com.example.adventcalendarsample.R
import com.example.adventcalendarsample.databinding.HeaderImageBinding
import com.example.adventcalendarsample.databinding.HeaderMovieBinding
import com.example.adventcalendarsample.databinding.HeaderMusicBinding
import java.lang.Exception

class HeaderAdapter(
    private val headerTitle: String,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<BindingViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (headerTitle) {
            "楽曲" -> R.layout.header_music
            "動画" -> R.layout.header_movie
            "画像" -> R.layout.header_image
            else -> throw Exception("そのヘッダーはありません")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return BindingViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        when (headerTitle) {
            "楽曲" -> (holder.binding as HeaderMusicBinding).textHeader.text = "楽曲"
            "動画" -> (holder.binding as HeaderMovieBinding).textHeader.text = "動画"
            "画像" -> (holder.binding as HeaderImageBinding).textHeader.text = "画像"
            else -> throw Exception("そのヘッダーはありません")
        }
        holder.binding.lifecycleOwner = lifecycleOwner
    }

    override fun getItemCount(): Int = 1
}