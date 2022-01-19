package ru.fefu.activitytracker.data;

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.util.*

// Репозиторий для активностей
public class ActivitiesRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    private val activities: List<ActivityInfo> = arrayListOf(
        ActivityInfo("Бег", "10 км", Duration.ofMinutes(10), Date(2022, 1, 14, 3, 25, 33), "Victor"),
        ActivityInfo("Качалка", "Кач", Duration.ofMinutes(16), Date(2022, 1, 14, 10, 0, 0), "Victor"),
        ActivityInfo("Спорт", "Спорт", Duration.ofMinutes(10), Date(2022, 1, 14, 10, 0, 0), "Vova"),
        ActivityInfo("Турник", "10 раз", Duration.ofMinutes(100), Date(2022, 1, 14, 10, 0, 0), "Victor"),
        ActivityInfo("Качалка", "Кач", Duration.ofMinutes(23), Date(2022, 1, 12, 3, 0, 0), "Vova"),
        ActivityInfo("Турник", "5 раз", Duration.ofMinutes(10), Date(2022, 1, 12, 2, 0, 0), "Victor"),
        ActivityInfo("Бегит", "10 км", Duration.ofMinutes(222), Date(2022, 1, 12, 10, 0, 0), "Masha"),
        ActivityInfo("Прес качат", "20 раз", Duration.ofMinutes(11), Date(2022, 1, 10, 3, 0, 0), "Vasya"),
        ActivityInfo("Бегит", "100 км", Duration.ofMinutes(11), Date(2022, 1, 10, 4, 0, 0), "Victor"),
        ActivityInfo("Турник", "1 раз", Duration.ofMinutes(10), Date(2022, 1, 10, 5, 0, 0), "Lady Gaga"),
        ActivityInfo("Прес качат", "50 раз", Duration.ofMinutes(11), Date(2022, 1, 8, 11, 0, 0), "Victor"),
        ActivityInfo("Бегит", "14 км", Duration.ofMinutes(10), Date(2022, 1, 8, 4, 0, 0), "Жора"),
        ActivityInfo("Прес качать", "100 раз", Duration.ofMinutes(10), Date(2022, 1, 8, 5, 0, 0), "Гена"),
        ActivityInfo("Качалка", "Кач", Duration.ofMinutes(232), Date(2022, 1, 5, 7, 0, 0), "Петя"),
        ActivityInfo("Фитнес", "Долго", Duration.ofMinutes(4), Date(2022, 1, 5, 9, 0, 0), "Victor"),
        ActivityInfo("Фитнес", "Много", Duration.ofMinutes(47), Date(2022, 1, 5, 1, 0, 0), "Дудь"),
        ActivityInfo("Фитнес", "Долго", Duration.ofMinutes(2), Date(2022, 1, 3, 4, 0, 0), "Димон"),
        ActivityInfo("Прес качат", "10 раз", Duration.ofMinutes(10), Date(2022, 1, 2, 6, 0, 0), "Клим Саныч"),
        ActivityInfo("Бегит", "10 км", Duration.ofMinutes(10), Date(2022, 1, 2, 7, 0, 0), "Дмитрий Пучков"),
    )

    // Получить список активностей
    @RequiresApi(Build.VERSION_CODES.O)
    fun getActivities(nameFilter: String): List<ActivityInfo> {
        return activities.filter { activityInfo -> activityInfo.user == nameFilter }
    }

    // Получить список активностей
    @RequiresApi(Build.VERSION_CODES.O)
    fun getActivities(): List<ActivityInfo> {
        return activities
    }
}
