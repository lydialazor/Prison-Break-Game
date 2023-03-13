package com.example.prison_break;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.prison_break.entities.GameCharacters;
import com.example.prison_break.helpers.GameConstants;

import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private Paint player1hair = new Paint();
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
    }

    public void render() {
        Canvas c = holder.lockCanvas();
        Player p = new Player();
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(80);
        c.drawColor(Color.BLACK);
        c.drawBitmap(GameCharacters.BACKGROUND.getSprite(), 0, 0, null);
        c.drawBitmap(p.getPlayerSprite(), p.getX(), p.getY(), null);
        String name = GameConstants.getName();
        String lives = GameConstants.getDifficulty();
        if (lives.equals("Easy (3 Lives")) {
            lives = "Lives: " + 3;
        } else if (lives.equals("Medium (2 Lives")) {
            lives = "Lives: " + 2;
        } else {
            lives = "Lives: " + 1;
        }
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

         for(PointF pos: vehicles) {
             pos.x += delta * 800;

             if(pos.x >= 1920) {
                 pos.x = 0;
             }
         }
        for(PointF pos: trucks) {
            pos.x += delta * 500;

            if(pos.x >= 1920) {
                pos.x = 0;
            }
        }
        for(PointF pos: tanks) {
            pos.x += delta * 200;

            if(pos.x >= 1920) {
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

}
