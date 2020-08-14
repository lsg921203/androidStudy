package com.example.androidstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidstudy.model.Member;

public class NextPage1Activity extends AppCompatActivity {
    private TextView msg;
    private TextView num;
    private TextView member;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page1);
        msg = findViewById(R.id.textView4);
        num = findViewById(R.id.textView5);
        member = findViewById(R.id.textView6);

        intent = getIntent();
        String m = intent.getStringExtra("msg");
        int n = intent.getIntExtra("number",0);
        Member mm = (Member)intent.getSerializableExtra("m");

        msg.setText(m);
        num.setText(n+"");
        member.setText(mm.toString());
    }
}