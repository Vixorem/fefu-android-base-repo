package ru.fefu.activitytracker.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PhysicalActivityAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = PhysicalActivitiesListFragment()
        fragment.arguments = Bundle().apply {
            putInt("fragmentPosition", position)
        }
        return fragment
    }
}