package com.miklesam.dota_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.TheInternational;
import static com.miklesam.dota_manager.TeamsInit.TheInternationalInit;
import static com.miklesam.dota_manager.YourTeam.*;
import static com.miklesam.dota_manager.YourTeam.InMajor;
import static com.miklesam.dota_manager.YourTeam.MajorPScore10;
import static com.miklesam.dota_manager.YourTeam.MajorPScore11;
import static com.miklesam.dota_manager.YourTeam.MajorPScore12;
import static com.miklesam.dota_manager.YourTeam.MajorPScore13;
import static com.miklesam.dota_manager.YourTeam.MajorPScore14;
import static com.miklesam.dota_manager.YourTeam.MajorPScore15;
import static com.miklesam.dota_manager.YourTeam.MajorPScore16;
import static com.miklesam.dota_manager.YourTeam.MajorPScore17;
import static com.miklesam.dota_manager.YourTeam.MajorPScore18;
import static com.miklesam.dota_manager.YourTeam.MajorPScore19;
import static com.miklesam.dota_manager.YourTeam.MajorPScore20;
import static com.miklesam.dota_manager.YourTeam.MajorPScore9;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoffStage;
import static com.miklesam.dota_manager.YourTeam.MinorQual;
import static com.miklesam.dota_manager.YourTeam.NotMinor;

public class theinternational extends AppCompatActivity {

    TextView Teams[]= new TextView[18];
    ImageView TeamsLogo[] = new ImageView[18];
    int groupstateposition;

    ArrayList<Teams> TITeams= new ArrayList<>();
    ArrayList<Teams> GroupTeams= new ArrayList<>();
    SharedPreferences mSettings;
    String YourTeam;
    int MajorFlash[]=new int[17];
    int majorteamscup[]=new int[17];
    int ShuffleMajorint;


    TextView Seriesnteam[]= new TextView[8];
    TextView Seriesnyouteam[]= new TextView[8];
    ImageView Seriesnteamlogo[]=new ImageView[8];
    ImageView Seriesnyourteamlogo[]=new ImageView[8];
    ImageView Play_btn;
    int Seriescnt;
    ArrayList<ModelTeam> tiA = new ArrayList<>();
    ArrayList<ModelTeam> tiB = new ArrayList<>();

    TextView SeriesScore[]=new TextView[8];
    TextView SeriesScoreyou[]=new TextView[8];

    int ScoreEnemy[]= new int[8];
    int ScoreMy[]= new int[8];

    TextView TeamWin[]= new TextView[18];
    TextView TeamLose[]= new TextView[18];
    int MyWin;
    int MyLose;

    int WinsA[]= new int[8];
    int LoseA[]= new int[8];

    int WinsB[]= new int[9];
    int LoseB[]= new int[9];
    int Dayint;


