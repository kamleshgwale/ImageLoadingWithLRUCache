package com.example.imageloadingwithlrucache

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.bumptech.glide.Glide
import com.example.imageloadingwithlrucache.imageloader.ImageLoader

class ImageAdapter(private val items: ArrayList<String>, private val context: Context,private val check:String?) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(check.equals("LRUAdapter"))
        {
            ImageLoader.with(context).load(holder.imageView, items[position])
        }else if(check.equals("Glide"))
        {
            Glide.with(context)
                .load(items[position])
                .onlyRetrieveFromCache( true )
                .into(holder.imageView)
        }else if(check.equals("Coil"))
        {
            holder.imageView.load(items[position])
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageView = view.findViewById(R.id.item_imageView) as ImageView
}
