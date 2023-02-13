package com.example.prison_break;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class gamescreen extends AppCompatActivity {
    private TextView name;
    private Button add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);

        //name = findViewById(R.id.nameinput);

        //String playername = getIntent().getStringExtra("keyname");

        //name.setText(playername);



    }
}