    protected void ViewInit()
    {



        Teams[0]=findViewById(R.id.Team1);
        Teams[1]=findViewById(R.id.Team2);
        Teams[2]=findViewById(R.id.Team3);
        Teams[3]=findViewById(R.id.Team4);
        Teams[4]=findViewById(R.id.Team5);
        Teams[5]=findViewById(R.id.Team6);
        Teams[6]=findViewById(R.id.Team7);
        Teams[7]=findViewById(R.id.Team8);
        Teams[8]=findViewById(R.id.Team9);
        Teams[9]=findViewById(R.id.Team10);
        Teams[10]=findViewById(R.id.Team11);
        Teams[11]=findViewById(R.id.Team12);
        Teams[12]=findViewById(R.id.Team13);
        Teams[13]=findViewById(R.id.Team14);
        Teams[14]=findViewById(R.id.Team15);
        Teams[15]=findViewById(R.id.Team16);
        Teams[16]=findViewById(R.id.Team17);
        Teams[17]=findViewById(R.id.Team18);



        TeamsLogo[0]=findViewById(R.id.Teamlogo1);
        TeamsLogo[1]=findViewById(R.id.Teamlogo2);
        TeamsLogo[2]=findViewById(R.id.Teamlogo3);
        TeamsLogo[3]=findViewById(R.id.Teamlogo4);
        TeamsLogo[4]=findViewById(R.id.Teamlogo5);
        TeamsLogo[5]=findViewById(R.id.Teamlogo6);
        TeamsLogo[6]=findViewById(R.id.Teamlogo7);
        TeamsLogo[7]=findViewById(R.id.Teamlogo8);
        TeamsLogo[8]=findViewById(R.id.Teamlogo9);
        TeamsLogo[9]=findViewById(R.id.Teamlogo10);
        TeamsLogo[10]=findViewById(R.id.Teamlogo11);
        TeamsLogo[11]=findViewById(R.id.Teamlogo12);
        TeamsLogo[12]=findViewById(R.id.Teamlogo13);
        TeamsLogo[13]=findViewById(R.id.Teamlogo14);
        TeamsLogo[14]=findViewById(R.id.Teamlogo15);
        TeamsLogo[15]=findViewById(R.id.Teamlogo16);
        TeamsLogo[16]=findViewById(R.id.Teamlogo17);
        TeamsLogo[17]=findViewById(R.id.Teamlogo18);


        Seriesnteam[0]=findViewById(R.id.Series1team1);
        Seriesnteam[1]=findViewById(R.id.Series2team1);
        Seriesnteam[2]=findViewById(R.id.Series3team1);
        Seriesnteam[3]=findViewById(R.id.Series4team1);
        Seriesnteam[4]=findViewById(R.id.Series5team1);
        Seriesnteam[5]=findViewById(R.id.Series6team1);
        Seriesnteam[6]=findViewById(R.id.Series7team1);
        Seriesnteam[7]=findViewById(R.id.Series8team1);

        Seriesnyouteam[0]=findViewById(R.id.Series1team2);
        Seriesnyouteam[1]=findViewById(R.id.Series2team2);
        Seriesnyouteam[2]=findViewById(R.id.Series3team2);
        Seriesnyouteam[3]=findViewById(R.id.Series4team2);
        Seriesnyouteam[4]=findViewById(R.id.Series5team2);
        Seriesnyouteam[5]=findViewById(R.id.Series6team2);
        Seriesnyouteam[6]=findViewById(R.id.Series7team2);
        Seriesnyouteam[7]=findViewById(R.id.Series8team2);


        Seriesnteamlogo[0]=findViewById(R.id.Series1teamlogo1);
        Seriesnteamlogo[1]=findViewById(R.id.Series2teamlogo1);
        Seriesnteamlogo[2]=findViewById(R.id.Series3teamlogo1);
        Seriesnteamlogo[3]=findViewById(R.id.Series4teamlogo1);
        Seriesnteamlogo[4]=findViewById(R.id.Series5teamlogo1);
        Seriesnteamlogo[5]=findViewById(R.id.Series6teamlogo1);
        Seriesnteamlogo[6]=findViewById(R.id.Series7teamlogo1);
        Seriesnteamlogo[7]=findViewById(R.id.Series8teamlogo1);

        Seriesnyourteamlogo[0]=findViewById(R.id.Series1teamlogo2);
        Seriesnyourteamlogo[1]=findViewById(R.id.Series2teamlogo2);
        Seriesnyourteamlogo[2]=findViewById(R.id.Series3teamlogo2);
        Seriesnyourteamlogo[3]=findViewById(R.id.Series4teamlogo2);
        Seriesnyourteamlogo[4]=findViewById(R.id.Series5teamlogo2);
        Seriesnyourteamlogo[5]=findViewById(R.id.Series6teamlogo2);
        Seriesnyourteamlogo[6]=findViewById(R.id.Series7teamlogo2);
        Seriesnyourteamlogo[7]=findViewById(R.id.Series8teamlogo2);

        Play_btn=findViewById(R.id.Play_btn);




        TeamWin[0]=findViewById(R.id.ScoreWin1);
        TeamWin[1]=findViewById(R.id.ScoreWin2);
        TeamWin[2]=findViewById(R.id.ScoreWin3);
        TeamWin[3]=findViewById(R.id.ScoreWin4);
        TeamWin[4]=findViewById(R.id.ScoreWin5);
        TeamWin[5]=findViewById(R.id.ScoreWin6);
        TeamWin[6]=findViewById(R.id.ScoreWin7);
        TeamWin[7]=findViewById(R.id.ScoreWin8);
        TeamWin[8]=findViewById(R.id.ScoreWin9);
        TeamWin[9]=findViewById(R.id.ScoreWin10);
        TeamWin[10]=findViewById(R.id.ScoreWin11);
        TeamWin[11]=findViewById(R.id.ScoreWin12);
        TeamWin[12]=findViewById(R.id.ScoreWin13);
        TeamWin[13]=findViewById(R.id.ScoreWin14);
        TeamWin[14]=findViewById(R.id.ScoreWin15);
        TeamWin[15]=findViewById(R.id.ScoreWin16);
        TeamWin[16]=findViewById(R.id.ScoreWin17);
        TeamWin[17]=findViewById(R.id.ScoreWin18);


        TeamLose[0]=findViewById(R.id.ScoreLose1);
        TeamLose[1]=findViewById(R.id.ScoreLose2);
        TeamLose[2]=findViewById(R.id.ScoreLose3);
        TeamLose[3]=findViewById(R.id.ScoreLose4);
        TeamLose[4]=findViewById(R.id.ScoreLose5);
        TeamLose[5]=findViewById(R.id.ScoreLose6);
        TeamLose[6]=findViewById(R.id.ScoreLose7);
        TeamLose[7]=findViewById(R.id.ScoreLose8);
        TeamLose[8]=findViewById(R.id.ScoreLose9);
        TeamLose[9]=findViewById(R.id.ScoreLose10);
        TeamLose[10]=findViewById(R.id.ScoreLose11);
        TeamLose[11]=findViewById(R.id.ScoreLose12);
        TeamLose[12]=findViewById(R.id.ScoreLose13);
        TeamLose[13]=findViewById(R.id.ScoreLose14);
        TeamLose[14]=findViewById(R.id.ScoreLose15);
        TeamLose[15]=findViewById(R.id.ScoreLose16);
        TeamLose[16]=findViewById(R.id.ScoreLose17);
        TeamLose[17]=findViewById(R.id.ScoreLose18);

        SeriesScore[0]=findViewById(R.id.Series1scoreteam1);
        SeriesScore[1]=findViewById(R.id.Series2scoreteam1);
        SeriesScore[2]=findViewById(R.id.Series3scoreteam1);
        SeriesScore[3]=findViewById(R.id.Series4scoreteam1);
        SeriesScore[4]=findViewById(R.id.Series5scoreteam1);
        SeriesScore[5]=findViewById(R.id.Series6scoreteam1);
        SeriesScore[6]=findViewById(R.id.Series7scoreteam1);
        SeriesScore[7]=findViewById(R.id.Series8scoreteam1);

        SeriesScoreyou[0]=findViewById(R.id.Series1scoreteam2);
        SeriesScoreyou[1]=findViewById(R.id.Series2scoreteam2);
        SeriesScoreyou[2]=findViewById(R.id.Series3scoreteam2);
        SeriesScoreyou[3]=findViewById(R.id.Series4scoreteam2);
        SeriesScoreyou[4]=findViewById(R.id.Series5scoreteam2);
        SeriesScoreyou[5]=findViewById(R.id.Series6scoreteam2);
        SeriesScoreyou[6]=findViewById(R.id.Series7scoreteam2);
        SeriesScoreyou[7]=findViewById(R.id.Series8scoreteam2);




    }

