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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static com.miklesam.dota_manager.HeroInit.AllHeroes;

import static com.miklesam.dota_manager.PlayersInit.CorePlayers;
import static com.miklesam.dota_manager.PlayersInit.PlayersCoreInit;
import static com.miklesam.dota_manager.PlayersInit.PlayersSupportInit;
import static com.miklesam.dota_manager.PlayersInit.SupportPlayers;
import static com.miklesam.dota_manager.YourTeam.*;

public class PlayerChoose extends AppCompatActivity {


    ListView CorelistView;
    ListView SupportlistView;
    ImageView CoreChoose;
    ImageView SupportChoose;
    LinearLayout PlayerInformation;
    TextView PlayerNickName;
    TextView PlayerDiscription;
    ImageView FlagIma;
    TextView GoldbalancePole;
    TextView Fansbalance;
    int last_position;

    TextView position1;
    TextView position2;
    TextView position3;
    TextView position4;
    TextView position5;

    ImageView Buy_Yes;
    ImageView Buy_No;
    ImageView Pos1;
    ImageView Pos2;
    ImageView Pos3;
    ImageView Back;
    String balancegold;
    SharedPreferences mSettings;

    TextView Laining;
    TextView Fighting;
    TextView Farming;
    TextView Supporting;
    TextView PlayerCost;
    TextView PlayerFans;


    ImageView Signature1;
    ImageView Signature2;
    ImageView Signature3;
    TextView TeamNameids;
    String fansbalansed;


    boolean team[]=new boolean[5];
    int playerseq[]=new int[5];
    int last_position_player;

    boolean CorePick;
    boolean SupportPick;
    boolean sup_pick;

     ArrayList<Players> Cores = new ArrayList<Players>();
     ArrayList<Players> Supports = new ArrayList<Players>();
     ArrayList <Heroes> DirectHero = new ArrayList<Heroes>();


    ImageView FacesImage;
    int languageshare;
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

