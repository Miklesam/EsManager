package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

public class MainActivity extends AppCompatActivity {
    String Gold_to_Continie;
    String Your_team_name;

    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TypefaceUtil.overrideFont(getApplicationContext(), "SANS_SERIF", "fonts/16606.ttf");
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/16606.ttf");


        mSettings = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);

        TextView TextName=findViewById(R.id.TestName);
        TextView TestGold = findViewById(R.id.TestGold);
        TextName.setTypeface(type);
        TextName.setTypeface(type);

        Button NewGame = findViewById(R.id.new_game);
        Button Continue = findViewById(R.id.Continue);

        Button Store = findViewById(R.id.Store);
        Button Teams = findViewById(R.id.Teams);

                Continue.setTypeface(type);
                NewGame.setTypeface(type);
                Store.setTypeface(type);
                Teams.setTypeface(type);

        final Intent NewGameIntent = new Intent(this, TeamName.class);
        final Intent ToMAinState = new Intent(this, mainstate.class);
        final Intent ToTeamsShow = new Intent(this, TeamsShow.class);

        final String Player[]= new String[5];


        NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(NewGameIntent);

            }
        });

        if(mSettings.contains(StaticPosition1)) {
            Player[0]=mSettings.getString(StaticPosition1, "Pos1");
        }

        if(mSettings.contains(StaticPosition2)) {
            Player[1]=mSettings.getString(StaticPosition2, "Pos2");
        }

        if(mSettings.contains(StaticPosition3)) {
            Player[2]=mSettings.getString(StaticPosition3, "Pos3");
        }

        if(mSettings.contains(StaticPosition4)) {
            Player[3]=mSettings.getString(StaticPosition4, "Pos4");
        }

        if(mSettings.contains(StaticPosition5)) {
            Player[4]=mSettings.getString(StaticPosition5, "Pos5");
        }




        if(mSettings.contains(GoldBalance)) {

            Gold_to_Continie =mSettings.getString(GoldBalance, "50000");
            TestGold.setText(Gold_to_Continie);
        }

        if(mSettings.contains(APP_PREFERENCES_NAME)) {

            Your_team_name =mSettings.getString(APP_PREFERENCES_NAME, "Your Team");
            TextName.setText(Your_team_name);
        }


        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToMAinState.putExtra("Position1",Player[0]);
                ToMAinState.putExtra("Position2",Player[1]);
                ToMAinState.putExtra("Position3",Player[2]);
                ToMAinState.putExtra("Position4",Player[3]);
                ToMAinState.putExtra("Position5",Player[4]);
                ToMAinState.putExtra("Gold",Gold_to_Continie);
                ToMAinState.putExtra("TeamName",Your_team_name);




                startActivity(ToMAinState);

            }
        });




        Teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToTeamsShow);

            }
        });





    }
}
