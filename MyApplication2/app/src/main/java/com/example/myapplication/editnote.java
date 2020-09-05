package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.note;
import com.welcome;

import java.text.SimpleDateFormat;
import java.util.Date;

public class editnote extends AppCompatActivity { Toolbar toll;
    EditText nottitle,notecon;
    Calendar c;
    note t;

    Date date;
    String Time;
    long id;
    welcome db;
    private Context context; @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("NewApi")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnote);toll = findViewById(R.id.toolbar3);
        nottitle=findViewById(R.id.title2);
        notecon=findViewById(R.id.content1);
        setSupportActionBar(toll);
        Intent i=getIntent();
        id=i.getLongExtra("ID",0);
         db=new welcome(this);
        t=db.getnote(id);
        getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(t.getTitle());
        nottitle.setText(t.getTitle());
        notecon.setText(t.getContnet());


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
    });} @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.saveno,menu);

        return true;
    }

    SimpleDateFormat sdf=new SimpleDateFormat(("yyyy/MM/dd")+"  "+("HH:mm:ss"));
    String ddat=sdf.format(new Date());
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.savenot){
            t.setTitle(nottitle.getText().toString());
            t.setContnet(notecon.getText().toString());
            t.setDate(ddat);
            t.setTime(ddat);
            int is=db.editnote(t);
            Toast.makeText(this, "note is update",Toast.LENGTH_SHORT).show();
            getonmain();
            }
        return  super.onOptionsItemSelected(item);
    }

    private void getonmain() {
        Intent i=new Intent(getApplicationContext(),editactivity.class);
        i.putExtra("ID",t.getId());
        startActivity(i);
    }
}