    public void ClearNonStaticFlash()
    {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(Mode, "0");

        editor.putString(OpenQuaterFinals, "0");
        editor.putString(OpenSemiFinals, "0");
        editor.putString(OpenFinals, "0");

        editor.putString(OpenScore1, "0");
        editor.putString(OpenScore2, "0");
        editor.putString(OpenScore3, "0");
        editor.putString(OpenScore4, "0");

        editor.putString(OpenScore5, "0");
        editor.putString(OpenScore6, "0");
        editor.putString(OpenScore7, "0");
        editor.putString(OpenScore8, "0");

        editor.putString(OpenScore9, "0");
        editor.putString(OpenScore10, "0");
        editor.putString(OpenScore11, "0");
        editor.putString(OpenScore12, "0");


        editor.putString(QuaterWin, "0");
        editor.putString(SemiWin, "0");
        editor.putString(FinalsWin, "0");
        editor.putString(OpenQualiWinner, "0");
        editor.putString(ClosedSeries, "0");

        editor.putString(Closedwin, "0");
        editor.putString(Closedlose, "0");


        editor.putString(CloseWin8, "0");
        editor.putString(CloseWin7, "0");
        editor.putString(CloseWin6, "0");
        editor.putString(CloseWin5, "0");
        editor.putString(CloseWin4, "0");
        editor.putString(CloseWin3, "0");
        editor.putString(CloseWin2, "0");
        editor.putString(CloseWin1, "0");



        editor.putString(CloseLose8, "0");
        editor.putString(CloseLose7, "0");
        editor.putString(CloseLose6, "0");
        editor.putString(CloseLose5, "0");
        editor.putString(CloseLose4, "0");
        editor.putString(CloseLose3, "0");
        editor.putString(CloseLose2, "0");
        editor.putString(CloseLose1, "0");



        editor.putString(OpenShaffle, "0");
        editor.putString(CloseShaffle, "0");


        editor.putString(CloseTeam1, "0");
        editor.putString(CloseTeam2, "0");
        editor.putString(CloseTeam3, "0");
        editor.putString(CloseTeam4, "0");
        editor.putString(CloseTeam5, "0");
        editor.putString(CloseTeam6, "0");
        editor.putString(CloseTeam7, "0");

        editor.putString(TeamPlayoff1, "0");
        editor.putString(TeamPlayoff2, "0");
        editor.putString(TeamPlayoff3, "0");
        editor.putString(TeamPlayoff4, "0");

        editor.putString(ClosedPlayofStage, "1");







        editor.putString(ClosePlayoff1, "0");
        editor.putString(ClosePlayoff2, "0");
        editor.putString(ClosePlayoff3, "0");
        editor.putString(ClosePlayoff4, "0");
        editor.putString(ClosePlayoff5, "0");
        editor.putString(ClosePlayoff6, "0");
        editor.putString(ClosePlayoff7, "0");
        editor.putString(ClosePlayoff8, "0");
        editor.putString(ClosePlayoff9, "0");
        editor.putString(ClosePlayoff10, "0");
        editor.putString(ClosePlayoff11, "0");
        editor.putString(ClosePlayoff12, "0");



        editor.putString(CloseScore1, "0");
        editor.putString(CloseScore2, "0");
        editor.putString(CloseScore3, "0");
        editor.putString(CloseScore4, "0");
        editor.putString(CloseScore5, "0");
        editor.putString(CloseScore6, "0");
        editor.putString(CloseScore7, "0");
        editor.putString(CloseScore8, "0");
        editor.putString(CloseScore9, "0");
        editor.putString(CloseScore10, "0");
        editor.putString(CloseScore11, "0");
        editor.putString(CloseScore12, "0");

        editor.putString(Series1Win, "0");
        editor.putString(Series2Win, "0");
        editor.putString(Series3Win, "0");
        editor.putString(Series4Win, "0");
        editor.putString(Series5Win, "0");
        editor.putString(Series6Win, "0");
        editor.putString(Series7Win, "0");

        editor.putString(MinorScore1, "0");
        editor.putString(MinorScore2, "0");
        editor.putString(MinorScore3, "0");
        editor.putString(MinorScore4, "0");
        editor.putString(MinorScore5, "0");
        editor.putString(MinorScore6, "0");
        editor.putString(MinorScore7, "0");
        editor.putString(MinorScore8, "0");

        editor.putString(MinorWin1, "0");
        editor.putString(MinorWin2, "0");
        editor.putString(MinorWin3, "0");
        editor.putString(MinorWin4, "0");
        editor.putString(MinorWin5, "0");
        editor.putString(MinorWin6, "0");
        editor.putString(MinorWin7, "0");
        editor.putString(MinorWin8, "0");

        editor.putString(MinorLose1, "0");
        editor.putString(MinorLose2, "0");
        editor.putString(MinorLose3, "0");
        editor.putString(MinorLose4, "0");
        editor.putString(MinorLose5, "0");
        editor.putString(MinorLose6, "0");
        editor.putString(MinorLose7, "0");
        editor.putString(MinorLose8, "0");


        editor.putString(MinorPlayoff1, "0");
        editor.putString(MinorPlayoff2, "0");
        editor.putString(MinorPlayoff3, "0");
        editor.putString(MinorPlayoff4, "0");
        editor.putString(MinorPlayoff5, "0");
        editor.putString(MinorPlayoff6, "0");
        editor.putString(MinorStage, "1");


        editor.putString(MajorStage, "1");

        editor.putString(MajorScore1, "0");
        editor.putString(MajorScore2, "0");
        editor.putString(MajorScore3, "0");
        editor.putString(MajorScore4, "0");
        editor.putString(MajorScore5, "0");
        editor.putString(MajorScore6, "0");
        editor.putString(MajorScore7, "0");
        editor.putString(MajorScore8, "0");

        editor.putString(MajorWin1, "0");
        editor.putString(MajorWin2, "0");
        editor.putString(MajorWin3, "0");
        editor.putString(MajorWin4, "0");
        editor.putString(MajorWin5, "0");
        editor.putString(MajorWin6, "0");
        editor.putString(MajorWin7, "0");
        editor.putString(MajorWin8, "0");

        editor.putString(MajorLose1, "0");
        editor.putString(MajorLose2, "0");
        editor.putString(MajorLose3, "0");
        editor.putString(MajorLose4, "0");
        editor.putString(MajorLose5, "0");
        editor.putString(MajorLose6, "0");
        editor.putString(MajorLose7, "0");
        editor.putString(MajorLose8, "0");


        editor.putString(MajorSeries1, "0");
        editor.putString(MajorSeries2, "0");
        editor.putString(MajorSeries3, "0");
        editor.putString(MajorSeries4, "0");
        editor.putString(MajorSeries5, "0");
        editor.putString(MajorSeries6, "0");

        editor.putString(MajorPlayoff1, "0");
        editor.putString(MajorPlayoff2, "0");
        editor.putString(MajorPlayoff3, "0");
        editor.putString(MajorPlayoff4, "0");
        editor.putString(MajorPlayoff5, "0");
        editor.putString(MajorPlayoff6, "0");
        editor.putString(MajorPlayoff7, "0");
        editor.putString(MajorPlayoff8, "0");
        editor.putString(MajorPlayoff9, "0");
        editor.putString(MajorPlayoff10, "0");
        editor.putString(MajorPlayoff11, "0");
        editor.putString(MajorPlayoff12, "0");
        editor.putString(MajorPlayoff13, "0");
        editor.putString(MajorPlayoff14, "0");
        editor.putString(MajorPlayoff15, "0");
        editor.putString(MajorPlayoff16, "0");
        editor.putString(MajorPlayoff17, "0");
        editor.putString(MajorPlayoff18, "0");
        editor.putString(MajorPlayoff19, "0");
        editor.putString(MajorPlayoff20, "0");
        editor.putString(MajorPlayoff21, "0");
        editor.putString(MajorPlayoff22, "0");
        editor.putString(MajorPlayoff23, "0");


        editor.putString(WinnerorLossers, "0");


        editor.putString(MajorGroup1, "0");
        editor.putString(MajorGroup2, "0");
        editor.putString(MajorGroup3, "0");
        editor.putString(MajorGroup4, "0");
        editor.putString(MajorGroup5, "0");
        editor.putString(MajorGroup6, "0");
        editor.putString(MajorGroup7, "0");
        editor.putString(MajorGroup8, "0");
        editor.putString(MajorGroup9, "0");
        editor.putString(MajorGroup10, "0");
        editor.putString(MajorGroup11, "0");
        editor.putString(MajorGroup12, "0");
        editor.putString(MajorGroup13, "0");
        editor.putString(MajorGroup14, "0");
        editor.putString(MajorGroup15, "0");
        editor.putString(ShuffleMajor, "0");


        editor.putString(MajorPScore1, "0");
        editor.putString(MajorPScore2, "0");
        editor.putString(MajorPScore3, "0");
        editor.putString(MajorPScore4, "0");
        editor.putString(MajorPScore5, "0");
        editor.putString(MajorPScore6, "0");
        editor.putString(MajorPScore7, "0");
        editor.putString(MajorPScore8, "0");
        editor.putString(MajorPScore9, "0");
        editor.putString(MajorPScore10, "0");
        editor.putString(MajorPScore11, "0");
        editor.putString(MajorPScore12, "0");
        editor.putString(MajorPScore13, "0");
        editor.putString(MajorPScore14, "0");
        editor.putString(MajorPScore15, "0");
        editor.putString(MajorPScore16, "0");
        editor.putString(MajorPScore17, "0");
        editor.putString(MajorPScore18, "0");
        editor.putString(MajorPScore19, "0");
        editor.putString(MajorPScore20, "0");
        editor.putString(InMajor, "0");





        editor.putString(MajorPlayoffStage, "1");







        editor.putString(MinorQual,"0");
        editor.putString(NotMinor,"0");
        editor.apply();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_player_choose);
        final ImageView NextStage = findViewById(R.id.NextStage);
        CoreChoose =findViewById(R.id.Core);
        SupportChoose =findViewById(R.id.Support);
        PlayerInformation=findViewById(R.id.PlayerInfo);
        FlagIma=findViewById(R.id.FlagImage);
        PlayerNickName=findViewById(R.id.Nickname);
        PlayerDiscription=findViewById(R.id.Description);
        Buy_Yes=findViewById(R.id.Buy_Yes);
        Buy_No=findViewById(R.id.Buy_No);
        Pos1=findViewById(R.id.Pos1);
        Pos2=findViewById(R.id.Pos2);
        Pos3=findViewById(R.id.Pos3);
        Back=findViewById(R.id.Back);
        GoldbalancePole=findViewById(R.id.Goldbalance);
        PlayerFans=findViewById(R.id.PlayerFans);
        FacesImage=findViewById(R.id.FacesImage);
        Fansbalance=findViewById(R.id.Fansbalance);
        PlayerCost=findViewById(R.id.PlayerCost);
        TeamNameids=findViewById(R.id.Teamnameid);

