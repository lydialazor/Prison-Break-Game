package com.example.prison_break.entities;

import android.content.Context;
import android.graphics.Bitmap;

public class Player {

    private Bitmap playerChoice;
    private int xpos;
    private int ypos;

    public Player(Context context, int xpos, int ypos) {
        playerChoice = playerChosen();

    }

    private Bitmap playerChosen() {
        if (GameConstants.getPlayer() == "dude1") {
            return GameCharacters.PLAYER1.getSprite();
        } else if (GameConstants.getPlayer() == "dude2") {
            return GameCharacters.PLAYER2.getSprite();
        } else if (GameConstants.getPlayer() == "dude3") {
            return GameCharacters.PLAYER3.getSprite();
        }
        return null;
    }

    public void move(String move) {
        if (move.equals("UP")) {
            ypos -= 100;
        } else if (move.equals("DOWN")) {
            ypos += 100;
        } else if (move.equals("LEFT")) {
            xpos -= 100;
        } else if (move.equals("RIGHT")) {
            xpos += 100;
        }
    }

}
