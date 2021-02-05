package com.example.mymarketmobileversion

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

private lateinit var imgView: ImageView
private lateinit var regBut: Button
private lateinit var logBut: Button


class LoadupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loadup)

        imgView = findViewById(R.id.imageView)
        regBut = findViewById(R.id.regBut)
        logBut = findViewById(R.id.logBut)
        imgView.setBackgroundResource(R.drawable.main)

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        regBut.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        logBut.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}