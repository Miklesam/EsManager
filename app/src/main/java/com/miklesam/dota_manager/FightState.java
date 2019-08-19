package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import static com.miklesam.dota_manager.HeroInit.AllHeroes;
import static com.miklesam.dota_manager.PlayersInit.AllPlayers;
import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.YourTeam.*;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

public class FightState extends AppCompatActivity {

    TextView daytimetext;
    TextView Toplane;
    TextView Midlane;
    TextView Bottomlane;
    int Hero[]=new int[5];
    int Lane[]=new int[5];
    int Gamer[]=new int[5];
    int CompLane[]=new int[5];
    int CompHero[]=new int[5];
    int CompGamer[]=new int[5];
    int MinorStageint;
    CountDownTimer Mytimer;
    CountDownTimer State2;
    CountDownTimer State3;
    CountDownTimer State4;
    int stage=0;
    int Major_stage;

    TextView stagenumber;

    ImageView  choose[]=new ImageView[3];

    ArrayList<NetworthUnit> nettable = new ArrayList<>();

    ImageView TopIcon[] =new ImageView[5];
    ImageView MidIcon[] =new ImageView[5];
    ImageView BottomIcon[] =new ImageView[5];

    ImageView EnemyTopIcon[] =new ImageView[5];
    ImageView EnemyMidIcon[] =new ImageView[5];
    ImageView EnemyBottomIcon[] =new ImageView[5];
    TextView TopScoreTitle;
    TextView MidScoreTitle;
    TextView BottomScoreTitle;

    ImageView[] Networthicon= new ImageView[10];
    TextView[] NetworthText= new TextView[10];


    static ArrayList<Heroes> HeroesSpot = new ArrayList<Heroes>();
    Player_unit[] Radiant_Unit= new Player_unit[5];
    Player_unit[] Dire_Unit= new Player_unit[5];


    int RadiantNetworh[]=new int[5];
    int DireNetworh[]=new int[5];
    TextView radiantnetw;

    TextView LoseOrWin;
    ImageView tomainstance;
    int winloose;
    SharedPreferences mSettings;
    int TournMode;
    int openquater;
    int opensemi;
    int day;
    int Seriescnt;
    int Closedwinint;
    int Closedloseint;

    int CloseWin7int;
    int CloseLose7int;
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
    int XPint;
    int ExLainingint;
    int ExFarmingint;
    int ExFightingint;
    int ExLateint;



    int ClosedPlayofStageint;
    int Score[] = new int[12];
    int MinorScore[] = new int [8];
    int MajorScore[]=new int[8];

    int stage4top;
    int stage6top;
    int ScorePlay[]= new int[20];
    int goldbalance;
    int fancebalance;

    int  Monthint;
    int Yearint;
    ImageView monst;
    int MajorPLayofStage;

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
        setContentView(R.layout.activity_fight_state);
        AllTeams.clear();
        tomainstance=findViewById(R.id.tomainstance);

        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        LoseOrWin=findViewById(R.id.LoseOrWin);
        Toplane=findViewById(R.id.topline);
        Midlane=findViewById(R.id.midline);
        Bottomlane=findViewById(R.id.bottomline);
        TopIcon[0]=findViewById(R.id.top5st);
        TopIcon[1]=findViewById(R.id.top4st);
        TopIcon[2]=findViewById(R.id.top3st);
        TopIcon[3]=findViewById(R.id.top2st);
        TopIcon[4]=findViewById(R.id.top1st);
        stagenumber=findViewById(R.id.stagenumber);
        choose[0]=findViewById(R.id.choose1);
        choose[1]=findViewById(R.id.choose2);
        choose[2]=findViewById(R.id.choose3);

        EnemyTopIcon[0]=findViewById(R.id.top6st);
        EnemyTopIcon[1]=findViewById(R.id.top7st);
        EnemyTopIcon[2]=findViewById(R.id.top8st);
        EnemyTopIcon[3]=findViewById(R.id.top9st);
        EnemyTopIcon[4]=findViewById(R.id.top10st);

        MidIcon[0]=findViewById(R.id.mid5st);
        MidIcon[1]=findViewById(R.id.mid4st);
        MidIcon[2]=findViewById(R.id.mid3st);
        MidIcon[3]=findViewById(R.id.mid2st);
        MidIcon[4]=findViewById(R.id.mid1st);

        EnemyMidIcon[0]=findViewById(R.id.mid6st);
        EnemyMidIcon[1]=findViewById(R.id.mid7st);
        EnemyMidIcon[2]=findViewById(R.id.mid8st);
        EnemyMidIcon[3]=findViewById(R.id.mid9st);
        EnemyMidIcon[4]=findViewById(R.id.mid10st);


        BottomIcon[0]=findViewById(R.id.bottom5st);
        BottomIcon[1]=findViewById(R.id.bottom4st);
        BottomIcon[2]=findViewById(R.id.bottom3st);
        BottomIcon[3]=findViewById(R.id.bottom2st);
        BottomIcon[4]=findViewById(R.id.bottom1st);

        EnemyBottomIcon[0]=findViewById(R.id.bottom6st);
        EnemyBottomIcon[1]=findViewById(R.id.bottom7st);
        EnemyBottomIcon[2]=findViewById(R.id.bottom8st);
        EnemyBottomIcon[3]=findViewById(R.id.bottom9st);
        EnemyBottomIcon[4]=findViewById(R.id.bottom10st);

        TopScoreTitle=findViewById(R.id.TopScore);
        MidScoreTitle=findViewById(R.id.MidScore);
        BottomScoreTitle=findViewById(R.id.BottomScore);

        Networthicon[0]=findViewById(R.id.networthicon1);
        Networthicon[1]=findViewById(R.id.networthicon2);
        Networthicon[2]=findViewById(R.id.networthicon3);
        Networthicon[3]=findViewById(R.id.networthicon4);
        Networthicon[4]=findViewById(R.id.networthicon5);
        Networthicon[5]=findViewById(R.id.networthicon6);
        Networthicon[6]=findViewById(R.id.networthicon7);
        Networthicon[7]=findViewById(R.id.networthicon8);
        Networthicon[8]=findViewById(R.id.networthicon9);
        Networthicon[9]=findViewById(R.id.networthicon10);


        NetworthText[0]=findViewById(R.id.networthtext1);
        NetworthText[1]=findViewById(R.id.networthtext2);
        NetworthText[2]=findViewById(R.id.networthtext3);
        NetworthText[3]=findViewById(R.id.networthtext4);
        NetworthText[4]=findViewById(R.id.networthtext5);
        NetworthText[5]=findViewById(R.id.networthtext6);
        NetworthText[6]=findViewById(R.id.networthtext7);
        NetworthText[7]=findViewById(R.id.networthtext8);
        NetworthText[8]=findViewById(R.id.networthtext9);
        NetworthText[9]=findViewById(R.id.networthtext10);

        daytimetext=findViewById(R.id.daytimetext);

        radiantnetw=findViewById(R.id.radiantnet);
        radiantnetw.setVisibility(View.INVISIBLE);


        monst=findViewById(R.id.monst);



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


        if(mSettings.contains(MajorPlayoffStage)) {
            MajorPLayofStage=Integer.parseInt(mSettings.getString(MajorPlayoffStage, "MajorPlayoffStage"));
        }


        if(mSettings.contains(XPstatic)) {
            XPint=Integer.parseInt(mSettings.getString(XPstatic, "0"));
        }


        if(mSettings.contains(GoldBalance)) {
            goldbalance=Integer.parseInt(mSettings.getString(GoldBalance, "0"));
        }
        if(mSettings.contains(Fans)) {
            fancebalance=Integer.parseInt(mSettings.getString(Fans, "0"));
        }





        if(mSettings.contains(Mode)) {
            TournMode=Integer.parseInt(mSettings.getString(Mode, "0"));
        }

