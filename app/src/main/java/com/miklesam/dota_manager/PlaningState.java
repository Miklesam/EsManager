package com.miklesam.dota_manager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.miklesam.dota_manager.HeroInit.AllHeroes;
import static com.miklesam.dota_manager.PlanersInit.AllPlanersInit;
import static com.miklesam.dota_manager.PlayersInit.AllPlayers;
import static com.miklesam.dota_manager.PlayersInit.PlayersAllInit;
import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;

public class PlaningState extends AppCompatActivity {

    int[] Hero = new int[5];
    int[] CompHero = new int[5];
    int[] Gamer = new int[5];
    ImageView[] GameHero = new ImageView[5];

    ImageView[] Top = new ImageView[5];
    ImageView[] Mid = new ImageView[5];
    ImageView[] Bottom = new ImageView[5];

    boolean toplline[]= new boolean[5];
    boolean midlline[]= new boolean[5];
    boolean bottomlline[]= new boolean[5];


    Button ToFightStage;
    int lane_id[]= new int[5];

    Spinner LineSpin[]=new Spinner[5];

    int seq_gamer[] = new int[5];

     Spinner Gamerspinner[] = new Spinner[5];

    ArrayList<Integer> CompHeroesAndLanes = new ArrayList<Integer>();
    ArrayList<Planers> TeamPlaners = new ArrayList<Planers>();
    ArrayList<Teams> AllTeamsTeams = new ArrayList<Teams>();

    ArrayList top = new ArrayList<>();
    ArrayList mid = new ArrayList<>();
    ArrayList bot = new ArrayList<>();

