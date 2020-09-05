package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
public class editactivity extends AppCompatActivity {
    Toolbar toll;
    EditText title,quest,op1,op2,op3,op4,ans;
    Button btn,btn2;
    int num=1;
    note t;
    int k=0;

    Date date;
    String Time;
    long id;
    welcome db;





    List<question> ques;
    List<note> nn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editactivity);
        toll=findViewById(R.id.toolbar4);
        title=findViewById(R.id.titletext2);
        quest=findViewById(R.id.question2);
        op1=findViewById(R.id.option12);
        op2=findViewById(R.id.option22);
        op3=findViewById(R.id.option32);
        op4=findViewById(R.id.option42);
        ans=findViewById(R.id.answer2);
        btn=(Button)findViewById(R.id.button2);
        btn2=(Button)findViewById(R.id.button8);
        setSupportActionBar(toll);
        db=new welcome(this);
        Intent i=getIntent();
        id=i.getLongExtra("IDt",0);
        t=db.getnote(id);
        getSupportActionBar().setTitle(String.valueOf(t.getTitle()));
        title.setText(String.valueOf(t.getTitle()));
        ques=db.getques(t.getId());


        quest.setText(String.valueOf(ques.get(k).getQues()));
        op1.setText(String.valueOf(ques.get(k).getOption1()));
        op2.setText(String.valueOf(ques.get(k).getOption2()));
        op3.setText(String.valueOf(ques.get(k).getOption3()));
        op4.setText(String.valueOf(ques.get(k).getOption4()));
        ans.setText(String.valueOf(ques.get(k).getAnswer()));
        if(k>0 && k<ques.size()){
            btn2.setVisibility(View.VISIBLE);}
        else{
            btn2.setVisibility(View.INVISIBLE);}
        if(k<ques.size()-1 && k>=0){
            btn.setVisibility(View.VISIBLE);}
        else {
            btn.setVisibility(View.INVISIBLE);}
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               stque();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rstque();
            }
        });

        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() !=0){
                    toll.setTitle(s);}

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void rstque() {
        sstqu();
        if(k>0 && k<ques.size()){
            btn2.setVisibility(View.VISIBLE);}
        else{
            btn2.setVisibility(View.INVISIBLE);}
        if(k<ques.size()-1 && k>=0){
            btn.setVisibility(View.VISIBLE);}
        else {
            btn.setVisibility(View.INVISIBLE);}
        k--;



        if(k< ques.size() && k>=0){
        quest.setText(String.valueOf(ques.get(k).getQues()));
        op1.setText(String.valueOf(ques.get(k).getOption1()));
        op2.setText(String.valueOf(ques.get(k).getOption2()));
        op3.setText(String.valueOf(ques.get(k).getOption3()));
        op4.setText(String.valueOf(ques.get(k).getOption4()));
        ans.setText(String.valueOf(ques.get(k).getAnswer()));}
        if(k>0 && k<ques.size()){
            btn2.setVisibility(View.VISIBLE);}
        else{
            btn2.setVisibility(View.INVISIBLE);}
        if(k<ques.size()-1 && k>=0){
            btn.setVisibility(View.VISIBLE);}
        else {
            btn.setVisibility(View.INVISIBLE);}
        sstqu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.save,menu);

        return true;}


            private void stque() {
                sstqu();
                if(k>0 && k<ques.size()){
                    btn2.setVisibility(View.VISIBLE);}
                else{
                    btn2.setVisibility(View.INVISIBLE);}
        if(k<ques.size()-1 && k>=0){
            btn.setVisibility(View.VISIBLE);}
        else {
            btn.setVisibility(View.INVISIBLE);}
            k++;
            if(k< ques.size() && k>=0){





        quest.setText(String.valueOf(ques.get(k).getQues()));
        op1.setText(String.valueOf(ques.get(k).getOption1()));
        op2.setText(String.valueOf(ques.get(k).getOption2()));
        op3.setText(String.valueOf(ques.get(k).getOption3()));
        op4.setText(String.valueOf(ques.get(k).getOption4()));
        ans.setText(String.valueOf(ques.get(k).getAnswer()));}
                if(k>0 && k<ques.size()){
                    btn2.setVisibility(View.VISIBLE);}
                else{
                    btn2.setVisibility(View.INVISIBLE);}
                if(k<ques.size()-1 && k>=0){
                    btn.setVisibility(View.VISIBLE);}
                else {
                    btn.setVisibility(View.INVISIBLE);}
        sstqu();

    }

    private void sstqu() {
        ques.get(k).setQues(quest.getText().toString());
        ques.get(k).setOption1(op1.getText().toString());
        ques.get(k).setOption2(op2.getText().toString());
        ques.get(k).setOption3(op3.getText().toString());
        ques.get(k).setOption4(op4.getText().toString());
        ques.get(k).setAnswer(ans.getText().toString());
        int ik=db.editques(ques.get(k), t.getId());
    }

    SimpleDateFormat sdf=new SimpleDateFormat(("yyyy/MM/dd")+"  "+("HH:mm:ss"));
    String ddat=sdf.format(new Date());
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.delete){
            db.deleteque(t.getId(),ques.get(k));
            getonmain();
        }
        if(item.getItemId()== R.id.save){
            sstqu();
            if(k<ques.size()-1){
                btn.setVisibility(View.VISIBLE);
            k++;
                if(k== ques.size()-1){
                    btn.setVisibility(View.INVISIBLE);}


                }sstqu();
            ques.get(k).setAnswer(ans.getText().toString());
            ques.get(k).setQues(quest.getText().toString());
            ques.get(k).setOption1(op1.getText().toString());
            ques.get(k).setOption2(op2.getText().toString());
            ques.get(k).setOption3(op3.getText().toString());
            ques.get(k).setOption4(op4.getText().toString());

            int ik=db.editques(ques.get(k), t.getId());


            t.setTitle(title.getText().toString());
            t.setDate(ddat.toString());
            t.setTime(ddat.toString());
            int is=db.editnote(t);
            getonmain();

        }
        return  super.onOptionsItemSelected(item);

}

    private void getonmain() {
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }
}