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
import java.util.Collections;

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
import static com.miklesam.dota_manager.YourTeam.ClosedSeries;
import static com.miklesam.dota_manager.YourTeam.Closedlose;
import static com.miklesam.dota_manager.YourTeam.Closedwin;
import static com.miklesam.dota_manager.YourTeam.Day;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Language;
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

public class ClosedQuali extends AppCompatActivity {

    static ArrayList<Teams> ClosedTeamstour = new ArrayList<Teams>();

    TextView Teams[]= new TextView[8];
    TextView Seriesnteam[]= new TextView[7];
    TextView Seriesnyouteam[]= new TextView[7];
    ImageView Seriesnteamlogo[]=new ImageView[7];
    ImageView Seriesnyourteamlogo[]=new ImageView[7];



    TextView SeriesScore[]=new TextView[7];
    TextView SeriesScoreyou[]=new TextView[7];
    ImageView TeamsLogo[] = new ImageView[8];


    TextView TeamWin[]= new TextView[8];
    TextView TeamLose[]= new TextView[8];


    SharedPreferences mSettings;
    String YourTeam;
    ImageView Play_btn;
    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;
    int Seriescnt=0;
    int Dayint;

    int Closedwinint=0;
    int Closedloseint=0;

    int CloseWin7int=0;
    int CloseLose7int=0;

    int CloseWin6int=0;
    int CloseLose6int=0;

    int CloseWin5int=0;
    int CloseLose5int=0;

    int CloseWin4int=0;
    int CloseLose4int=0;

    int CloseWin3int=0;
    int CloseLose3int=0;

    int CloseWin2int=0;
    int CloseLose2int=0;

    int CloseWin1int=0;
    int CloseLose1int=0;
    TextView AfterGroupStage;
    int groupstateposition;
    boolean playoff;

    int CloseTeam[]= new int[7];
    int languageshare;


    ArrayList<ModelTeam> teamstable = new ArrayList<>();

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
        setContentView(R.layout.activity_closed_quali);

        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        final Intent ToMainstate = new Intent(this, mainstate.class);
        final Intent ToClosedPlayoff = new Intent(this, ClosedPlayoff.class);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        AllTeams.clear();


        ClosedTeamstour=AllTeamsInit();
        AfterGroupStage=findViewById(R.id.AfterGroupStage);
        Teams[0]=findViewById(R.id.Team1);
        Teams[1]=findViewById(R.id.Team2);
        Teams[2]=findViewById(R.id.Team3);
        Teams[3]=findViewById(R.id.Team4);
        Teams[4]=findViewById(R.id.Team5);
        Teams[5]=findViewById(R.id.Team6);
        Teams[6]=findViewById(R.id.Team7);
        Teams[7]=findViewById(R.id.Team8);



        TeamsLogo[0]=findViewById(R.id.Teamlogo1);
        TeamsLogo[1]=findViewById(R.id.Teamlogo2);
        TeamsLogo[2]=findViewById(R.id.Teamlogo3);
        TeamsLogo[3]=findViewById(R.id.Teamlogo4);
        TeamsLogo[4]=findViewById(R.id.Teamlogo5);
        TeamsLogo[5]=findViewById(R.id.Teamlogo6);
        TeamsLogo[6]=findViewById(R.id.Teamlogo7);
        TeamsLogo[7]=findViewById(R.id.Teamlogo8);

        Seriesnteam[0]=findViewById(R.id.Series1team1);
        Seriesnteam[1]=findViewById(R.id.Series2team1);
        Seriesnteam[2]=findViewById(R.id.Series3team1);
        Seriesnteam[3]=findViewById(R.id.Series4team1);
        Seriesnteam[4]=findViewById(R.id.Series5team1);
        Seriesnteam[5]=findViewById(R.id.Series6team1);
        Seriesnteam[6]=findViewById(R.id.Series7team1);

        Seriesnyouteam[0]=findViewById(R.id.Series1team2);
        Seriesnyouteam[1]=findViewById(R.id.Series2team2);
        Seriesnyouteam[2]=findViewById(R.id.Series3team2);
        Seriesnyouteam[3]=findViewById(R.id.Series4team2);
        Seriesnyouteam[4]=findViewById(R.id.Series5team2);
        Seriesnyouteam[5]=findViewById(R.id.Series6team2);
        Seriesnyouteam[6]=findViewById(R.id.Series7team2);


