package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.CloseLose1;
import static com.miklesam.dota_manager.YourTeam.CloseLose2;
import static com.miklesam.dota_manager.YourTeam.CloseLose3;
import static com.miklesam.dota_manager.YourTeam.CloseLose4;
import static com.miklesam.dota_manager.YourTeam.CloseLose5;
import static com.miklesam.dota_manager.YourTeam.CloseLose6;
import static com.miklesam.dota_manager.YourTeam.CloseLose7;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff1;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff10;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff11;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff12;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff2;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff3;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff4;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff5;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff6;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff7;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff8;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff9;
import static com.miklesam.dota_manager.YourTeam.CloseScore1;
import static com.miklesam.dota_manager.YourTeam.CloseScore10;
import static com.miklesam.dota_manager.YourTeam.CloseScore11;
import static com.miklesam.dota_manager.YourTeam.CloseScore12;
import static com.miklesam.dota_manager.YourTeam.CloseScore2;
import static com.miklesam.dota_manager.YourTeam.CloseScore3;
import static com.miklesam.dota_manager.YourTeam.CloseScore4;
import static com.miklesam.dota_manager.YourTeam.CloseScore5;
import static com.miklesam.dota_manager.YourTeam.CloseScore6;
import static com.miklesam.dota_manager.YourTeam.CloseScore7;
import static com.miklesam.dota_manager.YourTeam.CloseScore8;
import static com.miklesam.dota_manager.YourTeam.CloseScore9;
import static com.miklesam.dota_manager.YourTeam.CloseShaffle;
import static com.miklesam.dota_manager.YourTeam.CloseTeam1;
import static com.miklesam.dota_manager.YourTeam.CloseTeam2;
import static com.miklesam.dota_manager.YourTeam.CloseTeam3;
import static com.miklesam.dota_manager.YourTeam.CloseTeam4;
import static com.miklesam.dota_manager.YourTeam.CloseTeam5;
import static com.miklesam.dota_manager.YourTeam.CloseTeam6;
import static com.miklesam.dota_manager.YourTeam.CloseTeam7;
import static com.miklesam.dota_manager.YourTeam.CloseWin1;
import static com.miklesam.dota_manager.YourTeam.CloseWin2;
import static com.miklesam.dota_manager.YourTeam.CloseWin3;
import static com.miklesam.dota_manager.YourTeam.CloseWin4;
import static com.miklesam.dota_manager.YourTeam.CloseWin5;
import static com.miklesam.dota_manager.YourTeam.CloseWin6;
import static com.miklesam.dota_manager.YourTeam.CloseWin7;
import static com.miklesam.dota_manager.YourTeam.ClosedPlayofStage;
import static com.miklesam.dota_manager.YourTeam.ClosedSeries;
import static com.miklesam.dota_manager.YourTeam.Closedlose;
import static com.miklesam.dota_manager.YourTeam.Closedwin;
import static com.miklesam.dota_manager.YourTeam.Day;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.MinorQual;
import static com.miklesam.dota_manager.YourTeam.Mode;
import static com.miklesam.dota_manager.YourTeam.OpenQualiWinner;
import static com.miklesam.dota_manager.YourTeam.Series1Win;
import static com.miklesam.dota_manager.YourTeam.Series2Win;
import static com.miklesam.dota_manager.YourTeam.Series3Win;
import static com.miklesam.dota_manager.YourTeam.Series4Win;
import static com.miklesam.dota_manager.YourTeam.Series5Win;
import static com.miklesam.dota_manager.YourTeam.Series6Win;
import static com.miklesam.dota_manager.YourTeam.Series7Win;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;
import static com.miklesam.dota_manager.YourTeam.TeamPlayoff2;
import static com.miklesam.dota_manager.YourTeam.TeamPlayoff3;
import static com.miklesam.dota_manager.YourTeam.TeamPlayoff4;


public class ClosedPlayoff extends AppCompatActivity {
    int enemyteam[]=new int[3];
    String YourTeam;
    SharedPreferences mSettings;
    ArrayList<Teams> AllPlayoffTeams= new ArrayList<Teams>();
    TextView Teamsplayoff[]= new TextView[12];
    ImageView Teamsplayofflogo[]= new ImageView[12];

    TextView Scoreplayoff[]= new TextView[12];
    ImageView playoffplay;
    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;

    int Score[] = new int[12];
    int Teamsplayoffs[]=new int [12];
    int Dayint;
    boolean   to_final=false;
    int ClosedPlayofStageint;
    int Minorornot;

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
        final Intent Tomainstate = new Intent(this, mainstate.class);

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



