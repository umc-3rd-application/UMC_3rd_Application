package com.example.umc_3rd_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.example.umc_3rd_application.databinding.ActivityCreateProfile1Binding

class CreateProfile1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCreateProfile1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //다음 화면 이동 버튼 비활성화
        binding.btnNext.isEnabled = false

        binding.editName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

    }
}