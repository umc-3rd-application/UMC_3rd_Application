package com.example.Showdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragment.homeFragment
import com.example.umc_3rd_application.R
import com.example.umc_3rd_application.databinding.ActivitySendPwBinding
import com.example.umc_3rd_application.databinding.ActivityShowDetailBinding
import com.example.umc_3rd_application.loginactivity

class showDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShowDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        //세부보기1의 화면입니다.


        //1.뒤로 가기 버튼을 누르면 홈화면으로 이동합니다.
        binding.backToTheHome.setOnClickListener{
                val intent = Intent(this, homeFragment::class.java)
                Toast.makeText(this,"홈(오늘의 소개)화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
                startActivity(intent)
        }
      //2.다음으로 버튼을 누르면 다음으로 이동합니다.
      binding.goToTheNextDetailButton1.setOnClickListener {
          val intent = Intent(this, showDetailActivity2::class.java)
          Toast.makeText(this,"다음 세부 보기 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
          startActivity(intent)
      }

        //3.가장 중요한 데이터 받아오는 코드는 서버 연동시 코딩할 예정입니다.


    }
}