    protected void ReadFlash()
    {


        if(mSettings.contains(Day)) {
            Dayint=Integer.parseInt(mSettings.getString(Day, "0"));
        }

        if(mSettings.contains(ClosedSeries)) {
            Seriescnt=Integer.parseInt(mSettings.getString(ClosedSeries, "ClosedSeries"));
        }

        if (mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam = mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

        }

        if (mSettings.contains(MajorGroup1)) {
            MajorFlash[0] = Integer.parseInt(mSettings.getString(MajorGroup1, "MajorGroup1"));
        }
        if (mSettings.contains(MajorGroup2)) {
            MajorFlash[1] = Integer.parseInt(mSettings.getString(MajorGroup2, "MajorGroup2"));
        }
        if (mSettings.contains(MajorGroup3)) {
            MajorFlash[2] = Integer.parseInt(mSettings.getString(MajorGroup3, "MajorGroup3"));
        }
        if (mSettings.contains(MajorGroup4)) {
            MajorFlash[3] = Integer.parseInt(mSettings.getString(MajorGroup4, "MajorGroup4"));
        }
        if (mSettings.contains(MajorGroup5)) {
            MajorFlash[4] = Integer.parseInt(mSettings.getString(MajorGroup5, "MajorGroup5"));
        }
        if (mSettings.contains(MajorGroup6)) {
            MajorFlash[5] = Integer.parseInt(mSettings.getString(MajorGroup6, "MajorGroup6"));
        }
        if (mSettings.contains(MajorGroup7)) {
            MajorFlash[6] = Integer.parseInt(mSettings.getString(MajorGroup7, "MajorGroup7"));
        }
        if (mSettings.contains(MajorGroup8)) {
            MajorFlash[7] = Integer.parseInt(mSettings.getString(MajorGroup8, "MajorGroup8"));
        }
        if (mSettings.contains(MajorGroup9)) {
            MajorFlash[8] = Integer.parseInt(mSettings.getString(MajorGroup9, "MajorGroup9"));
        }
        if (mSettings.contains(MajorGroup10)) {
            MajorFlash[9] = Integer.parseInt(mSettings.getString(MajorGroup10, "MajorGroup10"));
        }
        if (mSettings.contains(MajorGroup11)) {
            MajorFlash[10] = Integer.parseInt(mSettings.getString(MajorGroup11, "MajorGroup11"));
        }
        if (mSettings.contains(MajorGroup12)) {
            MajorFlash[11] = Integer.parseInt(mSettings.getString(MajorGroup12, "MajorGroup12"));
        }
        if (mSettings.contains(MajorGroup13)) {
            MajorFlash[12] = Integer.parseInt(mSettings.getString(MajorGroup13, "MajorGroup13"));
        }
        if (mSettings.contains(MajorGroup14)) {
            MajorFlash[13] = Integer.parseInt(mSettings.getString(MajorGroup14, "MajorGroup14"));
        }
        if (mSettings.contains(MajorGroup15)) {
            MajorFlash[14] = Integer.parseInt(mSettings.getString(MajorGroup15, "MajorGroup15"));
        }
        if (mSettings.contains(OpenTeam1)) {
            MajorFlash[15] = Integer.parseInt(mSettings.getString(OpenTeam1, "MajorGroup15"));
        }
        if (mSettings.contains(OpenTeam2)) {
            MajorFlash[16] = Integer.parseInt(mSettings.getString(OpenTeam2, "MajorGroup15"));
        }



        if(mSettings.contains(ShuffleMajor)) {
            ShuffleMajorint=Integer.parseInt(mSettings.getString(ShuffleMajor, "ShuffleMajor"));
        }

        if (mSettings.contains(CloseScore1)) {
            ScoreEnemy[0] = Integer.parseInt(mSettings.getString(CloseScore1, "MajorGroup15"));
        }

        if (mSettings.contains(CloseScore2)) {
            ScoreEnemy[1] = Integer.parseInt(mSettings.getString(CloseScore2, "MajorGroup15"));
        }

        if (mSettings.contains(CloseScore3)) {
            ScoreEnemy[2] = Integer.parseInt(mSettings.getString(CloseScore3, "MajorGroup15"));
        }

        if (mSettings.contains(CloseScore4)) {
            ScoreEnemy[3] = Integer.parseInt(mSettings.getString(CloseScore4, "MajorGroup15"));
        }

        if (mSettings.contains(CloseScore5)) {
            ScoreEnemy[4] = Integer.parseInt(mSettings.getString(CloseScore5, "MajorGroup15"));
        }

        if (mSettings.contains(CloseScore6)) {
            ScoreEnemy[5] = Integer.parseInt(mSettings.getString(CloseScore6, "MajorGroup15"));
        }

        if (mSettings.contains(CloseScore7)) {
            ScoreEnemy[6] = Integer.parseInt(mSettings.getString(CloseScore7, "MajorGroup15"));
        }

        if (mSettings.contains(CloseScore8)) {
            ScoreEnemy[7] = Integer.parseInt(mSettings.getString(CloseScore8, "MajorGroup15"));
        }


        if (mSettings.contains(MinorScore1)) {
            ScoreMy[0] = Integer.parseInt(mSettings.getString(MinorScore1, "MajorGroup15"));
        }

        if (mSettings.contains(MinorScore2)) {
            ScoreMy[1] = Integer.parseInt(mSettings.getString(MinorScore2, "MajorGroup15"));
        }

        if (mSettings.contains(MinorScore3)) {
            ScoreMy[2] = Integer.parseInt(mSettings.getString(MinorScore3, "MajorGroup15"));
        }

        if (mSettings.contains(MinorScore4)) {
            ScoreMy[3] = Integer.parseInt(mSettings.getString(MinorScore4, "MajorGroup15"));
        }

        if (mSettings.contains(MinorScore5)) {
            ScoreMy[4] = Integer.parseInt(mSettings.getString(MinorScore5, "MajorGroup15"));
        }

        if (mSettings.contains(MinorScore6)) {
            ScoreMy[5] = Integer.parseInt(mSettings.getString(MinorScore6, "MajorGroup15"));
        }

        if (mSettings.contains(MinorScore7)) {
            ScoreMy[6] = Integer.parseInt(mSettings.getString(MinorScore7, "MajorGroup15"));
        }

        if (mSettings.contains(MinorScore8)) {
            ScoreMy[7] = Integer.parseInt(mSettings.getString(MinorScore8, "MajorGroup15"));
        }








    }

