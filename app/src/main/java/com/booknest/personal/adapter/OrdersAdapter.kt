package com.booknest.personal.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.booknest.personal.R
import com.booknest.personal.model.Order

class OrdersAdapter(private val orders: List<Order>, private val context: Context) :
    RecyclerView.Adapter<OrdersAdapter.OrdersVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersVH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.order_item_view, parent, false)
        return OrdersVH(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: OrdersVH, position: Int) {
        val order = orders[position]
        val colorMap = HashMap<String, Int>()
        val button = holder.statusBtn
        val returns: String

        holder.orderIdTextView.text = order.orderId;
        holder.dateTextView.text = order.date.toString();
        holder.bookName.text = order.name
        holder.price.text = "$${order.price}"
        holder.author.text = order.author;
        holder.image.setImageResource(order.image)
        button.text = order.status

        if (order.status == "Delivered") {
            colorMap["textColor"] = context.getColor(R.color.red)
            colorMap["backColor"] = context.getColor(R.color.icon_grey)
            holder.returns.text = "Buy Again"

        } else if (order.status == "Processing") {
            colorMap["textColor"] = context.getColor(R.color.orange_red)
            colorMap["backColor"] = context.getColor(R.color.orange_yellow)
            holder.returns.text = "Track Order"

        } else if (order.status == "Cancelled") {
            colorMap["textColor"] = context.getColor(R.color.text_color1)
            colorMap["backColor"] = context.getColor(R.color.light_grey)
            holder.returns.text = "Order Again"

        }
        colorMap["backColor"]?.let { button.setBackgroundColor(it) }
        colorMap["textColor"]?.let { button.setTextColor(it) }


    }

    override fun getItemCount(): Int = orders.size

    class OrdersVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderIdTextView: TextView = itemView.findViewById(R.id.textView30)
        val dateTextView: TextView = itemView.findViewById(R.id.textView31)
        val price: TextView = itemView.findViewById(R.id.textView34)
        val bookName: TextView = itemView.findViewById(R.id.textView32)
        val author: TextView = itemView.findViewById(R.id.textView33)
        val image: ImageView = itemView.findViewById(R.id.imageView4)
        val returns: TextView = itemView.findViewById(R.id.textView35)
        val statusBtn: TextView = itemView.findViewById(R.id.button10)
    }
}