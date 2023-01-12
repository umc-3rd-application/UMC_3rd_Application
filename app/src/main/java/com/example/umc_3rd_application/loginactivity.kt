package com.example.umc_3rd_application

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class loginactivity : AppCompatActivity() {

    private var waitTime =0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //로그인 부분을 구현하기 위한 엑티비티입니다.
        //1.회원 가입 버튼을 누르면 회원가입 화면으로 이동하고,
        //2.비밀번호 찾기 버튼을 누르면 비밀번호 찾기 화면으로 이동합니다.
        //3.아이디와 비밀번호를 입력하지 않았다면 로그인 부분의 색이 회색이고
        //정보를 입력했다면 로그인 버튼의 색이 바뀝니다.
        // 4.입력한 정보가 서버가 있다면 로그인을 눌렀을 시 홈 화면으로 이동합니다.
        //5.만약 아이디,비밀번호가 틀렸거나, 회원이 아니라면 로그인 오류 페이지를 출력합니다.
        //6.스플래쉬 화면(앱을 구동했을 때 가장 먼저 보이는 화면)이 끝나고 난 뒤 이 페이지를 보여줍니다.
        //7.만약, 한번 로그인을 한 상태이면 스플래쉬 화면 뒤에 바로 홈화면으로 이동합니다.
        //8.'설정'에서 '로그아웃'을 눌렀다면 로그아웃을 하고, 다시 로그인 화면으로 이동합니다.
        //9.뒤로 가기 버튼을 2번 눌렀을시 앱을 종료합니다.
        //10.1부터 9까지의 부분들은 관련 기능,페이지가 만들어졌을 때 연동해서 개발하는 것이 좋을 것 같습니다.

        //수정사항(2023-01-11)
        //1.디자이너님께서 글꼴을 roboto를 적용하신다고 하셨는데, 제 노트북에서는 코드가 적용이 잘 되지 않는것 같습니다.
        //2.아이디나 비밀번호가 틀렸을 때 나오는 오류 메시지룰 추가해야 합니다. 이를 곧 추가하겠습니다.











        setContentView(R.layout.activity_loginactivity)
        onBackPressed()
        //3.아이디와 비밀번호를 입력하지 않았다면 로그인 부분의 색이 회색이고
        //정보를 입력했다면 로그인 버튼의 색이 바뀝니다.

        //20230111 21시 11분 현재 이 부분이 잘 안되네요.
        var loginBtn =findViewById<Button>(R.id.btn_next)
        var wirteid =findViewById<EditText>(R.id.writeId)
        var wirtepassword =findViewById<EditText>(R.id.writePassword)
        //만약 아이디와 비밀번호를 다 적었다면
        //setbackgroundcolor를 통해 버튼의 색을 바꾼다.
        if(wirteid.toString()!=null && wirtepassword.toString()!=null)
        {
            loginBtn.setBackgroundColor(Color.parseColor("#d3d3d3"))
        }
        //만약 위의 조건을 만족하지 못한다면, 다시 색이 원상 복귀된다ㅁㄴ.
        else
        {
            loginBtn.setBackgroundColor(Color.parseColor("#8071d9"))

        }

        //9.뒤로 가기 버튼을 2번 눌렀을시 앱을 종료합니다.
        //또한, 로그인화면 좌측상단의 버튼을 눌렀을 때도 종료시킨다.

        var loginactivityBackButton = findViewById<ImageButton>(R.id.loginBackButton)
        loginactivityBackButton.setOnClickListener{
            finish()//엑티비티 종료
            //로그인 화면의 좌측상단의 버튼을 1번 누르면 종료시킨다.
            //toast 메시지는 넣지 않았습니다.
        }



    }

    //9.뒤로 가기 버튼을 2번 눌렀을시 앱을 종료합니다.
    //또한, 로그인화면 좌측상단의 버튼을 눌렀을 때도 종료시킨다.

    override fun onBackPressed() {
        if(System.currentTimeMillis() - waitTime >=1500 ) {
            waitTime = System.currentTimeMillis()
            Toast.makeText(this,"뒤로가기 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show()
        } else {
            finish() // 액티비티 종료
        }
}
}