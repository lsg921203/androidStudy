package com.example.androidstudy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidstudy.model.Member;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ArrayList<Member> datas;
    private ArrayAdapter<Member> aa;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.lv1);

        datas = new ArrayList<Member>();

        // android.R.layout.simple_list_item_1: 안드로이드에서 제공하는 api
        aa = new PhoneAdaptor(this,R.layout.item_layout, datas);
        listView.setAdapter(aa);
        //이벤트 리스너 : 이벤트가 발생했는가 기다렸다가 발생하면 핸들러 호출
        //setOnItemClickListener: 리스너를 view에 붙여줌
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Member m = datas.get(i);
                String s = m.getName() + "/" + m.getTel();
                Toast.makeText(ListViewActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });
        registerForContextMenu(listView);
    }
    public void onAdd(View view){

        Intent intent = new Intent(this,AddMemberActivity.class);
        startActivityForResult(intent,1);//requestCode: 어느 엑티비티에 다녀왔는지 표시
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,Menu.FIRST,0,"add");
        menu.add(0,Menu.FIRST+1,0,"delete");
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(ListViewActivity.this,"option menu:add",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(ListViewActivity.this,"option menu:delete",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("UPDATE");
        menu.add(0,Menu.FIRST,0,"edit");
        menu.add(0,Menu.FIRST+1,0,"delete");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int idx = info.position;// info.position : 리스트의 몇 번째 인지 알려줌

        switch(item.getItemId()){
            case 1:
                //edit 창 추가
                Toast.makeText(ListViewActivity.this,"option menu:edit",Toast.LENGTH_SHORT).show();
                break;
            case 2:

                datas.remove(idx);
                aa.notifyDataSetChanged();//데이터 갱신 -> 뷰 갱신
                Toast.makeText(ListViewActivity.this,"삭제됨",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case 1:
                    Member m = (Member) data.getSerializableExtra("m");

                    datas.add(m);
                    aa.notifyDataSetChanged();//데이터 갱신 -> 뷰 갱신
                    break;
            }
        }
    }
}