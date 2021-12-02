package com.example.adventcalendarsample

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BindingViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val binding: ViewDataBinding = DataBindingUtil.bind(v)!!
}