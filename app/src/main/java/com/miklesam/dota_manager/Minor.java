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
import java.util.Collections;
import java.util.MissingFormatArgumentException;
import java.util.Random;

import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.BucharestInit;
import static com.miklesam.dota_manager.TeamsInit.BucharestTeams;
import static com.miklesam.dota_manager.TeamsInit.DotaPitInit;
import static com.miklesam.dota_manager.TeamsInit.DotaPitTeams;
import static com.miklesam.dota_manager.TeamsInit.DreamLeagueInit;
import static com.miklesam.dota_manager.TeamsInit.DreamLeagueTeams;
import static com.miklesam.dota_manager.TeamsInit.KievS1Init;
import static com.miklesam.dota_manager.TeamsInit.KievS1Teams;
import static com.miklesam.dota_manager.TeamsInit.KievS2Init;
import static com.miklesam.dota_manager.TeamsInit.KievS2Teams;
import static com.miklesam.dota_manager.YourTeam.*;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff10;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff11;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff12;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff7;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff8;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff9;

public class Minor extends AppCompatActivity {


    TextView Teams[]= new TextView[8];
    ImageView TeamsLogo[] = new ImageView[8];
    TextView SeriesTeam[]=new TextView[20];
    ImageView SeriesLogo[] = new ImageView[20];
    ImageView nextminorbttn;

    TextView ScoreText[]= new TextView[20];

    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;

    int Score[]= new int[8];
    int ClosedPlayofStageint;
    int Teamsplayoffs[]= new int[6];

    TextView ScoreWin[]= new TextView[8];
    TextView ScoreLose[]= new TextView[8];




    int CloseWin1int;
    int CloseLose1int;

    int CloseWin2int;
    int CloseLose2int;

    int CloseWin3int;
    int CloseLose3int;

    int CloseWin4int;
    int CloseLose4int;

    int CloseWin5int;
    int CloseLose5int;

    int CloseWin6int;
    int CloseLose6int;

    int CloseWin7int;
    int CloseLose7int;

    int CloseWin8int;
    int CloseLose8int;
    ImageView EventImage;


    ArrayList<ModelTeam> groupa = new ArrayList<>();
    ArrayList<ModelTeam> groupb = new ArrayList<>();

    static ArrayList<Teams> MinorTeams = new ArrayList<Teams>();
    SharedPreferences mSettings;
    String YourTeam;
    boolean five;
    int Dayint;
    int Minorornot;
    int OpenTeamQual[]=new int[7];
    int somecup[]=new int[7];
    TextView minorname;
    int RealDayint;

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
        minorname=findViewById(R.id.minorname);
        EventImage=findViewById(R.id.EventImage);
        Teams[0]=findViewById(R.id.Team1);
        Teams[1]=findViewById(R.id.Team2);
        Teams[2]=findViewById(R.id.Team3);
        Teams[3]=findViewById(R.id.Team4);
        Teams[4]=findViewById(R.id.Team5);
        Teams[5]=findViewById(R.id.Team6);
        Teams[6]=findViewById(R.id.Team7);
        Teams[7]=findViewById(R.id.Team8);
        nextminorbttn=findViewById(R.id.nextminorbttn);

        TeamsLogo[0]=findViewById(R.id.Teamlogo1);
        TeamsLogo[1]=findViewById(R.id.Teamlogo2);
        TeamsLogo[2]=findViewById(R.id.Teamlogo3);
        TeamsLogo[3]=findViewById(R.id.Teamlogo4);
        TeamsLogo[4]=findViewById(R.id.Teamlogo5);
        TeamsLogo[5]=findViewById(R.id.Teamlogo6);
        TeamsLogo[6]=findViewById(R.id.Teamlogo7);
        TeamsLogo[7]=findViewById(R.id.Teamlogo8);


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




        ScoreWin[0]=findViewById(R.id.ScoreWin1);
        ScoreWin[1]=findViewById(R.id.ScoreWin2);
        ScoreWin[2]=findViewById(R.id.ScoreWin3);
        ScoreWin[3]=findViewById(R.id.ScoreWin4);
        ScoreWin[4]=findViewById(R.id.ScoreWin5);
        ScoreWin[5]=findViewById(R.id.ScoreWin6);
        ScoreWin[6]=findViewById(R.id.ScoreWin7);
        ScoreWin[7]=findViewById(R.id.ScoreWin8);

