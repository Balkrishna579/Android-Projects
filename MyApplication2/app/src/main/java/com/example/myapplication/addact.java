package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class addact extends AppCompatActivity {
    Toolbar toll;
    EditText nottitle,notecon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addact);
        toll = findViewById(R.id.toolbar2);
        nottitle=findViewById(R.id.title1);
        notecon=findViewById(R.id.content);

    }
}