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

class CartAdapter(private val cartItems: MutableList<Cart>, private val context: Context) :
    RecyclerView.Adapter<CartAdapter.CartVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartVH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_item_view, parent, false)
        return CartVH(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CartVH, position: Int) {
        val cartItem = cartItems[position]
        val addBtn = holder.addBtn
        val minusBtn = holder.minusBtn
        val removeBtn = holder.removeBtn
        val qty = holder.qty

        holder.bookName.text = cartItem.name
        holder.price.text = "$${cartItem.price}"
        holder.author.text = cartItem.author;
        holder.image.setImageResource(cartItem.image)

        addBtn.setOnClickListener {
            val num = qty.text
            var intNum = Integer.parseInt(num.toString())
            intNum += 1
            qty.text = intNum.toString()
        }
        minusBtn.setOnClickListener {
            if (!qty.text.equals("0")) {
                val num = qty.text
                var intNum = Integer.parseInt(num.toString())
                intNum -= 1
                qty.text = intNum.toString()
            }
        }
        removeBtn.setOnClickListener {
            cartItems.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
            Toast.makeText(context, "Item Removed", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int = cartItems.size

    class CartVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val qty: TextView = itemView.findViewById(R.id.textView55)
        val addBtn: TextView = itemView.findViewById(R.id.textView57)
        val minusBtn: TextView = itemView.findViewById(R.id.textView56)
        val price: TextView = itemView.findViewById(R.id.textView54)
        val bookName: TextView = itemView.findViewById(R.id.textView51)
        val author: TextView = itemView.findViewById(R.id.textView52)
        val image: ImageView = itemView.findViewById(R.id.imageView5)
        val removeBtn: TextView = itemView.findViewById(R.id.textView53)
    }
}