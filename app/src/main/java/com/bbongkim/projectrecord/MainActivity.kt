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
    lateinit var calenderView: CalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setDate()
    }

    private fun init() {
        calenderView = findViewById(R.id.calendar)
        calenderView.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View): DayViewContainer = DayViewContainer(view)

            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.textView.text = day.date.dayOfMonth.toString()
            }

        }
        calenderView.monthHeaderBinder = object : MonthHeaderFooterBinder<MonthHeaderContainer> {
            override fun create(view: View): MonthHeaderContainer = MonthHeaderContainer(view)

            override fun bind(container: MonthHeaderContainer, month: CalendarMonth) {
                container.textView.text = String.format(getString(R.string.kr_monthYear), month.year, month.month)
            }
        }
    }

    private fun setDate() {
        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        calenderView.setup(firstMonth, lastMonth, firstDayOfWeek)
        calenderView.scrollToMonth(currentMonth)
    }
}