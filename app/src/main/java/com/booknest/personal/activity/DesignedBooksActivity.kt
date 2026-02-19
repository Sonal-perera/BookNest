package com.booknest.community.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.adapter.ColorAdapter
import com.booknest.community.adapter.FeaturedBooksAdapter
import com.booknest.community.adapter.TemplateAdapter
import com.booknest.community.model.Books
import com.booknest.community.model.Colors
import com.booknest.community.model.Template
import com.google.android.material.appbar.MaterialToolbar

class DesignedBooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_designed_books)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbar = findViewById<MaterialToolbar>(R.id.materialToolbar7)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView11)
        val recyclerView1 = findViewById<RecyclerView>(R.id.recyclerView12)
        val previewBtn = findViewById<Button>(R.id.button7)
        val saveBtn = findViewById<Button>(R.id.button8)

        val colorPalette: MutableList<Colors> = mutableListOf()

        colorPalette.add(Colors("#3B82F6"))
        colorPalette.add(Colors("#EF4444"))
        colorPalette.add(Colors("#10B981"))
        colorPalette.add(Colors("#8B5CF6"))
        colorPalette.add(Colors("#F59E0B"))
        val colorAdapter = ColorAdapter(colorPalette, this)

        val manager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = manager
        recyclerView.adapter = colorAdapter

        val templates: MutableList<Template> = mutableListOf()

        templates.add(Template("Template 1"))
        templates.add(Template("Template 2"))
        val templateAdapter = TemplateAdapter(templates, this)

        val manager2 = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView1.layoutManager = manager2
        recyclerView1.adapter = templateAdapter

        toolbar.setNavigationOnClickListener {
            finish()
        }
        toolbar.setTitle("Design My Book")
        toolbar.isTitleCentered = true

        previewBtn.setOnClickListener {
            val intent = Intent(this, NewBookActivity::class.java)
            intent.putExtra("name", "The Art of Design")
            intent.putExtra("author", "John Smith")
            intent.putExtra("price", 29.99)
            intent.putExtra("image", R.drawable.book_8)
            startActivity(intent)
        }

        saveBtn.setOnClickListener {
            finish()
        }

    }

}