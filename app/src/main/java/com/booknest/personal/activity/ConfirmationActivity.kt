package com.booknest.community.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.adapter.FeaturedBooksAdapter
import com.booknest.community.adapter.PaymentOrderAdapter
import com.booknest.community.model.Books
import com.booknest.community.model.Cart
import com.booknest.community.model.Order

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView7)
        val orderDetailsButton = findViewById<Button>(R.id.button16)
        val fragmentId = R.id.fragmentContainerView

        val orders: MutableList<Cart> = mutableListOf()

        orders.add(Cart("753743", "The Great Gatsby", "F. Scott Fitzgerald", R.drawable.book_7, 30.0, 2))
        orders.add(
            Cart(
                "7325432",
                "Rich dad poor dad",
                "Emma Roberts",
                R.drawable.book_5,
                25.99,
                2
            )
        )
        val paymentOrderAdapter = PaymentOrderAdapter(orders, this)

        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = manager
        recyclerView.adapter = paymentOrderAdapter

        orderDetailsButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}