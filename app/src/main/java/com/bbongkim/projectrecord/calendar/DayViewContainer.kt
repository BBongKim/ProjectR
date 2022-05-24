package com.bbongkim.projectrecord.calendar

import android.view.View
import android.widget.TextView
import com.bbongkim.projectrecord.R
import com.bbongkim.projectrecord.databinding.CalendarDayLayoutBinding
import com.kizitonwose.calendarview.CalendarView
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.ViewContainer
import java.time.DayOfWeek
import java.time.LocalDate

class DayViewContainer(view: View) : ViewContainer(view) {
    lateinit var day: CalendarDay
    lateinit var calendarView: CalendarView
    var selectedDate: LocalDate? = null
    private val binding = CalendarDayLayoutBinding.bind(view)
    val textView = binding.calendarDayText

    init {
        view.setOnClickListener {
            if (day.owner == DayOwner.THIS_MONTH) {
                val currentSelection = selectedDate

                if (currentSelection == day.date) {
                    selectedDate = null
                    calendarView.notifyDateChanged(currentSelection)
                } else {
                    selectedDate = day.date
                    calendarView.notifyDateChanged(day.date)
                }
            }
        }
    }
}