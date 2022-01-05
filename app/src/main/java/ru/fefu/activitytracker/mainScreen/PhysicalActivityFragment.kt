package ru.fefu.activitytracker.mainScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.fefu.activitytracker.R

// Фрагмент для вкладки "Активности"
class PhysicalActivityFragment : Fragment(R.layout.fragment_physical_activity) {
    private lateinit var physicalActivityAdapter: PhysicalActivityAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_physical_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        physicalActivityAdapter = PhysicalActivityAdapter(this)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = physicalActivityAdapter

        val tabLayout = view.findViewById(R.id.tab_layout) as TabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            if (position == 0)
                tab.text = "Мои"
            else
                tab.text = "Пользователи"
        }.attach()
    }
}