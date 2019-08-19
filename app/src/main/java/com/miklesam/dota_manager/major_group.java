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
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.TeamsInit.Chongqing;
import static com.miklesam.dota_manager.TeamsInit.ChongqingInit;
import static com.miklesam.dota_manager.TeamsInit.DreamMajInit;
import static com.miklesam.dota_manager.TeamsInit.KualaLumpur;
import static com.miklesam.dota_manager.TeamsInit.KualaLunpurInit;
import static com.miklesam.dota_manager.TeamsInit.dreammaj;
import static com.miklesam.dota_manager.TeamsInit.epicenter;
import static com.miklesam.dota_manager.TeamsInit.epicenterInit;
import static com.miklesam.dota_manager.TeamsInit.mdl;
import static com.miklesam.dota_manager.TeamsInit.mdlInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.MajorGroup1;
import static com.miklesam.dota_manager.YourTeam.MajorGroup10;
import static com.miklesam.dota_manager.YourTeam.MajorGroup11;
import static com.miklesam.dota_manager.YourTeam.MajorGroup12;
import static com.miklesam.dota_manager.YourTeam.MajorGroup13;
import static com.miklesam.dota_manager.YourTeam.MajorGroup14;
import static com.miklesam.dota_manager.YourTeam.MajorGroup15;
import static com.miklesam.dota_manager.YourTeam.MajorGroup2;
import static com.miklesam.dota_manager.YourTeam.MajorGroup3;
import static com.miklesam.dota_manager.YourTeam.MajorGroup4;
import static com.miklesam.dota_manager.YourTeam.MajorGroup5;
import static com.miklesam.dota_manager.YourTeam.MajorGroup6;
import static com.miklesam.dota_manager.YourTeam.MajorGroup7;
import static com.miklesam.dota_manager.YourTeam.MajorGroup8;
import static com.miklesam.dota_manager.YourTeam.MajorGroup9;
import static com.miklesam.dota_manager.YourTeam.MajorLose1;
import static com.miklesam.dota_manager.YourTeam.MajorLose2;
import static com.miklesam.dota_manager.YourTeam.MajorLose3;
import static com.miklesam.dota_manager.YourTeam.MajorLose4;
import static com.miklesam.dota_manager.YourTeam.MajorLose5;
import static com.miklesam.dota_manager.YourTeam.MajorLose6;
import static com.miklesam.dota_manager.YourTeam.MajorLose7;
import static com.miklesam.dota_manager.YourTeam.MajorLose8;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff1;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff10;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff11;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff12;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff13;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff14;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff15;

import static com.miklesam.dota_manager.YourTeam.MajorPlayoff2;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff3;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff4;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff5;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff6;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff7;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff8;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoff9;
import static com.miklesam.dota_manager.YourTeam.MajorPlayoffStage;
import static com.miklesam.dota_manager.YourTeam.MajorScore1;
import static com.miklesam.dota_manager.YourTeam.MajorScore2;
import static com.miklesam.dota_manager.YourTeam.MajorScore3;
import static com.miklesam.dota_manager.YourTeam.MajorScore4;
import static com.miklesam.dota_manager.YourTeam.MajorScore5;
import static com.miklesam.dota_manager.YourTeam.MajorScore6;
import static com.miklesam.dota_manager.YourTeam.MajorScore7;
import static com.miklesam.dota_manager.YourTeam.MajorScore8;
import static com.miklesam.dota_manager.YourTeam.MajorSeries1;
import static com.miklesam.dota_manager.YourTeam.MajorSeries2;
import static com.miklesam.dota_manager.YourTeam.MajorSeries3;
import static com.miklesam.dota_manager.YourTeam.MajorSeries4;
import static com.miklesam.dota_manager.YourTeam.MajorSeries5;
import static com.miklesam.dota_manager.YourTeam.MajorSeries6;
import static com.miklesam.dota_manager.YourTeam.MajorStage;
import static com.miklesam.dota_manager.YourTeam.MajorWin1;
import static com.miklesam.dota_manager.YourTeam.MajorWin2;
import static com.miklesam.dota_manager.YourTeam.MajorWin3;
import static com.miklesam.dota_manager.YourTeam.MajorWin4;
import static com.miklesam.dota_manager.YourTeam.MajorWin5;
import static com.miklesam.dota_manager.YourTeam.MajorWin6;
import static com.miklesam.dota_manager.YourTeam.MajorWin7;
import static com.miklesam.dota_manager.YourTeam.MajorWin8;

import static com.miklesam.dota_manager.YourTeam.Mode;

import static com.miklesam.dota_manager.YourTeam.Month;
import static com.miklesam.dota_manager.YourTeam.ShuffleMajor;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;
import static com.miklesam.dota_manager.YourTeam.WinnerorLossers;


public class major_group extends AppCompatActivity {

    ArrayList<Teams> MajorTeams = new ArrayList<>();
    TextView Teams[]= new TextView[16];
    ImageView TeamsLogo[] = new ImageView[16];
    TextView SeriesTeam[]=new TextView[40];
    ImageView SeriesLogo[] = new ImageView[40];
    TextView ScoreText[]= new TextView[40];

