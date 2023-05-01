package com.example.lessonviewtabpracticum.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lessonviewtabpracticum.ui.ProductItemFragment

class ProductPagerAdapter(fa: FragmentActivity, var list: MutableList<String>) :
    FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return ProductItemFragment.newInstance(list[position])
    }
}