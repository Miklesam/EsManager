package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.miklesam.dota_manager.HeroInit.AllHeroes;
import static com.miklesam.dota_manager.PlayersInit.AllPlayers;
import static com.miklesam.dota_manager.PlayersInit.CorePlayers;
import static com.miklesam.dota_manager.PlayersInit.PlayersAllInit;
import static com.miklesam.dota_manager.PlayersInit.PlayersCoreInit;
import static com.miklesam.dota_manager.PlayersInit.PlayersSupportInit;
import static com.miklesam.dota_manager.PlayersInit.SupportPlayers;
import static com.miklesam.dota_manager.YourTeam.Fans;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Language;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

public class market extends AppCompatActivity {
    ImageView Backtomain;
    ListView CorelistView;
    ListView SupportlistView;
    ImageView CoreChoose;
    ImageView SupportChoose;
    TextView Teamnameid;

    ScrollView scrollscroll;
    ArrayList<Players> Cores = new ArrayList<Players>();
    ArrayList<Players> Supports = new ArrayList<Players>();
    LinearLayout Your_Team;
    LinearLayout notmoneyhelp;
    LinearLayout toreward;
    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;
    ArrayList<Players> TheAllPlayers;
    ArrayList <Heroes> DirectHero = new ArrayList<Heroes>();
    TextView Team[]=new TextView[5];
    TextView Goldbalance;
    boolean CorePick;
    LinearLayout PlayerInformation;
    ImageView FlagIma;

    TextView PlayerNickName;
    TextView PlayerDiscription;

    TextView Laining;
    TextView Fighting;
    TextView Farming;
    TextView Supporting;
    TextView PlayerCost;

    ImageView Signature1;
    ImageView Signature2;
    ImageView Signature3;

    int last_position_player;
    int last_position;
    ImageView Back;

    ImageView Posi1;
    ImageView Posi2;
    ImageView Posi3;
    ImageView Buy_Yes;
    ImageView Buy_No;
    ImageView Sell;

    boolean SupportPick;
    boolean sup_pick;
    String Gold;

    boolean sellgoes;

    boolean team[]=new boolean[5];
    int playerseq[]=new int[5];
    int sellposition;
    ImageView tostore;
    ImageView toback;
    ImageView torewardbtn;
    TextView Fansbalance;
    String fansbalansed;

    TextView PlayerFans;
    ImageView FaceImage;

    SharedPreferences mSettings;
    boolean lock;
    int languageshare;


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
        setContentView(R.layout.activity_market);

        Fansbalance=findViewById(R.id.Fansbalance);
        torewardbtn=findViewById(R.id.torewardbtn);
        scrollscroll=findViewById(R.id.scrollscroll);
        toback=findViewById(R.id.toback);
        tostore=findViewById(R.id.tostore);
        toreward=findViewById(R.id.toreward);
        notmoneyhelp=findViewById(R.id.notmoneyhelp);
        Your_Team=findViewById(R.id.Your_Team);
        Sell=findViewById(R.id.Sell);
        Sell.setVisibility(View.INVISIBLE);
        Goldbalance=findViewById(R.id.Goldbalance);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        CorelistView = (ListView)findViewById(R.id.CoreList);
        SupportlistView=(ListView)findViewById(R.id.SupportList);
        final Intent Tomainstate = new Intent(this, mainstate.class);

        final Intent ToShop = new Intent(this, Shop.class);
        final Intent ToReward = new Intent(this, Rewarded.class);

        PlayerFans=findViewById(R.id.PlayerFans);
        FaceImage=findViewById(R.id.FaceImage);
        Backtomain=findViewById(R.id.Backtomain);
        CoreChoose =findViewById(R.id.Core);
        SupportChoose =findViewById(R.id.Support);
        PlayerInformation=findViewById(R.id.PlayerInfo);
        FlagIma=findViewById(R.id.FlagImage);
        PlayerNickName=findViewById(R.id.Nickname);
        PlayerDiscription=findViewById(R.id.Description);
        PlayerCost=findViewById(R.id.PlayerCost);
        Back=findViewById(R.id.Back);
        Posi1=findViewById(R.id.Pos1);
        Posi2=findViewById(R.id.Pos2);
        Posi3=findViewById(R.id.Pos3);


        Buy_Yes=findViewById(R.id.Buy_Yes);
        Buy_No=findViewById(R.id.Buy_No);
        Laining=findViewById(R.id.laning);
        Fighting=findViewById(R.id.fighting);
        Farming=findViewById(R.id.farming);
        Supporting=findViewById(R.id.supporting);

        Signature1=findViewById(R.id.signature1);
        Signature2=findViewById(R.id.signature2);
        Signature3=findViewById(R.id.signature3);

        Team[0]=findViewById(R.id.position1);
        Team[1]=findViewById(R.id.position2);
        Team[2]=findViewById(R.id.position3);
        Team[3]=findViewById(R.id.position4);
        Team[4]=findViewById(R.id.position5);

