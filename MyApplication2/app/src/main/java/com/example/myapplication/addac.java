package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.note;
import com.welcome;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import static com.example.myapplication.R.*;


public class addac extends AppCompatActivity {


    Toolbar toll;
    EditText nottitle,notecon;
    Calendar c;

    Date date;
    String Time;
    private Context context;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_addact);
        toll = findViewById(id.toolbar2);
        nottitle=findViewById(id.title1);
        notecon=findViewById(id.content);
       setSupportActionBar(toll);
       getSupportActionBar();
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nottitle.addTextChangedListener(new TextWatcher() {
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
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.save3,menu);

        return true;
    }
    SimpleDateFormat sdf=new SimpleDateFormat(("yyyy/MM/dd")+"  "+("HH:mm:ss"));
    String ddat=sdf.format(new Date());
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== id.delete){
            Toast.makeText(this, "note is delete", Toast.LENGTH_SHORT).show();
            onBackPressed();}
        if(item.getItemId()== id.save){
             note nt=new note(nottitle.getText().toString(),notecon.getText().toString(),ddat.toString(),ddat.toString());
            welcome db=new welcome(this);
            long s=db.addn(nt);
            Toast.makeText(this, "note is save",Toast.LENGTH_SHORT).show();
            getonmain();

        }
        return  super.onOptionsItemSelected(item);
    }

    private void getonmain() {
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();

    }





}