    TextView Majorname;
    ImageView EventImage;
    SharedPreferences mSettings;
    String YourTeam;
    int Major_stage;
    int Score[]=new int[8];
    int Win[]=new int[16];
    int Lose[]=new int[16];
    int Teamsplayoffs[]=new int[6];
    ImageView nextminorbttn;
    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;
    boolean five;
    TextView ScoreWin[]=new TextView[16];
    TextView ScoreLose[]=new TextView[16];
    int Monthint;
    ArrayList<ModelTeam> groupa = new ArrayList<>();
    ArrayList<ModelTeam> groupb = new ArrayList<>();
    ArrayList<ModelTeam> groupc = new ArrayList<>();
    ArrayList<ModelTeam> groupd = new ArrayList<>();
    int MajorPLayofStage;
    int ShuffleMajorint;
    int majorteamscup[]=new int[15];
    int MajorFlash[]=new int[15];
    ArrayList<Teams> MajorsTeams=new ArrayList<>();

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
    protected void InitView()
    {
        Majorname=findViewById(R.id.minorname);
        nextminorbttn=findViewById(R.id.nextminorbttn);
        EventImage=findViewById(R.id.EventImage);
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


        SeriesTeam[0]=findViewById(R.id.Series1team1);
        SeriesTeam[1]=findViewById(R.id.Series1team2);
        SeriesTeam[2]=findViewById(R.id.Series2team1);
        SeriesTeam[3]=findViewById(R.id.Series2team2);
        SeriesTeam[4]=findViewById(R.id.Series3team1);
        SeriesTeam[5]=findViewById(R.id.Series3team2);
        SeriesTeam[6]=findViewById(R.id.Series4team1);
        SeriesTeam[7]=findViewById(R.id.Series4team2);
        SeriesTeam[8]=findViewById(R.id.Series5team1);
        SeriesTeam[9]=findViewById(R.id.Series5team2);


        SeriesTeam[10]=findViewById(R.id.Series6team1);
        SeriesTeam[11]=findViewById(R.id.Series6team2);
        SeriesTeam[12]=findViewById(R.id.Series7team1);
        SeriesTeam[13]=findViewById(R.id.Series7team2);
        SeriesTeam[14]=findViewById(R.id.Series8team1);
        SeriesTeam[15]=findViewById(R.id.Series8team2);
        SeriesTeam[16]=findViewById(R.id.Series9team1);
        SeriesTeam[17]=findViewById(R.id.Series9team2);
        SeriesTeam[18]=findViewById(R.id.Series10team1);
        SeriesTeam[19]=findViewById(R.id.Series10team2);


        SeriesTeam[20]=findViewById(R.id.Series11team1);
        SeriesTeam[21]=findViewById(R.id.Series11team2);
        SeriesTeam[22]=findViewById(R.id.Series12team1);
        SeriesTeam[23]=findViewById(R.id.Series12team2);
        SeriesTeam[24]=findViewById(R.id.Series13team1);
        SeriesTeam[25]=findViewById(R.id.Series13team2);
        SeriesTeam[26]=findViewById(R.id.Series14team1);
        SeriesTeam[27]=findViewById(R.id.Series14team2);
        SeriesTeam[28]=findViewById(R.id.Series15team1);
        SeriesTeam[29]=findViewById(R.id.Series15team2);

        SeriesTeam[30]=findViewById(R.id.Series16team1);
        SeriesTeam[31]=findViewById(R.id.Series16team2);
        SeriesTeam[32]=findViewById(R.id.Series17team1);
        SeriesTeam[33]=findViewById(R.id.Series17team2);
        SeriesTeam[34]=findViewById(R.id.Series18team1);
        SeriesTeam[35]=findViewById(R.id.Series18team2);
        SeriesTeam[36]=findViewById(R.id.Series19team1);
        SeriesTeam[37]=findViewById(R.id.Series19team2);
        SeriesTeam[38]=findViewById(R.id.Series20team1);
        SeriesTeam[39]=findViewById(R.id.Series20team2);






        SeriesLogo[0]=findViewById(R.id.Series1teamlogo1);
        SeriesLogo[1]=findViewById(R.id.Series1teamlogo2);
        SeriesLogo[2]=findViewById(R.id.Series2teamlogo1);
        SeriesLogo[3]=findViewById(R.id.Series2teamlogo2);
        SeriesLogo[4]=findViewById(R.id.Series3teamlogo1);
        SeriesLogo[5]=findViewById(R.id.Series3teamlogo2);
        SeriesLogo[6]=findViewById(R.id.Series4teamlogo1);
        SeriesLogo[7]=findViewById(R.id.Series4teamlogo2);
        SeriesLogo[8]=findViewById(R.id.Series5teamlogo1);
        SeriesLogo[9]=findViewById(R.id.Series5teamlogo2);


        SeriesLogo[10]=findViewById(R.id.Series6teamlogo1);
        SeriesLogo[11]=findViewById(R.id.Series6teamlogo2);
        SeriesLogo[12]=findViewById(R.id.Series7teamlogo1);
        SeriesLogo[13]=findViewById(R.id.Series7teamlogo2);
        SeriesLogo[14]=findViewById(R.id.Series8teamlogo1);
        SeriesLogo[15]=findViewById(R.id.Series8teamlogo2);
        SeriesLogo[16]=findViewById(R.id.Series9teamlogo1);
        SeriesLogo[17]=findViewById(R.id.Series9teamlogo2);
        SeriesLogo[18]=findViewById(R.id.Series10teamlogo1);
        SeriesLogo[19]=findViewById(R.id.Series10teamlogo2);


        SeriesLogo[20]=findViewById(R.id.Series11teamlogo1);
        SeriesLogo[21]=findViewById(R.id.Series11teamlogo2);
        SeriesLogo[22]=findViewById(R.id.Series12teamlogo1);
        SeriesLogo[23]=findViewById(R.id.Series12teamlogo2);
        SeriesLogo[24]=findViewById(R.id.Series13teamlogo1);
        SeriesLogo[25]=findViewById(R.id.Series13teamlogo2);
        SeriesLogo[26]=findViewById(R.id.Series14teamlogo1);
        SeriesLogo[27]=findViewById(R.id.Series14teamlogo2);
        SeriesLogo[28]=findViewById(R.id.Series15teamlogo1);
        SeriesLogo[29]=findViewById(R.id.Series15teamlogo2);

        SeriesLogo[30]=findViewById(R.id.Series16teamlogo1);
        SeriesLogo[31]=findViewById(R.id.Series16teamlogo2);
        SeriesLogo[32]=findViewById(R.id.Series17teamlogo1);
        SeriesLogo[33]=findViewById(R.id.Series17teamlogo2);
        SeriesLogo[34]=findViewById(R.id.Series18teamlogo1);
        SeriesLogo[35]=findViewById(R.id.Series18teamlogo2);
        SeriesLogo[36]=findViewById(R.id.Series19teamlogo1);
        SeriesLogo[37]=findViewById(R.id.Series19teamlogo2);
        SeriesLogo[38]=findViewById(R.id.Series20teamlogo1);
        SeriesLogo[39]=findViewById(R.id.Series20teamlogo2);


        ScoreText[0]=findViewById(R.id.Series1scoreteam1);
        ScoreText[1]=findViewById(R.id.Series1scoreteam2);
        ScoreText[2]=findViewById(R.id.Series2scoreteam1);
        ScoreText[3]=findViewById(R.id.Series2scoreteam2);
        ScoreText[4]=findViewById(R.id.Series3scoreteam1);
        ScoreText[5]=findViewById(R.id.Series3scoreteam2);
        ScoreText[6]=findViewById(R.id.Series4scoreteam1);
        ScoreText[7]=findViewById(R.id.Series4scoreteam2);
        ScoreText[8]=findViewById(R.id.Series5scoreteam1);
        ScoreText[9]=findViewById(R.id.Series5scoreteam2);
        ScoreText[10]=findViewById(R.id.Series6scoreteam1);
        ScoreText[11]=findViewById(R.id.Series6scoreteam2);
        ScoreText[12]=findViewById(R.id.Series7scoreteam1);
        ScoreText[13]=findViewById(R.id.Series7scoreteam2);
        ScoreText[14]=findViewById(R.id.Series8scoreteam1);
        ScoreText[15]=findViewById(R.id.Series8scoreteam2);
        ScoreText[16]=findViewById(R.id.Series9scoreteam1);
        ScoreText[17]=findViewById(R.id.Series9scoreteam2);
        ScoreText[18]=findViewById(R.id.Series10scoreteam1);
        ScoreText[19]=findViewById(R.id.Series10scoreteam2);

        ScoreText[20]=findViewById(R.id.Series11scoreteam1);
        ScoreText[21]=findViewById(R.id.Series11scoreteam2);
        ScoreText[22]=findViewById(R.id.Series12scoreteam1);
        ScoreText[23]=findViewById(R.id.Series12scoreteam2);
        ScoreText[24]=findViewById(R.id.Series13scoreteam1);
        ScoreText[25]=findViewById(R.id.Series13scoreteam2);
        ScoreText[26]=findViewById(R.id.Series14scoreteam1);
        ScoreText[27]=findViewById(R.id.Series14scoreteam2);
        ScoreText[28]=findViewById(R.id.Series15scoreteam1);
        ScoreText[29]=findViewById(R.id.Series15scoreteam2);
        ScoreText[30]=findViewById(R.id.Series16scoreteam1);
        ScoreText[31]=findViewById(R.id.Series16scoreteam2);
        ScoreText[32]=findViewById(R.id.Series17scoreteam1);
        ScoreText[33]=findViewById(R.id.Series17scoreteam2);
        ScoreText[34]=findViewById(R.id.Series18scoreteam1);
        ScoreText[35]=findViewById(R.id.Series18scoreteam2);
        ScoreText[36]=findViewById(R.id.Series19scoreteam1);
        ScoreText[37]=findViewById(R.id.Series19scoreteam2);
        ScoreText[38]=findViewById(R.id.Series20scoreteam1);
        ScoreText[39]=findViewById(R.id.Series20scoreteam2);

        ScoreWin[0]=findViewById(R.id.ScoreWin1);
        ScoreWin[1]=findViewById(R.id.ScoreWin2);
        ScoreWin[2]=findViewById(R.id.ScoreWin3);
        ScoreWin[3]=findViewById(R.id.ScoreWin4);
        ScoreWin[4]=findViewById(R.id.ScoreWin5);
        ScoreWin[5]=findViewById(R.id.ScoreWin6);
        ScoreWin[6]=findViewById(R.id.ScoreWin7);
        ScoreWin[7]=findViewById(R.id.ScoreWin8);
        ScoreWin[8]=findViewById(R.id.ScoreWin9);
        ScoreWin[9]=findViewById(R.id.ScoreWin10);
        ScoreWin[10]=findViewById(R.id.ScoreWin11);
        ScoreWin[11]=findViewById(R.id.ScoreWin12);
        ScoreWin[12]=findViewById(R.id.ScoreWin13);
        ScoreWin[13]=findViewById(R.id.ScoreWin14);
        ScoreWin[14]=findViewById(R.id.ScoreWin15);
        ScoreWin[15]=findViewById(R.id.ScoreWin16);

        ScoreLose[0]=findViewById(R.id.ScoreLose1);
        ScoreLose[1]=findViewById(R.id.ScoreLose2);
        ScoreLose[2]=findViewById(R.id.ScoreLose3);
        ScoreLose[3]=findViewById(R.id.ScoreLose4);
        ScoreLose[4]=findViewById(R.id.ScoreLose5);
        ScoreLose[5]=findViewById(R.id.ScoreLose6);
        ScoreLose[6]=findViewById(R.id.ScoreLose7);
        ScoreLose[7]=findViewById(R.id.ScoreLose8);
        ScoreLose[8]=findViewById(R.id.ScoreLose9);
        ScoreLose[9]=findViewById(R.id.ScoreLose10);
        ScoreLose[10]=findViewById(R.id.ScoreLose11);
        ScoreLose[11]=findViewById(R.id.ScoreLose12);
        ScoreLose[12]=findViewById(R.id.ScoreLose13);
        ScoreLose[13]=findViewById(R.id.ScoreLose14);
        ScoreLose[14]=findViewById(R.id.ScoreLose15);
        ScoreLose[15]=findViewById(R.id.ScoreLose16);



    }

