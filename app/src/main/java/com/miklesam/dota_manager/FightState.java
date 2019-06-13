package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.miklesam.dota_manager.HeroInit.AllHeroes;
import static com.miklesam.dota_manager.PlayersInit.AllPlayers;
import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.YourTeam.FinalsWin;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Mode;
import static com.miklesam.dota_manager.YourTeam.OpenFinals;
import static com.miklesam.dota_manager.YourTeam.OpenQuaterFinals;
import static com.miklesam.dota_manager.YourTeam.OpenSemiFinals;
import static com.miklesam.dota_manager.YourTeam.QuaterWin;
import static com.miklesam.dota_manager.YourTeam.SemiWin;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;

public class FightState extends AppCompatActivity {


    TextView Toplane;
    TextView Midlane;
    TextView Bottomlane;
    int Hero[]=new int[5];
    int Lane[]=new int[5];
    int Gamer[]=new int[5];
    int CompLane[]=new int[5];
    int CompHero[]=new int[5];
    int CompGamer[]=new int[5];

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
    TextView GoldKeff;
    TextView latekeff;
    TextView LoseOrWin;
    Button tomainstance;
    int winloose;
    SharedPreferences mSettings;
    int TournMode;
    int openquater;
    int opensemi;

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
        latekeff=findViewById(R.id.latekeff);
        Toplane=findViewById(R.id.topline);
        Midlane=findViewById(R.id.midline);
        Bottomlane=findViewById(R.id.bottomline);
        TopIcon[0]=findViewById(R.id.top5st);
        TopIcon[1]=findViewById(R.id.top4st);
        TopIcon[2]=findViewById(R.id.top3st);
        TopIcon[3]=findViewById(R.id.top2st);
        TopIcon[4]=findViewById(R.id.top1st);

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

        radiantnetw=findViewById(R.id.radiantnet);
        GoldKeff=findViewById(R.id.goldkeff);

        if(mSettings.contains(Mode)) {
            TournMode=Integer.parseInt(mSettings.getString(Mode, "0"));
        }

        if(mSettings.contains(OpenQuaterFinals)) {
            openquater=Integer.parseInt(mSettings.getString(OpenQuaterFinals, "0"));
        }

        if(mSettings.contains(OpenSemiFinals)) {
            opensemi=Integer.parseInt(mSettings.getString(OpenSemiFinals, "0"));
        }



        final Intent Tomainstance = new Intent(this, mainstate.class);
        final Intent Tobackopen = new Intent(this, OpenQuali.class);

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

                Gamer[0] = 0;
                Gamer[1] = 0;
                Gamer[2] = 0;
                Gamer[3] = 0;
                Gamer[4] = 0;


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

                Gamer[0] = extras.getInt("Gamer1");
                Gamer[1] = extras.getInt("Gamer2");
                Gamer[2] = extras.getInt("Gamer3");
                Gamer[3] = extras.getInt("Gamer4");
                Gamer[4] = extras.getInt("Gamer5");




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

            Gamer[0] = (int) savedInstanceState.getSerializable("Gamer1");
            Gamer[1] = (int) savedInstanceState.getSerializable("Gamer2");
            Gamer[2] = (int) savedInstanceState.getSerializable("Gamer3");
            Gamer[3] = (int) savedInstanceState.getSerializable("Gamer4");
            Gamer[4] = (int) savedInstanceState.getSerializable("Gamer5");

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


                if (TournMode==1)
                {
                    HeroesSpot.clear();
                    AllHeroes.clear();
                    SharedPreferences.Editor editor = mSettings.edit();
                    if (opensemi==1)
                    {
                        editor.putString(OpenFinals, "1");
                        editor.putString(FinalsWin, "1");
                    }

                    else if (openquater==1)
                    {
                        editor.putString(OpenSemiFinals, "1");
                        editor.putString(SemiWin, "1");
                    }
                    else
                    {
                        editor.putString(OpenQuaterFinals, "1");
                        editor.putString(QuaterWin, "1");

                    }


                    editor.apply();

                    startActivity(Tobackopen);
                }

