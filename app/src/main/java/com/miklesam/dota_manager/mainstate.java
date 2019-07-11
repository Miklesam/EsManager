package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static com.miklesam.dota_manager.PlayersInit.AllPlayers;
import static com.miklesam.dota_manager.PlayersInit.PlayersAllInit;
import static com.miklesam.dota_manager.TeamsInit.AllTeams;

import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.TeamsInit.CloseTeamsInit;
import static com.miklesam.dota_manager.TeamsInit.ClosedTeams;
import static com.miklesam.dota_manager.TeamsInit.OpenTeams;
import static com.miklesam.dota_manager.TeamsInit.OpenTeamsInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.CloseShaffle;
import static com.miklesam.dota_manager.YourTeam.CloseTeam1;
import static com.miklesam.dota_manager.YourTeam.CloseTeam2;
import static com.miklesam.dota_manager.YourTeam.CloseTeam3;
import static com.miklesam.dota_manager.YourTeam.CloseTeam4;
import static com.miklesam.dota_manager.YourTeam.CloseTeam5;
import static com.miklesam.dota_manager.YourTeam.CloseTeam6;
import static com.miklesam.dota_manager.YourTeam.CloseTeam7;
import static com.miklesam.dota_manager.YourTeam.Day;
import static com.miklesam.dota_manager.YourTeam.ExtraFarming;
import static com.miklesam.dota_manager.YourTeam.ExtraFighting;
import static com.miklesam.dota_manager.YourTeam.ExtraLaining;
import static com.miklesam.dota_manager.YourTeam.ExtraLate;
import static com.miklesam.dota_manager.YourTeam.Fans;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.OpenQualiWinner;
import static com.miklesam.dota_manager.YourTeam.OpenShaffle;
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
import static com.miklesam.dota_manager.YourTeam.XPstatic;

public class mainstate extends AppCompatActivity {


    ImageView Play_game;

    ImageView Market;
    ImageView Teamimprove;
    TextView Goldbalance;
    TextView TeamName;
    ListView CWList;
    ArrayList<Teams> TeamsCloseQuals;
    ArrayList<Teams> TeamsOpenQuals;
    ArrayList<Teams> TeamsCW;
    String YourTeam;
    TextView XPShow;
    TextView InfoBlock;
    int XPint;
    boolean cw;
    TextView DayText;
    int gamemode=0;
    String fansbalansed;

    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;
    int Dayint;
    int QualiWinner;
    int openqual[]= new int[7];
    ArrayList<Players> TheAllPlayers;


    TextView LainingPoints;
    TextView FarmingPoints;
    TextView FightingPoints;
    TextView LateGamePoints;

    LinearLayout Laining;
    LinearLayout Farming;
    LinearLayout Fighting;
    LinearLayout LateGame;
    TextView FansNumber;
    ImageView backtomenu;


    int ExLainingint;
    int ExFarmingint;
    int ExFightingint;
    int ExLateint;

    int OpenShaffleint;
    int CloseShaffleint;
    ImageView Media;


