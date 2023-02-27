package com.example.prison_break;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Test;

public class NextScreenTest extends TestCase {
    NextScreen instance = new NextScreen();

    //checks empty String inputs
    @Test
    void emptyNameTest() {
        String name = "";
        assertEquals(true, instance.checkInvalidNames(name));
    }

    //checks null inputs
    @Test
    void nullNameTest() {
        String name = null;
        assertEquals(true, instance.checkInvalidNames(name));
    }

}