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

    //The coordinates for our dear pacman: (0,0) is the top-left corner
    int pacx = 10;
    int pacy = 400;
    int h,w; //used for storing our height and width

    public void moveRight(int x)
    {
        //still within our boundaries?
        if (pacx+x+pacman.getWidth()<w)
            pacx=pacx+x;
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
        super(context,attrs,defStyleAttr);
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

        canvas.drawBitmap(pacman, pacx, pacy, paint);
        super.onDraw(canvas);
    }


}
