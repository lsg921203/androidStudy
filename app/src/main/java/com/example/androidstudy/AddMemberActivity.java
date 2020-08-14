package com.example.androidstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidstudy.model.Member;

import java.util.ArrayList;

public class AddMemberActivity extends AppCompatActivity {
    private Intent intent;
    private TextView name;
    private TextView tel;
    private RadioGroup radioGroup;
    private ImageView imageView;
    private Spinner spinner;
    private Button button;
    private ArrayList<String> list;
    private ArrayList<Integer> list2;
    private ArrayAdapter<String> aa;
    private int PhoneType;
    private int imageIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        intent = getIntent();
        name = findViewById(R.id.AddMember_EditText_Name);
        tel = findViewById(R.id.AddMember_EditText_Tel);
        radioGroup = findViewById(R.id.AddMember_RadioGroup);
        imageView = findViewById(R.id.AddMember_imageView);
        spinner = findViewById(R.id.AddMember_spinner);
        button = findViewById(R.id.AddMember_AddButton);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                PhoneType=0;
                switch (i){
                    case R.id.AddMember_Radio_CellPhone:
                        PhoneType = 1;
                        break;
                    case R.id.AddMember_Radio_HomePhone:
                        PhoneType = 2;
                        break;
                    case R.id.AddMember_Radio_JobPhone:
                        PhoneType = 3;
                        break;
                }
                //Toast.makeText(AddMemberActivity.this, PhoneType, Toast.LENGTH_SHORT).show();
            }
        });
        list = new ArrayList<>();
        list.add("soodal");
        list.add("fire_extinguisher");
        list.add("img1");
        list.add("img2");
        list.add("img3");
        list.add("img4");
        list.add("img5");
        list.add("img6");

        list2 = new ArrayList<>();

        list2.add(R.drawable.soodal);
        list2.add(R.drawable.fire_extinguisher);
        list2.add(R.drawable.img1);
        list2.add(R.drawable.img2);
        list2.add(R.drawable.img3);
        list2.add(R.drawable.img4);
        list2.add(R.drawable.img5);
        list2.add(R.drawable.img6);

        aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,list);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AddMemberActivity.this,list.get(i),Toast.LENGTH_SHORT).show();
                imageView.setImageResource(list2.get(i));
                imageIndex = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(AddMemberActivity.this, "선택된항목없음",Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void onClickAddButton(View view){
        Member m = new Member();
        String n = name.getText().toString();
        String t = tel.getText().toString();
        Integer img = list2.get(imageIndex);
        int type = PhoneType;
        m.setName(n);
        m.setTel(t);
        m.setImgRes(img);
        m.setPhoneType(type);
        intent.putExtra("m",m);
        setResult(RESULT_OK,intent);
        finish();
    }
}