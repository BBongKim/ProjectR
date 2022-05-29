package com.bbongkim.projectrecord.record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bbongkim.projectrecord.databinding.FragmentRecordBinding

class RecordFragment : Fragment() {
    private lateinit var binding: FragmentRecordBinding


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
            val message = RecordFragmentArgs.fromBundle(it).message
            binding.dateText.text = "${message.year}년 ${message.month}월 ${message.day}일"
        }
    }
}