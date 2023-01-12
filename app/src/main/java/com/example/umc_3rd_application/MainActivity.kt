package com.example.umc_3rd_application


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //2022-01-12
        //현재는 mainactivity에서 할 일이 없기 때문에, hello world 버튼을 누르면 loginactivity로 이동하는 코드만 작성하도록 하겠습니다.
        val mainButton = findViewById<Button>(R.id.mainActivityButton)
        mainButton.setOnClickListener {

            val intent = Intent(this, loginactivity::class.java)
            startActivity(intent)
        }

    }
}