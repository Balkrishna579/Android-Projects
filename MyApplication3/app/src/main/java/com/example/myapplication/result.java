package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class result extends AppCompatActivity {
    int score,total,attm;
    long tim;
    TextView totq,attq,wroq,cooq,tos,tot;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent in=getIntent();
        attm=in.getIntExtra("att",0);
        score=in.getIntExtra("score",0);
        total=in.getIntExtra("ques",0);
        tim=in.getLongExtra("time",0);
        String sgh=in.getStringExtra("title");
        totq=findViewById(R.id.textView3);
        attq=findViewById(R.id.textView4);
        wroq=findViewById(R.id.textView5);
        cooq=findViewById(R.id.textView6);
        tos=findViewById(R.id.textView7);
       tot=findViewById(R.id.textView8);
       btn=findViewById(R.id.home);
        Toolbar toll=findViewById(R.id.toolbar02);
        setSupportActionBar(toll);
        getSupportActionBar().setTitle(String.valueOf(sgh));


        totq.setText(String.valueOf(total));
        attq.setText(String.valueOf(attm));
        wroq.setText(String.valueOf(attm-score));
        cooq.setText(String.valueOf(score));
        tos.setText(String.valueOf(score));
        int h= (int) (tim/(1000*60*60));
        int m=(int)((tim/(1000*60))%60);
        int s=(int)((tim/1000)%3600);
        String sb=h+": "+m+": "+s;
        tot.setText(String.valueOf(sb));
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getonmain();
           }
       });

    }

    private void getonmain() {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}