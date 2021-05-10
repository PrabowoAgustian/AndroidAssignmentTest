package com.assignmenttestandroid.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.assignmenttestandroid.R
import com.assignmenttestandroid.model.ListPhotos
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_list.view.*

class ListPhotosAdapter: RecyclerView.Adapter<ListPhotosAdapter.ListPhotosHolder>() {

    private val differCallBack = object : DiffUtil.ItemCallback<ListPhotos>() {

        override fun areItemsTheSame(oldItem: ListPhotos, newItem: ListPhotos) =
            oldItem.albumId == newItem.albumId

        override fun areContentsTheSame(oldItem: ListPhotos, newItem: ListPhotos) = oldItem == newItem

    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListPhotosHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_list,
                parent,
                false
            )
        )

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: ListPhotosHolder, position: Int) {
        val listPhotos = differ.currentList[position]
        holder.itemView.apply {
            listPhotos?.let {
                iv_list.load(it.url)
                tv_title.text = it.title
            }
        }
    }

    class ListPhotosHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}