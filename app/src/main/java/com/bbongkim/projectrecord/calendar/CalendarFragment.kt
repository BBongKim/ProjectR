package com.bbongkim.projectrecord.calendar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.bbongkim.projectrecord.R
import com.bbongkim.projectrecord.databinding.FragmentCalendarBinding
import com.bbongkim.projectrecord.record.RecordArgument
import com.bbongkim.projectrecord.viewmodel.CalendarViewModel
import com.bbongkim.projectrecord.viewmodel.MonthViewModel
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

// 메인 화면에 올라올 달력을 담고 있는 프래그먼트
class CalendarFragment : Fragment() {
    // Delegate Property 이용
    private val viewModel: MonthViewModel by activityViewModels()
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!! // nullable 해서 이렇게 만듦

    companion object {
        @JvmStatic
        fun newInstance() = CalendarFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Debug", "OnCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("Debug", "OnCreateView")
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Debug", "OnViewCreated")
        calendarInit()
        setDate()
        setClickListener()
    }

    // Fragment는 View보다 오래 지속되기 때문에, View에 대한 참조를 여기서 다 제거해야 한다.
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Debug", "onDestroyView")
        _binding = null
    }

    // 달력 초기화
    private fun calendarInit() {
        // 달력 일 초기화
        binding.calendar.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View): DayViewContainer = DayViewContainer(view)

            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.date = day.date
                container.day = day
                val textView = container.textView
                textView.text = day.date.dayOfMonth.toString()
            }

        }

        // 달력 헤더 초기화
        binding.calendar.monthHeaderBinder =
            object : MonthHeaderFooterBinder<MonthHeaderContainer> {
                override fun create(view: View): MonthHeaderContainer = MonthHeaderContainer(view)

                override fun bind(container: MonthHeaderContainer, month: CalendarMonth) {
                    container.textView.text =
                        String.format(getString(R.string.kr_monthYear), month.year, month.month)
                }
            }

        // 스크롤 리스너 초기화
        // 스크롤 할 때마다 뷰 모델에 현재 달을 저장한다.
        binding.calendar.monthScrollListener = {
            viewModel.currentMonth = it.yearMonth
        }
    }

    // 달력 날짜 초기화
    private fun setDate() {
        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)   // 앞 뒤로 최대 10개월까지
        val lastMonth = currentMonth.plusMonths(10)
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        binding.calendar.setup(firstMonth, lastMonth, firstDayOfWeek)

        // 뷰 모델에 있는 저장된 현재 달로 스크롤한다.
        viewModel.currentMonth?.let {
            binding.calendar.scrollToMonth(it)
        } ?: run {
            binding.calendar.scrollToMonth(currentMonth)
        }
    }

    private fun setClickListener() {
        //일기 쓰기 버튼
        binding.recordCreateButton.setOnClickListener {
            val localDateTime = LocalDateTime.now()
            val messageToday = RecordArgument(
                localDateTime.year,
                localDateTime.monthValue,
                localDateTime.dayOfMonth,
                localDateTime.hour,
                localDateTime.minute
            )
            val action = CalendarFragmentDirections.calendarToCreate(messageToday)
            this.requireView().findNavController().navigate(action)
        }
    }
}