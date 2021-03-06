package com.bbongkim.projectrecord.calendar

import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.bbongkim.projectrecord.R
import com.bbongkim.projectrecord.databinding.CalendarDayLayoutBinding
import com.bbongkim.projectrecord.record.RecordArgument
import com.bbongkim.projectrecord.viewmodel.CalendarViewModel
import com.kizitonwose.calendarview.CalendarView
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.ViewContainer
import java.time.LocalDate

class DayViewContainer(view: View) : ViewContainer(view) {
    lateinit var date: LocalDate
    lateinit var day: CalendarDay
    var selectedDate: LocalDate? = null
    private val binding = CalendarDayLayoutBinding.bind(view)
    val textView = binding.calendarDayText

    init {
        view.setOnClickListener {
            if (day.owner == DayOwner.THIS_MONTH) {
                // Argument로 선택된 날짜 넣어서 이동하기
                // TODO 이 부분을 viewModel로 그냥 리펙토링 가능할듯?
                val message = RecordArgument(date.year, date.month.value, day.day)
                val action = CalendarFragmentDirections.calendarToRecord(message)
                view.findNavController().navigate(action)

                // if record exists :
                // goto Fragment Record
                // else :
                // goto Fragment Create
            }
        }
    }
}