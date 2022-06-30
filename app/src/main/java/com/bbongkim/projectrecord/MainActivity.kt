package com.bbongkim.projectrecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bbongkim.projectrecord.viewmodel.CalendarViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CalendarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO 리펙토링
        viewModel = ViewModelProvider(this).get(CalendarViewModel::class.java)
        setContentView(R.layout.activity_main)
    }
}