package com.example.secondlabmobdev4sem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CharacterAdapter(private val context: Context,
                       private val list: MutableList<Character>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ImageViewHolder(item: View): RecyclerView.ViewHolder(item) {
        fun bind(item: String) {
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)
            Picasso.get().load(item).into(imageView)
        }
    }
    class NameViewHolder(item: View): RecyclerView.ViewHolder(item) {
        fun bind(item: String) {
            val textView = itemView.findViewById<TextView>(R.id.nameTextView)
            textView.text = item
        }
    }
    class SpeciesViewHolder(item: View): RecyclerView.ViewHolder(item) {
        fun bind(item: String) {
            val textView = itemView.findViewById<TextView>(R.id.speciesTextView)
            textView.text = item
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if(viewType == R.layout.image_item) return ImageViewHolder(inflater.inflate(viewType, parent, false))
        if(viewType == R.layout.name_item) return NameViewHolder(inflater.inflate(viewType, parent, false))
        return SpeciesViewHolder(inflater.inflate(viewType, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        if(list[position].getType() == "image") return R.layout.image_item
        if(list[position].getType() == "name") return R.layout.name_item
        return R.layout.species_item
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ImageViewHolder) holder.bind(list[position].image)
        if(holder is NameViewHolder) holder.bind(list[position].name)
        if(holder is SpeciesViewHolder) holder.bind(list[position].species)
    }
}