        if(mSettings.contains(OpenQuaterFinals)) {
            openquater=Integer.parseInt(mSettings.getString(OpenQuaterFinals, "0"));
        }

        if(mSettings.contains(OpenSemiFinals)) {
            opensemi=Integer.parseInt(mSettings.getString(OpenSemiFinals, "0"));
        }
        if (mSettings.contains(Day)) {
            day = Integer.parseInt(mSettings.getString(Day, "Day"));
        }

        if(mSettings.contains(Month)) {
            Monthint=Integer.parseInt(mSettings.getString(Month, "0"));
        }
        if(mSettings.contains(Year)) {
            Yearint=Integer.parseInt(mSettings.getString(Year, "0"));
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


        if(mSettings.contains(ClosedPlayofStage)) {
            ClosedPlayofStageint=Integer.parseInt(mSettings.getString(ClosedPlayofStage, "0"));
        }

        if(mSettings.contains(MinorStage)) {
            MinorStageint=Integer.parseInt(mSettings.getString(MinorStage, "0"));
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


        if(mSettings.contains(ClosePlayoff9)) {
           stage4top=Integer.parseInt(mSettings.getString(ClosePlayoff9, "0"));
        }
        if(mSettings.contains(ClosePlayoff11)) {
            stage6top=Integer.parseInt(mSettings.getString(ClosePlayoff11, "0"));
        }

        if(mSettings.contains(MinorScore1)) {
            MinorScore[0]=Integer.parseInt(mSettings.getString(MinorScore1, "0"));
        }
        if(mSettings.contains(MinorScore2)) {
            MinorScore[1]=Integer.parseInt(mSettings.getString(MinorScore2, "0"));
        }
        if(mSettings.contains(MinorScore3)) {
            MinorScore[2]=Integer.parseInt(mSettings.getString(MinorScore3, "0"));
        }
        if(mSettings.contains(MinorScore4)) {
            MinorScore[3]=Integer.parseInt(mSettings.getString(MinorScore4, "0"));
        }
        if(mSettings.contains(MinorScore5)) {
            MinorScore[4]=Integer.parseInt(mSettings.getString(MinorScore5, "0"));
        }
        if(mSettings.contains(MinorScore6)) {
            MinorScore[5]=Integer.parseInt(mSettings.getString(MinorScore6, "0"));
        }
        if(mSettings.contains(MinorScore7)) {
            MinorScore[6]=Integer.parseInt(mSettings.getString(MinorScore7, "0"));
        }
        if(mSettings.contains(MinorScore8)) {
            MinorScore[7]=Integer.parseInt(mSettings.getString(MinorScore8, "0"));
        }

        if(mSettings.contains(MajorScore1)) {
            MajorScore[0]=Integer.parseInt(mSettings.getString(MajorScore1, "0"));
        }
        if(mSettings.contains(MajorScore2)) {
            MajorScore[1]=Integer.parseInt(mSettings.getString(MajorScore2, "0"));
        }
        if(mSettings.contains(MajorScore3)) {
            MajorScore[2]=Integer.parseInt(mSettings.getString(MajorScore3, "0"));
        }
        if(mSettings.contains(MajorScore4)) {
            MajorScore[3]=Integer.parseInt(mSettings.getString(MajorScore4, "0"));
        }
        if(mSettings.contains(MajorScore5)) {
            MajorScore[4]=Integer.parseInt(mSettings.getString(MajorScore5, "0"));
        }
        if(mSettings.contains(MajorScore6)) {
            MajorScore[5]=Integer.parseInt(mSettings.getString(MajorScore6, "0"));
        }
        if(mSettings.contains(MajorScore7)) {
            MajorScore[6]=Integer.parseInt(mSettings.getString(MajorScore7, "0"));
        }
        if(mSettings.contains(MajorScore8)) {
            MajorScore[7]=Integer.parseInt(mSettings.getString(MajorScore8, "0"));
        }

        if(mSettings.contains(MajorStage)) {
            Major_stage=Integer.parseInt(mSettings.getString(MajorStage, "1"));
        }

        if(mSettings.contains(StaticPosition1)) {
            Gamer[0]=Integer.parseInt(mSettings.getString(StaticPosition1, "Position1"));
        }

        if(mSettings.contains(StaticPosition2)) {
            Gamer[1]=Integer.parseInt(mSettings.getString(StaticPosition2, "Position2"));
        }

        if(mSettings.contains(StaticPosition3)) {
            Gamer[2]=Integer.parseInt(mSettings.getString(StaticPosition3, "Position3"));
        }

        if(mSettings.contains(StaticPosition4)) {
            Gamer[3]=Integer.parseInt(mSettings.getString(StaticPosition4, "Position4"));
        }

        if(mSettings.contains(StaticPosition5)) {
            Gamer[4]=Integer.parseInt(mSettings.getString(StaticPosition5, "Position5"));
        }




        final Intent Tomainstance = new Intent(this, mainstate.class);
        final Intent Tobackopen = new Intent(this, OpenQuali.class);
        final Intent Tobackclose = new Intent(this, ClosedQuali.class);
        final Intent Tobackplayoff = new Intent(this, ClosedPlayoff.class);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Hero[0] = 0;
                Hero[1] = 0;
                Hero[2] = 0;
                Hero[3] = 0;
                Hero[4] = 0;
                Lane[0] = 0;
                Lane[1] = 0;
                Lane[2] = 0;
                Lane[3] = 0;
                Lane[4] = 0;



                CompLane[0] = 0;
                CompLane[1] = 0;
                CompLane[2] = 0;
                CompLane[3] = 0;
                CompLane[4] = 0;



                CompHero[0] = 0;
                CompHero[1] = 0;
                CompHero[2] = 0;
                CompHero[3] = 0;
                CompHero[4] = 0;


                CompGamer[0] = 0;
                CompGamer[1] = 0;
                CompGamer[2] = 0;
                CompGamer[3] = 0;
                CompGamer[4] = 0;






            } else {
                Hero[0] = extras.getInt("Hero1");
                Hero[1] = extras.getInt("Hero2");
                Hero[2] = extras.getInt("Hero3");
                Hero[3] = extras.getInt("Hero4");
                Hero[4] = extras.getInt("Hero5");

                Lane[0] = extras.getInt("Lane1");
                Lane[1] = extras.getInt("Lane2");
                Lane[2] = extras.getInt("Lane3");
                Lane[3] = extras.getInt("Lane4");
                Lane[4] = extras.getInt("Lane5");





                CompHero[0] = extras.getInt("CompHero1");
                CompHero[1] = extras.getInt("CompHero2");
                CompHero[2] = extras.getInt("CompHero3");
                CompHero[3] = extras.getInt("CompHero4");
                CompHero[4] = extras.getInt("CompHero5");

                CompLane[0] = extras.getInt("CompLane1");
                CompLane[1] = extras.getInt("CompLane2");
                CompLane[2] = extras.getInt("CompLane3");
                CompLane[3] = extras.getInt("CompLane4");
                CompLane[4] = extras.getInt("CompLane5");



                CompGamer[0] = extras.getInt("CompGamer1");
                CompGamer[1] = extras.getInt("CompGamer2");
                CompGamer[2] = extras.getInt("CompGamer3");
                CompGamer[3] = extras.getInt("CompGamer4");
                CompGamer[4] = extras.getInt("CompGamer5");





            }
        } else {
            Hero[0] = (int) savedInstanceState.getSerializable("Hero1");
            Hero[1] = (int) savedInstanceState.getSerializable("Hero2");
            Hero[2] = (int) savedInstanceState.getSerializable("Hero3");
            Hero[3] = (int) savedInstanceState.getSerializable("Hero4");
            Hero[4] = (int) savedInstanceState.getSerializable("Hero5");

            Lane[0] = (int) savedInstanceState.getSerializable("Lane1");
            Lane[1] = (int) savedInstanceState.getSerializable("Lane2");
            Lane[2] = (int) savedInstanceState.getSerializable("Lane3");
            Lane[3] = (int) savedInstanceState.getSerializable("Lane4");
            Lane[4] = (int) savedInstanceState.getSerializable("Lane5");


            CompHero[0] = (int) savedInstanceState.getSerializable("CompHero1");
            CompHero[1] = (int) savedInstanceState.getSerializable("CompHero2");
            CompHero[2] = (int) savedInstanceState.getSerializable("CompHero3");
            CompHero[3] = (int) savedInstanceState.getSerializable("CompHero4");
            CompHero[4] = (int) savedInstanceState.getSerializable("CompHero5");

            CompLane[0] = (int) savedInstanceState.getSerializable("CompLane1");
            CompLane[1] = (int) savedInstanceState.getSerializable("CompLane2");
            CompLane[2] = (int) savedInstanceState.getSerializable("CompLane3");
            CompLane[3] = (int) savedInstanceState.getSerializable("CompLane4");
            CompLane[4] = (int) savedInstanceState.getSerializable("CompLane5");

            CompGamer[0] = (int) savedInstanceState.getSerializable("CompGamer1");
            CompGamer[1] = (int) savedInstanceState.getSerializable("CompGamer2");
            CompGamer[2] = (int) savedInstanceState.getSerializable("CompGamer3");
            CompGamer[3] = (int) savedInstanceState.getSerializable("CompGamer4");
            CompGamer[4] = (int) savedInstanceState.getSerializable("CompGamer5");





        }

