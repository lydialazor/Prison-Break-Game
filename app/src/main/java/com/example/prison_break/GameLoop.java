package com.example.prison_break;

public class GameLoop implements Runnable {
    private Thread gameThread;
    private GamePanel gamePanel;

    public GameLoop(GamePanel gamePanel) {
        gameThread = new Thread(this);
        this.gamePanel = gamePanel;

    }
    @Override
    public void run() {
        while (true) {
            //gamePanel.update();
            gamePanel.render();

        }
    }

    public void startGameLoop() {
        gameThread.start();
    }

    public void stopGameLoop() {

    }
}
