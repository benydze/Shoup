package com.example.mymarketmobileversion

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class ProductAdapter(private val products: List<Product>)
    : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val productName: TextView = itemView.findViewById(R.id.productName)
        val productDesc: TextView = itemView.findViewById(R.id.productDesc)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        val urlofPhoto: TextView = itemView.findViewById(R.id.urlofPhoto)
        val postedBy: TextView = itemView.findViewById(R.id.userEmail)
        val image: ImageView = itemView.findViewById(R.id.productPhoto)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(itemView)

    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val p = products[position]

        holder.productName.text = p.name
        holder.productDesc.text = p.description
        holder.productPrice.text = p.price
        holder.urlofPhoto.text = p.url
        holder.postedBy.text = p.postedBy

        Glide.with(holder.image.getContext())
            .load("${p.url}")
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.image);


    }

}