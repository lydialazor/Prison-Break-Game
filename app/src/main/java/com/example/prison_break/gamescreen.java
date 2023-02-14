package com.example.prison_break;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class gamescreen extends AppCompatActivity {
    private TextView name;
    private Button add;
    private TextView diff;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);

        name = findViewById(R.id.playername);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Name: ");
        name.setText(str);

        diff = findViewById(R.id.difficulty);
        Intent intent2 = getIntent();
        String str2 = intent2.getStringExtra("Difficulty: ");
        diff.setText(str2);





    }

}
