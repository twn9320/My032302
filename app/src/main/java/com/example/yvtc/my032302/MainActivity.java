package com.example.yvtc.my032302;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this); //設定框架
        builder.setTitle("對話框測試");
        builder.setMessage("測試");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {  //設定按下確認鍵
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
}
