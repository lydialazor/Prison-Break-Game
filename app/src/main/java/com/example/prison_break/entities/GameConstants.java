package com.example.prison_break.entities;

public class GameConstants {
    private static String player;
    private static String name;
    private static String difficulty;

    public static String getPlayer() {
        return player;
    }

    public static void setPlayer(String p) {
        player = p;
    }

    public static void setName(String n) {
        name = n;
    }
    public static String getName() {
        return name;
    }

    public static String getDifficulty() {
        return difficulty;
    }
    public static void setDifficulty(String d) {
        difficulty = d;
    }

}
