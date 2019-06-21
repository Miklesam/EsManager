package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.miklesam.dota_manager.YourTeam.ExtraFarming;
import static com.miklesam.dota_manager.YourTeam.ExtraFighting;
import static com.miklesam.dota_manager.YourTeam.ExtraLaining;
import static com.miklesam.dota_manager.YourTeam.ExtraLate;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.XPstatic;

public class Improve extends AppCompatActivity {
    Button backtomain;
    TextView ExLaining;
    TextView ExFarming;
    TextView ExFighting;
    TextView ExLateGame;

    Button LainingPlus;
    Button FarmingPlus;
    Button FightingPlus;
    Button LateGamePlus;

    Button LainingMinus;
    Button FarmingMinus;
    Button FightingMinus;
    Button LateGameMinus;


    int XPint;
    int ExLainingint;
    int ExFarmingint;
    int ExFightingint;
    int ExLateint;

    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);


        ExLaining=findViewById(R.id.ExtraLaining);
        ExFarming=findViewById(R.id.ExtraFarming);
        ExFighting=findViewById(R.id.ExtraFighting);
        ExLateGame=findViewById(R.id.ExtraLateGame);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);



        LainingPlus=findViewById(R.id.lainingplus);
        FarmingPlus=findViewById(R.id.farmingplus);
        FightingPlus=findViewById(R.id.fightingplus);
        LateGamePlus=findViewById(R.id.lategameplus);

        LainingMinus=findViewById(R.id.lainingminus);
        FarmingMinus=findViewById(R.id.farmingminus);
        FightingMinus=findViewById(R.id.fightingminus);
        LateGameMinus=findViewById(R.id.lategameminus);





        backtomain=findViewById(R.id.backtomain);
        final Intent Tomainstate = new Intent(this, mainstate.class);

        if(mSettings.contains(XPstatic)) {
            XPint=Integer.parseInt(mSettings.getString(XPstatic, "0"));
        }


        if(mSettings.contains(ExtraLaining)) {
            ExLainingint=Integer.parseInt(mSettings.getString(ExtraLaining, "0"));
        }
        if(mSettings.contains(ExtraFarming)) {
            ExFarmingint=Integer.parseInt(mSettings.getString(ExtraFarming, "0"));
        }
        if(mSettings.contains(ExtraFighting)) {
            ExFightingint=Integer.parseInt(mSettings.getString(ExtraFighting, "0"));
        }
        if(mSettings.contains(ExtraLate)) {
            ExLateint=Integer.parseInt(mSettings.getString(ExtraLate, "0"));
        }



        ExLaining.setText(String.valueOf(ExLainingint));
        ExFarming.setText(String.valueOf(ExFarmingint));
        ExFighting.setText(String.valueOf(ExFightingint));
        ExLateGame.setText(String.valueOf(ExLateint));





        backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(Tomainstate);



            }
        });

    }
}