    protected  void ReadFlash()
    {

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



        if(mSettings.contains(ShuffleMajor)) {
            ShuffleMajorint=Integer.parseInt(mSettings.getString(ShuffleMajor, "ShuffleMajor"));
        }
        if(mSettings.contains(MajorPlayoffStage)) {
           MajorPLayofStage=Integer.parseInt(mSettings.getString(MajorPlayoffStage, "MajorPlayoffStage"));
        }

        if(mSettings.contains(StaticPosition1)) {
            Pos1=Integer.parseInt(mSettings.getString(StaticPosition1, "Position1"));
        }

        if(mSettings.contains(StaticPosition2)) {
            Pos2=Integer.parseInt(mSettings.getString(StaticPosition2, "Position2"));
        }

        if(mSettings.contains(StaticPosition3)) {
            Pos3=Integer.parseInt(mSettings.getString(StaticPosition3, "Position3"));
        }

        if(mSettings.contains(StaticPosition4)) {
            Pos4=Integer.parseInt(mSettings.getString(StaticPosition4, "Position4"));
        }

        if(mSettings.contains(StaticPosition5)) {
            Pos5=Integer.parseInt(mSettings.getString(StaticPosition5, "Position5"));
        }

        if (mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam = mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

        }

        if(mSettings.contains(MajorStage)) {
            Major_stage=Integer.parseInt(mSettings.getString(MajorStage, "1"));
        }

        if(mSettings.contains(MajorScore1)) {
            Score[0]=Integer.parseInt(mSettings.getString(MajorScore1, "0"));
        }
        if(mSettings.contains(MajorScore2)) {
            Score[1]=Integer.parseInt(mSettings.getString(MajorScore2, "0"));
        }
        if(mSettings.contains(MajorScore3)) {
            Score[2]=Integer.parseInt(mSettings.getString(MajorScore3, "0"));
        }
        if(mSettings.contains(MajorScore4)) {
            Score[3]=Integer.parseInt(mSettings.getString(MajorScore4, "0"));
        }
        if(mSettings.contains(MajorScore5)) {
            Score[4]=Integer.parseInt(mSettings.getString(MajorScore5, "0"));
        }
        if(mSettings.contains(MajorScore6)) {
            Score[5]=Integer.parseInt(mSettings.getString(MajorScore6, "0"));
        }
        if(mSettings.contains(MajorScore7)) {
            Score[6]=Integer.parseInt(mSettings.getString(MajorScore7, "0"));
        }
        if(mSettings.contains(MajorScore8)) {
            Score[7]=Integer.parseInt(mSettings.getString(MajorScore8, "0"));
        }
        if(mSettings.contains(MajorWin1)) {
            Win[0]=Integer.parseInt(mSettings.getString(MajorWin1, "MajorWin1"));
        }

        if(mSettings.contains(MajorLose1)) {
            Lose[0]=Integer.parseInt(mSettings.getString(MajorLose1, "MajorLose1"));
        }
        if(mSettings.contains(MajorWin2)) {
            Win[1]=Integer.parseInt(mSettings.getString(MajorWin2, "MajorWin2"));
        }

        if(mSettings.contains(MajorLose2)) {
            Lose[1]=Integer.parseInt(mSettings.getString(MajorLose2, "MajorLose2"));
        }
        if(mSettings.contains(MajorWin3)) {
            Win[2]=Integer.parseInt(mSettings.getString(MajorWin3, "MajorWin3"));
        }

        if(mSettings.contains(MajorLose3)) {
            Lose[2]=Integer.parseInt(mSettings.getString(MajorLose3, "MajorLose3"));
        }
        if(mSettings.contains(MajorWin4)) {
            Win[3]=Integer.parseInt(mSettings.getString(MajorWin4, "MajorWin4"));
        }

        if(mSettings.contains(MajorLose4)) {
            Lose[3]=Integer.parseInt(mSettings.getString(MajorLose4, "MajorLose4"));
        }
        if(mSettings.contains(MajorWin5)) {
            Win[4]=Integer.parseInt(mSettings.getString(MajorWin5, "MajorWin5"));
        }

        if(mSettings.contains(MajorLose5)) {
            Lose[4]=Integer.parseInt(mSettings.getString(MajorLose5, "MajorLose5"));
        }
        if(mSettings.contains(MajorWin6)) {
            Win[5]=Integer.parseInt(mSettings.getString(MajorWin6, "MajorWin6"));
        }

        if(mSettings.contains(MajorLose6)) {
            Lose[5]=Integer.parseInt(mSettings.getString(MajorLose6, "MajorLose6"));
        }
        if(mSettings.contains(MajorWin7)) {
            Win[6]=Integer.parseInt(mSettings.getString(MajorWin7, "MajorWin7"));
        }

        if(mSettings.contains(MajorLose7)) {
            Lose[6]=Integer.parseInt(mSettings.getString(MajorLose7, "MajorLose7"));
        }
        if(mSettings.contains(MajorWin8)) {
            Win[7]=Integer.parseInt(mSettings.getString(MajorWin8, "MajorWin8"));
        }

        if(mSettings.contains(MajorLose8)) {
            Lose[7]=Integer.parseInt(mSettings.getString(MajorLose8, "MajorLose8"));
        }


        if(mSettings.contains(MajorSeries1)) {
            Teamsplayoffs[0]=Integer.parseInt(mSettings.getString(MajorSeries1, "0"));
        }
        if(mSettings.contains(MajorSeries2)) {
            Teamsplayoffs[1]=Integer.parseInt(mSettings.getString(MajorSeries2, "0"));
        }
        if(mSettings.contains(MajorSeries3)) {
            Teamsplayoffs[2]=Integer.parseInt(mSettings.getString(MajorSeries3, "0"));
        }
        if(mSettings.contains(MajorSeries4)) {
            Teamsplayoffs[3]=Integer.parseInt(mSettings.getString(MajorSeries4, "0"));
        }
        if(mSettings.contains(MajorSeries5)) {
            Teamsplayoffs[4]=Integer.parseInt(mSettings.getString(MajorSeries5, "0"));
        }
        if(mSettings.contains(MajorSeries6)) {
            Teamsplayoffs[5]=Integer.parseInt(mSettings.getString(MajorSeries6, "0"));
        }

        if(mSettings.contains(Month)) {
            Monthint=Integer.parseInt(mSettings.getString(Month, "Month"));
        }


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_group);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = mSettings.edit();
        final Intent ToMAinState = new Intent(this, mainstate.class);
        InitView();
        ReadFlash();
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        final Intent ToMajorPlayoff = new Intent(this, majorplayoff.class);

