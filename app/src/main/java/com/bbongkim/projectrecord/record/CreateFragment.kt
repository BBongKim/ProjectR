package com.bbongkim.projectrecord.record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.bbongkim.projectrecord.R
import com.bbongkim.projectrecord.database.RecordDatabase
import com.bbongkim.projectrecord.database.RecordEntity
import com.bbongkim.projectrecord.databinding.FragmentCreateBinding
import com.bbongkim.projectrecord.viewmodel.CalendarViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class CreateFragment : Fragment() {
    private val viewModel: CalendarViewModel by activityViewModels()
    private lateinit var binding: FragmentCreateBinding
    private lateinit var message: RecordArgument

    companion object {
        @JvmStatic
        fun newInstance() = CreateFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setArguments()
        setListener()
    }

    private fun setArguments() {
        arguments?.let {
            message = CreateFragmentArgs.fromBundle(it).messageDate
            val text = "${message.year}년 ${message.month}월 ${message.day}일 ${message.hour}시 ${message.min}분"
            binding.date.text = text
        }
    }

    private fun setListener() {
        // TODO 데이터 바인딩 리팩토링 (기능확장된 EditText로 가능하면)
        binding.saveButton.setOnClickListener {

            val date = getDate()
            val record = RecordEntity(date, getContents())
            viewModel.insertRecord(record)

            Toast.makeText(requireContext(), "저장 완료", Toast.LENGTH_SHORT).show()

            // RecordFragment로 이동
            val message = RecordArgument(date.year, date.monthValue, date.dayOfMonth, date.hour, date.minute)
            val action = CreateFragmentDirections.createToRecord(message)
            this.requireView().findNavController().navigate(action)
        }
    }

    private fun getDate(): LocalDateTime {
        return LocalDateTime.of(message.year, message.month, message.day, message.hour, message.min, 0)
    }

    private fun getContents(): String {
        return binding.record.text.toString()
    }
}