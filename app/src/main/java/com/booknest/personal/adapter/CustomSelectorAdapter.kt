package com.booknest.community.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.model.Status

class CustomSelectorAdapter<T>(
    private val items: List<T>,
    private val context: Context,
    private val getDisplayText: (T) -> String
) : RecyclerView.Adapter<CustomSelectorAdapter.CustomSelectorVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomSelectorVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_selector_button, parent, false)
        return CustomSelectorVH(view)
    }

    override fun onBindViewHolder(holder: CustomSelectorVH, position: Int) {
        val item = items[position]
        holder.customBtn.text = getDisplayText(item)

        if (position == 0) {
            holder.customBtn.setBackgroundColor(context.getColor(R.color.primary))
            holder.customBtn.setTextColor(context.getColor(R.color.white))
        } else {
            holder.customBtn.setBackgroundColor(context.getColor(R.color.icon_grey))
            holder.customBtn.setTextColor(context.getColor(R.color.black))
        }
    }

    override fun getItemCount(): Int = items.size

    class CustomSelectorVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val customBtn: Button = itemView.findViewById(R.id.button11)
    }
}