        if(mSettings.contains(ClosedPlayofStage)) {
            ClosedPlayofStageint=Integer.parseInt(mSettings.getString(ClosedPlayofStage, "0"));
        }
        if(mSettings.contains(CloseScore1)) {
            Score[0]=Integer.parseInt(mSettings.getString(CloseScore1, "0"));
        }
        if(mSettings.contains(CloseScore2)) {
            Score[1]=Integer.parseInt(mSettings.getString(CloseScore2, "0"));
        }
        if(mSettings.contains(CloseScore3)) {
            Score[2]=Integer.parseInt(mSettings.getString(CloseScore3, "0"));
        }
        if(mSettings.contains(CloseScore4)) {
            Score[3]=Integer.parseInt(mSettings.getString(CloseScore4, "0"));
        }
        if(mSettings.contains(CloseScore5)) {
            Score[4]=Integer.parseInt(mSettings.getString(CloseScore5, "0"));
        }
        if(mSettings.contains(CloseScore6)) {
            Score[5]=Integer.parseInt(mSettings.getString(CloseScore6, "0"));
        }
        if(mSettings.contains(CloseScore7)) {
            Score[6]=Integer.parseInt(mSettings.getString(CloseScore7, "0"));
        }
        if(mSettings.contains(CloseScore8)) {
            Score[7]=Integer.parseInt(mSettings.getString(CloseScore8, "0"));
        }
        if(mSettings.contains(CloseScore9)) {
            Score[8]=Integer.parseInt(mSettings.getString(CloseScore9, "0"));
        }
        if(mSettings.contains(CloseScore10)) {
            Score[9]=Integer.parseInt(mSettings.getString(CloseScore10, "0"));
        }
        if(mSettings.contains(CloseScore11)) {
            Score[10]=Integer.parseInt(mSettings.getString(CloseScore11, "0"));
        }
        if(mSettings.contains(CloseScore12)) {
            Score[11]=Integer.parseInt(mSettings.getString(CloseScore12, "0"));
        }

        if(mSettings.contains(ClosePlayoff1)) {
            Teamsplayoffs[0]=Integer.parseInt(mSettings.getString(ClosePlayoff1, "0"));
        }
        if(mSettings.contains(ClosePlayoff2)) {
            Teamsplayoffs[1]=Integer.parseInt(mSettings.getString(ClosePlayoff2, "0"));
        }
        if(mSettings.contains(ClosePlayoff3)) {
            Teamsplayoffs[2]=Integer.parseInt(mSettings.getString(ClosePlayoff3, "0"));
        }
        if(mSettings.contains(ClosePlayoff4)) {
            Teamsplayoffs[3]=Integer.parseInt(mSettings.getString(ClosePlayoff4, "0"));
        }
        if(mSettings.contains(ClosePlayoff5)) {
            Teamsplayoffs[4]=Integer.parseInt(mSettings.getString(ClosePlayoff5, "0"));
        }
        if(mSettings.contains(ClosePlayoff6)) {
            Teamsplayoffs[5]=Integer.parseInt(mSettings.getString(ClosePlayoff6, "0"));
        }
        if(mSettings.contains(ClosePlayoff7)) {
            Teamsplayoffs[6]=Integer.parseInt(mSettings.getString(ClosePlayoff7, "0"));
        }
        if(mSettings.contains(ClosePlayoff8)) {
            Teamsplayoffs[7]=Integer.parseInt(mSettings.getString(ClosePlayoff8, "0"));
        }
        if(mSettings.contains(ClosePlayoff9)) {
            Teamsplayoffs[8]=Integer.parseInt(mSettings.getString(ClosePlayoff9, "0"));
        }
        if(mSettings.contains(ClosePlayoff10)) {
            Teamsplayoffs[9]=Integer.parseInt(mSettings.getString(ClosePlayoff10, "0"));
        }
        if(mSettings.contains(ClosePlayoff11)) {
            Teamsplayoffs[10]=Integer.parseInt(mSettings.getString(ClosePlayoff11, "0"));
        }
        if(mSettings.contains(ClosePlayoff12)) {
            Teamsplayoffs[11]=Integer.parseInt(mSettings.getString(ClosePlayoff12, "0"));
        }

        if(mSettings.contains(Day)) {
            Dayint=Integer.parseInt(mSettings.getString(Day, "0"));
        }

