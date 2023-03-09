package com.example.prison_break;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.prison_break.entities.GameCharacters;
import com.example.prison_break.helpers.GameConstants;


public class Player {
    private static int x;
    private static int y;
    private static String name;
    private static Bitmap player;

    public Player(int xpos, int ypos) {
        setPlayer();
        x = xpos;
        y = ypos;

    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    private void setPlayer() {
        if (GameConstants.getPlayer() == "dude1") {
            player = GameCharacters.PLAYER1.getSprite();
        } else if (GameConstants.getPlayer() == "dude2") {
            player = GameCharacters.PLAYER2.getSprite();
        } else {
            player = GameCharacters.PLAYER3.getSprite();
        }

    }

    public static Bitmap getPlayerSprite() {
        return player;
    }

    public void move(String s) {
        if (s == "UP") {
            y -= 100;
     } else if (s == "DOWN") {
        y += 100;
     }
     if (s == "LEFT") {
        x -= 100;
     } else if (s == "RIGHT") {
        x += 100;
     }

    }

}

