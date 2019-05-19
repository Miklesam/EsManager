package com.miklesam.dota_manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    ImageView Heros_icon[] = new ImageView[7];


    ArrayList <Heroes> HeroList= new ArrayList <Heroes>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick__stage);

        HeroList.addAll(HeroInit.HeroInit());

        Thread t = new Thread(new Threadstage());
        t.start();

        Pick_Stage=findViewById(R.id.Pick_Stage);
        Heros_icon[0] = findViewById(R.id.Abadon);
        Heros_icon[1] = findViewById(R.id.Alcemic);
        Heros_icon[2] = findViewById(R.id.Axe);
        Heros_icon[3] = findViewById(R.id.Beastmaster);
        Heros_icon[4] = findViewById(R.id.Brewmaster);
        Heros_icon[5] = findViewById(R.id.Bristleback);
        Heros_icon[6] = findViewById(R.id.Centaur);
        ImageView Chaos = findViewById(R.id.Chaos);
        ImageView Clockwerk = findViewById(R.id.Clockwerk);
        ImageView Doom = findViewById(R.id.Doom);


        ImageView DK_Icon = findViewById(R.id.DK);
        ImageView EarthSpirit_Icon = findViewById(R.id.EarthSpirit);
        ImageView EarthShaker_Icon = findViewById(R.id.EarthShaker);
        ImageView ElderTitan_Icon = findViewById(R.id.ElderTitan);
        ImageView Huskar = findViewById(R.id.Huskar);
        ImageView IO = findViewById(R.id.Io);
        ImageView Kunnka = findViewById(R.id.Kunnka);
        ImageView LC = findViewById(R.id.LC);
        ImageView Lifestealer = findViewById(R.id.Lifestealer);
        ImageView Lycan = findViewById(R.id.Lycan);



        ImageView Magnus = findViewById(R.id.Magnus);
        ImageView NS = findViewById(R.id.NS);
        ImageView Omniknight = findViewById(R.id.Omniknight);
        ImageView Phoenix = findViewById(R.id.Phoenix);
        ImageView Pudge = findViewById(R.id.Pudge);
        ImageView SandKing = findViewById(R.id.SandKing);
        ImageView Slardar = findViewById(R.id.Slardar);
        ImageView SpiritBreaker = findViewById(R.id.SpiritBreaker);
        ImageView Sven = findViewById(R.id.Sven);
        ImageView Tidehunter = findViewById(R.id.Tidehunter);



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
        Pick_stage[10] = findViewById(R.id.ban7);
        Pick_stage[11] = findViewById(R.id.ban8);

        Pick_stage[12]= findViewById(R.id.ban9);
        Pick_stage[13] = findViewById(R.id.ban10);
        Pick_stage[14] = findViewById(R.id.pick5);
        Pick_stage[15] = findViewById(R.id.pick6);
        Pick_stage[16] = findViewById(R.id.pick7);
        Pick_stage[17] = findViewById(R.id.pick8);
        Pick_stage[18] = findViewById(R.id.ban11);
        Pick_stage[19] = findViewById(R.id.ban12);
        Pick_stage[20] = findViewById(R.id.pick9);
        Pick_stage[21] = findViewById(R.id.pick10);

        Heros_icon[0].setImageResource(R.drawable.abadon_icon);
        Heros_icon[1].setImageResource(R.drawable.alchemic_icon);
        Heros_icon[2].setImageResource(R.drawable.axe_icon);
        Heros_icon[3].setImageResource(R.drawable.beastmater_icon);
        Heros_icon[4].setImageResource(R.drawable.brewmaster_icon);
        Heros_icon[5].setImageResource(R.drawable.bristleback_icon);
        Heros_icon[6].setImageResource(R.drawable.centaur_icon);
        Chaos.setImageResource(R.drawable.chaos_icon);
        Clockwerk.setImageResource(R.drawable.clockwerk_icon);
        Doom.setImageResource(R.drawable.doom_icon);

        DK_Icon.setImageResource(R.drawable.dk_icon);
        EarthSpirit_Icon.setImageResource(R.drawable.earth_spirit_icon);
        EarthShaker_Icon.setImageResource(R.drawable.eartshaker_icon);
        ElderTitan_Icon.setImageResource(R.drawable.eldertitan_icon);
        Huskar.setImageResource(R.drawable.huskar_icon);
        IO.setImageResource(R.drawable.io_icon);
        Kunnka.setImageResource(R.drawable.kunnka_icon);
        LC.setImageResource(R.drawable.lc_icon);
        Lifestealer.setImageResource(R.drawable.lifestealer_icon);
        Lycan.setImageResource(R.drawable.lycan_icon);



        Magnus.setImageResource(R.drawable.magnus_icon);
        NS.setImageResource(R.drawable.night_stalker_icon);
        Omniknight.setImageResource(R.drawable.omniknight_icon);
        Phoenix.setImageResource(R.drawable.phoenix_icon);
        Pudge.setImageResource(R.drawable.pudge_icon);
        SandKing.setImageResource(R.drawable.sand_king_icon);
        Slardar.setImageResource(R.drawable.slardar_icon);
        SpiritBreaker.setImageResource(R.drawable.spirit_breaker_icon);
        Sven.setImageResource(R.drawable.sven_icon);
        Tidehunter.setImageResource(R.drawable.tidehunter_icon);

        for (int i=0;i<12;i++)
        {
            Pick_stage[i].setImageResource(R.drawable.ban);
        }

        for (int i=12;i<22;i++)
        {
            Pick_stage[i].setImageResource(R.drawable.pick);
        }



        Pick_Stage_stam();





        for (int i=0;i<7;i++)
        {

            final int finalI = i;
            Heros_icon[i].setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {


                                                     if (HeroInit.AllHeroes.get(finalI).baned == false) {

                                                         if (Threadstage.cnt < 6) {
                                                             Pick_stage[Threadstage.cnt].setImageResource(HeroInit.AllHeroes.get(finalI).minban);
                                                         } else if ((Threadstage.cnt > 5) && (Threadstage.cnt < 10)) {
                                                             Pick_stage[Threadstage.cnt].setImageResource(HeroInit.AllHeroes.get(finalI).picked);
                                                         } else if ((Threadstage.cnt > 9) && (Threadstage.cnt < 14)) {
                                                             Pick_stage[Threadstage.cnt].setImageResource(HeroInit.AllHeroes.get(finalI).minban);
                                                         } else if ((Threadstage.cnt > 13) && (Threadstage.cnt < 18)) {
                                                             Pick_stage[Threadstage.cnt].setImageResource(HeroInit.AllHeroes.get(finalI).picked);
                                                         } else if ((Threadstage.cnt > 17) && (Threadstage.cnt < 20)) {
                                                             Pick_stage[Threadstage.cnt].setImageResource(HeroInit.AllHeroes.get(finalI).minban);
                                                         } else if ((Threadstage.cnt > 19) && (Threadstage.cnt < 22)) {
                                                             Pick_stage[Threadstage.cnt].setImageResource(HeroInit.AllHeroes.get(finalI).picked);
                                                         }

                                                         had_choosen=true;
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

            Pick_Stage.setText("Stage"+" "+String.valueOf(Threadstage.cnt+1));
            if((Threadstage.cnt==1)||(Threadstage.cnt==3)||(Threadstage.cnt==5))
            {
                Pick_stage[Threadstage.cnt].setImageResource(HeroList.get(whathero).minban);
                HeroList.get(whathero).baned=true;
                Heros_icon[HeroList.get(whathero).seq].setImageResource(HeroList.get(whathero).largeban);
                HeroList.remove(whathero);
                had_choosen=true;

            }



        }







    }







