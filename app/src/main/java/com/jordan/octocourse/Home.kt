package com.jordan.octocourse

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnIndonesia = findViewById<ImageView>(R.id.btnIndonesia)
        btnIndonesia.setOnClickListener {
            val intent = Intent(this@Home, Course::class.java)
            startActivity(intent)
            finish()
        }

        val btnCourse = findViewById<ImageView>(R.id.btnCourse)
        btnCourse.setOnClickListener {
            val intent = Intent(this@Home, MenuCourse::class.java)
            startActivity(intent)
            finish()
        }

        val btnQuiz = findViewById<ImageView>(R.id.btnQuiz)
        btnQuiz.setOnClickListener {
            val intent = Intent(this@Home, Quiz::class.java)
            startActivity(intent)
            finish()
        }

        val btnDownload = findViewById<ImageView>(R.id.btnDownload)
        btnDownload.setOnClickListener {
            val intent = Intent(this@Home, ViewDownload::class.java)
            startActivity(intent)
            finish()
        }

        val btnReport = findViewById<ImageView>(R.id.btnReport)
        btnReport.setOnClickListener {
            val intent = Intent(this@Home, ViewReport::class.java)
            startActivity(intent)
            finish()
        }

        val btnStudy = findViewById<ImageView>(R.id.btnStudy)
        btnStudy.setOnClickListener {
            val intent = Intent(this@Home, ViewSchedule::class.java)
            startActivity(intent)
            finish()
        }

        val imgQuiz = findViewById<ImageView>(R.id.imgQuiz)
        imgQuiz.setOnClickListener {
            val intent = Intent(this@Home, Quiz::class.java)
            startActivity(intent)
            finish()
        }

        val setting = findViewById<ImageView>(R.id.btnSetting)
        setting.setOnClickListener {
            val intent = Intent(this@Home, Setting::class.java)
            startActivity(intent)
            finish()
        }
    }
}