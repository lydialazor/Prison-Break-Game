package com.example.prison_break;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.content.Intent;
import android.widget.Button;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class ButtonTests {
    @Test
    // Test whether player can move from Main to NextScreen in order to access character options, name, etc.
    public void mainToNextButtonTest() {
        // making main activity instance
        MainActivity mainAct = new MainActivity();

        // setting to layout of start button that is being tested
        mainAct.setContentView(R.layout.activity_main);

        // gets the start button from the main screen and performs the click
        Button buttonNext = mainAct.findViewById(R.id.start);
        buttonNext.performClick();
        ShadowActivity shadowActivity = shadowOf(mainAct);
        Intent nextActivityIntent = shadowActivity.getNextStartedActivity();

        // detects whether the start button functions as intended
        assertNotNull(nextActivityIntent);
        assertEquals(nextActivityIntent.getComponent().getClassName(), NextScreen.class.getName());

        // cleans up the test
        mainAct.finish();
    }

    @Test
    // Test whether player can move from Next to GameScreen in order to play the game
    public void nextToGameButtonTest() {
        // making next screen/activity instance
        NextScreen next = new NextScreen();

        // setting to layout of start button that is being tested
        next.setContentView(R.layout.nextscreen);

        // gets the start1 button from the main screen and performs the click
        Button buttonNext = next.findViewById(R.id.start1);
        buttonNext.performClick();
        ShadowActivity shadowActivity = shadowOf(next);
        Intent nextActivityIntent = shadowActivity.getNextStartedActivity();

        // detects whether the start button functions as intended
        assertNotNull(nextActivityIntent);
        assertEquals(nextActivityIntent.getComponent().getClassName(), GameScreen.class.getName());

        // cleans up the test
        next.finish();
    }
}
