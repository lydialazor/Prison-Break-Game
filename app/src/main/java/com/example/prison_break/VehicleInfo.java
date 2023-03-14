package com.example.prison_break;

import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;

public class VehicleInfo {

    //
    protected static ArrayList<PointF> vehicles = new ArrayList<>();
    protected static ArrayList<PointF> trucks = new ArrayList<>();

    protected static ArrayList<PointF> tanks = new ArrayList<>();
    PointF vehiclePos;
    protected static int VEHICLE_WIDTH = 130;
    protected static int VEHICLE_HEIGHT = 52;


    // checks whether the cop car vehicles collide or not
    public boolean doVehiclesCollide(PointF pos1, PointF pos2) {
        // calculate the boxes for the two vehicles
        RectF box1 = new RectF(pos1.x - VEHICLE_WIDTH / 2, pos1.y - VEHICLE_HEIGHT / 2,
                pos1.x + VEHICLE_WIDTH / 2, pos1.y + VEHICLE_HEIGHT / 2);
        RectF box2 = new RectF(pos2.x - VEHICLE_WIDTH / 2, pos2.y - VEHICLE_HEIGHT / 2,
                pos2.x + VEHICLE_WIDTH / 2, pos2.y + VEHICLE_HEIGHT / 2);
        return box1.intersect(box2);
    }

    // update
    public static void update(double delta) {

        for(PointF pos: getVehicles()) {
            pos.x += delta * 800;

            if(pos.x >= 1920) {
                pos.x = 0;
            }
        }
        for(PointF pos: getTrucks()) {
            pos.x += delta * 500;

            if(pos.x >= 1920) {
                pos.x = 0;
            }
        }
        for(PointF pos: getTanks()) {
            pos.x += delta * 200;

            if(pos.x >= 1920) {
                pos.x = 0;
            }
        }
    }

    public static void vehicleGenerate() {
        // vehicles
        for (int i = 0; i < 50; i++) {
            getVehicles().add(i, new PointF(500, 500));
        }
        for (int i = 0; i < 50; i++) {
            getVehicles().add(i, new PointF(100, 500));
        }
        for (int i = 0; i < 50; i++) {
            getVehicles().add(i, new PointF(300, 500));
        }

    }


    public static void trucksGenerate() {
        // trucks
        for (int i = 0; i < 50; i++) {
            getTrucks().add(i, new PointF(100, 1200));
        }

        for (int i = 0; i < 50; i++) {
            getTrucks().add(i, new PointF(500, 1200));
        }
    }
    public static void tanksGenerate() {
        // tanks
        for (int i = 0; i < 50; i++) {
            getTanks().add(new PointF(500, 300));
        }
        for (int i = 0; i < 50; i++) {
            getTanks().add(new PointF(200, 300));
        }
    }


    // getter method for vehicles
    public static ArrayList<PointF> getVehicles() {
        return vehicles;
    }

    // getter method for trucks
    public static ArrayList<PointF> getTrucks() {
        return trucks;
    }

    // getter method for tanks
    public static ArrayList<PointF> getTanks() {
        return tanks;
    }

}


