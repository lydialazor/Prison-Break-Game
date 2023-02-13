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

public class nextscreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView Textview;
    String name;
    EditText nameinput;
    Button submitname;
    ImageButton player1;
    ImageButton player2;
    ImageButton player3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextscreen);

        Spinner spinner = findViewById(R.id.difficulty);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.difficulty, android.R.layout.simple_selectable_list_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        nameinput = (EditText) findViewById(R.id.nameinput);
        submitname = (Button) findViewById(R.id.submitname);

        player1 = (ImageButton) findViewById(R.id.player1);
        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nextscreen.this, "player 1 selected", Toast.LENGTH_SHORT).show();
            }
        });
        player2 = (ImageButton) findViewById(R.id.player2);
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nextscreen.this, "player 2 selected", Toast.LENGTH_SHORT).show();
            }
        });
        player3 = (ImageButton) findViewById(R.id.player3);
        player3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nextscreen.this, "player 3 selected", Toast.LENGTH_SHORT).show();
            }
        });


        Button start1;
        start1 = findViewById(R.id.start1);

        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(nextscreen.this, gamescreen.class);
                //String name = nameinput.getText().toString();
                //myIntent.putExtra("keyname",name);
                startActivity(myIntent);

            }
        });

        submitname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = nameinput.getText().toString();
                if (name.equals("")) {
                    Toast t = Toast.makeText(nextscreen.this, "Please enter not null", Toast.LENGTH_SHORT);
                    t.show();
                }
                if (name.trim().isEmpty()) {
                    Toast t = Toast.makeText(nextscreen.this, "Please enter a name", Toast.LENGTH_SHORT);
                    t.show();
                }
                showToast(name);

            }

        });

    }
    private void showToast(String text) {
        Toast.makeText(nextscreen.this, text, Toast.LENGTH_SHORT).show();
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

