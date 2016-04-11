package com.example.liga.pacmangame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

/**
 * Created by Liga on 11-04-2016.
 */
public class Coin {

    int x = 0;
    int y = 0;
    int r = 20;
    boolean caught = false;
    int color = Color.BLUE;

    Paint paint = new Paint(color);

    public Coin() {}

    public Coin(int maxw, int maxh) {
        Random nbx = new Random();
        this.x = nbx.nextInt(maxw);
        Random nby = new Random();
        this.y = nby.nextInt(maxh);
    }

    public void newPosition(int maxw, int maxh) {
        Random nbx = new Random();
        this.x = nbx.nextInt(maxw);
        Random nby = new Random();
        this.y = nby.nextInt(maxh);
    }
}
