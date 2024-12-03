package com.jordan.octocourse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageBack = findViewById<ImageView>(R.id.imageBack)
        imageBack.setOnClickListener {
            val intent = Intent(this@RegisterPage, WelcomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        val btnNew = findViewById<Button>(R.id.btnsignup)
        btnNew.setOnClickListener {
            val intent = Intent(this@RegisterPage, ChooseClass::class.java)
            startActivity(intent)
            finish()
        }

        val btnHave = findViewById<Button>(R.id.btnHaveACC)
        btnHave.setOnClickListener {
            val intent = Intent(this@RegisterPage, LoginPage::class.java)
            startActivity(intent)
            finish()
        }
    }
}