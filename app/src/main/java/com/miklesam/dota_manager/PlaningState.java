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

public class PlaningState extends AppCompatActivity {

    int[] Hero = new int[5];
    int[] CompHero = new int[5];
    String[] Gamer = new String[5];
    ImageView[] GameHero = new ImageView[5];

    ImageView[] Top = new ImageView[5];
    ImageView[] Mid = new ImageView[5];
    ImageView[] Bottom = new ImageView[5];

    boolean toplline[]= new boolean[5];
    boolean midlline[]= new boolean[5];
    boolean bottomlline[]= new boolean[5];

    int bothero[]=new int[5];
    int midhero[]=new int[5];
    int tophero[]=new int[5];
    Button ToFightStage;
    int lane_id[]= new int[5];

    Spinner LineSpin[]=new Spinner[5];

    ArrayList<Integer> CompHeroesAndLanes = new ArrayList<Integer>();
    ArrayList<Planers> TeamPlaners = new ArrayList<Planers>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_planing_state);

        GameHero[0] = findViewById(R.id.GameHero1);
        GameHero[1] = findViewById(R.id.GameHero2);
        GameHero[2] = findViewById(R.id.GameHero3);
        GameHero[3] = findViewById(R.id.GameHero4);
        GameHero[4] = findViewById(R.id.GameHero5);
        ToFightStage=findViewById(R.id.FightStage);

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

        final Intent ToFightStageActivity = new Intent(this, FightState.class);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Hero[0] = 0;
                Hero[1] = 0;
                Hero[2] = 0;
                Hero[3] = 0;
                Hero[4] = 0;
                Gamer[0] = null;
                Gamer[1] = null;
                Gamer[2] = null;
                Gamer[3] = null;
                Gamer[4] = null;
                CompHero[0]=0;
                CompHero[1]=0;
                CompHero[2]=0;
                CompHero[3]=0;
                CompHero[4]=0;


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

                Gamer[0] = extras.getString("Position1");
                Gamer[1] = extras.getString("Position2");
                Gamer[2] = extras.getString("Position3");
                Gamer[3] = extras.getString("Position4");
                Gamer[4] = extras.getString("Position5");

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

            Gamer[0] = (String) savedInstanceState.getSerializable("Position1");
            Gamer[1] = (String) savedInstanceState.getSerializable("Position2");
            Gamer[2] = (String) savedInstanceState.getSerializable("Position3");
            Gamer[3] = (String) savedInstanceState.getSerializable("Position4");
            Gamer[4] = (String) savedInstanceState.getSerializable("Position5");

        }

        for (int i = 0; i < 5; i++) {
            GameHero[i].setImageResource(AllHeroes.get(Hero[i]).picked);
        }



        for (int i = 0; i < 5; i++) {
            Top[i].setVisibility(View.INVISIBLE);
            Mid[i].setVisibility(View.INVISIBLE);
            Bottom[i].setVisibility(View.INVISIBLE);
        }







        final Spinner spinner1 = (Spinner) findViewById(R.id.Spiner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.Spiner2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.Spiner3);
        final Spinner spinner4 = (Spinner) findViewById(R.id.Spiner4);
        final Spinner spinner5 = (Spinner) findViewById(R.id.Spiner5);

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
        CompHeroesAndLanes=TeamPlaners.get(0).Plane(CompHero[0],CompHero[1],CompHero[2],CompHero[3],CompHero[4]);


        String[] data = {String.valueOf(Hero[0]), String.valueOf(Hero[1]), String.valueOf(Hero[2]), String.valueOf(Hero[3]), String.valueOf(Hero[4])};
        String[] Lane = {"top", "mid", "bottom"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, Gamer);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> Laneadapter = new ArrayAdapter<String>(this, R.layout.spinner_item, Lane);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setAdapter(adapter);
        //spinner.setPrompt("Title");
        spinner1.setSelection(0);

        spinner2.setAdapter(adapter);
        spinner2.setSelection(1);

        spinner3.setAdapter(adapter);
        spinner3.setSelection(2);

        spinner4.setAdapter(adapter);
        spinner4.setSelection(3);

        spinner5.setAdapter(adapter);
        spinner5.setSelection(4);

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




        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {


                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


for(int k=0;k<5;k++)
{
    final int finalK = k;

    LineSpin[k].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {


            // показываем позиция нажатого элемента
            Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            if (position==0)
            {
                lane_id[finalK]=1;

                //Top[0].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                // Top[0].setVisibility(View.VISIBLE);
                for(int i=0;i<5;i++)
                {
                    if(midhero[i]==Hero[finalK])
                    {
                        Mid[i].setVisibility(View.INVISIBLE);
                        midlline[i]=false;
                    }
                    else if(bothero[i]==Hero[finalK])
                    {
                        Bottom[i].setVisibility(View.INVISIBLE);
                        bottomlline[i]=false;
                    }

                }

                if(toplline[0]==false)
                {
                    Top[0].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Top[0].setVisibility(View.VISIBLE);
                    toplline[0]=true;
                    tophero[0]=Hero[finalK];
                }
                else if(toplline[1]==false)
                {
                    Top[1].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Top[1].setVisibility(View.VISIBLE);
                    toplline[1]=true;
                    tophero[1]=Hero[finalK];
                }
                else if(toplline[2]==false)
                {
                    Top[2].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Top[2].setVisibility(View.VISIBLE);
                    toplline[2]=true;
                    tophero[2]=Hero[finalK];
                }
                else if(toplline[3]==false)
                {
                    Top[3].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Top[3].setVisibility(View.VISIBLE);
                    toplline[3]=true;
                    tophero[3]=Hero[finalK];
                }

                else if(toplline[4]==false)
                {
                    Top[4].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Top[4].setVisibility(View.VISIBLE);
                    toplline[4]=true;
                    tophero[4]=Hero[finalK];
                }








            }
            else if (position==1)
            {
                lane_id[finalK]=2;
                for(int i=0;i<5;i++)
                {
                    if(bothero[i]==Hero[finalK])
                    {
                        Bottom[i].setVisibility(View.INVISIBLE);
                        bottomlline[i]=false;
                    }
                    else if(tophero[i]==Hero[finalK])
                    {
                        Top[i].setVisibility(View.INVISIBLE);
                        toplline[i]=false;
                    }

                }

                if(midlline[0]==false)
                {
                    Mid[0].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Mid[0].setVisibility(View.VISIBLE);
                    midlline[0]=true;
                    midhero[0]=Hero[finalK];
                }
                else if(midlline[1]==false)
                {
                    Mid[1].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Mid[1].setVisibility(View.VISIBLE);
                    midlline[1]=true;
                    midhero[1]=Hero[finalK];
                }
                else if(midlline[2]==false)
                {
                    Mid[2].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Mid[2].setVisibility(View.VISIBLE);
                    midlline[2]=true;
                    midhero[2]=Hero[finalK];
                }
                else if(midlline[3]==false)
                {
                    Mid[3].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Mid[3].setVisibility(View.VISIBLE);
                    midlline[3]=true;
                    midhero[3]=Hero[finalK];
                }

                else if(midlline[4]==false)
                {
                    Mid[4].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Mid[4].setVisibility(View.VISIBLE);
                    midlline[4]=true;
                    midhero[4]=Hero[finalK];
                }


            }
            else if (position==2)
            {
                lane_id[finalK]=3;
                for(int i=0;i<5;i++)
                {
                    if(midhero[i]==Hero[finalK])
                    {
                        Mid[i].setVisibility(View.INVISIBLE);
                        midlline[i]=false;
                    }

                    else if(tophero[i]==Hero[finalK])
                    {
                        Top[i].setVisibility(View.INVISIBLE);
                        toplline[i]=false;
                    }

                }

                if(bottomlline[0]==false)
                {
                    Bottom[0].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Bottom[0].setVisibility(View.VISIBLE);
                    bottomlline[0]=true;
                    bothero[0]=Hero[finalK];
                }
                else if(bottomlline[1]==false)
                {
                    Bottom[1].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Bottom[1].setVisibility(View.VISIBLE);
                    bottomlline[1]=true;
                    bothero[1]=Hero[finalK];
                }
                else if(bottomlline[2]==false)
                {
                    Bottom[2].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Bottom[2].setVisibility(View.VISIBLE);
                    bottomlline[2]=true;
                    bothero[2]=Hero[finalK];
                }
                else if(bottomlline[3]==false)
                {
                    Bottom[3].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Bottom[3].setVisibility(View.VISIBLE);
                    bottomlline[3]=true;
                    bothero[3]=Hero[finalK];
                }

                else if(bottomlline[4]==false)
                {
                    Bottom[4].setImageResource(AllHeroes.get(Hero[finalK]).mipmap);
                    Bottom[4].setVisibility(View.VISIBLE);
                    bottomlline[4]=true;
                    bothero[4]=Hero[finalK];
                }
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


              startActivity(ToFightStageActivity);

            }
        });







    }

}
