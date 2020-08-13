package com.example.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

enum inputType{
    NUMBER,
    OPERATOR,
    NOTHING
}

public class Sub1Activity extends AppCompatActivity {
    private EditText result;
    private ArrayList<Integer> numberList;
    private ArrayList<Character> operatorList;
    private inputType beforeType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        result = findViewById(R.id.result);
        numberList = new ArrayList<Integer>();
        operatorList = new ArrayList<Character>();
        beforeType = inputType.NOTHING;
    }
    public void myEval(String str){
        result.setText(Character.toString(str.charAt(0)));
    }
    public void onClickbtnNum(View view){
        Button b = (Button)view;
        String numText = result.getText() + b.getText().toString();
        int cur_index = numberList.size()-1;
        int curNum = Integer.parseInt(numText);

        if(beforeType == inputType.NUMBER){
            int befNum = numberList.get(cur_index);
            curNum = befNum*10 + curNum;
            numberList.set(cur_index,curNum);
        }else{
            numberList.add(curNum);
        }
        result.setText( numText );
    }
    public void onClickbtnOper(View view){
        Button b = (Button)view;
        String numOper = result.getText() + b.getText().toString();
        int cur_index = operatorList.size()-1;
        
    }
    public void onClickbtnEqual(View view){
        onClickbtnNum(view);
        Button b = (Button)view;
        myEval(b.getText().toString());

    }
    public void onClickC(View view){
        result.setText("");
    }
}