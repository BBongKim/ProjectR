package com.bbongkim.projectrecord.viewmodel

import androidx.lifecycle.ViewModel
import java.time.YearMonth

class MonthViewModel : ViewModel() {
    // 현재 보고 있는 달, 날짜 저장
    var currentMonth: YearMonth? = null
}