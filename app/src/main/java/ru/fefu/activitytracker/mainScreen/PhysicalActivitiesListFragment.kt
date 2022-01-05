package ru.fefu.activitytracker.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.R
import android.widget.TextView

// Фрагмент для своей активности или других пользователей
class PhysicalActivitiesListFragment : Fragment() {
    // Позиция фрагмента и таба
    private var fragmentNumber = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentNumber = arguments?.get("fragmentPosition") as Int
        return inflater.inflate(R.layout.fragment_physical_activities_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView = view.findViewById<TextView>(R.id.test_text)
        textView.text = "Активности " + (if (fragmentNumber == 0) "" else "пользователей")
    }
}