    public void ClearNonStaticFlash()
    {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(Mode, "0");

        editor.putString(OpenQuaterFinals, "0");
        editor.putString(OpenSemiFinals, "0");
        editor.putString(OpenFinals, "0");

        editor.putString(OpenScore1, "0");
        editor.putString(OpenScore2, "0");
        editor.putString(OpenScore3, "0");
        editor.putString(OpenScore4, "0");

        editor.putString(OpenScore5, "0");
        editor.putString(OpenScore6, "0");
        editor.putString(OpenScore7, "0");
        editor.putString(OpenScore8, "0");

        editor.putString(OpenScore9, "0");
        editor.putString(OpenScore10, "0");
        editor.putString(OpenScore11, "0");
        editor.putString(OpenScore12, "0");


        editor.putString(QuaterWin, "0");
        editor.putString(SemiWin, "0");
        editor.putString(FinalsWin, "0");
        editor.putString(OpenQualiWinner, "0");
        editor.putString(ClosedSeries, "0");

        editor.putString(Closedwin, "0");
        editor.putString(Closedlose, "0");


        editor.putString(CloseWin8, "0");
        editor.putString(CloseWin7, "0");
        editor.putString(CloseWin6, "0");
        editor.putString(CloseWin5, "0");
        editor.putString(CloseWin4, "0");
        editor.putString(CloseWin3, "0");
        editor.putString(CloseWin2, "0");
        editor.putString(CloseWin1, "0");



        editor.putString(CloseLose8, "0");
        editor.putString(CloseLose7, "0");
        editor.putString(CloseLose6, "0");
        editor.putString(CloseLose5, "0");
        editor.putString(CloseLose4, "0");
        editor.putString(CloseLose3, "0");
        editor.putString(CloseLose2, "0");
        editor.putString(CloseLose1, "0");



        editor.putString(OpenShaffle, "0");
        editor.putString(CloseShaffle, "0");


        editor.putString(CloseTeam1, "0");
        editor.putString(CloseTeam2, "0");
        editor.putString(CloseTeam3, "0");
        editor.putString(CloseTeam4, "0");
        editor.putString(CloseTeam5, "0");
        editor.putString(CloseTeam6, "0");
        editor.putString(CloseTeam7, "0");

        editor.putString(TeamPlayoff1, "0");
        editor.putString(TeamPlayoff2, "0");
        editor.putString(TeamPlayoff3, "0");
        editor.putString(TeamPlayoff4, "0");

        editor.putString(ClosedPlayofStage, "1");







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

        editor.putString(Series1Win, "0");
        editor.putString(Series2Win, "0");
        editor.putString(Series3Win, "0");
        editor.putString(Series4Win, "0");
        editor.putString(Series5Win, "0");
        editor.putString(Series6Win, "0");
        editor.putString(Series7Win, "0");

        editor.putString(MinorScore1, "0");
        editor.putString(MinorScore2, "0");
        editor.putString(MinorScore3, "0");
        editor.putString(MinorScore4, "0");
        editor.putString(MinorScore5, "0");
        editor.putString(MinorScore6, "0");
        editor.putString(MinorScore7, "0");
        editor.putString(MinorScore8, "0");

        editor.putString(MinorWin1, "0");
        editor.putString(MinorWin2, "0");
        editor.putString(MinorWin3, "0");
        editor.putString(MinorWin4, "0");
        editor.putString(MinorWin5, "0");
        editor.putString(MinorWin6, "0");
        editor.putString(MinorWin7, "0");
        editor.putString(MinorWin8, "0");

        editor.putString(MinorLose1, "0");
        editor.putString(MinorLose2, "0");
        editor.putString(MinorLose3, "0");
        editor.putString(MinorLose4, "0");
        editor.putString(MinorLose5, "0");
        editor.putString(MinorLose6, "0");
        editor.putString(MinorLose7, "0");
        editor.putString(MinorLose8, "0");


        editor.putString(MinorPlayoff1, "0");
        editor.putString(MinorPlayoff2, "0");
        editor.putString(MinorPlayoff3, "0");
        editor.putString(MinorPlayoff4, "0");
        editor.putString(MinorPlayoff5, "0");
        editor.putString(MinorPlayoff6, "0");
        editor.putString(MinorStage, "1");


        editor.putString(MajorStage, "1");

        editor.putString(MajorScore1, "0");
        editor.putString(MajorScore2, "0");
        editor.putString(MajorScore3, "0");
        editor.putString(MajorScore4, "0");
        editor.putString(MajorScore5, "0");
        editor.putString(MajorScore6, "0");
        editor.putString(MajorScore7, "0");
        editor.putString(MajorScore8, "0");

        editor.putString(MajorWin1, "0");
        editor.putString(MajorWin2, "0");
        editor.putString(MajorWin3, "0");
        editor.putString(MajorWin4, "0");
        editor.putString(MajorWin5, "0");
        editor.putString(MajorWin6, "0");
        editor.putString(MajorWin7, "0");
        editor.putString(MajorWin8, "0");

        editor.putString(MajorLose1, "0");
        editor.putString(MajorLose2, "0");
        editor.putString(MajorLose3, "0");
        editor.putString(MajorLose4, "0");
        editor.putString(MajorLose5, "0");
        editor.putString(MajorLose6, "0");
        editor.putString(MajorLose7, "0");
        editor.putString(MajorLose8, "0");


        editor.putString(MajorSeries1, "0");
        editor.putString(MajorSeries2, "0");
        editor.putString(MajorSeries3, "0");
        editor.putString(MajorSeries4, "0");
        editor.putString(MajorSeries5, "0");
        editor.putString(MajorSeries6, "0");

        editor.putString(MajorPlayoff1, "0");
        editor.putString(MajorPlayoff2, "0");
        editor.putString(MajorPlayoff3, "0");
        editor.putString(MajorPlayoff4, "0");
        editor.putString(MajorPlayoff5, "0");
        editor.putString(MajorPlayoff6, "0");
        editor.putString(MajorPlayoff7, "0");
        editor.putString(MajorPlayoff8, "0");
        editor.putString(MajorPlayoff9, "0");
        editor.putString(MajorPlayoff10, "0");
        editor.putString(MajorPlayoff11, "0");
        editor.putString(MajorPlayoff12, "0");
        editor.putString(MajorPlayoff13, "0");
        editor.putString(MajorPlayoff14, "0");
        editor.putString(MajorPlayoff15, "0");
        editor.putString(MajorPlayoff16, "0");
        editor.putString(MajorPlayoff17, "0");
        editor.putString(MajorPlayoff18, "0");
        editor.putString(MajorPlayoff19, "0");
        editor.putString(MajorPlayoff20, "0");
        editor.putString(MajorPlayoff21, "0");
        editor.putString(MajorPlayoff22, "0");
        editor.putString(MajorPlayoff23, "0");


        editor.putString(WinnerorLossers, "0");


        editor.putString(MajorGroup1, "0");
        editor.putString(MajorGroup2, "0");
        editor.putString(MajorGroup3, "0");
        editor.putString(MajorGroup4, "0");
        editor.putString(MajorGroup5, "0");
        editor.putString(MajorGroup6, "0");
        editor.putString(MajorGroup7, "0");
        editor.putString(MajorGroup8, "0");
        editor.putString(MajorGroup9, "0");
        editor.putString(MajorGroup10, "0");
        editor.putString(MajorGroup11, "0");
        editor.putString(MajorGroup12, "0");
        editor.putString(MajorGroup13, "0");
        editor.putString(MajorGroup14, "0");
        editor.putString(MajorGroup15, "0");
        editor.putString(ShuffleMajor, "0");


        editor.putString(MajorPScore1, "0");
        editor.putString(MajorPScore2, "0");
        editor.putString(MajorPScore3, "0");
        editor.putString(MajorPScore4, "0");
        editor.putString(MajorPScore5, "0");
        editor.putString(MajorPScore6, "0");
        editor.putString(MajorPScore7, "0");
        editor.putString(MajorPScore8, "0");
        editor.putString(MajorPScore9, "0");
        editor.putString(MajorPScore10, "0");
        editor.putString(MajorPScore11, "0");
        editor.putString(MajorPScore12, "0");
        editor.putString(MajorPScore13, "0");
        editor.putString(MajorPScore14, "0");
        editor.putString(MajorPScore15, "0");
        editor.putString(MajorPScore16, "0");
        editor.putString(MajorPScore17, "0");
        editor.putString(MajorPScore18, "0");
        editor.putString(MajorPScore19, "0");
        editor.putString(MajorPScore20, "0");
        editor.putString(InMajor, "0");





        editor.putString(MajorPlayoffStage, "1");







        editor.putString(MinorQual,"0");
        editor.putString(NotMinor,"0");
        editor.apply();
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theinternational);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = mSettings.edit();
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        final Intent ToMajorPlayoff = new Intent(this, majorplayoff.class);
        final Intent Tomainstate = new Intent(this, mainstate.class);
        ViewInit();
        ReadFlash();
        TheInternational.clear();
        TITeams=TheInternationalInit();



