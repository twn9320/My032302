package com.example.yvtc.my032302;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.yvtc.my032302.R.id.button;

public class MainActivity extends AppCompatActivity {
    int s= -1;
    int tmp;
    boolean chks[] = new boolean[4];
    boolean tmpchk[]=new boolean[4];
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
                if(tmp>-1){
                    TextView tv = (TextView)findViewById(R.id.textView2);
                    s=tmp;   //s表示真的選什麼
                    tv.setText(fruit[s]);
                }
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

    public void click5(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選測試");
        final String fruit[] = getResources().getStringArray(R.array.fruits);
        tmpchk = chks.clone();  // 將chks陣列存到tmpchk陣列
        builder.setMultiChoiceItems(R.array.fruits, tmpchk, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下確定");
                StringBuilder sb = new StringBuilder();  //用來累加字串的類別
                int i ;
                chks = tmpchk.clone();
                for(i=0;i<fruit.length;i++){
                    if(chks[i]){
                        sb.append(fruit[i]+" ");  //append用來累加字串到sb
                    }
                }
                TextView tv4 = (TextView)findViewById(R.id.textView4);
                tv4.setText(sb.toString());
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

    public void click6(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("自訂測試");

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View mv= inflater.inflate(R.layout.custom_dialog_layout,null);

        Button btn = (Button) mv.findViewById(R.id.button6);
        final TextView tv5 = (TextView) mv.findViewById(R.id.textView5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv5.setText("Hello World");
            }
        });
        builder.setView(mv);

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG","使用者按下取消");
            }
        });
        builder.show();
    }

    public void click7(View v){
        final ProgressDialog pd = new ProgressDialog(MainActivity.this);
        pd.setTitle("進度框");
        pd.setCancelable(false);
        pd.setMessage("請稍後..");
        pd.show();
        new Thread(){     //多執行緒  使進度顯示三秒後自動消失
            public void run(){      /*通常會用在資料擷取時*/
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pd.dismiss();
            }
        }.start();
    }
}
