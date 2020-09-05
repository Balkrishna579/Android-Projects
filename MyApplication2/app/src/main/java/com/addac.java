package com;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class addac extends AppCompatActivity { Toolbar toll;
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
