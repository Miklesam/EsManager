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
import static com.miklesam.dota_manager.YourTeam.ClosedPlayofStage;
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
import static com.miklesam.dota_manager.YourTeam.Winner2Enemy;
import static com.miklesam.dota_manager.YourTeam.Winner2My;
import static com.miklesam.dota_manager.YourTeam.Winner3Enemy;
import static com.miklesam.dota_manager.YourTeam.Winner3My;

public class ClosedPlayoff extends AppCompatActivity {
    int enemyteam[]=new int[3];
    String YourTeam;
    SharedPreferences mSettings;
    ArrayList<Teams> AllPlayoffTeams= new ArrayList<Teams>();
    TextView Teamsplayoff[]= new TextView[12];
    ImageView Teamsplayofflogo[]= new ImageView[12];

    TextView Scoreplayoff[]= new TextView[12];
    Button playoffplay;
    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;

    int Winner1Myint;
    int Winner1Enemyint;
    int Winner2Myint;
    int Winner2Enemyint;
    int Winner3Myint;
    int Winner3Enemyint;
    int stage;
    int ClosedPlayofStageint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_playoff);

        playoffplay = findViewById(R.id.playoffplay);
        Teamsplayoff[0]=findViewById(R.id.Teamname1);
        Teamsplayoff[1]=findViewById(R.id.Teamname2);
        Teamsplayoff[2]=findViewById(R.id.Teamname3);
        Teamsplayoff[3]=findViewById(R.id.Teamname4);
        Teamsplayoff[4]=findViewById(R.id.Teamname5);
        Teamsplayoff[5]=findViewById(R.id.Teamname6);
        Teamsplayoff[6]=findViewById(R.id.Teamname7);
        Teamsplayoff[7]=findViewById(R.id.Teamname8);

        Teamsplayoff[8]=findViewById(R.id.Teamname9);
        Teamsplayoff[9]=findViewById(R.id.Teamname10);
        Teamsplayoff[10]=findViewById(R.id.Teamname11);
        Teamsplayoff[11]=findViewById(R.id.Teamname12);

        Teamsplayofflogo[0]=findViewById(R.id.Team1);
        Teamsplayofflogo[1]=findViewById(R.id.Team2);
        Teamsplayofflogo[2]=findViewById(R.id.Team3);
        Teamsplayofflogo[3]=findViewById(R.id.Team4);
        Teamsplayofflogo[4]=findViewById(R.id.Team5);
        Teamsplayofflogo[5]=findViewById(R.id.Team6);
        Teamsplayofflogo[6]=findViewById(R.id.Team7);
        Teamsplayofflogo[7]=findViewById(R.id.Team8);
        Teamsplayofflogo[8]=findViewById(R.id.Team9);
        Teamsplayofflogo[9]=findViewById(R.id.Team10);
        Teamsplayofflogo[10]=findViewById(R.id.Team11);
        Teamsplayofflogo[11]=findViewById(R.id.Team12);

        Scoreplayoff[0]=findViewById(R.id.Score1);
        Scoreplayoff[1]=findViewById(R.id.Score2);
        Scoreplayoff[2]=findViewById(R.id.Score3);
        Scoreplayoff[3]=findViewById(R.id.Score4);
        Scoreplayoff[4]=findViewById(R.id.Score5);
        Scoreplayoff[5]=findViewById(R.id.Score6);
        Scoreplayoff[6]=findViewById(R.id.Score7);
        Scoreplayoff[7]=findViewById(R.id.Score8);
        Scoreplayoff[8]=findViewById(R.id.Score9);
        Scoreplayoff[9]=findViewById(R.id.Score10);
        Scoreplayoff[10]=findViewById(R.id.Score11);
        Scoreplayoff[11]=findViewById(R.id.Score12);

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

        if(mSettings.contains(Winner2My)) {
            Winner2Myint=Integer.parseInt(mSettings.getString(Winner2My, "0"));
        }
        if(mSettings.contains(Winner2Enemy)) {
            Winner2Enemyint=Integer.parseInt(mSettings.getString(Winner2Enemy, "0"));
        }

        if(mSettings.contains(Winner3My)) {
            Winner3Myint=Integer.parseInt(mSettings.getString(Winner3My, "0"));
        }
        if(mSettings.contains(Winner3Enemy)) {
            Winner3Enemyint=Integer.parseInt(mSettings.getString(Winner3Enemy, "0"));
        }

        if(mSettings.contains(ClosedPlayofStage)) {
            ClosedPlayofStageint=Integer.parseInt(mSettings.getString(ClosedPlayofStage, "0"));
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


        if(Winner1Enemyint==2)
        {
            Teamsplayoff[4].setText(YourTeam);
            Teamsplayofflogo[4].setImageResource(R.drawable.teamlogo);

            Teamsplayoff[6].setText(AllPlayoffTeams.get(enemyteam[0]).teamname);
            Teamsplayofflogo[6].setImageResource(AllPlayoffTeams.get(enemyteam[0]).logo);

            stage=2;


        }
        else if(Winner1Myint==2)
        {
            Teamsplayoff[6].setText(YourTeam);
            Teamsplayofflogo[6].setImageResource(R.drawable.teamlogo);

            Teamsplayoff[4].setText(AllPlayoffTeams.get(enemyteam[0]).teamname);
            Teamsplayofflogo[4].setImageResource(AllPlayoffTeams.get(enemyteam[0]).logo);
            stage=1;
        }

        Teamsplayoff[7].setText(AllPlayoffTeams.get(enemyteam[1]).teamname);
        Teamsplayofflogo[7].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);

        Teamsplayoff[5].setText(AllPlayoffTeams.get(enemyteam[2]).teamname);
        Teamsplayofflogo[5].setImageResource(AllPlayoffTeams.get(enemyteam[2]).logo);

        Scoreplayoff[2].setText("2");
        Scoreplayoff[3].setText("1");


        if(ClosedPlayofStageint>0)
        {
            Scoreplayoff[4].setText(String.valueOf(Winner2Myint));
            Scoreplayoff[5].setText(String.valueOf(Winner2Enemyint));

            if(ClosedPlayofStageint==2)
            {
                if(Winner2Enemyint==2)
                {


                    Teamsplayoff[9].setText(AllPlayoffTeams.get(enemyteam[2]).teamname);
                    Teamsplayofflogo[9].setImageResource(AllPlayoffTeams.get(enemyteam[2]).logo);

                    //stage=2;


                }
                else if(Winner2Myint==2)
                {
                    Teamsplayoff[9].setText(YourTeam);
                    Teamsplayofflogo[9].setImageResource(R.drawable.teamlogo);
                    stage=3;
                }

                Teamsplayoff[10].setText(AllPlayoffTeams.get(enemyteam[0]).teamname);
                Teamsplayofflogo[10].setImageResource(AllPlayoffTeams.get(enemyteam[0]).logo);
                Teamsplayoff[8].setText(AllPlayoffTeams.get(enemyteam[1]).teamname);
                Teamsplayofflogo[8].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);
                Scoreplayoff[6].setText("2");
                Scoreplayoff[7].setText("1");


            }
            else if(ClosedPlayofStageint==3)
            {
                if(Winner3Enemyint==2)
                {


                    Teamsplayoff[11].setText(AllPlayoffTeams.get(enemyteam[1]).teamname);
                    Teamsplayofflogo[11].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);

                    //stage=2;


                }
                else if(Winner3Myint==2)
                {
                    Teamsplayoff[11].setText(YourTeam);
                    Teamsplayofflogo[11].setImageResource(R.drawable.teamlogo);
                    stage=4;
                }
                Scoreplayoff[8].setText(String.valueOf(Winner3Enemyint));
                Scoreplayoff[9].setText(String.valueOf(Winner3Myint));

            }


        }



        playoffplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(stage==2)
                    {
                        ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[2]).seq);
                        ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[2]).teamname);

                        editor.putString(ClosedPlayofStage, "2");
                        editor.apply();
                    }
                    else if(stage==3)
                    {
                        ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[1]).seq);
                        ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[1]).teamname);

                        editor.putString(ClosedPlayofStage, "3");
                        editor.apply();
                    }
                    else
                    {
                        ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[0]).seq);
                        ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[0]).teamname);
                    }


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
