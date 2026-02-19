package com.booknest.community.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.model.Books
import com.booknest.community.model.Cart
import com.booknest.community.model.Order

class OrderSummaryAdapter(private val orders: List<Cart>, private val context: Context) :
    RecyclerView.Adapter<OrderSummaryAdapter.OrderSummaryVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderSummaryVH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.order_summary_view, parent, false)
        return OrderSummaryVH(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: OrderSummaryVH, position: Int) {
        val order = orders[position]

        holder.bookName.text = order.name
        holder.price.text = "$${order.price}"
        holder.author.text = order.author;
        holder.image.setImageResource(order.image)
        holder.qty.text = order.qty.toString()
    }

    override fun getItemCount(): Int = orders.size

    class OrderSummaryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val price: TextView = itemView.findViewById(R.id.textView67)
        val bookName: TextView = itemView.findViewById(R.id.textView65)
        val author: TextView = itemView.findViewById(R.id.textView66)
        val image: ImageView = itemView.findViewById(R.id.imageView7)
        val qty: TextView = itemView.findViewById(R.id.textView69)
    }
}