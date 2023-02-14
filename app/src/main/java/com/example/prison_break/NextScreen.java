package com.example.prison_break;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NextScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView textView;
    private String name;
    private EditText nameinput;
    private Button submitname;
    private ImageButton player1;
    private ImageButton player2;
    private ImageButton player3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextscreen);

        Spinner spinner = findViewById(R.id.difficulty);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.difficulty, android.R.layout.simple_selectable_list_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        nameinput = (EditText) findViewById(R.id.nameinput);
        submitname = (Button) findViewById(R.id.submitname);

        player1 = (ImageButton) findViewById(R.id.player1);
        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NextScreen.this, "player 1 selected",
                        Toast.LENGTH_SHORT).show();
            }
        });
        player2 = (ImageButton) findViewById(R.id.player2);
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NextScreen.this, "player 2 selected",
                        Toast.LENGTH_SHORT).show();
            }
        });
        player3 = (ImageButton) findViewById(R.id.player3);
        player3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NextScreen.this, "player 3 selected",
                        Toast.LENGTH_SHORT).show();
            }
        });


        Button start1;
        start1 = findViewById(R.id.start1);

        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GameScreen.class);
                String name = nameinput.getText().toString();
                String difficulty = spinner.getSelectedItem().toString();
                String playerChoice = "";
                if (player1.isSelected()) {
                    playerChoice = "dude1";
                } else if (player2.isSelected()) {
                    playerChoice = "dude2";
                } else {
                    playerChoice = "dude3";
                }
                intent.putExtra("Name: ", name);
                intent.putExtra("Difficulty: ", difficulty);
                intent.putExtra("Player", playerChoice);
                if (name.equals("")) {
                    Toast t = Toast.makeText(NextScreen.this,
                            "Please enter not null", Toast.LENGTH_SHORT);
                    t.show();
                } else if (name.trim().isEmpty()) {
                    Toast t = Toast.makeText(NextScreen.this,
                            "Please enter a name", Toast.LENGTH_SHORT);
                    t.show();
                } else {
                    startActivity(intent);
                }
                showToast(name);
            }
        });

        submitname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = nameinput.getText().toString();
                if (name.equals("")) {
                    Toast t = Toast.makeText(NextScreen.this,
                            "Please enter not null", Toast.LENGTH_SHORT);
                    t.show();
                }
                if (name.trim().isEmpty()) {
                    Toast t = Toast.makeText(NextScreen.this,
                            "Please enter a name", Toast.LENGTH_SHORT);
                    t.show();
                }
                showToast(name);
            }

        });

    }
    private void showToast(String text) {
        Toast.makeText(NextScreen.this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