    boolean team[]=new boolean[5];
    boolean rosterok;
    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainstate);
       // mSettings = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);



        LainingPoints=findViewById(R.id.LainingPoints);
        FarmingPoints=findViewById(R.id.FarmingPoints);
        FightingPoints=findViewById(R.id.FightingPoints);
        LateGamePoints=findViewById(R.id.LateGamePoints);


        backtomenu=findViewById(R.id.backtomenu);
        Laining=findViewById(R.id.lainingfeature);


        FansNumber=findViewById(R.id.FansNumber);
        Play_game=findViewById(R.id.Play_game);
        TeamName=findViewById(R.id.team_name);
        Goldbalance=findViewById(R.id.Goldbalance);
        XPShow=findViewById(R.id.XP);
        DayText=findViewById(R.id.Day);
        String Gold="1";
        YourTeam="Your Team";
        Market=findViewById(R.id.Market);
        Teamimprove=findViewById(R.id.Teamimprove);
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        final Intent ToOpenQuali = new Intent(this, OpenQuali.class);
        final Intent ToClosedQuali = new Intent(this, ClosedQuali.class);
        final Intent ToMarket = new Intent(this, market.class);
        final Intent ToImprove = new Intent(this, Improve.class);
        final Intent ToMainActivity = new Intent(this, MainActivity.class);
        final Intent ToPractice = new Intent(this, practiceactivity.class);



        AllTeams.clear();
        OpenTeams.clear();
        ClosedTeams.clear();
        TeamsCloseQuals=CloseTeamsInit();
        TeamsCW=AllTeamsInit();
        TeamsOpenQuals=OpenTeamsInit();
        InfoBlock=findViewById(R.id.InfoBlock);



        final int won;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                won= 0;
            } else {
                won= extras.getInt("win");
            }
        } else {
            won= (int) savedInstanceState.getSerializable("win");
        }


        if(mSettings.contains(XPstatic)) {
            XPint=Integer.parseInt(mSettings.getString(XPstatic, "0"));
        }


        if(mSettings.contains(Day)) {
            Dayint=Integer.parseInt(mSettings.getString(Day, "0"));
        }

        if(mSettings.contains(OpenQualiWinner)) {

            QualiWinner =Integer.parseInt(mSettings.getString(OpenQualiWinner, "OpenQualiWinner"));

        }


        if(mSettings.contains(ExtraLaining)) {
            ExLainingint=Integer.parseInt(mSettings.getString(ExtraLaining, "0"));
        }
        if(mSettings.contains(ExtraFarming)) {
            ExFarmingint=Integer.parseInt(mSettings.getString(ExtraFarming, "0"));
        }
        if(mSettings.contains(ExtraFighting)) {
            ExFightingint=Integer.parseInt(mSettings.getString(ExtraFighting, "0"));
        }
        if(mSettings.contains(ExtraLate)) {
            ExLateint=Integer.parseInt(mSettings.getString(ExtraLate, "0"));
        }

        if(mSettings.contains(OpenShaffle)) {
            OpenShaffleint=Integer.parseInt(mSettings.getString(OpenShaffle, "0"));
        }
        if(mSettings.contains(CloseShaffle)) {
            CloseShaffleint=Integer.parseInt(mSettings.getString(CloseShaffle, "0"));
        }




        LainingPoints.setText(String.valueOf(ExLainingint));
        FarmingPoints.setText(String.valueOf(ExFarmingint));
        FightingPoints.setText(String.valueOf(ExFightingint));
        LateGamePoints.setText(String.valueOf(ExLateint));


        XPShow.setText(String.valueOf(XPint));
        SharedPreferences.Editor editor = mSettings.edit();




        DayText.setText(String.valueOf(Dayint));



        if (Dayint<10)
        {
            //Play_game.setText("Practice");
            gamemode=2;
        }
        else if (Dayint==10)
        {
            //Play_game.setText("Open");
            gamemode=1;
        }
        else if((Dayint>10)&&(Dayint<15))
        {
            //Play_game.setText("Practice");
            gamemode=2;
        }
        else if(Dayint==15)
        {
            if (QualiWinner==1)
            {
                //Play_game.setText("Close");
                gamemode=3;
            }
            else
            {
                //Play_game.setText("Practice");
                gamemode=2;
            }
        }
        else if((Dayint>15)&&(Dayint<20))
        {
            //Play_game.setText("Practice");
            gamemode=2;
        }
        else if (Dayint==20)
        {
           // Play_game.setText("Open");
            gamemode=1;
        }
        else if((Dayint>20)&&(Dayint<25))
        {
            //Play_game.setText("Practice");
            gamemode=2;
        }
        else if(Dayint==25)
        {
            if (QualiWinner==1)
            {
                //Play_game.setText("Close");
                gamemode=3;
            }
            else
            {
                //Play_game.setText("Practice");
                gamemode=2;
            }
        }
        else if((Dayint>25))
        {
           // Play_game.setText("Practice");
            gamemode=2;
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


        if (Pos1!=77)
        {
            team[0]=true;
        }
        if (Pos2!=77)
        {
            team[1]=true;
        }
        if (Pos3!=77)
        {
            team[2]=true;
        }
        if (Pos4!=77)
        {
            team[3]=true;
        }
        if (Pos5!=77)
        {
            team[4]=true;
        }

        rosterok=team[0]&&team[1]&&team[2]&team[3]&&team[4];
        if(mSettings.contains(GoldBalance)) {

            Gold =mSettings.getString(GoldBalance, "50000");

        }

        if(mSettings.contains(Fans)) {

            fansbalansed =mSettings.getString(Fans, "0");

        }
        FansNumber.setText(fansbalansed);
        if(mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam =mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

        }


        AllPlayers.clear();
        TheAllPlayers=PlayersAllInit();





        Goldbalance.setText(Gold);
        TeamName.setText("Команда "+YourTeam);

        if(QualiWinner==1)
        {
            if(Dayint==4)
            {
                InfoBlock.setText("CloseQuali сегодня");
            }
            else
            {
                InfoBlock.setText("CloseQuali через "+ String.valueOf(4-Dayint) );
            }
        }
        else
        {
            if(Dayint==2)
            {
                InfoBlock.setText("OpenQuali сегодня");
            }
            else
            {
                InfoBlock.setText("OpenQuali через "+ String.valueOf(2-Dayint) );
            }

        }

        if (Dayint<10)
        {
            InfoBlock.setText("Open Major Qual через "+ String.valueOf(10-Dayint) );
        }
        else if (Dayint==10)
        {
            InfoBlock.setText("Open Major Qual сегодня");
        }
        else if((Dayint>10)&&(Dayint<15))
        {
            if (QualiWinner==1)
            {
                InfoBlock.setText("Closed Major Qual через "+ String.valueOf(15-Dayint) );
            }
            else
            {
                InfoBlock.setText("Open Minor Qual через "+ String.valueOf(20-Dayint) );
            }
        }
        else if(Dayint==15)
        {
            if (QualiWinner==1)
            {
                InfoBlock.setText("Closed Major Qual сегодня");
            }
            else
            {
                InfoBlock.setText("Open Minor Qual через "+ String.valueOf(20-Dayint) );
            }
        }
        else if((Dayint>15)&&(Dayint<20))
        {
            //if not win major quals
            InfoBlock.setText("Open Minor Qual через "+ String.valueOf(20-Dayint) );
        }
        else if (Dayint==20)
        {
         InfoBlock.setText("Open Minor Qual сегодня");
        }
        else if((Dayint>20)&&(Dayint<25))
        {
            if (QualiWinner==1)
            {
                InfoBlock.setText("Closed Minor Qual через "+ String.valueOf(25-Dayint) );
            }
            else
            {
                InfoBlock.setText("Open Major Qual через "+ String.valueOf(35-Dayint) );
            }
        }
        else if(Dayint==25)
        {
            if (QualiWinner==1)
            {
                InfoBlock.setText("Closed Minor Qual сегодня");
            }
            else
            {
                InfoBlock.setText("Open Major Qual через "+ String.valueOf(35-Dayint) );
            }
        }
        else if((Dayint>25))
        {
            InfoBlock.setText("Open Major Qual через "+ String.valueOf(35-Dayint) );
        }











        Play_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         // YourTeamIntent.putExtra("Name",TeamTag);
                if(rosterok==true)
                {



                if(gamemode==2)
                {
                    startActivity(ToPractice);

                } else if (gamemode==1)
                {


                    if(OpenShaffleint==0)
                    {
                        Random randomteam = new Random();
                        int whatteam=0;

                        for (int i=0;i<7;i++)
                        {
                            whatteam=randomteam.nextInt(TeamsOpenQuals.size());
                            openqual[i]=TeamsOpenQuals.get(whatteam).seq;
                            TeamsOpenQuals.remove(whatteam);

                        }

                        SharedPreferences.Editor editor = mSettings.edit();
                        editor.putString(OpenTeam1,String.valueOf(openqual[0]));
                        editor.putString(OpenTeam2,String.valueOf(openqual[1]));
                        editor.putString(OpenTeam3,String.valueOf(openqual[2]));
                        editor.putString(OpenTeam4,String.valueOf(openqual[3]));
                        editor.putString(OpenTeam5,String.valueOf(openqual[4]));
                        editor.putString(OpenTeam6,String.valueOf(openqual[5]));
                        editor.putString(OpenTeam7,String.valueOf(openqual[6]));
                        editor.putString(OpenShaffle,"1");
                        editor.apply();
                    }

                    startActivity(ToOpenQuali);
                }
                else if (gamemode==3)
                {
                    if(CloseShaffleint==0)
                    {
                        Random randomteam = new Random();
                        int whatteam=0;

                        for (int i=0;i<7;i++)
                        {
                            whatteam=randomteam.nextInt(TeamsCloseQuals.size());
                            openqual[i]=TeamsCloseQuals.get(whatteam).seq;
                            TeamsCloseQuals.remove(whatteam);

                        }
                        Arrays.sort(openqual);

                        SharedPreferences.Editor editor = mSettings.edit();
                        editor.putString(CloseTeam1,String.valueOf(openqual[0]));
                        editor.putString(CloseTeam2,String.valueOf(openqual[1]));
                        editor.putString(CloseTeam3,String.valueOf(openqual[2]));
                        editor.putString(CloseTeam4,String.valueOf(openqual[3]));
                        editor.putString(CloseTeam5,String.valueOf(openqual[4]));
                        editor.putString(CloseTeam6,String.valueOf(openqual[5]));
                        editor.putString(CloseTeam7,String.valueOf(openqual[6]));
                        editor.putString(CloseShaffle,"1");
                        editor.apply();

                    }


                    startActivity(ToClosedQuali);
                }


                }
                else
                {

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Укомплектуйте состав", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });










        Market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(ToMarket);



            }
        });

        backtomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToMainActivity);



            }
        });





        Teamimprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToImprove);
            }
        });

        Laining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToImprove);
            }
        });










    }






}
