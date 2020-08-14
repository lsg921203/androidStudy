package com.example.androidstudy;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidstudy.model.Member;

import java.util.ArrayList;

public class Activity_0814_Main extends AppCompatActivity {
    private Spinner spinner;
    private ImageView imageView;
    private ArrayList<String> list;
    private ArrayList<Integer> list2;
    private ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0814__main);
        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView2);
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
                Toast.makeText(Activity_0814_Main.this,list.get(i),Toast.LENGTH_SHORT).show();
                imageView.setImageResource(list2.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Activity_0814_Main.this, "선택된항목없음",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onGoActivity(View view){
        Intent intent = new Intent(this, AddMemberActivity.class);
        intent.putExtra("msg","helloAndroid");
        intent.putExtra("number",7);
        Member m = new Member("aaa","111",R.drawable.fire_extinguisher,1);
        intent.putExtra("m", m);
        startActivity(intent);

    }
    public void onGoActivityGoAndBack(View view){
        Intent intent = new Intent(this,ActivityGoAndBack.class);
        Member m = new Member("bbb","222",R.drawable.fire_extinguisher,1);
        intent.putExtra("m", m);
        startActivityForResult(intent,1);//requestCode: 어느 엑티비티에 다녀왔는지 표시
    }
    //startActivityForResult오 다른 액티비티에 다녀오면 자동호출됨. 다녀온 액티비티 처리결과를 현재 액티비티에 적용
    //requestCode: 어느 엑티비티에 다녀왔는지 표시
    //resultCode:다녀온 액티비티의 처리결과가 정상인지 확인
    //data: 다녀온 액티비티 쪽에서 처리결과를 담아 보낸 인텐트
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case 1:
                    Member m = (Member) data.getSerializableExtra("m");
                    Toast.makeText(this,m.toString(),Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}