        Seriesnteamlogo[0]=findViewById(R.id.Series1teamlogo1);
        Seriesnteamlogo[1]=findViewById(R.id.Series2teamlogo1);
        Seriesnteamlogo[2]=findViewById(R.id.Series3teamlogo1);
        Seriesnteamlogo[3]=findViewById(R.id.Series4teamlogo1);
        Seriesnteamlogo[4]=findViewById(R.id.Series5teamlogo1);
        Seriesnteamlogo[5]=findViewById(R.id.Series6teamlogo1);
        Seriesnteamlogo[6]=findViewById(R.id.Series7teamlogo1);

        Seriesnyourteamlogo[0]=findViewById(R.id.Series1teamlogo2);
        Seriesnyourteamlogo[1]=findViewById(R.id.Series2teamlogo2);
        Seriesnyourteamlogo[2]=findViewById(R.id.Series3teamlogo2);
        Seriesnyourteamlogo[3]=findViewById(R.id.Series4teamlogo2);
        Seriesnyourteamlogo[4]=findViewById(R.id.Series5teamlogo2);
        Seriesnyourteamlogo[5]=findViewById(R.id.Series6teamlogo2);
        Seriesnyourteamlogo[6]=findViewById(R.id.Series7teamlogo2);

        Play_btn=findViewById(R.id.Play_btn);

        int Serieswin[]=new int[7];
        TeamWin[0]=findViewById(R.id.ScoreWin1);
        TeamWin[1]=findViewById(R.id.ScoreWin2);
        TeamWin[2]=findViewById(R.id.ScoreWin3);
        TeamWin[3]=findViewById(R.id.ScoreWin4);
        TeamWin[4]=findViewById(R.id.ScoreWin5);
        TeamWin[5]=findViewById(R.id.ScoreWin6);
        TeamWin[6]=findViewById(R.id.ScoreWin7);
        TeamWin[7]=findViewById(R.id.ScoreWin8);


        TeamLose[0]=findViewById(R.id.ScoreLose1);
        TeamLose[1]=findViewById(R.id.ScoreLose2);
        TeamLose[2]=findViewById(R.id.ScoreLose3);
        TeamLose[3]=findViewById(R.id.ScoreLose4);
        TeamLose[4]=findViewById(R.id.ScoreLose5);
        TeamLose[5]=findViewById(R.id.ScoreLose6);
        TeamLose[6]=findViewById(R.id.ScoreLose7);
        TeamLose[7]=findViewById(R.id.ScoreLose8);

        SeriesScore[0]=findViewById(R.id.Series1scoreteam1);
        SeriesScore[1]=findViewById(R.id.Series2scoreteam1);
        SeriesScore[2]=findViewById(R.id.Series3scoreteam1);
        SeriesScore[3]=findViewById(R.id.Series4scoreteam1);
        SeriesScore[4]=findViewById(R.id.Series5scoreteam1);
        SeriesScore[5]=findViewById(R.id.Series6scoreteam1);
        SeriesScore[6]=findViewById(R.id.Series7scoreteam1);

        SeriesScoreyou[0]=findViewById(R.id.Series1scoreteam2);
        SeriesScoreyou[1]=findViewById(R.id.Series2scoreteam2);
        SeriesScoreyou[2]=findViewById(R.id.Series3scoreteam2);
        SeriesScoreyou[3]=findViewById(R.id.Series4scoreteam2);
        SeriesScoreyou[4]=findViewById(R.id.Series5scoreteam2);
        SeriesScoreyou[5]=findViewById(R.id.Series6scoreteam2);
        SeriesScoreyou[6]=findViewById(R.id.Series7scoreteam2);



