package com.example.liga.pacmangame;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button leftButton = (Button) findViewById(R.id.leftButton);
        Button upButton = (Button) findViewById(R.id.upButton);
        Button downButton = (Button) findViewById(R.id.downButton);
        Button rightButton = (Button) findViewById(R.id.rightButton);

        gameView = (GameView) findViewById(R.id.gameView);

        //listener of our pacman
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.moveLeft(10);
            }
        });

        upButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.moveUp(10);
            }
        });

        downButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.moveDown(10);
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.moveRight(10);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
