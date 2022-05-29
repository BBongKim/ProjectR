package com.bbongkim.projectrecord.record

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecordArgument(val year: Int, val month: Int, val day: Int): Parcelable