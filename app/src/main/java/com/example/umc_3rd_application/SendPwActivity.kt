package com.example.umc_3rd_application

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.umc_3rd_application.databinding.ActivitySendPwBinding

class SendPwActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySendPwBinding
    private var IDMessage : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendPwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //1. 이메일을 적어야 '다음' 버튼이 활성화됩니다.
        //2. 뒤로가기 아이콘을 2번 누르면 로그인 화면으로 이동합니다.
        //3. 다음 버튼을 누르면 임시 비밀번호가 발송되는 Activity로 이동합니다(추후 화면 구현되면 연동)

        //버튼을 비활성화합니다.
        binding.btnNext.isEnabled = false

        //EditText 값이 있을 때 버튼 활성화시킵니다.
        binding.txtEmail.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                IDMessage = binding.txtEmail.text.toString()

                binding.btnNext.isEnabled = IDMessage.isNotEmpty()
                if(binding.btnNext.isEnabled==true) {
                    binding.btnNext.setBackgroundColor(Color.parseColor("#8071d9"))
                }
            }
            override fun afterTextChanged(p0: Editable?) { }
        }
        )
        binding.btnBacktomain.setOnClickListener {
            val intent = Intent(this, findPassWordActivity::class.java)
            startActivity(intent)
        }
    }
}