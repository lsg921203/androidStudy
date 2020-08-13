package com.example.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//savedInstanceState 사용자가 입력하던 정보같은거 받아옴
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main 에 있는 내용대로 View 객체로 만들어서
                                                // 화면을 구성해라
        tv = findViewById(R.id.tv1);
    }
    public void onBtnClick(View view){
        Button b = (Button)view;
        String text = b.getText().toString();
        tv.setText(text);

    }
    public void onBtn1Click(View view){
        onBtnClick(view);
        Toast.makeText(MainActivity.this, "button1 click", Toast.LENGTH_SHORT).show();
    }
    public void onBtn2Click(View view){
        onBtnClick(view);
        Toast.makeText(MainActivity.this, "button2 click", Toast.LENGTH_SHORT).show();
    }
    public void onBtn3Click(View view){
        onBtnClick(view);
        Toast.makeText(MainActivity.this, "button3 click", Toast.LENGTH_SHORT).show();
    }
}