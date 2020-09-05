package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import  androidx.appcompat.widget.Toolbar;

public class test extends AppCompatActivity {
    RadioGroup rgp;
    welcome db;
    note t;
    long id;
    int k=0;
    TextView que;
    Button btn,btn1,btn2;
    RadioButton rb1,rb2,rb3,rb4;
    int ans;
    int f=0;
    ArrayList<Integer> score=new ArrayList<>();
    int choose;
    long t1=0,t2=0;
    Date date1,date2;
    int a[];
    int df=0;

List<question> ques;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent i=getIntent();
       id= i.getLongExtra("quesset",0);
        rgp=findViewById(R.id.radioGroup);
        rgp.clearCheck();
        db=new welcome(this);
        t=db.getnote(id);
        ques=db.getques(id);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(t.getTitle());
        que=findViewById(R.id.textView);
        que.setText(String.valueOf(ques.get(k).getQues()));
         rb1=findViewById(R.id.radioButton4);
         rb2=findViewById(R.id.radioButton3);
         rb3=findViewById(R.id.radioButton2);
       rb4=findViewById(R.id.radioButton);
        btn=findViewById(R.id.button3);
        btn1=findViewById(R.id.button4);
        btn2=findViewById(R.id.button5);
        rb1.setText(String.valueOf(ques.get(k).getOption1()));
        rb2.setText(String.valueOf(ques.get(k).getOption2()));
        rb3.setText(String.valueOf(ques.get(k).getOption3()));
        rb4.setText(String.valueOf(ques.get(k).getOption4()));
        ans= Integer.parseInt(ques.get(k).getAnswer());
        a=new  int[ques.size()];


        t1=System.currentTimeMillis();


        if(k<ques.size() && k>0){
            btn2.setVisibility(View.VISIBLE);
        }
        else {
            btn2.setVisibility(View.INVISIBLE);
        }
        if(k<ques.size()-1 && k>=0){
            btn.setVisibility(View.VISIBLE);
        }
        else{
            btn.setVisibility(View.INVISIBLE);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sstque();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrtque();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ending();
            }
        });





    }
    private  void save(){
        if(rb1.isChecked()){
            choose=1;
        }else if(rb2.isChecked()){
            choose=2; }
        else if(rb3.isChecked()){
            choose=3;
        }
        else if(rb4.isChecked()){
            choose=4;
        }
        Log.d("answer","the score is"+ans);


        sco();


    }

    private void sco() {
        if(choose >=1 ){
        if(ans==choose){
           a[k]=ans;
        }
        else {
            a[k]= -1;
        }}



    }private  void ll(){
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
        choose=0;
    }

    private void ending() {
        save();
        t2=System.currentTimeMillis();

        for(int i=0;i<a.length;i++){
            if(a[i] !=0){
                f++;
            }
        }

        for(int i=0;i<a.length;i++){
            if(a[i] >0){
                df++;
            }
        }


        getonmain();
    }

    private void getonmain() {
        long t3=t2-t1;
        Intent in=new Intent(this,result.class);
        in.putExtra("title",t.getTitle());
        in.putExtra("att",f);
        in.putExtra("score",df);
        in.putExtra("ques",ques.size());
        in.putExtra("time",t3);
        startActivity(in);
        finish();
    }

    private void rrtque() {
        save();

        if(k<ques.size() && k>0){
            btn2.setVisibility(View.VISIBLE);
        }
        else {
            btn2.setVisibility(View.INVISIBLE);
        }
        if(k<ques.size()-1 && k>=0){
            btn.setVisibility(View.VISIBLE);
        }
        else{
            btn.setVisibility(View.INVISIBLE);
        }
        if(k>0 && k<ques.size()){
        k--;

        que.setText(String.valueOf(ques.get(k).getQues()));
        rb1.setText(String.valueOf(ques.get(k).getOption1()));
        rb2.setText(String.valueOf(ques.get(k).getOption2()));
        rb3.setText(String.valueOf(ques.get(k).getOption3()));
        rb4.setText(String.valueOf(ques.get(k).getOption4()));
        ans= Integer.parseInt(ques.get(k).getAnswer());
        ll();}
        if(k<ques.size() && k>0){
            btn2.setVisibility(View.VISIBLE);
        }
        else {
            btn2.setVisibility(View.INVISIBLE);
        }
        if(k<ques.size()-1 && k>=0){
            btn.setVisibility(View.VISIBLE);
        }
        else{
            btn.setVisibility(View.INVISIBLE);
        }
        ll();
        rgp.clearCheck();

    }



    private void sstque() {
        save();
        if(k<ques.size() && k>0){
            btn2.setVisibility(View.VISIBLE);
        }
        else {
            btn2.setVisibility(View.INVISIBLE);
        }
        if(k<ques.size()-1 && k>=0){
            btn.setVisibility(View.VISIBLE);
        }
        else{
            btn.setVisibility(View.INVISIBLE);
        }
        if(k>=0 && k<ques.size()-1){
        k++;

        que.setText(String.valueOf(ques.get(k).getQues()));
        rb1.setText(String.valueOf(ques.get(k).getOption1()));
        rb2.setText(String.valueOf(ques.get(k).getOption2()));
        rb3.setText(String.valueOf(ques.get(k).getOption3()));
        rb4.setText(String.valueOf(ques.get(k).getOption4()));
        ans= Integer.parseInt(ques.get(k).getAnswer());
        ll();}
        if(k<ques.size() && k>0){
            btn2.setVisibility(View.VISIBLE);
        }
        else {
            btn2.setVisibility(View.INVISIBLE);
        }
        if(k<ques.size()-1 && k>=0){
            btn.setVisibility(View.VISIBLE);
        }
        else{
            btn.setVisibility(View.INVISIBLE);
        }
        ll();
       rgp.clearCheck();
    }
}