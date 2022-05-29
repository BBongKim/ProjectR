package com.bbongkim.projectrecord.calendar

import android.view.View
import com.bbongkim.projectrecord.databinding.CalendarMonthHeaderLayoutBinding
import com.kizitonwose.calendarview.ui.ViewContainer

class MonthHeaderContainer(view: View): ViewContainer(view) {
    val textView = CalendarMonthHeaderLayoutBinding.bind(view).calendarMonthText
}