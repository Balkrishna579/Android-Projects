package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import com.note;
import com.welcome;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<note> nt;
    RecyclerView rt;
    adapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        welcome db=new welcome(this);
       nt = db.getnotes();
       rt = findViewById(R.id.listnotes);
        rt.setLayoutManager(new LinearLayoutManager(this));

        adapter adp=new adapter(this,nt);
        rt.setAdapter(adp);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.add,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.addm){
            Toast.makeText(this, "note is cli",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,addac.class);
            startActivity(intent);
        }
        return  super.onOptionsItemSelected(item);
    }




}
