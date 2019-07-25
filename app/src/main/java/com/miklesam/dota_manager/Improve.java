package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.miklesam.dota_manager.YourTeam.ExtraFarming;
import static com.miklesam.dota_manager.YourTeam.ExtraFighting;
import static com.miklesam.dota_manager.YourTeam.ExtraLaining;
import static com.miklesam.dota_manager.YourTeam.ExtraLate;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.XPstatic;

public class Improve extends AppCompatActivity {
    ImageView backtomain;
    TextView ExLaining;
    TextView ExFarming;
    TextView ExFighting;
    TextView ExLateGame;

    ImageView LainingPlus;
    ImageView FarmingPlus;
    ImageView FightingPlus;
    ImageView LateGamePlus;

    ImageView LainingMinus;
    ImageView FarmingMinus;
    ImageView FightingMinus;
    ImageView LateGameMinus;


    int XPint;
    int ExLainingint;
    int ExFarmingint;
    int ExFightingint;
    int ExLateint;

    int cnt_plus_laining;
    int cnt_plus_farming;
    int cnt_plus_fighting;
    int cnt_plus_lategame;
    boolean changexp;
    ImageView saveimprovements;

    TextView XPcnt;

    SharedPreferences mSettings;
    boolean lock;


    @Override
    public void onResume() {
        super.onResume();
        if (lock==true)
        {
            Intent k = new Intent(this, MainActivity.class);
            startActivity(k);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        lock=true;

    }
    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        cnt_plus_laining=0;
        cnt_plus_farming=0;
        cnt_plus_fighting=0;
        cnt_plus_lategame=0;

        ExLaining=findViewById(R.id.ExtraLaining);
        ExFarming=findViewById(R.id.ExtraFarming);
        ExFighting=findViewById(R.id.ExtraFighting);
        ExLateGame=findViewById(R.id.ExtraLateGame);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);

        saveimprovements=findViewById(R.id.saveimprovements);

        XPcnt=findViewById(R.id.xpcnt);
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

        XPcnt.setText(String.valueOf(XPint));



        backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(changexp==false)
                {
                    startActivity(Tomainstate);
                }
                else
                {
                    backtomain.setImageResource(R.drawable.back_bttn);
                    changexp=false;
                    cnt_plus_laining=0;
                    cnt_plus_farming=0;
                    cnt_plus_fighting=0;
                    cnt_plus_lategame=0;
                    if(mSettings.contains(XPstatic)) {
                        XPint=Integer.parseInt(mSettings.getString(XPstatic, "0"));
                    }
                    XPcnt.setText(String.valueOf(XPint));

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



                }




            }
        });



        saveimprovements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    backtomain.setImageResource(R.drawable.back_bttn);
                    changexp=false;
                    cnt_plus_laining=0;
                    cnt_plus_farming=0;
                    cnt_plus_fighting=0;
                    cnt_plus_lategame=0;


                    SharedPreferences.Editor editor = mSettings.edit();
                    editor.putString(XPstatic,String.valueOf(XPint));

                    editor.putString(ExtraLaining,String.valueOf(ExLainingint));
                    editor.putString(ExtraFarming,String.valueOf(ExFarmingint));
                    editor.putString(ExtraFighting,String.valueOf(ExFightingint));
                    editor.putString(ExtraLate,String.valueOf(ExLateint));
                    editor.apply();

                    ExLaining.setText(String.valueOf(ExLainingint));
                    ExFarming.setText(String.valueOf(ExFarmingint));
                    ExFighting.setText(String.valueOf(ExFightingint));
                    ExLateGame.setText(String.valueOf(ExLateint));
                    startActivity(Tomainstate);



            }
        });





        LainingPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (XPint>0)
                {
                    cnt_plus_laining=cnt_plus_laining+1;
                    XPint=XPint-1;
                    XPcnt.setText(String.valueOf(XPint));
                    ExLainingint=ExLainingint+1;
                    ExLaining.setText(String.valueOf(ExLainingint));
                    backtomain.setImageResource(R.drawable.cancel_bttn);
                    changexp=true;
                }


            }
        });

        LainingMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cnt_plus_laining>0)
                {
                    cnt_plus_laining=cnt_plus_laining-1;
                    XPint=XPint+1;
                    XPcnt.setText(String.valueOf(XPint));
                    ExLainingint=ExLainingint-1;
                    ExLaining.setText(String.valueOf(ExLainingint));
                }


            }
        });


        FarmingPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (XPint>0)
                {
                    cnt_plus_farming=cnt_plus_farming+1;
                    XPint=XPint-1;
                    XPcnt.setText(String.valueOf(XPint));
                    ExFarmingint=ExFarmingint+1;
                    ExFarming.setText(String.valueOf(ExFarmingint));
                    backtomain.setImageResource(R.drawable.cancel_bttn);
                    changexp=true;
                }


            }
        });

        FarmingMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cnt_plus_farming>0)
                {
                    cnt_plus_farming=cnt_plus_farming-1;
                    XPint=XPint+1;
                    XPcnt.setText(String.valueOf(XPint));
                    ExFarmingint=ExFarmingint-1;
                    ExFarming.setText(String.valueOf(ExFarmingint));
                }



            }
        });


        FightingPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (XPint>0)
                {
                    cnt_plus_fighting=cnt_plus_fighting+1;
                    XPint=XPint-1;
                    XPcnt.setText(String.valueOf(XPint));
                    ExFightingint=ExFightingint+1;
                    ExFighting.setText(String.valueOf(ExFightingint));
                    backtomain.setImageResource(R.drawable.cancel_bttn);
                    changexp=true;
                }


            }
        });

        FightingMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cnt_plus_fighting>0)
                {
                    cnt_plus_fighting=cnt_plus_fighting-1;
                    XPint=XPint+1;
                    XPcnt.setText(String.valueOf(XPint));
                    ExFightingint=ExFightingint-1;
                    ExFighting.setText(String.valueOf(ExFightingint));
                }



            }
        });



        LateGamePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (XPint>0)
                {
                    cnt_plus_lategame=cnt_plus_lategame+1;
                    XPint=XPint-1;
                    XPcnt.setText(String.valueOf(XPint));
                    ExLateint=ExLateint+1;
                    ExLateGame.setText(String.valueOf(ExLateint));
                    backtomain.setImageResource(R.drawable.cancel_bttn);
                    changexp=true;
                }


            }
        });



        LateGameMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cnt_plus_lategame>0)
                {
                    cnt_plus_lategame=cnt_plus_lategame-1;
                    XPint=XPint+1;
                    XPcnt.setText(String.valueOf(XPint));
                    ExLateint=ExLateint-1;
                    ExLateGame.setText(String.valueOf(ExLateint));

                }



            }
        });







    }
}
