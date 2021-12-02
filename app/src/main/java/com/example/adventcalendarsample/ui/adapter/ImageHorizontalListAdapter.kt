package com.example.adventcalendarsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.adventcalendarsample.BindingViewHolder
import com.example.adventcalendarsample.R
import com.example.adventcalendarsample.databinding.ListItemImageBinding
import com.example.adventcalendarsample.model.BusinessService
import com.example.adventcalendarsample.model.DWeekImageImpl
import com.example.adventcalendarsample.model.Image
import com.example.adventcalendarsample.model.MerketImageImpl
import com.example.adventcalendarsample.model.PraypassImageImpl
import com.example.adventcalendarsample.model.TrachokuImageImpl

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
            is DWeekImageImpl,
            is PraypassImageImpl,
            is MerketImageImpl,
            is TrachokuImageImpl -> R.layout.list_item_image
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return BindingViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        (holder.binding as ListItemImageBinding).textTitle.text = contents[position].title
        holder.binding.textCompany.text = (contents[position] as BusinessService).serviceCompany
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