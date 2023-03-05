package com.example.prison_break;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class GameScreen extends AppCompatActivity {
    private TextView name;
    private TextView difficulty;
    private ImageButton playerChoice;
    private Button add;

    private ImageView square;
    private int squareX, squareY;
    private int prevX, prevY;

    private String str1;

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

        Intent intent2 = getIntent();
        String str2 = intent2.getStringExtra("Player");

        square = findViewById(R.id.square);
        if (str2.equals("dude1")) {
            square.setImageResource(R.drawable.dude1);
        } else if (str2.equals("dude2")) {
            square.setImageResource(R.drawable.dude2);
        } else if (str2.equals("dude3")) {
            square.setImageResource(R.drawable.dude3);
        }
        //square.setOnTouchListener(this::onTouch);
        square.setOnKeyListener(this::onKey);
        square.setFocusable(true);
        //square.setFocusableInTouchMode(true);
        // get the dimensions of the screen
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;
        // initialize the position of the square to the middle of the bottom 100 pixels of the screen
        squareX = (screenWidth - square.getWidth()) / 2;
        squareY = 1650;
        square.setX(squareX);
        square.setY(squareY);

        // initialize the pos of grass to bottom middle;
        View grass = findViewById(R.id.grass);
        //int grassX = (screenWidth - 1100); //  - square.getWidth()) / 2 - 700
        int grassY = screenHeight - square.getHeight();
        grass.setX(0);
        grass.setY(grassY - 1711);

        View river = findViewById(R.id.river);
        //int river = (screenWidth - 1100); //  - square.getWidth()) / 2 - 700
        int riverY = screenHeight - 850 - square.getHeight();
        river.setX(0);
        river.setY(riverY);

        View goal = findViewById(R.id.goal);
        //int river = (screenWidth - 1100); //  - square.getWidth()) / 2 - 700
        int goalY = screenHeight - 1000 - square.getHeight();
        goal.setX(0);
        goal.setY(goalY - 850);

        View road = findViewById(R.id.road);
        //int river = (screenWidth - 1100); //  - square.getWidth()) / 2 - 700
        int roadY = screenHeight - 800 - square.getHeight();
        road.setX(0);
        road.setY(roadY - 711);


    }

    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                prevX = (int) event.getX();
                prevY = (int) event.getY();
                squareX = (int) square.getX();
                squareY = (int) square.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int newX = (int) event.getX();
                int newY = (int) event.getY();
                int deltaX = newX - prevX;
                int deltaY = newY - prevY;
                square.setX(squareX + deltaX);
                square.setY(squareY + deltaY);
                break;
            default:
                return false;
        }
        return true;
    }

    public boolean onKey(View view, int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                if (squareY > 135) {
                    square.setY(squareY - 50);
                    squareY -= 50;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (squareY < 1650) { // view.getHeight() - square.getHeight()
                    square.setY(squareY + 50);
                    squareY += 50;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (squareX > 0) {
                    square.setX(squareX - 50);
                    squareX -= 50;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (squareX < view.getWidth() - square.getWidth() + 950) {
                    square.setX(squareX + 50);
                    squareX += 50;
                }
                break;
            default:
                return false;
        }

        return true;
    }

    public boolean diffTextView() {
        if (str1.equals("Easy (3 Lives") || str1.equals("Medium (2 Lives") || str1.equals("Hard (1 Life")) {
            return true;
        }
        return false;
    }
    }


