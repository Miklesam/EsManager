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

import java.util.ArrayList;

import static com.miklesam.dota_manager.PlayersInit.PlayersAllInit;
import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

public class mainstate extends AppCompatActivity {

    TextView TeamPosition[]= new TextView[5];
    Button Play_game;
    TextView Goldbalance;
    TextView TeamName;
    ListView CWList;
    ArrayList<Teams> TeamsCW;
    String YourTeam;
    boolean cw;

    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;
    ArrayList<Players> TheAllPlayers;

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
        String Gold="1";
        YourTeam="Your Team";
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        CWList = (ListView)findViewById(R.id.TeamCW);
        TeamsCW=AllTeamsInit();

        final CWAdapter CWteamsAdapter=new CWAdapter();


        CWList.setAdapter(CWteamsAdapter);










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

        if(mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam =mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

        }



        TheAllPlayers=PlayersAllInit();


        TeamPosition[0].setText(TheAllPlayers.get(Pos1).Name);
        TeamPosition[1].setText(TheAllPlayers.get(Pos2).Name);
        TeamPosition[2].setText(TheAllPlayers.get(Pos3).Name);
        TeamPosition[3].setText(TheAllPlayers.get(Pos4).Name);
        TeamPosition[4].setText(TheAllPlayers.get(Pos5).Name);
        Goldbalance.setText(Gold);
        TeamName.setText("Команда "+YourTeam);




        Play_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         // YourTeamIntent.putExtra("Name",TeamTag);
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



            }
        });



        CWList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //FlagIma.setImageResource(Supports.get(position).Flag);
                //PlayerNickName.setText(Supports.get(position).Name);
                //PlayerDiscription.setText(Supports.get(position).Description);

                //PlayerCost.setText(String.valueOf(Supports.get(position).Cost));


                //Laining.setText("Лайнинг "+ String.valueOf(Supports.get(position).laining));
                //Fighting.setText("Файтинг "+ String.valueOf(Supports.get(position).fighting));
                //Farming.setText("Фарм "+ String.valueOf(Supports.get(position).farming));
                //Supporting.setText("Поддержка "+ String.valueOf(Supports.get(position).supporting));
                //last_position=position;

                ToPickStage.putExtra("Position1",Pos1);
                ToPickStage.putExtra("Position2",Pos2);
                ToPickStage.putExtra("Position3",Pos3);
                ToPickStage.putExtra("Position4",Pos4);
                ToPickStage.putExtra("Position5",Pos5);

                ToPickStage.putExtra("EnemyTeam",AllTeams.get(position).seq);



                ToPickStage.putExtra("TeamName",YourTeam);
                ToPickStage.putExtra("TeamEnemy",TeamsCW.get(position).teamname);

                startActivity(ToPickStage);


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