        if(ShuffleMajorint==0)
        {
            Random randomteam = new Random();
            int whatteam;

            for (int i=0;i<17;i++)
            {
                whatteam=randomteam.nextInt(TheInternational.size());
                majorteamscup[i]=TheInternational.get(whatteam).seq;
                GroupTeams.add(TheInternational.get(whatteam));
                TheInternational.remove(whatteam);
            }

            editor.putString(MajorGroup1, String.valueOf(majorteamscup[0]));
            editor.putString(MajorGroup2, String.valueOf(majorteamscup[1]));
            editor.putString(MajorGroup3, String.valueOf(majorteamscup[2]));
            editor.putString(MajorGroup4, String.valueOf(majorteamscup[3]));
            editor.putString(MajorGroup5, String.valueOf(majorteamscup[4]));
            editor.putString(MajorGroup6, String.valueOf(majorteamscup[5]));
            editor.putString(MajorGroup7, String.valueOf(majorteamscup[6]));
            editor.putString(MajorGroup8, String.valueOf(majorteamscup[7]));
            editor.putString(MajorGroup9, String.valueOf(majorteamscup[8]));
            editor.putString(MajorGroup10, String.valueOf(majorteamscup[9]));
            editor.putString(MajorGroup11, String.valueOf(majorteamscup[10]));
            editor.putString(MajorGroup12, String.valueOf(majorteamscup[11]));
            editor.putString(MajorGroup13, String.valueOf(majorteamscup[12]));
            editor.putString(MajorGroup14, String.valueOf(majorteamscup[13]));
            editor.putString(MajorGroup15, String.valueOf(majorteamscup[14]));
            editor.putString(OpenTeam1, String.valueOf(majorteamscup[15]));
            editor.putString(OpenTeam2, String.valueOf(majorteamscup[16]));
            editor.putString(ShuffleMajor, "1");
            editor.apply();

        }
        else
        {
            GroupTeams.clear();
            for (int i=0;i<17;i++)
            {
                GroupTeams.add(AllTeams.get(MajorFlash[i]));
            }
        }


        for (int i=0;i<8;i++)
        {
            Teams[i].setText(GroupTeams.get(i).teamname);
            TeamsLogo[i].setImageResource(GroupTeams.get(i).logo);

        }

        Teams[8].setText(YourTeam);
        TeamsLogo[8].setImageResource(R.drawable.teamlogo);




        for (int i=0;i<8;i++)
        {
            Seriesnteam[i].setText(GroupTeams.get(i).teamname);
            Seriesnteamlogo[i].setImageResource(GroupTeams.get(i).logo);
            Seriesnyouteam[i].setText(YourTeam);
            Seriesnyourteamlogo[i].setImageResource(R.drawable.teamlogo);

        }


        MyWin=0;
        MyLose=0;
        for (int i=0;i<8;i++)
        {
            SeriesScore[i].setText(String.valueOf(ScoreEnemy[i]));
            SeriesScoreyou[i].setText(String.valueOf(ScoreMy[i]));
            MyWin=MyWin+ScoreMy[i];
            MyLose=MyLose+ScoreEnemy[i];
        }



        if(Seriescnt<8)
        {
            if((ScoreEnemy[Seriescnt]+ScoreMy[Seriescnt])==2)
            {
                editor.putString(ClosedSeries, String.valueOf(Seriescnt+1));
                editor.apply();
            }

        }

        ReadFlash();

