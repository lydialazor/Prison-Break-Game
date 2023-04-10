package com.example.prison_break;

import android.graphics.PointF;

public class VehiclesGenerate extends VehicleInfo {
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
}
