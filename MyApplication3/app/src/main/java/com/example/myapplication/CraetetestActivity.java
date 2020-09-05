package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CraetetestActivity extends AppCompatActivity {
     Toolbar toll;
     EditText title,quest,op1,op2,op3,op4,ans;
     int num=0;
     Button btn;
     question ty;




List<question> ques=new ArrayList<>();
List<note> nn;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.craetetest);
        toll=findViewById(R.id.toolbar5);
        title=findViewById(R.id.titletext);
        quest=findViewById(R.id.question);
        op1=findViewById(R.id.option1);
        op2=findViewById(R.id.option2);
        op3=findViewById(R.id.option3);
        op4=findViewById(R.id.option4);
        ans=findViewById(R.id.answer);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               stque();
            }
        });

        setSupportActionBar(toll);
        getSupportActionBar();

        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() !=0){
                    toll.setTitle(s);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });}
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.save,menu);

            return true;}
            SimpleDateFormat sdf=new SimpleDateFormat(("yyyy/MM/dd")+"  "+("HH:mm:ss"));
            String ddat=sdf.format(new Date());
            @Override
            public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.delete){
                    Toast.makeText(this, "note is delete", Toast.LENGTH_SHORT).show();
                    onBackPressed();}
                if(item.getItemId()== R.id.save){
                    num++;

                    question que=new question(num,quest.getText().toString(),op1.getText().toString(),op2.getText().toString(),op3.getText().toString(),op4.getText().toString(),ans.getText().toString());
                  boolean t=  ques.add(que);
                    note nt=new note(title.getText().toString(),ques,ddat.toString(),ddat.toString());

                    if(num==1){
                        ty=que;
                    }
                    welcome db=new welcome(this);
                    long s=db.addn(nt,ques,num);
                    long gh=db.bddn(nt,ques,s);
                    Log.d("ID","the id is"+s);
                    Log.d("IDQU","the queid is"+gh);

                    Toast.makeText(this, "note is save",Toast.LENGTH_SHORT).show();
                    getonmain();

                }
                return  super.onOptionsItemSelected(item);

            } private void getonmain() {
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }

    public  void  stque(){
                num++;
                question que=new question(num,quest.getText().toString(),op1.getText().toString(),op2.getText().toString(),op3.getText().toString(),op4.getText().toString(),ans.getText().toString());
                ty=que;
                boolean rit= ques.add(que);





               getonmai();



    }  private void getonmai() {

               quest.setText("");
               op1.setText("");
               op2.setText("");
               op3.setText("");
               op4.setText("");ans.setText("");
       }






}