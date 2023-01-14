package com.example.umc_3rd_application

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class findPassWordActivity : AppCompatActivity() {

    //2번 클릭에 관한 함수.
    private var backPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //2022-01-12 21:40 업데이트

        //'비밀번호 찾기' 의 엑티비티입니다.
        //1.로그인 화면의 '비밀번호 찾기'를 누르면 '비밀번호 찾기'로 이동하는 것을 구현합니다.
        //2.이메일을 적어야 '다음'버튼이 활성화되는 것을 구현합니다.
        //3.뒤로가기 아이콘을 2번 누르면 로그인화면으로 이동합니다.
        //4.'다음' 버튼을 누르면 '이메일이 발송되었습니다'라는 화면으로 이동합니다.


        //1.로그인 화면의 '비밀번호 찾기'를 누르면 '비밀번호 찾기'로 이동하는 것을 구현합니다.(loginactivity에 구현했습니다.)

        setContentView(R.layout.activity_find_pass_word)






        //2.이메일을 적어야 '다음'버튼이 활성화되는 것을 구현합니다.
        //객체를 생성합니다.

        val writeid =findViewById<EditText>(R.id.findPasswordwriteId)
        val nextbutton = findViewById<Button>(R.id.findPasswordNextButton)

        //메시지를 담을 변수를 생성합니다.
        var idMessage : String = " "


        //버튼을 비활성화합니다.
        nextbutton.isEnabled = false

        //EditText 값이 있을 때만 버튼을 활성화합니다.
        writeid.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            //값 변경시 실행되는 함수이다.
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                //입력값 담기
                idMessage = writeid.text.toString()


                //값 유무에 따른 활성화여부
                //이메일은 1글자 이상만 적으면 enabled가 되도록 설정했습니다. 더 정확하게 구현할 수 있는 방법을 찾으면 좋겠네요.
                nextbutton.isEnabled = idMessage.isNotEmpty()
                if(nextbutton.isEnabled==true)
                {
                    nextbutton.setBackgroundColor(Color.parseColor("#8071d9"))
                }




            }

            override fun afterTextChanged(p0: Editable?) {}


        }

        )




        //3.뒤로가기 아이콘을 누르면 로그인화면으로 이동합니다.
        val goback = findViewById<ImageButton>(R.id.loginBackButton)

        goback.setOnClickListener{
            val intent = Intent(this, loginactivity::class.java)
            Toast.makeText(this,"로그인 화면으로 이동합니다.",Toast.LENGTH_LONG).show()
            startActivity(intent)

        }

        //4.'다음' 버튼을 누르면 '이메일이 발송되었습니다'라는 화면으로 이동합니다.
        nextbutton.setOnClickListener{
            Log.e("aaaa","aaaa")
            val intent = Intent(this,Login3Activity::class.java)
            startActivity(intent)
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
