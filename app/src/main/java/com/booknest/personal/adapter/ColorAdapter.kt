package com.booknest.community.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.model.Colors
import com.google.android.material.card.MaterialCardView

class ColorAdapter(private val colors: List<Colors>, private val context: Context) :
    RecyclerView.Adapter<ColorAdapter.ColorVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorVH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.color_palette_view, parent, false)
        return ColorVH(view)
    }

    override fun onBindViewHolder(holder: ColorVH, position: Int) {
        val color = colors[position]
        val animation = AnimationUtils.loadAnimation(context, R.anim.flash)

        holder.colorCard.setCardBackgroundColor(Color.parseColor(color.hexCode))
        holder.card.setOnClickListener {
            holder.card.startAnimation(animation)
        }

    }

    override fun getItemCount(): Int = colors.size

    class ColorVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorCard: MaterialCardView = itemView.findViewById(R.id.cardViewCircular)
        val card = itemView
    }
}