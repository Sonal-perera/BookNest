package com.booknest.personal.activity

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.booknest.community.R
import com.booknest.personal.fragment.ExploreFragment
import com.booknest.personal.fragment.HomeFragment
import com.booknest.personal.fragment.MyBooksFragment
import com.booknest.personal.fragment.OrderFragment
import com.booknest.personal.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bottom: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val drawer: DrawerLayout = findViewById(R.id.drawerLayout)
        val navigationView: NavigationView = findViewById(R.id.navigationView1)
        val fragmentId = R.id.fragmentContainerView

        val colorStateList = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_checked)
            ),
            intArrayOf(
                getColor(R.color.primary),
                getColor(R.color.light_grey)
            )
        )

        bottom.itemTextColor = colorStateList;
        bottom.itemIconTintList = colorStateList;

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(fragmentId, HomeFragment())
                .commit()
        }
        bottom.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_explore -> ExploreFragment()
                R.id.nav_orders -> OrderFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> null
            }

            fragment?.let {
                supportFragmentManager.beginTransaction().replace(fragmentId, it).commit()
                true
            } ?: false
        }
        navigationView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.nav_checkout) {
                val intent = Intent(this, CheckoutActivity::class.java)
                startActivity(intent)
            } else if (it.itemId == R.id.menu_home) {
                supportFragmentManager.beginTransaction().replace(fragmentId, HomeFragment())
                    .commit()
            } else if (it.itemId == R.id.menu_explore) {
                supportFragmentManager.beginTransaction().replace(fragmentId, ExploreFragment())
                    .commit()
            } else if (it.itemId == R.id.menu_orders) {
                supportFragmentManager.beginTransaction().replace(fragmentId, OrderFragment())
                    .commit()
            } else if (it.itemId == R.id.menu_profile) {
                supportFragmentManager.beginTransaction().replace(fragmentId, ProfileFragment())
                    .commit()
            } else if (it.itemId == R.id.menu_books) {
                supportFragmentManager.beginTransaction().replace(fragmentId, MyBooksFragment())
                    .commit()
            } else if (it.itemId == R.id.menu_log_out) {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }
            drawer.close()
            true
        }

    }


}