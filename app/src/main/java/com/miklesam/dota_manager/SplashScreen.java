package com.miklesam.dota_manager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundResource(R.drawable.new_splashscreen);

            View easySplashScreen=config.create();
            setContentView(easySplashScreen);

    }
}
