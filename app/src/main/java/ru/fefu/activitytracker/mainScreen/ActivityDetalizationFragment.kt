package ru.fefu.activitytracker.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.models.PhysicalActivityItemModel
import ru.fefu.activitytracker.databinding.FragmentActivityDetalizationBinding

// Фрагмент с детализацей иктивности
class ActivityDetalizationFragment() : Fragment() {

    private lateinit var binding: FragmentActivityDetalizationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityDetalizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detalizationToolbar.backButton.setNavigationOnClickListener {
            parentFragmentManager.commit {
                remove(parentFragmentManager.findFragmentByTag("detalization")!!)
                show(parentFragmentManager.findFragmentByTag("physical")!!)
                parentFragmentManager.executePendingTransactions()
            }
        }
    }
}