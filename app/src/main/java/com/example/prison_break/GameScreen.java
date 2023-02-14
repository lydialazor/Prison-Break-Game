package com.example.prison_break;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class GameScreen extends AppCompatActivity {
    private TextView name;
    private TextView difficulty;
    private ImageButton playerChoice;
    private Button add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);

        name = findViewById(R.id.playername);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Name: ");
        name.setText(str);

        difficulty = findViewById(R.id.difficulty);
        Intent intent1 = getIntent();
        String str1 = intent1.getStringExtra("Difficulty: ");
        difficulty.setText(str1);

        playerChoice = findViewById(R.id.playerChoice);
        Intent intent2 = getIntent();
        String str2 = intent2.getStringExtra("Player");
        if (str2.equals("dude1")) {
            playerChoice.setImageResource(R.drawable.dude1);
        } else if (str2.equals("dude2")) {
            playerChoice.setImageResource(R.drawable.dude2);
        } else if (str2.equals("dude3")) {
            playerChoice.setImageResource(R.drawable.dude3);
        }

    }

}
