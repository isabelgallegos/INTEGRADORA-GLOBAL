package com.first.diana.mi.prueba_menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.afdroid.mi.prueba_menu.R;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screem);

        new Handler ().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, VideoIntroduction.class);
                startActivity(intent);
            }
        },4000);
    }
}
