package com.bbongkim.projectrecord.record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bbongkim.projectrecord.databinding.FragmentRecordBinding
import com.bbongkim.projectrecord.viewmodel.CalendarViewModel
import java.time.LocalDateTime

class RecordFragment : Fragment() {
    private val viewModel: CalendarViewModel by activityViewModels()
    private lateinit var binding: FragmentRecordBinding
    private lateinit var date: LocalDateTime

    companion object {
        @JvmStatic
        fun newInstance() = RecordFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val message = RecordFragmentArgs.fromBundle(it).messageDate
            val text = "${message.year}년 ${message.month}월 ${message.day}일"
            date = LocalDateTime.of(message.year, message.month, message.day, message.hour, message.min)
            viewModel.fetchRecordsWithDate(date)
            binding.dateText.text = text
        }
    }
}