        Teamnameid=findViewById(R.id.Teamnameid);

        AllHeroes.clear();
        CorePlayers.clear();
        SupportPlayers.clear();

        DirectHero.addAll(HeroInit.HeroInit());
        Cores=PlayersCoreInit();
        Supports=PlayersSupportInit();
        SupportlistView.setVisibility(View.INVISIBLE);






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

        if(mSettings.contains(GoldBalance)) {

            Gold =mSettings.getString(GoldBalance, "50000");

        }
        if(mSettings.contains(Fans)) {

            fansbalansed =mSettings.getString(Fans, "0");

        }
        if(mSettings.contains(Language)) {
            languageshare=Integer.parseInt(mSettings.getString(Language, "0"));
        }
        if(languageshare==2)
        {
            Teamnameid.setText("Sell");
        }
        else
        {
            Teamnameid.setText("Продать");
        }


        Fansbalance.setText(fansbalansed);


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






        for (int i=0;i<Cores.size();i++)
        {
            if((Cores.get(i).sequence==Pos1)||(Cores.get(i).sequence==Pos2)||(Cores.get(i).sequence==Pos3))
            {
                Cores.remove(i);
            }
        }

        for (int i=0;i<Supports.size();i++)
        {
            if((Supports.get(i).sequence==Pos4)||(Supports.get(i).sequence==Pos5))
            {
                Supports.remove(i);
            }
        }



        final CoreAdapter coreAdapter=new CoreAdapter();
        final suppoportAdapter cupppAdapter = new suppoportAdapter();
        CorelistView.setAdapter(coreAdapter);
        SupportlistView.setAdapter(cupppAdapter);



        AllPlayers.clear();
        TheAllPlayers=PlayersAllInit();
        if(team[0]==true)
        {
            Team[0].setText(TheAllPlayers.get(Pos1).Name);
        }
        else
        {
            Team[0].setText("1");
        }
        if(team[1]==true)
        {
            Team[1].setText(TheAllPlayers.get(Pos2).Name);
        }
        else
        {
            Team[1].setText("2");
        }

        if(team[2]==true)
        {
            Team[2].setText(TheAllPlayers.get(Pos3).Name);
        }
        else
        {
            Team[2].setText("3");
        }


        if(team[3]==true)
        {
            Team[3].setText(TheAllPlayers.get(Pos4).Name);
        }
        else
        {
            Team[3].setText("4");
        }

        if(team[4]==true)
        {
            Team[4].setText(TheAllPlayers.get(Pos5).Name);
        }
        else
        {
            Team[4].setText("5");
        }
        Goldbalance.setText(Gold);



        Backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(Tomainstate);



            }
        });

        SupportChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CorelistView.setVisibility(View.INVISIBLE);
                SupportlistView.setVisibility(View.VISIBLE);

            }
        });

        CoreChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CorelistView.setVisibility(View.VISIBLE);
                SupportlistView.setVisibility(View.INVISIBLE);

            }
        });



        CorelistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CorePick=true;
                CorelistView.setVisibility(View.INVISIBLE);
                CoreChoose.setVisibility(View.INVISIBLE);
                SupportChoose.setVisibility(View.INVISIBLE);
                PlayerInformation.setVisibility(View.VISIBLE);
                //PlayerNickName.setText(CoreNAMES[position]);
                //PlayerDiscription.setText(CorePriceMoney[position]);
                //FlagIma.setImageResource(CoreIMAGES[position]);
                FaceImage.setImageResource(Cores.get(position).face);
                FlagIma.setImageResource(Cores.get(position).Flag);
                PlayerNickName.setText(Cores.get(position).Name);
                if(languageshare==2)
                {
                    PlayerDiscription.setText(Cores.get(position).EngDescription);
                }
                else
                {
                    PlayerDiscription.setText(Cores.get(position).Description);
                }

                PlayerCost.setText(String.valueOf(Cores.get(position).Cost));
                PlayerFans.setText(String.valueOf(Cores.get(position).fans));
                Buy_Yes.setVisibility(View.VISIBLE);
                Buy_No.setVisibility(View.VISIBLE);

                Laining.setText("Laining "+ String.valueOf(Cores.get(position).laining));
                Fighting.setText("Fight "+ String.valueOf(Cores.get(position).fighting));
                Farming.setText("Farm "+ String.valueOf(Cores.get(position).farming));
                Supporting.setText("LateGame "+ String.valueOf(Cores.get(position).late));
                Signature1.setImageResource(AllHeroes.get(Cores.get(position).signature1).picked);
                Signature2.setImageResource(AllHeroes.get(Cores.get(position).signature2).picked);
                Signature3.setImageResource(AllHeroes.get(Cores.get(position).signature3).picked);

                last_position=position;
                last_position_player=Cores.get(position).sequence;
                //Posi2.setText("Позиция 2");
                //Posi3.setText("Позиция 3");
                Posi2.setImageResource(R.drawable.position_2);
                Posi3.setImageResource(R.drawable.position_3);

            }
        });




        SupportlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SupportPick=true;
                SupportlistView.setVisibility(View.INVISIBLE);
                CoreChoose.setVisibility(View.INVISIBLE);
                SupportChoose.setVisibility(View.INVISIBLE);
                PlayerInformation.setVisibility(View.VISIBLE);

                FaceImage.setImageResource(Supports.get(position).face);
                FlagIma.setImageResource(Supports.get(position).Flag);
                PlayerNickName.setText(Supports.get(position).Name);
                if(languageshare==2)
                {
                    PlayerDiscription.setText(Supports.get(position).EngDescription);
                }
                else
                {
                    PlayerDiscription.setText(Supports.get(position).Description);
                }


                PlayerCost.setText(String.valueOf(Supports.get(position).Cost));
                PlayerFans.setText(String.valueOf(Supports.get(position).fans));

                Laining.setText("Laning "+ String.valueOf(Supports.get(position).laining));
                Fighting.setText("Fight "+ String.valueOf(Supports.get(position).fighting));
                Farming.setText("Farm "+ String.valueOf(Supports.get(position).farming));
                Supporting.setText("Lategame "+ String.valueOf(Supports.get(position).late));
                Signature1.setImageResource(AllHeroes.get(Supports.get(position).signature1).picked);
                Signature2.setImageResource(AllHeroes.get(Supports.get(position).signature2).picked);
                Signature3.setImageResource(AllHeroes.get(Supports.get(position).signature3).picked);

                last_position=position;
                last_position_player=Supports.get(position).sequence;
                //Posi2.setText("Позиция 4");
                //Posi3.setText("Позиция 5");
                Posi2.setImageResource(R.drawable.position_4);
                Posi3.setImageResource(R.drawable.position_5);

            }
        });






        Buy_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorelistView.setVisibility(View.VISIBLE);
                CoreChoose.setVisibility(View.VISIBLE);
                SupportChoose.setVisibility(View.VISIBLE);
                PlayerInformation.setVisibility(View.INVISIBLE);
                //SupportPick=false;
                CorePick=false;


            }
        });

        Buy_Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( sellgoes==true)
                {
                    sellgoes=false;
                    Buy_Yes.setImageResource(R.drawable.buy_bttn);


                    CorelistView.setVisibility(View.VISIBLE);
                    CoreChoose.setVisibility(View.VISIBLE);
                    SupportChoose.setVisibility(View.VISIBLE);
                    PlayerInformation.setVisibility(View.INVISIBLE);
                    Sell.setVisibility(View.INVISIBLE);




                }
                else {

                    if (CorePick == true) {
                        Posi1.setVisibility(View.VISIBLE);
                        Posi2.setVisibility(View.VISIBLE);
                        Posi3.setVisibility(View.VISIBLE);
                        Back.setVisibility(View.VISIBLE);

                        Buy_Yes.setVisibility(View.INVISIBLE);
                        Buy_No.setVisibility(View.INVISIBLE);

                    } else if (SupportPick == true) {
                        sup_pick = true;
                        //Posi2.setText("Позиция 4");
                        Posi2.setImageResource(R.drawable.position_4);
                        Posi2.setVisibility(View.VISIBLE);




                        //Posi3.setText("Позиция 5");
                        Posi3.setImageResource(R.drawable.position_5);
                        Posi3.setVisibility(View.VISIBLE);
                        Back.setVisibility(View.VISIBLE);

                        Buy_Yes.setVisibility(View.INVISIBLE);
                        Buy_No.setVisibility(View.INVISIBLE);

                    }

                }

            }
        });


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorelistView.setVisibility(View.VISIBLE);
                CoreChoose.setVisibility(View.VISIBLE);
                SupportChoose.setVisibility(View.VISIBLE);
                PlayerInformation.setVisibility(View.INVISIBLE);
                SupportPick=false;
                CorePick=false;
                Posi1.setVisibility(View.INVISIBLE);
                Posi2.setVisibility(View.INVISIBLE);
                Posi3.setVisibility(View.INVISIBLE);
                Back.setVisibility(View.INVISIBLE);
                Buy_Yes.setVisibility(View.VISIBLE);
                Buy_No.setVisibility(View.VISIBLE);

                if (sup_pick==true)
                {
                    sup_pick=false;
                    //Posi2.setText("Позиция 2");
                    //Posi3.setText("Позиция 3");
                    Posi2.setImageResource(R.drawable.position_2);
                    Posi3.setImageResource(R.drawable.position_3);
                }




            }
        });


        final SharedPreferences.Editor editor = mSettings.edit();


        Team[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(team[0]==true) {
                    CorePick = true;
                    CorelistView.setVisibility(View.INVISIBLE);
                    SupportlistView.setVisibility(View.INVISIBLE);
                    CoreChoose.setVisibility(View.INVISIBLE);
                    SupportChoose.setVisibility(View.INVISIBLE);
                    PlayerInformation.setVisibility(View.VISIBLE);
                    Posi1.setVisibility(View.INVISIBLE);
                    Posi2.setVisibility(View.INVISIBLE);
                    Posi3.setVisibility(View.INVISIBLE);
                    Back.setVisibility(View.INVISIBLE);

                    sellgoes=true;
                    Sell.setVisibility(View.VISIBLE);
                    Buy_Yes.setVisibility(View.VISIBLE);
                    Buy_Yes.setImageResource(R.drawable.cancel_bttn);
                    Buy_No.setVisibility(View.INVISIBLE);

                    FaceImage.setImageResource(AllPlayers.get(Pos1).face);
                    FlagIma.setImageResource(AllPlayers.get(Pos1).Flag);
                    PlayerNickName.setText(AllPlayers.get(Pos1).Name);
                    if(languageshare==2)
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos1).EngDescription);
                    }
                    else
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos1).Description);
                    }

                    PlayerCost.setText(String.valueOf(AllPlayers.get(Pos1).Cost/2));
                    PlayerFans.setText(String.valueOf(AllPlayers.get(Pos1).fans));


                    Laining.setText("Laning " + String.valueOf(AllPlayers.get(Pos1).laining));
                    Fighting.setText("Fight " + String.valueOf(AllPlayers.get(Pos1).fighting));
                    Farming.setText("Farm " + String.valueOf(AllPlayers.get(Pos1).farming));
                    Supporting.setText("LateGame " + String.valueOf(AllPlayers.get(Pos1).late));
                    Signature1.setImageResource(AllHeroes.get(AllPlayers.get(Pos1).signature1).picked);
                    Signature2.setImageResource(AllHeroes.get(AllPlayers.get(Pos1).signature2).picked);
                    Signature3.setImageResource(AllHeroes.get(AllPlayers.get(Pos1).signature3).picked);

                    //last_position_player=Cores.get(position).sequence;
                    sellposition=0;

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Позиция Свободна", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });



        Team[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(team[1]==true) {

                    CorePick = true;
                    CorelistView.setVisibility(View.INVISIBLE);
                    SupportlistView.setVisibility(View.INVISIBLE);
                    CoreChoose.setVisibility(View.INVISIBLE);
                    SupportChoose.setVisibility(View.INVISIBLE);
                    PlayerInformation.setVisibility(View.VISIBLE);
                    Posi1.setVisibility(View.INVISIBLE);
                    Posi2.setVisibility(View.INVISIBLE);
                    Posi3.setVisibility(View.INVISIBLE);
                    Back.setVisibility(View.INVISIBLE);
                    sellgoes=true;
                    Sell.setVisibility(View.VISIBLE);
                    Buy_Yes.setVisibility(View.VISIBLE);
                    Buy_Yes.setImageResource(R.drawable.cancel_bttn);
                    Buy_No.setVisibility(View.INVISIBLE);

                    FaceImage.setImageResource(AllPlayers.get(Pos2).face);
                    FlagIma.setImageResource(AllPlayers.get(Pos2).Flag);
                    PlayerNickName.setText(AllPlayers.get(Pos2).Name);
                    if(languageshare==2)
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos2).EngDescription);
                    }
                    else
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos2).Description);
                    }
                    PlayerCost.setText(String.valueOf(AllPlayers.get(Pos2).Cost/2));
                    PlayerFans.setText(String.valueOf(AllPlayers.get(Pos2).fans));


                    Laining.setText("Laining " + String.valueOf(AllPlayers.get(Pos2).laining));
                    Fighting.setText("Fight " + String.valueOf(AllPlayers.get(Pos2).fighting));
                    Farming.setText("Farm " + String.valueOf(AllPlayers.get(Pos2).farming));
                    Supporting.setText("LateGame " + String.valueOf(AllPlayers.get(Pos2).late));
                    Signature1.setImageResource(AllHeroes.get(AllPlayers.get(Pos2).signature1).picked);
                    Signature2.setImageResource(AllHeroes.get(AllPlayers.get(Pos2).signature2).picked);
                    Signature3.setImageResource(AllHeroes.get(AllPlayers.get(Pos2).signature3).picked);

                    //last_position_player=Cores.get(position).sequence;
                    sellposition=1;

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Позиция Свободна", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });





        Team[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(team[2]==true) {

                    CorePick = true;
                    CorelistView.setVisibility(View.INVISIBLE);
                    SupportlistView.setVisibility(View.INVISIBLE);
                    CoreChoose.setVisibility(View.INVISIBLE);
                    SupportChoose.setVisibility(View.INVISIBLE);
                    PlayerInformation.setVisibility(View.VISIBLE);
                    Posi1.setVisibility(View.INVISIBLE);
                    Posi2.setVisibility(View.INVISIBLE);
                    Posi3.setVisibility(View.INVISIBLE);
                    Back.setVisibility(View.INVISIBLE);
                    sellgoes=true;
                    Sell.setVisibility(View.VISIBLE);
                    Buy_Yes.setVisibility(View.VISIBLE);
                    Buy_Yes.setImageResource(R.drawable.cancel_bttn);
                    Buy_No.setVisibility(View.INVISIBLE);

                    FaceImage.setImageResource(AllPlayers.get(Pos3).face);
                    FlagIma.setImageResource(AllPlayers.get(Pos3).Flag);
                    PlayerNickName.setText(AllPlayers.get(Pos3).Name);
                    if(languageshare==2)
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos3).EngDescription);
                    }
                    else
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos3).Description);
                    }
                    PlayerCost.setText(String.valueOf(AllPlayers.get(Pos3).Cost/2));
                    PlayerFans.setText(String.valueOf(AllPlayers.get(Pos3).fans));


                    Laining.setText("Laning " + String.valueOf(AllPlayers.get(Pos3).laining));
                    Fighting.setText("Fight " + String.valueOf(AllPlayers.get(Pos3).fighting));
                    Farming.setText("Farm " + String.valueOf(AllPlayers.get(Pos3).farming));
                    Supporting.setText("LateGame " + String.valueOf(AllPlayers.get(Pos3).late));
                    Signature1.setImageResource(AllHeroes.get(AllPlayers.get(Pos3).signature1).picked);
                    Signature2.setImageResource(AllHeroes.get(AllPlayers.get(Pos3).signature2).picked);
                    Signature3.setImageResource(AllHeroes.get(AllPlayers.get(Pos3).signature3).picked);

                    //last_position_player=Cores.get(position).sequence;
                    sellposition=2;

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Позиция Свободна", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });









        Team[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(team[3]==true) {

                    CorePick = false;
                    CorelistView.setVisibility(View.INVISIBLE);
                    SupportlistView.setVisibility(View.INVISIBLE);
                    CoreChoose.setVisibility(View.INVISIBLE);
                    SupportChoose.setVisibility(View.INVISIBLE);
                    PlayerInformation.setVisibility(View.VISIBLE);
                    Posi1.setVisibility(View.INVISIBLE);
                    Posi2.setVisibility(View.INVISIBLE);
                    Posi3.setVisibility(View.INVISIBLE);
                    Back.setVisibility(View.INVISIBLE);
                    sellgoes=true;
                    Sell.setVisibility(View.VISIBLE);
                    Buy_Yes.setVisibility(View.VISIBLE);
                    Buy_Yes.setImageResource(R.drawable.cancel_bttn);
                    Buy_No.setVisibility(View.INVISIBLE);

                    FaceImage.setImageResource(AllPlayers.get(Pos4).face);
                    FlagIma.setImageResource(AllPlayers.get(Pos4).Flag);
                    PlayerNickName.setText(AllPlayers.get(Pos4).Name);
                    if(languageshare==2)
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos4).EngDescription);
                    }
                    else
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos4).Description);
                    }
                    PlayerCost.setText(String.valueOf(AllPlayers.get(Pos4).Cost/2));
                    PlayerFans.setText(String.valueOf(AllPlayers.get(Pos4).fans));


                    Laining.setText("Laining " + String.valueOf(AllPlayers.get(Pos4).laining));
                    Fighting.setText("Fight " + String.valueOf(AllPlayers.get(Pos4).fighting));
                    Farming.setText("Farm " + String.valueOf(AllPlayers.get(Pos4).farming));
                    Supporting.setText("LateGame " + String.valueOf(AllPlayers.get(Pos4).late));
                    Signature1.setImageResource(AllHeroes.get(AllPlayers.get(Pos4).signature1).picked);
                    Signature2.setImageResource(AllHeroes.get(AllPlayers.get(Pos4).signature2).picked);
                    Signature3.setImageResource(AllHeroes.get(AllPlayers.get(Pos4).signature3).picked);

                    //last_position_player=Cores.get(position).sequence;
                    sellposition=3;

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Позиция Свободна", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        Team[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(team[4]==true) {

                    CorePick = false;
                    CorelistView.setVisibility(View.INVISIBLE);
                    SupportlistView.setVisibility(View.INVISIBLE);
                    CoreChoose.setVisibility(View.INVISIBLE);
                    SupportChoose.setVisibility(View.INVISIBLE);
                    PlayerInformation.setVisibility(View.VISIBLE);
                    Posi1.setVisibility(View.INVISIBLE);
                    Posi2.setVisibility(View.INVISIBLE);
                    Posi3.setVisibility(View.INVISIBLE);
                    Back.setVisibility(View.INVISIBLE);
                    sellgoes=true;
                    Sell.setVisibility(View.VISIBLE);
                    Buy_Yes.setVisibility(View.VISIBLE);
                    Buy_Yes.setImageResource(R.drawable.cancel_bttn);
                    Buy_No.setVisibility(View.INVISIBLE);

                    FaceImage.setImageResource(AllPlayers.get(Pos5).face);
                    FlagIma.setImageResource(AllPlayers.get(Pos5).Flag);
                    PlayerNickName.setText(AllPlayers.get(Pos5).Name);
                    if(languageshare==2)
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos5).EngDescription);
                    }
                    else
                    {
                        PlayerDiscription.setText(AllPlayers.get(Pos5).Description);
                    }
                    PlayerCost.setText(String.valueOf(AllPlayers.get(Pos5).Cost/2));
                    PlayerFans.setText(String.valueOf(AllPlayers.get(Pos5).fans));


                    Laining.setText("Laining " + String.valueOf(AllPlayers.get(Pos5).laining));
                    Fighting.setText("Fight " + String.valueOf(AllPlayers.get(Pos5).fighting));
                    Farming.setText("Farm " + String.valueOf(AllPlayers.get(Pos5).farming));
                    Supporting.setText("LateGame " + String.valueOf(AllPlayers.get(Pos5).late));
                    Signature1.setImageResource(AllHeroes.get(AllPlayers.get(Pos5).signature1).picked);
                    Signature2.setImageResource(AllHeroes.get(AllPlayers.get(Pos5).signature2).picked);
                    Signature3.setImageResource(AllHeroes.get(AllPlayers.get(Pos5).signature3).picked);

                    //last_position_player=Cores.get(position).sequence;
                    sellposition=4;

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Позиция Свободна", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });













        Sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                team[sellposition]=false;



                 Gold= String.valueOf(Integer.parseInt(Gold)+ (Integer.parseInt((String) PlayerCost.getText())/2));


                Goldbalance.setText(Gold);
                fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)- Integer.parseInt((String) PlayerFans.getText()));
                Fansbalance.setText(fansbalansed);

                sellgoes=false;
                Buy_Yes.setImageResource(R.drawable.buy_bttn);
                if (sellposition==0)
                {
                    Team[0].setText("1.");
                    editor.putString(StaticPosition1,String.valueOf(77));
                    Cores.add(AllPlayers.get(Pos1));
                }
                else if(sellposition==1)
                {
                    Team[1].setText("2.");
                    editor.putString(StaticPosition2,String.valueOf(77));
                    Cores.add(AllPlayers.get(Pos2));
                }
                else if(sellposition==2)
                {
                    Team[2].setText("3.");
                    editor.putString(StaticPosition3,String.valueOf(77));
                    Cores.add(AllPlayers.get(Pos3));
                }

                else if(sellposition==3)
                {
                    Team[3].setText("4.");
                    editor.putString(StaticPosition4,String.valueOf(77));
                    Supports.add(AllPlayers.get(Pos4));
                }
                else if(sellposition==4)
                {
                    Team[4].setText("5.");
                    editor.putString(StaticPosition5,String.valueOf(77));
                    Supports.add(AllPlayers.get(Pos5));
                }

                editor.putString(GoldBalance,String.valueOf(Gold));
                editor.apply();


                    //playerseq[0]=last_position_player;
                    CorelistView.setVisibility(View.VISIBLE);
                    CoreChoose.setVisibility(View.VISIBLE);
                    SupportChoose.setVisibility(View.VISIBLE);
                    PlayerInformation.setVisibility(View.INVISIBLE);
                    Back.setVisibility(View.INVISIBLE);

                    CorelistView.setAdapter(coreAdapter);
                    SupportlistView.setAdapter(cupppAdapter);

                    Posi1.setVisibility(View.INVISIBLE);
                    Posi2.setVisibility(View.INVISIBLE);
                    Posi3.setVisibility(View.INVISIBLE);
                    Buy_Yes.setVisibility(View.VISIBLE);
                    Buy_No.setVisibility(View.VISIBLE);
                    Sell.setVisibility(View.INVISIBLE);
                    SupportPick=false;
                    CorePick=false;





            }
        });








        Posi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (team[0]==false)
                {

                    if(Integer.parseInt(Gold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                    {
                        Team[0].setText(PlayerNickName.getText());
                        Gold= String.valueOf(Integer.parseInt(Gold)- Integer.parseInt((String) PlayerCost.getText()));
                        Goldbalance.setText(Gold);

                        fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                        Fansbalance.setText(fansbalansed);


                        Pos1=last_position_player;
                        team[0]=true;
                        playerseq[0]=last_position_player;
                        editor.putString(StaticPosition1,String.valueOf(playerseq[0]));
                        editor.putString(GoldBalance,String.valueOf(Gold));
                        editor.apply();

                        CorelistView.setVisibility(View.VISIBLE);
                        CoreChoose.setVisibility(View.VISIBLE);
                        SupportChoose.setVisibility(View.VISIBLE);
                        PlayerInformation.setVisibility(View.INVISIBLE);
                        Back.setVisibility(View.INVISIBLE);
                        Cores.remove(last_position);
                        CorelistView.setAdapter(coreAdapter);

                        Posi1.setVisibility(View.INVISIBLE);
                        Posi2.setVisibility(View.INVISIBLE);
                        Posi3.setVisibility(View.INVISIBLE);
                        Buy_Yes.setVisibility(View.VISIBLE);
                        Buy_No.setVisibility(View.VISIBLE);
                        SupportPick=false;
                        CorePick=false;


                    }
                    else
                    {
                        if(languageshare==2)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Not enough money", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Недостаточно денег", Toast.LENGTH_SHORT);
                            toast.show();
                        }


                    }

                }

                else
                {


                    if(languageshare==2)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "position already taken", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Позиция занята", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }



            }
        });



        Posi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CorePick==true)
                {
                    if (team[1]==false)
                    {
                        if(Integer.parseInt(Gold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                        {
                            Team[1].setText(PlayerNickName.getText());
                            Gold= String.valueOf(Integer.parseInt(Gold)- Integer.parseInt((String) PlayerCost.getText()));
                            Goldbalance.setText(Gold);

                            fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                            Fansbalance.setText(fansbalansed);

                            Pos2=last_position_player;
                            team[1]=true;
                            playerseq[1]=last_position_player;
                            editor.putString(StaticPosition2,String.valueOf(playerseq[1]));
                            editor.putString(GoldBalance,String.valueOf(Gold));
                            editor.apply();

                            CorelistView.setVisibility(View.VISIBLE);
                            CoreChoose.setVisibility(View.VISIBLE);
                            SupportChoose.setVisibility(View.VISIBLE);
                            PlayerInformation.setVisibility(View.INVISIBLE);
                            Back.setVisibility(View.INVISIBLE);
                            Cores.remove(last_position);
                            CorelistView.setAdapter(coreAdapter);

                            Posi1.setVisibility(View.INVISIBLE);
                            Posi2.setVisibility(View.INVISIBLE);
                            Posi3.setVisibility(View.INVISIBLE);
                            Buy_Yes.setVisibility(View.VISIBLE);
                            Buy_No.setVisibility(View.VISIBLE);
                            SupportPick=false;
                            CorePick=false;

                        }
                        else
                        {
                            if(languageshare==2)
                            {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Not enough money", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                            else
                            {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Недостаточно денег", Toast.LENGTH_SHORT);
                                toast.show();
                            }


                        }

                    }

                    else
                    {


                        if(languageshare==2)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "position already taken", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Позиция занята", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    }
                }
                else
                {
                    if (team[3]==false)
                    {
                        if(Integer.parseInt(Gold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                        {
                            Team[3].setText(PlayerNickName.getText());
                            Gold= String.valueOf(Integer.parseInt(Gold)- Integer.parseInt((String) PlayerCost.getText()));
                            Goldbalance.setText(Gold);

                            fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                            Fansbalance.setText(fansbalansed);

                            Pos4=last_position_player;
                            team[3]=true;
                            playerseq[3]=last_position_player;
                            editor.putString(StaticPosition4,String.valueOf(playerseq[3]));
                            editor.putString(GoldBalance,String.valueOf(Gold));
                            editor.apply();

                            CorelistView.setVisibility(View.VISIBLE);
                            CoreChoose.setVisibility(View.VISIBLE);
                            SupportChoose.setVisibility(View.VISIBLE);
                            PlayerInformation.setVisibility(View.INVISIBLE);
                            Back.setVisibility(View.INVISIBLE);
                            Supports.remove(last_position);
                            SupportlistView.setAdapter(cupppAdapter);


                            Posi1.setVisibility(View.INVISIBLE);
                            Posi2.setVisibility(View.INVISIBLE);
                            Posi3.setVisibility(View.INVISIBLE);
                            Buy_Yes.setVisibility(View.VISIBLE);
                            Buy_No.setVisibility(View.VISIBLE);
                            SupportPick=false;
                            CorePick=false;
                        }
                        else
                        {
                            if(languageshare==2)
                            {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Not enough money", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                            else
                            {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Недостаточно денег", Toast.LENGTH_SHORT);
                                toast.show();
                            }


                        }

                    }

                    else
                    {


                        if(languageshare==2)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "position already taken", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Позиция занята", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    }
                }





            }
        });







        Posi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CorePick==true) {


                    if (team[2] == false) {
                        if(Integer.parseInt(Gold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                        {
                            Team[2].setText(PlayerNickName.getText());
                            Gold = String.valueOf(Integer.parseInt(Gold) - Integer.parseInt((String) PlayerCost.getText()));
                            Goldbalance.setText(Gold);

                            fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                            Fansbalance.setText(fansbalansed);

                            Pos3 = last_position_player;
                            team[2] = true;
                            playerseq[2] = last_position_player;
                            editor.putString(StaticPosition3, String.valueOf(playerseq[2]));
                            editor.putString(GoldBalance, String.valueOf(Gold));
                            editor.apply();

                            CorelistView.setVisibility(View.VISIBLE);
                            CoreChoose.setVisibility(View.VISIBLE);
                            SupportChoose.setVisibility(View.VISIBLE);
                            PlayerInformation.setVisibility(View.INVISIBLE);
                            Back.setVisibility(View.INVISIBLE);
                            Cores.remove(last_position);
                            CorelistView.setAdapter(coreAdapter);

                            Posi1.setVisibility(View.INVISIBLE);
                            Posi2.setVisibility(View.INVISIBLE);
                            Posi3.setVisibility(View.INVISIBLE);
                            Buy_Yes.setVisibility(View.VISIBLE);
                            Buy_No.setVisibility(View.VISIBLE);
                            SupportPick = false;
                            CorePick = false;
                        }
                        else
                        {
                            if(languageshare==2)
                            {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Not enough money", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                            else
                            {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Недостаточно денег", Toast.LENGTH_SHORT);
                                toast.show();
                            }


                        }

                    }

                    else
                    {


                        if(languageshare==2)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "position already taken", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Позиция занята", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    }

                }
                else
                {
                    if (team[4] == false) {

                        if(Integer.parseInt(Gold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                        {
                            Team[4].setText(PlayerNickName.getText());
                            Gold = String.valueOf(Integer.parseInt(Gold) - Integer.parseInt((String) PlayerCost.getText()));
                            Goldbalance.setText(Gold);

                            fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                            Fansbalance.setText(fansbalansed);

                            Pos5 = last_position_player;
                            team[4] = true;
                            playerseq[4] = last_position_player;
                            editor.putString(StaticPosition5, String.valueOf(playerseq[4]));
                            editor.putString(GoldBalance, String.valueOf(Gold));
                            editor.apply();

                            CorelistView.setVisibility(View.VISIBLE);
                            CoreChoose.setVisibility(View.VISIBLE);
                            SupportChoose.setVisibility(View.VISIBLE);
                            PlayerInformation.setVisibility(View.INVISIBLE);
                            Back.setVisibility(View.INVISIBLE);
                            Supports.remove(last_position);
                            SupportlistView.setAdapter(cupppAdapter);

                            Posi1.setVisibility(View.INVISIBLE);
                            Posi2.setVisibility(View.INVISIBLE);
                            Posi3.setVisibility(View.INVISIBLE);
                            Buy_Yes.setVisibility(View.VISIBLE);
                            Buy_No.setVisibility(View.VISIBLE);
                            SupportPick = false;
                            CorePick = false;


                        }
                        else
                        {
                            if(languageshare==2)
                            {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Not enough money", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                            else
                            {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Недостаточно денег", Toast.LENGTH_SHORT);
                                toast.show();
                            }


                        }

                    }

                    else
                    {


                        if(languageshare==2)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "position already taken", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Позиция занята", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    }

                }

            }
        });




        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAll();
            }
        });

        tostore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ToShop);

            }
        });

        toreward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToReward);
            }
        });
        torewardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToReward);
            }
        });








    }

    protected void HideAll()
    {
        PlayerInformation.setVisibility(View.INVISIBLE);
        Your_Team.setVisibility(View.INVISIBLE);
        Backtomain.setVisibility(View.INVISIBLE);
        scrollscroll.setVisibility(View.INVISIBLE);
        notmoneyhelp.setVisibility(View.VISIBLE);

    }

    protected void ShowAll()
    {
        scrollscroll.setVisibility(View.VISIBLE);
        PlayerInformation.setVisibility(View.VISIBLE);
        Your_Team.setVisibility(View.VISIBLE);
        Backtomain.setVisibility(View.VISIBLE);
        notmoneyhelp.setVisibility(View.INVISIBLE);

    }



    class CoreAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Cores.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.Titile);
            TextView Price = (TextView)convertView.findViewById(R.id.Price);

            //imageView.setImageResource(CoreIMAGES[position]);
            //textView.setText(CoreNAMES[position]);
            //Price.setText(CorePriceMoney[position]);


            imageView.setImageResource(Cores.get(position).Flag);
            textView.setText(Cores.get(position).Name);
            Price.setText(String.valueOf(Cores.get(position).Cost));






            return convertView;
        }
    }



    class suppoportAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Supports.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.Titile);
            TextView Price = (TextView)convertView.findViewById(R.id.Price);

            imageView.setImageResource(Supports.get(position).Flag);
            textView.setText(Supports.get(position).Name);
            Price.setText(String.valueOf(Supports.get(position).Cost));
            return convertView;
        }
    }




}
