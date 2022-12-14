package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Thongtin> arrayList;
    Adapter adapter;
    private Button buttonpro,btn_lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = (ListView) findViewById(R.id.listviewtt);
        arrayList = new ArrayList<>();
        arrayList.add(new Thongtin( "Đinh Văn Nơi","Quân hàm: Đại tá","Nơi công tác : Tỉnh Quảng Ninh","Số sao quốc gia tín nhiệm : 5 sao",R.drawable.dvn));
        arrayList.add(new Thongtin( "Nguyễn Thị Diện","Quân hàm: Trung Úy","Nơi công tác : Thủ đô Hà Nội","Số sao quốc gia tín nhiệm : 3 sao",R.drawable.ntd));
        arrayList.add(new Thongtin( "Hoàng Thị Linh Chi","Quân hàm: Học Viên","Nơi công tác :Thủ đô Hà Nội","Số sao quốc gia tín nhiệm : Chưa được cấp sao",R.drawable.htlc));
        adapter = new Adapter( MainActivity.this,R.layout.activity_layoutlistview, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,ListView1.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,ListView2.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,ListView3.class);
                    startActivity(intent);
                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {

                deleteData(position);
                return false;
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        switch (item.getItemId()){
            case R.id.profile:
                Intent  intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
                return true;

            default:return  super.onOptionsItemSelected(item);
        }

    }
    private void deleteData(int position){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Delete")
                .setMessage("Bạn có muốn xóa k?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        arrayList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancel",null)
                .show();

    }



}