        if(Seriescnt==0)
        {
            WinsA[0]=ScoreEnemy[0];
            LoseA[0]=ScoreMy[0];
        }
        else if (Seriescnt==1)
        {
            WinsA[0]=ScoreEnemy[0];
            LoseA[0]=ScoreMy[0];
            WinsA[1]=0+ScoreEnemy[1];
            LoseA[1]=0+ScoreMy[1];
            WinsA[2]=2;
            LoseA[2]=0;
            WinsA[3]=2;
            LoseA[3]=0;
            WinsA[4]=1;
            LoseA[4]=1;
            WinsA[5]=1;
            LoseA[5]=1;
            WinsA[6]=0;
            LoseA[6]=2;
            WinsA[7]=0;
            LoseA[7]=2;

            WinsB[0]=2;
            LoseB[0]=0;
            WinsB[1]=0;
            LoseB[1]=0;
            WinsB[2]=2;
            LoseB[2]=0;
            WinsB[3]=2;
            LoseB[3]=0;
            WinsB[4]=1;
            LoseB[4]=1;
            WinsB[5]=1;
            LoseB[5]=1;
            WinsB[6]=0;
            LoseB[6]=2;
            WinsB[7]=0;
            LoseB[7]=2;
            WinsB[8]=0;
            LoseB[8]=2;


            WinsB[0]=3;
            LoseB[0]=1;
            WinsB[1]=2;
            LoseB[1]=0;
            WinsB[2]=3;
            LoseB[2]=1;
            WinsB[3]=2;
            LoseB[3]=0;
            WinsB[4]=2;
            LoseB[4]=2;
            WinsB[5]=2;
            LoseB[5]=2;
            WinsB[6]=1;
            LoseB[6]=3;
            WinsB[7]=1;
            LoseB[7]=3;
            WinsB[8]=0;
            LoseB[8]=4;




        }

        else if (Seriescnt==2)
        {
            WinsA[0]=1+ScoreEnemy[0];
            LoseA[0]=1+ScoreMy[0];
            WinsA[1]=0+ScoreEnemy[1];
            LoseA[1]=0+ScoreMy[1];
            WinsA[2]=3;
            LoseA[2]=1;
            WinsA[3]=2;
            LoseA[3]=0;
            WinsA[4]=2;
            LoseA[4]=2;
            WinsA[5]=2;
            LoseA[5]=2;
            WinsA[6]=1;
            LoseA[6]=3;
            WinsA[7]=1;
            LoseA[7]=3;

            WinsB[0]=5;
            LoseB[0]=1;
            WinsB[1]=4;
            LoseB[1]=0;
            WinsB[2]=5;
            LoseB[2]=1;
            WinsB[3]=2;
            LoseB[3]=2;
            WinsB[4]=2;
            LoseB[4]=4;
            WinsB[5]=2;
            LoseB[5]=2;
            WinsB[6]=2;
            LoseB[6]=4;
            WinsB[7]=2;
            LoseB[7]=4;
            WinsB[8]=0;
            LoseB[8]=6;



        }

        else if (Seriescnt==3)
        {
            WinsA[0]=3+ScoreEnemy[0];
            LoseA[0]=1+ScoreMy[0];
            WinsA[1]=2+ScoreEnemy[1];
            LoseA[1]=0+ScoreMy[1];
            WinsA[2]=3+ScoreEnemy[2];
            LoseA[2]=1+ScoreMy[2];
            WinsA[3]=2;
            LoseA[3]=2;
            WinsA[4]=2;
            LoseA[4]=4;
            WinsA[5]=2;
            LoseA[5]=2;
            WinsA[6]=2;
            LoseA[6]=4;
            WinsA[7]=2;
            LoseA[7]=4;

            WinsB[0]=7;
            LoseB[0]=1;
            WinsB[1]=6;
            LoseB[1]=0;
            WinsB[2]=7;
            LoseB[2]=1;
            WinsB[3]=3;
            LoseB[3]=3;
            WinsB[4]=2;
            LoseB[4]=6;
            WinsB[5]=2;
            LoseB[5]=4;
            WinsB[6]=2;
            LoseB[6]=6;
            WinsB[7]=2;
            LoseB[7]=4;
            WinsB[8]=1;
            LoseB[8]=7;




        }

        else if (Seriescnt==4)
        {
            WinsA[0]=5+ScoreEnemy[0];
            LoseA[0]=1+ScoreMy[0];
            WinsA[1]=4+ScoreEnemy[1];
            LoseA[1]=0+ScoreMy[1];
            WinsA[2]=5+ScoreEnemy[2];
            LoseA[2]=1+ScoreMy[2];
            WinsA[3]=2+ScoreEnemy[3];
            LoseA[3]=2+ScoreMy[3];
            WinsA[4]=2;
            LoseA[4]=6;
            WinsA[5]=2;
            LoseA[5]=4;
            WinsA[6]=2;
            LoseA[6]=6;
            WinsA[7]=2;
            LoseA[7]=4;

            WinsB[0]=7;
            LoseB[0]=1;
            WinsB[1]=8;
            LoseB[1]=0;
            WinsB[2]=9;
            LoseB[2]=1;
            WinsB[3]=4;
            LoseB[3]=4;
            WinsB[4]=3;
            LoseB[4]=7;
            WinsB[5]=3;
            LoseB[5]=5;
            WinsB[6]=2;
            LoseB[6]=8;
            WinsB[7]=2;
            LoseB[7]=6;
            WinsB[8]=2;
            LoseB[8]=8;

        }

        else if (Seriescnt==5)
        {
            WinsA[0]=7+ScoreEnemy[0];
            LoseA[0]=1+ScoreMy[0];
            WinsA[1]=6+ScoreEnemy[1];
            LoseA[1]=0+ScoreMy[1];
            WinsA[2]=7+ScoreEnemy[2];
            LoseA[2]=1+ScoreMy[2];
            WinsA[3]=3+ScoreEnemy[3];
            LoseA[3]=3+ScoreMy[3];
            WinsA[4]=2+ScoreEnemy[4];
            LoseA[4]=6+ScoreMy[4];
            WinsA[5]=3;
            LoseA[5]=5;
            WinsA[6]=2;
            LoseA[6]=8;
            WinsA[7]=2;
            LoseA[7]=6;


            WinsB[0]=8;
            LoseB[0]=2;
            WinsB[1]=9;
            LoseB[1]=1;
            WinsB[2]=9;
            LoseB[2]=1;
            WinsB[3]=6;
            LoseB[3]=4;
            WinsB[4]=5;
            LoseB[4]=7;
            WinsB[5]=4;
            LoseB[5]=6;
            WinsB[6]=2;
            LoseB[6]=10;
            WinsB[7]=2;
            LoseB[7]=8;
            WinsB[8]=3;
            LoseB[8]=9;



        }

