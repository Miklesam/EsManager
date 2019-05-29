package com.miklesam.dota_manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FightState extends AppCompatActivity {


    TextView Toplane;
    TextView Midlane;
    TextView Bottomlane;
    int Hero[]=new int[5];
    int Lane[]=new int[5];

    int CompHero[]=new int[5];

    ImageView TopIcon[] =new ImageView[10];
    ImageView MidIcon[] =new ImageView[5];
    ImageView BottomIcon[] =new ImageView[5];

    static ArrayList<Heroes> HeroesSpot = new ArrayList<Heroes>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_state);

        Toplane=findViewById(R.id.topline);
        Midlane=findViewById(R.id.midline);
        Bottomlane=findViewById(R.id.bottomline);
        TopIcon[0]=findViewById(R.id.top5st);
        TopIcon[1]=findViewById(R.id.top4st);
        TopIcon[2]=findViewById(R.id.top3st);
        TopIcon[3]=findViewById(R.id.top2st);
        TopIcon[4]=findViewById(R.id.top1st);

        TopIcon[5]=findViewById(R.id.top6st);
        TopIcon[6]=findViewById(R.id.top7st);
        TopIcon[7]=findViewById(R.id.top8st);
        TopIcon[8]=findViewById(R.id.top9st);
        TopIcon[9]=findViewById(R.id.top10st);

        MidIcon[0]=findViewById(R.id.mid5st);
        MidIcon[1]=findViewById(R.id.mid4st);
        MidIcon[2]=findViewById(R.id.mid3st);
        MidIcon[3]=findViewById(R.id.mid2st);
        MidIcon[4]=findViewById(R.id.mid1st);


        BottomIcon[0]=findViewById(R.id.bottom5st);
        BottomIcon[1]=findViewById(R.id.bottom4st);
        BottomIcon[2]=findViewById(R.id.bottom3st);
        BottomIcon[3]=findViewById(R.id.bottom2st);
        BottomIcon[4]=findViewById(R.id.bottom1st);


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

                CompHero[0] = 0;
                CompHero[1] = 0;
                CompHero[2] = 0;
                CompHero[3] = 0;
                CompHero[4] = 0;







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



        }

        HeroesSpot=HeroInit.HeroInit();

        Toplane.setText(String.valueOf(Hero[0])+","+String.valueOf(Lane[0]));


        int tt=0;
        int mm=0;
        int bb=0;

        for(int z=0;z<5;z++)
        {
            if (Lane[z]==1)
            {
                TopIcon[tt].setImageResource(HeroesSpot.get(Hero[z]).mipmap);
                tt++;
            }
            else if(Lane[z]==2)
            {
                MidIcon[mm].setImageResource(HeroesSpot.get(Hero[z]).mipmap);
                mm++;
            }
            else if(Lane[z]==3)
            {
                BottomIcon[bb].setImageResource(HeroesSpot.get(Hero[z]).mipmap);
                bb++;
            }
        }

        TopIcon[5].setImageResource(HeroesSpot.get(CompHero[0]).mipmap);
        TopIcon[6].setImageResource(HeroesSpot.get(CompHero[1]).mipmap);
        TopIcon[7].setImageResource(HeroesSpot.get(CompHero[2]).mipmap);
        TopIcon[8].setImageResource(HeroesSpot.get(CompHero[3]).mipmap);
        TopIcon[9].setImageResource(HeroesSpot.get(CompHero[4]).mipmap);




    }
}