        HeroesSpot=HeroInit.HeroInit();
        //Toplane.setText(String.valueOf(Hero[0])+","+String.valueOf(Lane[0]));


        tomainstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = mSettings.edit();
                if (TournMode==1)
                {
                    HeroesSpot.clear();
                    AllHeroes.clear();

                    if (opensemi==1)//OpenQuaterFinal
                    {

                        if (winloose==1)
                        {
                            editor.putString(FinalsWin, "1");
                        }
                        else if (winloose==2)
                        {
                            editor.putString(FinalsWin, "2");
                        }
                        editor.putString(OpenFinals, "1");

                        editor.putString(XPstatic, String.valueOf(XPint+3));
                    }

                    else if (openquater==1)//OpenSemiFinal
                    {
                        if (winloose==1)
                        {
                            editor.putString(SemiWin, "1");
                        }

                        else if (winloose==2)
                        {
                            editor.putString(SemiWin, "2");
                        }
                        editor.putString(OpenSemiFinals, "1");

                        editor.putString(XPstatic, String.valueOf(XPint+2));
                    }
                    else//OpenQuaterFinal
                    {
                        if (winloose==1)
                        {
                            editor.putString(QuaterWin, "1");
                        }
                        else if (winloose==2)
                        {
                            editor.putString(QuaterWin, "2");
                        }

                        editor.putString(OpenQuaterFinals, "1");

                        editor.putString(XPstatic, String.valueOf(XPint+1));

                    }

                    editor.apply();
                    startActivity(Tobackopen);
                }

