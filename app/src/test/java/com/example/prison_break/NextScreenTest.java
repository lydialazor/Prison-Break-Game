package com.example.prison_break;

import static org.junit.Assert.*;

import android.widget.ImageButton;

import junit.framework.TestCase;

import org.junit.Test;

public class NextScreenTest extends TestCase {
    NextScreen instance = new NextScreen();

    //checks empty String inputs
    @Test
    void testEmptyName() {
        String name = "";
        assertEquals(true, instance.checkInvalidNames(name));
    }

    //checks null inputs
    @Test
    void testNullName() {
        String name = null;
        assertEquals(true, instance.checkInvalidNames(name));
    }

    @Test
    public void testPlayerSelect() {
        String choice = instance.getPlayerChoice();
        ImageButton button = instance.getChoice();
        assertTrue(instance.checkPlayerSelected());
    }
    @Test
    public void difficultySelect() {
        assertEquals(false,instance.checkInvalidDifficulty(instance.getDifficulty()));
    }


}