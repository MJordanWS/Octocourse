package com.jordan.octocourse

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_setting)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backHome = findViewById<ImageView>(R.id.goBack)
        backHome.setOnClickListener {
            val intent = Intent(this@Setting, Home::class.java)
            startActivity(intent)
            finish()
        }

        val goQuiz = findViewById<ImageView>(R.id.imageQuiz)
        goQuiz.setOnClickListener {
            val intent = Intent(this@Setting, Quiz::class.java)
            startActivity(intent)
            finish()
        }

        val course = findViewById<ImageView>(R.id.buttonCourse)
        course.setOnClickListener {
            val intent = Intent(this@Setting, MenuCourse::class.java)
            startActivity(intent)
            finish()
        }

        val btnBack = findViewById<ImageView>(R.id.buttonHome)
        btnBack.setOnClickListener {
            val intent = Intent(this@Setting, Home::class.java)
            startActivity(intent)
            finish()
        }
    }
}