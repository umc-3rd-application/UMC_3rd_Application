package com.example.umc_3rd_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import com.example.umc_3rd_application.databinding.ActivityCreateProfile1Binding

class CreateProfile1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCreateProfile1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //1. 사진 추가 버튼을 눌렀을 때 갤러리로 이동해서 사진 선택할 수 있도록 함
        //2. 사진을 추가하면, 네모난 박스 안에 사진을 크롭해서 보이게끔 함
        //3. 성별 버튼을 누르면 색상이 바뀜
        //4. 거주지, 직업 버튼을 누르면 리스트가 뜸

        val add1data = arrayOf("서울특별시", "부산광역시", "대구광역시", "인천광역시", "대전광역시", "울산광역시", "세종특별자치시", "경기도", "강원도",
        "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주특별자치도")
        val add2data = arrayOf("고양시", "파주시")
        val job = arrayOf("학생", "군인", "사무직", "개발자", "공무원", "전문직", "개인사업자/자영업자", "자유직/프리랜서", "무직")
        //val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, add1data)

        // binding.spinnerAddress1.adapter = adapter

        //다음 화면 이동 버튼 비활성화
        binding.btnNext.isEnabled = false

       /* binding.editName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })*/

    }
}