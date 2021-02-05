package com.example.mymarketmobileversion.ui.home

import android.app.ActionBar
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymarketmobileversion.Product
import com.example.mymarketmobileversion.ProductAdapter
import com.example.mymarketmobileversion.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        val database = FirebaseDatabase.getInstance().reference

        var getData = object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val products = ArrayList<Product>()

                for(i in snapshot.children){
                    var productName = i.child("name").getValue().toString()
                    var productDesc = i.child("description").getValue().toString()
                    var productPrice = i.child("price").getValue().toString() + "₾"
                    var photoUrl = i.child("url").getValue().toString()
                    var postedBy = i.child("postedBy").getValue().toString()

                    products.add(Product(productName, productDesc, productPrice, photoUrl, postedBy))
                }

                val adapter = ProductAdapter(products)
                recyclerView.layoutManager = LinearLayoutManager(activity)
                recyclerView.adapter = adapter

            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)
    }

}