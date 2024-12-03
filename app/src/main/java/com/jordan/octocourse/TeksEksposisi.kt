package com.jordan.octocourse

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TeksEksposisi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_teks_eksposisi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gobtnBack = findViewById<ImageView>(R.id.Backbutton)
        gobtnBack.setOnClickListener {
            val intent = Intent(this@TeksEksposisi, Course::class.java)
            startActivity(intent)
            finish()
        }

        val goHome = findViewById<ImageView>(R.id.Homebutton)
        goHome.setOnClickListener {
            val intent = Intent(this@TeksEksposisi, Home::class.java)
            startActivity(intent)
            finish()
        }

        val goBelajar = findViewById<ImageView>(R.id.Coursebutton)
        goBelajar.setOnClickListener {
            val intent = Intent(this@TeksEksposisi, Course::class.java)
            startActivity(intent)
            finish()
        }

        val goQuiz = findViewById<ImageView>(R.id.Quizbutton)
        goQuiz.setOnClickListener {
            val intent = Intent(this@TeksEksposisi, Quiz::class.java)
            startActivity(intent)
            finish()
        }

        val gosetting = findViewById<ImageView>(R.id.butSetting)
        gosetting.setOnClickListener {
            val intent = Intent(this@TeksEksposisi, Setting::class.java)
            startActivity(intent)
            finish()
        }
    }
}