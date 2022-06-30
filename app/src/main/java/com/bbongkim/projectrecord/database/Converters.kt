package com.bbongkim.projectrecord.database

import android.util.Log
import androidx.room.TypeConverter
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class Converters {
    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): Long? {
        Log.d("Date", date.toString())
        return date?.let { date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() }
    }

    @TypeConverter
    fun TimestampToDate(value: Long?): LocalDateTime? {
        return value?.let { LocalDateTime.ofInstant(Instant.ofEpochMilli(it), TimeZone.getDefault().toZoneId()) }
    }
}