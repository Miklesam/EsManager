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
                Gold=null;
                YourTeam=null;

            } else {
                Pos1= extras.getString("Position1");
                Pos2= extras.getString("Position2");
                Pos3= extras.getString("Position3");
                Pos4= extras.getString("Position4");
                Pos5= extras.getString("Position5");
                Gold=extras.getString("Gold");
                YourTeam=extras.getString("TeamName");
            }
        } else {
            Pos1= (String) savedInstanceState.getSerializable("Position1");
            Pos2= (String) savedInstanceState.getSerializable("Position2");
            Pos3= (String) savedInstanceState.getSerializable("Position3");
            Pos4= (String) savedInstanceState.getSerializable("Position4");
            Pos5= (String) savedInstanceState.getSerializable("Position5");
            Gold= (String) savedInstanceState.getSerializable("Gold");
            YourTeam= (String) savedInstanceState.getSerializable("TeamName");
        }


        TeamPosition[0].setText(Pos1);
        TeamPosition[1].setText(Pos2);
        TeamPosition[2].setText(Pos3);
        TeamPosition[3].setText(Pos4);
        TeamPosition[4].setText(Pos5);
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
