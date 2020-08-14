package com.example.androidstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.androidstudy.model.Member;

public class ActivityGoAndBack extends AppCompatActivity {
    private EditText name_et;
    private EditText tel_et;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_and_back);
        name_et = findViewById(R.id.et2);
        tel_et = findViewById(R.id.et3);

        intent = getIntent();
        Member m = (Member)intent.getSerializableExtra("m");
        name_et.setText(m.getName());
        tel_et.setText(m.getTel());
    }

    public void onGoBack(View view){
        Member m = new Member();
        m.setName(name_et.getText().toString());
        m.setTel(tel_et.getText().toString());
        intent.putExtra("m",m);
        setResult(RESULT_OK,intent);
        finish();
    }
}