package ru.fefu.activitytracker.mainScreen

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ToolbarBinding
import ru.fefu.activitytracker.models.BaseItemModel
import ru.fefu.activitytracker.models.DateTitleItemModel
import ru.fefu.activitytracker.models.PhysicalActivityItemModel
import java.lang.Exception
import java.text.SimpleDateFormat

// Адаптер списка активностей
class PhysicalActivityListAdapter(
    private val items: Array<BaseItemModel>,
    private val dateTitlePositions: HashSet<Int>,
    private val fragmentManager: FragmentManager
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Элемент списка активностей
    class PhysicalActivityItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val activityTitleTextView: TextView = view.findViewById(R.id.item_title)
        val durationTextView: TextView = view.findViewById(R.id.activity_duration)
        val activityTypeTextView: TextView = view.findViewById(R.id.activity_type)
        val timeTextView: TextView = view.findViewById(R.id.activity_time)
        val info_card_id: MaterialCardView = view.findViewById(R.id.info_card_id)
        val itemConstraint: ConstraintLayout = view.findViewById(R.id.item_constraint)
    }

    // Элемент для группировки списка по датам
    class DateTitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateTitle: TextView = view.findViewById(R.id.date_title)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhysicalActivityItemViewHolder) {
            val item = items[position] as PhysicalActivityItemModel
            holder.activityTitleTextView.text = item.distance
            holder.activityTypeTextView.text = item.activityName
            holder.durationTextView.text = item.duration.toMinutes().toString() + " мин."
            holder.timeTextView.text = SimpleDateFormat("HH:mm").format(item.activityDate)
            holder.itemConstraint.setOnClickListener { view ->
                fragmentManager.commit {
                    setReorderingAllowed(true)
                    add<ActivityDetalizationFragment>(R.id.fragment_container, "detalization")
                    hide(fragmentManager.findFragmentByTag("physical")!!)
                }
                fragmentManager.executePendingTransactions()
            }

        } else if (holder is DateTitleViewHolder) {
            val item = items[position] as DateTitleItemModel
            holder.dateTitle.text = item.activityDate
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (dateTitlePositions.contains(position)) 1 else 0;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0)
            PhysicalActivityItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_physical_activity_item, parent, false)
            )
        else
            DateTitleViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_activity_date_title_item, parent, false)
            )
    }

    override fun getItemCount(): Int = items.size
}