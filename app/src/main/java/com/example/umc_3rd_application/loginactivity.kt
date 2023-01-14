package com.example.umc_3rd_application

import android.content.Intent
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.HandlerCompat.postDelayed
import androidx.core.widget.addTextChangedListener

class loginactivity : AppCompatActivity() {

    private var backPressedTime : Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //로그인 부분을 구현하기 위한 엑티비티입니다.
        //1.회원 가입 버튼을 누르면 회원가입 화면으로 이동하고,
        //2.비밀번호 찾기 버튼을 누르면 비밀번호 찾기 화면으로 이동합니다.
        //3.아이디와 비밀번호를 입력하지 않았다면 로그인 부분의 색이 회색이고
        //정보를 입력했다면 로그인 버튼의 색이 바뀝니다.
        // 4.입력한 정보가 서버에 있다면 로그인을 눌렀을 시 홈 화면으로 이동합니다.
        //5.만약 아이디,비밀번호가 틀렸거나, 회원이 아니라면 로그인 오류 페이지를 출력합니다.
        //6.스플래쉬 화면(앱을 구동했을 때 가장 먼저 보이는 화면)이 끝나고 난 뒤 이 페이지를 보여줍니다.
        //7.만약, 한번 로그인을 한 상태이면 스플래쉬 화면 뒤에 바로 홈화면으로 이동합니다.
        //8.'설정'에서 '로그아웃'을 눌렀다면 로그아웃을 하고, 다시 로그인 화면으로 이동합니다.
        //9.뒤로 가기 버튼을 2번 눌렀을시 앱을 완전히 종료합니다.
        //10.1부터 9까지의 부분들은 관련 기능,페이지가 만들어졌을 때 연동해서 개발하는 것이 좋을 것 같습니다.
        //11.'회원가입' 버튼을 누르면 회원가입 페이지로 이동합니다.


        //수정사항(2023-01-11)
        //1.디자이너님께서 글꼴을 roboto를 적용하신다고 하셨는데, 제 노트북에서는 코드가 적용이 잘 되지 않는것 같습니다.
        //2.아이디나 비밀번호가 틀렸을 때 나오는 오류 메시지룰 추가해야 합니다. 이를 곧 추가하겠습니다.

        setContentView(R.layout.activity_loginactivity)


        //11.'회원가입' 버튼을 누르면 회원가입 페이지로 이동합니다.
        val movetoSignup = findViewById<TextView>(R.id.moveToSignUpActivity)
        movetoSignup.setOnClickListener{
            val intent = Intent(this,signUpActivity::class.java)
            Toast.makeText(this,"회원가입 페이지로 이동합니다.",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }


        //2.비밀번호 찾기 버튼을 누르면 비밀번호 찾기 화면으로 이동합니다.
        //EditText를 누르면 이동이 되도록 코드를 작성했습니다.
        val moveToFindPassword = findViewById<TextView>(R.id.movetoFindPassword)

        moveToFindPassword.setOnClickListener {

            val intent = Intent(this, findPassWordActivity::class.java)
            startActivity(intent)
        }


        //3.아이디와 비밀번호를 입력하지 않았다면 로그인 부분의 색이 회색이고
        //아이디를 입력했다면 로그인 버튼의 색이 바뀝니다.


        //객체를 생성합니다.
        val loginBtn =findViewById<Button>(R.id.loginButton)
        val writeid =findViewById<EditText>(R.id.writeId)
        val writepassword =findViewById<EditText>(R.id.writePassword)

        //메시지를 담을 변수를 생성합니다.
        var idMessage : String =""
        var pwMessage : String =""

        //버튼을 비활성화합니다.
        loginBtn.isEnabled = false

        //EditText 값이 있을 때만 버튼을 활성화합니다.
        writeid.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            //값 변경시 실행되는 함수이다.
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                //입력값 담기
                idMessage = writeid.text.toString()
                pwMessage = writepassword.text.toString()

                //값 유무에 따른 활성화여부

                loginBtn.isEnabled = idMessage.isNotEmpty()
                if(loginBtn.isEnabled==true)
                {
                    loginBtn.setBackgroundColor(Color.parseColor("#8071d9"))
                }




            }

            override fun afterTextChanged(p0: Editable?) {}


        }

        )







        //9.뒤로 가기 버튼을 2번 눌렀을시 앱을 종료합니다.
        //또한, 로그인화면 좌측상단의 버튼을 눌렀을 때도 종료시킨다.

        val loginactivityBackButton = findViewById<ImageButton>(R.id.loginBackButton)
        loginactivityBackButton.setOnClickListener{
            finish()
        }

    }
    //9.뒤로 가기 버튼을 2번 눌렀을시 앱을 완전히 종료합니다.
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
