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
    private static int changeX;
    private static int changeY;

    public Player() {
        setPlayer();
        x = 500 + changeX;
        y = 1500 + changeY;

    }

    public static void setX(String s) {
            if (s == "left" && x > 0) {
                changeX -= 50;
            } else if (s == "right" && x < 1000) {
                changeX += 50;
            }
    }
    public static void setY(String s) {
            if (s == "up" && y > 0) {
                changeY -= 50;
            } else if (s == "down" && y <= 1500) {
                changeY += 50;
            }
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


}

