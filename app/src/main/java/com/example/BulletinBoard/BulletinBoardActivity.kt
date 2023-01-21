package com.example.BulletinBoard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_3rd_application.R

class BulletinBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //게시판의 화면의 엑티비티입니다.

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bulletin_board)
    }
}