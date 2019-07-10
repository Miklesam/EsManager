package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

public class practiceactivity extends AppCompatActivity {

    Button backmainstate;
    ListView CWList;
    ArrayList<Teams> TeamsCW;
    SharedPreferences mSettings;
    String YourTeam;
    LinearLayout solotrainigLinear;
    TextView Teams;
    TextView Solo;
    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practiceactivity);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        backmainstate=findViewById(R.id.backmainstate);
        YourTeam="Your Team";
        final Intent Tomainstate = new Intent(this, mainstate.class);
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);
        solotrainigLinear=findViewById(R.id.solotrainigLinear);

        Teams=findViewById(R.id.Teams);
        Solo=findViewById(R.id.Solo);


        CWList = (ListView)findViewById(R.id.TeamCW);

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
        if(mSettings.contains(APP_PREFERENCES_NAME)) {

            YourTeam =mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

        }



        AllTeams.clear();
        TeamsCW=AllTeamsInit();

        final CWAdapter CWteamsAdapter=new CWAdapter();
        CWList.setAdapter(CWteamsAdapter);

        Teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                solotrainigLinear.setVisibility(View.INVISIBLE);
                CWList.setVisibility(View.VISIBLE);
            }
        });
        Solo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                solotrainigLinear.setVisibility(View.VISIBLE);
                CWList.setVisibility(View.INVISIBLE);
            }
        });






        backmainstate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(Tomainstate);



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
            imageView.setImageResource(TeamsCW.get(position).logo);

            //Price.setText(String.valueOf(Cores.get(position).Cost));






            return convertView;
        }
    }

}
