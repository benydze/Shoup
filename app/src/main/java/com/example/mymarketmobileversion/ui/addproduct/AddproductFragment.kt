package com.example.mymarketmobileversion.ui.addproduct

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mymarketmobileversion.MainActivity
import com.example.mymarketmobileversion.Product
import com.example.mymarketmobileversion.R
import com.example.mymarketmobileversion.RegisterActivity
import com.example.mymarketmobileversion.ui.home.HomeFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_addproduct.*

class AddproductFragment : Fragment(R.layout.fragment_addproduct) {

    private lateinit var inputName: EditText
    private lateinit var inputDescription: EditText
    private lateinit var inputPrice: EditText
    private lateinit var url: EditText
    private lateinit var addButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputName = view.findViewById(R.id.inputName)
        inputDescription = view.findViewById(R.id.inputDescription)
        inputPrice = view.findViewById(R.id.inputPrice)
        url = view.findViewById(R.id.url)

        addButton = view.findViewById(R.id.addButton)

        val database = FirebaseDatabase.getInstance().reference
        val user = FirebaseAuth.getInstance().currentUser

        addButton.setOnClickListener{

            val builder = AlertDialog.Builder(activity)

            builder.setTitle("პროდუქტი დამატებულია")
            builder.setMessage("გსურთ ახალი პროდუქტის დამატება?")
            builder.setPositiveButton("ახლის დამატება"){ dialog, i ->
                inputName.setText("")
                inputDescription.setText("")
                inputPrice.setText("")
                url.setText("")
                dialog.dismiss()
            }
            builder.setNegativeButton("მთავარ გვერდზე გადასვლა"){ dialog, i ->
                startActivity(Intent(activity, MainActivity::class.java))
                dialog.dismiss()
            }

            builder.show().setCancelable(false)

            var name = inputName.text.toString()
            var description = inputDescription.text.toString()
            var price = inputPrice.text.toString()
            var photoUrl = url.text.toString()
            var postedBy = user!!.email.toString()
            var id = database.push().key

            database.child("$id").setValue(Product(name,description, price, photoUrl, postedBy))
//            startActivity(Intent(activity, MainActivity::class.java))
        }


    }
}