        position1=findViewById(R.id.position1);
        position2=findViewById(R.id.position2);
        position3=findViewById(R.id.position3);
        position4=findViewById(R.id.position4);
        position5=findViewById(R.id.position5);

        Signature1=findViewById(R.id.signature1);
        Signature2=findViewById(R.id.signature2);
        Signature3=findViewById(R.id.signature3);

        Laining=findViewById(R.id.laning);
        Fighting=findViewById(R.id.fighting);
        Farming=findViewById(R.id.farming);
        Supporting=findViewById(R.id.supporting);


        AllHeroes.clear();
        CorePlayers.clear();
        SupportPlayers.clear();


        DirectHero.addAll(HeroInit.HeroInit());
        Cores=PlayersCoreInit();
        ArrayList<Player_cost_shuffle> Coressh = new ArrayList<>();
        for(int i=0;i<Cores.size();i++)
        {
            Coressh.add( new Player_cost_shuffle(Cores.get(i),Cores.get(i).Cost));
        }

        Collections.sort(Coressh, Player_cost_shuffle.COMPARE_BY_Price);
        Cores.clear();
        for(int i=0; i<Coressh.size();i++)
        {
            Cores.add(Coressh.get(i).Player);
        }



        Supports=PlayersSupportInit();
        Coressh.clear();
        for(int i=0;i<Supports.size();i++)
        {
            Coressh.add( new Player_cost_shuffle(Supports.get(i),Supports.get(i).Cost));
        }
        Collections.sort(Coressh, Player_cost_shuffle.COMPARE_BY_Price);
        Supports.clear();
        for(int i=0; i<Coressh.size();i++)
        {
            Supports.add(Coressh.get(i).Player);
        }
        Coressh.clear();



