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
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<note> nt;
    RecyclerView rt;
    adapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome db=new welcome(this);
        nt = db.getnotes();
        rt = findViewById(R.id.testi);
        rt.setLayoutManager(new LinearLayoutManager(this));

        adapter adp=new adapter(this,nt);
        rt.setAdapter(adp);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.make){
            Toast.makeText(this, "note is cli",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,CraetetestActivity.class);

            startActivity(intent);
        }
        if(item.getItemId()==R.id.edit){
            Intent intent=new Intent(this,edittest.class);
            intent.putExtra("ID",0);
            startActivity(intent);
        }

        return  super.onOptionsItemSelected(item);
    }

}