package com.rinal.submission1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rinal.submission1.LeagueListUI.Companion.img_league
import com.rinal.submission1.LeagueListUI.Companion.name_league
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.startActivity

class ItemAdapter(private val items: List<Item>, private val listener : (Item) -> Unit)
    : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LeagueListUI().createView(AnkoContext.Companion.create(parent.context,parent)))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        val name = itemView.findViewById<TextView>(name_league)
        val image = itemView.findViewById<ImageView>(img_league)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            name.text = items.name
            items.image?.let { Picasso.get().load(it).fit().into(image) }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}