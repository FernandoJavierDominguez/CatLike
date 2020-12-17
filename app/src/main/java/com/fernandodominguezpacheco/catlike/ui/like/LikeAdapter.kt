package com.fernandodominguezpacheco.catlike.ui.like

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fernandodominguezpacheco.catlike.R
import com.fernandodominguezpacheco.catlike.databinding.RowLikeBinding
import com.fernandodominguezpacheco.domain.Like
import kotlin.properties.Delegates

class LikeAdapter(
    private val listener: (Like) -> Unit
) : RecyclerView.Adapter<LikeAdapter.ViewHolder>() {

    var items: List<Like> by Delegates.observable(mutableListOf()) { _, _, _ -> notifyDataSetChanged() }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_like, parent, false)
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

        private val binding = RowLikeBinding.bind(view)

        fun bind(likeItem: Like){

            with(binding){
                id.text = likeItem.id.toString()
                breedId.text = likeItem.breedId
                date.text = likeItem.date.toString()
            }
        }

    }

}