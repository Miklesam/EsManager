package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.miklesam.dota_manager.HeroInit.AllHeroes;
import static com.miklesam.dota_manager.PlayersInit.PlayersCoreInit;
import static com.miklesam.dota_manager.PlayersInit.PlayersSupportInit;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

public class PlayerChoose extends AppCompatActivity {


    ListView CorelistView;
    ListView SupportlistView;
    Button CoreChoose;
    Button SupportChoose;
    LinearLayout PlayerInformation;
    TextView PlayerNickName;
    TextView PlayerDiscription;
    ImageView FlagIma;
    TextView GoldbalancePole;
    int last_position;

    TextView position1;
    TextView position2;
    TextView position3;
    TextView position4;
    TextView position5;

    Button Buy_Yes;
    Button Buy_No;
    Button Pos1;
    Button Pos2;
    Button Pos3;
    Button Back;
    String balancegold;
    SharedPreferences mSettings;

    TextView Laining;
    TextView Fighting;
    TextView Farming;
    TextView Supporting;
    TextView PlayerCost;


    ImageView Signature1;
    ImageView Signature2;
    ImageView Signature3;
    TextView TeamNameids;


    boolean team[]=new boolean[5];
    int playerseq[]=new int[5];
    int last_position_player;

    boolean CorePick;
    boolean SupportPick;
    boolean sup_pick;

     ArrayList<Players> Cores = new ArrayList<Players>();
     ArrayList<Players> Supports = new ArrayList<Players>();
     ArrayList <Heroes> DirectHero = new ArrayList<Heroes>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_player_choose);
        final Button NextStage = findViewById(R.id.NextStage);
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
        balancegold=GoldBalance;
        GoldbalancePole.setText(balancegold);
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

        DirectHero.addAll(HeroInit.HeroInit());

        Cores=PlayersCoreInit();
        Supports=PlayersSupportInit();

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

                FlagIma.setImageResource(Cores.get(position).Flag);
                PlayerNickName.setText(Cores.get(position).Name);
                PlayerDiscription.setText(Cores.get(position).Description);
                PlayerCost.setText(String.valueOf(Cores.get(position).Cost));


                Laining.setText("Лайнинг "+ String.valueOf(Cores.get(position).laining));
                Fighting.setText("Файтинг "+ String.valueOf(Cores.get(position).fighting));
                Farming.setText("Фарм "+ String.valueOf(Cores.get(position).farming));
                Supporting.setText("Поддержка "+ String.valueOf(Cores.get(position).supporting));
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


                //PlayerNickName.setText(SupportNAMES[position]);
                //PlayerDiscription.setText(SupportPriceMoney[position]);
                //FlagIma.setImageResource(SupportIMAGES[position]);


                FlagIma.setImageResource(Supports.get(position).Flag);
                PlayerNickName.setText(Supports.get(position).Name);
                PlayerDiscription.setText(Supports.get(position).Description);

                PlayerCost.setText(String.valueOf(Supports.get(position).Cost));


                Laining.setText("Лайнинг "+ String.valueOf(Supports.get(position).laining));
                Fighting.setText("Файтинг "+ String.valueOf(Supports.get(position).fighting));
                Farming.setText("Фарм "+ String.valueOf(Supports.get(position).farming));
                Supporting.setText("Поддержка "+ String.valueOf(Supports.get(position).supporting));
                last_position=position;
                last_position_player=Supports.get(position).sequence;

            }
        });







        NextStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(GoldBalance, balancegold);

                editor.putString(StaticPosition1,String.valueOf(playerseq[0]));
                editor.putString(StaticPosition2,String.valueOf(playerseq[1]));
                editor.putString(StaticPosition3,String.valueOf(playerseq[2]));
                editor.putString(StaticPosition4,String.valueOf(playerseq[3]));
                editor.putString(StaticPosition5,String.valueOf(playerseq[4]));

                editor.apply();

         Tomainstate.putExtra("Position1",playerseq[0]);
                Tomainstate.putExtra("Position2",playerseq[1]);
                Tomainstate.putExtra("Position3",playerseq[2]);
                Tomainstate.putExtra("Position4",playerseq[3]);
                Tomainstate.putExtra("Position5",playerseq[4]);
                Tomainstate.putExtra("Gold",balancegold);
                Tomainstate.putExtra("TeamName",TeamName);
                //Gold=extras.getString("Gold");
                //YourTeam=extras.getString("TeamName");


           startActivity(Tomainstate);

            }
        });


        Buy_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorelistView.setVisibility(View.VISIBLE);
                CoreChoose.setVisibility(View.VISIBLE);
                SupportChoose.setVisibility(View.VISIBLE);
                PlayerInformation.setVisibility(View.INVISIBLE);
                SupportPick=false;
                CorePick=false;


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
                Pos1.setVisibility(View.INVISIBLE);
                Pos2.setVisibility(View.INVISIBLE);
                Pos3.setVisibility(View.INVISIBLE);
                Back.setVisibility(View.INVISIBLE);
                Buy_Yes.setVisibility(View.VISIBLE);
                Buy_No.setVisibility(View.VISIBLE);

                if (sup_pick==true)
                {
                    sup_pick=false;
                    Pos2.setText("Позиция 2");
                    Pos3.setText("Позиция 3");
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
                    Pos2.setText("Позиция 4");
                    Pos2.setVisibility(View.VISIBLE);

                    Pos3.setText("Позиция 5");
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

                    position1.setText(PlayerNickName.getText());
                    balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText()));
                    GoldbalancePole.setText(balancegold);
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
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Позиция Занята", Toast.LENGTH_SHORT);
                    toast.show();
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
                        position4.setText(PlayerNickName.getText());
                        team[3]=true;
                        playerseq[3]=last_position_player;
                        balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText()));
                        GoldbalancePole.setText(balancegold);
                        CorelistView.setVisibility(View.VISIBLE);
                        CoreChoose.setVisibility(View.VISIBLE);
                        SupportChoose.setVisibility(View.VISIBLE);
                        PlayerInformation.setVisibility(View.INVISIBLE);
                        Pos2.setText("Позиция 2");
                        Pos3.setText("Позиция 3");
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
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Позиция Занята", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
                else
                {


                    if (team[1]==false)
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
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Позиция Занята", Toast.LENGTH_SHORT);
                        toast.show();
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
                        position5.setText(PlayerNickName.getText());
                        team[4]=true;
                        playerseq[4]=last_position_player;
                        CorelistView.setVisibility(View.VISIBLE);
                        CoreChoose.setVisibility(View.VISIBLE);
                        SupportChoose.setVisibility(View.VISIBLE);
                        PlayerInformation.setVisibility(View.INVISIBLE);
                        Pos2.setText("Позиция 2");
                        Pos3.setText("Позиция 3");
                        Supports.remove(last_position);
                        SupportlistView.setAdapter(mysupAdapter);
                        sup_pick=false;
                        balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerCost.getText()));
                        GoldbalancePole.setText(balancegold);
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
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Позиция Занята", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
                else
                {


                    if (team[2]==false)
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
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Позиция Занята", Toast.LENGTH_SHORT);
                        toast.show();
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
