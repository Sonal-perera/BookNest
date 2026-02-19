package com.booknest.personal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.booknest.personal.R
import com.booknest.personal.model.Template

class TemplateAdapter(private val templates: List<Template>, private val context: Context) :
    RecyclerView.Adapter<TemplateAdapter.TemplateVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemplateVH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.template_view, parent, false)
        return TemplateVH(view)
    }

    override fun onBindViewHolder(holder: TemplateVH, position: Int) {
        val template = templates[position]
        val animation = AnimationUtils.loadAnimation(context, R.anim.flash)

        holder.name.text = template.name
        holder.card.setOnClickListener {
            holder.card.startAnimation(animation)
        }

    }

    override fun getItemCount(): Int = templates.size

    class TemplateVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.textView155)
        val card = itemView
    }
}