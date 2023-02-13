package com.example.prison_break;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start;
        start = findViewById(R.id.start);

        start.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, nextscreen.class);
            startActivity(myIntent);
        });
    }

}
