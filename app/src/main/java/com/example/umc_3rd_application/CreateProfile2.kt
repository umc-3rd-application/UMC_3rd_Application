package com.example.umc_3rd_application

import android.os.Binder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_3rd_application.databinding.ActivityCreateProfile2Binding

class CreateProfile2: AppCompatActivity() {
    private lateinit var viewBinding : ActivityCreateProfile2Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewBinding = ActivityCreateProfile2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        val dataList:  ArrayList<Profile2Data> =arrayListOf()

        dataList.apply {
            add(Profile2Data("1","2","3"))
            add(Profile2Data("4","5","6"))
            add(Profile2Data("7","8","9"))
            add(Profile2Data("10","11","12"))
        }
        val profile2RVAdapter = ProfileRVAdapter(dataList)
        // 이 다음 뭐써야되냐 .. layoutmanager 호출 해야되는데


    }
}