        ScoreLose[0]=findViewById(R.id.ScoreLose1);
        ScoreLose[1]=findViewById(R.id.ScoreLose2);
        ScoreLose[2]=findViewById(R.id.ScoreLose3);
        ScoreLose[3]=findViewById(R.id.ScoreLose4);
        ScoreLose[4]=findViewById(R.id.ScoreLose5);
        ScoreLose[5]=findViewById(R.id.ScoreLose6);
        ScoreLose[6]=findViewById(R.id.ScoreLose7);
        ScoreLose[7]=findViewById(R.id.ScoreLose8);

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
    }
    protected void ReadFlash()
    {
        if (mSettings.contains(OpenTeam1)) {
            OpenTeamQual[0] = Integer.parseInt(mSettings.getString(OpenTeam1, "77"));
        }
        if (mSettings.contains(OpenTeam2)) {
            OpenTeamQual[1] = Integer.parseInt(mSettings.getString(OpenTeam2, "77"));
        }

        if (mSettings.contains(OpenTeam3)) {
            OpenTeamQual[2] = Integer.parseInt(mSettings.getString(OpenTeam3, "77"));
        }

        if (mSettings.contains(OpenTeam4)) {
            OpenTeamQual[3] = Integer.parseInt(mSettings.getString(OpenTeam4, "77"));
        }

        if (mSettings.contains(OpenTeam5)) {
            OpenTeamQual[4] = Integer.parseInt(mSettings.getString(OpenTeam5, "77"));
        }

        if (mSettings.contains(OpenTeam6)) {
            OpenTeamQual[5] = Integer.parseInt(mSettings.getString(OpenTeam6, "77"));
        }

        if (mSettings.contains(OpenTeam7)) {
            OpenTeamQual[6] = Integer.parseInt(mSettings.getString(OpenTeam7, "77"));
        }


        if(mSettings.contains(Day)) {
            RealDayint=Integer.parseInt(mSettings.getString(Day, "Day"));
        }


        if(mSettings.contains(MinorQual)) {
            Minorornot=Integer.parseInt(mSettings.getString(MinorQual, "0"));
        }

        if (mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam = mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

        }
        if(mSettings.contains(Month)) {
            Dayint=Integer.parseInt(mSettings.getString(Month, "Month"));
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


        if(mSettings.contains(MinorStage)) {
            ClosedPlayofStageint=Integer.parseInt(mSettings.getString(MinorStage, "0"));
        }

        if(mSettings.contains(MinorScore1)) {
            Score[0]=Integer.parseInt(mSettings.getString(MinorScore1, "0"));
        }
        if(mSettings.contains(MinorScore2)) {
            Score[1]=Integer.parseInt(mSettings.getString(MinorScore2, "0"));
        }
        if(mSettings.contains(MinorScore3)) {
            Score[2]=Integer.parseInt(mSettings.getString(MinorScore3, "0"));
        }
        if(mSettings.contains(MinorScore4)) {
            Score[3]=Integer.parseInt(mSettings.getString(MinorScore4, "0"));
        }
        if(mSettings.contains(MinorScore5)) {
            Score[4]=Integer.parseInt(mSettings.getString(MinorScore5, "0"));
        }
        if(mSettings.contains(MinorScore6)) {
            Score[5]=Integer.parseInt(mSettings.getString(MinorScore6, "0"));
        }
        if(mSettings.contains(MinorScore7)) {
            Score[6]=Integer.parseInt(mSettings.getString(MinorScore7, "0"));
        }
        if(mSettings.contains(MinorScore8)) {
            Score[7]=Integer.parseInt(mSettings.getString(MinorScore8, "0"));
        }
        if(mSettings.contains(MinorWin1)) {
            CloseWin1int=Integer.parseInt(mSettings.getString(MinorWin1, "CloseWin1"));
        }

        if(mSettings.contains(MinorLose1)) {
            CloseLose1int=Integer.parseInt(mSettings.getString(MinorLose1, "CloseLose1"));
        }
        if(mSettings.contains(MinorWin2)) {
            CloseWin2int=Integer.parseInt(mSettings.getString(MinorWin2, "CloseWin2"));
        }

        if(mSettings.contains(MinorLose2)) {
            CloseLose2int=Integer.parseInt(mSettings.getString(MinorLose2, "CloseLose2"));
        }
        if(mSettings.contains(MinorWin3)) {
            CloseWin3int=Integer.parseInt(mSettings.getString(MinorWin3, "CloseWin3"));
        }

        if(mSettings.contains(MinorLose3)) {
            CloseLose3int=Integer.parseInt(mSettings.getString(MinorLose3, "CloseLose3"));
        }
        if(mSettings.contains(MinorWin4)) {
            CloseWin4int=Integer.parseInt(mSettings.getString(MinorWin4, "CloseWin1"));
        }

        if(mSettings.contains(MinorLose4)) {
            CloseLose4int=Integer.parseInt(mSettings.getString(MinorLose4, "CloseLose1"));
        }
        if(mSettings.contains(MinorWin5)) {
            CloseWin5int=Integer.parseInt(mSettings.getString(MinorWin5, "CloseWin1"));
        }

        if(mSettings.contains(MinorLose5)) {
            CloseLose5int=Integer.parseInt(mSettings.getString(MinorLose5, "CloseLose1"));
        }
        if(mSettings.contains(MinorWin6)) {
            CloseWin6int=Integer.parseInt(mSettings.getString(MinorWin6, "CloseWin1"));
        }

        if(mSettings.contains(MinorLose6)) {
            CloseLose6int=Integer.parseInt(mSettings.getString(MinorLose6, "CloseLose1"));
        }
        if(mSettings.contains(MinorWin7)) {
            CloseWin7int=Integer.parseInt(mSettings.getString(MinorWin7, "CloseWin1"));
        }

        if(mSettings.contains(MinorLose7)) {
            CloseLose7int=Integer.parseInt(mSettings.getString(MinorLose7, "CloseLose1"));
        }
        if(mSettings.contains(MinorWin8)) {
            CloseWin8int=Integer.parseInt(mSettings.getString(MinorWin8, "CloseWin1"));
        }

        if(mSettings.contains(MinorLose8)) {
            CloseLose8int=Integer.parseInt(mSettings.getString(MinorLose8, "CloseLose1"));
        }


        if(mSettings.contains(MinorPlayoff1)) {
            Teamsplayoffs[0]=Integer.parseInt(mSettings.getString(MinorPlayoff1, "0"));
        }
        if(mSettings.contains(MinorPlayoff2)) {
            Teamsplayoffs[1]=Integer.parseInt(mSettings.getString(MinorPlayoff2, "0"));
        }
        if(mSettings.contains(MinorPlayoff3)) {
            Teamsplayoffs[2]=Integer.parseInt(mSettings.getString(MinorPlayoff3, "0"));
        }
        if(mSettings.contains(MinorPlayoff4)) {
            Teamsplayoffs[3]=Integer.parseInt(mSettings.getString(MinorPlayoff4, "0"));
        }
        if(mSettings.contains(MinorPlayoff5)) {
            Teamsplayoffs[4]=Integer.parseInt(mSettings.getString(MinorPlayoff5, "0"));
        }
        if(mSettings.contains(MinorPlayoff6)) {
            Teamsplayoffs[5]=Integer.parseInt(mSettings.getString(MinorPlayoff6, "0"));
        }





    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minor);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = mSettings.edit();
        final Intent ToMAinState = new Intent(this, mainstate.class);
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        final Intent ToClosedPlayoff = new Intent(this, ClosedPlayoff.class);

        InitView();


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

        ReadFlash();







        if(Minorornot==1)
        {
        if(Dayint==1)
        {
            EventImage.setImageResource(R.drawable.dreams10);
            minorname.setText("DreamLeague Minor");
            DreamLeagueTeams.clear();
            MinorTeams=DreamLeagueInit();
        }
        else if(Dayint==3)
        {
            EventImage.setImageResource(R.drawable.bucharest_minor);
            minorname.setText("The Bucharest Minor");
            BucharestTeams.clear();
            MinorTeams=BucharestInit();
        }
        else if(Dayint==5)
        {
            EventImage.setImageResource(R.drawable.kievs1);
            minorname.setText("StarLadder Minor Season 1");
            minorname.setTextSize(20);
            KievS1Teams.clear();
            MinorTeams=KievS1Init();
        }
        else if(Dayint==7)
        {
            EventImage.setImageResource(R.drawable.dotapit);
            minorname.setText("OGA Dota PIT Minor");

            DotaPitTeams.clear();
            MinorTeams=DotaPitInit();
        }
        else if(Dayint==9)
        {
            EventImage.setImageResource(R.drawable.kievs1);
            minorname.setText("StarLadder Minor Season 2");
            minorname.setTextSize(20);
            KievS2Teams.clear();
            MinorTeams=KievS2Init();
        }
        else
        {
            MinorTeams.clear();
            EventImage.setImageResource(R.drawable.battlecup);
            DreamLeagueTeams.clear();
            MinorTeams=DreamLeagueInit();
        }

        }
        else
        {
            minorname.setText("Some Cup");
            EventImage.setImageResource(R.drawable.battlecup);

            MinorTeams.clear();
            if(OpenTeamQual[0]==77)
            {
                Random randomteam = new Random();
                int whatteam=0;

                for (int i=0;i<7;i++)
                {
                    whatteam=randomteam.nextInt(AllTeams.size());
                    somecup[i]=AllTeams.get(whatteam).seq;
                    MinorTeams.add(AllTeams.get(whatteam));
                    AllTeams.remove(whatteam);
                }

                editor.putString(MinorQual, "0");
                editor.putString(OpenTeam1, String.valueOf(somecup[0]));
                editor.putString(OpenTeam2, String.valueOf(somecup[1]));
                editor.putString(OpenTeam3, String.valueOf(somecup[2]));
                editor.putString(OpenTeam4, String.valueOf(somecup[3]));
                editor.putString(OpenTeam5, String.valueOf(somecup[4]));
                editor.putString(OpenTeam6, String.valueOf(somecup[5]));
                editor.putString(OpenTeam7, String.valueOf(somecup[6]));
                editor.apply();

            }
            else
            {
                editor.putString(MinorQual, "0");
                editor.apply();
                MinorTeams.clear();

                for (int i=0;i<7;i++)
                {

                    MinorTeams.add(AllTeams.get(OpenTeamQual[i]));


                }
            }


        }




        for (int i=0;i<7;i++)
        {
            Teams[i+1].setText(MinorTeams.get(i).teamname);
            TeamsLogo[i+1].setImageResource(MinorTeams.get(i).logo);
        }



        Teams[0].setText(YourTeam);
        TeamsLogo[0].setImageResource(R.drawable.teamlogo);
        SeriesTeam[0].setText(MinorTeams.get(0).teamname);

        SeriesTeam[2].setText(MinorTeams.get(1).teamname);
        SeriesLogo[2].setImageResource(MinorTeams.get(1).logo);
        SeriesTeam[3].setText(MinorTeams.get(2).teamname);
        SeriesLogo[3].setImageResource(MinorTeams.get(2).logo);

        SeriesTeam[10].setText(MinorTeams.get(3).teamname);
        SeriesLogo[10].setImageResource(MinorTeams.get(3).logo);
        SeriesTeam[11].setText(MinorTeams.get(4).teamname);
        SeriesLogo[11].setImageResource(MinorTeams.get(4).logo);
        SeriesTeam[12].setText(MinorTeams.get(5).teamname);
        SeriesLogo[12].setImageResource(MinorTeams.get(5).logo);
        SeriesTeam[13].setText(MinorTeams.get(6).teamname);
        SeriesLogo[13].setImageResource(MinorTeams.get(6).logo);


        SeriesLogo[0].setImageResource(MinorTeams.get(0).logo);
        SeriesTeam[1].setText(YourTeam);
        SeriesLogo[1].setImageResource(R.drawable.teamlogo);
        ScoreText[0].setText(String.valueOf(Score[0]));
        ScoreText[1].setText(String.valueOf(Score[1]));


       // ScoreText[1].setText(String.valueOf(ClosedPlayofStageint));







        if(ClosedPlayofStageint==1)
        {

            if(Score[0]==2)
            {
                editor.putString(MinorStage,"2");
                editor.putString(MinorPlayoff2,"10");
                editor.putString(MinorPlayoff4, "1");
                editor.putString(MinorPlayoff1,"2");
                editor.putString(MinorPlayoff3, "3");


                editor.putString(MinorWin4, String.valueOf(Score[1]));
                editor.putString(MinorLose4, String.valueOf(Score[0]));

                editor.putString(MinorWin1,String.valueOf(Score[0]));
                editor.putString(MinorLose1, String.valueOf(Score[1]));

                editor.putString(MinorWin2,"0");
                editor.putString(MinorLose2,"2");

                editor.putString(MinorWin3,"2");
                editor.putString(MinorLose3,"0");

                editor.putString(MinorWin5,String.valueOf(CloseWin5int+2));
                editor.putString(MinorLose5,String.valueOf(CloseLose5int+0));
                editor.putString(MinorWin6,String.valueOf(CloseWin6int+0));
                editor.putString(MinorLose6,String.valueOf(CloseLose6int+2));
                editor.putString(MinorWin7,String.valueOf(CloseWin7int+1));
                editor.putString(MinorLose7,String.valueOf(CloseLose7int+2));
                editor.putString(MinorWin8,String.valueOf(CloseWin8int+2));
                editor.putString(MinorLose8,String.valueOf(CloseLose8int+1));


            }
            else if(Score[1]==2)
            {
                editor.putString(MinorStage,"3");
                editor.putString(MinorPlayoff4,"10");
                editor.putString(MinorPlayoff2,"1");
                editor.putString(MinorPlayoff1,"2");
                editor.putString(MinorPlayoff3, "3");

                editor.putString(MinorWin4, String.valueOf(Score[1]));
                editor.putString(MinorLose4, String.valueOf(Score[0]));

                editor.putString(MinorWin1,String.valueOf(Score[0]));
                editor.putString(MinorLose1, String.valueOf(Score[1]));

                editor.putString(MinorWin2,"0");
                editor.putString(MinorLose2,"2");

                editor.putString(MinorWin3,"2");
                editor.putString(MinorLose3,"0");

                editor.putString(MinorWin5,String.valueOf(CloseWin5int+2));
                editor.putString(MinorLose5,String.valueOf(CloseLose5int+0));
                editor.putString(MinorWin6,String.valueOf(CloseWin6int+0));
                editor.putString(MinorLose6,String.valueOf(CloseLose6int+2));
                editor.putString(MinorWin7,String.valueOf(CloseWin7int+1));
                editor.putString(MinorLose7,String.valueOf(CloseLose7int+2));
                editor.putString(MinorWin8,String.valueOf(CloseWin8int+2));
                editor.putString(MinorLose8,String.valueOf(CloseLose8int+1));

            }

            editor.putString(CloseTeam1, "0");
            editor.putString(CloseTeam2, "0");
            editor.putString(CloseTeam3, "0");
            editor.putString(CloseTeam4, "0");
            editor.putString(CloseTeam5, "0");
            editor.putString(CloseTeam6, "0");
            editor.putString(CloseTeam7, "0");


            editor.putString(Series1Win, "0");
            editor.putString(Series2Win, "0");
            editor.putString(Series3Win, "0");
            editor.putString(Series4Win, "0");
            editor.putString(Series5Win, "0");
            editor.putString(Series6Win, "0");
            editor.putString(Series7Win, "0");


            editor.putString(CloseWin7, "0");
            editor.putString(CloseWin6, "0");
            editor.putString(CloseWin5, "0");
            editor.putString(CloseWin4, "0");
            editor.putString(CloseWin3, "0");
            editor.putString(CloseWin2, "0");
            editor.putString(CloseWin1, "0");

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

            editor.putString(ClosedPlayofStage, "1");

            editor.putString(CloseLose7, "0");
            editor.putString(CloseLose6, "0");
            editor.putString(CloseLose5, "0");
            editor.putString(CloseLose4, "0");
            editor.putString(CloseLose3, "0");
            editor.putString(CloseLose2, "0");
            editor.putString(CloseLose1, "0");






            editor.apply();

        }

       else if(ClosedPlayofStageint==2)
        {
            if(Score[2]==2)
            {
                GroupWinnerLoser();
                editor.putString(MinorStage,"7");
                nextminorbttn.setImageResource(R.drawable.leave_bttn);


            }
            else if(Score[3]==2)
            {
                GroupWinnerLoser();
                editor.putString(MinorStage,"4");
                editor.putString(MinorPlayoff6,"10");
            }
            editor.apply();
        }

        else if(ClosedPlayofStageint==3)
        {
            if(Score[4]==2)
            {

                GroupWinnerLoser();
                editor.putString(MinorStage,"4");
                editor.putString(MinorPlayoff6,"10");

            }
            else if(Score[5]==2)
            {
                GroupWinnerLoser();
                editor.putString(MinorStage,"5");
                editor.putString(MinorPlayoff6,"3");

            }
            editor.apply();
        }
        else if(ClosedPlayofStageint==4)
        {
            if(Score[6]==2)
            {

                GroupWinnerLoser();
                editor.putString(MinorStage,"7");
                nextminorbttn.setImageResource(R.drawable.leave_bttn);


            }
            else if(Score[7]==2)
            {
                GroupWinnerLoser();
                editor.putString(MinorStage,"6");


            }
            editor.apply();
        }


        if(mSettings.contains(MinorStage)) {
            ClosedPlayofStageint=Integer.parseInt(mSettings.getString(MinorStage, "0"));
        }
        if(ClosedPlayofStageint>1)
        {
            ScoreText[2].setText("0");
            ScoreText[3].setText("2");

            ScoreText[10].setText("2");
            ScoreText[11].setText("0");
            SeriesTeam[16].setText(MinorTeams.get(3).teamname);
            SeriesLogo[16].setImageResource(MinorTeams.get(3).logo);
            SeriesTeam[14].setText(MinorTeams.get(4).teamname);
            SeriesLogo[14].setImageResource(MinorTeams.get(4).logo);


            ScoreText[12].setText("1");
            ScoreText[13].setText("2");

            SeriesTeam[15].setText(MinorTeams.get(5).teamname);
            SeriesLogo[15].setImageResource(MinorTeams.get(5).logo);
            SeriesTeam[17].setText(MinorTeams.get(6).teamname);
            SeriesLogo[17].setImageResource(MinorTeams.get(6).logo);
        }

        if(ClosedPlayofStageint>3)
        {
            ScoreText[14].setText("0");
            ScoreText[15].setText("2");

            ScoreText[16].setText("2");
            ScoreText[17].setText("1");

            SeriesTeam[18].setText(MinorTeams.get(5).teamname);
            SeriesLogo[18].setImageResource(MinorTeams.get(5).logo);
            SeriesTeam[19].setText(MinorTeams.get(6).teamname);
            SeriesLogo[19].setImageResource(MinorTeams.get(6).logo);
        }
        if(ClosedPlayofStageint>5)
        {
            ScoreText[18].setText("2");
            ScoreText[19].setText("0");

        }


        ReadFlash();


        ScoreText[4].setText(String.valueOf(Score[2]));
        ScoreText[5].setText(String.valueOf(Score[3]));
        ScoreText[6].setText(String.valueOf(Score[4]));
        ScoreText[7].setText(String.valueOf(Score[5]));
        ScoreText[8].setText(String.valueOf(Score[6]));
        ScoreText[9].setText(String.valueOf(Score[7]));

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
                    SeriesTeamA[i].setText(MinorTeams.get(Teamsplayoffs[i]-1).teamname);
                    SeriesLogoA[i].setImageResource(MinorTeams.get(Teamsplayoffs[i]-1).logo);
                }

            }

        }



        ShuffleGroup();





        nextminorbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ToPickStage.putExtra("TeamName",YourTeam);

                if(ClosedPlayofStageint==1)
                {
                    ToPickStage.putExtra("TeamEnemy",MinorTeams.get(0).teamname);
                    ToPickStage.putExtra("EnemyTeam",MinorTeams.get(0).seq);
                    startActivity(ToPickStage);
                }
                else if (ClosedPlayofStageint==2)
                {
                    ToPickStage.putExtra("TeamEnemy",MinorTeams.get(1).teamname);
                    ToPickStage.putExtra("EnemyTeam",MinorTeams.get(1).seq);
                    startActivity(ToPickStage);
                }
                else if (ClosedPlayofStageint==3)
                {
                    ToPickStage.putExtra("TeamEnemy",MinorTeams.get(2).teamname);
                    ToPickStage.putExtra("EnemyTeam",MinorTeams.get(2).seq);
                    startActivity(ToPickStage);
                }
                else if (ClosedPlayofStageint==4)
                {

                    if(Teamsplayoffs[1]==10)
                    {
                        ToPickStage.putExtra("TeamEnemy",MinorTeams.get(2).teamname);
                        ToPickStage.putExtra("EnemyTeam",MinorTeams.get(2).seq);
                    }
                    else
                    {
                        ToPickStage.putExtra("TeamEnemy",MinorTeams.get(0).teamname);
                        ToPickStage.putExtra("EnemyTeam",MinorTeams.get(0).seq);
                    }
                    startActivity(ToPickStage);
                }
                else if (ClosedPlayofStageint==5)
                {
                    if(five==false) {
                        ScoreText[8].setText("2");
                        ScoreText[9].setText("0");

                        ScoreText[18].setText("2");
                        ScoreText[19].setText("0");
                        editor.putString(MinorWin1, String.valueOf(CloseWin1int + 2));
                        editor.putString(MinorLose1, String.valueOf(CloseLose1int + 0));

                        editor.putString(MinorWin3, String.valueOf(CloseWin3int + 0));
                        editor.putString(MinorLose3, String.valueOf(CloseLose3int + 2));

                        editor.putString(MinorWin7, String.valueOf(CloseWin7int + 2));
                        editor.putString(MinorLose7, String.valueOf(CloseLose7int + 0));

                        editor.putString(MinorWin8, String.valueOf(CloseWin8int + 0));
                        editor.putString(MinorLose8, String.valueOf(CloseLose8int + 2));
                        editor.apply();
                        ReadFlash();
                        ShuffleGroup();
                        editor.putString(MinorStage, "6");
                        editor.apply();
                    }
                    if(five==true)
                    {
                        editor.putString(TeamPlayoff2, String.valueOf(MinorTeams.get(5).seq));
                        editor.putString(TeamPlayoff3, String.valueOf(MinorTeams.get(3).seq));
                        editor.putString(TeamPlayoff4, String.valueOf(MinorTeams.get(0).seq));
                        editor.putString(NotMinor,"1");
                        editor.putString(ClosedPlayofStage, "1");
                        editor.apply();



                        startActivity(ToClosedPlayoff);
                        five=false;
                    }



                    five=true;

                }
                else if(ClosedPlayofStageint==6)
                {
                    editor.putString(TeamPlayoff2, String.valueOf(MinorTeams.get(5).seq));
                    editor.putString(TeamPlayoff3, String.valueOf(MinorTeams.get(3).seq));
                    editor.putString(TeamPlayoff4, String.valueOf(MinorTeams.get(0).seq));
                    editor.putString(NotMinor,"1");
                    editor.putString(ClosedPlayofStage, "1");
                    editor.apply();



                    startActivity(ToClosedPlayoff);
                    five=false;
                }

                else if(ClosedPlayofStageint==7) {

                    editor.putString(Day,String.valueOf(RealDayint+20));
                    editor.putString(OpenTeam1, "77");
                    editor.putString(OpenTeam2, "77");
                    editor.putString(OpenTeam3, "77");
                    editor.putString(OpenTeam4, "77");
                    editor.putString(OpenTeam5, "77");
                    editor.putString(OpenTeam6, "77");
                    editor.putString(OpenTeam7, "77");
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
                    editor.putString(ClosedPlayofStage, "1");
                    editor.putString(MinorStage, "1");

                    editor.apply();

                    startActivity(ToMAinState);
                }
                else
                {
                    editor.putString(Day,String.valueOf(RealDayint));
                    editor.putString(OpenTeam1, "77");
                    editor.putString(OpenTeam2, "77");
                    editor.putString(OpenTeam3, "77");
                    editor.putString(OpenTeam4, "77");
                    editor.putString(OpenTeam5, "77");
                    editor.putString(OpenTeam6, "77");
                    editor.putString(OpenTeam7, "77");
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
                    editor.putString(ClosedPlayofStage, "1");
                    editor.putString(MinorStage, "1");
                    editor.apply();

                    startActivity(ToMAinState);
                }






                //startActivity(ToMAinState);

            }
        });



    }

    protected void GroupWinnerLoser()
    {
        SharedPreferences.Editor editor = mSettings.edit();
        if(ClosedPlayofStageint==2)
        {
            editor.putString(MinorScore5,"0");
            editor.putString(MinorScore6,"2");

            editor.putString(MinorPlayoff5,"3");


            editor.putString(MinorWin2,String.valueOf(CloseWin2int+Score[2]));
            editor.putString(MinorLose2,String.valueOf(CloseLose2int+Score[3]));

            editor.putString(MinorWin4,String.valueOf(CloseWin4int+Score[3]));
            editor.putString(MinorLose4,String.valueOf(CloseLose4int+Score[2]));

            editor.putString(MinorWin1,String.valueOf(CloseWin1int+2));
            editor.putString(MinorLose1,String.valueOf(CloseLose1int+0));

            editor.putString(MinorWin3,String.valueOf(CloseWin3int+0));
            editor.putString(MinorLose3,String.valueOf(CloseLose3int+2));


            editor.putString(MinorWin6,String.valueOf(CloseWin6int+0));
            editor.putString(MinorLose6,String.valueOf(CloseLose6int+2));
            editor.putString(MinorWin7,String.valueOf(CloseWin7int+2));
            editor.putString(MinorLose7,String.valueOf(CloseLose7int+0));

            editor.putString(MinorWin5,String.valueOf(CloseWin5int+2));
            editor.putString(MinorLose5,String.valueOf(CloseLose5int+1));
            editor.putString(MinorWin8,String.valueOf(CloseWin8int+1));
            editor.putString(MinorLose8,String.valueOf(CloseLose8int+2));


            editor.apply();





        }
        else if(ClosedPlayofStageint==3)
        {
            editor.putString(MinorScore3,"0");
            editor.putString(MinorScore4,"2");
            editor.putString(MinorPlayoff5,"1");

            editor.putString(MinorWin3,String.valueOf(CloseWin3int+Score[4]));
            editor.putString(MinorLose3,String.valueOf(CloseLose3int+Score[5]));

            editor.putString(MinorWin4,String.valueOf(CloseWin4int+Score[5]));
            editor.putString(MinorLose4,String.valueOf(CloseLose4int+Score[4]));

            editor.putString(MinorWin1,String.valueOf(CloseWin1int+2));
            editor.putString(MinorLose1,String.valueOf(CloseLose1int+0));

            editor.putString(MinorWin2,String.valueOf(CloseWin2int+0));
            editor.putString(MinorLose2,String.valueOf(CloseLose2int+2));


            editor.putString(MinorWin6,String.valueOf(CloseWin6int+0));
            editor.putString(MinorLose6,String.valueOf(CloseLose6int+2));
            editor.putString(MinorWin7,String.valueOf(CloseWin7int+2));
            editor.putString(MinorLose7,String.valueOf(CloseLose7int+0));

            editor.putString(MinorWin5,String.valueOf(CloseWin5int+2));
            editor.putString(MinorLose5,String.valueOf(CloseLose5int+1));
            editor.putString(MinorWin8,String.valueOf(CloseWin8int+1));
            editor.putString(MinorLose8,String.valueOf(CloseLose8int+2));


            editor.apply();
        }
        else if(ClosedPlayofStageint==4)
        {
            if(Teamsplayoffs[1]==10)
            {
                editor.putString(MinorWin3,String.valueOf(CloseWin3int+Score[6]));
                editor.putString(MinorLose3,String.valueOf(CloseLose3int+Score[7]));
            }
            else
            {
                editor.putString(MinorWin1,String.valueOf(CloseWin3int+Score[6]));
                editor.putString(MinorLose1,String.valueOf(CloseLose3int+Score[7]));
            }



            editor.putString(MinorWin4,String.valueOf(CloseWin4int+Score[7]));
            editor.putString(MinorLose4,String.valueOf(CloseLose4int+Score[6]));

            editor.putString(MinorWin7, String.valueOf(CloseWin7int + 2));
            editor.putString(MinorLose7, String.valueOf(CloseLose7int + 0));

            editor.putString(MinorWin8, String.valueOf(CloseWin8int + 0));
            editor.putString(MinorLose8, String.valueOf(CloseLose8int + 2));

            editor.apply();
        }
    }


    protected void ShuffleGroup()
    {
        groupa.clear();
        groupa.add( new ModelTeam( MinorTeams.get(0).teamname,MinorTeams.get(0).logo,CloseWin1int,CloseLose1int,MinorTeams.get(0).seq));
        groupa.add( new ModelTeam( MinorTeams.get(1).teamname,MinorTeams.get(1).logo,CloseWin2int,CloseLose2int,MinorTeams.get(1).seq));
        groupa.add( new ModelTeam( MinorTeams.get(2).teamname,MinorTeams.get(2).logo,CloseWin3int,CloseLose3int,MinorTeams.get(2).seq));
        groupa.add( new ModelTeam( YourTeam,R.drawable.teamlogo,CloseWin4int,CloseLose4int,77));
        Collections.sort(groupa, ModelTeam.COMPARE_BY_Winning);

        for (int i=0;i<4;i++)
        {
            Teams[i].setText(groupa.get(i).TeamName);
            TeamsLogo[i].setImageResource(groupa.get(i).logo);
            ScoreWin[i].setText(String.valueOf(groupa.get(i).w));
            ScoreLose[i].setText(String.valueOf(groupa.get(i).l));
        }
        groupb.clear();
        groupb.add( new ModelTeam( MinorTeams.get(3).teamname,MinorTeams.get(3).logo,CloseWin5int,CloseLose5int,MinorTeams.get(3).seq));
        groupb.add( new ModelTeam( MinorTeams.get(4).teamname,MinorTeams.get(4).logo,CloseWin6int,CloseLose6int,MinorTeams.get(4).seq));
        groupb.add( new ModelTeam( MinorTeams.get(5).teamname,MinorTeams.get(5).logo,CloseWin7int,CloseLose7int,MinorTeams.get(5).seq));
        groupb.add( new ModelTeam( MinorTeams.get(6).teamname,MinorTeams.get(6).logo,CloseWin8int,CloseLose8int,MinorTeams.get(6).seq));
        Collections.sort(groupb, ModelTeam.COMPARE_BY_Winning);
        for (int i=0;i<4;i++)
        {
            Teams[4+i].setText(groupb.get(i).TeamName);
            TeamsLogo[4+i].setImageResource(groupb.get(i).logo);
            ScoreWin[4+i].setText(String.valueOf(groupb.get(i).w));
            ScoreLose[4+i].setText(String.valueOf(groupb.get(i).l));
        }
    }



}
