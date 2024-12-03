package com.jordan.octocourse

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Course : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_course)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnHome = findViewById<ImageView>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent = Intent(this@Course, Home::class.java)
            startActivity(intent)
            finish()
        }

        val imgCourse = findViewById<ImageView>(R.id.imgCourse)
        imgCourse.setOnClickListener {
            val intent = Intent(this@Course, MenuCourse::class.java)
            startActivity(intent)
            finish()
        }

        val buttonQuiz = findViewById<ImageView>(R.id.buttonQuiz)
        buttonQuiz.setOnClickListener {
            val intent = Intent(this@Course, Quiz::class.java)
            startActivity(intent)
            finish()
        }

        val setting = findViewById<ImageView>(R.id.imgSetting)
        setting.setOnClickListener {
            val intent = Intent(this@Course, Setting::class.java)
            startActivity(intent)
            finish()
        }

        val eksposisi = findViewById<ImageView>(R.id.btnEksposisi)
        eksposisi.setOnClickListener {
            val intent = Intent(this@Course, TeksEksposisi::class.java)
            startActivity(intent)
            finish()
        }
    }
}