package com.miklesam.dota_manager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.miklesam.dota_manager.HeroInit.Abadon;
import static com.miklesam.dota_manager.HeroInit.Alchemic;

public class Pick_Stage extends AppCompatActivity {

    TextView Pick_Stage;
    public static boolean had_choosen;
    boolean abadon_ban;
    boolean alcemic_ban;
    final ImageView Pick_stage[]= new ImageView[22];
    ImageView Heros_icon[] = new ImageView[30];
    int pick_state;
    Button Plan_state;
    int[] what_hero = new int[5];
    int k=0;


    ArrayList <Heroes> HeroList= new ArrayList <Heroes>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pick__stage);
        Plan_state=findViewById(R.id.Plan_state);
        HeroList.addAll(HeroInit.HeroInit());

        final Intent PlaningState = new Intent(this, PlaningState.class);
        pick_state=0;









        final String Pos1;
        final String Pos2;
        final String Pos3;
        final String Pos4;
        final String Pos5;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                Pos1= null;
                Pos2= null;
                Pos3= null;
                Pos4= null;
                Pos5= null;


            } else {
                Pos1= extras.getString("Position1");
                Pos2= extras.getString("Position2");
                Pos3= extras.getString("Position3");
                Pos4= extras.getString("Position4");
                Pos5= extras.getString("Position5");

            }
        } else {
            Pos1= (String) savedInstanceState.getSerializable("Position1");
            Pos2= (String) savedInstanceState.getSerializable("Position2");
            Pos3= (String) savedInstanceState.getSerializable("Position3");
            Pos4= (String) savedInstanceState.getSerializable("Position4");
            Pos5= (String) savedInstanceState.getSerializable("Position5");

        }


        Pick_Stage=findViewById(R.id.Pick_Stage);
        Heros_icon[0] = findViewById(R.id.Abadon);
        Heros_icon[1] = findViewById(R.id.Alcemic);
        Heros_icon[2] = findViewById(R.id.Axe);
        Heros_icon[3] = findViewById(R.id.Beastmaster);
        Heros_icon[4] = findViewById(R.id.Brewmaster);
        Heros_icon[5] = findViewById(R.id.Bristleback);
        Heros_icon[6] = findViewById(R.id.Centaur);
        Heros_icon[7] = findViewById(R.id.Chaos);
        Heros_icon[8] = findViewById(R.id.Clockwerk);
        Heros_icon[9] = findViewById(R.id.Doom);


        Heros_icon[10] = findViewById(R.id.DK);
        Heros_icon[11] = findViewById(R.id.EarthSpirit);
        Heros_icon[12] = findViewById(R.id.EarthShaker);
        Heros_icon[13] = findViewById(R.id.ElderTitan);
        Heros_icon[14] = findViewById(R.id.Huskar);
        Heros_icon[15] = findViewById(R.id.Io);
        Heros_icon[16] = findViewById(R.id.Kunnka);
        Heros_icon[17] = findViewById(R.id.LC);
        Heros_icon[18] = findViewById(R.id.Lifestealer);
        Heros_icon[19] = findViewById(R.id.Lycan);



        Heros_icon[20] = findViewById(R.id.Magnus);
        Heros_icon[21] = findViewById(R.id.NS);
        Heros_icon[22] = findViewById(R.id.Omniknight);
        Heros_icon[23] = findViewById(R.id.Phoenix);
        Heros_icon[24] = findViewById(R.id.Pudge);
        Heros_icon[25] = findViewById(R.id.SandKing);
        Heros_icon[26] = findViewById(R.id.Slardar);
        Heros_icon[27] = findViewById(R.id.SpiritBreaker);
        Heros_icon[28] = findViewById(R.id.Sven);
        Heros_icon[29] = findViewById(R.id.Tidehunter);



        Pick_stage[0] = findViewById(R.id.ban1);
        Pick_stage[1] = findViewById(R.id.ban2);
        Pick_stage[2] = findViewById(R.id.ban3);
        Pick_stage[3] = findViewById(R.id.ban4);
        Pick_stage[4] = findViewById(R.id.ban5);
        Pick_stage[5] = findViewById(R.id.ban6);
        Pick_stage[6] = findViewById(R.id.pick1);
        Pick_stage[7] = findViewById(R.id.pick2);
        Pick_stage[8] = findViewById(R.id.pick3);
        Pick_stage[9] = findViewById(R.id.pick4);
        Pick_stage[11] = findViewById(R.id.ban7);
        Pick_stage[10] = findViewById(R.id.ban8);

        Pick_stage[13]= findViewById(R.id.ban9);
        Pick_stage[12] = findViewById(R.id.ban10);
        Pick_stage[14] = findViewById(R.id.pick5);
        Pick_stage[15] = findViewById(R.id.pick6);
        Pick_stage[16] = findViewById(R.id.pick7);
        Pick_stage[17] = findViewById(R.id.pick8);
        Pick_stage[19] = findViewById(R.id.ban11);
        Pick_stage[18] = findViewById(R.id.ban12);
        Pick_stage[20] = findViewById(R.id.pick9);
        Pick_stage[21] = findViewById(R.id.pick10);

        Heros_icon[0].setImageResource(R.drawable.abadon_icon);
        Heros_icon[1].setImageResource(R.drawable.alchemic_icon);
        Heros_icon[2].setImageResource(R.drawable.axe_icon);
        Heros_icon[3].setImageResource(R.drawable.beastmater_icon);
        Heros_icon[4].setImageResource(R.drawable.brewmaster_icon);
        Heros_icon[5].setImageResource(R.drawable.bristleback_icon);
        Heros_icon[6].setImageResource(R.drawable.centaur_icon);
        Heros_icon[7].setImageResource(R.drawable.chaos_icon);
        Heros_icon[8].setImageResource(R.drawable.clockwerk_icon);
        Heros_icon[9].setImageResource(R.drawable.doom_icon);

        Heros_icon[10].setImageResource(R.drawable.dk_icon);
        Heros_icon[11].setImageResource(R.drawable.earth_spirit_icon);
        Heros_icon[12].setImageResource(R.drawable.eartshaker_icon);
        Heros_icon[13].setImageResource(R.drawable.eldertitan_icon);
        Heros_icon[14].setImageResource(R.drawable.huskar_icon);
        Heros_icon[15].setImageResource(R.drawable.io_icon);
        Heros_icon[16].setImageResource(R.drawable.kunnka_icon);
        Heros_icon[17].setImageResource(R.drawable.lc_icon);
        Heros_icon[18].setImageResource(R.drawable.lifestealer_icon);
        Heros_icon[19].setImageResource(R.drawable.lycan_icon);



        Heros_icon[20].setImageResource(R.drawable.magnus_icon);
        Heros_icon[21].setImageResource(R.drawable.night_stalker_icon);
        Heros_icon[22].setImageResource(R.drawable.omniknight_icon);
        Heros_icon[23].setImageResource(R.drawable.phoenix_icon);
        Heros_icon[24].setImageResource(R.drawable.pudge_icon);
        Heros_icon[25].setImageResource(R.drawable.sand_king_icon);
        Heros_icon[26].setImageResource(R.drawable.slardar_icon);
        Heros_icon[27].setImageResource(R.drawable.spirit_breaker_icon);
        Heros_icon[28].setImageResource(R.drawable.sven_icon);
        Heros_icon[29].setImageResource(R.drawable.tidehunter_icon);

        //for (int i=0;i<12;i++)
        //{
        //    Pick_stage[i].setImageResource(R.drawable.ban);
       // }

        //for (int i=12;i<22;i++)
        //{
       //     Pick_stage[i].setImageResource(R.drawable.pick);
       // }




        Plan_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PlaningState.putExtra("Hero1",what_hero[0]);
                PlaningState.putExtra("Hero2",what_hero[1]);
                PlaningState.putExtra("Hero3",what_hero[2]);
                PlaningState.putExtra("Hero4",what_hero[3]);
                PlaningState.putExtra("Hero5",what_hero[4]);

                PlaningState.putExtra("Position1",Pos1);
                PlaningState.putExtra("Position2",Pos2);
                PlaningState.putExtra("Position3",Pos3);
                PlaningState.putExtra("Position4",Pos4);
                PlaningState.putExtra("Position5",Pos5);


                startActivity(PlaningState);

            }
        });


        Pick_Stage_stam();





        for (int i=0;i<30;i++)
        {

            final int finalI = i;
            Heros_icon[i].setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {


                                                     if (HeroInit.AllHeroes.get(finalI).baned == false) {

                                                         if (pick_state< 6) {
                                                             Pick_stage[pick_state].setImageResource(HeroInit.AllHeroes.get(finalI).minban);
                                                         } else if ((pick_state > 5) && (pick_state < 10)) {

                                                             Pick_stage[pick_state].setImageResource(HeroInit.AllHeroes.get(finalI).picked);
                                                             what_hero[k]=HeroInit.AllHeroes.get(finalI).seq;
                                                             k++;
                                                         } else if ((pick_state > 9) && (pick_state < 14)) {
                                                             Pick_stage[pick_state].setImageResource(HeroInit.AllHeroes.get(finalI).minban);
                                                         } else if ((pick_state > 13) && (pick_state < 18)) {
                                                             Pick_stage[pick_state].setImageResource(HeroInit.AllHeroes.get(finalI).picked);
                                                             what_hero[k]=HeroInit.AllHeroes.get(finalI).seq;
                                                             k++;
                                                         } else if ((pick_state > 17) && (pick_state < 20)) {
                                                             Pick_stage[pick_state].setImageResource(HeroInit.AllHeroes.get(finalI).minban);
                                                         } else if ((pick_state > 19) && (pick_state < 22)) {
                                                             Pick_stage[pick_state].setImageResource(HeroInit.AllHeroes.get(finalI).picked);
                                                             what_hero[k]=HeroInit.AllHeroes.get(finalI).seq;
                                                             k++;
                                                         }

                                                         pick_state++;
                                                         HeroInit.AllHeroes.get(finalI).baned=true;
                                                         HeroList.remove(HeroInit.AllHeroes.get(finalI));
                                                         Heros_icon[finalI].setImageResource(HeroInit.AllHeroes.get(finalI).largeban);
                                                         Pick_Stage_stam();

                                                     }

                                                     else {
                                                         Toast toast = Toast.makeText(getApplicationContext(),
                                                                 "Забанен", Toast.LENGTH_SHORT);
                                                         toast.show();

                                                     }


                                                 }

                                             });
        }










        }



        protected void Pick_Stage_stam()
        {
            Random randomhero = new Random();
            int whathero=0;
            if(HeroList.size()!=0)
            {
                whathero=randomhero.nextInt(HeroList.size());

            }

            Pick_Stage.setText("Stage"+" "+String.valueOf(pick_state+1));
            if((pick_state==1)||(pick_state==3)||(pick_state==5)||(pick_state==10)||(pick_state==12)||(pick_state==18))
            {
                Pick_stage[pick_state].setImageResource(HeroList.get(whathero).minban);
                HeroList.get(whathero).baned=true;
                Heros_icon[HeroList.get(whathero).seq].setImageResource(HeroList.get(whathero).largeban);
                HeroList.remove(whathero);
                pick_state++;

            }
            else if ((pick_state==7))
            {
                Pick_stage[pick_state].setImageResource(HeroList.get(whathero).picked);
                HeroList.get(whathero).baned=true;
                Heros_icon[HeroList.get(whathero).seq].setImageResource(HeroList.get(whathero).largeban);
                HeroList.remove(whathero);
                pick_state++;
                if(HeroList.size()!=0)
                {
                    whathero=randomhero.nextInt(HeroList.size());

                }
                Pick_stage[pick_state].setImageResource(HeroList.get(whathero).picked);
                HeroList.get(whathero).baned=true;
                Heros_icon[HeroList.get(whathero).seq].setImageResource(HeroList.get(whathero).largeban);
                HeroList.remove(whathero);
                pick_state++;



            }

            else if ((pick_state==14)||(pick_state==16)||(pick_state==21))
            {
                Pick_stage[pick_state].setImageResource(HeroList.get(whathero).picked);
                HeroList.get(whathero).baned=true;
                Heros_icon[HeroList.get(whathero).seq].setImageResource(HeroList.get(whathero).largeban);
                HeroList.remove(whathero);
                pick_state++;
            }




        }









    }







