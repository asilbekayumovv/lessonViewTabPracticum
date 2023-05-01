package com.example.lessonviewtabpracticum.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lessonviewtabpracticum.R
import com.example.lessonviewtabpracticum.adapter.ProductPagerAdapter
import com.example.lessonviewtabpracticum.databinding.FragmentProductBinding
import com.google.android.material.tabs.TabLayoutMediator


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ProductFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var productType = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProductBinding.inflate(inflater, container, false)

        productTypeLoad()
        binding.productPager.adapter = ProductPagerAdapter(requireActivity(),productType)

        TabLayoutMediator(binding.productTab,binding.productPager){tab, position->
            val view = LayoutInflater.from(requireContext()).inflate(R.layout.tab_item_layout,null, false)
            view.findViewById<TextView>(R.id.type).text = productType[position]
            tab.customView = view
        }.attach()

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun productTypeLoad(){
        productType.add("Barchasi")
        productType.add("Samsung")
        productType.add("Apple")
        productType.add("Honor")
        productType.add("Redmi")
        productType.add("Vivo")
        productType.add("Tecno")
        productType.add("Artel")
    }
}