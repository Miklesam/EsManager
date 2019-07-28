package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import static com.miklesam.dota_manager.YourTeam.CloseLose1;
import static com.miklesam.dota_manager.YourTeam.CloseLose2;
import static com.miklesam.dota_manager.YourTeam.CloseLose3;
import static com.miklesam.dota_manager.YourTeam.CloseLose4;
import static com.miklesam.dota_manager.YourTeam.CloseLose5;
import static com.miklesam.dota_manager.YourTeam.CloseLose6;
import static com.miklesam.dota_manager.YourTeam.CloseLose7;
import static com.miklesam.dota_manager.YourTeam.CloseLose8;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff1;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff2;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff3;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff4;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff5;
import static com.miklesam.dota_manager.YourTeam.ClosePlayoff6;
import static com.miklesam.dota_manager.YourTeam.CloseScore1;
import static com.miklesam.dota_manager.YourTeam.CloseScore2;
import static com.miklesam.dota_manager.YourTeam.CloseScore3;
import static com.miklesam.dota_manager.YourTeam.CloseScore4;
import static com.miklesam.dota_manager.YourTeam.CloseScore5;
import static com.miklesam.dota_manager.YourTeam.CloseScore6;
import static com.miklesam.dota_manager.YourTeam.CloseScore7;
import static com.miklesam.dota_manager.YourTeam.CloseScore8;
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
import static com.miklesam.dota_manager.YourTeam.CloseWin8;
import static com.miklesam.dota_manager.YourTeam.ClosedPlayofStage;
import static com.miklesam.dota_manager.YourTeam.Day;
import static com.miklesam.dota_manager.YourTeam.ExtraFarming;
import static com.miklesam.dota_manager.YourTeam.ExtraFighting;
import static com.miklesam.dota_manager.YourTeam.ExtraLaining;
import static com.miklesam.dota_manager.YourTeam.ExtraLate;
import static com.miklesam.dota_manager.YourTeam.Fans;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Language;
import static com.miklesam.dota_manager.YourTeam.MinorQual;
import static com.miklesam.dota_manager.YourTeam.Mode;
import static com.miklesam.dota_manager.YourTeam.Month;
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
import static com.miklesam.dota_manager.YourTeam.Year;

public class mainstate extends AppCompatActivity {


    ImageView Play_game;

    ImageView Market;
    ImageView Teamimprove;
    TextView Goldbalance;


    ArrayList<Teams> TeamsCloseQuals;
    ArrayList<Teams> TeamsOpenQuals;
    ArrayList<Teams> TeamsCW;
    String YourTeam;
    TextView XPShow;
    TextView InfoBlock;
    int XPint;
    boolean cw;
    TextView DayText;
    TextView MonthText;
    TextView YearText;
    int gamemode=0;
    String fansbalansed;

    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;
    int Dayint;
    int QualiWinner;
    int Playercnt=0;
    int openqual[]= new int[7];
    ArrayList<Players> TheAllPlayers;


    TextView LainingPoints;
    TextView FarmingPoints;
    TextView FightingPoints;
    TextView LateGamePoints;

    LinearLayout Laining;

    TextView FansNumber;
    ImageView backtomenu;


    int ExLainingint;
    int ExFarmingint;
    int ExFightingint;
    int ExLateint;

    int OpenShaffleint;
    int CloseShaffleint;
    ImageView Media;

    int Monthint;
    int Yearint;
    Intent ToMainActivity;

    boolean team[]=new boolean[5];
    boolean rosterok;
    SharedPreferences mSettings;
    boolean lock;
    int languageshare;
    int Minorornot;


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



        setContentView(R.layout.activity_mainstate);
       // mSettings = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);