        MajorsTeams.clear();

        AllTeams.clear();
        AllTeamsInit();
        if(Monthint==1)
        {
            EventImage.setImageResource(R.drawable.kualalumpurmajor);
            Majorname.setText("The Kuala Lumpur Major");
            KualaLumpur.clear();
            MajorsTeams=KualaLunpurInit();
        }
        else if(Monthint==3)
        {
            EventImage.setImageResource(R.drawable.chongqing);
            Majorname.setText("The Chongqing Major");
            Chongqing.clear();
            MajorsTeams=ChongqingInit();
        }
        else if(Monthint==5)
        {
            EventImage.setImageResource(R.drawable.dreamleaguemaj);
            Majorname.setText("DreamLeague Major");
            dreammaj.clear();
            MajorsTeams=DreamMajInit();
        }
        else if(Monthint==7)
        {
            EventImage.setImageResource(R.drawable.mdl);
            Majorname.setText("MDL Major");
            mdl.clear();
            MajorsTeams=mdlInit();

        }
        else if(Monthint==9)
        {
            EventImage.setImageResource(R.drawable.newepicenter);
            Majorname.setText("EPICENTER Major");
            epicenter.clear();
            MajorsTeams=epicenterInit();

        }
        else
        {

            EventImage.setImageResource(R.drawable.battlecup);
            AllTeams.clear();
            MajorsTeams=AllTeamsInit();
        }

