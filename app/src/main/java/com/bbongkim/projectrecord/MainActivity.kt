package com.bbongkim.projectrecord

import android.icu.text.DateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bbongkim.projectrecord.calendar.DayViewContainer
import com.bbongkim.projectrecord.calendar.MonthHeaderContainer
import com.kizitonwose.calendarview.CalendarView
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}