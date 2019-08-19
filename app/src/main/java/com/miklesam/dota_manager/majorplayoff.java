package com.miklesam.dota_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.*;

public class majorplayoff extends AppCompatActivity {

    int MajorTeams[]= new int[23];
    SharedPreferences mSettings;
    ArrayList<Teams> MajorlayoffTeams= new ArrayList<Teams>();
    TextView Teamsplayoff[]=new TextView[44];
    ImageView Teamsplayofflogo[]=new ImageView[44];
    int Winners;
    String YourTeam;
    int MajorPLayofStage;
    ImageView nextminorbttn;
    TextView Scoreview[] = new TextView[44];

    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;

    int ScorePlay[]= new int[20];

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


    protected void Readflash()
    {
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

        if(mSettings.contains(MajorPlayoffStage)) {
            MajorPLayofStage=Integer.parseInt(mSettings.getString(MajorPlayoffStage, "MajorPlayoffStage"));
        }
        if (mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam = mSettings.getString(APP_PREFERENCES_NAME, "Your Team");
        }
        if(mSettings.contains(MajorPlayoff1)) {
            MajorTeams[0]=Integer.parseInt(mSettings.getString(MajorPlayoff1, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff2)) {
            MajorTeams[1]=Integer.parseInt(mSettings.getString(MajorPlayoff2, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff3)) {
            MajorTeams[2]=Integer.parseInt(mSettings.getString(MajorPlayoff3, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff4)) {
            MajorTeams[3]=Integer.parseInt(mSettings.getString(MajorPlayoff4, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff5)) {
            MajorTeams[4]=Integer.parseInt(mSettings.getString(MajorPlayoff5, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff6)) {
            MajorTeams[5]=Integer.parseInt(mSettings.getString(MajorPlayoff6, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff7)) {
            MajorTeams[6]=Integer.parseInt(mSettings.getString(MajorPlayoff7, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff8)) {
            MajorTeams[7]=Integer.parseInt(mSettings.getString(MajorPlayoff8, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff9)) {
            MajorTeams[8]=Integer.parseInt(mSettings.getString(MajorPlayoff9, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff10)) {
            MajorTeams[9]=Integer.parseInt(mSettings.getString(MajorPlayoff10, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff11)) {
            MajorTeams[10]=Integer.parseInt(mSettings.getString(MajorPlayoff11, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff12)) {
            MajorTeams[11]=Integer.parseInt(mSettings.getString(MajorPlayoff12, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff13)) {
            MajorTeams[12]=Integer.parseInt(mSettings.getString(MajorPlayoff13, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff14)) {
            MajorTeams[13]=Integer.parseInt(mSettings.getString(MajorPlayoff14, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff15)) {
            MajorTeams[14]=Integer.parseInt(mSettings.getString(MajorPlayoff15, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff16)) {
            MajorTeams[15]=Integer.parseInt(mSettings.getString(MajorPlayoff16, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff17)) {
            MajorTeams[16]=Integer.parseInt(mSettings.getString(MajorPlayoff17, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff18)) {
            MajorTeams[17]=Integer.parseInt(mSettings.getString(MajorPlayoff18, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff19)) {
            MajorTeams[18]=Integer.parseInt(mSettings.getString(MajorPlayoff19, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff20)) {
            MajorTeams[19]=Integer.parseInt(mSettings.getString(MajorPlayoff20, "Position2"));
        }

        if(mSettings.contains(MajorPlayoff21)) {
            MajorTeams[20]=Integer.parseInt(mSettings.getString(MajorPlayoff21, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff22)) {
            MajorTeams[21]=Integer.parseInt(mSettings.getString(MajorPlayoff22, "Position2"));
        }
        if(mSettings.contains(MajorPlayoff23)) {
            MajorTeams[22]=Integer.parseInt(mSettings.getString(MajorPlayoff23, "Position2"));
        }



        if(mSettings.contains(WinnerorLossers)) {
            Winners=Integer.parseInt(mSettings.getString(WinnerorLossers, "WinnerorLossers"));
        }


        if(mSettings.contains(MajorPScore1)) {
            ScorePlay[0]=Integer.parseInt(mSettings.getString(MajorPScore1, "MajorPScore1"));
        }
        if(mSettings.contains(MajorPScore2)) {
            ScorePlay[1]=Integer.parseInt(mSettings.getString(MajorPScore2, "MajorPScore2"));
        }
        if(mSettings.contains(MajorPScore3)) {
            ScorePlay[2]=Integer.parseInt(mSettings.getString(MajorPScore3, "MajorPScore3"));
        }
        if(mSettings.contains(MajorPScore4)) {
            ScorePlay[3]=Integer.parseInt(mSettings.getString(MajorPScore4, "MajorPScore4"));
        }
        if(mSettings.contains(MajorPScore5)) {
            ScorePlay[4]=Integer.parseInt(mSettings.getString(MajorPScore5, "MajorPScore5"));
        }
        if(mSettings.contains(MajorPScore6)) {
            ScorePlay[5]=Integer.parseInt(mSettings.getString(MajorPScore6, "MajorPScore6"));
        }
        if(mSettings.contains(MajorPScore7)) {
            ScorePlay[6]=Integer.parseInt(mSettings.getString(MajorPScore7, "MajorPScore7"));
        }
        if(mSettings.contains(MajorPScore8)) {
            ScorePlay[7]=Integer.parseInt(mSettings.getString(MajorPScore8, "MajorPScore8"));
        }
        if(mSettings.contains(MajorPScore9)) {
            ScorePlay[8]=Integer.parseInt(mSettings.getString(MajorPScore9, "MajorPScore9"));
        }
        if(mSettings.contains(MajorPScore10)) {
            ScorePlay[9]=Integer.parseInt(mSettings.getString(MajorPScore10, "MajorPScore10"));
        }
        if(mSettings.contains(MajorPScore11)) {
            ScorePlay[10]=Integer.parseInt(mSettings.getString(MajorPScore11, "MajorPScore11"));
        }
        if(mSettings.contains(MajorPScore12)) {
            ScorePlay[11]=Integer.parseInt(mSettings.getString(MajorPScore12, "MajorPScore12"));
        }
        if(mSettings.contains(MajorPScore13)) {
            ScorePlay[12]=Integer.parseInt(mSettings.getString(MajorPScore13, "MajorPScore13"));
        }
        if(mSettings.contains(MajorPScore14)) {
            ScorePlay[13]=Integer.parseInt(mSettings.getString(MajorPScore14, "MajorPScore14"));
        }
        if(mSettings.contains(MajorPScore15)) {
            ScorePlay[14]=Integer.parseInt(mSettings.getString(MajorPScore15, "MajorPScore15"));
        }
        if(mSettings.contains(MajorPScore16)) {
            ScorePlay[15]=Integer.parseInt(mSettings.getString(MajorPScore16, "MajorPScore16"));
        }
        if(mSettings.contains(MajorPScore17)) {
            ScorePlay[16]=Integer.parseInt(mSettings.getString(MajorPScore17, "MajorPScore17"));
        }
        if(mSettings.contains(MajorPScore18)) {
            ScorePlay[17]=Integer.parseInt(mSettings.getString(MajorPScore18, "MajorPScore18"));
        }
        if(mSettings.contains(MajorPScore19)) {
            ScorePlay[18]=Integer.parseInt(mSettings.getString(MajorPScore19, "MajorPScore19"));
        }
        if(mSettings.contains(MajorPScore20)) {
            ScorePlay[19]=Integer.parseInt(mSettings.getString(MajorPScore20, "MajorPScore20"));
        }







    }

    protected void InitView()
    {
        nextminorbttn=findViewById(R.id.playoffplay);
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

        Teamsplayoff[12]=findViewById(R.id.Teamname13);
        Teamsplayoff[13]=findViewById(R.id.Teamname14);
        Teamsplayoff[14]=findViewById(R.id.Teamname15);
        Teamsplayoff[15]=findViewById(R.id.Teamname16);

        Teamsplayoff[16]=findViewById(R.id.Teamname17);
        Teamsplayoff[17]=findViewById(R.id.Teamname18);
        Teamsplayoff[18]=findViewById(R.id.Teamname19);
        Teamsplayoff[19]=findViewById(R.id.Teamname20);

        Teamsplayoff[20]=findViewById(R.id.Teamname21);
        Teamsplayoff[21]=findViewById(R.id.Teamname22);
        Teamsplayoff[22]=findViewById(R.id.Teamname23);
        Teamsplayoff[23]=findViewById(R.id.Teamname24);

        Teamsplayoff[24]=findViewById(R.id.Teamname25);
        Teamsplayoff[25]=findViewById(R.id.Teamname26);
        Teamsplayoff[26]=findViewById(R.id.Teamname27);
        Teamsplayoff[27]=findViewById(R.id.Teamname28);
        Teamsplayoff[28]=findViewById(R.id.Teamname29);
        Teamsplayoff[29]=findViewById(R.id.Teamname30);
        Teamsplayoff[30]=findViewById(R.id.Teamname31);
        Teamsplayoff[31]=findViewById(R.id.Teamname32);

        Teamsplayoff[32]=findViewById(R.id.Teamname33);
        Teamsplayoff[33]=findViewById(R.id.Teamname34);
        Teamsplayoff[34]=findViewById(R.id.Teamname35);
        Teamsplayoff[35]=findViewById(R.id.Teamname36);

        Teamsplayoff[36]=findViewById(R.id.Teamname37);
        Teamsplayoff[37]=findViewById(R.id.Teamname38);
        Teamsplayoff[38]=findViewById(R.id.Teamname39);
        Teamsplayoff[39]=findViewById(R.id.Teamname40);

        Teamsplayoff[40]=findViewById(R.id.Teamname41);
        Teamsplayoff[41]=findViewById(R.id.Teamname42);
        Teamsplayoff[42]=findViewById(R.id.Teamname43);
        Teamsplayoff[43]=findViewById(R.id.Teamname44);


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

        Teamsplayofflogo[12]=findViewById(R.id.Team13);
        Teamsplayofflogo[13]=findViewById(R.id.Team14);
        Teamsplayofflogo[14]=findViewById(R.id.Team15);
        Teamsplayofflogo[15]=findViewById(R.id.Team16);

        Teamsplayofflogo[16]=findViewById(R.id.Team17);
        Teamsplayofflogo[17]=findViewById(R.id.Team18);
        Teamsplayofflogo[18]=findViewById(R.id.Team19);
        Teamsplayofflogo[19]=findViewById(R.id.Team20);
        Teamsplayofflogo[20]=findViewById(R.id.Team21);
        Teamsplayofflogo[21]=findViewById(R.id.Team22);
        Teamsplayofflogo[22]=findViewById(R.id.Team23);
        Teamsplayofflogo[23]=findViewById(R.id.Team24);


        Teamsplayofflogo[24]=findViewById(R.id.Team25);
        Teamsplayofflogo[25]=findViewById(R.id.Team26);
        Teamsplayofflogo[26]=findViewById(R.id.Team27);
        Teamsplayofflogo[27]=findViewById(R.id.Team28);
        Teamsplayofflogo[28]=findViewById(R.id.Team29);
        Teamsplayofflogo[29]=findViewById(R.id.Team30);
        Teamsplayofflogo[30]=findViewById(R.id.Team31);
        Teamsplayofflogo[31]=findViewById(R.id.Team32);
        Teamsplayofflogo[32]=findViewById(R.id.Team33);
        Teamsplayofflogo[33]=findViewById(R.id.Team34);
        Teamsplayofflogo[34]=findViewById(R.id.Team35);
        Teamsplayofflogo[35]=findViewById(R.id.Team36);

        Teamsplayofflogo[36]=findViewById(R.id.Team37);
        Teamsplayofflogo[37]=findViewById(R.id.Team38);
        Teamsplayofflogo[38]=findViewById(R.id.Team39);
        Teamsplayofflogo[39]=findViewById(R.id.Team40);

        Teamsplayofflogo[40]=findViewById(R.id.Team41);
        Teamsplayofflogo[41]=findViewById(R.id.Team42);
        Teamsplayofflogo[42]=findViewById(R.id.Team43);
        Teamsplayofflogo[43]=findViewById(R.id.Team44);






        Scoreview[0]=findViewById(R.id.Score1);
        Scoreview[1]=findViewById(R.id.Score2);
        Scoreview[2]=findViewById(R.id.Score3);
        Scoreview[3]=findViewById(R.id.Score4);
        Scoreview[4]=findViewById(R.id.Score5);
        Scoreview[5]=findViewById(R.id.Score6);
        Scoreview[6]=findViewById(R.id.Score7);
        Scoreview[7]=findViewById(R.id.Score8);
        Scoreview[8]=findViewById(R.id.Score9);
        Scoreview[9]=findViewById(R.id.Score10);
        Scoreview[10]=findViewById(R.id.Score11);
        Scoreview[11]=findViewById(R.id.Score12);
        Scoreview[12]=findViewById(R.id.Score13);
        Scoreview[13]=findViewById(R.id.Score14);
        Scoreview[14]=findViewById(R.id.Score15);
        Scoreview[15]=findViewById(R.id.Score16);

        Scoreview[16]=findViewById(R.id.Score17);
        Scoreview[17]=findViewById(R.id.Score18);
        Scoreview[18]=findViewById(R.id.Score19);
        Scoreview[19]=findViewById(R.id.Score20);
        Scoreview[20]=findViewById(R.id.Score21);
        Scoreview[21]=findViewById(R.id.Score22);
        Scoreview[22]=findViewById(R.id.Score23);
        Scoreview[23]=findViewById(R.id.Score24);
        Scoreview[24]=findViewById(R.id.Score25);
        Scoreview[25]=findViewById(R.id.Score26);
        Scoreview[26]=findViewById(R.id.Score27);
        Scoreview[27]=findViewById(R.id.Score28);
        Scoreview[28]=findViewById(R.id.Score29);
        Scoreview[29]=findViewById(R.id.Score30);
        Scoreview[30]=findViewById(R.id.Score31);
        Scoreview[31]=findViewById(R.id.Score32);

        Scoreview[32]=findViewById(R.id.Score33);
        Scoreview[33]=findViewById(R.id.Score34);
        Scoreview[34]=findViewById(R.id.Score35);
        Scoreview[35]=findViewById(R.id.Score36);
        Scoreview[36]=findViewById(R.id.Score37);
        Scoreview[37]=findViewById(R.id.Score38);
        Scoreview[38]=findViewById(R.id.Score39);
        Scoreview[39]=findViewById(R.id.Score40);
        Scoreview[40]=findViewById(R.id.Score41);
        Scoreview[41]=findViewById(R.id.Score42);
        Scoreview[42]=findViewById(R.id.Score43);
        Scoreview[43]=findViewById(R.id.Score44);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majorplayoff);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = mSettings.edit();
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        final Intent ToMainstate = new Intent(this, mainstate.class);

        InitView();
        Readflash();
        //Teamsplayoff[0].setText(String.valueOf(MajorPLayofStage));

        AllTeams.clear();
        MajorlayoffTeams.clear();
        MajorlayoffTeams = AllTeamsInit();

        if(Winners==1)
        {
            if(MajorPLayofStage==1)
            {
                editor.putString(MajorPlayoffStage, "2");
                editor.apply();
            }
            Readflash();
            for(int i=0; i<15;i++)
            {
                Teamsplayofflogo[i+1].setImageResource(MajorlayoffTeams.get(MajorTeams[i]).logo);
                Teamsplayoff[i+1].setText(MajorlayoffTeams.get(MajorTeams[i]).teamname);
            }
            Teamsplayofflogo[0].setImageResource(R.drawable.teamlogo);
            Teamsplayoff[0].setText(YourTeam);


            if (MajorPLayofStage==2)
            {
                if (ScorePlay[0]==2)
                {

                    Teamsplayofflogo[28].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[28].setText(YourTeam);
                    Teamsplayofflogo[23].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                    Teamsplayoff[23].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
                    editor.putString(MajorPlayoff22, "77");

                    editor.putString(MajorPlayoffStage, "4");
                }
                else if(ScorePlay[1]==2)
                {
                    Teamsplayofflogo[28].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                    Teamsplayoff[28].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
                    Teamsplayofflogo[23].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[23].setText(YourTeam);
                    editor.putString(MajorPlayoff22, String.valueOf(MajorlayoffTeams.get(MajorTeams[0]).seq));
                    editor.putString(MajorPlayoff16, "77");
                    editor.putString(MajorPlayoffStage, "3");
                }
                editor.apply();
            }

            Scoreview[0].setText(String.valueOf(ScorePlay[0]));
            Scoreview[1].setText(String.valueOf(ScorePlay[1]));

            Readflash();
            //Teamsplayoff[0].setText(String.valueOf(MajorPLayofStage));
        if(MajorPLayofStage>2)
        {
            Scoreview[2].setText("0");
            Scoreview[3].setText("2");
            Scoreview[4].setText("2");
            Scoreview[5].setText("0");
            Scoreview[6].setText("1");
            Scoreview[7].setText("2");

            Scoreview[8].setText("1");
            Scoreview[9].setText("0");
            Scoreview[10].setText("0");
            Scoreview[11].setText("1");
            Scoreview[12].setText("1");
            Scoreview[13].setText("0");
            Scoreview[14].setText("0");
            Scoreview[15].setText("1");


            Teamsplayofflogo[16].setImageResource(MajorlayoffTeams.get(MajorTeams[5]).logo);
            Teamsplayoff[16].setText(MajorlayoffTeams.get(MajorTeams[5]).teamname);
            Teamsplayofflogo[17].setImageResource(MajorlayoffTeams.get(MajorTeams[7]).logo);
            Teamsplayoff[17].setText(MajorlayoffTeams.get(MajorTeams[7]).teamname);
            Teamsplayofflogo[18].setImageResource(MajorlayoffTeams.get(MajorTeams[4]).logo);
            Teamsplayoff[18].setText(MajorlayoffTeams.get(MajorTeams[4]).teamname);
            Teamsplayofflogo[19].setImageResource(MajorlayoffTeams.get(MajorTeams[10]).logo);
            Teamsplayoff[19].setText(MajorlayoffTeams.get(MajorTeams[10]).teamname);
            Teamsplayofflogo[20].setImageResource(MajorlayoffTeams.get(MajorTeams[1]).logo);
            Teamsplayoff[20].setText(MajorlayoffTeams.get(MajorTeams[1]).teamname);
            Teamsplayofflogo[21].setImageResource(MajorlayoffTeams.get(MajorTeams[11]).logo);
            Teamsplayoff[21].setText(MajorlayoffTeams.get(MajorTeams[11]).teamname);
            Teamsplayofflogo[22].setImageResource(MajorlayoffTeams.get(MajorTeams[14]).logo);
            Teamsplayoff[22].setText(MajorlayoffTeams.get(MajorTeams[14]).teamname);


            Teamsplayofflogo[29].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
            Teamsplayoff[29].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);

            Teamsplayofflogo[30].setImageResource(MajorlayoffTeams.get(MajorTeams[3]).logo);
            Teamsplayoff[30].setText(MajorlayoffTeams.get(MajorTeams[3]).teamname);

            Teamsplayofflogo[31].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
            Teamsplayoff[31].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);

            Scoreview[16].setText("0");
            Scoreview[17].setText("0");
            Scoreview[18].setText("0");
            Scoreview[19].setText("0");
            Scoreview[20].setText("0");
            Scoreview[21].setText("0");
            Scoreview[22].setText("0");
            Scoreview[23].setText("0");

            //Scoreview[28].setText("0");
            //Scoreview[29].setText("0");
            Scoreview[30].setText("0");
            Scoreview[31].setText("0");


            Scoreview[28].setText(String.valueOf(ScorePlay[16]));
            Scoreview[29].setText(String.valueOf(ScorePlay[17]));


            if(MajorTeams[21]==77)
            {
                Teamsplayofflogo[28].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[28].setText(YourTeam);
                Teamsplayofflogo[23].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                Teamsplayoff[23].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
            }
            else
            {
                Teamsplayofflogo[28].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                Teamsplayoff[28].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
                Teamsplayofflogo[23].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[23].setText(YourTeam);
            }

            Scoreview[22].setText(String.valueOf(ScorePlay[4]));
            Scoreview[23].setText(String.valueOf(ScorePlay[5]));


        }


            if (MajorPLayofStage==3)
            {
                if (ScorePlay[4]==2)
                {
                    Teamsplayofflogo[27].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                    Teamsplayoff[27].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                    editor.putString(MajorPlayoff17, String.valueOf(MajorlayoffTeams.get(MajorTeams[6]).seq));
                    editor.putString(MajorPlayoffStage, "77");
                }
                else if(ScorePlay[5]==2)
                {
                    Teamsplayofflogo[27].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[27].setText(YourTeam);
                    editor.putString(MajorPlayoff17, "77");
                    editor.putString(MajorPlayoffStage, "5");
                }
                editor.apply();
            }
            Readflash();





            if (MajorPLayofStage==4)
            {
                if (ScorePlay[16]==2)
                {

                    Teamsplayofflogo[38].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[38].setText(YourTeam);
                    Teamsplayofflogo[32].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                    Teamsplayoff[32].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);

                    editor.putString(MajorPlayoff23, "77");
                    editor.putString(MajorPlayoffStage, "6");
                }
                else if(ScorePlay[17]==2)
                {
                    Teamsplayofflogo[38].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                    Teamsplayoff[38].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                    Teamsplayofflogo[32].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[32].setText(YourTeam);
                    editor.putString(MajorPlayoff18, "77");
                    editor.putString(MajorPlayoff23, String.valueOf(MajorlayoffTeams.get(MajorTeams[2]).seq));
                    editor.putString(MajorPlayoffStage, "7");
                }
                editor.apply();
            }
            Readflash();


            if(MajorPLayofStage>4)
            {
               if(MajorTeams[22] == 77)
               {
                   Scoreview[16].setText("2");
                   Scoreview[17].setText("1");
                   Scoreview[18].setText("0");
                   Scoreview[19].setText("2");
                   Scoreview[20].setText("0");
                   Scoreview[21].setText("2");
                   Scoreview[22].setText("1");
                   Scoreview[23].setText("2");
                   Scoreview[30].setText("1");
                   Scoreview[31].setText("2");



                   Teamsplayofflogo[24].setImageResource(MajorlayoffTeams.get(MajorTeams[5]).logo);
                   Teamsplayoff[24].setText(MajorlayoffTeams.get(MajorTeams[5]).teamname);
                   Teamsplayofflogo[25].setImageResource(MajorlayoffTeams.get(MajorTeams[10]).logo);
                   Teamsplayoff[25].setText(MajorlayoffTeams.get(MajorTeams[10]).teamname);
                   Teamsplayofflogo[26].setImageResource(MajorlayoffTeams.get(MajorTeams[11]).logo);
                   Teamsplayoff[26].setText(MajorlayoffTeams.get(MajorTeams[11]).teamname);
                   Teamsplayofflogo[27].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                   Teamsplayoff[27].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);

                   Teamsplayofflogo[39].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                   Teamsplayoff[39].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);


                   Scoreview[24].setText("2");
                   Scoreview[25].setText("1");
                   Scoreview[26].setText("1");
                   Scoreview[27].setText("2");



                   Teamsplayofflogo[33].setImageResource(MajorlayoffTeams.get(MajorTeams[5]).logo);
                   Teamsplayoff[33].setText(MajorlayoffTeams.get(MajorTeams[5]).teamname);

                   Teamsplayofflogo[34].setImageResource(MajorlayoffTeams.get(MajorTeams[3]).logo);
                   Teamsplayoff[34].setText(MajorlayoffTeams.get(MajorTeams[3]).teamname);

                   Teamsplayofflogo[35].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                   Teamsplayoff[35].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);


                   Scoreview[32].setText("2");
                   Scoreview[33].setText("1");
                   Scoreview[34].setText("1");
                   Scoreview[35].setText("2");

                   Teamsplayofflogo[36].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                   Teamsplayoff[36].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);

                   Teamsplayofflogo[37].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                   Teamsplayoff[37].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);

                   Scoreview[36].setText("0");
                   Scoreview[37].setText("0");

                   Scoreview[38].setText("0");
                   Scoreview[39].setText("0");


                   Scoreview[38].setText(String.valueOf(ScorePlay[18]));
                   Scoreview[39].setText(String.valueOf(ScorePlay[19]));


                   if(MajorTeams[22]==77)
                   {
                       Teamsplayofflogo[38].setImageResource(R.drawable.teamlogo);
                       Teamsplayoff[38].setText(YourTeam);
                       Teamsplayofflogo[32].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                       Teamsplayoff[32].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                   }
                   else
                   {
                       Teamsplayofflogo[38].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                       Teamsplayoff[38].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                       Teamsplayofflogo[32].setImageResource(R.drawable.teamlogo);
                       Teamsplayoff[32].setText(YourTeam);
                   }

               }

               else
               {
                   if(MajorTeams[16]==77)
                   {
                       Teamsplayofflogo[27].setImageResource(R.drawable.teamlogo);
                       Teamsplayoff[27].setText(YourTeam);
                   }
                   else
                   {
                       Teamsplayofflogo[27].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                       Teamsplayoff[27].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
                   }

                   if(MajorTeams[15]==77)
                   {
                       Teamsplayofflogo[38].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                       Teamsplayoff[38].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
                       Scoreview[26].setText(String.valueOf(ScorePlay[6]));
                       Scoreview[27].setText(String.valueOf(ScorePlay[7]));
                       Scoreview[28].setText("2");
                       Scoreview[29].setText("1");
                   }
                   else
                   {
                       Teamsplayofflogo[38].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                       Teamsplayoff[38].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                       Scoreview[22].setText("1");
                       Scoreview[23].setText("2");
                       Scoreview[26].setText("1");
                       Scoreview[27].setText("2");

                   }


                   Scoreview[16].setText("2");
                   Scoreview[17].setText("1");
                   Scoreview[18].setText("0");
                   Scoreview[19].setText("2");
                   Scoreview[20].setText("0");
                   Scoreview[21].setText("2");



                   Scoreview[30].setText("1");
                   Scoreview[31].setText("2");

                   Teamsplayofflogo[24].setImageResource(MajorlayoffTeams.get(MajorTeams[5]).logo);
                   Teamsplayoff[24].setText(MajorlayoffTeams.get(MajorTeams[5]).teamname);
                   Teamsplayofflogo[25].setImageResource(MajorlayoffTeams.get(MajorTeams[10]).logo);
                   Teamsplayoff[25].setText(MajorlayoffTeams.get(MajorTeams[10]).teamname);

                   Teamsplayofflogo[26].setImageResource(MajorlayoffTeams.get(MajorTeams[11]).logo);
                   Teamsplayoff[26].setText(MajorlayoffTeams.get(MajorTeams[11]).teamname);

                   Scoreview[24].setText("0");
                   Scoreview[25].setText("0");


                   Teamsplayofflogo[32].setImageResource(MajorlayoffTeams.get(MajorTeams[3]).logo);
                   Teamsplayoff[32].setText(MajorlayoffTeams.get(MajorTeams[3]).teamname);
                   if(MajorTeams[15]==77)
                   {
                       Teamsplayofflogo[34].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                       Teamsplayoff[34].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                   }
                   else
                   {
                       Teamsplayofflogo[34].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                       Teamsplayoff[34].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
                   }




                   Teamsplayofflogo[39].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                   Teamsplayoff[39].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);







               }






            }

            if (MajorPLayofStage==5)
            {
                if (ScorePlay[6]==2)
                {
                    Teamsplayofflogo[35].setImageResource(MajorlayoffTeams.get(MajorTeams[11]).logo);
                    Teamsplayoff[35].setText(MajorlayoffTeams.get(MajorTeams[11]).teamname);
                    editor.putString(MajorPlayoff18, String.valueOf(MajorlayoffTeams.get(MajorTeams[11]).seq));
                    editor.putString(MajorPlayoffStage, "77");
                }
                else if(ScorePlay[7]==2)
                {
                    Teamsplayofflogo[35].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[35].setText(YourTeam);
                    editor.putString(MajorPlayoff18, "77");
                    editor.putString(MajorPlayoffStage, "7");
                }
                editor.apply();
            }

            Readflash();


            if(MajorPLayofStage>6)
            {
                if (MajorTeams[22] == 77) {

                }
                else
                {
                    if(MajorTeams[17]==77)
                    {
                        Teamsplayofflogo[35].setImageResource(R.drawable.teamlogo);
                        Teamsplayoff[35].setText(YourTeam);
                    }
                    else
                    {
                        Teamsplayofflogo[35].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                        Teamsplayoff[35].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                    }


                    Scoreview[24].setText("2");
                    Scoreview[25].setText("1");


                    Teamsplayofflogo[33].setImageResource(MajorlayoffTeams.get(MajorTeams[5]).logo);
                    Teamsplayoff[33].setText(MajorlayoffTeams.get(MajorTeams[5]).teamname);

                    Scoreview[32].setText("0");
                    Scoreview[33].setText("0");
                    Scoreview[34].setText(String.valueOf(ScorePlay[8]));
                    Scoreview[35].setText(String.valueOf(ScorePlay[9]));
                }


            }







            if (MajorPLayofStage==6)
            {
                if (ScorePlay[18]==2)
                {


                    Teamsplayofflogo[41].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                    Teamsplayoff[41].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                    editor.putString(MajorPlayoff20, String.valueOf(MajorlayoffTeams.get(MajorTeams[6]).seq));
                    editor.putString(MajorPlayoff21, "77");
                    editor.putString(MajorPlayoffStage, "10");
                }
                else if(ScorePlay[19]==2)
                {

                    Teamsplayofflogo[41].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[41].setText(YourTeam);
                    editor.putString(MajorPlayoff20, "77");
                    editor.putString(MajorPlayoff21, String.valueOf(MajorlayoffTeams.get(MajorTeams[6]).seq));
                    editor.putString(MajorPlayoffStage, "9");
                }
                editor.apply();
            }
            Readflash();



            if (MajorPLayofStage==7)
            {
                if (ScorePlay[8]==2)
                {
                    Teamsplayofflogo[37].setImageResource(MajorlayoffTeams.get(MajorTeams[3]).logo);
                    Teamsplayoff[37].setText(MajorlayoffTeams.get(MajorTeams[3]).teamname);
                    editor.putString(MajorPlayoff19, String.valueOf(MajorlayoffTeams.get(MajorTeams[3]).seq));
                    editor.putString(MajorPlayoffStage, "77");
                }
                else if(ScorePlay[9]==2)
                {
                    Teamsplayofflogo[37].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[37].setText(YourTeam);
                    editor.putString(MajorPlayoff19, "77");
                    editor.putString(MajorPlayoffStage, "8");
                }
                editor.apply();
            }

            Readflash();

            if(MajorPLayofStage>7) {
                if(MajorTeams[22] == 77)
                {

                }
                else
                {
                    if (MajorTeams[18] == 77) {
                        Teamsplayofflogo[37].setImageResource(R.drawable.teamlogo);
                        Teamsplayoff[37].setText(YourTeam);
                    } else {
                        Teamsplayofflogo[37].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                        Teamsplayoff[37].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                    }

                    Scoreview[32].setText("2");
                    Scoreview[33].setText("1");
                    if(MajorTeams[15]==77)
                    {
                        Teamsplayofflogo[36].setImageResource(MajorlayoffTeams.get(MajorTeams[3]).logo);
                        Teamsplayoff[36].setText(MajorlayoffTeams.get(MajorTeams[3]).teamname);
                    }
                    else if(MajorTeams[17]==77)
                    {
                        Teamsplayofflogo[36].setImageResource(MajorlayoffTeams.get(MajorTeams[3]).logo);
                        Teamsplayoff[36].setText(MajorlayoffTeams.get(MajorTeams[3]).teamname);
                    }
                    else
                    {
                        Teamsplayofflogo[36].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                        Teamsplayoff[36].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                    }


                    Scoreview[32].setText("2");
                    Scoreview[33].setText("1");

                    Scoreview[36].setText(String.valueOf(ScorePlay[10]));
                    Scoreview[37].setText(String.valueOf(ScorePlay[11]));
                }




            }

            if (MajorPLayofStage==8)
            {
                if (ScorePlay[10]==2)
                {
                    Teamsplayofflogo[41].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                    Teamsplayoff[41].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                    editor.putString(MajorPlayoff20, String.valueOf(MajorlayoffTeams.get(MajorTeams[2]).seq));
                    editor.putString(MajorPlayoffStage, "77");
                }
                else if(ScorePlay[11]==2)
                {
                    Teamsplayofflogo[41].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[41].setText(YourTeam);
                    editor.putString(MajorPlayoff20, "77");
                    editor.putString(MajorPlayoffStage, "9");
                }
                editor.apply();
            }

            Readflash();






            if (MajorPLayofStage==9)
            {
                if (ScorePlay[12]==2)
                {
                    Teamsplayofflogo[43].setImageResource(MajorlayoffTeams.get(MajorTeams[7]).logo);
                    Teamsplayoff[43].setText(MajorlayoffTeams.get(MajorTeams[7]).teamname);
                    editor.putString(MajorPlayoff21, String.valueOf(MajorlayoffTeams.get(MajorTeams[7]).seq));
                    editor.putString(MajorPlayoffStage, "77");
                }
                else if(ScorePlay[13]==2)
                {
                    Teamsplayofflogo[43].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[43].setText(YourTeam);
                    editor.putString(MajorPlayoff21, "77");
                    editor.putString(MajorPlayoffStage, "10");
                }
                editor.apply();
            }
            Readflash();

            if(MajorPLayofStage>8) {

                if(MajorTeams[18] == 77)
                {
                    if (MajorTeams[19] == 77) {
                        Teamsplayofflogo[41].setImageResource(R.drawable.teamlogo);
                        Teamsplayoff[41].setText(YourTeam);
                    } else {
                        Teamsplayofflogo[41].setImageResource(MajorlayoffTeams.get(MajorTeams[4]).logo);
                        Teamsplayoff[41].setText(MajorlayoffTeams.get(MajorTeams[4]).teamname);
                    }

                    Scoreview[38].setText("2");
                    Scoreview[39].setText("1");
                    Teamsplayofflogo[40].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                    Teamsplayoff[40].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);


                        if(MajorTeams[15] == 77)
                        {
                            Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                            Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
                        }
                        else if(MajorTeams[17] == 77)
                        {
                            Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                            Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                        }
                        else
                        {
                            Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                            Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                        }






                    Scoreview[40].setText(String.valueOf(ScorePlay[12]));
                    Scoreview[41].setText(String.valueOf(ScorePlay[13]));


                    Scoreview[42].setText(String.valueOf(ScorePlay[14]));
                    Scoreview[43].setText(String.valueOf(ScorePlay[15]));


                }
                else {
                    if (MajorTeams[19] == 77) {
                        Teamsplayofflogo[41].setImageResource(R.drawable.teamlogo);
                        Teamsplayoff[41].setText(YourTeam);

                        if(MajorTeams[15] == 77)
                        {
                            Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
                            Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
                        }
                        else if(MajorTeams[16] == 77)
                        {
                            Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                            Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                        }
                        else
                        {
                            Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                            Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                        }


                        Scoreview[40].setText(String.valueOf(ScorePlay[12]));
                        Scoreview[41].setText(String.valueOf(ScorePlay[13]));

                    } else {

                        Scoreview[40].setText("2");
                        Scoreview[41].setText("1");
                        Teamsplayofflogo[41].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                        Teamsplayoff[41].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                        if ((MajorTeams[17] != 77)&&(MajorTeams[15]!=77)) {
                            Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                            Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
                        }



                    }

                    Scoreview[36].setText("2");
                    Scoreview[37].setText("1");
                    Teamsplayofflogo[40].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                    Teamsplayoff[40].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);



                    Scoreview[42].setText(String.valueOf(ScorePlay[14]));
                    Scoreview[43].setText(String.valueOf(ScorePlay[15]));


                }




            }


            /*
            if(MajorPLayofStage>8) {
                if (MajorTeams[19] == 77) {
                    Teamsplayofflogo[41].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[41].setText(YourTeam);
                    Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                    Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                    Scoreview[40].setText(String.valueOf(ScorePlay[12]));
                    Scoreview[41].setText(String.valueOf(ScorePlay[13]));

                } else {

                    Scoreview[40].setText("2");
                    Scoreview[41].setText("1");
                    Teamsplayofflogo[41].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                    Teamsplayoff[41].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                    Teamsplayofflogo[42].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[42].setText(YourTeam);

                }

                Scoreview[36].setText("2");
                Scoreview[37].setText("1");
                Teamsplayofflogo[40].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                Teamsplayoff[40].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);



                Scoreview[42].setText(String.valueOf(ScorePlay[14]));
                Scoreview[43].setText(String.valueOf(ScorePlay[15]));

                if (MajorTeams[20] == 77) {
                    Teamsplayofflogo[43].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[43].setText(YourTeam);


                } else {
                    Teamsplayofflogo[43].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                    Teamsplayoff[43].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);

                }

            }



            */





            if(MajorPLayofStage>9) {

                //Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
                //Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);

                if (MajorTeams[20] == 77) {
                    Teamsplayofflogo[43].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[43].setText(YourTeam);


                } else {
                    Teamsplayofflogo[43].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                    Teamsplayoff[43].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);

                }


                if (MajorPLayofStage == 11) {
                    if (ScorePlay[14] == 3) {
                        editor.putString(MajorPlayoffStage, "77");
                    } else if (ScorePlay[15] == 3) {
                        editor.putString(MajorPlayoffStage, "100");
                    }
                    editor.apply();
                }
            }


            if (MajorPLayofStage==10)
            {
                if (ScorePlay[14]==3)
                {
                    editor.putString(MajorPlayoffStage, "77");
                }
                else if(ScorePlay[15]==3)
                {
                    editor.putString(MajorPlayoffStage, "100");
                }
                editor.apply();
            }





            Readflash();




        }
        else {
            for (int i = 0; i < 15; i++) {
                Teamsplayofflogo[i].setImageResource(MajorlayoffTeams.get(MajorTeams[i]).logo);
                Teamsplayoff[i].setText(MajorlayoffTeams.get(MajorTeams[i]).teamname);
            }
            Teamsplayofflogo[15].setImageResource(R.drawable.teamlogo);
            Teamsplayoff[15].setText(YourTeam);

            if (MajorPLayofStage == 1) {
                if (ScorePlay[2] == 1) {
                    Teamsplayofflogo[23].setImageResource(MajorlayoffTeams.get(MajorTeams[14]).logo);
                    Teamsplayoff[23].setText(MajorlayoffTeams.get(MajorTeams[14]).teamname);
                    editor.putString(MajorPlayoff16, String.valueOf(MajorlayoffTeams.get(MajorTeams[14]).seq));
                    editor.putString(MajorPlayoffStage, "77");
                } else if (ScorePlay[3] == 1) {
                    Teamsplayofflogo[23].setImageResource(R.drawable.teamlogo);
                    Teamsplayoff[23].setText(YourTeam);
                    editor.putString(MajorPlayoff16, "77");
                    editor.putString(MajorPlayoffStage, "3");
                }
                editor.apply();
            }





        Readflash();

        if(MajorPLayofStage>2)
        {
            Scoreview[0].setText("2");
            Scoreview[1].setText("1");
            Scoreview[2].setText("0");
            Scoreview[3].setText("2");
            Scoreview[4].setText("2");
            Scoreview[5].setText("0");
            Scoreview[6].setText("1");
            Scoreview[7].setText("2");

            Scoreview[8].setText("1");
            Scoreview[9].setText("0");
            Scoreview[10].setText("0");
            Scoreview[11].setText("1");
            Scoreview[12].setText("1");
            Scoreview[13].setText("0");


            Teamsplayofflogo[16].setImageResource(MajorlayoffTeams.get(MajorTeams[1]).logo);
            Teamsplayoff[16].setText(MajorlayoffTeams.get(MajorTeams[1]).teamname);
            Teamsplayofflogo[17].setImageResource(MajorlayoffTeams.get(MajorTeams[8]).logo);
            Teamsplayoff[17].setText(MajorlayoffTeams.get(MajorTeams[8]).teamname);

            Teamsplayofflogo[18].setImageResource(MajorlayoffTeams.get(MajorTeams[2]).logo);
            Teamsplayoff[18].setText(MajorlayoffTeams.get(MajorTeams[2]).teamname);
            Teamsplayofflogo[19].setImageResource(MajorlayoffTeams.get(MajorTeams[11]).logo);
            Teamsplayoff[19].setText(MajorlayoffTeams.get(MajorTeams[11]).teamname);

            Teamsplayofflogo[20].setImageResource(MajorlayoffTeams.get(MajorTeams[5]).logo);
            Teamsplayoff[20].setText(MajorlayoffTeams.get(MajorTeams[5]).teamname);
            Teamsplayofflogo[21].setImageResource(MajorlayoffTeams.get(MajorTeams[12]).logo);
            Teamsplayoff[21].setText(MajorlayoffTeams.get(MajorTeams[12]).teamname);

            Teamsplayofflogo[22].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
            Teamsplayoff[22].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);


            Teamsplayofflogo[28].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
            Teamsplayoff[28].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
            Teamsplayofflogo[29].setImageResource(MajorlayoffTeams.get(MajorTeams[3]).logo);
            Teamsplayoff[29].setText(MajorlayoffTeams.get(MajorTeams[3]).teamname);

            Teamsplayofflogo[30].setImageResource(MajorlayoffTeams.get(MajorTeams[4]).logo);
            Teamsplayoff[30].setText(MajorlayoffTeams.get(MajorTeams[4]).teamname);
            Teamsplayofflogo[31].setImageResource(MajorlayoffTeams.get(MajorTeams[7]).logo);
            Teamsplayoff[31].setText(MajorlayoffTeams.get(MajorTeams[7]).teamname);

            Scoreview[16].setText("0");
            Scoreview[17].setText("0");
            Scoreview[18].setText("0");
            Scoreview[19].setText("0");
            Scoreview[20].setText("0");
            Scoreview[21].setText("0");
            Scoreview[22].setText("0");
            Scoreview[23].setText("0");

            Scoreview[28].setText("0");
            Scoreview[29].setText("0");
            Scoreview[30].setText("0");
            Scoreview[31].setText("0");


            Scoreview[22].setText(String.valueOf(ScorePlay[4]));
            Scoreview[23].setText(String.valueOf(ScorePlay[5]));




            if(MajorTeams[15]==77)
            {
                Teamsplayofflogo[23].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[23].setText(YourTeam);
            }
            else
            {
                Teamsplayofflogo[23].setImageResource(MajorlayoffTeams.get(MajorTeams[14]).logo);
                Teamsplayoff[23].setText(MajorlayoffTeams.get(MajorTeams[14]).teamname);
            }



        }

        Scoreview[14].setText(String.valueOf(ScorePlay[2]));
        Scoreview[15].setText(String.valueOf(ScorePlay[3]));



        if (MajorPLayofStage==3)
        {
            if (ScorePlay[4]==2)
            {
                Teamsplayofflogo[27].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                Teamsplayoff[27].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                editor.putString(MajorPlayoff17, String.valueOf(MajorlayoffTeams.get(MajorTeams[6]).seq));
                editor.putString(MajorPlayoffStage, "77");
            }
            else if(ScorePlay[5]==2)
            {
                Teamsplayofflogo[27].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[27].setText(YourTeam);
                editor.putString(MajorPlayoff17, "77");
                editor.putString(MajorPlayoffStage, "5");
            }
            editor.apply();
        }
        Readflash();

        if(MajorPLayofStage>4)
        {
            if(MajorTeams[16]==77)
            {
                Teamsplayofflogo[27].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[27].setText(YourTeam);
            }
            else
            {
                Teamsplayofflogo[27].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                Teamsplayoff[27].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
            }


            Scoreview[16].setText("2");
            Scoreview[17].setText("1");
            Scoreview[18].setText("0");
            Scoreview[19].setText("2");
            Scoreview[20].setText("0");
            Scoreview[21].setText("2");
            //Scoreview[22].setText("0");
            //Scoreview[23].setText("0");

            Scoreview[28].setText("2");
            Scoreview[29].setText("1");
            Scoreview[30].setText("1");
            Scoreview[31].setText("2");

            Teamsplayofflogo[24].setImageResource(MajorlayoffTeams.get(MajorTeams[1]).logo);
            Teamsplayoff[24].setText(MajorlayoffTeams.get(MajorTeams[1]).teamname);
            Teamsplayofflogo[25].setImageResource(MajorlayoffTeams.get(MajorTeams[11]).logo);
            Teamsplayoff[25].setText(MajorlayoffTeams.get(MajorTeams[11]).teamname);

            Teamsplayofflogo[26].setImageResource(MajorlayoffTeams.get(MajorTeams[12]).logo);
            Teamsplayoff[26].setText(MajorlayoffTeams.get(MajorTeams[12]).teamname);

            Scoreview[24].setText("0");
            Scoreview[25].setText("0");
            Scoreview[26].setText("0");
            Scoreview[27].setText("0");

            Teamsplayofflogo[32].setImageResource(MajorlayoffTeams.get(MajorTeams[3]).logo);
            Teamsplayoff[32].setText(MajorlayoffTeams.get(MajorTeams[3]).teamname);
            Teamsplayofflogo[34].setImageResource(MajorlayoffTeams.get(MajorTeams[4]).logo);
            Teamsplayoff[34].setText(MajorlayoffTeams.get(MajorTeams[4]).teamname);

            Teamsplayofflogo[38].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
            Teamsplayoff[38].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);
            Teamsplayofflogo[39].setImageResource(MajorlayoffTeams.get(MajorTeams[7]).logo);
            Teamsplayoff[39].setText(MajorlayoffTeams.get(MajorTeams[7]).teamname);


            Scoreview[26].setText(String.valueOf(ScorePlay[6]));
            Scoreview[27].setText(String.valueOf(ScorePlay[7]));


        }


        if (MajorPLayofStage==5)
        {
            if (ScorePlay[6]==2)
            {
                Teamsplayofflogo[35].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                Teamsplayoff[35].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
                editor.putString(MajorPlayoff18, String.valueOf(MajorlayoffTeams.get(MajorTeams[6]).seq));
                editor.putString(MajorPlayoffStage, "77");
            }
            else if(ScorePlay[7]==2)
            {
                Teamsplayofflogo[35].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[35].setText(YourTeam);
                editor.putString(MajorPlayoff18, "77");
                editor.putString(MajorPlayoffStage, "7");
            }
            editor.apply();
        }

        Readflash();



        if(MajorPLayofStage>6)
        {
            if(MajorTeams[17]==77)
            {
                Teamsplayofflogo[35].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[35].setText(YourTeam);
            }
            else
            {
                Teamsplayofflogo[35].setImageResource(MajorlayoffTeams.get(MajorTeams[6]).logo);
                Teamsplayoff[35].setText(MajorlayoffTeams.get(MajorTeams[6]).teamname);
            }


            Scoreview[24].setText("2");
            Scoreview[25].setText("1");


            Teamsplayofflogo[33].setImageResource(MajorlayoffTeams.get(MajorTeams[1]).logo);
            Teamsplayoff[33].setText(MajorlayoffTeams.get(MajorTeams[1]).teamname);

            Scoreview[32].setText("0");
            Scoreview[33].setText("0");
            Scoreview[34].setText(String.valueOf(ScorePlay[8]));
            Scoreview[35].setText(String.valueOf(ScorePlay[9]));

        }

        if (MajorPLayofStage==7)
        {
            if (ScorePlay[8]==2)
            {
                Teamsplayofflogo[38].setImageResource(MajorlayoffTeams.get(MajorTeams[4]).logo);
                Teamsplayoff[38].setText(MajorlayoffTeams.get(MajorTeams[4]).teamname);
                editor.putString(MajorPlayoff19, String.valueOf(MajorlayoffTeams.get(MajorTeams[4]).seq));
                editor.putString(MajorPlayoffStage, "77");
            }
            else if(ScorePlay[9]==2)
            {
                Teamsplayofflogo[38].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[38].setText(YourTeam);
                editor.putString(MajorPlayoff19, "77");
                editor.putString(MajorPlayoffStage, "8");
            }
            editor.apply();
        }

        Readflash();

        if(MajorPLayofStage>7) {
            if (MajorTeams[18] == 77) {
                Teamsplayofflogo[37].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[37].setText(YourTeam);
            } else {
                Teamsplayofflogo[37].setImageResource(MajorlayoffTeams.get(MajorTeams[4]).logo);
                Teamsplayoff[37].setText(MajorlayoffTeams.get(MajorTeams[4]).teamname);
            }


            Teamsplayofflogo[36].setImageResource(MajorlayoffTeams.get(MajorTeams[1]).logo);
            Teamsplayoff[36].setText(MajorlayoffTeams.get(MajorTeams[1]).teamname);

            Scoreview[32].setText("1");
            Scoreview[33].setText("2");

           Scoreview[36].setText(String.valueOf(ScorePlay[10]));
           Scoreview[37].setText(String.valueOf(ScorePlay[11]));



        }


        if (MajorPLayofStage==8)
        {
            if (ScorePlay[10]==2)
            {
                Teamsplayofflogo[41].setImageResource(MajorlayoffTeams.get(MajorTeams[1]).logo);
                Teamsplayoff[41].setText(MajorlayoffTeams.get(MajorTeams[1]).teamname);
                editor.putString(MajorPlayoff20, String.valueOf(MajorlayoffTeams.get(MajorTeams[1]).seq));
                editor.putString(MajorPlayoffStage, "77");
            }
            else if(ScorePlay[11]==2)
            {
                Teamsplayofflogo[41].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[41].setText(YourTeam);
                editor.putString(MajorPlayoff20, "77");
                editor.putString(MajorPlayoffStage, "9");
            }
            editor.apply();
        }

        Readflash();
        if(MajorPLayofStage>8) {
            if (MajorTeams[19] == 77) {
                Teamsplayofflogo[41].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[41].setText(YourTeam);
            } else {
                Teamsplayofflogo[41].setImageResource(MajorlayoffTeams.get(MajorTeams[4]).logo);
                Teamsplayoff[41].setText(MajorlayoffTeams.get(MajorTeams[4]).teamname);
            }

            Scoreview[38].setText("2");
            Scoreview[39].setText("1");
            Teamsplayofflogo[40].setImageResource(MajorlayoffTeams.get(MajorTeams[7]).logo);
            Teamsplayoff[40].setText(MajorlayoffTeams.get(MajorTeams[7]).teamname);

            Teamsplayofflogo[42].setImageResource(MajorlayoffTeams.get(MajorTeams[0]).logo);
            Teamsplayoff[42].setText(MajorlayoffTeams.get(MajorTeams[0]).teamname);


            Scoreview[40].setText(String.valueOf(ScorePlay[12]));
            Scoreview[41].setText(String.valueOf(ScorePlay[13]));



        }


        if (MajorPLayofStage==9)
        {
            if (ScorePlay[12]==2)
            {
                Teamsplayofflogo[43].setImageResource(MajorlayoffTeams.get(MajorTeams[7]).logo);
                Teamsplayoff[43].setText(MajorlayoffTeams.get(MajorTeams[7]).teamname);
                editor.putString(MajorPlayoff21, String.valueOf(MajorlayoffTeams.get(MajorTeams[7]).seq));
                editor.putString(MajorPlayoffStage, "77");
            }
            else if(ScorePlay[13]==2)
            {
                Teamsplayofflogo[43].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[43].setText(YourTeam);
                editor.putString(MajorPlayoff21, "77");
                editor.putString(MajorPlayoffStage, "10");
            }
            editor.apply();
        }
        Readflash();

        if(MajorPLayofStage>9) {
            if (MajorTeams[20] == 77) {
                Teamsplayofflogo[43].setImageResource(R.drawable.teamlogo);
                Teamsplayoff[43].setText(YourTeam);
            } else {
                Teamsplayofflogo[43].setImageResource(MajorlayoffTeams.get(MajorTeams[7]).logo);
                Teamsplayoff[43].setText(MajorlayoffTeams.get(MajorTeams[7]).teamname);
            }


            Scoreview[42].setText(String.valueOf(ScorePlay[14]));
            Scoreview[43].setText(String.valueOf(ScorePlay[15]));

        }

        if (MajorPLayofStage==10)
        {
            if (ScorePlay[14]==3)
            {
               editor.putString(MajorPlayoffStage, "77");
            }
            else if(ScorePlay[15]==3)
            {
              editor.putString(MajorPlayoffStage, "100");
            }
            editor.apply();
        }




        Readflash();
        }


        nextminorbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToPickStage.putExtra("TeamName", YourTeam);

                if(Winners==0)
                {
                    if(MajorPLayofStage==1)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[14]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[14]).seq);
                        startActivity(ToPickStage);
                    }
                    else if(MajorPLayofStage==3)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[6]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[6]).seq);
                        startActivity(ToPickStage);
                    }
                    else if(MajorPLayofStage==5)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[12]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[12]).seq);
                        startActivity(ToPickStage);
                    }
                    else if(MajorPLayofStage==7)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[4]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[4]).seq);
                        startActivity(ToPickStage);
                    }
                    else if(MajorPLayofStage==8)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[1]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[1]).seq);
                        startActivity(ToPickStage);
                    }
                    else if(MajorPLayofStage==9)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[7]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[7]).seq);
                        startActivity(ToPickStage);
                    }
                    else if(MajorPLayofStage==10)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[0]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[0]).seq);
                        startActivity(ToPickStage);
                    }

                    else if(MajorPLayofStage==100)
                    {
                        ClearNonStaticFlash();
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




                        editor.putString(Mode, "0");
                        editor.putString(InMajor, "0");
                        editor.putString(MajorPlayoffStage, "1");
                        editor.apply();
                        startActivity(ToMainstate);

                    }


                    else if(MajorPLayofStage==77)
                    {
                        ClearNonStaticFlash();
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




                        editor.putString(Mode, "0");
                        editor.putString(InMajor, "0");
                        editor.putString(MajorPlayoffStage, "1");
                        editor.apply();
                        startActivity(ToMainstate);

                    }




                }
                else if(Winners==1)
                {
                    Readflash();
                    if(MajorPLayofStage==2)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[0]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[0]).seq);
                        startActivity(ToPickStage);
                    }
                    else if(MajorPLayofStage==3)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[14]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[14]).seq);
                        startActivity(ToPickStage);
                    }

                    if(MajorPLayofStage==4)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[2]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[2]).seq);
                        startActivity(ToPickStage);
                    }
                    else if(MajorPLayofStage==5)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[11]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[11]).seq);
                        startActivity(ToPickStage);
                    }

                    if(MajorPLayofStage==6)
                    {
                        ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[6]).teamname);
                        ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[6]).seq);
                        startActivity(ToPickStage);
                    }

                    else if(MajorPLayofStage==7)
                    {
                        if(MajorTeams[15]==77)
                        {
                            ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[2]).teamname);
                            ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[2]).seq);
                        }
                        else
                        {
                            ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[0]).teamname);
                            ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[0]).seq);
                        }


                        startActivity(ToPickStage);
                    }
                    else if(MajorPLayofStage==8)
                    {
                        if(MajorTeams[15]==77)
                        {
                            ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[3]).teamname);
                            ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[3]).seq);


                        }   else if(MajorTeams[17]==77)
                        {
                            ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[3]).teamname);
                            ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[3]).seq);
                        }
                        else
                        {
                            ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[2]).teamname);
                            ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[2]).seq);
                        }


                        startActivity(ToPickStage);
                    }


                    if(MajorPLayofStage==9)
                    {
                         if(MajorTeams[17] == 77)
                        {
                            ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[6]).teamname);
                            ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[6]).seq);
                        }
                        else if(MajorTeams[19] == 77)
                         {
                             ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[2]).teamname);
                             ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[2]).seq);
                         }
                        else
                         {
                             ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[3]).teamname);
                             ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[3]).seq);
                         }

                        startActivity(ToPickStage);
                    }

                    if(MajorPLayofStage==10)
                    {

                        if (MajorTeams[19] == 77) {
                            if(MajorTeams[15] == 77)
                            {
                                ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[0]).teamname);
                                ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[0]).seq);
                            }
                            else if(MajorTeams[17] == 77)
                            {
                                ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[2]).teamname);
                                ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[2]).seq);
                            }
                            else
                            {
                                ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[6]).teamname);
                                ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[6]).seq);
                            }

                            startActivity(ToPickStage);
                        }
                        else
                            {

                                ToPickStage.putExtra("TeamEnemy", MajorlayoffTeams.get(MajorTeams[2]).teamname);
                                ToPickStage.putExtra("EnemyTeam", MajorlayoffTeams.get(MajorTeams[2]).seq);
                                startActivity(ToPickStage);
                            }





                    }


                    else if(MajorPLayofStage==100)
                    {
                        ClearNonStaticFlash();
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




                        editor.putString(Mode, "0");
                        editor.putString(InMajor, "0");
                        editor.putString(MajorPlayoffStage, "1");
                        editor.apply();
                        startActivity(ToMainstate);

                    }

                    else if(MajorPLayofStage==77)
                    {
                        ClearNonStaticFlash();
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
                        editor.putString(Mode, "0");




                        editor.putString(MajorPlayoffStage, "1");
                        editor.apply();
                        startActivity(ToMainstate);

                    }


                }








            }
            });





    }
}
