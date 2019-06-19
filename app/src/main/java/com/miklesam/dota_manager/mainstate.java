package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static com.miklesam.dota_manager.PlayersInit.AllPlayers;
import static com.miklesam.dota_manager.PlayersInit.PlayersAllInit;
import static com.miklesam.dota_manager.TeamsInit.AllTeams;

import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.Day;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.OpenQualiWinner;
import static com.miklesam.dota_manager.YourTeam.OpenTeam1;
import static com.miklesam.dota_manager.YourTeam.OpenTeam2;
import static com.miklesam.dota_manager.YourTeam.OpenTeam3;
import static com.miklesam.dota_manager.YourTeam.OpenTeam4;
import static com.miklesam.dota_manager.YourTeam.OpenTeam5;
import static com.miklesam.dota_manager.YourTeam.OpenTeam6;
import static com.miklesam.dota_manager.YourTeam.OpenTeam7;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;
import static com.miklesam.dota_manager.YourTeam.XPstatic;

public class mainstate extends AppCompatActivity {

    TextView TeamPosition[]= new TextView[5];
    Button Play_game;

    Button Market;
    Button Teamimprove;
    TextView Goldbalance;
    TextView TeamName;
    ListView CWList;
    ArrayList<Teams> TeamsCW;
    String YourTeam;
    TextView XPShow;
    TextView InfoBlock;
    int XPint;
    boolean cw;
    TextView DayText;
    int gamemode=0;

    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;
    int Dayint;
    int QualiWinner;
    int openqual[]= new int[7];
    ArrayList<Players> TheAllPlayers;

