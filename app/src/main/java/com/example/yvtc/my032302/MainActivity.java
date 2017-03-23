package com.example.yvtc.my032302;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int s= -1;
    int tmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this); //設定框架
        builder.setTitle("對話框測試");
        builder.setMessage("測試");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {  //打完new 按O選擇後 即會跳出下方程式碼(onClick)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下確定");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {  //設定按下取消鍵
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下取消");
            }
        });
        builder.setNeutralButton("看說明", new DialogInterface.OnClickListener() { //第三顆按鍵
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下看說明");
            }
        });
        builder.show();
    }

    public void click2(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("輸入測試");
        final EditText ed = new EditText(MainActivity.this); //加入final 下面 ed.getText就不會有紅線
        final TextView tv = (TextView)findViewById(R.id.textView); //加入final 下面tv.setText 就不會有紅線
        builder.setMessage("請輸入訊息");
        builder.setIcon(android.R.drawable.ic_dialog_info); //加入圖示
        builder.setView(ed);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下確定");
                tv.setText(ed.getText().toString());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下取消");
            }
        });
        builder.show();
    }
    public  void click3(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("選項測試");
        final String fruit[] = getResources().getStringArray(R.array.fruits);
        tmp = s;
        builder.setSingleChoiceItems(R.array.fruits, s, new DialogInterface.OnClickListener() { //s預設-1代表一開始都不選
            @Override
            public void onClick(DialogInterface dialog, int which) {   //which 代表選第幾個
                tmp = which;   //tmp 表示暫時選什麼
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下確定");
                TextView tv = (TextView)findViewById(R.id.textView2);
                s=tmp;   //s表示真的選什麼
                tv.setText(fruit[s]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下取消");
            }
        });
        builder.show();
    }

    public void click4(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("列表");
        final String fruit[] = getResources().getStringArray(R.array.fruits);
        builder.setItems(R.array.fruits, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView tv3 =(TextView)findViewById(R.id.textView3);
                tv3.setText(fruit[which]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下取消");
            }
        });
        builder.show();
    }
}
