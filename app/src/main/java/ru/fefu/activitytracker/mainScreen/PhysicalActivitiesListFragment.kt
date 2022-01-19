package ru.fefu.activitytracker.mainScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import ru.fefu.activitytracker.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.data.ActivitiesRepository
import ru.fefu.activitytracker.data.ActivityInfo
import ru.fefu.activitytracker.models.BaseItemModel
import ru.fefu.activitytracker.models.DateTitleItemModel
import ru.fefu.activitytracker.models.PhysicalActivityItemModel
import java.text.SimpleDateFormat
import java.util.function.Consumer

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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rep = ActivitiesRepository()

        val items = (if (fragmentNumber == 0) rep.getActivities("Victor") else rep.getActivities())
        val indices = items.asSequence().withIndex()
            .groupBy { indexedValue: IndexedValue<ActivityInfo> ->
                SimpleDateFormat("EEE MMM dd").format(
                    indexedValue.value.activityDate
                )
            }
            .filter { entry -> entry.value.isNotEmpty() }
            .map { entry -> entry.value.first().index }
            .toHashSet()

        val models = items.map { activityInfo ->
            PhysicalActivityItemModel(
                activityInfo.activityName,
                activityInfo.distance,
                activityInfo.duration,
                activityInfo.activityDate,
                activityInfo.user
            ) as BaseItemModel
        }.toMutableList()
        indices.withIndex().forEach(Consumer { v ->
            models.add(
                v.value + v.index,
                DateTitleItemModel(SimpleDateFormat("EEE MMM dd").format(items[v.value].activityDate))
            )
        })


        val listAdapter = PhysicalActivityListAdapter(
            models.toTypedArray(),
            models.withIndex()
                .mapNotNull { m -> if (m.value is DateTitleItemModel) m.index else null }
                .map { i -> i }.toHashSet(),
            requireParentFragment().parentFragmentManager
        )
        val recyclerView = view.findViewById<RecyclerView>(R.id.activitiesRecycleView)
        recyclerView.adapter = listAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        (recyclerView.layoutManager as LinearLayoutManager).offsetChildrenVertical(10)
    }
}