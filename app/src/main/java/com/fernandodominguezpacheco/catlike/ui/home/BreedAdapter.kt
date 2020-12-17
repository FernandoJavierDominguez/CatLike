package com.fernandodominguezpacheco.catlike.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.fernandodominguezpacheco.catlike.R
import com.fernandodominguezpacheco.catlike.databinding.RowBreedBinding
import com.fernandodominguezpacheco.domain.Breed
import com.fernandodominguezpacheco.miningmarket.loadUrl
import kotlin.properties.Delegates

class BreedAdapter(
    private val listener: (Breed) -> Unit
) : RecyclerView.Adapter<BreedAdapter.ViewHolder>() {

    var items: List<Breed> by Delegates.observable(mutableListOf()) { _, _, _ -> notifyDataSetChanged() }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_breed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            listener(item)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = RowBreedBinding.bind(view)

        fun bind(breedItem: Breed){

            with(binding){
                if(breedItem.url != "") url.loadUrl(breedItem.url)
                name.text = breedItem.name
                if(breedItem.like) likeResult.setImageResource(R.drawable.ic_favorite) else likeResult.setImageResource(R.drawable.ic_favorite_border)
            }
        }

    }

}