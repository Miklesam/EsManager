package com.miklesam.dota_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Shop extends AppCompatActivity {

    ImageView back_from_shopbut;
    ImageView rewardedBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        final Intent ToMain = new Intent(this, MainActivity.class);
        final Intent ToRewarded = new Intent(this, Rewarded.class);
        rewardedBut=findViewById(R.id.rewarded);
        back_from_shopbut=findViewById(R.id.back_from_shop);

        back_from_shopbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToMain);

            }
        });

        rewardedBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToRewarded);

            }
        });



    }
}
