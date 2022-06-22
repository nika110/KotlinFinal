package com.example.imgzavredges.ui.trip.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.imgzavredges.ui.trip.TripFragment

class LastRideAdapter(tripFragment: TripFragment,
                      private val fragmentArray: ArrayList<Fragment>): FragmentStateAdapter(tripFragment) {

    override fun getItemCount(): Int {
        return fragmentArray.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentArray[position]
    }
}