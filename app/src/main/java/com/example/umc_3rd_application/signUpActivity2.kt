package com.example.umc_3rd_application

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.umc_3rd_application.databinding.ActivitySignUp2Binding


class signUpActivity2 : AppCompatActivity() {
    private var backPressedTime : Long = 0
    private lateinit var binding : ActivitySignUp2Binding
    var ConfirmButton : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)
        binding = ActivitySignUp2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //2023-01-14
        //구현방법
        //1.개인정보 이용방침은, 개인정보 이용방침을 따로 만들어서, 블로그 같은 곳에 올립니다,
        //그런 다음, 버튼을 만들어서 버튼을 누르면 개인정보 이용방침을 볼 수 있는 링크로 이동하는 식으로 구현합니다.
        //2.본인인증
        //우선 전화번호를 입력하고, '인증번호 발송'버튼을 누릅니다.
        //이 때, 전화번호를 입력하지 않으면 '인증번호 발송'버튼은 활성화 되지 않습니다.
        //3. 1과 2를 다 완료해야지만 회원가입 완료가 되게 signUpActivity2를 코딩합니다.


        //그 외
        //개인정보 이용방침을 만드는 것은 생각보다 간편합니다.
        //(구글 검색창에  '안드로이드 개인정보 이용방침 만들기'를 검색해 보시면 됩니다.)
        //단, 이 부분을 팀원분들과 공유해야 할것 같습니다. 그래서 1월 2째주 초반에 이 안건을 단톡방에 올릴 예정입니다.
        //또한 아직 기능이 구현되지 않은 부분은 서버쪽에서 작업이 완료되면 그 때 기능을 구현할 생각입니다.

        //1.개인정보 이용방침은, 개인정보 이용방침을 따로 만들어서, 블로그 같은 곳에 올립니다,
        //그런 다음, 버튼을 만들어서 버튼을 누르면 개인정보 이용방침을 볼 수 있는 링크로 이동하는 식으로 구현합니다.

        //버튼을 누르면 해당 사이트로 이동하도록 합니다.
        binding.goToTheLinkButton.setOnClickListener {
            ConfirmButton++//버튼을 누르면 1을 추가합니다.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"))
            startActivity(intent)
        }



        //뒤로 가기 버튼을 누르면 이전 페이지로 이동하게 합니다.
        binding.btnBackSignup2.setOnClickListener{
            val intent = Intent(this,signUpActivity::class.java)
            Toast.makeText(this,"이전 페이지로 이동합니다.",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }

        //2.본인인증
        //우선 전화번호를 입력하고, '인증번호 발송'버튼을 누릅니다.
        //이 때, 전화번호를 입력하지 않으면 '인증번호 발송'버튼은 활성화 되지 않습니다.



        //회원가입 완료에 대한 버튼의 객체를 생성합니다.
        binding.FinishSignUpButton.setOnClickListener{

            if(ConfirmButton==1)
            { val intent = Intent(this,CreateProfile1::class.java)
            Toast.makeText(this,"회원가입이 완료되었습니다.",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }
            else
            {
                Toast.makeText(this,"개인정보 이용약관을 읽어주세요.",Toast.LENGTH_LONG).show()

            }
        }


    }

    override fun onBackPressed() {

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