        RelativeLayout view= (RelativeLayout)findViewById(R.id.mainfon);



        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);



        LainingPoints=findViewById(R.id.LainingPoints);
        FarmingPoints=findViewById(R.id.FarmingPoints);
        FightingPoints=findViewById(R.id.FightingPoints);
        LateGamePoints=findViewById(R.id.LateGamePoints);

        MonthText=findViewById(R.id.Month);
        YearText=findViewById(R.id.Year);
        backtomenu=findViewById(R.id.backtomenu);
        Laining=findViewById(R.id.lainingfeature);


        FansNumber=findViewById(R.id.FansNumber);
        Play_game=findViewById(R.id.Play_game);

        Goldbalance=findViewById(R.id.Goldbalance);
        XPShow=findViewById(R.id.XP);
        DayText=findViewById(R.id.Day);
        String Gold="1";
        YourTeam="Your Team";
        Market=findViewById(R.id.Market);
        Teamimprove=findViewById(R.id.Teamimprove);
        final Intent ToOpenQuali = new Intent(this, OpenQuali.class);
        final Intent ToClosedQuali = new Intent(this, ClosedQuali.class);
        final Intent ToMarket = new Intent(this, market.class);
        final Intent ToImprove = new Intent(this, Improve.class);
        ToMainActivity = new Intent(this, MainActivity.class);
        final Intent ToPractice = new Intent(this, practiceactivity.class);
        final Intent ToMinor = new Intent(this, Minor.class);



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
        if(mSettings.contains(Month)) {
            Monthint=Integer.parseInt(mSettings.getString(Month, "0"));
        }
        if(mSettings.contains(Year)) {
            Yearint=Integer.parseInt(mSettings.getString(Year, "0"));
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
        if(mSettings.contains(Language)) {
            languageshare=Integer.parseInt(mSettings.getString(Language, "0"));
        }

        if(mSettings.contains(MinorQual)) {
            Minorornot=Integer.parseInt(mSettings.getString(MinorQual, "0"));
        }

        LainingPoints.setText(String.valueOf(ExLainingint));
        FarmingPoints.setText(String.valueOf(ExFarmingint));
        FightingPoints.setText(String.valueOf(ExFightingint));
        LateGamePoints.setText(String.valueOf(ExLateint));


        XPShow.setText(String.valueOf(XPint));
        final SharedPreferences.Editor editor = mSettings.edit();




        DayText.setText(String.valueOf(Dayint));
        MonthText.setText(String.valueOf(Monthint));
        YearText.setText(String.valueOf(Yearint));


        if(Monthint%2==0) {

            if (Dayint < 10) {
                gamemode = 2;
            } else if (Dayint == 10) {
                //Play_game.setText("Open");
                Play_game.setImageResource(R.drawable.openquali);
                gamemode = 1;
            } else if ((Dayint > 10) && (Dayint < 15)) {
                //Play_game.setText("Practice");
                gamemode = 2;
            } else if (Dayint == 15) {
                if(QualiWinner==1)
                {
                    gamemode = 2;
                }
                else
                {
                    Play_game.setImageResource(R.drawable.openquali);
                    gamemode = 1;
                }



            } else if ((Dayint > 15) && (Dayint < 20)) {
                //Play_game.setText("Practice");
                gamemode = 2;
            } else if (Dayint == 20) {
                if (QualiWinner == 1) {
                    //Play_game.setText("Close");
                    Play_game.setImageResource(R.drawable.closequali);
                    gamemode = 3;
                } else {
                    //Play_game.setText("Practice");
                    gamemode = 2;
                }
            } else if (Dayint > 20) {
                //Play_game.setText("Practice");
                gamemode = 2;
            }
        }
        else
        {
            if (Dayint < 10)
            {
            gamemode = 2;
            }
            else if (Dayint == 10)
            {

                    gamemode=4;



                //bttnMinor
            }
            else
            {
                gamemode = 2;
            }

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


        if (Pos1!=177)
        {
            team[0]=true;
        }
        if (Pos2!=177)
        {
            team[1]=true;
        }
        if (Pos3!=177)
        {
            team[2]=true;
        }
        if (Pos4!=177)
        {
            team[3]=true;
        }
        if (Pos5!=177)
        {
            team[4]=true;
        }

        for(int i=0; i<5;i++)
        {
         if(team[i]==true)
         {
             Playercnt=Playercnt+1;
         }
        }
        if(Playercnt==0)
        {
            view.setBackgroundResource(R.drawable.zero_players);
        }
        else if(Playercnt==1)
        {
            view.setBackgroundResource(R.drawable.one_players);
        }
        else if(Playercnt==2)
        {
            view.setBackgroundResource(R.drawable.two_players);
        }
        else if(Playercnt==3)
        {
            view.setBackgroundResource(R.drawable.three_players);
        }
        else if(Playercnt==4)
        {
            view.setBackgroundResource(R.drawable.four_players);
        }
        else if(Playercnt==5)
        {
            view.setBackgroundResource(R.drawable.five_players);
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

        if(Monthint%2==0)
        {



        if (Dayint<10)
        {
            InfoBlock.setText("First Open Minor Qual after "+ String.valueOf(10-Dayint) );
        }
        else if (Dayint==10)
        {
            InfoBlock.setText("First Open Minor Qual today");
        }
        else if((Dayint>10)&&(Dayint<15))
        {
            if (QualiWinner==1)
            {
                InfoBlock.setText("Closed Minor Qual after "+ String.valueOf(20-Dayint) );
            }
            else
            {
                InfoBlock.setText("Second Open Minor Qual today "+ String.valueOf(15-Dayint) );
            }
        }
        else if(Dayint==15)
        {
            if (QualiWinner==1)
            {
                InfoBlock.setText("Closed Minor Qual after "+ String.valueOf(20-Dayint));
            }
            else
            {
                InfoBlock.setText("Second Open Minor Qual today ");
            }
        }
        else if((Dayint>15)&&(Dayint<20))
        {
            if (QualiWinner==1)
            {
                InfoBlock.setText("Closed Minor Qual after "+ String.valueOf(20-Dayint));
            }
            else
            {
                InfoBlock.setText("Some cup in next month ");
            }

        }
        else if (Dayint==20)
        {

            if (QualiWinner==1)
            {
                InfoBlock.setText("Closed Minor Qual today ");
            }
            else
            {
                InfoBlock.setText("Some cup in next month ");
            }

        }
        else if(Dayint>20)
        {
            if(Minorornot==1)
            {
                InfoBlock.setText("Minor in next month ");
            }
            else{

                InfoBlock.setText("Some cup in next month ");
            }
        }

        }
        else
        {
            if(Dayint<10)
            {
                if(Minorornot==1)
            {
                InfoBlock.setText("Minor after "+ String.valueOf(10-Dayint));
            }
            else{

                    InfoBlock.setText("Some Cup after "+ String.valueOf(10-Dayint));
            }

            }
            else if (Dayint==10)
            {
                if(Minorornot==1)
                {
                    InfoBlock.setText("Minor today ");
                }
                else{
                    InfoBlock.setText("Some Cup today");
                }
            }
            else if(Dayint>10)
            {
                InfoBlock.setText("Open Qaul in next month ");
            }
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
                else if(gamemode==4)
                {
                    editor.putString(Mode,"4");
                    editor.apply();
                    startActivity(ToMinor);
                }


                }
                else
                {
                    if(languageshare==2)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Roster must be complete", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Укомплектуйте состав", Toast.LENGTH_SHORT);
                        toast.show();
                    }

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