                else
                {

                    HeroesSpot.clear();
                    AllHeroes.clear();
                    startActivity(Tomainstance);
                }


            }
        });

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

        TopScoreTitle.setText(String.valueOf(totaltopRadiant)+"vs"+String.valueOf(totaltopDire));
        MidScoreTitle.setText(String.valueOf(totalmidRadiant)+"vs"+String.valueOf(totalmidDire));
        BottomScoreTitle.setText(String.valueOf(totalbottomRadiant)+"vs"+String.valueOf(totalbottomDire));

       for(int i=0; i<5;i++)
       {
        //NetworthText[i].setText("1300");
       }

        float kefmid = (float) (totalmidRadiant+totalmidDire)/2;
        float keftop = (float) (totaltopRadiant+totaltopDire)/2;
        float kefbottom = (float) (totalbottomRadiant+totalbottomDire)/2;





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









        for(int i=0; i<topradiantheroes;i++)
        {

            if(mylanefarmigtop<100)
            {
                RadiantNetworh[i] = (int) (((float) Radiant_Unit[i].GamerPlayer.farming/100)*(float)(totaltopRadiant/keftop*5000));
            }
            else
            {
                RadiantNetworh[i] = (int) (((float) Radiant_Unit[i].GamerPlayer.farming/mylanefarmigtop)*(float)(totaltopRadiant/keftop*5000));
            }

            NetworthText[i].setText(String.valueOf(RadiantNetworh[i]));
        }

        for(int i=0; i<midradiantheroes;i++)
        {
            if(mylanefarmigmid<100)
            {
                RadiantNetworh[i+topradiantheroes] = (int) (((float) Radiant_Unit[i+topradiantheroes].GamerPlayer.farming/100)*(float)(totalmidRadiant/kefmid*5000));
            }
            else
            {
                RadiantNetworh[i+topradiantheroes] = (int) (((float) Radiant_Unit[i+topradiantheroes].GamerPlayer.farming/mylanefarmigmid)*(float)(totalmidRadiant/kefmid*5000));
            }


            NetworthText[i+topradiantheroes].setText(String.valueOf(RadiantNetworh[i+topradiantheroes]));
        }

        for(int i=0; i<bottomradiantheroes;i++)
        {

            if(mylanefarmigbottom<100)
            {
                RadiantNetworh[i+topradiantheroes+midradiantheroes] = (int) (((float) Radiant_Unit[i+topradiantheroes+midradiantheroes].GamerPlayer.farming/100)*(float)(totalbottomRadiant/kefbottom*5000));
            }
            else
            {
                RadiantNetworh[i+topradiantheroes+midradiantheroes] = (int) (((float) Radiant_Unit[i+topradiantheroes+midradiantheroes].GamerPlayer.farming/mylanefarmigbottom)*(float)(totalbottomRadiant/kefbottom*5000));
            }

            NetworthText[i+topradiantheroes+midradiantheroes].setText(String.valueOf(RadiantNetworh[i+topradiantheroes+midradiantheroes]));
        }




        int lanefarmigtop=0;
        int lanefarmigmid=0;
        int lanefarmigbottom=0;


        for (int i=0;i<comptopradiantheroes;i++)
        {
            lanefarmigtop=lanefarmigtop+Dire_Unit[i].GamerPlayer.farming;
        }

        for (int i=0;i<compmidradiantheroes;i++)
        {
            lanefarmigmid=lanefarmigmid+Dire_Unit[i+comptopradiantheroes].GamerPlayer.farming;
        }

        for (int i=0;i<compbottomradiantheroes;i++)
        {
            lanefarmigbottom=lanefarmigbottom+Dire_Unit[i+comptopradiantheroes+compmidradiantheroes].GamerPlayer.farming;
        }







        for(int i=0; i<comptopradiantheroes;i++)
        {

            if (lanefarmigtop<100)
            {
                DireNetworh[i] = (int) (((float) Dire_Unit[i].GamerPlayer.farming/100)*(float)(totaltopDire/keftop*5000));
            }
            else
            {
                DireNetworh[i] = (int) (((float) Dire_Unit[i].GamerPlayer.farming/lanefarmigtop)*(float)(totaltopDire/keftop*5000));
            }


            NetworthText[5+i].setText(String.valueOf(DireNetworh[i]));
        }

        for(int i=0; i<compmidradiantheroes;i++)
        {
            if (lanefarmigmid<100)
            {
                DireNetworh[i+comptopradiantheroes] = (int) (((float) Dire_Unit[i+comptopradiantheroes].GamerPlayer.farming/100)*(float)(totalmidDire/kefmid*5000));
            }
            else
            {
                DireNetworh[i+comptopradiantheroes] = (int) (((float) Dire_Unit[i+comptopradiantheroes].GamerPlayer.farming/lanefarmigmid)*(float)(totalmidDire/kefmid*5000));
            }

            NetworthText[5+i+comptopradiantheroes].setText(String.valueOf(DireNetworh[i+comptopradiantheroes]));
        }

        for(int i=0; i<compbottomradiantheroes;i++)
        {

            if (lanefarmigbottom<100)
            {
                DireNetworh[i+comptopradiantheroes+compmidradiantheroes] = (int) (((float) Dire_Unit[i+comptopradiantheroes+compmidradiantheroes].GamerPlayer.farming/100)*(float)(totalbottomDire/kefbottom*5000));
            }
            else
            {
                DireNetworh[i+comptopradiantheroes+compmidradiantheroes] = (int) (((float) Dire_Unit[i+comptopradiantheroes+compmidradiantheroes].GamerPlayer.farming/lanefarmigbottom)*(float)(totalbottomDire/kefbottom*5000));
            }

            NetworthText[5+i+comptopradiantheroes+compmidradiantheroes].setText(String.valueOf(DireNetworh[i+comptopradiantheroes+compmidradiantheroes]));
        }



                radiantnetw.setText(String.valueOf(RadiantNetworh[0]+RadiantNetworh[1]+RadiantNetworh[2]+RadiantNetworh[3]+RadiantNetworh[4])+"vs"+
                String.valueOf(DireNetworh[0]+DireNetworh[1]+DireNetworh[2]+DireNetworh[3]+DireNetworh[4]));




