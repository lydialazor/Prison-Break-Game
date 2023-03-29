package com.example.prison_break;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.prison_break.entities.GameCharacters;
import com.example.prison_break.helpers.GameConstants;

import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    private int xDir = 1;
    private int yDir = 1;
    private GameLoop gameLoop;
    private NextScreen nextscreen;
    private Random rand = new Random();

    private ArrayList<PointF> vehicles = new ArrayList<>();
    private ArrayList<PointF> trucks = new ArrayList<>();

    private ArrayList<PointF> tanks = new ArrayList<>();
    private PointF vehiclePos;
    private int VEHICLE_WIDTH = 130;
    private int VEHICLE_HEIGHT = 52;

    private static int num = 0;

    private static int tracker = 1501;
    private Player player;

    private static int numLives;





    public GamePanel(Context context) {
        super(context);

        holder = getHolder();
        holder.addCallback(this);
        nextscreen  = new NextScreen();

        gameLoop = new GameLoop(this);

        for(int i = 0; i < 50; i++) {
            vehicles.add(new PointF(500, 500));
        }
        for(int i = 0; i < 50; i++) {
            vehicles.add(new PointF(100, 500));
        }

        for(int i = 0; i < 50; i++) {
            vehicles.add(new PointF(300, 500));
        }

        for(int i = 0; i < 50; i++) {
            trucks.add(new PointF(100, 1200));
        }

        for(int i = 0; i < 50; i++) {
            trucks.add(new PointF(500, 1200));
        }

        for(int i = 0; i < 50; i++) {
            tanks.add(new PointF(500, 300));
        }
        for(int i = 0; i < 50; i++) {
            tanks.add(new PointF(200, 300));
        }
        String lives = GameConstants.getDifficulty();
        if (lives.equals("Easy (3 Lives)")) {
            numLives = 3;
        } else if (lives.equals("Medium (2 Lives)")) {
            numLives = 2;
        } else {
            numLives = 1;
        }
    }

    public void render() {
        Canvas c = holder.lockCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(80);
        c.drawColor(Color.BLACK);
        c.drawBitmap(GameCharacters.BACKGROUND.getSprite(), 0, 0, null);
        c.drawBitmap(player.getPlayerSprite(), player.getX(), player.getY(), null);


        String name = GameConstants.getName();
        String lives = "Lives: " + numLives;
        c.drawText(name, 30, 80, paint);
        c.drawText(lives, 800, 80, paint);
        String score = "Score: " + num;
        c.drawText(score,400, 80, paint);


        for(PointF pos: vehicles) {
            c.drawBitmap(GameCharacters.VEHICLE.getSprite(), pos.x, pos.y, null);
        }

        for(PointF pos: trucks) {
            c.drawBitmap(GameCharacters.TRUCK.getSprite(), pos.x, pos.y, null);
        }

        for(PointF pos: tanks) {
            c.drawBitmap(GameCharacters.TANK.getSprite(), pos.x, pos.y, null);
        }

        holder.unlockCanvasAndPost(c);

    }


    public void update(double delta) {
        Player p = new Player();
        PointF playerPos = new PointF(p.getX(), p.getY());
        for (PointF vehiclePos : vehicles) {
            if (doVehiclesCollide(playerPos, vehiclePos)) {
                p.resetPosition();
                break;
            }
        }
        for (PointF truckPos : trucks) {
            if (doVehiclesCollide(playerPos, truckPos)) {
                p.resetPosition();
                break;
            }
        }
        for (PointF tankPos : tanks) {
            if (doVehiclesCollide(playerPos, tankPos)) {
                p.resetPosition();
                break;
            }
        }
        for(PointF pos: vehicles) {
             pos.x += delta * 800;

             if(pos.x >= getWidth()) {
                 pos.x = 0;
             }


         }
        for(PointF pos: trucks) {
            pos.x += delta * 500;

            if(pos.x >= getWidth()) {
                pos.x = 0;
            }

        }
        for(PointF pos: tanks) {
            pos.x += delta * 200;

            if(pos.x >= getWidth()) {
                pos.x = 0;
            }


        }

    }

    // checks whether the cop car vehicles collide or not
    public boolean doVehiclesCollide(PointF pos1, PointF pos2) {
        // calculate the boxes for the two vehicles
        RectF box1 = new RectF(pos1.x - VEHICLE_WIDTH / 2, pos1.y - VEHICLE_HEIGHT / 2,
                pos1.x + VEHICLE_WIDTH / 2, pos1.y + VEHICLE_HEIGHT / 2);
        RectF box2 = new RectF(pos2.x - VEHICLE_WIDTH / 2, pos2.y - VEHICLE_HEIGHT / 2,
                pos2.x + VEHICLE_WIDTH / 2, pos2.y + VEHICLE_HEIGHT / 2);
        return box1.intersect(box2);
    }

    // getter method for vehicles
    public ArrayList<PointF> getVehicles() {
        return vehicles;
    }

    // getter method for trucks
    public ArrayList<PointF> getTrucks () {
        return trucks;
    }

    // getter method for tanks
    public ArrayList<PointF> getTanks() {
        return tanks;
    }

    public static void setPoints(int x) {
        num += x;
    }

    public static void setLives() {
        if (numLives == 1) {
            numLives -= 1;
            //reset
        } else {
            numLives -= 1;
        }
    }
    public static void setTracker(int yCoor) {
        tracker = yCoor;
    }

    public static int getTracker() {
        return tracker;
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        gameLoop.startGameLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    public void checkCollisionWithVehicles() {
        RectF playerRect = new RectF(Player.getX(), Player.getY(),
                Player.getX() + Player.getPlayerSprite().getWidth(),
                Player.getY() + Player.getPlayerSprite().getHeight());

        for (PointF vehicle : vehicles) {
            RectF vehicleRect = new RectF(vehicle.x, vehicle.y,
                    vehicle.x + VEHICLE_WIDTH, vehicle.y + GameCharacters.VEHICLE.getSprite().getHeight());

            if (playerRect.intersect(vehicleRect)) {
                // Collision detected, decrement score
                if (num > 0) {
                    GamePanel.setPoints(-((num / 2) + 1));
                }
                GamePanel.setLives();
                Player.setX("reset");
                Player.setY("reset");
                // Remove the vehicle from the list
                vehicles.remove(vehicle);
                break;
            }
        }
    }

    public void checkCollisionWithTrucks() {
        RectF playerRect = new RectF(Player.getX(), Player.getY(),
                Player.getX() + Player.getPlayerSprite().getWidth(),
                Player.getY() + Player.getPlayerSprite().getHeight());

        for (PointF tank : tanks) {
            RectF vehicleRect = new RectF(tank.x, tank.y,
                    tank.x + VEHICLE_WIDTH, tank.y + GameCharacters.TANK.getSprite().getHeight());

            if (playerRect.intersect(vehicleRect)) {
                // Collision detected, decrement score
                if (num > 0) {
                    GamePanel.setPoints(-((num / 2) + 1));
                }
                GamePanel.setLives();
                Player.setX("reset");
                Player.setY("reset");
                // Remove the vehicle from the list
                tanks.remove(tank);
                break;
            }
        }
    }

    public void checkCollisionWithTanks() {
        RectF playerRect = new RectF(Player.getX(), Player.getY(),
                Player.getX() + Player.getPlayerSprite().getWidth(),
                Player.getY() + Player.getPlayerSprite().getHeight());

        for (PointF truck : trucks) {
            RectF vehicleRect = new RectF(truck.x, truck.y,
                    truck.x + VEHICLE_WIDTH, truck.y + GameCharacters.TRUCK.getSprite().getHeight());

            if (playerRect.intersect(vehicleRect)) {
                // Collision detected, decrement score
                if (num > 0) {
                    GamePanel.setPoints(-((num / 2) + 1));
                }
                GamePanel.setLives();
                Player.setX("reset");
                Player.setY("reset");
                // Remove the vehicle from the list
                trucks.remove(truck);
                break;
            }
        }
    }

}
