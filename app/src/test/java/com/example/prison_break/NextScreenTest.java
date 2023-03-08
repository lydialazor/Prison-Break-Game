package com.example.prison_break;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class NextScreenTest {
    NextScreen instance = new NextScreen();

    //checks empty String inputs
    @Test
    public void testemptyName() {
        String name = "";
        Assert.assertEquals(true, instance.checkInvalidNames(name));
    }

    //checks null inputs
    @Test
    public void testnullName() {
        String name = null;
        Assert.assertEquals(true, instance.checkInvalidNames(name));
    }
}