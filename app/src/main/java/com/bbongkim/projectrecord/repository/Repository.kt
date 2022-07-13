package com.bbongkim.projectrecord.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.bbongkim.projectrecord.database.RecordDatabase
import com.bbongkim.projectrecord.database.RecordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class Repository(context: Context) {
    private var recordDao = RecordDatabase.getInstance(context).recordDao()

    fun insert(record: RecordEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            recordDao.insert(record)
        }
    }

    fun delete(record: RecordEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            recordDao.delete(record)
        }
    }

    fun update(record: RecordEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            recordDao.update(record)
        }
    }

    // TODO LiveData -> Flow 변경
    // ViewModel <-> Repository 간은 LiveData보다 Flow를 사용하는게 더 좋다는 글이 있다.
    suspend fun fetchRecordsWithDate(date: LocalDateTime): LiveData<List<RecordEntity>> {
        return withContext(Dispatchers.IO) {
            recordDao.fetchRecordsWithDate(date)
        }
    }

}