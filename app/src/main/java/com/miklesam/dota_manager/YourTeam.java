package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YourTeam extends AppCompatActivity {
    public static final String APP_PREFERENCES_NAME = "TeamName";
    public static final String GoldBalance = "50000";
    public static final String StaticPosition1 = "pos1";
    public static final String StaticPosition2 = "pos2";
    public static final String StaticPosition3 = "pos3";
    public static final String StaticPosition4 = "pos4";
    public static final String StaticPosition5 = "pos5";
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_your_team);
        final Intent ChoosePlayer = new Intent(this, PlayerChoose.class);
        TextView TeamTag=findViewById(R.id.TeamTag);
        TextView Gold=findViewById(R.id.gold);
        Button toPlayerChoose = findViewById(R.id.toPlayerChoose);
        mSettings = getSharedPreferences(APP_PREFERENCES_NAME , Context.MODE_PRIVATE);
        mSettings = getSharedPreferences(GoldBalance , Context.MODE_PRIVATE);

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("Name");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("Name");
        }

        TeamTag.setText("Welcome\nTeam: "+newString);
        Gold.setText("У Вас 50000 рублей\n"+
        "Наберите игроков и управляйте командой");


        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_NAME, newString);
        editor.apply();





        toPlayerChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ChoosePlayer);

            }
        });




    }
}