        else if (Seriescnt==6)
        {
            WinsA[0]=9+ScoreEnemy[0];
            LoseA[0]=1+ScoreMy[0];
            WinsA[1]=7+ScoreEnemy[1];
            LoseA[1]=1+ScoreMy[1];
            WinsA[2]=7+ScoreEnemy[2];
            LoseA[2]=1+ScoreMy[2];
            WinsA[3]=5+ScoreEnemy[3];
            LoseA[3]=3+ScoreMy[3];
            WinsA[4]=4+ScoreEnemy[4];
            LoseA[4]=6+ScoreMy[4];
            WinsA[5]=3+ScoreEnemy[5];
            LoseA[5]=5+ScoreMy[5];
            WinsA[6]=2;
            LoseA[6]=10;
            WinsA[7]=2;
            LoseA[7]=8;


            WinsB[0]=10;
            LoseB[0]=2;
            WinsB[1]=11;
            LoseB[1]=1;
            WinsB[2]=9;
            LoseB[2]=3;
            WinsB[3]=8;
            LoseB[3]=4;
            WinsB[4]=5;
            LoseB[4]=7;
            WinsB[5]=4;
            LoseB[5]=8;
            WinsB[6]=2;
            LoseB[6]=12;
            WinsB[7]=3;
            LoseB[7]=9;
            WinsB[8]=5;
            LoseB[8]=9;

        }

        else if (Seriescnt==7)
        {
            WinsA[0]=11+ScoreEnemy[0];
            LoseA[0]=1+ScoreMy[0];
            WinsA[1]=11+ScoreEnemy[1];
            LoseA[1]=1+ScoreMy[1];
            WinsA[2]=9+ScoreEnemy[2];
            LoseA[2]=3+ScoreMy[2];
            WinsA[3]=5+ScoreEnemy[3];
            LoseA[3]=7+ScoreMy[3];
            WinsA[4]=4+ScoreEnemy[4];
            LoseA[4]=8+ScoreMy[4];
            WinsA[5]=4+ScoreEnemy[5];
            LoseA[5]=8+ScoreMy[5];
            WinsA[6]=2+ScoreEnemy[6];
            LoseA[6]=10+ScoreMy[6];
            WinsA[7]=3;
            LoseA[7]=9;


            WinsB[0]=12;
            LoseB[0]=2;
            WinsB[1]=13;
            LoseB[1]=1;
            WinsB[2]=11;
            LoseB[2]=3;
            WinsB[3]=8;
            LoseB[3]=6;
            WinsB[4]=5;
            LoseB[4]=9;
            WinsB[5]=4;
            LoseB[5]=10;
            WinsB[6]=2;
            LoseB[6]=12;
            WinsB[7]=3;
            LoseB[7]=11;
            WinsB[8]=7;
            LoseB[8]=9;

        }

        else if (Seriescnt==8)
        {
            WinsA[0]=13+ScoreEnemy[0];
            LoseA[0]=1+ScoreMy[0];
            WinsA[1]=13+ScoreEnemy[1];
            LoseA[1]=1+ScoreMy[1];
            WinsA[2]=11+ScoreEnemy[2];
            LoseA[2]=3+ScoreMy[2];
            WinsA[3]=7+ScoreEnemy[3];
            LoseA[3]=7+ScoreMy[3];
            WinsA[4]=4+ScoreEnemy[4];
            LoseA[4]=10+ScoreMy[4];
            WinsA[5]=4+ScoreEnemy[5];
            LoseA[5]=10+ScoreMy[5];
            WinsA[6]=2+ScoreEnemy[6];
            LoseA[6]=12+ScoreMy[6];
            WinsA[7]=3+ScoreEnemy[7];
            LoseA[7]=11+ScoreMy[7];


            WinsB[0]=14;
            LoseB[0]=2;
            WinsB[1]=15;
            LoseB[1]=1;
            WinsB[2]=13;
            LoseB[2]=3;
            WinsB[3]=10;
            LoseB[3]=6;
            WinsB[4]=5;
            LoseB[4]=11;
            WinsB[5]=4;
            LoseB[5]=12;
            WinsB[6]=2;
            LoseB[6]=14;
            WinsB[7]=3;
            LoseB[7]=13;
            WinsB[8]=7;
            LoseB[8]=9;


        }








        tiA.clear();
        tiA.add( new ModelTeam( GroupTeams.get(0).teamname,GroupTeams.get(0).logo,WinsA[0],LoseA[0],GroupTeams.get(0).seq));
        tiA.add( new ModelTeam( GroupTeams.get(1).teamname,GroupTeams.get(1).logo,WinsA[1],LoseA[1],GroupTeams.get(1).seq));
        tiA.add( new ModelTeam( GroupTeams.get(2).teamname,GroupTeams.get(2).logo,WinsA[2],LoseA[2],GroupTeams.get(2).seq));
        tiA.add( new ModelTeam( GroupTeams.get(3).teamname,GroupTeams.get(3).logo,WinsA[3],LoseA[3],GroupTeams.get(3).seq));
        tiA.add( new ModelTeam( GroupTeams.get(4).teamname,GroupTeams.get(4).logo,WinsA[4],LoseA[4],GroupTeams.get(4).seq));
        tiA.add( new ModelTeam( GroupTeams.get(5).teamname,GroupTeams.get(5).logo,WinsA[5],LoseA[5],GroupTeams.get(5).seq));
        tiA.add( new ModelTeam( GroupTeams.get(6).teamname,GroupTeams.get(6).logo,WinsA[6],LoseA[6],GroupTeams.get(6).seq));
        tiA.add( new ModelTeam( GroupTeams.get(7).teamname,GroupTeams.get(7).logo,WinsA[7],LoseA[7],GroupTeams.get(7).seq));
        tiA.add( new ModelTeam(YourTeam ,R.drawable.teamlogo,MyWin,MyLose,77));
        Collections.sort(tiA, ModelTeam.COMPARE_BY_Winning);


