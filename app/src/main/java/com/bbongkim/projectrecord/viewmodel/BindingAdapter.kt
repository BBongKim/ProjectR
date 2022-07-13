package com.bbongkim.projectrecord.viewmodel

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bbongkim.projectrecord.database.RecordEntity
import com.bbongkim.projectrecord.record.RecordRecyclerAdapter

object BindingAdapter {
    @BindingAdapter
    @JvmStatic
    fun setRecords(view: RecyclerView, records: List<RecordEntity>?) {
        if (view.adapter == null) {
            view.adapter = RecordRecyclerAdapter()
        }

        records?.let {
            val adapter = view.adapter as RecordRecyclerAdapter
            adapter.setRecords(it)
        }
    }
}