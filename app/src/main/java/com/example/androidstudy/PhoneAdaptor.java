package com.example.androidstudy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidstudy.model.Member;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdaptor extends ArrayAdapter<Member> {
    private Context context;
    private ArrayList<Member> list ;
    private int resId;

    public PhoneAdaptor(@NonNull Context context, int resource, @NonNull List<Member> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = (ArrayList<Member>)objects;
        this.resId = resource;
    }

    @NonNull
    @Override // position 위치의 데이터를 읽어와서 리소스로 지정한 뷰로 생성하여 반환
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if(itemView==null){
            //LayoutInflater : xml을 실제 객체로 만들어줌
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //뷰로 연결
            itemView = vi.inflate(resId, null);



        }
        final Member m = list.get(position);
        if(m!=null){
            TextView t1 = (TextView) itemView.findViewById(R.id.textView);
            TextView t2 = (TextView) itemView.findViewById(R.id.textView2);
            ImageView imgv = itemView.findViewById(R.id.Item_imageView);
            //imgv.setImageResource(R.drawable.ic_launcher_foreground);
            Button sms = itemView.findViewById(R.id.button18);
            Button call = itemView.findViewById(R.id.button19);
            if(t1 != null){
                t1.setText(m.getName());
            }
            if(t2 != null){
                t2.setText(m.getTel());
            }
            if(imgv != null){
                imgv.setImageResource(m.getImgRes());
            }
            call.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+m.getTel()));
                    context.startActivity(intent);
                }
            });
        }
        return itemView;
    }

}
