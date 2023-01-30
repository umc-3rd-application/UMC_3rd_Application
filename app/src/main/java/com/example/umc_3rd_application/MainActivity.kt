package com.example.umc_3rd_application


import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import java.security.MessageDigest


class MainActivity : AppCompatActivity() {

    //MainActivity와 같은 위치에 GlobalApplication이라는 kotlin class파일을 생성해준다.
    //참고 사이트:https://vanillacreamdonut.tistory.com/200
    //https://yunaaaas.tistory.com/86
    //https://dotiromoook.tistory.com/3
    //https://velog.io/@dlghgus5656/kotlin%EC%9C%BC%EB%A1%9C-Android-Kakao-Login%EC%B9%B4%EC%B9%B4%EC%98%A4-%EB%A1%9C%EA%B7%B8%EC%9D%B8-api-%ED%99%9C%EC%9A%A9
    //변경된 부분은 위의 참고 사이트를 통해 만들어졌음을 알려드립니다.
    class GlobalApplication : Application() {

        //클래스에서 초기화를 해 줍니다.
        override fun onCreate() {
            super.onCreate()
            KakaoSdk.init(this, "19beb4ca9314c6542224fbc105a5b668")
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //2023-01-30 : keyHash를 구하기 위한 코드들입니다.
        //보안상 이유로 일단은 주석 처리를 했습니다.
       // val keyHash= Utility.getKeyHash(this)
       // Log.e("Key","keyhash: $keyHash")
       // getAppKeyHash()



        //2023-01-30
        //카카오 로그인을 위한 클래스를 작성해 보겠습니다.
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
            }
            else if (tokenInfo != null) {
                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                //토큰 정보 보기를 성공하면(유저 정보가 존재할 경우) 다른 페이지로 페이지를 이동시킨다.
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        //로그인 시도 후 사용하는 callback
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                when {
                    error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                        Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                        Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.ServerError.toString() -> {
                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                        Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                    }
                    else -> { // Unknown
                        Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else if (token != null) {
                Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, loginactivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }
        val kakao_login_button = findViewById<ImageButton>(R.id.kakaologin) // 로그인 버튼
        kakao_login_button.setOnClickListener {
            //카카오톡이 설시되어 있으면 카카오톡으로 로그인, 아니라면 카카오계정으로 로그인
            if(UserApiClient .instance.isKakaoTalkLoginAvailable(this)){
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
            }else{
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }

        //2023-01-12
        //현재는 mainactivity에서 할 일이 없기 때문에, hello world 버튼을 누르면 loginactivity로 이동하는 코드만 작성하도록 하겠습니다.
        val mainButton = findViewById<Button>(R.id.mainActivityButton)
        mainButton.setOnClickListener {

            val intent = Intent(this, loginactivity::class.java)
            startActivity(intent)
        }



    }

    //2023-01-30
    //해시 키를 받기 위한 코드입니다.
    private fun getAppKeyHash() {
        try {
            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                var md: MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val something: String = String(Base64.encode(md.digest(), 0))
                Log.e("Hash key", something)
            }
        } catch (e: Exception) {
            // TODO Auto-generated catch block
            Log.e("name not found", e.toString())
        }
    }
}