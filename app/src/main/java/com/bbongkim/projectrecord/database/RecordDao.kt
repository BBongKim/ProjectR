package com.bbongkim.projectrecord.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bbongkim.projectrecord.database.RecordEntity
import java.time.LocalDateTime

@Dao
interface RecordDao {
    @Insert
    fun insert(record: RecordEntity)

    @Update
    fun update(record: RecordEntity)

    @Delete
    fun delete(record: RecordEntity)

    // TODO O월 O일에 해당하는 기록 모두 가져오도록 쿼리 변경 필요
    @Query("SELECT * FROM record WHERE date = :date")
    fun fetchRecordsWithDate(date: LocalDateTime): LiveData<List<RecordEntity>>

    @Query("SELECT * FROM record")
    fun fetchAllRecords(): LiveData<List<RecordEntity>>
}