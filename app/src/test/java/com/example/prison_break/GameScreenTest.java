package com.example.prison_break;

import static org.junit.Assert.*;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import junit.framework.TestCase;



import org.junit.Test;

public class GameScreenTest extends TestCase {
    GameScreen instance = new GameScreen();

    @Test
    public void testIsDifficultyDisplayed() {
        assertEquals(true,instance.diffTextView());
    }
}