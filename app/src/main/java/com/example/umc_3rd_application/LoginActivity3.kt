package com.example.umc_3rd_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.umc_3rd_application.databinding.ActivityLogin3Binding

class Login3Activity : AppCompatActivity() {

    //2023-01-14 현재 다른 기능들은 잘 구현이 되었지만
    //화면을 실행시 이 화면이 잘 구현되지 않는 문제가 있습니다.
    //이 오류를 고쳐야 할 것 같습니다.


    private var backPressedTime : Long = 0

    private lateinit var viewBinding : ActivityLogin3Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewBinding = ActivityLogin3Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        //'로그인 화면으로 이동' 버튼을 누르면, 로그인 화면으로 이동합니다.
        viewBinding.btnShift.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, loginactivity::class.java)
            startActivity(intent)
        })
    }
    override fun onBackPressed() {

        //뒤로가기 버튼을 2번 누르면, 앱이 완전히 종료됩니다.

        if (System.currentTimeMillis() - backPressedTime >= 2000) {
            backPressedTime = System.currentTimeMillis()
            Toast.makeText(this, "한번 더 누르시면 앱이 완전히 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            //앱을 완전히 종료시키는 코드입니다.
            finishAffinity();
            System.runFinalization();
            System.exit(0);
        }

    }

}