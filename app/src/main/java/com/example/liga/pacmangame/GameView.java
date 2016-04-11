package com.example.liga.pacmangame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Liga on 11-04-2016.
 */
public class GameView extends View {

    Bitmap pacman = BitmapFactory.decodeResource(getResources(), R.drawable.pacman);
    Coin[] coins = new Coin[10];

    //The coordinates for our dear pacman: (0,0) is the top-left corner
    int pacx = 10;
    int pacy = 400;
    int h,w; //used for storing our height and width

    int points = 0;

    public void moveLeft(int x)
    {
        //still within our boundaries?
        if (pacx - x - pacman.getWidth() > 0)
            pacx = pacx - x;
        invalidate(); //redraw everything
    }

    public void moveUp(int y)
    {
        //still within our boundaries?
        if (pacy - y - pacman.getHeight() > 0)
            pacy = pacy - y;
        invalidate(); //redraw everything
    }

    public void moveDown(int y)
    {
        //still within our boundaries?
        if (pacy + y + pacman.getWidth() < h)
            pacy = pacy + y;
        invalidate(); //redraw everything
    }
    public void moveRight(int x)
    {
        //still within our boundaries?
        if (pacx + x + pacman.getWidth() < w)
            pacx = pacx + x;
        invalidate(); //redraw everything
    }


    /* The next 3 constructors are needed for the Android view system,
when we have a custom view.
 */
    public GameView(Context context) {
        super(context);

    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public GameView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    //In the onDraw we put all our code that should be
    //drawn whenever we update the screen.
    @Override
    protected void onDraw(Canvas canvas) {
        //Here we get the height and weight
        h = canvas.getHeight();
        w = canvas.getWidth();
        System.out.println("h = " + h + ", w = " + w);
        //Making a new paint object
        Paint paint = new Paint();
        //setting the color
        canvas.drawColor(Color.DKGRAY); //clear entire canvas to white color

        for(int i=0; i<10; i+=1){
            if((coins[i] == null)){
                coins[i] = new Coin(w, h);
                continue;
            }

            if (coins[i].x < pacx + 20 &&
                    coins[i].x + coins[i].r*2 > pacx &&
                    coins[i].y < pacy + 20 &&
                    coins[i].r*2 + coins[i].y > pacy) {
                if(!coins[i].caught) {
                    coins[i].caught = true;
                    points++;
                }

            }

            if(!coins[i].caught){
                paint.setColor(coins[i].color);
                canvas.drawCircle(coins[i].x,coins[i].y, coins[i].r, paint);
            }
        }

        canvas.drawBitmap(pacman, pacx, pacy, paint);
        super.onDraw(canvas);
    }


}
