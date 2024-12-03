package com.jordan.octocourse

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuCourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_course)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnIndo = findViewById<ImageView>(R.id.imgIndonesia)
        btnIndo.setOnClickListener {
            val intent = Intent(this@MenuCourse, Course::class.java)
            startActivity(intent)
            finish()
        }

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@MenuCourse, Home::class.java)
            startActivity(intent)
            finish()
        }

        val btnHome = findViewById<ImageView>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent = Intent(this@MenuCourse, Home::class.java)
            startActivity(intent)
            finish()
        }

        val btnQuiz = findViewById<ImageView>(R.id.Quiz)
        btnQuiz.setOnClickListener {
            val intent = Intent(this@MenuCourse, Quiz::class.java)
            startActivity(intent)
            finish()
        }

        val setting = findViewById<ImageView>(R.id.btnSetting)
        setting.setOnClickListener {
            val intent = Intent(this@MenuCourse, Setting::class.java)
            startActivity(intent)
            finish()
        }
    }
}