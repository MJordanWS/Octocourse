package com.jordan.octocourse

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class RegisterPage : AppCompatActivity() {
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editPasswordConf: EditText
    lateinit var btnRegister: Button
    lateinit var progressDialog: ProgressDialog

    var firebaseAuth = FirebaseAuth.getInstance()

//    override fun onStart() {
//        super.onStart()
//        if (firebaseAuth.currentUser!=null){
//            startActivity(Intent(this, Home::class.java))
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_page)
        editEmail = findViewById(R.id.txtMail)
        editPassword = findViewById(R.id.txtPswrd)
        editPasswordConf = findViewById(R.id.txtConfirm)
        btnRegister = findViewById(R.id.btnsignup)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Logging")
        progressDialog.setMessage("Silahkan Tunggu...")

        btnRegister.setOnClickListener {
            if (editEmail.text.isNotEmpty() && editPassword.text.isNotEmpty()){
                if (editPassword.text.toString() == editPasswordConf.text.toString()) {
                    //LAUNCH REGISTER
                    processRegister()
                }else{
                    Toast.makeText(this, "Konfirmasi Kata Sandi Harus Sama", LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Silahkan isi dulu semua data", LENGTH_SHORT).show()
            }
        }

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

        val btnHave = findViewById<Button>(R.id.btnHaveACC)
        btnHave.setOnClickListener {
            val intent = Intent(this@RegisterPage, LoginPage::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun processRegister() {
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()

        progressDialog.show()
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    user?.sendEmailVerification()?.addOnCompleteListener { verifyTask ->
                        if (verifyTask.isSuccessful) {
                            Toast.makeText(this, "Verifikasi email telah dikirim. Silakan cek email Anda.", Toast.LENGTH_LONG).show()
                            firebaseAuth.signOut() // Logout setelah register
                            startActivity(Intent(this, LoginPage::class.java)) // Arahkan ke login
                            finish()
                        } else {
                            Toast.makeText(this, "Gagal mengirim email verifikasi.", Toast.LENGTH_SHORT).show()
                        }
                        progressDialog.dismiss()
                    }
                } else {
                    Toast.makeText(this, task.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
            }
    }

}