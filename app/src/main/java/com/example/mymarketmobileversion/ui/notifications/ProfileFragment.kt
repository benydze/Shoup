package com.example.mymarketmobileversion.ui.notifications

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mymarketmobileversion.LoadupActivity
import com.example.mymarketmobileversion.LoginActivity
import com.example.mymarketmobileversion.MainActivity
import com.example.mymarketmobileversion.R
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var mAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance();

        val builder = AlertDialog.Builder(activity)

        builder.setTitle("მთავარ გვერდზე დაბრუნება")

        builder.setMessage("გსურთ საიტიდან გასვლა?")

        builder.setPositiveButton("კი"){ dialog, i ->
            startActivity(Intent(activity, LoadupActivity::class.java))
            dialog.dismiss()
        }

        builder.setNegativeButton("არა"){ dialog, i ->
            startActivity(Intent(activity, MainActivity::class.java))
            dialog.dismiss()
        }

        builder.show().setCancelable(false)
        mAuth.signOut()

    }
}