    int TeamEnemy;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_planing_state);
        AllTeams.clear();
        GameHero[0] = findViewById(R.id.GameHero1);
        GameHero[1] = findViewById(R.id.GameHero2);
        GameHero[2] = findViewById(R.id.GameHero3);
        GameHero[3] = findViewById(R.id.GameHero4);
        GameHero[4] = findViewById(R.id.GameHero5);
        ToFightStage=findViewById(R.id.FightStage);
        HeroInit.HeroInit();

        Bottom[0]=findViewById(R.id.bottom1);
        Bottom[1]=findViewById(R.id.bottom2);
        Bottom[2]=findViewById(R.id.bottom3);
        Bottom[3]=findViewById(R.id.bottom4);
        Bottom[4]=findViewById(R.id.bottom5);

        Mid[0]=findViewById(R.id.mid1);
        Mid[1]=findViewById(R.id.mid2);
        Mid[2]=findViewById(R.id.mid3);
        Mid[3]=findViewById(R.id.mid4);
        Mid[4]=findViewById(R.id.mid5);

        Top[0]=findViewById(R.id.top1);
        Top[1]=findViewById(R.id.top2);
        Top[2]=findViewById(R.id.top3);
        Top[3]=findViewById(R.id.top4);
        Top[4]=findViewById(R.id.top5);
        AllTeamsTeams=AllTeamsInit();
        final Intent ToFightStageActivity = new Intent(this, FightState.class);


        for (int i=0;i<AllHeroes.size();i++)
        {
            AllHeroes.get(i).baned=false;
        }

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Hero[0] = 0;
                Hero[1] = 0;
                Hero[2] = 0;
                Hero[3] = 0;
                Hero[4] = 0;
                Gamer[0] = 0;
                Gamer[1] = 0;
                Gamer[2] = 0;
                Gamer[3] = 0;
                Gamer[4] = 0;
                CompHero[0]=0;
                CompHero[1]=0;
                CompHero[2]=0;
                CompHero[3]=0;
                CompHero[4]=0;
                TeamEnemy=0;


            } else {
                Hero[0] = extras.getInt("Hero1");
                Hero[1] = extras.getInt("Hero2");
                Hero[2] = extras.getInt("Hero3");
                Hero[3] = extras.getInt("Hero4");
                Hero[4] = extras.getInt("Hero5");


                CompHero[0] = extras.getInt("CompHero1");
                CompHero[1] = extras.getInt("CompHero2");
                CompHero[2] = extras.getInt("CompHero3");
                CompHero[3] = extras.getInt("CompHero4");
                CompHero[4] = extras.getInt("CompHero5");
                TeamEnemy = extras.getInt("EnemyTeam");


                Gamer[0] = extras.getInt("Position1");
                Gamer[1] = extras.getInt("Position2");
                Gamer[2] = extras.getInt("Position3");
                Gamer[3] = extras.getInt("Position4");
                Gamer[4] = extras.getInt("Position5");

            }
        } else {
            Hero[0] = (int) savedInstanceState.getSerializable("Hero1");
            Hero[1] = (int) savedInstanceState.getSerializable("Hero2");
            Hero[2] = (int) savedInstanceState.getSerializable("Hero3");
            Hero[3] = (int) savedInstanceState.getSerializable("Hero4");
            Hero[4] = (int) savedInstanceState.getSerializable("Hero5");

            CompHero[0] = (int) savedInstanceState.getSerializable("CompHero1");
            CompHero[1] = (int) savedInstanceState.getSerializable("CompHero2");
            CompHero[2] = (int) savedInstanceState.getSerializable("CompHero3");
            CompHero[3] = (int) savedInstanceState.getSerializable("CompHero4");
            CompHero[4] = (int) savedInstanceState.getSerializable("CompHero5");

            Gamer[0] = (Integer) savedInstanceState.getSerializable("Position1");
            Gamer[1] = (Integer) savedInstanceState.getSerializable("Position2");
            Gamer[2] = (Integer) savedInstanceState.getSerializable("Position3");
            Gamer[3] = (Integer) savedInstanceState.getSerializable("Position4");
            Gamer[4] = (Integer) savedInstanceState.getSerializable("Position5");

        }

        for (int i = 0; i < 5; i++) {
            GameHero[i].setImageResource(AllHeroes.get(Hero[i]).picked);
        }



        for (int i = 0; i < 5; i++) {
            Top[i].setVisibility(View.INVISIBLE);
            Mid[i].setVisibility(View.INVISIBLE);
            Bottom[i].setVisibility(View.INVISIBLE);
        }







        Gamerspinner[0] = (Spinner) findViewById(R.id.Spiner1);
        Gamerspinner[1] = (Spinner) findViewById(R.id.Spiner2);
        Gamerspinner[2] = (Spinner) findViewById(R.id.Spiner3);
        Gamerspinner[3] = (Spinner) findViewById(R.id.Spiner4);
        Gamerspinner[4] = (Spinner) findViewById(R.id.Spiner5);

        final Spinner Lanespinner1 = (Spinner) findViewById(R.id.LineSpiner1);
        final Spinner Lanespinner2 = (Spinner) findViewById(R.id.LineSpiner2);
        final Spinner Lanespinner3 = (Spinner) findViewById(R.id.LineSpiner3);
        final Spinner Lanespinner4 = (Spinner) findViewById(R.id.LineSpiner4);
        final Spinner Lanespinner5 = (Spinner) findViewById(R.id.LineSpiner5);

        LineSpin[0]=Lanespinner1;
        LineSpin[1]=Lanespinner2;
        LineSpin[2]=Lanespinner3;
        LineSpin[3]=Lanespinner4;
        LineSpin[4]=Lanespinner5;
        TeamPlaners=AllPlanersInit();
        PlayersAllInit();

        CompHeroesAndLanes=TeamPlaners.get(TeamEnemy).Plane(CompHero[0],CompHero[1],CompHero[2],CompHero[3],CompHero[4]);


        String[] data = {AllPlayers.get(Gamer[0]).Name, AllPlayers.get(Gamer[1]).Name, AllPlayers.get(Gamer[2]).Name, AllPlayers.get(Gamer[3]).Name, AllPlayers.get(Gamer[4]).Name};
        String[] Lane = {"top", "mid", "bottom"};




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> Laneadapter = new ArrayAdapter<String>(this, R.layout.spinner_item, Lane);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for(int i=0;i<5;i++)
        {
            Gamerspinner[i].setAdapter(adapter);
            Gamerspinner[i].setSelection(i);

            final int finalI = i;
            Gamerspinner[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    seq_gamer[finalI]=Gamer[position];
                }


                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
        }


        Lanespinner1.setAdapter(Laneadapter);
        Lanespinner1.setSelection(0);

        Lanespinner2.setAdapter(Laneadapter);
        Lanespinner2.setSelection(1);

        Lanespinner3.setAdapter(Laneadapter);
        Lanespinner3.setSelection(2);

        Lanespinner4.setAdapter(Laneadapter);
        Lanespinner4.setSelection(2);

        Lanespinner5.setAdapter(Laneadapter);
        Lanespinner5.setSelection(2);




       top.add(Hero[0]);
       mid.add(Hero[1]);
       bot.add(Hero[2]);
       bot.add(Hero[3]);
       bot.add(Hero[4]);

        for (int i = 0; i < top.size(); i++) {
            Top[i].setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < mid.size(); i++) {
            Mid[i].setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < bot.size(); i++) {
            Bottom[i].setVisibility(View.VISIBLE);
        }







