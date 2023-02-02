package com.example.Showdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragment.homeFragment
import com.example.umc_3rd_application.R
import com.example.umc_3rd_application.databinding.ActivityShowDetail2Binding
import com.example.umc_3rd_application.databinding.ActivityShowDetailBinding

class showDetailActivity2 : AppCompatActivity() {
    //세부보기의 2번째 화면입니다.
    private lateinit var binding : ActivityShowDetail2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail2)


        //1.뒤로가기 버튼을 누르면 세부보기 페이지의 첫번째 페이지로 이동합니다.
        binding.backToTheDetail1.setOnClickListener {
            val intent = Intent(this, showDetailActivity::class.java)
            Toast.makeText(this,"세부 보기 첫번째 페이지로 이동합니다.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }


        //2.메세지 보내기 버튼을 누르면 해당 사람에게 메세지를 전송합니다.
        //이 부분은 서버와 연동하여 코드를 작성해야 합니다.
        binding.SendMessageButton.setOnClickListener {

        }


        //3.홈으로 돌아가기 버튼을 누르면 홈으로 돌아갑니다.
        binding.gotoTheHomePageButton2.setOnClickListener {
            val intent = Intent(this, homeFragment::class.java)
            Toast.makeText(this,"홈(오늘의 소개)페이지로 이동합니다.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        //4.성격,연애 가치관을 받아옵니다. 이 부분도 서버와 연동하여 작업합니다.
    }
}