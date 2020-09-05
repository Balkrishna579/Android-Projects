package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.note;
import com.welcome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class editactivity extends AppCompatActivity {
    TextView det;
    long id;
    note t;
    welcome db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
         id=i.getLongExtra("ID",0);
         db=new welcome(this);
         t=db.getnote(id);
        getSupportActionBar().setTitle(t.getTitle());
        det=findViewById(R.id.details);
        det.setText(t.getContnet());
     det.setMovementMethod(new ScrollingMovementMethod());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deletenot(id);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    } @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.editte,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.edit){
            Intent i=new Intent(this,editnote.class);
            i.putExtra("ID",t.getId());
            startActivity(i);

        }

        return  super.onOptionsItemSelected(item);
    }}