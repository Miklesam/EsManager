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

import static com.miklesam.dota_manager.TeamsInit.DreamLeagueInit;
import static com.miklesam.dota_manager.TeamsInit.DreamLeagueTeams;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.CloseLose1;
import static com.miklesam.dota_manager.YourTeam.CloseLose2;
import static com.miklesam.dota_manager.YourTeam.CloseLose3;
import static com.miklesam.dota_manager.YourTeam.CloseLose4;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff1;

import static com.miklesam.dota_manager.YourTeam.ClosePlayoff2;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff3;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff4;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff5;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff6;

import static com.miklesam.dota_manager.YourTeam.CloseScore1;
import static com.miklesam.dota_manager.YourTeam.CloseScore2;
import static com.miklesam.dota_manager.YourTeam.CloseWin1;
import static com.miklesam.dota_manager.YourTeam.CloseWin2;
import static com.miklesam.dota_manager.YourTeam.CloseWin3;
import static com.miklesam.dota_manager.YourTeam.CloseWin4;
import static com.miklesam.dota_manager.YourTeam.ClosedPlayofStage;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

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

    int Score[]= new int[2];
    int ClosedPlayofStageint;
    int Teamsplayoffs[]= new int[6];

    TextView ScoreWin[]= new TextView[4];
    TextView ScoreLose[]= new TextView[4];




    int CloseWin1int;
    int CloseLose1int;

    int CloseWin2int;
    int CloseLose2int;

    int CloseWin3int;
    int CloseLose3int;

    int CloseWin4int;
    int CloseLose4int;

    ArrayList<ModelTeam> teamstable = new ArrayList<>();


    static ArrayList<Teams> MinorTeams = new ArrayList<Teams>();
    SharedPreferences mSettings;
    String YourTeam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minor);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        final Intent ToMAinState = new Intent(this, mainstate.class);
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);



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

        ScoreLose[0]=findViewById(R.id.ScoreLose1);
        ScoreLose[1]=findViewById(R.id.ScoreLose2);
        ScoreLose[2]=findViewById(R.id.ScoreLose3);
        ScoreLose[3]=findViewById(R.id.ScoreLose4);





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

        DreamLeagueTeams.clear();
        MinorTeams=DreamLeagueInit();

        for (int i=0;i<7;i++)
        {
            Teams[i+1].setText(MinorTeams.get(i).teamname);
            TeamsLogo[i+1].setImageResource(MinorTeams.get(i).logo);
        }

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


        if(mSettings.contains(ClosedPlayofStage)) {
            ClosedPlayofStageint=Integer.parseInt(mSettings.getString(ClosedPlayofStage, "0"));
        }







        if(mSettings.contains(CloseScore1)) {
            Score[0]=Integer.parseInt(mSettings.getString(CloseScore1, "0"));
        }
        if(mSettings.contains(CloseScore2)) {
            Score[1]=Integer.parseInt(mSettings.getString(CloseScore2, "0"));
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






        final SharedPreferences.Editor editor = mSettings.edit();
        if(ClosedPlayofStageint==1)
        {
            if(Score[0]==2)
            {
                editor.putString(ClosedPlayofStage,"3");
                editor.putString(ClosePlayoff2,"10");
                editor.putString(ClosePlayoff4, "1");
                editor.putString(ClosePlayoff1,"3");
                editor.putString(ClosePlayoff3, "2");




            }
            else if(Score[1]==2)
            {
                editor.putString(ClosedPlayofStage,"2");
                editor.putString(ClosePlayoff4,"10");
                editor.putString(ClosePlayoff2,"1");
                editor.putString(ClosePlayoff1,"3");
                editor.putString(ClosePlayoff3, "2");

                editor.putString(CloseWin4, "2");

            }
            editor.apply();

        }

        if(mSettings.contains(ClosedPlayofStage)) {
            ClosedPlayofStageint=Integer.parseInt(mSettings.getString(ClosedPlayofStage, "0"));
        }
        if(ClosedPlayofStageint>1)
        {
            ScoreText[2].setText("1");
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

        if(mSettings.contains(CloseWin1)) {
            CloseWin1int=Integer.parseInt(mSettings.getString(CloseWin1, "CloseWin1"));
        }

        if(mSettings.contains(CloseLose1)) {
            CloseLose1int=Integer.parseInt(mSettings.getString(CloseLose1, "CloseLose1"));
        }
        if(mSettings.contains(CloseWin2)) {
            CloseWin2int=Integer.parseInt(mSettings.getString(CloseWin2, "CloseWin2"));
        }

        if(mSettings.contains(CloseLose2)) {
            CloseLose2int=Integer.parseInt(mSettings.getString(CloseLose2, "CloseLose2"));
        }
        if(mSettings.contains(CloseWin3)) {
            CloseWin3int=Integer.parseInt(mSettings.getString(CloseWin3, "CloseWin3"));
        }

        if(mSettings.contains(CloseLose3)) {
            CloseLose3int=Integer.parseInt(mSettings.getString(CloseLose3, "CloseLose3"));
        }
        if(mSettings.contains(CloseWin4)) {
            CloseWin4int=Integer.parseInt(mSettings.getString(CloseWin4, "CloseWin1"));
        }

        if(mSettings.contains(CloseLose4)) {
            CloseLose4int=Integer.parseInt(mSettings.getString(CloseLose4, "CloseLose1"));
        }

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





        teamstable.clear();
        teamstable.add( new ModelTeam( MinorTeams.get(0).teamname,MinorTeams.get(0).logo,CloseWin1int,CloseLose1int,MinorTeams.get(0).seq));
        teamstable.add( new ModelTeam( MinorTeams.get(1).teamname,MinorTeams.get(1).logo,CloseWin2int,CloseLose2int,MinorTeams.get(1).seq));
        teamstable.add( new ModelTeam( MinorTeams.get(2).teamname,MinorTeams.get(2).logo,CloseWin3int,CloseLose3int,MinorTeams.get(2).seq));
        teamstable.add( new ModelTeam( YourTeam,R.drawable.teamlogo,CloseWin4int,CloseLose4int,77));
        Collections.sort(teamstable, ModelTeam.COMPARE_BY_Winning);

        for (int i=0;i<4;i++)
        {
            Teams[i].setText(teamstable.get(i).TeamName);
            TeamsLogo[i].setImageResource(teamstable.get(i).logo);
            ScoreWin[i].setText(String.valueOf(teamstable.get(i).w));
            ScoreLose[i].setText(String.valueOf(teamstable.get(i).l));
        }



        nextminorbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToPickStage.putExtra("Position1",Pos1);
                ToPickStage.putExtra("Position2",Pos2);
                ToPickStage.putExtra("Position3",Pos3);
                ToPickStage.putExtra("Position4",Pos4);
                ToPickStage.putExtra("Position5",Pos5);
                ToPickStage.putExtra("TeamName",YourTeam);

                ToPickStage.putExtra("TeamEnemy",MinorTeams.get(0).teamname);
                ToPickStage.putExtra("EnemyTeam",MinorTeams.get(0).seq);
                startActivity(ToPickStage);




                //startActivity(ToMAinState);

            }
        });



    }
}