        if(mSettings.contains(MinorQual)) {
            Minorornot=Integer.parseInt(mSettings.getString(MinorQual, "0"));
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

        final SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(Mode, "3");
        editor.apply();



        Scoreplayoff[0].setText(String.valueOf(Score[0]));
        Scoreplayoff[1].setText(String.valueOf(Score[1]));
        if(ClosedPlayofStageint==1)
        {

            if(Score[0]==2)
            {
                Teamsplayoff[6].setText(YourTeam);
                Teamsplayofflogo[6].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[4].setText(AllPlayoffTeams.get(enemyteam[0]).teamname);
                Teamsplayofflogo[4].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);
                editor.putString(ClosedPlayofStage, "3");
                editor.putString(ClosePlayoff5, "1");
                editor.putString(ClosePlayoff7, "0");

                editor.putString(ClosePlayoff6, "3");
                editor.putString(ClosePlayoff8, "2");
                editor.putString(CloseScore3, "2");
                editor.putString(CloseScore4, "1");
                Score[2]=2;
                Score[3]=1;


            }
            else if (Score[1]==2)
            {
                Teamsplayoff[4].setText(YourTeam);
                Teamsplayofflogo[4].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[6].setText(AllPlayoffTeams.get(enemyteam[0]).teamname);
                Teamsplayofflogo[6].setImageResource(AllPlayoffTeams.get(enemyteam[0]).logo);
                editor.putString(ClosedPlayofStage, "2");
                editor.putString(ClosePlayoff5, "0");
                editor.putString(ClosePlayoff7, "1");

                editor.putString(ClosePlayoff6, "3");
                editor.putString(ClosePlayoff8, "2");
                editor.putString(CloseScore3, "2");
                editor.putString(CloseScore4, "1");
                Score[2]=2;
                Score[3]=1;
            }





            editor.apply();
        }
        else if(ClosedPlayofStageint==2)
        {
            if(Score[4]==2)
            {
                Teamsplayoff[9].setText(YourTeam);
                Teamsplayofflogo[9].setImageResource(R.drawable.teamlogo);
                editor.putString(ClosedPlayofStage, "4");
                editor.putString(ClosePlayoff9, "0");

                editor.putString(ClosePlayoff11, "1");
                editor.putString(ClosePlayoff9, "2");
                editor.putString(CloseScore7, "2");
                editor.putString(CloseScore8, "1");
                Score[6]=2;
                Score[7]=1;


            }
            else if (Score[5]==2)
            {
                Teamsplayoff[9].setText(AllPlayoffTeams.get(enemyteam[3]).teamname);
                Teamsplayofflogo[9].setImageResource(AllPlayoffTeams.get(enemyteam[3]).logo);
                editor.putString(ClosedPlayofStage, "9");
                editor.putString(ClosePlayoff9, "3");

                editor.putString(ClosePlayoff11, "1");
                editor.putString(ClosePlayoff9, "2");
                editor.putString(CloseScore7, "2");
                editor.putString(CloseScore8, "1");
                Score[6]=2;
                Score[7]=1;
            }
            editor.apply();
        }



        else if(ClosedPlayofStageint==3)
        {
            if(Score[6]==2)
            {
                Teamsplayoff[10].setText(YourTeam);
                Teamsplayofflogo[10].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[8].setText(AllPlayoffTeams.get(enemyteam[1]).teamname);
                Teamsplayofflogo[8].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);
                editor.putString(ClosedPlayofStage, "5");
                editor.putString(ClosePlayoff9, "2");
                editor.putString(ClosePlayoff10, "1");
                editor.putString(ClosePlayoff11, "0");
                editor.putString(CloseScore5, "2");
                editor.putString(CloseScore6, "1");



                Score[4]=2;
                Score[5]=1;



            }
            else if (Score[7]==2)
            {

                Teamsplayoff[10].setText(AllPlayoffTeams.get(enemyteam[1]).teamname);
                Teamsplayofflogo[10].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);
                Teamsplayoff[8].setText(YourTeam);
                Teamsplayofflogo[8].setImageResource(R.drawable.teamlogo);
                editor.putString(ClosedPlayofStage, "4");
                editor.putString(ClosePlayoff9, "0");
                editor.putString(ClosePlayoff11, "2");

                editor.putString(CloseScore5, "2");
                editor.putString(CloseScore6, "1");
                editor.putString(ClosePlayoff10, "1");