        if(ShuffleMajorint==0)
        {
            Random randomteam = new Random();
            int whatteam;

            for (int i=0;i<15;i++)
            {
                whatteam=randomteam.nextInt(MajorsTeams.size());
                majorteamscup[i]=MajorsTeams.get(whatteam).seq;
                MajorTeams.add(MajorsTeams.get(whatteam));
                MajorsTeams.remove(whatteam);
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
            editor.putString(ShuffleMajor, "1");
            editor.apply();

        }
        else
        {
            MajorTeams.clear();
            for (int i=0;i<15;i++)
            {
                MajorTeams.add(AllTeams.get(MajorFlash[i]));
            }
        }


        if(Major_stage==0)
        {
            editor.putString(MajorStage, "1");
            editor.apply();
        }

        if(MajorPLayofStage==0)
        {
            editor.putString(MajorPlayoffStage, "1");
            editor.apply();
        }




        for (int i=0;i<15;i++)
        {
            Teams[i+1].setText(MajorTeams.get(i).teamname);
            TeamsLogo[i+1].setImageResource(MajorTeams.get(i).logo);
        }



        Teams[0].setText(YourTeam);
        TeamsLogo[0].setImageResource(R.drawable.teamlogo);


        SeriesTeam[0].setText(MajorTeams.get(0).teamname);
        SeriesLogo[0].setImageResource(MajorTeams.get(0).logo);
        SeriesTeam[1].setText(YourTeam);
        SeriesLogo[1].setImageResource(R.drawable.teamlogo);


        SeriesTeam[2].setText(MajorTeams.get(1).teamname);
        SeriesLogo[2].setImageResource(MajorTeams.get(1).logo);
        SeriesTeam[3].setText(MajorTeams.get(2).teamname);
        SeriesLogo[3].setImageResource(MajorTeams.get(2).logo);



        SeriesTeam[10].setText(MajorTeams.get(3).teamname);
        SeriesLogo[10].setImageResource(MajorTeams.get(3).logo);
        SeriesTeam[11].setText(MajorTeams.get(4).teamname);
        SeriesLogo[11].setImageResource(MajorTeams.get(4).logo);
        SeriesTeam[12].setText(MajorTeams.get(5).teamname);
        SeriesLogo[12].setImageResource(MajorTeams.get(5).logo);
        SeriesTeam[13].setText(MajorTeams.get(6).teamname);
        SeriesLogo[13].setImageResource(MajorTeams.get(6).logo);



        SeriesTeam[20].setText(MajorTeams.get(7).teamname);
        SeriesLogo[20].setImageResource(MajorTeams.get(7).logo);
        SeriesTeam[21].setText(MajorTeams.get(8).teamname);
        SeriesLogo[21].setImageResource(MajorTeams.get(8).logo);
        SeriesTeam[22].setText(MajorTeams.get(9).teamname);
        SeriesLogo[22].setImageResource(MajorTeams.get(9).logo);
        SeriesTeam[23].setText(MajorTeams.get(10).teamname);
        SeriesLogo[23].setImageResource(MajorTeams.get(10).logo);


        SeriesTeam[30].setText(MajorTeams.get(11).teamname);
        SeriesLogo[30].setImageResource(MajorTeams.get(11).logo);
        SeriesTeam[31].setText(MajorTeams.get(12).teamname);
        SeriesLogo[31].setImageResource(MajorTeams.get(12).logo);
        SeriesTeam[32].setText(MajorTeams.get(13).teamname);
        SeriesLogo[32].setImageResource(MajorTeams.get(13).logo);
        SeriesTeam[33].setText(MajorTeams.get(14).teamname);
        SeriesLogo[33].setImageResource(MajorTeams.get(14).logo);

        ScoreText[0].setText(String.valueOf(Score[0]));
        ScoreText[1].setText(String.valueOf(Score[1]));

        TextView SeriesTeamA[]= new TextView[6];
        ImageView SeriesLogoA[]= new ImageView[6];
        SeriesTeamA[0]=SeriesTeam[4];
        SeriesTeamA[1]=SeriesTeam[5];
        SeriesTeamA[2]=SeriesTeam[6];
        SeriesTeamA[3]=SeriesTeam[7];
        SeriesTeamA[4]=SeriesTeam[8];
        SeriesTeamA[5]=SeriesTeam[9];

        SeriesLogoA[0]=SeriesLogo[4];
        SeriesLogoA[1]=SeriesLogo[5];
        SeriesLogoA[2]=SeriesLogo[6];
        SeriesLogoA[3]=SeriesLogo[7];
        SeriesLogoA[4]=SeriesLogo[8];
        SeriesLogoA[5]=SeriesLogo[9];




        if(Major_stage==1)
        {

            if(Score[0]==2)
            {
                editor.putString(MajorStage,"2");
                editor.putString(MajorSeries2,"10");
                editor.putString(MajorSeries4, "1");
                editor.putString(MajorSeries1,"2");
                editor.putString(MajorSeries3, "3");


                editor.putString(MajorWin4, String.valueOf(Score[1]));
                editor.putString(MajorLose4, String.valueOf(Score[0]));

                editor.putString(MajorWin1,String.valueOf(Score[0]));
                editor.putString(MajorLose1, String.valueOf(Score[1]));

                editor.putString(MajorWin2,"0");
                editor.putString(MajorLose2,"2");

                editor.putString(MajorWin3,"2");
                editor.putString(MajorLose3,"0");

                editor.putString(MajorWin5,String.valueOf(Win[4]+2));
                editor.putString(MajorLose5,String.valueOf(Lose[4]+0));
                editor.putString(MajorWin6,String.valueOf(Win[5]+0));
                editor.putString(MajorLose6,String.valueOf(Lose[5]+2));
                editor.putString(MajorWin7,String.valueOf(Win[6]+1));
                editor.putString(MajorLose7,String.valueOf(Lose[6]+2));
                editor.putString(MajorWin8,String.valueOf(Win[7]+2));
                editor.putString(MajorLose8,String.valueOf(Lose[7]+1));


            }
            else if(Score[1]==2)
            {
                editor.putString(MajorStage,"3");
                editor.putString(MajorSeries4,"10");
                editor.putString(MajorSeries2,"1");
                editor.putString(MajorSeries1,"2");
                editor.putString(MajorSeries3, "3");

                editor.putString(MajorWin4, String.valueOf(Score[1]));
                editor.putString(MajorLose4, String.valueOf(Score[0]));

                editor.putString(MajorWin1,String.valueOf(Score[0]));
                editor.putString(MajorLose1, String.valueOf(Score[1]));

                editor.putString(MajorWin2,"0");
                editor.putString(MajorLose2,"2");

                editor.putString(MajorWin3,"2");
                editor.putString(MajorLose3,"0");

                editor.putString(MajorWin5,String.valueOf(Win[4]+2));
                editor.putString(MajorLose5,String.valueOf(Lose[4]+0));
                editor.putString(MajorWin6,String.valueOf(Win[5]+0));
                editor.putString(MajorLose6,String.valueOf(Lose[5]+2));
                editor.putString(MajorWin7,String.valueOf(Win[6]+1));
                editor.putString(MajorLose7,String.valueOf(Lose[6]+2));
                editor.putString(MajorWin8,String.valueOf(Win[7]+2));
                editor.putString(MajorLose8,String.valueOf(Lose[7]+1));

            }








            editor.apply();

        }
        else if(Major_stage==2)
        {
            if(Score[2]==2)
            {
                GroupWinnerLoser();
                editor.putString(MajorStage,"7");
                editor.putString(MajorSeries6,"2");
                nextminorbttn.setImageResource(R.drawable.next_bttn_canv_2);
                //editor.putString(MajorWin3, String.valueOf(Win[2] + 2));
              //  editor.putString(MajorLose3, String.valueOf(Lose[2] + 0));
               // editor.putString(MajorWin2, String.valueOf(Win[1] + 0));
               // editor.putString(MajorLose2, String.valueOf(Lose[1] + 2));

                editor.putString(MajorWin4, String.valueOf(Win[3]+ Score[3]));
                editor.putString(MajorLose4, String.valueOf(Lose[3]+ Score[2]));

                editor.putString(MajorWin2, String.valueOf(Win[1]+ Score[2]));
                editor.putString(MajorLose2, String.valueOf(Lose[1]+ Score[3]));



                editor.putString(MajorScore7, "2");
                editor.putString(MajorScore8, "0");
                editor.apply();
                ReadFlash();

                editor.putString(MajorWin2, String.valueOf(Win[1]+ 0));
                editor.putString(MajorLose2, String.valueOf(Lose[1]+ 2));

                editor.putString(MajorWin3, String.valueOf(Win[2]+ 2));
                editor.putString(MajorLose3, String.valueOf(Lose[2]+0));




            }
            else if(Score[3]==2)
            {
                GroupWinnerLoser();
                editor.putString(MajorStage,"4");
                editor.putString(MajorSeries6,"10");
            }
            editor.apply();
        }

        else if(Major_stage==3)
        {
            if(Score[4]==2)
            {

                GroupWinnerLoser();
                editor.putString(MajorStage,"4");
                editor.putString(MajorSeries6,"10");

            }
            else if(Score[5]==2)
            {
                GroupWinnerLoser();
                editor.putString(MajorStage,"5");
                editor.putString(MajorSeries6,"3");

            }
            editor.apply();
        }
        else if(Major_stage==4)
        {
            if(Score[6]==2)
            {

                GroupWinnerLoser();
                editor.putString(MajorStage,"7");
                nextminorbttn.setImageResource(R.drawable.next_bttn_canv_2);;


            }
            else if(Score[7]==2)
            {
                GroupWinnerLoser();
                editor.putString(MajorStage,"6");


            }
            editor.apply();
        }

        else if(Major_stage==7)
        {
            nextminorbttn.setImageResource(R.drawable.next_bttn_canv_2);
        }






        ReadFlash();

        if(Major_stage>1)
        {
            ScoreText[2].setText("0");
            ScoreText[3].setText("2");

            ScoreText[10].setText("2");
            ScoreText[11].setText("0");
            ScoreText[12].setText("1");
            ScoreText[13].setText("2");

            SeriesTeam[16].setText(MajorTeams.get(3).teamname);
            SeriesLogo[16].setImageResource(MajorTeams.get(3).logo);
            SeriesTeam[14].setText(MajorTeams.get(4).teamname);
            SeriesLogo[14].setImageResource(MajorTeams.get(4).logo);

            SeriesTeam[15].setText(MajorTeams.get(5).teamname);
            SeriesLogo[15].setImageResource(MajorTeams.get(5).logo);
            SeriesTeam[17].setText(MajorTeams.get(6).teamname);
            SeriesLogo[17].setImageResource(MajorTeams.get(6).logo);


            ScoreText[20].setText("0");
            ScoreText[21].setText("2");
            ScoreText[22].setText("2");
            ScoreText[23].setText("1");

            SeriesTeam[26].setText(MajorTeams.get(8).teamname);
            SeriesLogo[26].setImageResource(MajorTeams.get(8).logo);
            SeriesTeam[24].setText(MajorTeams.get(7).teamname);
            SeriesLogo[24].setImageResource(MajorTeams.get(7).logo);

            SeriesTeam[25].setText(MajorTeams.get(10).teamname);
            SeriesLogo[25].setImageResource(MajorTeams.get(10).logo);
            SeriesTeam[27].setText(MajorTeams.get(9).teamname);
            SeriesLogo[27].setImageResource(MajorTeams.get(9).logo);


            ScoreText[30].setText("2");
            ScoreText[31].setText("0");
            ScoreText[32].setText("1");
            ScoreText[33].setText("2");

            SeriesTeam[36].setText(MajorTeams.get(11).teamname);
            SeriesLogo[36].setImageResource(MajorTeams.get(11).logo);
            SeriesTeam[34].setText(MajorTeams.get(12).teamname);
            SeriesLogo[34].setImageResource(MajorTeams.get(12).logo);

            SeriesTeam[35].setText(MajorTeams.get(13).teamname);
            SeriesLogo[35].setImageResource(MajorTeams.get(13).logo);
            SeriesTeam[37].setText(MajorTeams.get(14).teamname);
            SeriesLogo[37].setImageResource(MajorTeams.get(14).logo);

            Win[8]=0;
            Win[9]=2;
            Win[10]=2;
            Win[11]=1;


            Lose[8]=2;
            Lose[9]=0;
            Lose[10]=1;
            Lose[11]=2;

            Win[12]=2;
            Win[13]=0;
            Win[14]=1;
            Win[15]=2;


            Lose[12]=0;
            Lose[13]=2;
            Lose[14]=2;
            Lose[15]=1;


        }

        if(Major_stage>3)
        {
            ScoreText[14].setText("0");
            ScoreText[15].setText("2");

            ScoreText[16].setText("2");
            ScoreText[17].setText("1");

            SeriesTeam[18].setText(MajorTeams.get(5).teamname);
            SeriesLogo[18].setImageResource(MajorTeams.get(5).logo);
            SeriesTeam[19].setText(MajorTeams.get(6).teamname);
            SeriesLogo[19].setImageResource(MajorTeams.get(6).logo);


            ScoreText[24].setText("2");
            ScoreText[25].setText("0");

            ScoreText[26].setText("1");
            ScoreText[27].setText("2");

            SeriesTeam[28].setText(MajorTeams.get(7).teamname);
            SeriesLogo[28].setImageResource(MajorTeams.get(7).logo);
            SeriesTeam[29].setText(MajorTeams.get(8).teamname);
            SeriesLogo[29].setImageResource(MajorTeams.get(8).logo);



            Win[8]=2;
            Win[9]=3;
            Win[10]=4;
            Win[11]=1;


            Lose[8]=2;
            Lose[9]=2;
            Lose[10]=2;
            Lose[11]=4;


            ScoreText[34].setText("1");
            ScoreText[35].setText("2");

            ScoreText[36].setText("2");
            ScoreText[37].setText("1");

            SeriesTeam[38].setText(MajorTeams.get(13).teamname);
            SeriesLogo[38].setImageResource(MajorTeams.get(13).logo);
            SeriesTeam[39].setText(MajorTeams.get(14).teamname);
            SeriesLogo[39].setImageResource(MajorTeams.get(14).logo);



            Win[12]=4;
            Win[13]=1;
            Win[14]=3;
            Win[15]=3;

            Lose[12]=1;
            Lose[13]=4;
            Lose[14]=3;
            Lose[15]=3;




        }
        ScoreText[8].setText(String.valueOf(Score[6]));
        ScoreText[9].setText(String.valueOf(Score[7]));
        if(Major_stage>5)
        {
             if (Teamsplayoffs[5]!=10)
            {
                if((Major_stage==7)||(Major_stage==6))
                {
                    ScoreText[8].setText("2");
                    ScoreText[9].setText("0");
                }
            }


            ScoreText[18].setText("2");
            ScoreText[19].setText("0");

            Win[6]=5;
            Win[7]=3;

            Lose[6]=2;
            Lose[7]=5;


            ScoreText[28].setText("2");
            ScoreText[29].setText("1");

            Win[8]=4;
            Win[9]=4;

            Lose[8]=3;
            Lose[9]=4;

            ScoreText[38].setText("2");
            ScoreText[39].setText("1");

            Win[14]=5;
            Win[15]=4;

            Lose[14]=4;
            Lose[15]=5;


        }




        ScoreText[4].setText(String.valueOf(Score[2]));
        ScoreText[5].setText(String.valueOf(Score[3]));
        ScoreText[6].setText(String.valueOf(Score[4]));
        ScoreText[7].setText(String.valueOf(Score[5]));




        for(int i=0;i<6;i++)
        {
            if(Teamsplayoffs[i]>0)
            {
                if(Teamsplayoffs[i]==10)
                {
                    SeriesTeamA[i].setText(YourTeam);
                    SeriesLogoA[i].setImageResource(R.drawable.teamlogo);
                }
                else
                {
                    SeriesTeamA[i].setText(MajorTeams.get(Teamsplayoffs[i]-1).teamname);
                    SeriesLogoA[i].setImageResource(MajorTeams.get(Teamsplayoffs[i]-1).logo);
                }

            }

        }


        ShuffleGroup();






        //ReadFlash();
        nextminorbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ToPickStage.putExtra("TeamName",YourTeam);
                editor.putString(Mode,"5");
                editor.apply();

                if(Major_stage==1)
                {
                    ToPickStage.putExtra("TeamEnemy",MajorTeams.get(0).teamname);
                    ToPickStage.putExtra("EnemyTeam",MajorTeams.get(0).seq);
                    startActivity(ToPickStage);
                }
                else if (Major_stage==2)
                {
                    ToPickStage.putExtra("TeamEnemy",MajorTeams.get(1).teamname);
                    ToPickStage.putExtra("EnemyTeam",MajorTeams.get(1).seq);
                    startActivity(ToPickStage);
                }
                else if (Major_stage==3)
                {
                    ToPickStage.putExtra("TeamEnemy",MajorTeams.get(2).teamname);
                    ToPickStage.putExtra("EnemyTeam",MajorTeams.get(2).seq);
                    startActivity(ToPickStage);
                }
                else if (Major_stage==4)
                {

                    if(Teamsplayoffs[1]==10)
                    {
                        ToPickStage.putExtra("TeamEnemy",MajorTeams.get(2).teamname);
                        ToPickStage.putExtra("EnemyTeam",MajorTeams.get(2).seq);
                    }
                    else
                    {
                        ToPickStage.putExtra("TeamEnemy",MajorTeams.get(0).teamname);
                        ToPickStage.putExtra("EnemyTeam",MajorTeams.get(0).seq);
                    }
                    startActivity(ToPickStage);
                }
                else if (Major_stage==5)
                {
                    if(five==false) {
                        ScoreText[8].setText("2");
                        ScoreText[9].setText("0");


                        editor.putString(MajorWin1, String.valueOf(Win[0] + 2));
                        editor.putString(MajorLose1, String.valueOf(Lose[0] + 0));

                        editor.putString(MajorWin3, String.valueOf(Win[2] + 0));
                        editor.putString(MajorLose3, String.valueOf(Lose[2] + 2));

                        editor.putString(MajorWin7, String.valueOf(Win[6] + 2));
                        editor.putString(MajorLose7, String.valueOf(Lose[6] + 0));

                        editor.putString(MajorWin8, String.valueOf(Win[7] + 0));
                        editor.putString(MajorLose8, String.valueOf(Lose[7] + 2));
                        editor.apply();

                        ScoreText[18].setText("2");
                        ScoreText[19].setText("0");

                        Win[6]=5;
                        Win[7]=3;

                        Lose[6]=2;
                        Lose[7]=5;


                        ScoreText[28].setText("2");
                        ScoreText[29].setText("1");

                        Win[8]=4;
                        Win[9]=4;

                        Lose[8]=3;
                        Lose[9]=4;

                        ScoreText[38].setText("2");
                        ScoreText[39].setText("1");

                        Win[14]=5;
                        Win[15]=4;

                        Lose[14]=4;
                        Lose[15]=5;




                        ReadFlash();
                        ShuffleGroup();
                        editor.putString(MajorStage, "6");
                        editor.apply();
                    }
                    if(five==true)
                    {
                        five=false;
                        editor.putString(WinnerorLossers, "1");
                        //editor.putString(MajorPlayoffStage, "2");
                        editor.putString(Mode,"6");
                        editor.apply();
                        ShuffleGroup();
                        InitPlayoff();
                        startActivity(ToMajorPlayoff);

                    }



                    five=true;

                }
                else if(Major_stage==6)
                {
                    editor.putString(WinnerorLossers, "1");
                    //editor.putString(MajorPlayoffStage, "2");
                    editor.putString(Mode,"6");
                    editor.apply();
                    ShuffleGroup();
                    InitPlayoff();
                    startActivity(ToMajorPlayoff);
                }

                else if(Major_stage==7) {
                  ShuffleGroup();
                   InitPlayoff();
                    editor.putString(WinnerorLossers, "0");
                    //editor.putString(MajorPlayoffStage, "1");
                    editor.putString(Mode,"6");
                    editor.apply();
                   startActivity(ToMajorPlayoff);

                }
                else
                {

                }


                //startActivity(ToMAinState);

            }
        });








    }
    protected void ShuffleGroup()
    {
        groupa.clear();
        groupa.add( new ModelTeam( MajorTeams.get(0).teamname,MajorTeams.get(0).logo,Win[0],Lose[0],MajorTeams.get(0).seq));
        groupa.add( new ModelTeam( MajorTeams.get(1).teamname,MajorTeams.get(1).logo,Win[1],Lose[1],MajorTeams.get(1).seq));
        groupa.add( new ModelTeam( MajorTeams.get(2).teamname,MajorTeams.get(2).logo,Win[2],Lose[2],MajorTeams.get(2).seq));
        groupa.add( new ModelTeam( YourTeam,R.drawable.teamlogo,Win[3],Lose[3],77));
        Collections.sort(groupa, ModelTeam.COMPARE_BY_Winning);

        for (int i=0;i<4;i++)
        {
            Teams[i].setText(groupa.get(i).TeamName);
            TeamsLogo[i].setImageResource(groupa.get(i).logo);
            ScoreWin[i].setText(String.valueOf(groupa.get(i).w));
            ScoreLose[i].setText(String.valueOf(groupa.get(i).l));
        }


        groupb.clear();
        groupb.add( new ModelTeam( MajorTeams.get(3).teamname,MajorTeams.get(3).logo,Win[4],Lose[4],MajorTeams.get(3).seq));
        groupb.add( new ModelTeam( MajorTeams.get(4).teamname,MajorTeams.get(4).logo,Win[5],Lose[5],MajorTeams.get(4).seq));
        groupb.add( new ModelTeam( MajorTeams.get(5).teamname,MajorTeams.get(5).logo,Win[6],Lose[6],MajorTeams.get(5).seq));
        groupb.add( new ModelTeam( MajorTeams.get(6).teamname,MajorTeams.get(6).logo,Win[7],Lose[7],MajorTeams.get(6).seq));
        Collections.sort(groupb, ModelTeam.COMPARE_BY_Winning);
        for (int i=0;i<4;i++)
        {
            Teams[4+i].setText(groupb.get(i).TeamName);
            TeamsLogo[4+i].setImageResource(groupb.get(i).logo);
            ScoreWin[4+i].setText(String.valueOf(groupb.get(i).w));
            ScoreLose[4+i].setText(String.valueOf(groupb.get(i).l));
        }

        groupc.clear();
        groupc.add( new ModelTeam( MajorTeams.get(7).teamname,MajorTeams.get(7).logo,Win[8],Lose[8],MajorTeams.get(7).seq));
        groupc.add( new ModelTeam( MajorTeams.get(8).teamname,MajorTeams.get(8).logo,Win[9],Lose[9],MajorTeams.get(8).seq));
        groupc.add( new ModelTeam( MajorTeams.get(9).teamname,MajorTeams.get(9).logo,Win[10],Lose[10],MajorTeams.get(9).seq));
        groupc.add( new ModelTeam( MajorTeams.get(10).teamname,MajorTeams.get(10).logo,Win[11],Lose[11],MajorTeams.get(10).seq));
        Collections.sort(groupc, ModelTeam.COMPARE_BY_Winning);
        for (int i=0;i<4;i++)
        {
            Teams[8+i].setText(groupc.get(i).TeamName);
            TeamsLogo[8+i].setImageResource(groupc.get(i).logo);
            ScoreWin[8+i].setText(String.valueOf(groupc.get(i).w));
            ScoreLose[8+i].setText(String.valueOf(groupc.get(i).l));
        }

        groupd.clear();
        groupd.add( new ModelTeam( MajorTeams.get(11).teamname,MajorTeams.get(11).logo,Win[12],Lose[12],MajorTeams.get(11).seq));
        groupd.add( new ModelTeam( MajorTeams.get(12).teamname,MajorTeams.get(12).logo,Win[13],Lose[13],MajorTeams.get(12).seq));
        groupd.add( new ModelTeam( MajorTeams.get(13).teamname,MajorTeams.get(13).logo,Win[14],Lose[14],MajorTeams.get(13).seq));
        groupd.add( new ModelTeam( MajorTeams.get(14).teamname,MajorTeams.get(14).logo,Win[15],Lose[15],MajorTeams.get(14).seq));
        Collections.sort(groupd, ModelTeam.COMPARE_BY_Winning);
        for (int i=0;i<4;i++)
        {
            Teams[12+i].setText(groupd.get(i).TeamName);
            TeamsLogo[12+i].setImageResource(groupd.get(i).logo);
            ScoreWin[12+i].setText(String.valueOf(groupd.get(i).w));
            ScoreLose[12+i].setText(String.valueOf(groupd.get(i).l));
        }

    }

    protected void GroupWinnerLoser()
    {
        SharedPreferences.Editor editor = mSettings.edit();
        if(Major_stage==2)
        {
            editor.putString(MajorScore5,"0");
            editor.putString(MajorScore6,"2");

            editor.putString(MajorSeries5,"3");


            editor.putString(MajorWin2,String.valueOf(Win[1]+Score[2]));
            editor.putString(MajorLose2,String.valueOf(Lose[1]+Score[3]));

            editor.putString(MajorWin4,String.valueOf(Win[3]+Score[3]));
            editor.putString(MajorLose4,String.valueOf(Lose[3]+Score[2]));

            editor.putString(MajorWin1,String.valueOf(Win[0]+2));
            editor.putString(MajorLose1,String.valueOf(Lose[0]+0));

            editor.putString(MajorWin3,String.valueOf(Win[2]+0));
            editor.putString(MajorLose3,String.valueOf(Lose[2]+2));


            editor.putString(MajorWin6,String.valueOf(Win[5]+0));
            editor.putString(MajorLose6,String.valueOf(Lose[5]+2));
            editor.putString(MajorWin7,String.valueOf(Win[6]+2));
            editor.putString(MajorLose7,String.valueOf(Lose[6]+0));

            editor.putString(MajorWin5,String.valueOf(Win[4]+2));
            editor.putString(MajorLose5,String.valueOf(Lose[4]+1));
            editor.putString(MajorWin8,String.valueOf(Win[7]+1));
            editor.putString(MajorLose8,String.valueOf(Lose[7]+2));


            editor.apply();





        }
        else if(Major_stage==3)
        {
            editor.putString(MajorScore3,"0");
            editor.putString(MajorScore4,"2");
            editor.putString(MajorSeries5,"1");

            editor.putString(MajorWin3,String.valueOf(Win[2]+Score[4]));
            editor.putString(MajorLose3,String.valueOf(Lose[2]+Score[5]));

            editor.putString(MajorWin4,String.valueOf(Win[3]+Score[5]));
            editor.putString(MajorLose4,String.valueOf(Lose[3]+Score[4]));

            editor.putString(MajorWin1,String.valueOf(Win[0]+2));
            editor.putString(MajorLose1,String.valueOf(Lose[0]+0));

            editor.putString(MajorWin2,String.valueOf(Win[1]+0));
            editor.putString(MajorLose2,String.valueOf(Lose[1]+2));


            editor.putString(MajorWin6,String.valueOf(Win[5]+0));
            editor.putString(MajorLose6,String.valueOf(Lose[5]+2));
            editor.putString(MajorWin7,String.valueOf(Win[6]+2));
            editor.putString(MajorLose7,String.valueOf(Lose[6]+0));

            editor.putString(MajorWin5,String.valueOf(Win[4]+2));
            editor.putString(MajorLose5,String.valueOf(Lose[4]+1));
            editor.putString(MajorWin8,String.valueOf(Win[7]+1));
            editor.putString(MajorLose8,String.valueOf(Lose[7]+2));


            editor.apply();
        }
        else if(Major_stage==4)
        {
            if(Teamsplayoffs[1]==10)
            {
                editor.putString(MajorWin3,String.valueOf(Win[2]+Score[6]));
                editor.putString(MajorLose3,String.valueOf(Lose[2]+Score[7]));
            }
            else
            {
                editor.putString(MajorWin1,String.valueOf(Win[0]+Score[6]));
                editor.putString(MajorLose1,String.valueOf(Lose[0]+Score[7]));
            }



            editor.putString(MajorWin4,String.valueOf(Win[3]+Score[7]));
            editor.putString(MajorLose4,String.valueOf(Lose[3]+Score[6]));

            editor.putString(MajorWin7, String.valueOf(Win[6] + 2));
            editor.putString(MajorLose7, String.valueOf(Lose[6] + 0));

            editor.putString(MajorWin8, String.valueOf(Win[7] + 0));
            editor.putString(MajorLose8, String.valueOf(Lose[7] + 2));

            editor.apply();
        }
    }

    protected void InitPlayoff()
    {
        int groupplace=0;
        SharedPreferences.Editor editor = mSettings.edit();
        for(int i=0;i<4;i++)
        {
            if (groupa.get(i).seq==77)
            {
                groupplace=i;
            }
        }

        if((groupplace==0))
        {
            editor.putString(MajorPlayoff1, String.valueOf(groupc.get(1).seq));
            editor.putString(MajorPlayoff2, String.valueOf(groupb.get(0).seq));
            editor.putString(MajorPlayoff3, String.valueOf(groupd.get(1).seq));
            editor.putString(MajorPlayoff4, String.valueOf(groupc.get(0).seq));
            editor.putString(MajorPlayoff5, String.valueOf(groupb.get(1).seq));
            editor.putString(MajorPlayoff6, String.valueOf(groupd.get(0).seq));
            editor.putString(MajorPlayoff7, String.valueOf(groupa.get(1).seq));
            editor.putString(MajorPlayoff8, String.valueOf(groupa.get(2).seq));
            editor.putString(MajorPlayoff9, String.valueOf(groupc.get(3).seq));
            editor.putString(MajorPlayoff10, String.valueOf(groupb.get(2).seq));
            editor.putString(MajorPlayoff11, String.valueOf(groupd.get(3).seq));
            editor.putString(MajorPlayoff12, String.valueOf(groupc.get(2).seq));
            editor.putString(MajorPlayoff13,String.valueOf(groupb.get(3).seq));
            editor.putString(MajorPlayoff14, String.valueOf(groupd.get(2).seq));
            editor.putString(MajorPlayoff15, String.valueOf(groupa.get(3).seq));
        }
        else if((groupplace==1))
        {
            editor.putString(MajorPlayoff1, String.valueOf(groupd.get(0).seq));
            editor.putString(MajorPlayoff2, String.valueOf(groupb.get(0).seq));
            editor.putString(MajorPlayoff3, String.valueOf(groupd.get(1).seq));
            editor.putString(MajorPlayoff4, String.valueOf(groupc.get(0).seq));
            editor.putString(MajorPlayoff5, String.valueOf(groupb.get(1).seq));
            editor.putString(MajorPlayoff6, String.valueOf(groupa.get(0).seq));
            editor.putString(MajorPlayoff7, String.valueOf(groupc.get(1).seq));
            editor.putString(MajorPlayoff8, String.valueOf(groupa.get(2).seq));
            editor.putString(MajorPlayoff9, String.valueOf(groupc.get(3).seq));
            editor.putString(MajorPlayoff10, String.valueOf(groupb.get(2).seq));
            editor.putString(MajorPlayoff11, String.valueOf(groupd.get(3).seq));
            editor.putString(MajorPlayoff12, String.valueOf(groupc.get(2).seq));
            editor.putString(MajorPlayoff13,String.valueOf(groupb.get(3).seq));
            editor.putString(MajorPlayoff14, String.valueOf(groupd.get(2).seq));
            editor.putString(MajorPlayoff15, String.valueOf(groupa.get(3).seq));
        }
        else if((groupplace==2))
        {
            editor.putString(MajorPlayoff1, String.valueOf(groupa.get(0).seq));
            editor.putString(MajorPlayoff2, String.valueOf(groupc.get(1).seq));
            editor.putString(MajorPlayoff3, String.valueOf(groupb.get(0).seq));
            editor.putString(MajorPlayoff4, String.valueOf(groupd.get(1).seq));
            editor.putString(MajorPlayoff5, String.valueOf(groupc.get(0).seq));
            editor.putString(MajorPlayoff6, String.valueOf(groupb.get(1).seq));
            editor.putString(MajorPlayoff7, String.valueOf(groupd.get(0).seq));
            editor.putString(MajorPlayoff8, String.valueOf(groupa.get(1).seq));

            editor.putString(MajorPlayoff9, String.valueOf(groupb.get(2).seq));
            editor.putString(MajorPlayoff10, String.valueOf(groupd.get(3).seq));
            editor.putString(MajorPlayoff11, String.valueOf(groupc.get(2).seq));
            editor.putString(MajorPlayoff12,String.valueOf(groupb.get(3).seq));
            editor.putString(MajorPlayoff13, String.valueOf(groupd.get(2).seq));
            editor.putString(MajorPlayoff14, String.valueOf(groupa.get(3).seq));
            editor.putString(MajorPlayoff15, String.valueOf(groupc.get(3).seq));
        }
        else if((groupplace==3))
        {
            editor.putString(MajorPlayoff1, String.valueOf(groupa.get(0).seq));
            editor.putString(MajorPlayoff2, String.valueOf(groupc.get(1).seq));
            editor.putString(MajorPlayoff3, String.valueOf(groupb.get(0).seq));
            editor.putString(MajorPlayoff4, String.valueOf(groupd.get(1).seq));
            editor.putString(MajorPlayoff5, String.valueOf(groupc.get(0).seq));
            editor.putString(MajorPlayoff6, String.valueOf(groupb.get(1).seq));
            editor.putString(MajorPlayoff7, String.valueOf(groupd.get(0).seq));
            editor.putString(MajorPlayoff8, String.valueOf(groupa.get(1).seq));


            editor.putString(MajorPlayoff9,String.valueOf(groupa.get(2).seq));
            editor.putString(MajorPlayoff10, String.valueOf(groupc.get(3).seq));
            editor.putString(MajorPlayoff11, String.valueOf(groupb.get(2).seq));
            editor.putString(MajorPlayoff12, String.valueOf(groupd.get(3).seq));
            editor.putString(MajorPlayoff13, String.valueOf(groupc.get(2).seq));
            editor.putString(MajorPlayoff14,String.valueOf(groupb.get(3).seq));
            editor.putString(MajorPlayoff15, String.valueOf(groupd.get(2).seq));

        }






        editor.apply();
    }

}
