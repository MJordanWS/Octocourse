package com.jordan.octocourse

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnHome = findViewById<ImageView>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent = Intent(this@Quiz, Home::class.java)
            startActivity(intent)
            finish()
        }

        val btnCourse = findViewById<ImageView>(R.id.btnCourse)
        btnCourse.setOnClickListener {
            val intent = Intent(this@Quiz, MenuCourse::class.java)
            startActivity(intent)
            finish()
        }

        val setting = findViewById<ImageView>(R.id.buttonSetting)
        setting.setOnClickListener {
            val intent = Intent(this@Quiz, Setting::class.java)
            startActivity(intent)
            finish()
        }
    }
}