                else if(TournMode==2)
                {

                    if (Seriescnt==0)
                    {
                        if (winloose==1)
                        {
                            editor.putString(Closedwin, String.valueOf(Closedwinint+1));
                            CloseLose7int=CloseLose7int+1;
                        }
                        else if(winloose==2)
                        {
                            editor.putString(Closedlose, String.valueOf(Closedloseint+1));
                            CloseWin7int=CloseWin7int+1;
                        }

                        //1-2
                        CloseWin1int=CloseWin1int+1;
                        CloseLose2int=CloseLose2int+1;
                        //3-4
                        CloseWin3int=CloseWin3int+1;
                        CloseLose4int=CloseLose4int+1;
                        //5-6
                        CloseWin5int=CloseWin5int+1;
                        CloseLose6int=CloseLose6int+1;
                        editor.putString(Series1Win, String.valueOf(winloose));





                    }
                    else if (Seriescnt==1)
                    {
                        if (winloose==1)
                        {
                           editor.putString(Closedwin, String.valueOf(Closedwinint+1));
                            CloseLose6int=CloseLose6int+1;

                        }
                        else if(winloose==2)
                        {
                            editor.putString(Closedlose, String.valueOf(Closedloseint+1));
                            CloseWin6int=CloseWin6int+1;
                        }

                        //1-3
                        CloseWin1int=CloseWin1int+1;
                        CloseLose3int=CloseLose3int+1;
                        //2-4
                        CloseWin2int=CloseWin2int+1;
                        CloseLose4int=CloseLose4int+1;
                        //5-7
                        CloseWin5int=CloseWin5int+1;
                        CloseLose7int=CloseLose7int+1;
                        editor.putString(Series2Win, String.valueOf(winloose));



                    }
                    else if (Seriescnt==2)
                    {
                        if (winloose==1)
                        {
                            editor.putString(Closedwin, String.valueOf(Closedwinint+1));
                            CloseLose5int=CloseLose5int+1;

                        }
                        else if(winloose==2)
                        {
                            editor.putString(Closedlose, String.valueOf(Closedloseint+1));
                            CloseWin5int=CloseWin5int+1;
                        }



                        //1-4
                        CloseWin1int=CloseWin1int+1;
                        CloseLose4int=CloseLose4int+1;
                        //2-3
                        CloseWin2int=CloseWin2int+1;
                        CloseLose3int=CloseLose3int+1;
                        //6-7
                        CloseWin6int=CloseWin6int+1;
                        CloseLose7int=CloseLose7int+1;
                        editor.putString(Series3Win, String.valueOf(winloose));



                    }

                    else if (Seriescnt==3)
                    {
                        if (winloose==1)
                        {
                            editor.putString(Closedwin, String.valueOf(Closedwinint+1));
                            CloseLose4int=CloseLose4int+1;

                        }
                        else if(winloose==2)
                        {
                            editor.putString(Closedlose, String.valueOf(Closedloseint+1));
                            CloseWin4int=CloseWin4int+1;
                        }

                        //1-5
                        CloseWin1int=CloseWin1int+1;
                        CloseLose5int=CloseLose5int+1;
                        //2-6
                        CloseWin2int=CloseWin2int+1;
                        CloseLose6int=CloseLose6int+1;
                        //3-7
                        CloseWin3int=CloseWin3int+1;
                        CloseLose7int=CloseLose7int+1;
                        editor.putString(Series4Win, String.valueOf(winloose));

                    }

                    else if (Seriescnt==4)
                    {
                        if (winloose==1)
                        {
                            editor.putString(Closedwin, String.valueOf(Closedwinint+1));
                            CloseLose3int=CloseLose3int+1;

                        }
                        else if(winloose==2)
                        {
                            editor.putString(Closedlose, String.valueOf(Closedloseint+1));
                            CloseWin3int=CloseWin3int+1;
                        }

                        //1-6
                        CloseWin1int=CloseWin1int+1;
                        CloseLose6int=CloseLose6int+1;
                        //2-5
                        CloseWin2int=CloseWin2int+1;
                        CloseLose5int=CloseLose5int+1;
                        //4-7
                        CloseWin4int=CloseWin4int+1;
                        CloseLose7int=CloseLose7int+1;
                        editor.putString(Series5Win, String.valueOf(winloose));


                    }

                    else if (Seriescnt==5)
                    {
                        if (winloose==1)
                        {
                            editor.putString(Closedwin, String.valueOf(Closedwinint+1));
                            CloseLose2int=CloseLose2int+1;

                        }
                        else if(winloose==2)
                        {
                            editor.putString(Closedlose, String.valueOf(Closedloseint+1));
                            CloseWin2int=CloseWin2int+1;
                        }

                        //1-7
                        CloseWin1int=CloseWin1int+1;
                        CloseLose7int=CloseLose7int+1;
                        //3-6
                        CloseWin3int=CloseWin3int+1;
                        CloseLose6int=CloseLose6int+1;
                        //4-5
                        CloseWin4int=CloseWin4int+1;
                        CloseLose5int=CloseLose5int+1;
                        editor.putString(Series6Win, String.valueOf(winloose));
                    }

                    else if (Seriescnt==6)
                    {
                        if (winloose==1)
                        {
                            editor.putString(Closedwin, String.valueOf(Closedwinint+1));
                            CloseLose1int=CloseLose1int+1;

                        }
                        else if(winloose==2)
                        {
                            editor.putString(Closedlose, String.valueOf(Closedloseint+1));
                            CloseWin1int=CloseWin1int+1;
                        }


                        //2-7
                        CloseWin2int=CloseWin2int+1;
                        CloseLose7int=CloseLose7int+1;
                        //3-5
                        CloseWin3int=CloseWin3int+1;
                        CloseLose5int=CloseLose5int+1;
                        //4-6
                        CloseWin4int=CloseWin4int+1;
                        CloseLose6int=CloseLose6int+1;
                        editor.putString(Series7Win, String.valueOf(winloose));

                    }


                    editor.putString(CloseWin1, String.valueOf(CloseWin1int));
                    editor.putString(CloseWin2, String.valueOf(CloseWin2int));
                    editor.putString(CloseWin3, String.valueOf(CloseWin3int));
                    editor.putString(CloseWin4, String.valueOf(CloseWin4int));
                    editor.putString(CloseWin5, String.valueOf(CloseWin5int));
                    editor.putString(CloseWin6, String.valueOf(CloseWin6int));
                    editor.putString(CloseWin7, String.valueOf(CloseWin7int));

                    editor.putString(CloseLose1,String.valueOf(CloseLose1int));
                    editor.putString(CloseLose2,String.valueOf(CloseLose2int));
                    editor.putString(CloseLose3,String.valueOf(CloseLose3int));
                    editor.putString(CloseLose4,String.valueOf(CloseLose4int));
                    editor.putString(CloseLose5,String.valueOf(CloseLose5int));
                    editor.putString(CloseLose6,String.valueOf(CloseLose6int));
                    editor.putString(CloseLose7,String.valueOf(CloseLose7int));





                    editor.putString(ClosedSeries, String.valueOf(Seriescnt+1));
                    editor.apply();
                    startActivity(Tobackclose);
                }
                else if(TournMode==3)
                {

                    if(ClosedPlayofStageint==1)
                    {
                        if (winloose==1)
                        {
                            editor.putString(CloseScore1, String.valueOf(Score[0]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore2, String.valueOf(Score[1]+1));
                        }
                    }

                    else if(ClosedPlayofStageint==2)
                    {
                        if (winloose==1)
                        {
                            editor.putString(CloseScore5, String.valueOf(Score[4]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore6, String.valueOf(Score[5]+1));
                        }
                    }
                    else if(ClosedPlayofStageint==3)
                    {
                        if (winloose==1)
                        {
                            editor.putString(CloseScore7, String.valueOf(Score[6]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore8, String.valueOf(Score[7]+1));
                        }
                    }


                    else if(ClosedPlayofStageint==4)
                    {

                        if (stage4top==0)
                        {
                            if (winloose==1)
                            {
                                editor.putString(CloseScore9, String.valueOf(Score[8]+1));


                            }
                            else if(winloose==2)
                            {
                                editor.putString(CloseScore10, String.valueOf(Score[9]+1));
                            }
                        }
                        else
                        {
                            if (winloose==1)
                            {
                                editor.putString(CloseScore10, String.valueOf(Score[9]+1));


                            }
                            else if(winloose==2)
                            {
                                editor.putString(CloseScore9, String.valueOf(Score[8]+1));
                            }
                        }

                    }

                    else if(ClosedPlayofStageint==6)
                    {

                        if (stage6top==0)
                        {
                            if (winloose==1)
                            {
                                editor.putString(CloseScore11, String.valueOf(Score[10]+1));


                            }
                            else if(winloose==2)
                            {
                                editor.putString(CloseScore12, String.valueOf(Score[11]+1));
                            }
                        }
                        else
                        {
                            if (winloose==1)
                            {
                                editor.putString(CloseScore12, String.valueOf(Score[11]+1));


                            }
                            else if(winloose==2)
                            {
                                editor.putString(CloseScore11, String.valueOf(Score[10]+1));
                            }
                        }

                    }





                    editor.apply();
                    startActivity(Tobackplayoff);
                }
                else if(TournMode==4)
                {
                    if(MinorStageint==1)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore2, String.valueOf(MinorScore[1]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MinorScore1, String.valueOf(MinorScore[0]+1));
                        }
                    }
                    else if(MinorStageint==2)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore4, String.valueOf(MinorScore[3]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MinorScore3, String.valueOf(MinorScore[2]+1));
                        }
                    }
                    else if(MinorStageint==3)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore6, String.valueOf(MinorScore[5]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MinorScore5, String.valueOf(MinorScore[4]+1));
                        }
                    }
                    else if(MinorStageint==4)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore8, String.valueOf(MinorScore[7]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MinorScore7, String.valueOf(MinorScore[6]+1));
                        }
                    }

                    editor.apply();
                    startActivity(Tomainstance);
                }
                else if(TournMode==5)
                {
                   if(Major_stage==1)
                   {
                       if (winloose==1)
                       {
                           editor.putString(MajorScore2, String.valueOf(MajorScore[1]+1));


                       }
                       else if(winloose==2)
                       {
                           editor.putString(MajorScore1, String.valueOf(MajorScore[0]+1));
                       }
                   }
                   else if(Major_stage==2)
                   {
                       if (winloose==1)
                       {
                           editor.putString(MajorScore4, String.valueOf(MajorScore[3]+1));


                       }
                       else if(winloose==2)
                       {
                           editor.putString(MajorScore3, String.valueOf(MajorScore[2]+1));
                       }
                   }
                   else if(Major_stage==3)
                   {
                       if (winloose==1)
                       {
                           editor.putString(MajorScore6, String.valueOf(MajorScore[5]+1));


                       }
                       else if(winloose==2)
                       {
                           editor.putString(MajorScore5, String.valueOf(MajorScore[4]+1));
                       }
                   }
                   else if(Major_stage==4)
                   {
                       if (winloose==1)
                       {
                           editor.putString(MajorScore8, String.valueOf(MajorScore[7]+1));


                       }
                       else if(winloose==2)
                       {
                           editor.putString(MajorScore7, String.valueOf(MajorScore[6]+1));
                       }
                   }



                    editor.apply();
                    startActivity(Tomainstance);
                }
                else if(TournMode==6)
                {
                    if(MajorPLayofStage==1)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore4, "1");


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore3, "1");
                        }
                    }
                    if(MajorPLayofStage==3)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore6, String.valueOf(ScorePlay[5]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore5, String.valueOf(ScorePlay[4]+1));
                        }
                    }
                    if(MajorPLayofStage==5)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore8, String.valueOf(ScorePlay[7]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore7, String.valueOf(ScorePlay[6]+1));
                        }
                    }
                    if(MajorPLayofStage==7)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore10, String.valueOf(ScorePlay[9]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore9, String.valueOf(ScorePlay[8]+1));
                        }
                    }

                    if(MajorPLayofStage==8)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore12, String.valueOf(ScorePlay[11]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore11, String.valueOf(ScorePlay[10]+1));
                        }
                    }

                    if(MajorPLayofStage==9)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore14, String.valueOf(ScorePlay[13]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore13, String.valueOf(ScorePlay[12]+1));
                        }
                    }

                    if(MajorPLayofStage==10)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore16, String.valueOf(ScorePlay[15]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore15, String.valueOf(ScorePlay[14]+1));
                        }
                    }

                    if(MajorPLayofStage==2)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore1, String.valueOf(ScorePlay[0]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore2, String.valueOf(ScorePlay[1]+1));
                        }
                    }

                    if(MajorPLayofStage==4)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore17, String.valueOf(ScorePlay[16]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore18, String.valueOf(ScorePlay[17]+1));
                        }
                    }

                    if(MajorPLayofStage==6)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore19, String.valueOf(ScorePlay[18]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore20, String.valueOf(ScorePlay[19]+1));
                        }
                    }

                    if(MajorPLayofStage==11)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MajorPScore16, String.valueOf(ScorePlay[15]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(MajorPScore15, String.valueOf(ScorePlay[14]+1));
                        }
                    }



                    editor.apply();
                    startActivity(Tomainstance);

                }
                else if(TournMode==7)
                {
                    if(Seriescnt==0)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore1, String.valueOf(MinorScore[0]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore1, String.valueOf(Score[0]+1));
                        }
                    }
                    else  if(Seriescnt==1)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore2, String.valueOf(MinorScore[1]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore2, String.valueOf(Score[1]+1));
                        }
                    }
                    else  if(Seriescnt==2)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore3, String.valueOf(MinorScore[2]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore3, String.valueOf(Score[2]+1));
                        }
                    }
                    else  if(Seriescnt==3)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore4, String.valueOf(MinorScore[3]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore4, String.valueOf(Score[3]+1));
                        }
                    }
                    else  if(Seriescnt==4)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore5, String.valueOf(MinorScore[4]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore5, String.valueOf(Score[4]+1));
                        }
                    }
                    else  if(Seriescnt==5)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore6, String.valueOf(MinorScore[5]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore6, String.valueOf(Score[5]+1));
                        }
                    }
                    else  if(Seriescnt==6)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore7, String.valueOf(MinorScore[6]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore7, String.valueOf(Score[6]+1));
                        }
                    }
                    else  if(Seriescnt==7)
                    {
                        if (winloose==1)
                        {
                            editor.putString(MinorScore8, String.valueOf(MinorScore[7]+1));


                        }
                        else if(winloose==2)
                        {
                            editor.putString(CloseScore8, String.valueOf(Score[7]+1));
                        }
                    }
                    editor.apply();
                    startActivity(Tomainstance);
                }
                else
                {
                    if(day==30)
                    {
                        editor.putString(Day, "1");
                        if(Monthint==11)
                        {
                            editor.putString(Month, "0");
                            editor.putString(Year, String.valueOf(Yearint+1));
                        }
                        else{
                            editor.putString(Month, String.valueOf(Monthint+1));
                        }
                    }
                    else
                    {
                        editor.putString(Day, String.valueOf(day+1));
                    }




                    editor.putString(XPstatic, String.valueOf(XPint+3));
                    editor.putString(GoldBalance, String.valueOf(goldbalance+(fancebalance/50)));

                    editor.apply();
                    HeroesSpot.clear();
                    AllHeroes.clear();
                    startActivity(Tomainstance);
                }


            }
        });

        stagenumber.setText("stage1");

        int totaltopRadiant=0;
        int totaltopDire=0;

        int totalmidRadiant=0;
        int totalmidDire=0;

        int totalbottomRadiant=0;
        int totalbottomDire=0;

        int tt=0;
        int mm=0;
        int bb=0;

        int topradiantheroes=0;
        int midradiantheroes=0;
        int bottomradiantheroes=0;
        for (int i=0;i<5;i++)
        {
            if (Lane[i]==1)
            {
                topradiantheroes++;
            }
            if (Lane[i]==2)
            {
                midradiantheroes++;
            }
            if (Lane[i]==3)
            {
                bottomradiantheroes++;
            }


        }


        int comptopradiantheroes=0;
        int compmidradiantheroes=0;
        int compbottomradiantheroes=0;
        for (int i=0;i<5;i++)
        {
            if (CompLane[i]==1)
            {
                comptopradiantheroes++;
            }
            if (CompLane[i]==2)
            {
                compmidradiantheroes++;
            }
            if (CompLane[i]==3)
            {
                compbottomradiantheroes++;
            }


        }










        for(int z=0;z<5;z++)
        {
            if (Lane[z]==1)
            {
                Networthicon[tt].setImageResource(HeroesSpot.get(Hero[z]).mipmap);
                Radiant_Unit[tt]= new Player_unit(AllPlayers.get(Gamer[z]),HeroesSpot.get(Hero[z]));
                TopIcon[tt].setImageResource(HeroesSpot.get(Hero[z]).mipmap);
                tt++;
                totaltopRadiant=totaltopRadiant+HeroesSpot.get(Hero[z]).laining;

            }
            else if(Lane[z]==2)
            {
                Networthicon[topradiantheroes+mm].setImageResource(HeroesSpot.get(Hero[z]).mipmap);
                Radiant_Unit[topradiantheroes+mm]= new Player_unit(AllPlayers.get(Gamer[z]),HeroesSpot.get(Hero[z]));
                MidIcon[mm].setImageResource(HeroesSpot.get(Hero[z]).mipmap);
                mm++;
                totalmidRadiant=totalmidRadiant+HeroesSpot.get(Hero[z]).laining;

            }
            else if(Lane[z]==3)
            {
                Networthicon[midradiantheroes+topradiantheroes+bb].setImageResource(HeroesSpot.get(Hero[z]).mipmap);
                Radiant_Unit[midradiantheroes+topradiantheroes+bb]= new Player_unit(AllPlayers.get(Gamer[z]),HeroesSpot.get(Hero[z]));
                BottomIcon[bb].setImageResource(HeroesSpot.get(Hero[z]).mipmap);
                bb++;
                totalbottomRadiant=totalbottomRadiant+HeroesSpot.get(Hero[z]).laining;

            }



        }
        totaltopRadiant=totaltopRadiant+ExLainingint/4;
        totalmidRadiant=totalmidRadiant+ExLainingint/4;
        totalbottomRadiant=totalbottomRadiant+ExLainingint/4;






        int ett=0;
        int emm=0;
        int ebb=0;
        for(int z=0;z<5;z++)
        {
            if (CompLane[z]==1)
            {
                Networthicon[5+ett].setImageResource(HeroesSpot.get(CompHero[z]).mipmap);
                Dire_Unit[ett]= new Player_unit(AllPlayers.get(CompGamer[z]),HeroesSpot.get(CompHero[z]));
                EnemyTopIcon[ett].setImageResource(HeroesSpot.get(CompHero[z]).mipmap);
                ett++;
                totaltopDire=totaltopDire+HeroesSpot.get(CompHero[z]).laining;
            }
            else if(CompLane[z]==2)
            {
                Networthicon[5+comptopradiantheroes+emm].setImageResource(HeroesSpot.get(CompHero[z]).mipmap);
                Dire_Unit[comptopradiantheroes+emm]= new Player_unit(AllPlayers.get(CompGamer[z]),HeroesSpot.get(CompHero[z]));
                EnemyMidIcon[emm].setImageResource(HeroesSpot.get(CompHero[z]).mipmap);
                emm++;
                totalmidDire=totalmidDire+HeroesSpot.get(CompHero[z]).laining;
            }
            else if(CompLane[z]==3)
            {
                Networthicon[5+compmidradiantheroes+comptopradiantheroes+ebb].setImageResource(HeroesSpot.get(CompHero[z]).mipmap);
                Dire_Unit[compmidradiantheroes+comptopradiantheroes+ebb]= new Player_unit(AllPlayers.get(CompGamer[z]),HeroesSpot.get(CompHero[z]));
                EnemyBottomIcon[ebb].setImageResource(HeroesSpot.get(CompHero[z]).mipmap);
                ebb++;
                totalbottomDire=totalbottomDire+HeroesSpot.get(CompHero[z]).laining;
            }



        }


        if(totaltopRadiant>totaltopDire)
        {
            TopScoreTitle.setText("win");
            TopScoreTitle.setTextColor(Color.parseColor("#196310"));
        }
        else
        {
            TopScoreTitle.setText("lose");
            TopScoreTitle.setTextColor(Color.parseColor("#7d1212"));
        }

        if(totalmidRadiant>totalmidDire)
        {
            MidScoreTitle.setText("win");
            MidScoreTitle.setTextColor(Color.parseColor("#196310"));
        }
        else
        {
            MidScoreTitle.setText("lose");
            MidScoreTitle.setTextColor(Color.parseColor("#7d1212"));
        }

        if(totalbottomRadiant>totalbottomDire)
        {
            BottomScoreTitle.setText("win");
            BottomScoreTitle.setTextColor(Color.parseColor("#196310"));
        }
        else
        {
            BottomScoreTitle.setText("lose");
            BottomScoreTitle.setTextColor(Color.parseColor("#7d1212"));
        }




       for(int i=0; i<5;i++)
       {
        //NetworthText[i].setText("1300");
       }

        final float kefmid = (float) (totalmidRadiant+totalmidDire)/2;
        final float keftop = (float) (totaltopRadiant+totaltopDire)/2;
        final float kefbottom = (float) (totalbottomRadiant+totalbottomDire)/2;





        int mylanefarmigtop=0;
        int mylanefarmigmid=0;
        int mylanefarmigbottom=0;


        for (int i=0;i<topradiantheroes;i++)
        {
            mylanefarmigtop=mylanefarmigtop+Dire_Unit[i].GamerPlayer.farming;
        }

        for (int i=0;i<midradiantheroes;i++)
        {
            mylanefarmigmid=mylanefarmigmid+Dire_Unit[i+topradiantheroes].GamerPlayer.farming;
        }

        for (int i=0;i<bottomradiantheroes;i++)
        {
            mylanefarmigbottom=mylanefarmigbottom+Dire_Unit[i+topradiantheroes+midradiantheroes].GamerPlayer.farming;
        }



        mylanefarmigtop=mylanefarmigtop+ExFarmingint/4;
        mylanefarmigmid=mylanefarmigmid+ExFarmingint/4;
        mylanefarmigbottom=mylanefarmigbottom+ExFarmingint/4;


















        final int[] mycnt = {0};

        final int supafightima[]= new int[3];


        supafightima[0]=R.drawable.sufight1;
        supafightima[1]=R.drawable.sufigh2;
        supafightima[2]=R.drawable.sufigh3;
        final int finalTopradiantheroes = topradiantheroes;
        final int finalMylanefarmigtop = mylanefarmigtop;
        final int finalTotaltopRadiant = totaltopRadiant;
        final int finalMidradiantheroes = midradiantheroes;
        final int finalMylanefarmigmid = mylanefarmigmid;
        final int finalTotalmidRadiant = totalmidRadiant;
        final int finalBottomradiantheroes = bottomradiantheroes;
        final int finalMylanefarmigbottom = mylanefarmigbottom;
        final int finalTotalbottomRadiant = totalbottomRadiant;
        final int finalComptopradiantheroes = comptopradiantheroes;
        final int finalCompmidradiantheroes = compmidradiantheroes;
        final int finalCompbottomradiantheroes = compbottomradiantheroes;
        final int finalTotaltopDire = totaltopDire;
        final int finalTotalmidDire = totalmidDire;
        final int finalTotalbottomDire = totalbottomDire;
        Mytimer=  new CountDownTimer(200, 150) {
            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
            public void onTick(long millisUntilFinished) {

                if(mycnt[0] <2)
                {
                    mycnt[0]++;
                }
                else
                {
                    mycnt[0] =0;
                }

                monst.setImageResource(supafightima[mycnt[0]]);


            }
            //Задаем действия после завершения отсчета (высвечиваем надпись "Бабах!"):
            public void onFinish() {
                radiantnetw.setVisibility(View.VISIBLE);

                //Middlegametimer.start();


                for(int i = 0; i< finalTopradiantheroes; i++)
                {


                    if(finalMylanefarmigtop <100)
                    {
                        RadiantNetworh[i] =625+ (int) (((((float) Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))/100))*(float)(finalTotaltopRadiant /keftop*2000));
                    }
                    else
                    {
                        RadiantNetworh[i] =625+ (int) ((((float) Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))/ finalMylanefarmigtop)*(float)(finalTotaltopRadiant /keftop*2000));
                    }

                    NetworthText[i].setText(String.valueOf(RadiantNetworh[i]));
                }

                for(int i = 0; i< finalMidradiantheroes; i++)
                {
                    if(finalMylanefarmigmid <100)
                    {
                        RadiantNetworh[i+ finalTopradiantheroes] =625+ (int) ((((float) Radiant_Unit[i+ finalTopradiantheroes].GamerPlayer.farming+(ExFarmingint/5))/100)*(float)(finalTotalmidRadiant /kefmid*2000));
                    }
                    else
                    {
                        RadiantNetworh[i+ finalTopradiantheroes] =625+ (int) ((((float) Radiant_Unit[i+ finalTopradiantheroes].GamerPlayer.farming+(ExFarmingint/5))/ finalMylanefarmigmid)*(float)(finalTotalmidRadiant /kefmid*2000));
                    }


                    NetworthText[i+ finalTopradiantheroes].setText(String.valueOf(RadiantNetworh[i+ finalTopradiantheroes]));
                }

                for(int i = 0; i< finalBottomradiantheroes; i++)
                {

                    if(finalMylanefarmigbottom <100)
                    {
                        RadiantNetworh[i+ finalTopradiantheroes + finalMidradiantheroes] =625+ (int) ((((float) Radiant_Unit[i+ finalTopradiantheroes + finalMidradiantheroes].GamerPlayer.farming+(ExFarmingint/5))/100)*(float)(finalTotalbottomRadiant /kefbottom*2000));
                    }
                    else
                    {
                        RadiantNetworh[i+ finalTopradiantheroes + finalMidradiantheroes] =625+ (int) ((((float) Radiant_Unit[i+ finalTopradiantheroes + finalMidradiantheroes].GamerPlayer.farming+(ExFarmingint/5))/ finalMylanefarmigbottom)*(float)(finalTotalbottomRadiant /kefbottom*2000));
                    }

                    NetworthText[i+ finalTopradiantheroes + finalMidradiantheroes].setText(String.valueOf(RadiantNetworh[i+ finalTopradiantheroes + finalMidradiantheroes]));
                }




                int lanefarmigtop=0;
                int lanefarmigmid=0;
                int lanefarmigbottom=0;


                for (int i = 0; i< finalComptopradiantheroes; i++)
                {
                    lanefarmigtop=lanefarmigtop+Dire_Unit[i].GamerPlayer.farming;
                }

                for (int i = 0; i< finalCompmidradiantheroes; i++)
                {
                    lanefarmigmid=lanefarmigmid+Dire_Unit[i+ finalComptopradiantheroes].GamerPlayer.farming;
                }

                for (int i = 0; i< finalCompbottomradiantheroes; i++)
                {
                    lanefarmigbottom=lanefarmigbottom+Dire_Unit[i+ finalComptopradiantheroes + finalCompmidradiantheroes].GamerPlayer.farming;
                }







                for(int i = 0; i< finalComptopradiantheroes; i++)
                {

                    if (lanefarmigtop<100)
                    {
                        DireNetworh[i] =625+ (int) (((float) Dire_Unit[i].GamerPlayer.farming/100)*(float)(finalTotaltopDire /keftop*2000));
                    }
                    else
                    {
                        DireNetworh[i] =625+ (int) (((float) Dire_Unit[i].GamerPlayer.farming/lanefarmigtop)*(float)(finalTotaltopDire /keftop*2000));
                    }


                    NetworthText[5+i].setText(String.valueOf(DireNetworh[i]));
                }

                for(int i = 0; i< finalCompmidradiantheroes; i++)
                {
                    if (lanefarmigmid<100)
                    {
                        DireNetworh[i+ finalComptopradiantheroes] =625+ (int) (((float) Dire_Unit[i+ finalComptopradiantheroes].GamerPlayer.farming/100)*(float)(finalTotalmidDire /kefmid*2000));
                    }
                    else
                    {
                        DireNetworh[i+ finalComptopradiantheroes] =625+ (int) (((float) Dire_Unit[i+ finalComptopradiantheroes].GamerPlayer.farming/lanefarmigmid)*(float)(finalTotalmidDire /kefmid*2000));
                    }

                    NetworthText[5+i+ finalComptopradiantheroes].setText(String.valueOf(DireNetworh[i+ finalComptopradiantheroes]));
                }

                for(int i = 0; i< finalCompbottomradiantheroes; i++)
                {

                    if (lanefarmigbottom<100)
                    {
                        DireNetworh[i+ finalComptopradiantheroes + finalCompmidradiantheroes] =625+ (int) (((float) Dire_Unit[i+ finalComptopradiantheroes + finalCompmidradiantheroes].GamerPlayer.farming/100)*(float)(finalTotalbottomDire /kefbottom*2000));
                    }
                    else
                    {
                        DireNetworh[i+ finalComptopradiantheroes + finalCompmidradiantheroes] =625+ (int) (((float) Dire_Unit[i+ finalComptopradiantheroes + finalCompmidradiantheroes].GamerPlayer.farming/lanefarmigbottom)*(float)(finalTotalbottomDire /kefbottom*2000));
                    }

                    NetworthText[5+i+ finalComptopradiantheroes + finalCompmidradiantheroes].setText(String.valueOf(DireNetworh[i+ finalComptopradiantheroes + finalCompmidradiantheroes]));
                }


                funcsort();
                checknet();
                daytimetext.setText("5:00");

                LoseOrWin.setVisibility(View.VISIBLE);
                LoseOrWin.setText("Choose option");
                choose[0].setVisibility(View.VISIBLE);
                choose[1].setVisibility(View.VISIBLE);
                choose[2].setVisibility(View.VISIBLE);
