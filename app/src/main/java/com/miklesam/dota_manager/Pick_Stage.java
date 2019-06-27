package com.miklesam.dota_manager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
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
import static com.miklesam.dota_manager.HeroInit.AllHeroes;
import static com.miklesam.dota_manager.PickersInit.AllPickers;
import static com.miklesam.dota_manager.PickersInit.AllPickersInit;
import static com.miklesam.dota_manager.PickersInit.EmpirePickerMan;
import static com.miklesam.dota_manager.TeamsInit.AllTeams;

public class Pick_Stage extends AppCompatActivity {

    TextView Pick_Stage;
    public static boolean had_choosen;

    final ImageView Pick_stage[]= new ImageView[22];
    ImageView Heros_icon[] = new ImageView[117];
    int pick_state;
    Button Plan_state;
    int[] what_hero = new int[5];
    int[] comp_hero = new int[5];
    int k=0;
    TextView HelpText;
    CountDownTimer Mytimer;
    CountDownTimer Enemytimer;
    String TeamName;
    String EnemyName;

    TextView YourTeamName;
    TextView EnemyteamNamet;
    int frompicker;
    int TeamEnemy;
    boolean youlocked;

    ArrayList <Heroes> HeroList= new ArrayList <Heroes>();
    ArrayList <Pickers> PickerList= new ArrayList <Pickers>();

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pick__stage);
        Plan_state=findViewById(R.id.Plan_state);
        Plan_state.setVisibility(View.INVISIBLE);
        AllHeroes.clear();
        HeroList.addAll(HeroInit.HeroInit());
        YourTeamName=findViewById(R.id.Yourteam);
        EnemyteamNamet=findViewById(R.id.EnemyteamName);
        final Intent PlaningState = new Intent(this, PlaningState.class);
        pick_state=0;

        HelpText=findViewById(R.id.Help);







        final int Pos1;
        final int Pos2;
        final int Pos3;
        final int Pos4;
        final int Pos5;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                Pos1= 0;
                Pos2= 0;
                Pos3= 0;
                Pos4= 0;
                Pos5= 0;

                TeamEnemy=0;
                TeamName=null;
                EnemyName=null;

            } else {
                Pos1= extras.getInt("Position1");
                Pos2= extras.getInt("Position2");
                Pos3= extras.getInt("Position3");
                Pos4= extras.getInt("Position4");
                Pos5= extras.getInt("Position5");
                TeamEnemy= extras.getInt("EnemyTeam");
                TeamName=extras.getString("TeamName");
                EnemyName=extras.getString("TeamEnemy");


            }
        } else {
            Pos1= (Integer) savedInstanceState.getSerializable("Position1");
            Pos2= (Integer) savedInstanceState.getSerializable("Position2");
            Pos3= (Integer) savedInstanceState.getSerializable("Position3");
            Pos4= (Integer) savedInstanceState.getSerializable("Position4");
            Pos5= (Integer) savedInstanceState.getSerializable("Position5");
            TeamName= (String) savedInstanceState.getSerializable("TeamName");
            EnemyName= (String) savedInstanceState.getSerializable("TeamEnemy");
            TeamEnemy= (Integer) savedInstanceState.getSerializable("EnemyTeam");


        }
        AllPickers.clear();
        PickerList.addAll(AllPickersInit());
        YourTeamName.setText(TeamName);
        EnemyteamNamet.setText(EnemyName);
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
        Heros_icon[21] = findViewById(R.id.Mars);

        Heros_icon[22] = findViewById(R.id.NS);
        Heros_icon[23] = findViewById(R.id.Omniknight);
        Heros_icon[24] = findViewById(R.id.Phoenix);
        Heros_icon[25] = findViewById(R.id.Pudge);
        Heros_icon[26] = findViewById(R.id.SandKing);
        Heros_icon[27] = findViewById(R.id.Slardar);
        Heros_icon[28] = findViewById(R.id.SpiritBreaker);
        Heros_icon[29] = findViewById(R.id.Sven);
        Heros_icon[30] = findViewById(R.id.Tidehunter);

        Heros_icon[31] = findViewById(R.id.Timbersaw);
        Heros_icon[32] = findViewById(R.id.Tiny);
        Heros_icon[33] = findViewById(R.id.Treant);
        Heros_icon[34] = findViewById(R.id.Tusk);
        Heros_icon[35] = findViewById(R.id.Underlord);
        Heros_icon[36] = findViewById(R.id.Undying);
        Heros_icon[37] = findViewById(R.id.WraithKing);

        Heros_icon[38] = findViewById(R.id.AntiMag);
        Heros_icon[39] = findViewById(R.id.ArcWarden);
        Heros_icon[40] = findViewById(R.id.Bloodweeker);
        Heros_icon[41] = findViewById(R.id.BountyHunter);
        Heros_icon[42] = findViewById(R.id.Broodmother);
        Heros_icon[43] = findViewById(R.id.Clinkz);
        Heros_icon[44] = findViewById(R.id.Drow);
        Heros_icon[45] = findViewById(R.id.Ember);
        Heros_icon[46] = findViewById(R.id.FacelessVoid);
        Heros_icon[47] = findViewById(R.id.Gyrocopter);

        Heros_icon[48] = findViewById(R.id.Juggernaut);
        Heros_icon[49] = findViewById(R.id.LoneDruid);
        Heros_icon[50] = findViewById(R.id.Luna);
        Heros_icon[51] = findViewById(R.id.Medusa);
        Heros_icon[52] = findViewById(R.id.Meepo);
        Heros_icon[53] = findViewById(R.id.Mirana);
        Heros_icon[54] = findViewById(R.id.MonkeyKing);
        Heros_icon[55] = findViewById(R.id.Morpling);
        Heros_icon[56] = findViewById(R.id.Naga);
        Heros_icon[57] = findViewById(R.id.Nyx);
        Heros_icon[58] = findViewById(R.id.Pangolier);
        Heros_icon[59] = findViewById(R.id.PhantomAssasin);



        Heros_icon[60] = findViewById(R.id.PhantomLancer);
        Heros_icon[61] = findViewById(R.id.Razor);
        Heros_icon[62] = findViewById(R.id.Riki);
        Heros_icon[63] = findViewById(R.id.ShadowFiend);
        Heros_icon[64] = findViewById(R.id.Slark);
        Heros_icon[65] = findViewById(R.id.Sniper);
        Heros_icon[66] = findViewById(R.id.Spectre);
        Heros_icon[67] = findViewById(R.id.TemplarAssasin);
        Heros_icon[68] = findViewById(R.id.Terroblade);
        Heros_icon[69] = findViewById(R.id.TrollWarlord);
        Heros_icon[70] = findViewById(R.id.Ursa);
        Heros_icon[71] = findViewById(R.id.VengefulSpirit);


        Heros_icon[72] = findViewById(R.id.Venomancer);
        Heros_icon[73] = findViewById(R.id.Viper);
        Heros_icon[74] = findViewById(R.id.Wiver);
        Heros_icon[75] = findViewById(R.id.AA);
        Heros_icon[76] = findViewById(R.id.Bane);
        Heros_icon[77] = findViewById(R.id.Batrider);
        Heros_icon[78] = findViewById(R.id.Chen);
        Heros_icon[79] = findViewById(R.id.CM);
        Heros_icon[80] = findViewById(R.id.Darkseer);
        Heros_icon[81] = findViewById(R.id.DarkWillow);
        Heros_icon[82] = findViewById(R.id.Dazzle);
        Heros_icon[83] = findViewById(R.id.DeathProphet);

        Heros_icon[84] = findViewById(R.id.Disruptor);
        Heros_icon[85] = findViewById(R.id.Enchantress);
        Heros_icon[86] = findViewById(R.id.Enigma);
        Heros_icon[87] = findViewById(R.id.Grimstroke);
        Heros_icon[88] = findViewById(R.id.Invoker);
        Heros_icon[89] = findViewById(R.id.Jakiro);
        Heros_icon[90] = findViewById(R.id.KeeperoftheLight);
        Heros_icon[91] = findViewById(R.id.Lechrak);
        Heros_icon[92] = findViewById(R.id.Lich);
        Heros_icon[93] = findViewById(R.id.Lina);
        Heros_icon[94] = findViewById(R.id.Lion);
        Heros_icon[95] = findViewById(R.id.NaturesPhrophet);


        Heros_icon[96] = findViewById(R.id.Necrophos);
        Heros_icon[97] = findViewById(R.id.OgreMagi);
        Heros_icon[98] = findViewById(R.id.Oracle);
        Heros_icon[99] = findViewById(R.id.OD);
        Heros_icon[100] = findViewById(R.id.Puck);
        Heros_icon[101] = findViewById(R.id.Pugna);
        Heros_icon[102] = findViewById(R.id.Qop);
        Heros_icon[103] = findViewById(R.id.Rubick);
        Heros_icon[104] = findViewById(R.id.ShadowDemon);
        Heros_icon[105] = findViewById(R.id.ShadowShaman);
        Heros_icon[106] = findViewById(R.id.Silencer);
        Heros_icon[107] = findViewById(R.id.Skymag);


        Heros_icon[108] = findViewById(R.id.StormSpirit);
        Heros_icon[109] = findViewById(R.id.Techies);
        Heros_icon[110] = findViewById(R.id.Tinker);
        Heros_icon[111] = findViewById(R.id.Visage);
        Heros_icon[112] = findViewById(R.id.Warlock);
        Heros_icon[113] = findViewById(R.id.Windranger);
        Heros_icon[114] = findViewById(R.id.WW);
        Heros_icon[115] = findViewById(R.id.WichDoctor);
        Heros_icon[116] = findViewById(R.id.Zeus);





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
        Heros_icon[21].setImageResource(R.drawable.mars_icon);
        Heros_icon[22].setImageResource(R.drawable.night_stalker_icon);
        Heros_icon[23].setImageResource(R.drawable.omniknight_icon);
        Heros_icon[24].setImageResource(R.drawable.phoenix_icon);
        Heros_icon[25].setImageResource(R.drawable.pudge_icon);
        Heros_icon[26].setImageResource(R.drawable.sand_king_icon);
        Heros_icon[27].setImageResource(R.drawable.slardar_icon);
        Heros_icon[28].setImageResource(R.drawable.spirit_breaker_icon);
        Heros_icon[29].setImageResource(R.drawable.sven_icon);
        Heros_icon[30].setImageResource(R.drawable.tidehunter_icon);


        Heros_icon[31].setImageResource(R.drawable.timbersaw_icon);
        Heros_icon[32].setImageResource(R.drawable.tiny_icon);
        Heros_icon[33].setImageResource(R.drawable.treant_icon);
        Heros_icon[34].setImageResource(R.drawable.tusk_icon);
        Heros_icon[35].setImageResource(R.drawable.underlord_icon);
        Heros_icon[36].setImageResource(R.drawable.undying_icon);
        Heros_icon[37].setImageResource(R.drawable.wk_icon);


        Heros_icon[38].setImageResource(R.drawable.anti_mage_icon);
        Heros_icon[39].setImageResource(R.drawable.arc_warden_icon);
        Heros_icon[40].setImageResource(R.drawable.bloodseeker_icon);
        Heros_icon[41].setImageResource(R.drawable.bounty_hunter_icon);
        Heros_icon[42].setImageResource(R.drawable.broodmother_icon);
        Heros_icon[43].setImageResource(R.drawable.clinkz_icon);
        Heros_icon[44].setImageResource(R.drawable.drow_icon);
        Heros_icon[45].setImageResource(R.drawable.ember_icon);
        Heros_icon[46].setImageResource(R.drawable.facelessvoid_icon);
        Heros_icon[47].setImageResource(R.drawable.gyrocopter_icon);


        Heros_icon[48].setImageResource(R.drawable.jaggernaut_icon);
        Heros_icon[49].setImageResource(R.drawable.lonedruid_icon);
        Heros_icon[50].setImageResource(R.drawable.luna_icon);
        Heros_icon[51].setImageResource(R.drawable.medusa_icon);
        Heros_icon[52].setImageResource(R.drawable.meepo_icon);
        Heros_icon[53].setImageResource(R.drawable.mirana_icon);
        Heros_icon[54].setImageResource(R.drawable.monkey_king_icon);
        Heros_icon[55].setImageResource(R.drawable.morpling_icon);
        Heros_icon[56].setImageResource(R.drawable.naga_icon);
        Heros_icon[57].setImageResource(R.drawable.nyx_icon);
        Heros_icon[58].setImageResource(R.drawable.pangolier);
        Heros_icon[59].setImageResource(R.drawable.phantom_assasin_icon);


        Heros_icon[60].setImageResource(R.drawable.phantom_lancer_icon);
        Heros_icon[61].setImageResource(R.drawable.razor_icon);
        Heros_icon[62].setImageResource(R.drawable.riki_icon);
        Heros_icon[63].setImageResource(R.drawable.shadow_fiend_icon);
        Heros_icon[64].setImageResource(R.drawable.slark_icon);
        Heros_icon[65].setImageResource(R.drawable.sniper_icon);
        Heros_icon[66].setImageResource(R.drawable.spectre_icon);
        Heros_icon[67].setImageResource(R.drawable.templarassasin_icon);
        Heros_icon[68].setImageResource(R.drawable.teroblade_icon);
        Heros_icon[69].setImageResource(R.drawable.troll_warlord_icon);
        Heros_icon[70].setImageResource(R.drawable.ursa_icon);
        Heros_icon[71].setImageResource(R.drawable.vengespirit_icon);


        Heros_icon[72].setImageResource(R.drawable.venomancer_icon);
        Heros_icon[73].setImageResource(R.drawable.viper_icon);
        Heros_icon[74].setImageResource(R.drawable.wiver_icon);
        Heros_icon[75].setImageResource(R.drawable.aa_icon);
        Heros_icon[76].setImageResource(R.drawable.bane_icon);
        Heros_icon[77].setImageResource(R.drawable.batrider_icon);
        Heros_icon[78].setImageResource(R.drawable.chen_icon);
        Heros_icon[79].setImageResource(R.drawable.crystal_maden_icon);
        Heros_icon[80].setImageResource(R.drawable.dark_seer_icon);
        Heros_icon[81].setImageResource(R.drawable.dark_willow_icon);
        Heros_icon[82].setImageResource(R.drawable.duzzle_icon);
        Heros_icon[83].setImageResource(R.drawable.death_prophet_icon);


        Heros_icon[84].setImageResource(R.drawable.disruptor_icon);
        Heros_icon[85].setImageResource(R.drawable.enchantress_icon);
        Heros_icon[86].setImageResource(R.drawable.enigma_icon);
        Heros_icon[87].setImageResource(R.drawable.grimstroke_icon);
        Heros_icon[88].setImageResource(R.drawable.invoker_icon);
        Heros_icon[89].setImageResource(R.drawable.jakiro_icon);
        Heros_icon[90].setImageResource(R.drawable.keeper_of_the_light_icon);
        Heros_icon[91].setImageResource(R.drawable.lechrak_icon);
        Heros_icon[92].setImageResource(R.drawable.lich_icon);
        Heros_icon[93].setImageResource(R.drawable.lina_icon);
        Heros_icon[94].setImageResource(R.drawable.lion_icon);
        Heros_icon[95].setImageResource(R.drawable.natures_prophet_icon);


        Heros_icon[96].setImageResource(R.drawable.necrophos_icon);
        Heros_icon[97].setImageResource(R.drawable.ogre_magi_icon);
        Heros_icon[98].setImageResource(R.drawable.oracle_icon);
        Heros_icon[99].setImageResource(R.drawable.od_icon);
        Heros_icon[100].setImageResource(R.drawable.puck_icon);
        Heros_icon[101].setImageResource(R.drawable.pugna_icon);
        Heros_icon[102].setImageResource(R.drawable.qop_icon);
        Heros_icon[103].setImageResource(R.drawable.rubick_icon);
        Heros_icon[104].setImageResource(R.drawable.shadow_demon_icon);
        Heros_icon[105].setImageResource(R.drawable.shadow_shaman_icon);
        Heros_icon[106].setImageResource(R.drawable.silencer_icon);
        Heros_icon[107].setImageResource(R.drawable.skymag_icon);



        Heros_icon[108].setImageResource(R.drawable.stormspirit_icon);
        Heros_icon[109].setImageResource(R.drawable.techies_willow_icon);
        Heros_icon[110].setImageResource(R.drawable.tinker_icon);
        Heros_icon[111].setImageResource(R.drawable.visage_icon);
        Heros_icon[112].setImageResource(R.drawable.warlock_icon);
        Heros_icon[113].setImageResource(R.drawable.windranger_icon);
        Heros_icon[114].setImageResource(R.drawable.ww_icon);
        Heros_icon[115].setImageResource(R.drawable.witch_doctor_icon);
        Heros_icon[116].setImageResource(R.drawable.zeus_icon);




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

                PlaningState.putExtra("CompHero1",comp_hero[0]);
                PlaningState.putExtra("CompHero2",comp_hero[1]);
                PlaningState.putExtra("CompHero3",comp_hero[2]);
                PlaningState.putExtra("CompHero4",comp_hero[3]);
                PlaningState.putExtra("CompHero5",comp_hero[4]);

                PlaningState.putExtra("EnemyTeam",TeamEnemy);


                PlaningState.putExtra("Position1",Pos1);
                PlaningState.putExtra("Position2",Pos2);
                PlaningState.putExtra("Position3",Pos3);
                PlaningState.putExtra("Position4",Pos4);
                PlaningState.putExtra("Position5",Pos5);


               // AllHeroes.clear();
                HeroList.clear();
                AllHeroes.clear();
                PickerList.clear();


                startActivity(PlaningState);
                finish();

            }
        });



        Enemytimer=  new CountDownTimer(2000, 1000) {
            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
            public void onTick(long millisUntilFinished) {
                if((pick_state==1)||(pick_state==3)||(pick_state==5)||(pick_state==10)||(pick_state==12)||(pick_state==18))
                {
                    HelpText.setText("Бан "+EnemyName+" Осталось: "
                            +2+ millisUntilFinished / 1000);
                }
                else
                {
                    HelpText.setText("Пик "+EnemyName+" Осталось: "
                            +2+ millisUntilFinished / 1000);
                }


            }
            //Задаем действия после завершения отсчета (высвечиваем надпись "Бабах!"):
            public void onFinish() {
               Pick_Stage_stam();

            }

        };
                //.start();


        //Pick_Stage_stam();
         Mytimer=  new CountDownTimer(2000, 1000) {
            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
            public void onTick(long millisUntilFinished) {

                if((pick_state==0)||(pick_state==2)||(pick_state==4)||(pick_state==11)||(pick_state==13)||(pick_state==19))
                {
                    HelpText.setText("Бан "+TeamName+" Осталось: "
                            + millisUntilFinished / 1000);
                }
                else
                {
                    HelpText.setText("Пик "+TeamName+" Осталось: "
                            + millisUntilFinished / 1000);
                }

            }
            //Задаем действия после завершения отсчета (высвечиваем надпись "Бабах!"):
            public void onFinish() {
                Pick_Stage_Random();
                if (pick_state!=20)
             {
                    Enemytimer.start();
                    youlocked=true;
             }
             else
             {
                 Mytimer.cancel();
                 Mytimer.start();
             }

                //Pick_Stage_stam();

            }

        }
                .start();






        for (int i=0;i<117;i++)
        {

            final int finalI = i;
            Heros_icon[i].setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                if (youlocked==false)
                {

                                                     if (HeroList.get(finalI).baned == false) {

                                                         Mytimer.cancel();

                                                         if (pick_state< 6) {
                                                             Pick_stage[pick_state].setImageResource(HeroList.get(finalI).minban);
                                                         } else if ((pick_state > 5) && (pick_state < 10)) {

                                                             Pick_stage[pick_state].setImageResource(HeroList.get(finalI).picked);
                                                             what_hero[k]=HeroList.get(finalI).seq;
                                                             k++;
                                                         } else if ((pick_state > 9) && (pick_state < 14)) {
                                                             Pick_stage[pick_state].setImageResource(HeroList.get(finalI).minban);
                                                         } else if ((pick_state > 13) && (pick_state < 18)) {
                                                             Pick_stage[pick_state].setImageResource(HeroList.get(finalI).picked);
                                                             what_hero[k]=HeroList.get(finalI).seq;
                                                             k++;
                                                         } else if ((pick_state > 17) && (pick_state < 20)) {
                                                             Pick_stage[pick_state].setImageResource(HeroList.get(finalI).minban);
                                                         } else if ((pick_state > 19) && (pick_state < 22)) {
                                                             Pick_stage[pick_state].setImageResource(HeroList.get(finalI).picked);
                                                             what_hero[k]=HeroList.get(finalI).seq;
                                                             k++;
                                                         }

                                                         pick_state++;
                                                         HeroList.get(finalI).baned=true;
                                                         Heros_icon[finalI].setImageResource(HeroList.get(finalI).largeban);
                                                         if (pick_state!=20)
                                                         {
                                                             Enemytimer.start();
                                                             youlocked=true;
                                                         }
                                                         else
                                                         {
                                                             Mytimer.cancel();
                                                             Mytimer.start();
                                                         }
                                                         //Pick_Stage_stam();

                                                     }

                                                     else {
                                                         Toast toast = Toast.makeText(getApplicationContext(),
                                                                 "Забанен1", Toast.LENGTH_SHORT);
                                                         toast.show();

                                                     }


                                                 }
                                                 }
                                             });
        }










        }




    protected void Pick_Stage_stam()
    {

        Enemytimer.cancel();


        Pick_Stage.setText("Stage"+" "+String.valueOf(pick_state+1));
        if((pick_state==1)||(pick_state==3)||(pick_state==5)||(pick_state==10)||(pick_state==12)||(pick_state==18))
        {
            frompicker=PickerList.get(TeamEnemy).Pick(pick_state,HeroList);
            Pick_stage[pick_state].setImageResource(HeroList.get(frompicker).minban);
            HeroList.get(frompicker).baned=true;
            Heros_icon[HeroList.get(frompicker).seq].setImageResource(HeroList.get(frompicker).largeban);

            pick_state++;


        }
        else if ((pick_state==7))
        {

            frompicker=PickerList.get(TeamEnemy).Pick(pick_state,HeroList);
            Pick_stage[pick_state].setImageResource(HeroList.get(frompicker).picked);
            HeroList.get(frompicker).baned=true;
            Heros_icon[HeroList.get(frompicker).seq].setImageResource(HeroList.get(frompicker).largeban);
            comp_hero[0]=HeroList.get(frompicker).seq;
            pick_state++;



            frompicker=PickerList.get(TeamEnemy).Pick(pick_state,HeroList);
            Pick_stage[pick_state].setImageResource(HeroList.get(frompicker).picked);
            HeroList.get(frompicker).baned=true;
            Heros_icon[HeroList.get(frompicker).seq].setImageResource(HeroList.get(frompicker).largeban);
            comp_hero[1]=HeroList.get(frompicker).seq;

            pick_state++;



        }

        else if ((pick_state==14)||(pick_state==16)||(pick_state==21))
        {

            frompicker=PickerList.get(TeamEnemy).Pick(pick_state,HeroList);
            Pick_stage[pick_state].setImageResource(HeroList.get(frompicker).picked);
            HeroList.get(frompicker).baned=true;
            Heros_icon[HeroList.get(frompicker).seq].setImageResource(HeroList.get(frompicker).largeban);
            if (pick_state==14)
            {
                comp_hero[2]=HeroList.get(frompicker).seq;
            }
            else if (pick_state==16)
            {
                comp_hero[3]=HeroList.get(frompicker).seq;
            }
            else if (pick_state==21)
            {
                comp_hero[4]=HeroList.get(frompicker).seq;
            }


            pick_state++;
        }

        youlocked=false;
        if(pick_state!=22)
        {
            Mytimer.start();
        }
        else
        {
            HelpText.setText("Перейдите к стадии планирования");
            Plan_state.setVisibility(View.VISIBLE);
        }


    }




    protected void Pick_Stage_Random()
    {
        Random randomhero = new Random();
        int whathero=0;
        if(HeroList.size()!=0)
        {
            whathero=randomhero.nextInt(HeroList.size());
            if (HeroList.get(whathero).baned==true)
            {
                Pick_Stage_Random();
            }

        }

        Pick_Stage.setText("Stage"+" "+String.valueOf(pick_state+1));
        if((pick_state==0)||(pick_state==2)||(pick_state==4)||(pick_state==11)||(pick_state==13)||(pick_state==19))
        {
            Pick_stage[pick_state].setImageResource(HeroList.get(whathero).minban);
            HeroList.get(whathero).baned=true;
            Heros_icon[whathero].setImageResource(HeroList.get(whathero).largeban);
            pick_state++;



        }
        else if ((pick_state==6)||(pick_state==9)||(pick_state==15)||(pick_state==17)||(pick_state==20))
        {
            Pick_stage[pick_state].setImageResource(HeroList.get(whathero).picked);
            HeroList.get(whathero).baned=true;
            Heros_icon[whathero].setImageResource(HeroList.get(whathero).largeban);
            what_hero[k]=whathero;
            k++;
            pick_state++;




        }

        //else if ((pick_state==15)||(pick_state==17)||(pick_state==20))
        //{
         //   Pick_stage[pick_state].setImageResource(HeroList.get(whathero).picked);
         //   HeroList.get(whathero).baned=true;
         //   Heros_icon[whathero].setImageResource(HeroList.get(whathero).largeban);
         //   what_hero[k]=whathero;
        //    k++;
        //    pick_state++;




       // }




    }









    }







