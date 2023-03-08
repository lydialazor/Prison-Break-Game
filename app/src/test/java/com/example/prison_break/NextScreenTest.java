package com.example.prison_break;

import static org.junit.Assert.*;

import android.widget.ImageButton;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class NextScreenTest {
    NextScreen instance = new NextScreen();

    //checks empty String inputs
    @Test

    public void testEmptyName() {
        String name = "";
        Assert.assertEquals(true, instance.checkInvalidNames(name));
    }

    //checks null inputs
    @Test

    public void testNullName() {
        String name = null;
        Assert.assertEquals(true, instance.checkInvalidNames(name));
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