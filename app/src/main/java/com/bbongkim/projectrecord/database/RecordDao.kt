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

    @Query("SELECT * FROM record WHERE date = :date")
    fun getRecordsWithDate(date: LocalDateTime): List<RecordEntity>

    @Query("SELECT * FROM record")
    fun getAllRecords(): List<RecordEntity>
}