for(int k=0;k<5;k++)
{
    final int finalK = k;

    LineSpin[k].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {

            for(int i=0;i<top.size();i++)
            {
                if((Integer) top.get(i)==Hero[finalK])
                {
                    top.remove(i);
                }
                if((Integer) mid.get(i)==Hero[finalK])
                {
                    mid.remove(i);
                }
                if((Integer) bot.get(i)==Hero[finalK])
                {
                    bot.remove(i);
                }
            }


            if (position==0)
            {
                top.add(Hero[finalK]);
            }
            else if (position==1)
            {
                mid.add(Hero[finalK]);
            }
            else if (position==2)
            {
                bot.add(Hero[finalK]);
            }





            for (int i=0;i<top.size();i++){
                Top[i].setImageResource(AllHeroes.get((Integer) top.get(i)).mipmap);
            }
            for (int i=0;i<mid.size();i++){
                Mid[i].setImageResource(AllHeroes.get((Integer) mid.get(i)).mipmap);
            }
            for (int i=0;i<top.size();i++){
                Bottom[i].setImageResource(AllHeroes.get((Integer) bot.get(i)).mipmap);
            }


            for (int i = 0; i < top.size(); i++) {
                Top[i].setVisibility(View.VISIBLE);
            }
            for (int i = 0; i < mid.size(); i++) {
                Mid[i].setVisibility(View.VISIBLE);
            }
            for (int i = 0; i < bot.size(); i++) {
                Bottom[i].setVisibility(View.VISIBLE);
            }








        }


        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    });
}





        ToFightStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ToFightStageActivity.putExtra("Hero1",Hero[0]);
                ToFightStageActivity.putExtra("Hero2",Hero[1]);
                ToFightStageActivity.putExtra("Hero3",Hero[2]);
                ToFightStageActivity.putExtra("Hero4",Hero[3]);
                ToFightStageActivity.putExtra("Hero5",Hero[4]);

                ToFightStageActivity.putExtra("Lane1",lane_id[0]);
                ToFightStageActivity.putExtra("Lane2",lane_id[1]);
                ToFightStageActivity.putExtra("Lane3",lane_id[2]);
                ToFightStageActivity.putExtra("Lane4",lane_id[3]);
                ToFightStageActivity.putExtra("Lane5",lane_id[4]);

                ToFightStageActivity.putExtra("Gamer1",seq_gamer[0]);
                ToFightStageActivity.putExtra("Gamer2",seq_gamer[1]);
                ToFightStageActivity.putExtra("Gamer3",seq_gamer[2]);
                ToFightStageActivity.putExtra("Gamer4",seq_gamer[3]);
                ToFightStageActivity.putExtra("Gamer5",seq_gamer[4]);


                ToFightStageActivity.putExtra("CompHero1",CompHero[0]);
                ToFightStageActivity.putExtra("CompHero2",CompHero[1]);
                ToFightStageActivity.putExtra("CompHero3",CompHero[2]);
                ToFightStageActivity.putExtra("CompHero4",CompHero[3]);
                ToFightStageActivity.putExtra("CompHero5",CompHero[4]);


                ToFightStageActivity.putExtra("CompLane1",CompHeroesAndLanes.get(0));
                ToFightStageActivity.putExtra("CompLane2",CompHeroesAndLanes.get(1));
                ToFightStageActivity.putExtra("CompLane3",CompHeroesAndLanes.get(2));
                ToFightStageActivity.putExtra("CompLane4",CompHeroesAndLanes.get(3));
                ToFightStageActivity.putExtra("CompLane5",CompHeroesAndLanes.get(4));


                ToFightStageActivity.putExtra("CompGamer1",AllTeamsTeams.get(TeamEnemy).Players.get(0).sequence);
                ToFightStageActivity.putExtra("CompGamer2",AllTeamsTeams.get(TeamEnemy).Players.get(3).sequence);
                ToFightStageActivity.putExtra("CompGamer3",AllTeamsTeams.get(TeamEnemy).Players.get(4).sequence);
                ToFightStageActivity.putExtra("CompGamer4",AllTeamsTeams.get(TeamEnemy).Players.get(1).sequence);
                ToFightStageActivity.putExtra("CompGamer5",AllTeamsTeams.get(TeamEnemy).Players.get(2).sequence);

                AllHeroes.clear();
              startActivity(ToFightStageActivity);

            }
        });







    }

}
