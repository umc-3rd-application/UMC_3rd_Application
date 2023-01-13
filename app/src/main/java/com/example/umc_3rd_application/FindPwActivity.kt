package com.example.umc_3rd_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_3rd_application.databinding.ActivityFindPwBinding

class FindPwActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFindPwBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindPwBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}