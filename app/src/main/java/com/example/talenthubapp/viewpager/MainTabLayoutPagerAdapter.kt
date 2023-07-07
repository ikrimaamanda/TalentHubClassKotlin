package com.example.talenthubapp.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainTabLayoutPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    private val listOfFragment = arrayListOf(ABlankFragment(), BBlankFragment())

    override fun getCount(): Int {
        return listOfFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> listOfFragment[position]
            else -> listOfFragment[position]
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when(position) {
            0 -> "Fragment A"
            else -> "Fragment B"
        }
    }

}