package com.example.prison_break;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.graphics.PointF;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
@Config(manifest= Config.NONE)
public class VehicleTests {
    // local variables
    // mock context
    private Context mockContext;
    private GamePanel gamePanel;
    private SurfaceView mockSView;
    private SurfaceHolder mSurfaceHolder;
    private Looper mLooper;

    @Before
    public void setUp() {
        mLooper = mock(Looper.class);
        mockContext = mock(Context.class);
        when(mockContext.getMainLooper()).thenReturn(mLooper);
        gamePanel = new GamePanel(mockContext);
    }

////////////////////////////////////////////////////////////////

    // tests whether the vehicles are generated correctly
    @Test
    public void testVehicleGeneration() {

        // assert there are no vehicles to begin with
        assertEquals(0, gamePanel.getVehicles().size());

        // ensure that the correct number of vehicles has been generated
        // 50 from each side
        assertEquals(100, gamePanel.getVehicles().size());

        // check if the vehicles are generated at correct position
        int numVehiclesOnLeftSide = 0;
        int numVehiclesOnRightSide = 0;
        for(PointF pos: gamePanel.getVehicles()) {
            if(pos.x == 100) {
                numVehiclesOnLeftSide++;
            } else if(pos.x == 500) {
                numVehiclesOnRightSide++;
            }
        }

        // ensure
        assertEquals(50, numVehiclesOnLeftSide);
        assertEquals(50, numVehiclesOnRightSide);
    }

    // tests whether vehicles collide to each other
    @Test
    public void testVehicleCollision() {
        // create gamePanel instance
        GamePanel gamePanel = new GamePanel(mockContext);

        // create two vehicles
        PointF vehicle1 = new PointF(100,100);
        PointF vehicle2 = new PointF(150,150);

        // simulate a collision
        boolean collision = gamePanel.doVehiclesCollide(vehicle1, vehicle2);

        // assert if collision occurred
        assertTrue(collision);
    }


    // tests whether vehicle spawn from different sides of the road
    @Test
    public void testVehicleSpawn() {
        // initialize mockito annotations
        //MockitoAnnotations.openMocks(this);

        // surface holder
        mockSView = mock(SurfaceView.class);
        mSurfaceHolder = mock(SurfaceHolder.class);
        when(mockSView.getHolder()).thenReturn(mSurfaceHolder);

        // make gamePanel instance
        //when(mockContext.getApplicationContext()).thenReturn(mockContext);

        // run the code to spawn the vehicles
        for (int i = 0; i < 50; i++) {
            gamePanel.getVehicles().add(new PointF(500,500));
        }
        for (int i = 0; i < 50; i++) {
            gamePanel.getVehicles().add(new PointF(100,500));
        }

        // checks that vehicles are spawning from the correct position
        for (int i = 0; i < gamePanel.getVehicles().size(); i++) {
            if (i < 50) {
                assertEquals(500, gamePanel.getVehicles().get(i).x, 0);
                assertEquals(500, gamePanel.getVehicles().get(i).y, 0);
            } else {
                assertEquals(100, gamePanel.getVehicles().get(i).x, 0);
                assertEquals(500, gamePanel.getVehicles().get(i).y, 0);
            }
        }
    }

    // tests whether trucks spawn from different sides of the road
    @Test
    public void testTruckSpawn() {
        // initialize mockito annotations
        MockitoAnnotations.openMocks(this);

        // make gamePanel instance
        when(mockContext.getApplicationContext()).thenReturn(mockContext);
        GamePanel gamePanel = new GamePanel(mockContext);

        // run the code to spawn the vehicles
        for (int i = 0; i < 50; i++) {
            gamePanel.getTrucks().add(new PointF(500,800));
        }
        for (int i = 0; i < 50; i++) {
            gamePanel.getTrucks().add(new PointF(100,800));
        }

        // checks that vehicles are spawning from the correct position
        for (int i = 0; i < gamePanel.getTrucks().size(); i++) {
            if (i < 50) {
                assertEquals(500, gamePanel.getTrucks().get(i).x, 0);
                assertEquals(800, gamePanel.getTrucks().get(i).y, 0);
            } else {
                assertEquals(100, gamePanel.getTrucks().get(i).x, 0);
                assertEquals(800, gamePanel.getTrucks().get(i).y, 0);
            }
        }
    }

    // tests whether tanks spawn from different sides of the road
    @Test
    public void testTankSpawn() {
        // initialize mockito annotations
        MockitoAnnotations.openMocks(this);

        // make gamePanel instance
        when(mockContext.getApplicationContext()).thenReturn(mockContext);
        GamePanel gamePanel = new GamePanel(mockContext);

        // run the code to spawn the vehicles
        for (int i = 0; i < 50; i++) {
            gamePanel.getTanks().add(new PointF(500,300));
        }
        for (int i = 0; i < 50; i++) {
            gamePanel.getTanks().add(new PointF(200,300));
        }

        // checks that vehicles are spawning from the correct position
        for (int i = 0; i < gamePanel.getTanks().size(); i++) {
            if (i < 50) {
                assertEquals(500, gamePanel.getTanks().get(i).x, 0);
                assertEquals(300, gamePanel.getTanks().get(i).y, 0);
            } else {
                assertEquals(200, gamePanel.getTanks().get(i).x, 0);
                assertEquals(300, gamePanel.getTanks().get(i).y, 0);
            }
        }
    }

    //tests if vehicles have speed differences and whether it turns out correctly
    @Test
    public void testSpeedDifference() {
        // initialize mockito annotations
        MockitoAnnotations.openMocks(this);

        // make gamePanel instance
        when(mockContext.getApplicationContext()).thenReturn(mockContext);
        GamePanel gamePanel = new GamePanel(mockContext);

        // add vehicles with their different speeds to the game panel
        ArrayList<PointF> vehicles = gamePanel.getVehicles();
        ArrayList<PointF> trucks = gamePanel.getTrucks();
        ArrayList<PointF> tanks = gamePanel.getTanks();

        // add a vehicle with speed 800
        vehicles.add(new PointF(0, 0));

        // add a truck with speed 500
        trucks.add(new PointF(0, 0));

        // add a tank with speed 200
        tanks.add(new PointF(0, 0));

        // fixed double delta
        double delta = 0.5;

        // call update method
        gamePanel.update(delta);

        // The vehicle should have moved by 400 units (800 * 0.5)
        assertEquals(400, vehicles.get(0).x, 0.001);

        // The truck should have moved by 250 units (500 * 0.5)
        assertEquals(250, trucks.get(0).x, 0.001);

        // The tank should have moved by 100 units (200 * 0.5)
        assertEquals(100, tanks.get(0).x, 0.001);
    }

}
