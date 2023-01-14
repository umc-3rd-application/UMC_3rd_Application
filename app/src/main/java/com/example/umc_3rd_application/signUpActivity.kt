package com.example.umc_3rd_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.umc_3rd_application.databinding.ActivitySignUpBinding

class signUpActivity : AppCompatActivity() {
    private var backPressedTime : Long = 0
    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)



        //0.서버 파트에서 관련 부분을 개발을 완료하면, 그 때 이 부분이 완성될 예정입니다.
        //1.디자이너님께서 일정상 문제가 생기셔서, 일단 디자인은 신경쓰지 않고 기능을 구현하는 것을 중점으로 삼았습니다.
        //2.4가지 항목을 다 입력해야 '다음'으로 넘어가도록 설정했습니다.
        //3.비밀번호 입력과 비밀번호 확인이 같지 않으면 넘어가지 않도록 설정할 것입니다.
        //4.비밀번호가 10자 이상이 아니면 '다음'으로 넘어가지 않도록 설정할 것입니다.


        //각 객체를 정의합니다.
        //이 때, binding을 통해 정의를 하면 더 빠르게 정의가 됩니다.



        






        binding.SingUpGoToTheNextButton.setOnClickListener {

            val email = binding.writeNameView3.text!!.toString()
            val password = binding.writeNameView2.text!!.toString()
            val passwordverify = binding.writeNameView4.text!!.toString()
            val name = binding.writeNameView.text!!.toString()

//조건들을 검사할 수 있는 int var 변수를 하나 만듭니다.
            //원래는 boolean 타입으로 정의를 해서 true/false로 판별을 하려 했으나, 이상하게 오류가 떠서 int로 변경했습니다.
            var isGoToNext: Int = 1

            //만약 이름이 비어있다면
            if(name.isEmpty()){

                isGoToNext = 0
            }
            //만약 이메일이 비어있다면
            if(email.isEmpty()){

                isGoToNext = 0
                }
            //만약 비밀번호입력이 비어있다면
            if(password.isEmpty()){

                isGoToNext = 0
                }
            //만약 비밀번호확인이 비어있다면
            if(passwordverify.isEmpty()){

                isGoToNext = 0
                 }

            //비밀번호 입력과 비밀번호 확인이 같은지 같지 않은지 확인합니다.
            if(password.equals(passwordverify))
            {

                isGoToNext = 1

            }
            else{

                isGoToNext = 0

            }
            //비밀번호는 10자리 이상으로 입력하게끔 유도합니다.
            if(password.length<10)
            {
                isGoToNext = 0
            }
            //위의 모든 조건을 만족했을시, 다음 엑티비티로 이동합니다.
            if(isGoToNext==1)
            {
                val intent = Intent(this,signUpActivity2::class.java)
                Toast.makeText(this,"다음 단계로 이동합니다.",Toast.LENGTH_LONG).show()
                startActivity(intent)

            }
            //위의 조건을 불만족했을시, 이동하지 않고,메시지를 띄웁니다.
            else
            {
                //만약 이름이 비어있다면
                if(name.isEmpty()){
                    Toast.makeText(this,"이름을 입력해주세요.",Toast.LENGTH_LONG).show()

                }
                //만약 이메일이 비어있다면
                if(email.isEmpty()){
                    Toast.makeText(this,"이메일(아이디)을 입력해주세요.",Toast.LENGTH_LONG).show()

                }
                //만약 비밀번호입력이 비어있다면
                if(password.isEmpty()){
                    Toast.makeText(this,"비밀번호를 입력해주세요.",Toast.LENGTH_LONG).show()

                }
                //만약 비밀번호확인이 비어있다면
                if(passwordverify.isEmpty()){
                    Toast.makeText(this,"비밀번호 확인을 입력해주세요.",Toast.LENGTH_LONG).show()

                }

                //비밀번호 입력과 비밀번호 확인이 같은지 같지 않은지 확인합니다.
                if(!password.equals(passwordverify))
                {
                    Toast.makeText(this,"비밀번호 똑같이 입력해주세요.",Toast.LENGTH_LONG).show()

                }
                //비밀번호는 10자리 이상으로 입력하게끔 유도합니다.
                if(password.length>9)
                {
                    Toast.makeText(this,"비밀번호는 10자 이상으로 입력해주세요.",Toast.LENGTH_LONG).show()


                }
            }


        }
        setContentView(binding.root)
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