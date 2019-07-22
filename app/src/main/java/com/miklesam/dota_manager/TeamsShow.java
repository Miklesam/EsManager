package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Language;

public class TeamsShow extends AppCompatActivity {
    ListView TeamslistView;
    ArrayList<Teams> ThisTeams;
    LinearLayout TeamInfos;
    ListView teamroosts;
    ImageView Backinfo;
    ImageView FlagImage;
    ImageView signature1;
    ImageView signature2;
    ImageView signature3;
    ArrayList<Heroes> Heroeses= new ArrayList<Heroes>();
    int teampos;
    TextView PlayerNickname;
    TextView Descriptionplayer;

   TextView PlayerCost;
   TextView PlayerFans;


    TextView laning;
    TextView fighting;
    TextView farming;
    TextView supporting;
    int languageshare;

    ImageView faceima;

    boolean backteams;
    boolean lock;
    SharedPreferences mSettings;

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
        setContentView(R.layout.activity_teams_show);
        TeamInfos=findViewById(R.id.TeamInfo);
        TeamslistView = (ListView)findViewById(R.id.TeamList);
        teamroosts= (ListView)findViewById(R.id.teamroost);

        PlayerCost=findViewById(R.id.PlayerCost);
        PlayerFans=findViewById(R.id.PlayerFans);
        faceima=findViewById(R.id.faceima);
        AllTeams.clear();
        ThisTeams=AllTeamsInit();
        final TeamsAdapter teamsAdapter=new TeamsAdapter();
        Backinfo=findViewById(R.id.Backs);
        FlagImage=findViewById(R.id.FlagImage);
        PlayerNickname=findViewById(R.id.Nickname);

        signature1=findViewById(R.id.signature1);
        signature2=findViewById(R.id.signature2);
        signature3=findViewById(R.id.signature3);

        Descriptionplayer=findViewById(R.id.Description);
        laning=findViewById(R.id.laning);
        fighting=findViewById(R.id.fighting);
        farming=findViewById(R.id.farming);
        supporting=findViewById(R.id.supporting);


        final Intent ToMain = new Intent(this, MainActivity.class);

        TeamslistView.setAdapter(teamsAdapter);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        if(mSettings.contains(Language)) {
            languageshare=Integer.parseInt(mSettings.getString(Language, "0"));
        }

        Heroeses=HeroInit.HeroInit();

        Backinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (backteams==true)
                {
                    teamroosts.setVisibility(View.INVISIBLE);
                    TeamInfos.setVisibility(View.INVISIBLE);
                    TeamslistView.setVisibility(View.VISIBLE);
                     backteams=false;
                }
                else
                {
                    startActivity(ToMain);

                }


            }
            });


        TeamslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TeamslistView.setVisibility(View.INVISIBLE);
                TeamInfos.setVisibility(View.VISIBLE);
                teampos=position;
                final TeamsInfodapter teamsener=new TeamsInfodapter();
                teamroosts.setAdapter(teamsener);
                teamroosts.setVisibility(View.VISIBLE);
                backteams=true;



                FlagImage.setImageResource(AllTeams.get(teampos).Players.get(0).Flag);
                PlayerNickname.setText(String.valueOf(AllTeams.get(teampos).Players.get(0).Name));
                signature1.setImageResource(Heroeses.get(AllTeams.get(teampos).Players.get(0).signature1).picked);
                signature2.setImageResource(Heroeses.get(AllTeams.get(teampos).Players.get(0).signature2).picked);
                signature3.setImageResource(Heroeses.get(AllTeams.get(teampos).Players.get(0).signature3).picked);

                laning.setText("laning"+ String.valueOf(AllTeams.get(teampos).Players.get(0).laining));
                fighting.setText("fight"+String.valueOf(AllTeams.get(teampos).Players.get(0).fighting));
                farming.setText("farm"+String.valueOf(AllTeams.get(teampos).Players.get(0).farming));
                supporting.setText("late"+String.valueOf(AllTeams.get(teampos).Players.get(0).late));
                if(languageshare==2)
                {
                    Descriptionplayer.setText(String.valueOf(AllTeams.get(teampos).Players.get(0).EngDescription));
                }
                else
                {
                    Descriptionplayer.setText(String.valueOf(AllTeams.get(teampos).Players.get(0).Description));
                }


                PlayerCost.setText(String.valueOf(AllTeams.get(teampos).Players.get(0).Cost));
                PlayerFans.setText(String.valueOf(AllTeams.get(teampos).Players.get(0).fans));
                faceima.setImageResource(AllTeams.get(teampos).Players.get(0).face);


            }
        });



        teamroosts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                FlagImage.setImageResource(AllTeams.get(teampos).Players.get(position).Flag);
                PlayerNickname.setText(String.valueOf(AllTeams.get(teampos).Players.get(position).Name));
                signature1.setImageResource(Heroeses.get(AllTeams.get(teampos).Players.get(position).signature1).picked);
                signature2.setImageResource(Heroeses.get(AllTeams.get(teampos).Players.get(position).signature2).picked);
                signature3.setImageResource(Heroeses.get(AllTeams.get(teampos).Players.get(position).signature3).picked);

                laning.setText("laning"+String.valueOf(AllTeams.get(teampos).Players.get(position).laining));
                fighting.setText("fight"+String.valueOf(AllTeams.get(teampos).Players.get(position).fighting));
                farming.setText("farm"+String.valueOf(AllTeams.get(teampos).Players.get(position).farming));
                supporting.setText("late"+String.valueOf(AllTeams.get(teampos).Players.get(position).late));
                if(languageshare==2)
                {
                    Descriptionplayer.setText(String.valueOf(AllTeams.get(teampos).Players.get(position).EngDescription));
                }
                else
                {
                    Descriptionplayer.setText(String.valueOf(AllTeams.get(teampos).Players.get(position).Description));
                }
              

                PlayerCost.setText(String.valueOf(AllTeams.get(teampos).Players.get(position).Cost));
                PlayerFans.setText(String.valueOf(AllTeams.get(teampos).Players.get(position).fans));
                faceima.setImageResource(AllTeams.get(teampos).Players.get(position).face);

            }
        });





    }

    class TeamsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ThisTeams.size();
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

            convertView = getLayoutInflater().inflate(R.layout.teams_layout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.Titile);


            //imageView.setImageResource(CoreIMAGES[position]);
            //textView.setText(CoreNAMES[position]);
            //Price.setText(CorePriceMoney[position]);


            //imageView.setImageResource(ThisTeams.get(position).Flag);
            textView.setText(ThisTeams.get(position).teamname);
            imageView.setImageResource(ThisTeams.get(position).logo);
            //Price.setText(String.valueOf(Cores.get(position).Cost));






            return convertView;
        }
    }





    class TeamsInfodapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 5;
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

            convertView = getLayoutInflater().inflate(R.layout.teaminf,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.Titile);


            //imageView.setImageResource(CoreIMAGES[position]);
            //textView.setText(CoreNAMES[position]);
            //Price.setText(CorePriceMoney[position]);


            //imageView.setImageResource(ThisTeams.get(position).Flag);

            textView.setText(ThisTeams.get(teampos).Players.get(position).Name);
            imageView.setImageResource(ThisTeams.get(teampos).Players.get(position).Flag);
            //Price.setText(String.valueOf(Cores.get(position).Cost));






            return convertView;
        }
    }




}