/*

*/

                //tomainstance.setVisibility(View.VISIBLE);
            }

        }
                .start();




for (int i=0;i<3;i++)
{
    final int finalI = i;
    final int finalComptopradiantheroes1 = comptopradiantheroes;
    choose[i].setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View v) {

            if (stage==0)
            {
                stagenumber.setText("stage2");
                choose[0].setVisibility(View.INVISIBLE);
                choose[1].setVisibility(View.INVISIBLE);
                choose[2].setVisibility(View.INVISIBLE);
                State2=new CountDownTimer(200, 150) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if(mycnt[0] <2)
                        {
                            mycnt[0]++;
                        }
                        else
                        {
                            mycnt[0] =0;
                        }

                        monst.setImageResource(supafightima[mycnt[0]]);
                    }

                    @Override
                    public void onFinish() {
                        for(int i =0;i<5;i++)
                        {
                            if(Radiant_Unit[i].GamerPlayer.farming>60)
                            {
                                RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))*15)+Radiant_Unit[i].GamerHeroes.fighting*5);
                            }
                            else
                            {
                                RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))*5)+Radiant_Unit[i].GamerHeroes.fighting*5);
                            }
                            if(Dire_Unit[i].GamerPlayer.farming>60)
                            {
                                DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*15)+Dire_Unit[i].GamerHeroes.fighting*5);
                            }
                            else
                            {
                                DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*5)+Dire_Unit[i].GamerHeroes.fighting*5);
                            }


                        }
                        if(finalI==0)
                        {
                            DireNetworh[0]=DireNetworh[0]-300;
                            DireNetworh[1]=DireNetworh[1]-300;
                            DireNetworh[2]=DireNetworh[2]-300;

                        }
                        else if(finalI==1)
                        {
                            DireNetworh[finalComptopradiantheroes1]=DireNetworh[finalComptopradiantheroes1]-1000;
                        }
                        else if(finalI==2)
                        {
                            DireNetworh[4]=DireNetworh[4]-1000;
                        }

                        funcsort();
                        checknet();
                        stage=1;
                        choose[1].setImageResource(R.drawable.fightt);
                        choose[2].setImageResource(R.drawable.farmt);
                        choose[1].setVisibility(View.VISIBLE);
                        choose[2].setVisibility(View.VISIBLE);
                        daytimetext.setText("10:00");
                    }
                }.start();
            }
            else if(stage==1)
            {
                choose[1].setVisibility(View.INVISIBLE);
                choose[2].setVisibility(View.INVISIBLE);
                stagenumber.setText("stage3");
                State3=new CountDownTimer(200,150) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if(mycnt[0] <2)
                        {
                            mycnt[0]++;
                        }
                        else
                        {
                            mycnt[0] =0;
                        }

                        monst.setImageResource(supafightima[mycnt[0]]);
                    }

                    @Override
                    public void onFinish() {
                        daytimetext.setText("20:00");
                        if (finalI==1)
                        {
                            for(int i =0;i<5;i++)
                            {
                                if(Radiant_Unit[i].GamerPlayer.farming>60) {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.fighting+(ExFightingint/5))*40)+Radiant_Unit[i].GamerHeroes.fighting*40);
                                }
                                else if(Radiant_Unit[i].GamerPlayer.farming>25)
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.fighting+(ExFightingint/5))*20)+Radiant_Unit[i].GamerHeroes.fighting*20);
                                }
                                else
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.fighting+(ExFightingint/5))*10)+Radiant_Unit[i].GamerHeroes.fighting*10);
                                }

                                if(Dire_Unit[i].GamerPlayer.farming>60) {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.fighting*40)+Dire_Unit[i].GamerHeroes.fighting*40);
                                }
                                else if(Dire_Unit[i].GamerPlayer.farming>25)
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.fighting*20)+Dire_Unit[i].GamerHeroes.fighting*20);
                                }
                                else
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.fighting*10)+Dire_Unit[i].GamerHeroes.fighting*10);
                                }
                            }
                        }
                        else if (finalI==2)
                        {
                            for(int i =0;i<5;i++)
                            {

                                if(Radiant_Unit[i].GamerPlayer.farming>60) {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))*40)+Radiant_Unit[i].GamerHeroes.farm*40);
                                }
                                else if(Radiant_Unit[i].GamerPlayer.farming>25)
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))*20)+Radiant_Unit[i].GamerHeroes.farm*20);
                                }
                                else
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))*10)+Radiant_Unit[i].GamerHeroes.farm*10);
                                }

                                if(Dire_Unit[i].GamerPlayer.farming>60) {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*40)+Dire_Unit[i].GamerHeroes.farm*40);
                                }
                                else if(Dire_Unit[i].GamerPlayer.farming>25)
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*20)+Dire_Unit[i].GamerHeroes.farm*20);
                                }
                                else
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*10)+Dire_Unit[i].GamerHeroes.farm*10);
                                }



                            }
                        }
                        funcsort();
                        checknet();
                        stage=2;
                        choose[0].setImageResource(R.drawable.push);
                        choose[1].setImageResource(R.drawable.rosh);
                        choose[2].setImageResource(R.drawable.latebttn);
                        choose[0].setVisibility(View.VISIBLE);
                        choose[1].setVisibility(View.VISIBLE);
                        choose[2].setVisibility(View.VISIBLE);

                    }
                }.start();



            }

            else if (stage==2)
            {
                stagenumber.setText("stage4");
                choose[0].setVisibility(View.INVISIBLE);
                choose[1].setVisibility(View.INVISIBLE);
                choose[2].setVisibility(View.INVISIBLE);

                State4=new CountDownTimer(200,150) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if(mycnt[0] <2)
                        {
                            mycnt[0]++;
                        }
                        else
                        {
                            mycnt[0] =0;
                        }

                        monst.setImageResource(supafightima[mycnt[0]]);
                    }

                    @Override
                    public void onFinish() {

                        if(finalI==0)
                        {
                            daytimetext.setText("35:00");
                            for(int i =0;i<5;i++)
                            {
                                if(Radiant_Unit[i].GamerPlayer.farming>60) {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.fighting+(ExFightingint/5))*40)+Radiant_Unit[i].GamerHeroes.fighting*40);
                                }
                                else if(Radiant_Unit[i].GamerPlayer.farming>25)
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.fighting+(ExFightingint/5))*20)+Radiant_Unit[i].GamerHeroes.fighting*20);
                                }
                                else
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.fighting+(ExFightingint/5))*10)+Radiant_Unit[i].GamerHeroes.fighting*10);
                                }

                                if(Dire_Unit[i].GamerPlayer.farming>60) {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.fighting*40)+Dire_Unit[i].GamerHeroes.fighting*40);
                                }
                                else if(Dire_Unit[i].GamerPlayer.farming>25)
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.fighting*20)+Dire_Unit[i].GamerHeroes.fighting*20);
                                }
                                else
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.fighting*10)+Dire_Unit[i].GamerHeroes.fighting*10);
                                }
                            }


                        }
                        else if (finalI==1)
                        {
                            daytimetext.setText("40:00");
                            for(int i =0;i<5;i++)
                            {
                                if(Radiant_Unit[i].GamerPlayer.farming>60) {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))*50)+Radiant_Unit[i].GamerHeroes.fighting*50);
                                }
                                else if(Radiant_Unit[i].GamerPlayer.farming>25)
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))*25)+Radiant_Unit[i].GamerHeroes.fighting*25);
                                }
                                else
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+((Radiant_Unit[i].GamerPlayer.farming+(ExFarmingint/5))*15)+Radiant_Unit[i].GamerHeroes.fighting*15);
                                }

                                if(Dire_Unit[i].GamerPlayer.farming>60) {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*50)+Dire_Unit[i].GamerHeroes.fighting*50);
                                }
                                else if(Dire_Unit[i].GamerPlayer.farming>25)
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*25)+Dire_Unit[i].GamerHeroes.fighting*25);
                                }
                                else
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*15)+Dire_Unit[i].GamerHeroes.fighting*15);
                                }
                            }
                        }

                        else if(finalI==2)
                        {
                            daytimetext.setText("50:00");
                            for(int i =0;i<5;i++)
                            {
                                if(Radiant_Unit[i].GamerPlayer.farming>60) {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+(Radiant_Unit[i].GamerPlayer.farming*100)+(Radiant_Unit[i].GamerPlayer.late+(ExLateint/5))*60);
                                }
                                else if(Radiant_Unit[i].GamerPlayer.farming>25)
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+(Radiant_Unit[i].GamerPlayer.farming*45)+(Radiant_Unit[i].GamerPlayer.late+(ExLateint/5))*45);
                                }
                                else
                                {
                                    RadiantNetworh[i]=(RadiantNetworh[i]+(Radiant_Unit[i].GamerPlayer.farming*35)+(Radiant_Unit[i].GamerPlayer.late+(ExLateint/5))*35);
                                }

                                if(Dire_Unit[i].GamerPlayer.farming>60) {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*100)+Dire_Unit[i].GamerPlayer.late*60);
                                }
                                else if(Dire_Unit[i].GamerPlayer.farming>25)
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*45)+Dire_Unit[i].GamerPlayer.late*45);
                                }
                                else
                                {
                                    DireNetworh[i]=(DireNetworh[i]+  (Dire_Unit[i].GamerPlayer.farming*35)+Dire_Unit[i].GamerPlayer.late*35);
                                }
                            }
                        }
                        funcsort();
                        checknet();



                        int totalradlate=0;
                        int totaldirelate=0;

                        for (int i=0;i<5;i++)
                        {
                            totalradlate=totalradlate+RadiantNetworh[i];
                            totaldirelate=totaldirelate+DireNetworh[i];
                        }

                        if(totalradlate>totaldirelate)
                        {
                            LoseOrWin.setText("Radiant Victory");
                            LoseOrWin.setTextColor(Color.parseColor("#196310"));
                            LoseOrWin.setVisibility(View.VISIBLE);

                            winloose=1;
                        }
                        else
                        {
                            LoseOrWin.setText("Dire Victory");
                            LoseOrWin.setTextColor(Color.parseColor("#7d1212"));
                            LoseOrWin.setVisibility(View.VISIBLE);

                            winloose=2;
                        }






                        tomainstance.setVisibility(View.VISIBLE);

                    }
                }.start();


            }









        }
    });
}







    }

    void funcsort()
    {
        nettable.clear();
        nettable.add( new NetworthUnit(1,RadiantNetworh[0],Radiant_Unit[0].GamerHeroes.seq));
        nettable.add( new NetworthUnit(1,RadiantNetworh[1],Radiant_Unit[1].GamerHeroes.seq));
        nettable.add( new NetworthUnit(1,RadiantNetworh[2],Radiant_Unit[2].GamerHeroes.seq));
        nettable.add( new NetworthUnit(1,RadiantNetworh[3],Radiant_Unit[3].GamerHeroes.seq));
        nettable.add( new NetworthUnit(1,RadiantNetworh[4],Radiant_Unit[4].GamerHeroes.seq));

        nettable.add( new NetworthUnit(2,DireNetworh[0],Dire_Unit[0].GamerHeroes.seq));
        nettable.add( new NetworthUnit(2,DireNetworh[1],Dire_Unit[1].GamerHeroes.seq));
        nettable.add( new NetworthUnit(2,DireNetworh[2],Dire_Unit[2].GamerHeroes.seq));
        nettable.add( new NetworthUnit(2,DireNetworh[3],Dire_Unit[3].GamerHeroes.seq));
        nettable.add( new NetworthUnit(2,DireNetworh[4],Dire_Unit[4].GamerHeroes.seq));
        Collections.sort(nettable, NetworthUnit.COMPARE_BY_Networth);

        for(int i=0;i<10;i++)
        {
            NetworthText[i].setText(String.valueOf(nettable.get(i).networth));
            Networthicon[i].setImageResource(AllHeroes.get(nettable.get(i).hero).mipmap);
            if(nettable.get(i).color==1)
            {
                NetworthText[i].setBackgroundColor(Color.parseColor("#8ce182"));
                Networthicon[i].setBackgroundColor(Color.parseColor("#8ce182"));
            }
            else
            {
                NetworthText[i].setBackgroundColor(Color.parseColor("#cf7474"));
                Networthicon[i].setBackgroundColor(Color.parseColor("#cf7474"));
            }
        }
    }

    void checknet()
    {
        int radiatlaining=0;
        int direlaining=0;

        for (int i=0;i<5;i++)
        {
            radiatlaining=radiatlaining+RadiantNetworh[i];
            direlaining=direlaining+DireNetworh[i];
        }



        if (radiatlaining>direlaining)
        {
            radiantnetw.setText("WIN");


            radiantnetw.setTextColor(Color.parseColor("#196310"));
        }
        else
        {
            radiantnetw.setText("LOSE");
            radiantnetw.setTextColor(Color.parseColor("#7d1212"));
        }
    }




}
