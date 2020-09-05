package com;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
        adapter t;
  List<note> nt;
    RecyclerView rte;
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.welcome);
   findViewById(R.id.listnot); welcome db=new welcome(this);
    nt = db.getnotes();
     rte= findViewById(R.id.listnotes);
    rte.setLayoutManager(new LinearLayoutManager(this));
    t=new adapter(this,nt);
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
            Intent intent=new Intent(this, addac.class);
            startActivity(intent);
        }
        return  super.onOptionsItemSelected(item);
    }



}
