package com.booknest.personal.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.booknest.community.R
import com.google.android.material.appbar.MaterialToolbar

class NewBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_book)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.materialToolbar6)
        val publishBtn = findViewById<Button>(R.id.button17)
        val titleEditText = findViewById<EditText>(R.id.editTextText)
        val authorEditText = findViewById<EditText>(R.id.editTextText2)
        val priceEditText = findViewById<EditText>(R.id.editTextText6)
        val openCamera = findViewById<TextView>(R.id.textView142)
        val imageView = findViewById<ImageView>(R.id.imageView13)
        val layout = findViewById<ConstraintLayout>(R.id.constraintLayout15)
        val intent = intent
        val name = intent.getStringExtra("name")
        val author = intent.getStringExtra("author")
        val price = intent.getDoubleExtra("price", 0.0)
        val image = intent.getIntExtra("image", 0)

        if (name != null) {
            toolbar.setTitle("Preview Book")
            titleEditText.setText(name)
            authorEditText.setText(author)
            priceEditText.setText("$${price}")
            imageView.setImageResource(image)
            layout.visibility = ConstraintLayout.VISIBLE
            openCamera.visibility = ConstraintLayout.GONE
        } else {
            toolbar.setTitle("Add New Book")
        }

        toolbar.isTitleCentered = true

        toolbar.setNavigationOnClickListener {
            finish()
        }
        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.nav_save) {
                finish()
            }
            true
        }
        publishBtn.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            finish()
        }

        openCamera.setOnClickListener {
            val openGalleryIntent = Intent(this, DesignedBooksActivity::class.java)
            startActivity(openGalleryIntent)
        }

    }
}