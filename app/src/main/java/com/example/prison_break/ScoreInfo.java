package com.example.prison_break;

public class ScoreInfo {
    protected static int num = 0;
    protected static int tracker = 1501;

    public static void calculateScore() {
        if (ScoreInfo.getTracker() > Player.getY()) {
            if (Player.getY() < 1501 && Player.getY() > 1150) {
                ScoreInfo.setPoints(10);
            } else if (Player.getY() <= 1150 && Player.getY() > 950) {
                ScoreInfo.setPoints(5);
            } else if (Player.getY() <= 950 && Player.getY() > 750) {
                ScoreInfo.setPoints(15);
            } else if (Player.getY() <= 750 && Player.getY() > 550) {
                ScoreInfo.setPoints(5);
            } else if (Player.getY() <= 550 && Player.getY() > 250) {
                ScoreInfo.setPoints(10);
            } else if (Player.getY() <= 250 && Player.getY() > 150) {
                ScoreInfo.setPoints(5);
            } else {
                ScoreInfo.setPoints(25);
            }
            ScoreInfo.setTracker(Player.getY());
        }
    }

    // static methods
    public static void setPoints(int x) {num += x;}
    public static int getPoints() {return num;}
    public static void setTracker(int yCoor) {
        tracker = yCoor;
    }
    public static int getTracker() {
        return tracker;
    }
}