        tiB.clear();
        tiB.add( new ModelTeam( GroupTeams.get(8).teamname,GroupTeams.get(8).logo,WinsB[0],LoseB[0],GroupTeams.get(8).seq));
        tiB.add( new ModelTeam( GroupTeams.get(9).teamname,GroupTeams.get(9).logo,WinsB[1],LoseB[1],GroupTeams.get(9).seq));
        tiB.add( new ModelTeam( GroupTeams.get(10).teamname,GroupTeams.get(10).logo,WinsB[2],LoseB[2],GroupTeams.get(10).seq));
        tiB.add( new ModelTeam( GroupTeams.get(11).teamname,GroupTeams.get(11).logo,WinsB[3],LoseB[3],GroupTeams.get(11).seq));
        tiB.add( new ModelTeam( GroupTeams.get(12).teamname,GroupTeams.get(12).logo,WinsB[4],LoseB[4],GroupTeams.get(12).seq));
        tiB.add( new ModelTeam( GroupTeams.get(13).teamname,GroupTeams.get(13).logo,WinsB[5],LoseB[5],GroupTeams.get(13).seq));
        tiB.add( new ModelTeam( GroupTeams.get(14).teamname,GroupTeams.get(14).logo,WinsB[6],LoseB[6],GroupTeams.get(14).seq));
        tiB.add( new ModelTeam( GroupTeams.get(15).teamname,GroupTeams.get(15).logo,WinsB[7],LoseB[7],GroupTeams.get(15).seq));
        tiB.add( new ModelTeam( GroupTeams.get(16).teamname,GroupTeams.get(16).logo,WinsB[8],LoseB[8],GroupTeams.get(16).seq));
        Collections.sort(tiB, ModelTeam.COMPARE_BY_Winning);

        for (int i=0;i<9;i++)
        {
            Teams[i].setText(tiA.get(i).TeamName);
            TeamsLogo[i].setImageResource(tiA.get(i).logo);
            TeamWin[i].setText(String.valueOf(tiA.get(i).w));
            TeamLose[i].setText(String.valueOf(tiA.get(i).l));
        }

        for (int i=0;i<9;i++)
        {
            Teams[i+9].setText(tiB.get(i).TeamName);
            TeamsLogo[i+9].setImageResource(tiB.get(i).logo);
            TeamWin[i+9].setText(String.valueOf(tiB.get(i).w));
            TeamLose[i+9].setText(String.valueOf(tiB.get(i).l));
        }



        if((Seriescnt==8)&&(ScoreEnemy[7]+ScoreMy[7]==2))
        {
            for(int i=0;i<tiA.size();i++)
            {
                if(tiA.get(i).TeamName.equals(YourTeam))
                {
                    groupstateposition=i+1;
                    tiA.remove(groupstateposition-1);
                    break;
                }

            }

            if (groupstateposition==9)
            {
                Play_btn.setImageResource(R.drawable.leave_bttn);
            }
            else if (groupstateposition<5)
            {
               //Winners
            }
            else if(groupstateposition>4)
            {
               //Losers
            }


        }







        Play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        ToPickStage.putExtra("TeamName",YourTeam);
                        if(Seriescnt<8)
                        {
                            ToPickStage.putExtra("TeamEnemy",GroupTeams.get(Seriescnt).teamname);
                            ToPickStage.putExtra("EnemyTeam",GroupTeams.get(Seriescnt).seq);
                            startActivity(ToPickStage);
                        }
                        if((Seriescnt==8)&&(ScoreEnemy[7]+ScoreMy[7]==2))
                        {

                            if(groupstateposition==9)
                            {
                                ClearNonStaticFlash();
                                editor.putString(Day,String.valueOf(Dayint+1));
                                editor.apply();
                                startActivity(Tomainstate);
                            }
                            else if(groupstateposition>4)
                            {
                                editor.putString(WinnerorLossers, "0");
                                editor.putString(MajorPlayoff1, String.valueOf(tiA.get(0).seq));
                                editor.putString(MajorPlayoff2, String.valueOf(tiB.get(3).seq));
                                editor.putString(MajorPlayoff3, String.valueOf(tiA.get(2).seq));
                                editor.putString(MajorPlayoff4, String.valueOf(tiB.get(1).seq));
                                editor.putString(MajorPlayoff5, String.valueOf(tiA.get(1).seq));
                                editor.putString(MajorPlayoff6, String.valueOf(tiB.get(2).seq));
                                editor.putString(MajorPlayoff7, String.valueOf(tiA.get(3).seq));
                                editor.putString(MajorPlayoff8, String.valueOf(tiB.get(0).seq));
                                editor.putString(MajorPlayoff9, String.valueOf(tiA.get(4).seq));
                                editor.putString(MajorPlayoff10, String.valueOf(tiB.get(7).seq));
                                editor.putString(MajorPlayoff11, String.valueOf(tiA.get(6).seq));
                                editor.putString(MajorPlayoff12, String.valueOf(tiB.get(5).seq));
                                editor.putString(MajorPlayoff13,String.valueOf(tiB.get(4).seq));
                                editor.putString(MajorPlayoff14, String.valueOf(tiA.get(5).seq));
                                editor.putString(MajorPlayoff15, String.valueOf(tiB.get(6).seq));
                                editor.putString(Mode,"6");
                                editor.apply();
                                startActivity(ToMajorPlayoff);
                            }
                            else if(groupstateposition<5)
                            {
                                editor.putString(WinnerorLossers, "1");
                                editor.putString(MajorPlayoff1, String.valueOf(tiB.get(3).seq));
                                editor.putString(MajorPlayoff2, String.valueOf(tiA.get(0).seq));
                                editor.putString(MajorPlayoff3, String.valueOf(tiB.get(1).seq));
                                editor.putString(MajorPlayoff4, String.valueOf(tiA.get(2).seq));
                                editor.putString(MajorPlayoff5, String.valueOf(tiB.get(0).seq));
                                editor.putString(MajorPlayoff6, String.valueOf(tiA.get(1).seq));
                                editor.putString(MajorPlayoff7, String.valueOf(tiB.get(2).seq));
                                editor.putString(MajorPlayoff8, String.valueOf(tiA.get(4).seq));
                                editor.putString(MajorPlayoff9, String.valueOf(tiB.get(7).seq));
                                editor.putString(MajorPlayoff10, String.valueOf(tiA.get(6).seq));
                                editor.putString(MajorPlayoff11, String.valueOf(tiB.get(5).seq));
                                editor.putString(MajorPlayoff12, String.valueOf(tiB.get(4).seq));
                                editor.putString(MajorPlayoff13,String.valueOf(tiA.get(5).seq));
                                editor.putString(MajorPlayoff14, String.valueOf(tiB.get(6).seq));
                                editor.putString(MajorPlayoff15, String.valueOf(tiA.get(3).seq));
                                editor.putString(Mode,"6");
                                editor.apply();
                                startActivity(ToMajorPlayoff);
                            }


                        }



                }













        });




    }
}
