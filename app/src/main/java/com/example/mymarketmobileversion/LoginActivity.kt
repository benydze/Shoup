package com.example.mymarketmobileversion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


private lateinit var inputEmail: EditText
private lateinit var inputPassword: EditText
private lateinit var loginButton: Button
private lateinit var signupText: TextView
private lateinit var mAuth: FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        inputEmail = findViewById(R.id.inputEmail)
        inputPassword = findViewById(R.id.inputPassword)
        loginButton = findViewById(R.id.loginButton)
        signupText = findViewById(R.id.signupText)
        mAuth = FirebaseAuth.getInstance();

        signupText.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        loginButton.setOnClickListener{
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill out required fields", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener{ task ->
                        if(task.isSuccessful){
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }




    }
}