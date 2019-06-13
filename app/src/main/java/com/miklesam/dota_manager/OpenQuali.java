package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Mode;
import static com.miklesam.dota_manager.YourTeam.OpenTeam1;
import static com.miklesam.dota_manager.YourTeam.OpenTeam2;
import static com.miklesam.dota_manager.YourTeam.OpenTeam3;
import static com.miklesam.dota_manager.YourTeam.OpenTeam4;
import static com.miklesam.dota_manager.YourTeam.OpenTeam5;
import static com.miklesam.dota_manager.YourTeam.OpenTeam6;
import static com.miklesam.dota_manager.YourTeam.OpenTeam7;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

public class OpenQuali extends AppCompatActivity {

    ImageView QuatersFinals[]=new ImageView[14];
    TextView QuatersFinalsText[]=new TextView[14];

    ArrayList<Teams> OpenTeams= new ArrayList<Teams>();
    ArrayList<Teams> AllOpenTeams= new ArrayList<Teams>();
    private static final String TAG = "MyApp";
    String YourTeam;
    SharedPreferences mSettings;
    Button openplaybtn;
    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;

    int OpenTeamQual[]=new int[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_quali);

        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        openplaybtn=findViewById(R.id.openplay);
        QuatersFinals[0]=findViewById(R.id.Team1);
        QuatersFinals[1]=findViewById(R.id.Team2);
        QuatersFinals[2]=findViewById(R.id.Team3);
        QuatersFinals[3]=findViewById(R.id.Team4);
        QuatersFinals[4]=findViewById(R.id.Team5);
        QuatersFinals[5]=findViewById(R.id.Team6);
        QuatersFinals[6]=findViewById(R.id.Team7);
        QuatersFinals[7]=findViewById(R.id.Team8);
        QuatersFinals[8]=findViewById(R.id.Team9);
        QuatersFinals[9]=findViewById(R.id.Team10);
        QuatersFinals[10]=findViewById(R.id.Team11);
        QuatersFinals[11]=findViewById(R.id.Team12);
        QuatersFinals[12]=findViewById(R.id.Team13);
        QuatersFinals[13]=findViewById(R.id.Team14);



        QuatersFinalsText[0]=findViewById(R.id.Teamname1);
        QuatersFinalsText[1]=findViewById(R.id.Teamname2);
        QuatersFinalsText[2]=findViewById(R.id.Teamname3);
        QuatersFinalsText[3]=findViewById(R.id.Teamname4);
        QuatersFinalsText[4]=findViewById(R.id.Teamname5);
        QuatersFinalsText[5]=findViewById(R.id.Teamname6);
        QuatersFinalsText[6]=findViewById(R.id.Teamname7);
        QuatersFinalsText[7]=findViewById(R.id.Teamname8);
        QuatersFinalsText[8]=findViewById(R.id.Teamname9);
        QuatersFinalsText[9]=findViewById(R.id.Teamname10);
        QuatersFinalsText[10]=findViewById(R.id.Teamname11);
        QuatersFinalsText[11]=findViewById(R.id.Teamname12);
        QuatersFinalsText[12]=findViewById(R.id.Teamname13);
        QuatersFinalsText[13]=findViewById(R.id.Teamname14);




        AllTeams.clear();
        AllOpenTeams=AllTeamsInit();

        if(mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam =mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

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

        if(mSettings.contains(OpenTeam1)) {
            OpenTeamQual[0]=Integer.parseInt(mSettings.getString(OpenTeam1, "open1"));
        }

        if(mSettings.contains(OpenTeam2)) {
            OpenTeamQual[1]=Integer.parseInt(mSettings.getString(OpenTeam2, "open2"));
        }

        if(mSettings.contains(OpenTeam3)) {
            OpenTeamQual[2]=Integer.parseInt(mSettings.getString(OpenTeam3, "open3"));
        }

        if(mSettings.contains(OpenTeam4)) {
            OpenTeamQual[3]=Integer.parseInt(mSettings.getString(OpenTeam4, "open4"));
        }

        if(mSettings.contains(OpenTeam5)) {
            OpenTeamQual[4]=Integer.parseInt(mSettings.getString(OpenTeam5, "open5"));
        }

        if(mSettings.contains(OpenTeam6)) {
            OpenTeamQual[5]=Integer.parseInt(mSettings.getString(OpenTeam6, "open6"));
        }

        if(mSettings.contains(OpenTeam7)) {
            OpenTeamQual[6]=Integer.parseInt(mSettings.getString(OpenTeam7, "open7"));
        }





        QuatersFinalsText[0].setText(YourTeam);
        QuatersFinals[0].setImageResource(R.drawable.teamlogo);

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(Mode, "1");
        editor.apply();




        for(int i=0;i<7;i++)
        {
            QuatersFinals[i+1].setImageResource(AllOpenTeams.get(OpenTeamQual[i]).logo);
            QuatersFinalsText[i+1].setText(AllOpenTeams.get(OpenTeamQual[i]).teamname);
        }







        openplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToPickStage.putExtra("Position1",Pos1);
                ToPickStage.putExtra("Position2",Pos2);
                ToPickStage.putExtra("Position3",Pos3);
                ToPickStage.putExtra("Position4",Pos4);
                ToPickStage.putExtra("Position5",Pos5);

                ToPickStage.putExtra("EnemyTeam",AllOpenTeams.get(OpenTeamQual[0]).seq);
                ToPickStage.putExtra("TeamName",YourTeam);
                ToPickStage.putExtra("TeamEnemy",AllOpenTeams.get(OpenTeamQual[0]).teamname);

                startActivity(ToPickStage);

            }
        });










    }
}
