package com.miklesam.dota_manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.TeamPlayoff2;
import static com.miklesam.dota_manager.YourTeam.TeamPlayoff3;
import static com.miklesam.dota_manager.YourTeam.TeamPlayoff4;

public class ClosedPlayoff extends AppCompatActivity {
    int enemyteam[]=new int[3];
    String YourTeam;
    SharedPreferences mSettings;
    ArrayList<Teams> AllPlayoffTeams= new ArrayList<Teams>();
    TextView Teamsplayoff[]= new TextView[4];
    ImageView Teamsplayofflogo[]= new ImageView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_playoff);

        Teamsplayoff[0]=findViewById(R.id.Teamname1);
        Teamsplayoff[1]=findViewById(R.id.Teamname2);
        Teamsplayoff[2]=findViewById(R.id.Teamname3);
        Teamsplayoff[3]=findViewById(R.id.Teamname4);

        Teamsplayofflogo[0]=findViewById(R.id.Team1);
        Teamsplayofflogo[1]=findViewById(R.id.Team2);
        Teamsplayofflogo[2]=findViewById(R.id.Team3);
        Teamsplayofflogo[3]=findViewById(R.id.Team4);

        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        if(mSettings.contains(TeamPlayoff2)) {
            enemyteam[0]=Integer.parseInt(mSettings.getString(TeamPlayoff2, "TeamPlayoff2"));
        }
        if(mSettings.contains(TeamPlayoff3)) {
            enemyteam[1]=Integer.parseInt(mSettings.getString(TeamPlayoff3, "TeamPlayoff3"));
        }
        if(mSettings.contains(TeamPlayoff4)) {
            enemyteam[2]=Integer.parseInt(mSettings.getString(TeamPlayoff4, "TeamPlayoff4"));
        }

        if (mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam = mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

        }



        AllTeams.clear();
        AllPlayoffTeams = AllTeamsInit();

        Teamsplayoff[0].setText(YourTeam);
        Teamsplayoff[1].setText(AllPlayoffTeams.get(enemyteam[0]).teamname);
        Teamsplayoff[2].setText(AllPlayoffTeams.get(enemyteam[1]).teamname);
        Teamsplayoff[3].setText(AllPlayoffTeams.get(enemyteam[2]).teamname);

        Teamsplayofflogo[0].setImageResource(R.drawable.teamlogo);
        Teamsplayofflogo[1].setImageResource(AllPlayoffTeams.get(enemyteam[0]).logo);
        Teamsplayofflogo[2].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);
        Teamsplayofflogo[3].setImageResource(AllPlayoffTeams.get(enemyteam[2]).logo);

    }
}