    boolean team[]=new boolean[5];
    boolean rosterok;
    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainstate);
       // mSettings = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        TeamPosition[0]=findViewById(R.id.teamposition1);
        TeamPosition[1]=findViewById(R.id.teamposition2);
        TeamPosition[2]=findViewById(R.id.teamposition3);
        TeamPosition[3]=findViewById(R.id.teamposition4);
        TeamPosition[4]=findViewById(R.id.teamposition5);
        Play_game=findViewById(R.id.Play_game);
        TeamName=findViewById(R.id.team_name);
        Goldbalance=findViewById(R.id.Goldbalance);
        XPShow=findViewById(R.id.XP);
        DayText=findViewById(R.id.Day);
        String Gold="1";
        YourTeam="Your Team";
        Market=findViewById(R.id.Market);
        Teamimprove=findViewById(R.id.Teamimprove);
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        final Intent ToOpenQuali = new Intent(this, OpenQuali.class);
        final Intent ToClosedQuali = new Intent(this, ClosedQuali.class);
        final Intent ToMarket = new Intent(this, market.class);
        final Intent ToImprove = new Intent(this, Improve.class);

        CWList = (ListView)findViewById(R.id.TeamCW);
        AllTeams.clear();
        TeamsCW=AllTeamsInit();
        InfoBlock=findViewById(R.id.InfoBlock);
        final CWAdapter CWteamsAdapter=new CWAdapter();
        CWList.setAdapter(CWteamsAdapter);


        final int won;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                won= 0;
            } else {
                won= extras.getInt("win");
            }
        } else {
            won= (int) savedInstanceState.getSerializable("win");
        }

        XPint=0;
        if(mSettings.contains(XPstatic)) {
            XPint=Integer.parseInt(mSettings.getString(XPstatic, "0"));
        }


        if(mSettings.contains(Day)) {
            Dayint=Integer.parseInt(mSettings.getString(Day, "0"));
        }

        if(mSettings.contains(OpenQualiWinner)) {

            QualiWinner =Integer.parseInt(mSettings.getString(OpenQualiWinner, "OpenQualiWinner"));

        }


        XPShow.setText(String.valueOf(XPint));
        SharedPreferences.Editor editor = mSettings.edit();




        DayText.setText(String.valueOf(Dayint));

        if (QualiWinner==1)
        {
            if (Dayint%3==0)
            {
                Play_game.setText("Close");
                gamemode=3;

            }
            else
            {
                Play_game.setText("Practice");
                gamemode=2;
            }
        }
        else
        {
            if (Dayint%3==0)
            {
                Play_game.setText("Open");
                gamemode=1;

            }
            else
            {
                Play_game.setText("Practice");
                gamemode=2;
            }
        }










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

        rosterok=team[0]&&team[1]&&team[2]&team[3]&&team[4];
        if(mSettings.contains(GoldBalance)) {

            Gold =mSettings.getString(GoldBalance, "50000");

        }

        if(mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam =mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

        }


        AllPlayers.clear();
        TheAllPlayers=PlayersAllInit();

        if(team[0]==true)
        {
            TeamPosition[0].setText(TheAllPlayers.get(Pos1).Name);
        }
        else
        {
            TeamPosition[0].setText("1");
        }

        if(team[1]==true)
        {
            TeamPosition[1].setText(TheAllPlayers.get(Pos2).Name);
        }
        else
        {
            TeamPosition[1].setText("2");
        }




        TeamPosition[2].setText(TheAllPlayers.get(Pos3).Name);
        TeamPosition[3].setText(TheAllPlayers.get(Pos4).Name);
        TeamPosition[4].setText(TheAllPlayers.get(Pos5).Name);
        Goldbalance.setText(Gold);
        TeamName.setText("Команда "+YourTeam);

        if(QualiWinner==1)
        {
            if(Dayint%3==0)
            {
                InfoBlock.setText("CloseQuali сегодня");
            }
            else
            {
                InfoBlock.setText("CloseQuali через "+ String.valueOf(3-Dayint%3) );
            }
        }
        else
        {
            if(Dayint%3==0)
            {
                InfoBlock.setText("OpenQuali сегодня");
            }
            else
            {
                InfoBlock.setText("OpenQuali через "+ String.valueOf(3-Dayint%3) );
            }

        }




        Play_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         // YourTeamIntent.putExtra("Name",TeamTag);
                if(rosterok==true)
                {



                if(gamemode==2)
                {
                    if (cw==false)
                    {
                        Play_game.setText("Отмена");
                        CWList.setVisibility(View.VISIBLE);
                        cw=true;

                    }
                    else
                    {
                        Play_game.setText("Игра");
                        CWList.setVisibility(View.INVISIBLE);
                        cw=false;
                    }
                } else if (gamemode==1) {


                    Random randomteam = new Random();
                    int whatteam=0;

                    for (int i=0;i<7;i++)
                    {
                        whatteam=randomteam.nextInt(TeamsCW.size());
                        openqual[i]=TeamsCW.get(whatteam).seq;
                        TeamsCW.remove(whatteam);

                    }

                    SharedPreferences.Editor editor = mSettings.edit();
                    editor.putString(OpenTeam1,String.valueOf(openqual[0]));
                    editor.putString(OpenTeam2,String.valueOf(openqual[1]));
                    editor.putString(OpenTeam3,String.valueOf(openqual[2]));
                    editor.putString(OpenTeam4,String.valueOf(openqual[3]));
                    editor.putString(OpenTeam5,String.valueOf(openqual[4]));
                    editor.putString(OpenTeam6,String.valueOf(openqual[5]));
                    editor.putString(OpenTeam7,String.valueOf(openqual[6]));
                    editor.apply();
                    startActivity(ToOpenQuali);
                }
                else if (gamemode==3)
                {
                    startActivity(ToClosedQuali);
                }


                }
                else
                {

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Укомплектуйте состав", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });



        CWList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                ToPickStage.putExtra("Position1",Pos1);
                ToPickStage.putExtra("Position2",Pos2);
                ToPickStage.putExtra("Position3",Pos3);
                ToPickStage.putExtra("Position4",Pos4);
                ToPickStage.putExtra("Position5",Pos5);

                ToPickStage.putExtra("EnemyTeam",AllTeams.get(position).seq);
                ToPickStage.putExtra("TeamName",YourTeam);
                ToPickStage.putExtra("TeamEnemy",TeamsCW.get(position).teamname);


                TeamsCW.clear();
                startActivity(ToPickStage);


            }
        });




        Market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(ToMarket);



            }
        });


        Teamimprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToImprove);



            }
        });







    }



    class CWAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return TeamsCW.size();
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

            convertView = getLayoutInflater().inflate(R.layout.cw_layout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.Titile);


            //imageView.setImageResource(CoreIMAGES[position]);
            //textView.setText(CoreNAMES[position]);
            //Price.setText(CorePriceMoney[position]);


            //imageView.setImageResource(ThisTeams.get(position).Flag);
            textView.setText(TeamsCW.get(position).teamname);

            //Price.setText(String.valueOf(Cores.get(position).Cost));






            return convertView;
        }
    }


}