                Score[4]=2;
                Score[5]=1;

            }
            editor.apply();
        }

        else if(ClosedPlayofStageint==4)
        {

            if(Teamsplayoffs[8]==0)
            {
                if(Score[8]==2)
                {
                    Teamsplayoff[11].setText(YourTeam);
                    Teamsplayofflogo[11].setImageResource(R.drawable.teamlogo);
                    editor.putString(ClosedPlayofStage, "6");
                    editor.putString(ClosePlayoff12, "0");


                }
                else if (Score[9]==2)
                {

                    Teamsplayoff[11].setText(AllPlayoffTeams.get(enemyteam[1]).teamname);
                    Teamsplayofflogo[11].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);
                    editor.putString(ClosedPlayofStage, "9");
                    editor.putString(ClosePlayoff12, "2");
                }
            }
            else
            {
                if(Score[8]==2)
                {

                    Teamsplayoff[11].setText(AllPlayoffTeams.get(enemyteam[1]).teamname);
                    Teamsplayofflogo[11].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);
                    editor.putString(ClosedPlayofStage, "9");
                    editor.putString(ClosePlayoff12, "2");

                }
                else if (Score[9]==2)
                {
                    Teamsplayoff[11].setText(YourTeam);
                    Teamsplayofflogo[11].setImageResource(R.drawable.teamlogo);
                    editor.putString(ClosedPlayofStage, "6");
                    editor.putString(ClosePlayoff12, "0");
                }
            }

            editor.apply();
        }


        else if(ClosedPlayofStageint==6)
        {

            if(Teamsplayoffs[10]==0)
            {
                if(Score[10]==3)
                {
                    //playoffplay.setText("YouWinQuali");
                    playoffplay.setImageResource(R.drawable.leave_bttn);
                    editor.putString(ClosedPlayofStage, "7");
                }
                else if (Score[11]==3)
                {
                    //playoffplay.setText("YouLoseQuali");
                    playoffplay.setImageResource(R.drawable.leave_bttn);
                    editor.putString(ClosedPlayofStage, "8");
                }
            }
            else
            {
                if(Score[10]==3)
                {
                    //playoffplay.setText("YouLoseQuali");
                    playoffplay.setImageResource(R.drawable.leave_bttn);
                    editor.putString(ClosedPlayofStage, "8");
                }
                else if (Score[11]==3)
                {
                    //playoffplay.setText("YouWinQuali");
                    playoffplay.setImageResource(R.drawable.leave_bttn);
                    editor.putString(ClosedPlayofStage, "7");
                }
            }

            editor.apply();
        }



        if(mSettings.contains(ClosedPlayofStage)) {
            ClosedPlayofStageint=Integer.parseInt(mSettings.getString(ClosedPlayofStage, "1"));
        }
        if(mSettings.contains(ClosePlayoff1)) {
            Teamsplayoffs[0]=Integer.parseInt(mSettings.getString(ClosePlayoff1, "0"));
        }
        if(mSettings.contains(ClosePlayoff2)) {
            Teamsplayoffs[1]=Integer.parseInt(mSettings.getString(ClosePlayoff2, "0"));
        }
        if(mSettings.contains(ClosePlayoff3)) {
            Teamsplayoffs[2]=Integer.parseInt(mSettings.getString(ClosePlayoff3, "0"));
        }
        if(mSettings.contains(ClosePlayoff4)) {
            Teamsplayoffs[3]=Integer.parseInt(mSettings.getString(ClosePlayoff4, "0"));
        }
        if(mSettings.contains(ClosePlayoff5)) {
            Teamsplayoffs[4]=Integer.parseInt(mSettings.getString(ClosePlayoff5, "0"));
        }
        if(mSettings.contains(ClosePlayoff6)) {
            Teamsplayoffs[5]=Integer.parseInt(mSettings.getString(ClosePlayoff6, "0"));
        }
        if(mSettings.contains(ClosePlayoff7)) {
            Teamsplayoffs[6]=Integer.parseInt(mSettings.getString(ClosePlayoff7, "0"));
        }
        if(mSettings.contains(ClosePlayoff8)) {
            Teamsplayoffs[7]=Integer.parseInt(mSettings.getString(ClosePlayoff8, "0"));
        }
        if(mSettings.contains(ClosePlayoff9)) {
            Teamsplayoffs[8]=Integer.parseInt(mSettings.getString(ClosePlayoff9, "0"));
        }
        if(mSettings.contains(ClosePlayoff10)) {
            Teamsplayoffs[9]=Integer.parseInt(mSettings.getString(ClosePlayoff10, "0"));
        }
        if(mSettings.contains(ClosePlayoff11)) {
            Teamsplayoffs[10]=Integer.parseInt(mSettings.getString(ClosePlayoff11, "0"));
        }
        if(mSettings.contains(ClosePlayoff12)) {
            Teamsplayoffs[11]=Integer.parseInt(mSettings.getString(ClosePlayoff12, "0"));
        }


        if(ClosedPlayofStageint>1)
        {
            Scoreplayoff[2].setText(String.valueOf(Score[2]));
            Scoreplayoff[3].setText(String.valueOf(Score[3]));
            Scoreplayoff[4].setText(String.valueOf(Score[4]));
            Scoreplayoff[5].setText(String.valueOf(Score[5]));
            Scoreplayoff[6].setText(String.valueOf(Score[6]));
            Scoreplayoff[7].setText(String.valueOf(Score[7]));
            if (Teamsplayoffs[4]==0)
            {
                Teamsplayoff[4].setText(YourTeam);
                Teamsplayofflogo[4].setImageResource(R.drawable.teamlogo);
            }
            else
            {
                Teamsplayoff[4].setText(AllPlayoffTeams.get(enemyteam[Teamsplayoffs[4]-1]).teamname);
                Teamsplayofflogo[4].setImageResource((AllPlayoffTeams.get(enemyteam[Teamsplayoffs[4]-1]).logo));
            }
            if (Teamsplayoffs[6]==0)
            {
                Teamsplayoff[6].setText(YourTeam);
                Teamsplayofflogo[6].setImageResource(R.drawable.teamlogo);
            }
            else
            {
                Teamsplayoff[6].setText(AllPlayoffTeams.get(enemyteam[Teamsplayoffs[6]-1]).teamname);
                Teamsplayofflogo[6].setImageResource((AllPlayoffTeams.get(enemyteam[Teamsplayoffs[6]-1]).logo));
            }

            Teamsplayoff[5].setText(AllPlayoffTeams.get(enemyteam[Teamsplayoffs[5]-1]).teamname);
            Teamsplayofflogo[5].setImageResource((AllPlayoffTeams.get(enemyteam[Teamsplayoffs[5]-1]).logo));
            Teamsplayoff[7].setText(AllPlayoffTeams.get(enemyteam[Teamsplayoffs[7]-1]).teamname);
            Teamsplayofflogo[7].setImageResource((AllPlayoffTeams.get(enemyteam[Teamsplayoffs[7]-1]).logo));




        }

        if(ClosedPlayofStageint>3)
        {

            Scoreplayoff[8].setText(String.valueOf(Score[8]));
            Scoreplayoff[9].setText(String.valueOf(Score[9]));
            if (Teamsplayoffs[8]==0)
            {
                Teamsplayoff[8].setText(YourTeam);
                Teamsplayofflogo[8].setImageResource(R.drawable.teamlogo);
            }
            else
            {
                Teamsplayoff[8].setText(AllPlayoffTeams.get(enemyteam[Teamsplayoffs[8]-1]).teamname);
                Teamsplayofflogo[8].setImageResource((AllPlayoffTeams.get(enemyteam[Teamsplayoffs[8]-1]).logo));
            }
            if (Teamsplayoffs[9]==0)
            {
                Teamsplayoff[9].setText(YourTeam);
                Teamsplayofflogo[9].setImageResource(R.drawable.teamlogo);
            }
            else
            {
                Teamsplayoff[9].setText(AllPlayoffTeams.get(enemyteam[Teamsplayoffs[9]-1]).teamname);
                Teamsplayofflogo[9].setImageResource((AllPlayoffTeams.get(enemyteam[Teamsplayoffs[9]-1]).logo));
            }

            if (Teamsplayoffs[10]==0)
            {
                Teamsplayoff[10].setText(YourTeam);
                Teamsplayofflogo[10].setImageResource(R.drawable.teamlogo);
            }
            else
            {
                Teamsplayoff[10].setText(AllPlayoffTeams.get(enemyteam[Teamsplayoffs[10]-1]).teamname);
                Teamsplayofflogo[10].setImageResource((AllPlayoffTeams.get(enemyteam[Teamsplayoffs[10]-1]).logo));
            }




        }



        if(ClosedPlayofStageint>5)
        {

            Scoreplayoff[10].setText(String.valueOf(Score[10]));
            Scoreplayoff[11].setText(String.valueOf(Score[11]));

            if (Teamsplayoffs[11]==0)
            {
                Teamsplayoff[11].setText(YourTeam);
                Teamsplayofflogo[11].setImageResource(R.drawable.teamlogo);
            }
            else
            {
                Teamsplayoff[11].setText(AllPlayoffTeams.get(enemyteam[Teamsplayoffs[11]-1]).teamname);
                Teamsplayofflogo[11].setImageResource((AllPlayoffTeams.get(enemyteam[Teamsplayoffs[11]-1]).logo));
            }










        }




        playoffplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(ClosedPlayofStageint==9)
                {
                    //playoffplay.setText("Вылет");
                    playoffplay.setImageResource(R.drawable.leave_bttn);
                    editor.putString(CloseScore1, "0");
                    editor.putString(CloseScore2, "0");
                    editor.putString(CloseScore3, "0");
                    editor.putString(CloseScore4, "0");
                    editor.putString(CloseScore5, "0");
                    editor.putString(CloseScore6, "0");
                    editor.putString(CloseScore7, "0");
                    editor.putString(CloseScore8, "0");
                    editor.putString(CloseScore9, "0");
                    editor.putString(CloseScore10, "0");
                    editor.putString(CloseScore11, "0");
                    editor.putString(CloseScore12, "0");

                    editor.putString(ClosePlayoff1, "0");
                    editor.putString(ClosePlayoff2, "0");
                    editor.putString(ClosePlayoff3, "0");
                    editor.putString(ClosePlayoff4, "0");
                    editor.putString(ClosePlayoff5, "0");
                    editor.putString(ClosePlayoff6, "0");
                    editor.putString(ClosePlayoff7, "0");
                    editor.putString(ClosePlayoff8, "0");
                    editor.putString(ClosePlayoff9, "0");
                    editor.putString(ClosePlayoff10, "0");
                    editor.putString(ClosePlayoff11, "0");
                    editor.putString(ClosePlayoff12, "0");

                    editor.putString(ClosedSeries, "0");
                    editor.putString(ClosedPlayofStage, "1");
                    editor.putString(Day, String.valueOf(Dayint+2));


                    editor.putString(Closedwin, "0");
                    editor.putString(Closedlose, "0");

                    editor.putString(CloseWin7, "0");
                    editor.putString(CloseWin6, "0");
                    editor.putString(CloseWin5, "0");
                    editor.putString(CloseWin4, "0");
                    editor.putString(CloseWin3, "0");
                    editor.putString(CloseWin2, "0");
                    editor.putString(CloseWin1, "0");




                    editor.putString(CloseLose7, "0");
                    editor.putString(CloseLose6, "0");
                    editor.putString(CloseLose5, "0");
                    editor.putString(CloseLose4, "0");
                    editor.putString(CloseLose3, "0");
                    editor.putString(CloseLose2, "0");
                    editor.putString(CloseLose1, "0");
                    editor.putString(OpenQualiWinner, "0");

                    editor.putString(CloseShaffle, "0");


                    editor.putString(CloseTeam1, "0");
                    editor.putString(CloseTeam2, "0");
                    editor.putString(CloseTeam3, "0");
                    editor.putString(CloseTeam4, "0");
                    editor.putString(CloseTeam5, "0");
                    editor.putString(CloseTeam6, "0");
                    editor.putString(CloseTeam7, "0");
                    editor.putString(Mode, "0");

                    editor.putString(Series1Win, "0");
                    editor.putString(Series2Win, "0");
                    editor.putString(Series3Win, "0");
                    editor.putString(Series4Win, "0");
                    editor.putString(Series5Win, "0");
                    editor.putString(Series6Win, "0");
                    editor.putString(Series7Win, "0");



                    editor.apply();
                    startActivity(Tomainstate);

                }
                else{
                    if(ClosedPlayofStageint==1)
                    {
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
                    else if (ClosedPlayofStageint==2)
                    {
                        ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[5]-1]).seq);
                        ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[5]-1]).teamname);
                        ToPickStage.putExtra("Position1",Pos1);
                        ToPickStage.putExtra("Position2",Pos2);
                        ToPickStage.putExtra("Position3",Pos3);
                        ToPickStage.putExtra("Position4",Pos4);
                        ToPickStage.putExtra("Position5",Pos5);
                        ToPickStage.putExtra("TeamName",YourTeam);
                        startActivity(ToPickStage);
                    }
                    else if (ClosedPlayofStageint==3)
                    {
                        ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[7]-1]).seq);
                        ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[7]-1]).teamname);
                        ToPickStage.putExtra("Position1",Pos1);
                        ToPickStage.putExtra("Position2",Pos2);
                        ToPickStage.putExtra("Position3",Pos3);
                        ToPickStage.putExtra("Position4",Pos4);
                        ToPickStage.putExtra("Position5",Pos5);
                        ToPickStage.putExtra("TeamName",YourTeam);
                        startActivity(ToPickStage);
                    }
                    else if (ClosedPlayofStageint==5)
                    {

                        Teamsplayoff[11].setText(AllPlayoffTeams.get(enemyteam[1]).teamname);
                        Teamsplayofflogo[11].setImageResource(AllPlayoffTeams.get(enemyteam[1]).logo);
                        editor.putString(ClosedPlayofStage, "6");
                        editor.putString(ClosePlayoff12, "1");
                        //ClosePlayoff12
                        editor.putString(CloseScore9, "2");
                        editor.putString(CloseScore10, "1");

                        Scoreplayoff[8].setText("2");
                        Scoreplayoff[9].setText("1");
                        Scoreplayoff[10].setText("0");
                        Scoreplayoff[11].setText("0");
                        editor.putString(ClosePlayoff12, "2");
                        //ClosedPlayofStageint=6;

                        if(to_final==true)
                        {

                           ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[2-1]).seq);
                           ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[2-1]).teamname);

                           ToPickStage.putExtra("Position1",Pos1);
                           ToPickStage.putExtra("Position2",Pos2);
                           ToPickStage.putExtra("Position3",Pos3);
                           ToPickStage.putExtra("Position4",Pos4);
                           ToPickStage.putExtra("Position5",Pos5);
                           editor.putString(ClosedPlayofStage, "6");
                           ToPickStage.putExtra("TeamName",YourTeam);
                           startActivity(ToPickStage);

                        }
                        to_final=true;
                        editor.apply();
                    }

                    else if (ClosedPlayofStageint==4)
                    {

                        if(Teamsplayoffs[8]==0)
                        {
                            ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[9]-1]).seq);
                            ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[9]-1]).teamname);
                        }
                        else
                        {
                            ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[8]-1]).seq);
                            ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[8]-1]).teamname);
                        }


                        ToPickStage.putExtra("Position1",Pos1);
                        ToPickStage.putExtra("Position2",Pos2);
                        ToPickStage.putExtra("Position3",Pos3);
                        ToPickStage.putExtra("Position4",Pos4);
                        ToPickStage.putExtra("Position5",Pos5);
                        ToPickStage.putExtra("TeamName",YourTeam);
                        startActivity(ToPickStage);
                    }



                    else if (ClosedPlayofStageint==6)
                    {
                        if(Teamsplayoffs[10]==0)
                        {
                            ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[11]-1]).seq);
                            ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[11]-1]).teamname);
                        }
                        else
                        {
                            ToPickStage.putExtra("EnemyTeam",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[10]-1]).seq);
                            ToPickStage.putExtra("TeamEnemy",AllPlayoffTeams.get(enemyteam[Teamsplayoffs[10]-1]).teamname);
                        }

                        ToPickStage.putExtra("Position1",Pos1);
                        ToPickStage.putExtra("Position2",Pos2);
                        ToPickStage.putExtra("Position3",Pos3);
                        ToPickStage.putExtra("Position4",Pos4);
                        ToPickStage.putExtra("Position5",Pos5);
                        ToPickStage.putExtra("TeamName",YourTeam);
                        startActivity(ToPickStage);
                    }

                    else if (ClosedPlayofStageint==7)
                    {
                        editor.putString(CloseScore1, "0");
                        editor.putString(CloseScore2, "0");
                        editor.putString(CloseScore3, "0");
                        editor.putString(CloseScore4, "0");
                        editor.putString(CloseScore5, "0");
                        editor.putString(CloseScore6, "0");
                        editor.putString(CloseScore7, "0");
                        editor.putString(CloseScore8, "0");
                        editor.putString(CloseScore9, "0");
                        editor.putString(CloseScore10, "0");
                        editor.putString(CloseScore11, "0");
                        editor.putString(CloseScore12, "0");

                        editor.putString(ClosePlayoff1, "0");
                        editor.putString(ClosePlayoff2, "0");
                        editor.putString(ClosePlayoff3, "0");
                        editor.putString(ClosePlayoff4, "0");
                        editor.putString(ClosePlayoff5, "0");
                        editor.putString(ClosePlayoff6, "0");
                        editor.putString(ClosePlayoff7, "0");
                        editor.putString(ClosePlayoff8, "0");
                        editor.putString(ClosePlayoff9, "0");
                        editor.putString(ClosePlayoff10, "0");
                        editor.putString(ClosePlayoff11, "0");
                        editor.putString(ClosePlayoff12, "0");

                        editor.putString(ClosedSeries, "0");
                        editor.putString(ClosedPlayofStage, "1");
                        editor.putString(Day, String.valueOf(Dayint+2));


                        editor.putString(Closedwin, "0");
                        editor.putString(Closedlose, "0");

                        editor.putString(CloseWin7, "0");
                        editor.putString(CloseWin6, "0");
                        editor.putString(CloseWin5, "0");
                        editor.putString(CloseWin4, "0");
                        editor.putString(CloseWin3, "0");
                        editor.putString(CloseWin2, "0");
                        editor.putString(CloseWin1, "0");




                        editor.putString(CloseLose7, "0");
                        editor.putString(CloseLose6, "0");
                        editor.putString(CloseLose5, "0");
                        editor.putString(CloseLose4, "0");
                        editor.putString(CloseLose3, "0");
                        editor.putString(CloseLose2, "0");
                        editor.putString(CloseLose1, "0");
                        editor.putString(OpenQualiWinner, "0");

                        editor.putString(CloseShaffle, "0");


                        editor.putString(CloseTeam1, "0");
                        editor.putString(CloseTeam2, "0");
                        editor.putString(CloseTeam3, "0");
                        editor.putString(CloseTeam4, "0");
                        editor.putString(CloseTeam5, "0");
                        editor.putString(CloseTeam6, "0");
                        editor.putString(CloseTeam7, "0");
                        editor.putString(Mode, "0");


                        editor.putString(Series1Win, "0");
                        editor.putString(Series2Win, "0");
                        editor.putString(Series3Win, "0");
                        editor.putString(Series4Win, "0");
                        editor.putString(Series5Win, "0");
                        editor.putString(Series6Win, "0");
                        editor.putString(Series7Win, "0");

                        if(Minorornot==0)
                        {
                            editor.putString(MinorQual,"1");
                        }
                        else{
                            editor.putString(MinorQual,"0");
                        }




                        editor.apply();
                        startActivity(Tomainstate);
                    }

                    else if (ClosedPlayofStageint==8)
                    {
                        editor.putString(CloseScore1, "0");
                        editor.putString(CloseScore2, "0");
                        editor.putString(CloseScore3, "0");
                        editor.putString(CloseScore4, "0");
                        editor.putString(CloseScore5, "0");
                        editor.putString(CloseScore6, "0");
                        editor.putString(CloseScore7, "0");
                        editor.putString(CloseScore8, "0");
                        editor.putString(CloseScore9, "0");
                        editor.putString(CloseScore10, "0");
                        editor.putString(CloseScore11, "0");
                        editor.putString(CloseScore12, "0");

                        editor.putString(ClosePlayoff1, "0");
                        editor.putString(ClosePlayoff2, "0");
                        editor.putString(ClosePlayoff3, "0");
                        editor.putString(ClosePlayoff4, "0");
                        editor.putString(ClosePlayoff5, "0");
                        editor.putString(ClosePlayoff6, "0");
                        editor.putString(ClosePlayoff7, "0");
                        editor.putString(ClosePlayoff8, "0");
                        editor.putString(ClosePlayoff9, "0");
                        editor.putString(ClosePlayoff10, "0");
                        editor.putString(ClosePlayoff11, "0");
                        editor.putString(ClosePlayoff12, "0");

                        editor.putString(ClosedSeries, "0");

                        editor.putString(ClosedPlayofStage, "1");
                        editor.putString(Day, String.valueOf(Dayint+2));

                        editor.putString(Closedwin, "0");
                        editor.putString(Closedlose, "0");

                        editor.putString(CloseWin7, "0");
                        editor.putString(CloseWin6, "0");
                        editor.putString(CloseWin5, "0");
                        editor.putString(CloseWin4, "0");
                        editor.putString(CloseWin3, "0");
                        editor.putString(CloseWin2, "0");
                        editor.putString(CloseWin1, "0");




                        editor.putString(CloseLose7, "0");
                        editor.putString(CloseLose6, "0");
                        editor.putString(CloseLose5, "0");
                        editor.putString(CloseLose4, "0");
                        editor.putString(CloseLose3, "0");
                        editor.putString(CloseLose2, "0");
                        editor.putString(CloseLose1, "0");
                        editor.putString(OpenQualiWinner, "0");

                        editor.putString(CloseShaffle, "0");


                        editor.putString(CloseTeam1, "0");
                        editor.putString(CloseTeam2, "0");
                        editor.putString(CloseTeam3, "0");
                        editor.putString(CloseTeam4, "0");
                        editor.putString(CloseTeam5, "0");
                        editor.putString(CloseTeam6, "0");
                        editor.putString(CloseTeam7, "0");
                        editor.putString(Mode, "0");

                        editor.putString(Series1Win, "0");
                        editor.putString(Series2Win, "0");
                        editor.putString(Series3Win, "0");
                        editor.putString(Series4Win, "0");
                        editor.putString(Series5Win, "0");
                        editor.putString(Series6Win, "0");
                        editor.putString(Series7Win, "0");

                        if(Minorornot==0)
                        {
                            editor.putString(MinorQual,"1");
                        }
                        else{
                            editor.putString(MinorQual,"0");
                        }

                        editor.apply();
                        startActivity(Tomainstate);
                    }




                }








            }
        });

    }
}
