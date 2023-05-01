package com.example.lessonviewtabpracticum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonviewtabpracticum.Product
import com.example.lessonviewtabpracticum.R
import com.example.lessonviewtabpracticum.databinding.FragmentProductItemBinding
import com.example.lessonviewtabpracticum.databinding.ProductItemBinding

class ProductItemAdapter(var products: MutableList<Product>): RecyclerView.Adapter<ProductItemAdapter.MyHolder>() {
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return products.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false))
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var binding = ProductItemBinding.bind(holder.itemView)

        var product = products[position]

        binding.productImg.setImageResource(product.img)
        binding.productName.text = product.name
        binding.productPrice.text = product.price
    }
}