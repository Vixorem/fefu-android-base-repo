package ru.fefu.activitytracker.models

import java.time.Duration
import java.util.*

// Модель данных для элемента списка активностей
class PhysicalActivityItemModel(
    val activityName: String,
    val distance: String,
    val duration: Duration,
    val activityDate: Date,
    val user: String
) : BaseItemModel()