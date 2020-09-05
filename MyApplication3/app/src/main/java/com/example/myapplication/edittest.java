package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class edittest extends AppCompatActivity {
    TextView tot;
long id;
    note k;
    welcome db;
    List<question> ques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittest);
        Toolbar toolbar = findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar);

        tot=findViewById(R.id.total);
        Intent i=getIntent();
       id= i.getLongExtra("ID",0);
        db=new welcome(this);
        k=db.getnote(id);
        ques=db.getques(k.getId());
        getSupportActionBar().setTitle(String.valueOf(k.getTitle()));
        tot.setText(String.valueOf(ques.size()));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deletenot(id);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.edit,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.edittes){
            Intent i=new Intent(this,editactivity.class);
            i.putExtra("IDt",id);
            startActivity(i);

        }
        if(item.getItemId()==R.id.start){
            Intent i=new Intent(this,test.class);
            i.putExtra("quesset",id);
            startActivity(i);}

        return  super.onOptionsItemSelected(item);
    }}
