package com.bbongkim.projectrecord.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "record")
data class RecordEntity(
    @ColumnInfo(name = "date")
    val date: LocalDateTime,
    val contents: String
) {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int = 0
}