package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Mode;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;
import static com.miklesam.dota_manager.YourTeam.TeamPlayoff2;
import static com.miklesam.dota_manager.YourTeam.TeamPlayoff3;
import static com.miklesam.dota_manager.YourTeam.TeamPlayoff4;
import static com.miklesam.dota_manager.YourTeam.Winner1Enemy;
import static com.miklesam.dota_manager.YourTeam.Winner1My;

public class ClosedPlayoff extends AppCompatActivity {
    int enemyteam[]=new int[3];
    String YourTeam;
    SharedPreferences mSettings;
    ArrayList<Teams> AllPlayoffTeams= new ArrayList<Teams>();
    TextView Teamsplayoff[]= new TextView[4];
    ImageView Teamsplayofflogo[]= new ImageView[4];

    TextView Scoreplayoff[]= new TextView[4];
    Button playoffplay;
    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;

    int Winner1Myint;
    int Winner1Enemyint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_playoff);

        playoffplay = findViewById(R.id.playoffplay);
        Teamsplayoff[0]=findViewById(R.id.Teamname1);
        Teamsplayoff[1]=findViewById(R.id.Teamname2);
        Teamsplayoff[2]=findViewById(R.id.Teamname3);
        Teamsplayoff[3]=findViewById(R.id.Teamname4);

        Teamsplayofflogo[0]=findViewById(R.id.Team1);
        Teamsplayofflogo[1]=findViewById(R.id.Team2);
        Teamsplayofflogo[2]=findViewById(R.id.Team3);
        Teamsplayofflogo[3]=findViewById(R.id.Team4);

        Scoreplayoff[0]=findViewById(R.id.Score1);
        Scoreplayoff[1]=findViewById(R.id.Score2);
        Scoreplayoff[2]=findViewById(R.id.Score3);
        Scoreplayoff[3]=findViewById(R.id.Score4);

        final Intent ToPickStage = new Intent(this, Pick_Stage.class);

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

        if (mSettings.contains(StaticPosition1)) {
            Pos1 = Integer.parseInt(mSettings.getString(StaticPosition1, "Position1"));
        }

        if (mSettings.contains(StaticPosition2)) {
            Pos2 = Integer.parseInt(mSettings.getString(StaticPosition2, "Position2"));
        }

        if (mSettings.contains(StaticPosition3)) {
            Pos3 = Integer.parseInt(mSettings.getString(StaticPosition3, "Position3"));
        }

        if (mSettings.contains(StaticPosition4)) {
            Pos4 = Integer.parseInt(mSettings.getString(StaticPosition4, "Position4"));
        }

        if (mSettings.contains(StaticPosition5)) {
            Pos5 = Integer.parseInt(mSettings.getString(StaticPosition5, "Position5"));
        }

        if(mSettings.contains(Winner1My)) {
            Winner1Myint=Integer.parseInt(mSettings.getString(Winner1My, "0"));
        }
        if(mSettings.contains(Winner1Enemy)) {
            Winner1Enemyint=Integer.parseInt(mSettings.getString(Winner1Enemy, "0"));
        }

        Scoreplayoff[0].setText(String.valueOf(Winner1Myint));
        Scoreplayoff[1].setText(String.valueOf(Winner1Enemyint));


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

        final SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(Mode, "3");
        editor.apply();
        playoffplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                        ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[0]).seq);
                        ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[0]).teamname);
                        ToPickStage.putExtra("Position1",Pos1);
                        ToPickStage.putExtra("Position2",Pos2);
                        ToPickStage.putExtra("Position3",Pos3);
                        ToPickStage.putExtra("Position4",Pos4);
                        ToPickStage.putExtra("Position5",Pos5);
                        ToPickStage.putExtra("TeamName",YourTeam);
                        startActivity(ToPickStage);







            }
        });

    }
}