        if (mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam = mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

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

        if(mSettings.contains(ClosedSeries)) {
            Seriescnt=Integer.parseInt(mSettings.getString(ClosedSeries, "ClosedSeries"));
        }

        if(mSettings.contains(Closedwin)) {
            Closedwinint=Integer.parseInt(mSettings.getString(Closedwin, "Closedwin"));
        }

        if(mSettings.contains(Closedlose)) {
            Closedloseint=Integer.parseInt(mSettings.getString(Closedlose, "Closedlose"));
        }

        if(mSettings.contains(CloseWin7)) {
            CloseWin7int=Integer.parseInt(mSettings.getString(CloseWin7, "CloseWin7"));
        }

        if(mSettings.contains(CloseLose7)) {
            CloseLose7int=Integer.parseInt(mSettings.getString(CloseLose7, "CloseLose7"));
        }

        if(mSettings.contains(CloseWin6)) {
            CloseWin6int=Integer.parseInt(mSettings.getString(CloseWin6, "CloseWin6"));
        }

        if(mSettings.contains(CloseLose6)) {
            CloseLose6int=Integer.parseInt(mSettings.getString(CloseLose6, "CloseLose6"));
        }

        if(mSettings.contains(CloseWin5)) {
            CloseWin5int=Integer.parseInt(mSettings.getString(CloseWin5, "CloseWin5"));
        }

        if(mSettings.contains(CloseLose5)) {
            CloseLose5int=Integer.parseInt(mSettings.getString(CloseLose5, "CloseLose5"));
        }
        if(mSettings.contains(CloseWin4)) {
            CloseWin4int=Integer.parseInt(mSettings.getString(CloseWin4, "CloseWin4"));
        }

        if(mSettings.contains(CloseLose4)) {
            CloseLose4int=Integer.parseInt(mSettings.getString(CloseLose4, "CloseLose4"));
        }

        if(mSettings.contains(CloseWin3)) {
            CloseWin3int=Integer.parseInt(mSettings.getString(CloseWin3, "CloseWin3"));
        }

        if(mSettings.contains(CloseLose3)) {
            CloseLose3int=Integer.parseInt(mSettings.getString(CloseLose3, "CloseLose3"));
        }

        if(mSettings.contains(CloseWin2)) {
            CloseWin2int=Integer.parseInt(mSettings.getString(CloseWin2, "CloseWin2"));
        }

        if(mSettings.contains(CloseLose2)) {
            CloseLose2int=Integer.parseInt(mSettings.getString(CloseLose2, "CloseLose2"));
        }

        if(mSettings.contains(CloseWin1)) {
            CloseWin1int=Integer.parseInt(mSettings.getString(CloseWin1, "CloseWin1"));
        }

        if(mSettings.contains(CloseLose1)) {
            CloseLose1int=Integer.parseInt(mSettings.getString(CloseLose1, "CloseWin1"));
        }


        if(mSettings.contains(CloseTeam1)) {
            CloseTeam[0]=Integer.parseInt(mSettings.getString(CloseTeam1, "CloseTeam1"));
        }

        if(mSettings.contains(CloseTeam2)) {
            CloseTeam[1]=Integer.parseInt(mSettings.getString(CloseTeam2, "CloseTeam2"));
        }

        if(mSettings.contains(CloseTeam3)) {
            CloseTeam[2]=Integer.parseInt(mSettings.getString(CloseTeam3, "CloseTeam3"));
        }

        if(mSettings.contains(CloseTeam4)) {
            CloseTeam[3]=Integer.parseInt(mSettings.getString(CloseTeam4, "CloseTeam4"));
        }

        if(mSettings.contains(CloseTeam5)) {
            CloseTeam[4]=Integer.parseInt(mSettings.getString(CloseTeam5, "CloseTeam5"));
        }

        if(mSettings.contains(CloseTeam6)) {
            CloseTeam[5]=Integer.parseInt(mSettings.getString(CloseTeam6, "CloseTeam6"));
        }

        if(mSettings.contains(CloseTeam7)) {
            CloseTeam[6]=Integer.parseInt(mSettings.getString(CloseTeam7, "CloseTeam7"));
        }

        if(mSettings.contains(Day)) {
            Dayint=Integer.parseInt(mSettings.getString(Day, "Day"));
        }



        if(mSettings.contains(Series1Win)) {
            Serieswin[0]=Integer.parseInt(mSettings.getString(Series1Win, "0"));
        }
        if(mSettings.contains(Series2Win)) {
            Serieswin[1]=Integer.parseInt(mSettings.getString(Series2Win, "0"));
        }
        if(mSettings.contains(Series3Win)) {
            Serieswin[2]=Integer.parseInt(mSettings.getString(Series3Win, "0"));
        }
        if(mSettings.contains(Series4Win)) {
            Serieswin[3]=Integer.parseInt(mSettings.getString(Series4Win, "0"));
        }
        if(mSettings.contains(Series5Win)) {
            Serieswin[4]=Integer.parseInt(mSettings.getString(Series5Win, "0"));
        }
        if(mSettings.contains(Series6Win)) {
            Serieswin[5]=Integer.parseInt(mSettings.getString(Series6Win, "0"));
        }
        if(mSettings.contains(Series7Win)) {
            Serieswin[6]=Integer.parseInt(mSettings.getString(Series7Win, "0"));
        }

        if(mSettings.contains(Language)) {
            languageshare=Integer.parseInt(mSettings.getString(Language, "0"));
        }

        for(int i=0;i<7;i++)
        {
            if(Serieswin[i]==1)
            {
                SeriesScore[i].setText("0");
                SeriesScoreyou[i].setText("1");
            }
            else if (Serieswin[i]==2)
            {
                SeriesScore[i].setText("1");
                SeriesScoreyou[i].setText("0");
            }
        }








        final SharedPreferences.Editor editor = mSettings.edit();











        editor.putString(Mode, "2");
        editor.apply();


        teamstable.clear();
        teamstable.add( new ModelTeam( ClosedTeamstour.get(CloseTeam[0]).teamname,ClosedTeamstour.get(CloseTeam[0]).logo,CloseWin1int,CloseLose1int,ClosedTeamstour.get(CloseTeam[0]).seq));
        teamstable.add( new ModelTeam( ClosedTeamstour.get(CloseTeam[1]).teamname,ClosedTeamstour.get(CloseTeam[1]).logo,CloseWin2int,CloseLose2int,ClosedTeamstour.get(CloseTeam[1]).seq));
        teamstable.add( new ModelTeam( ClosedTeamstour.get(CloseTeam[2]).teamname,ClosedTeamstour.get(CloseTeam[2]).logo,CloseWin3int,CloseLose3int,ClosedTeamstour.get(CloseTeam[2]).seq));
        teamstable.add( new ModelTeam( ClosedTeamstour.get(CloseTeam[3]).teamname,ClosedTeamstour.get(CloseTeam[3]).logo,CloseWin4int,CloseLose4int,ClosedTeamstour.get(CloseTeam[3]).seq));
        teamstable.add( new ModelTeam( ClosedTeamstour.get(CloseTeam[4]).teamname,ClosedTeamstour.get(CloseTeam[4]).logo,CloseWin5int,CloseLose5int,ClosedTeamstour.get(CloseTeam[4]).seq));
        teamstable.add( new ModelTeam( ClosedTeamstour.get(CloseTeam[5]).teamname,ClosedTeamstour.get(CloseTeam[5]).logo,CloseWin6int,CloseLose6int,ClosedTeamstour.get(CloseTeam[5]).seq));
        teamstable.add( new ModelTeam( ClosedTeamstour.get(CloseTeam[6]).teamname,ClosedTeamstour.get(CloseTeam[6]).logo,CloseWin7int,CloseLose7int,ClosedTeamstour.get(CloseTeam[6]).seq));
        teamstable.add( new ModelTeam(YourTeam ,R.drawable.teamlogo,Closedwinint,Closedloseint,77));
        Collections.sort(teamstable, ModelTeam.COMPARE_BY_Winning);



        for (int i=0;i<8;i++)
        {
            Teams[i].setText(teamstable.get(i).TeamName);
            TeamsLogo[i].setImageResource(teamstable.get(i).logo);
            TeamWin[i].setText(String.valueOf(teamstable.get(i).w));
            TeamLose[i].setText(String.valueOf(teamstable.get(i).l));
        }

        for (int i=0;i<7;i++)
        {
            Seriesnteam[i].setText(ClosedTeamstour.get(CloseTeam[7-(i+1)]).teamname);
            Seriesnteamlogo[i].setImageResource(ClosedTeamstour.get(CloseTeam[7-(i+1)]).logo);
            Seriesnyouteam[i].setText(YourTeam);
            Seriesnyourteamlogo[i].setImageResource(R.drawable.teamlogo);

        }


    if(Seriescnt==7)
    {
        for(int i=0;i<teamstable.size();i++)
        {
            if(teamstable.get(i).TeamName.equals(YourTeam))
            {
                groupstateposition=i+1;
                break;
            }

        }

        if (groupstateposition==1)
        {
            if(languageshare==2)
            {
                AfterGroupStage.setText("You take first place and go to the main event");
            }
            else{
                AfterGroupStage.setText("Вы заняли " + groupstateposition + " Место"+" и прошли на прямую");
            }
            editor.putString(MinorQual,"1");
            editor.apply();


            AfterGroupStage.setVisibility(View.VISIBLE);
        }
        else if ((groupstateposition>1)&&(groupstateposition<6))
        {
            if(languageshare==2)
            {
                AfterGroupStage.setText("You take " + groupstateposition + " place"+" and go to the playoff");
            }
            else{
                AfterGroupStage.setText("Вы заняли " + groupstateposition + " Место"+" и прошли в плей-офф");
            }

            playoff=true;
            Play_btn.setImageResource(R.drawable.next_bttn_canv_2);
            AfterGroupStage.setVisibility(View.VISIBLE);
        }
        else
        {
            if(languageshare==2)
            {
                AfterGroupStage.setText("You take " + groupstateposition + " place"+" and leave qual");
            }
            else
            {
                AfterGroupStage.setText("Вы заняли " + groupstateposition + " Место"+" и вылетели");
            }

            AfterGroupStage.setVisibility(View.VISIBLE);
        }


    }







        Play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(playoff==true)
                {

                    if (groupstateposition==2)
                    {

                        editor.putString(TeamPlayoff2, String.valueOf(teamstable.get(4).seq));
                        editor.putString(TeamPlayoff3, String.valueOf(teamstable.get(2).seq));
                        editor.putString(TeamPlayoff4,String.valueOf(teamstable.get(3).seq));
                    }
                    else if (groupstateposition==3)
                    {

                        editor.putString(TeamPlayoff2, String.valueOf(teamstable.get(3).seq));
                        editor.putString(TeamPlayoff3, String.valueOf(teamstable.get(1).seq));
                        editor.putString(TeamPlayoff4, String.valueOf(teamstable.get(4).seq));
                    }
                    else if (groupstateposition==4)
                    {

                        editor.putString(TeamPlayoff2, String.valueOf(teamstable.get(2).seq));
                        editor.putString(TeamPlayoff3, String.valueOf(teamstable.get(1).seq));
                        editor.putString(TeamPlayoff4, String.valueOf(teamstable.get(4).seq));
                    }
                    else if (groupstateposition==5)
                    {

                        editor.putString(TeamPlayoff2, String.valueOf(teamstable.get(1).seq));
                        editor.putString(TeamPlayoff3, String.valueOf(teamstable.get(2).seq));
                        editor.putString(TeamPlayoff4, String.valueOf(teamstable.get(3).seq));
                    }

                    editor.apply();
                    startActivity(ToClosedPlayoff);
                }

                    else
                {
                    if(Seriescnt<7)
                    {
                        ToPickStage.putExtra("Position1",Pos1);
                        ToPickStage.putExtra("Position2",Pos2);
                        ToPickStage.putExtra("Position3",Pos3);
                        ToPickStage.putExtra("Position4",Pos4);
                        ToPickStage.putExtra("Position5",Pos5);
                        ToPickStage.putExtra("TeamName",YourTeam);

                        ToPickStage.putExtra("TeamEnemy",ClosedTeamstour.get(CloseTeam[6-Seriescnt]).teamname);
                        ToPickStage.putExtra("EnemyTeam",ClosedTeamstour.get(CloseTeam[6-Seriescnt]).seq);
                        startActivity(ToPickStage);

                    }
                    else
                    {
                        editor.putString(ClosedSeries, "0");
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
                        editor.putString(Day, String.valueOf(Dayint+2));
                        editor.putString(Mode, "0");



                        editor.putString(Series1Win, "0");
                        editor.putString(Series2Win, "0");
                        editor.putString(Series3Win, "0");
                        editor.putString(Series4Win, "0");
                        editor.putString(Series5Win, "0");
                        editor.putString(Series6Win, "0");
                        editor.putString(Series7Win, "0");

                        editor.apply();

                        startActivity(ToMainstate);
                    }
                }













            }
        });


    }
}
