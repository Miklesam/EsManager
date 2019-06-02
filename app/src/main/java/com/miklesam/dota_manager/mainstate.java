package com.miklesam.dota_manager;

import android.content.Intent;
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

public class mainstate extends AppCompatActivity {

    TextView TeamPosition[]= new TextView[5];
    Button Play_game;
    TextView Goldbalance;
    TextView TeamName;
    ListView CWList;
    ArrayList<Teams> TeamsCW;
    String YourTeam;
    boolean cw;

    ArrayList<Players> TheAllPlayers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainstate);

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
                Gold=null;
                YourTeam=null;

            } else {
                Pos1= extras.getInt("Position1");
                Pos2= extras.getInt("Position2");
                Pos3= extras.getInt("Position3");
                Pos4= extras.getInt("Position4");
                Pos5= extras.getInt("Position5");
                Gold=extras.getString("Gold");
                YourTeam=extras.getString("TeamName");
            }
        } else {
            Pos1= (Integer) savedInstanceState.getSerializable("Position1");
            Pos2= (Integer) savedInstanceState.getSerializable("Position2");
            Pos3= (Integer) savedInstanceState.getSerializable("Position3");
            Pos4= (Integer) savedInstanceState.getSerializable("Position4");
            Pos5= (Integer) savedInstanceState.getSerializable("Position5");
            Gold= (String) savedInstanceState.getSerializable("Gold");
            YourTeam= (String) savedInstanceState.getSerializable("TeamName");
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
