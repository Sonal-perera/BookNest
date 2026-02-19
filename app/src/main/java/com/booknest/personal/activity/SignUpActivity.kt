package com.booknest.community.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.booknest.community.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signInTextView: TextView = findViewById(R.id.textView20)
        val createAccountBtn: Button = findViewById(R.id.button5)
        signInTextView.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
        createAccountBtn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}