        for(int i=0;i<Cores.size();i++)
        {
            Coressh.add( new Player_cost_shuffle(Cores.get(i),Cores.get(i).Cost));
        }

        final Intent Tomainstate = new Intent(this, mainstate.class);

        CorelistView = (ListView)findViewById(R.id.CoreList);
        SupportlistView=(ListView)findViewById(R.id.SupportList);

        SupportlistView.setVisibility(View.INVISIBLE);

        final String TeamName;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                TeamName= null;
            } else {
                TeamName= extras.getString("TeamName");
            }
        } else {
            TeamName= (String) savedInstanceState.getSerializable("TeamName");
        }

        TeamNameids.setText(TeamName);
        final CustomAdapter customAdapter=new CustomAdapter();
        final SupportAdapter mysupAdapter=new SupportAdapter();
        CorelistView.setAdapter(customAdapter);
        SupportlistView.setAdapter(mysupAdapter);

        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        if(mSettings.contains(GoldBalance)) {

            balancegold =mSettings.getString(GoldBalance, "50000");

        }
        if(mSettings.contains(Fans)) {

            fansbalansed =mSettings.getString(Fans, "0");
        }
        if(mSettings.contains(Language)) {
            languageshare=Integer.parseInt(mSettings.getString(Language, "0"));
        }

        GoldbalancePole.setText(balancegold);
        Fansbalance.setText(fansbalansed);

        CorelistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CorePick=true;
                CorelistView.setVisibility(View.INVISIBLE);
                CoreChoose.setVisibility(View.INVISIBLE);
                SupportChoose.setVisibility(View.INVISIBLE);
                PlayerInformation.setVisibility(View.VISIBLE);

                FacesImage.setImageResource(Cores.get(position).face);
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

                Laining.setText("Laning "+ String.valueOf(Cores.get(position).laining));
                Fighting.setText("Fight "+ String.valueOf(Cores.get(position).fighting));
                Farming.setText("Farm "+ String.valueOf(Cores.get(position).farming));
                Supporting.setText("LateGame "+ String.valueOf(Cores.get(position).late));
                Signature1.setImageResource(AllHeroes.get(Cores.get(position).signature1).picked);
                Signature2.setImageResource(AllHeroes.get(Cores.get(position).signature2).picked);
                Signature3.setImageResource(AllHeroes.get(Cores.get(position).signature3).picked);
                last_position=position;
                last_position_player=Cores.get(position).sequence;

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



                FacesImage.setImageResource(Supports.get(position).face);
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

                Laining.setText("Laining "+ String.valueOf(Supports.get(position).laining));
                Fighting.setText("Fight "+ String.valueOf(Supports.get(position).fighting));
                Farming.setText("Farm "+ String.valueOf(Supports.get(position).farming));
                Supporting.setText("Lategame "+ String.valueOf(Supports.get(position).late));
                Signature1.setImageResource(AllHeroes.get(Supports.get(position).signature1).picked);
                Signature2.setImageResource(AllHeroes.get(Supports.get(position).signature2).picked);
                Signature3.setImageResource(AllHeroes.get(Supports.get(position).signature3).picked);

                last_position=position;
                last_position_player=Supports.get(position).sequence;

            }
        });







        NextStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = mSettings.edit();

                    ClearNonStaticFlash();
                    editor.putString(GoldBalance, balancegold);
                    editor.putString(Fans, fansbalansed);
                    editor.putString(XPstatic, "0");
                    editor.putString(Day, "1");
                    editor.putString(Month, "10");
                    editor.putString(Year, "0");
                    editor.putString(APP_PREFERENCES_NAME, TeamName);
                    editor.putString(ExtraLaining, "0");
                    editor.putString(ExtraFarming, "0");
                    editor.putString(ExtraFighting, "0");
                    editor.putString(ExtraLate, "0");
                    editor.putString(StaticPosition1,String.valueOf(playerseq[0]));
                    editor.putString(StaticPosition2,String.valueOf(playerseq[1]));
                    editor.putString(StaticPosition3,String.valueOf(playerseq[2]));
                    editor.putString(StaticPosition4,String.valueOf(playerseq[3]));
                    editor.putString(StaticPosition5,String.valueOf(playerseq[4]));





                    editor.apply();




                    //Gold=extras.getString("Gold");
                    //YourTeam=extras.getString("TeamName");


                    startActivity(Tomainstate);






            }
        });


        Buy_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CoreChoose.setVisibility(View.VISIBLE);
                SupportChoose.setVisibility(View.VISIBLE);
                PlayerInformation.setVisibility(View.INVISIBLE);
                if(SupportPick==true)
                {
                    SupportlistView.setVisibility(View.VISIBLE);
                }
                else
                {
                    CorelistView.setVisibility(View.VISIBLE);
                }
                SupportPick=false;
                CorePick=false;



            }
        });


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CoreChoose.setVisibility(View.VISIBLE);
                SupportChoose.setVisibility(View.VISIBLE);
                PlayerInformation.setVisibility(View.INVISIBLE);
                if(SupportPick==true)
                {
                    SupportlistView.setVisibility(View.VISIBLE);
                }
                else
                {
                    CorelistView.setVisibility(View.VISIBLE);
                }
                SupportPick=false;
                CorePick=false;
                Pos1.setVisibility(View.INVISIBLE);
                Pos2.setVisibility(View.INVISIBLE);
                Pos3.setVisibility(View.INVISIBLE);
                Back.setVisibility(View.INVISIBLE);
                Buy_Yes.setVisibility(View.VISIBLE);
                Buy_No.setVisibility(View.VISIBLE);

                if (sup_pick==true)
                {

                    sup_pick=false;
                    //Pos2.setText("Позиция 2");
                    Pos2.setImageResource(R.drawable.position_2);
                    Pos3.setImageResource(R.drawable.position_3);
                    //Pos3.setText("Позиция 3");
                }





            }
        });


        Buy_Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CorelistView.setVisibility(View.VISIBLE);
                //CoreChoose.setVisibility(View.VISIBLE);
                //SupportChoose.setVisibility(View.VISIBLE);
                //PlayerInformation.setVisibility(View.INVISIBLE);
                //balancegold=String.valueOf(Integer.parseInt(balancegold)-1000);
                //GoldbalancePole.setText("Золото "+balancegold);

                if(CorePick==true)
                {
                    Pos1.setVisibility(View.VISIBLE);
                    Pos2.setVisibility(View.VISIBLE);
                    Pos3.setVisibility(View.VISIBLE);
                    Back.setVisibility(View.VISIBLE);

                    Buy_Yes.setVisibility(View.INVISIBLE);
                    Buy_No.setVisibility(View.INVISIBLE);

                }
                else if (SupportPick==true)
                {
                    sup_pick=true;
                    //Pos2.setText("Позиция 4");
                    Pos2.setImageResource(R.drawable.position_4);
                    Pos2.setVisibility(View.VISIBLE);

                    //Pos3.setText("Позиция 5");
                    Pos3.setImageResource(R.drawable.position_5);
                    Pos3.setVisibility(View.VISIBLE);
                    Back.setVisibility(View.VISIBLE);

                    Buy_Yes.setVisibility(View.INVISIBLE);
                    Buy_No.setVisibility(View.INVISIBLE);

                }



            }
        });


        Pos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (team[0]==false)
                {
                if(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                {
                    position1.setText(PlayerNickName.getText());
                    balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText()));
                    GoldbalancePole.setText(balancegold);

                    fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                    Fansbalance.setText(fansbalansed);
                    team[0]=true;
                    playerseq[0]=last_position_player;
                    CorelistView.setVisibility(View.VISIBLE);
                    CoreChoose.setVisibility(View.VISIBLE);
                    SupportChoose.setVisibility(View.VISIBLE);
                    PlayerInformation.setVisibility(View.INVISIBLE);
                    Back.setVisibility(View.INVISIBLE);
                    Cores.remove(last_position);
                    CorelistView.setAdapter(customAdapter);

                    Pos1.setVisibility(View.INVISIBLE);
                    Pos2.setVisibility(View.INVISIBLE);
                    Pos3.setVisibility(View.INVISIBLE);
                    Buy_Yes.setVisibility(View.VISIBLE);
                    Buy_No.setVisibility(View.VISIBLE);
                    SupportPick=false;
                    CorePick=false;


                    if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                    {
                        NextStage.setVisibility(View.VISIBLE);
                    }
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

        Pos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sup_pick==true)
                {

                    if(team[3]==false)
                    {
                        if(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                        {
                            position4.setText(PlayerNickName.getText());
                            team[3]=true;
                            playerseq[3]=last_position_player;
                            balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText()));
                            GoldbalancePole.setText(balancegold);

                            fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                            Fansbalance.setText(fansbalansed);

                            SupportlistView.setVisibility(View.VISIBLE);
                            CoreChoose.setVisibility(View.VISIBLE);
                            SupportChoose.setVisibility(View.VISIBLE);
                            PlayerInformation.setVisibility(View.INVISIBLE);
                            Pos2.setImageResource(R.drawable.position_2);
                            Pos3.setImageResource(R.drawable.position_3);
                            //Pos2.setText("Позиция 2");
                            //Pos3.setText("Позиция 3");
                            Supports.remove(last_position);
                            SupportlistView.setAdapter(mysupAdapter);
                            sup_pick=false;
                            Back.setVisibility(View.INVISIBLE);
                            Pos1.setVisibility(View.INVISIBLE);
                            Pos2.setVisibility(View.INVISIBLE);
                            Pos3.setVisibility(View.INVISIBLE);
                            Buy_Yes.setVisibility(View.VISIBLE);
                            Buy_No.setVisibility(View.VISIBLE);
                            SupportPick=false;
                            CorePick=false;

                            if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                            {
                                NextStage.setVisibility(View.VISIBLE);
                            }
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


                    if (team[1]==false)
                    {
                        if(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                        {
                            position2.setText(PlayerNickName.getText());
                            team[1]=true;
                            playerseq[1]=last_position_player;
                            CorelistView.setVisibility(View.VISIBLE);
                            CoreChoose.setVisibility(View.VISIBLE);
                            SupportChoose.setVisibility(View.VISIBLE);
                            PlayerInformation.setVisibility(View.INVISIBLE);
                            Back.setVisibility(View.INVISIBLE);
                            balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText()));
                            GoldbalancePole.setText(balancegold);

                            fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                            Fansbalance.setText(fansbalansed);

                            Cores.remove(last_position);
                            CorelistView.setAdapter(customAdapter);


                            Pos1.setVisibility(View.INVISIBLE);
                            Pos2.setVisibility(View.INVISIBLE);
                            Pos3.setVisibility(View.INVISIBLE);
                            Buy_Yes.setVisibility(View.VISIBLE);
                            Buy_No.setVisibility(View.VISIBLE);
                            SupportPick=false;
                            CorePick=false;

                            if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                            {
                                NextStage.setVisibility(View.VISIBLE);
                            }
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


        Pos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sup_pick==true)
                {

                    if(team[4]==false)
                    {
                        if(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                        {
                            position5.setText(PlayerNickName.getText());
                            team[4]=true;
                            playerseq[4]=last_position_player;
                            SupportlistView.setVisibility(View.VISIBLE);
                            CoreChoose.setVisibility(View.VISIBLE);
                            SupportChoose.setVisibility(View.VISIBLE);
                            PlayerInformation.setVisibility(View.INVISIBLE);
                            //Pos2.setText("Позиция 2");
                            //Pos3.setText("Позиция 3");

                            Pos2.setImageResource(R.drawable.position_2);
                            Pos3.setImageResource(R.drawable.position_3);
                            Supports.remove(last_position);
                            SupportlistView.setAdapter(mysupAdapter);
                            sup_pick=false;
                            balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText()));
                            GoldbalancePole.setText(balancegold);

                            fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                            Fansbalance.setText(fansbalansed);

                            Back.setVisibility(View.INVISIBLE);
                            Pos1.setVisibility(View.INVISIBLE);
                            Pos2.setVisibility(View.INVISIBLE);
                            Pos3.setVisibility(View.INVISIBLE);
                            Buy_Yes.setVisibility(View.VISIBLE);
                            Buy_No.setVisibility(View.VISIBLE);
                            SupportPick=false;
                            CorePick=false;

                            if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                            {
                                NextStage.setVisibility(View.VISIBLE);
                            }
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


                    if (team[2]==false)
                    {
                        if(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText())>=0)
                        {
                            position3.setText(PlayerNickName.getText());
                            team[2]=true;
                            playerseq[2]=last_position_player;
                            CorelistView.setVisibility(View.VISIBLE);
                            CoreChoose.setVisibility(View.VISIBLE);
                            SupportChoose.setVisibility(View.VISIBLE);
                            PlayerInformation.setVisibility(View.INVISIBLE);
                            Back.setVisibility(View.INVISIBLE);
                            balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText()));
                            GoldbalancePole.setText(balancegold);

                            fansbalansed= String.valueOf(Integer.parseInt(fansbalansed)+ Integer.parseInt((String) PlayerFans.getText()));
                            Fansbalance.setText(fansbalansed);

                            Cores.remove(last_position);
                            CorelistView.setAdapter(customAdapter);

                            Pos1.setVisibility(View.INVISIBLE);
                            Pos2.setVisibility(View.INVISIBLE);
                            Pos3.setVisibility(View.INVISIBLE);
                            Buy_Yes.setVisibility(View.VISIBLE);
                            Buy_No.setVisibility(View.VISIBLE);
                            SupportPick=false;
                            CorePick=false;

                            if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                            {
                                NextStage.setVisibility(View.VISIBLE);
                            }
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



    }


    class CustomAdapter extends BaseAdapter {

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








    class SupportAdapter extends BaseAdapter {

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
