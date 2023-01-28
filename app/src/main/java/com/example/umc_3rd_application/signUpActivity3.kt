package com.example.umc_3rd_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.umc_3rd_application.databinding.ActivitySignUp2Binding
import com.example.umc_3rd_application.databinding.ActivitySignUp3Binding

class signUpActivity3 : AppCompatActivity() {

    private var backPressedTime : Long = 0
    private lateinit var binding : ActivitySignUp3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up3)


        //1.백 버튼을 누르면 이전 페이지로 이동합니다.
        binding.imageButton.setOnClickListener{
            val intent = Intent(this,signUpActivity2::class.java)
            Toast.makeText(this,"이전 페이지로 이동합니다.",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }

        //2.완료 버튼을 누르면 회원가입/프로필 작성이 완료됩니다.
        binding.writeProfileComplete.setOnClickListener{
            val intent = Intent(this,loginactivity::class.java)
            Toast.makeText(this,"회원 가입/프로필 작성이 완료되었습니다.",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }



    }
}