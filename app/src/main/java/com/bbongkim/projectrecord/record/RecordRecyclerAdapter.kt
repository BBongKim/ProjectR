package com.bbongkim.projectrecord.record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bbongkim.projectrecord.database.RecordEntity
import com.bbongkim.projectrecord.databinding.RecordItemLayoutBinding

class RecordRecyclerAdapter : RecyclerView.Adapter<RecordRecyclerAdapter.RecordViewHolder>() {
    // TODO item layout 완성, BindingAdapter, ViewModel 추가 필요
    private var recordList: List<RecordEntity> = ArrayList()

    fun setRecords(records: List<RecordEntity>) {
        recordList = records
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val binding =
            RecordItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(recordList[position])
    }

    override fun getItemCount(): Int {
        return recordList.size
    }

    inner class RecordViewHolder(private val binding: RecordItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recordEntity: RecordEntity) {
            binding.record = recordEntity
        }
    }
}