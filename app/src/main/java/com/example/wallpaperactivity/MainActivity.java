package com.example.wallpaperactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button changeWallpaper;
    Timer myTimer;
    Drawable drawable;
    WallpaperManager wpm;
    int prev = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTimer = new Timer();
        wpm = WallpaperManager.getInstance(this);
        changeWallpaper = findViewById(R.id.button);
        changeWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    setWallpaper();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setWallpaper() throws IOException {
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (prev == 1) {
                    drawable = getResources().getDrawable(R.drawable.one);
                    prev = 2;
                } else if (prev == 2) {
                    drawable = getResources().getDrawable(R.drawable.two);
                    prev = 3;
                } else if (prev == 3) {
                    drawable = getResources().getDrawable(R.drawable.three);
                    prev = 4;
                } else if (prev == 4) {
                    drawable = getResources().getDrawable(R.drawable.four);
                    prev = 4;
                } else if (prev == 5) {
                    drawable = getResources().getDrawable(R.drawable.five);
                    prev = 1;
                }
                Bitmap wallpaper = ((BitmapDrawable) drawable).getBitmap();
                try {
                    wpm.setBitmap(wallpaper);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 30000);
    }
  }

















