package com.bbongkim.projectrecord.record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bbongkim.projectrecord.R
import com.bbongkim.projectrecord.databinding.FragmentCreateBinding

class CreateFragment : Fragment() {

    private lateinit var binding: FragmentCreateBinding

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
        arguments?.let {
            val message = CreateFragmentArgs.fromBundle(it).messageToday
            val text = "${message.year}년 ${message.month}월 ${message.day}일"
            binding.date.text = text
        }
    }

}