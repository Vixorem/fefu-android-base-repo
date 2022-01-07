package ru.fefu.activitytracker.data

import java.time.Duration
import java.util.*

data class ActivityInfo(
    val activityName: String,
    val distance: String,
    val duration: Duration,
    val activityDate: Date,
    val user: String
)