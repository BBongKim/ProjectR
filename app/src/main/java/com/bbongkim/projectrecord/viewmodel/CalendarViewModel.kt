package com.bbongkim.projectrecord.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bbongkim.projectrecord.database.RecordEntity
import com.bbongkim.projectrecord.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.YearMonth

class CalendarViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Repository(application.applicationContext)
    var date: LocalDateTime? = null
    var recordList: LiveData<List<RecordEntity>>? = null

    fun insertRecord(record: RecordEntity) {
        repository.insert(record)
    }

    fun fetchRecordsWithDate(date: LocalDateTime) {
        viewModelScope.launch {
            recordList = repository.fetchRecordsWithDate(date)
        }
    }
}