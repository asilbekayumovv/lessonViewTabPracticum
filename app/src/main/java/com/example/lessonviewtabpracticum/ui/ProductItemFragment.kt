package com.example.lessonviewtabpracticum.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lessonviewtabpracticum.Product
import com.example.lessonviewtabpracticum.R
import com.example.lessonviewtabpracticum.adapter.ProductItemAdapter
import com.example.lessonviewtabpracticum.databinding.FragmentProductItemBinding

private const val ARG_PARAM1 = "param1"


class ProductItemFragment : Fragment() {
    private var param1: String? = null
    private var products: MutableList<Product> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProductItemBinding.inflate(inflater, container, false)
        for (i in 0 until 5) {
            products.add(Product(R.drawable.apple13, "Apple 13", "$1000", "Apple"))
            products.add(Product(R.drawable.artel, "Artel", "$1000", "Artel"))
            products.add(Product(R.drawable.honorx8, "Honorx 8", "$1000", "Honor"))
            products.add(Product(R.drawable.redmi11pro, "Redmi 11 pro", "$1000", "Redmi"))
            products.add(Product(R.drawable.samsung53, "Samsung 53", "$1000", "Samsung"))
            products.add(Product(R.drawable.tecno, "Tecno", "$1000", "Tecno"))
            products.add(Product(R.drawable.vivo, "Vivo", "$1000", "Vivo"))
        }

        if (param1 == "Barchasi") binding.productRv.adapter = ProductItemAdapter(products)
        else binding.productRv.adapter = ProductItemAdapter(products.filter { it.type == param1 } as MutableList<Product>)

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            ProductItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}