for (int i=0;i<5;i++)
{
    NetworthText[i].setBackgroundColor(Color.parseColor("#00ff00"));
    Networthicon[i].setBackgroundColor(Color.parseColor("#00ff00"));
}

        for (int i=5;i<10;i++)
        {
            NetworthText[i].setBackgroundColor(Color.parseColor("#ff0000"));
            Networthicon[i].setBackgroundColor(Color.parseColor("#ff0000"));
        }



       //for(int i=5; i<10;i++)
      // {
       // Networthicon[i].setImageResource(HeroesSpot.get(CompHero[i-5]).mipmap);
      //  NetworthText[i].setText("1300");
      // }




        int Rad=RadiantNetworh[0]+RadiantNetworh[1]+RadiantNetworh[2]+RadiantNetworh[3]+RadiantNetworh[4];
        int Dire=DireNetworh[0]+DireNetworh[1]+DireNetworh[2]+DireNetworh[3]+DireNetworh[4];
        int goldkef=(Rad+Dire)/2;


        BottomScoreTitle.setText(String.valueOf(keftop));


        for(int i =0;i<5;i++)
        {
            RadiantNetworh[i]=(int) (RadiantNetworh[i]+ ((float)goldkef/Rad*Radiant_Unit[i].GamerPlayer.fighting*5000/100));
            DireNetworh[i]=(int) (DireNetworh[i]+ ((float)goldkef/Dire*Dire_Unit[i].GamerPlayer.fighting*5000/100));
            NetworthText[i].setText(String.valueOf(RadiantNetworh[i]));
            NetworthText[5+i].setText(String.valueOf(DireNetworh[i]));
        }



        //GoldKeff.setText(String.valueOf(goldkef));

        GoldKeff.setText(String.valueOf(RadiantNetworh[0]+RadiantNetworh[1]+RadiantNetworh[2]+RadiantNetworh[3]+RadiantNetworh[4])+"vs"+
        String.valueOf(DireNetworh[0]+DireNetworh[1]+DireNetworh[2]+DireNetworh[3]+DireNetworh[4]));


        Rad=RadiantNetworh[0]+RadiantNetworh[1]+RadiantNetworh[2]+RadiantNetworh[3]+RadiantNetworh[4];
        Dire=DireNetworh[0]+DireNetworh[1]+DireNetworh[2]+DireNetworh[3]+DireNetworh[4];
        goldkef=(Rad+Dire)/2;

        for(int i =0;i<5;i++)
        {
            RadiantNetworh[i]=(int) (RadiantNetworh[i]+ ((float)goldkef/Rad*Radiant_Unit[i].GamerPlayer.supporting*5000/100));
            DireNetworh[i]=(int) (DireNetworh[i]+ ((float)goldkef/Dire*Dire_Unit[i].GamerPlayer.supporting*5000/100));
            NetworthText[i].setText(String.valueOf(RadiantNetworh[i]));
            NetworthText[5+i].setText(String.valueOf(DireNetworh[i]));
        }

        latekeff.setText(String.valueOf(RadiantNetworh[0]+RadiantNetworh[1]+RadiantNetworh[2]+RadiantNetworh[3]+RadiantNetworh[4])+"vs"+
        String.valueOf(DireNetworh[0]+DireNetworh[1]+DireNetworh[2]+DireNetworh[3]+DireNetworh[4]));


        if ((RadiantNetworh[0]+RadiantNetworh[1]+RadiantNetworh[2]+RadiantNetworh[3]+RadiantNetworh[4])>(DireNetworh[0]+DireNetworh[1]+DireNetworh[2]+DireNetworh[3]+DireNetworh[4]))
        {
          LoseOrWin.setText("You Win!");
            winloose=1;
        }
        else
        {
            LoseOrWin.setText("You Lose!");
            winloose=2;
        }



        tomainstance.setVisibility(View.VISIBLE);



    }





}
