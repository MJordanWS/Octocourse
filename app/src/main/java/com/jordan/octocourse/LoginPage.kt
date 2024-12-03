package com.jordan.octocourse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnContinue = findViewById<Button>(R.id.btnSignin)
        btnContinue.setOnClickListener {
            val intent = Intent(this@LoginPage, ChooseClass::class.java)
            startActivity(intent)
            finish()
        }

        val btnNew = findViewById<Button>(R.id.btnNewAcc)
        btnNew.setOnClickListener {
            val intent = Intent(this@LoginPage, RegisterPage::class.java)
            startActivity(intent)
            finish()
        }

        val imgBack = findViewById<ImageView>(R.id.imgBack)
        imgBack.setOnClickListener {
            val intent = Intent(this@LoginPage, WelcomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}