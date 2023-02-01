package com.example.umc_3rd_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import com.example.umc_3rd_application.databinding.ActivityCreateProfile1Binding

class CreateProfile1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCreateProfile1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val add1data = arrayOf("서울특별시", "경기도", "강원도")
        val add2data = arrayOf("고양시", "파주시")
        //val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, add1data)

       // binding.spinnerAddress1.adapter = adapter
        //다음 화면 이동 버튼 비활성화
        binding.btnNext.isEnabled = false

       /* binding.editName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })*/

    }
}