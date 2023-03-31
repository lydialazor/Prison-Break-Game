package com.example.prison_break;

import androidx.lifecycle.MutableLiveData;

public class GameLoop implements Runnable {
    private Thread gameThread;
    private GamePanel gamePanel;
    private boolean isRunning;


    public GameLoop(GamePanel gamePanel) {
        gameThread = new Thread(this);
        this.gamePanel = gamePanel;
        isRunning = true;
    }

    @Override
    public void run() {
        long lastFPScheck = System.currentTimeMillis();
        int fps = 0;

        long lastDelta = System.nanoTime();
        long nanoSec = 1_000_000_000;

        while (isRunning) {
            long nowDelta = System.nanoTime();
            double timeSinceLastDelta = nowDelta - lastDelta;
            double delta = timeSinceLastDelta / nanoSec;

            gamePanel.update(delta);
            gamePanel.render();
            gamePanel.checkCollisionWithVehicles();
            gamePanel.checkCollisionWithTrucks();
            gamePanel.checkCollisionWithTanks();
            gamePanel.checkCollisionWithLogs();

            lastDelta = nowDelta;
            fps++;

            long now = System.currentTimeMillis();
            if (now - lastFPScheck >= 1000) {
                System.out.println("FPS: " + fps + "" + System.currentTimeMillis());
                fps = 0;
                lastFPScheck += 1000;
            }
        }
        //GameScreen.getInstance().setRun();


    }

    public void startGameLoop() {
        gameThread.start();
    }

    public void stopGameLoop() {
        isRunning = false;
    }


}
















