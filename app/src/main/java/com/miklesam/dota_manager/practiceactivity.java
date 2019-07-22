package com.miklesam.dota_manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static com.miklesam.dota_manager.PlayersInit.AllPlayers;
import static com.miklesam.dota_manager.PlayersInit.PlayersAllInit;
import static com.miklesam.dota_manager.TeamsInit.AllTeams;
import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;
import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.Day;
import static com.miklesam.dota_manager.YourTeam.Fans;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Language;
import static com.miklesam.dota_manager.YourTeam.Month;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;
import static com.miklesam.dota_manager.YourTeam.XPstatic;
import static com.miklesam.dota_manager.YourTeam.Year;

public class practiceactivity extends AppCompatActivity {

    ImageView backmainstate;
    ListView CWList;
    ArrayList<Teams> TeamsCW;
    SharedPreferences mSettings;
    String YourTeam;
    LinearLayout solotrainigLinear;
    ImageView Teams;
    ImageView Solo;

    TextView PlayerName[]=new TextView[5];
    ImageView PlayersFlag[] = new ImageView[5];
    ImageView PlayersFace[] = new ImageView[5];
    Spinner spin[]=new Spinner[5];
    int Pos1=0;
    int Pos2=0;
    int Pos3=0;
    int Pos4=0;
    int Pos5=0;
    ImageView nextday;
    ArrayList<Players> TheAllPlayers;
    ScrollView scrollsolo;
    CountDownTimer Mytimer;
    TextView DayText;
    TextView MonthText;
    TextView YearText;
    TextView XPShow;
    TextView Goldbalance;
    TextView FansNumber;
    int activitys[]=new int[5];

    TextView XP;
    int XPint;
    int Dayint;

    String Gold;
    String fansbalansed;

    int Monthint;
    int Yearint;
    int languageshare;

boolean lock;



    boolean locknext;


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
        setContentView(R.layout.activity_practiceactivity);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        backmainstate=findViewById(R.id.backmainstate);
        YourTeam="Your Team";
        final Intent Tomainstate = new Intent(this, mainstate.class);
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);

        MonthText=findViewById(R.id.Month);
        YearText=findViewById(R.id.Year);
        solotrainigLinear=findViewById(R.id.solotrainigLinear);
        scrollsolo=findViewById(R.id.scrollsolo);
        nextday=findViewById(R.id.nextday);
        PlayerName[0]=findViewById(R.id.textplayer1);
        PlayerName[1]=findViewById(R.id.textplayer2);
        PlayerName[2]=findViewById(R.id.textplayer3);
        PlayerName[3]=findViewById(R.id.textplayer4);
        PlayerName[4]=findViewById(R.id.textplayer5);
        PlayersFlag[0]=findViewById(R.id.flag_player1);
        PlayersFlag[1]=findViewById(R.id.flag_player2);
        PlayersFlag[2]=findViewById(R.id.flag_player3);
        PlayersFlag[3]=findViewById(R.id.flag_player4);
        PlayersFlag[4]=findViewById(R.id.flag_player5);

        PlayersFace[0]=findViewById(R.id.face_1);
        PlayersFace[1]=findViewById(R.id.face_2);
        PlayersFace[2]=findViewById(R.id.face_3);
        PlayersFace[3]=findViewById(R.id.face_4);
        PlayersFace[4]=findViewById(R.id.face_5);

        spin[0]=findViewById(R.id.prspinner1);
        spin[1]=findViewById(R.id.prspinner2);
        spin[2]=findViewById(R.id.prspinner3);
        spin[3]=findViewById(R.id.prspinner4);
        spin[4]=findViewById(R.id.prspinner5);

        Goldbalance=findViewById(R.id.Goldbalance);
        XPShow=findViewById(R.id.XP);
        DayText=findViewById(R.id.Day);

        FansNumber=findViewById(R.id.FansNumber);

        Teams=findViewById(R.id.Teams);
        Solo=findViewById(R.id.Solo);
        XP=findViewById(R.id.XP);
        AllPlayers.clear();
        TheAllPlayers=PlayersAllInit();

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
        if(mSettings.contains(XPstatic)) {
            XPint=Integer.parseInt(mSettings.getString(XPstatic, "0"));
        }
        XP.setText(String.valueOf(XPint));

        if(mSettings.contains(Day)) {
            Dayint=Integer.parseInt(mSettings.getString(Day, "0"));
        }

        if(mSettings.contains(Month)) {
            Monthint=Integer.parseInt(mSettings.getString(Month, "0"));
        }
        if(mSettings.contains(Year)) {
            Yearint = Integer.parseInt(mSettings.getString(Year, "0"));
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

        DayText.setText(String.valueOf(Dayint));
        MonthText.setText(String.valueOf(Monthint));
        YearText.setText(String.valueOf(Yearint));

        PlayerName[0].setText(AllPlayers.get(Pos1).Name);
        PlayerName[1].setText(AllPlayers.get(Pos2).Name);
        PlayerName[2].setText(AllPlayers.get(Pos3).Name);
        PlayerName[3].setText(AllPlayers.get(Pos4).Name);
        PlayerName[4].setText(AllPlayers.get(Pos5).Name);

        PlayersFlag[0].setImageResource(AllPlayers.get(Pos1).Flag);
        PlayersFlag[1].setImageResource(AllPlayers.get(Pos2).Flag);
        PlayersFlag[2].setImageResource(AllPlayers.get(Pos3).Flag);
        PlayersFlag[3].setImageResource(AllPlayers.get(Pos4).Flag);
        PlayersFlag[4].setImageResource(AllPlayers.get(Pos5).Flag);

        PlayersFace[0].setImageResource(AllPlayers.get(Pos1).face);
        PlayersFace[1].setImageResource(AllPlayers.get(Pos2).face);
        PlayersFace[2].setImageResource(AllPlayers.get(Pos3).face);
        PlayersFace[3].setImageResource(AllPlayers.get(Pos4).face);
        PlayersFace[4].setImageResource(AllPlayers.get(Pos5).face);

        Goldbalance.setText(Gold);
        FansNumber.setText(fansbalansed);
        String[] practivity=new String[5];
        if (languageshare==2)
        {
            practivity[0] ="Relax";
            practivity[1] ="Game analysis";
            practivity[2] ="Strategies";
            practivity[3] ="Broadcast Stream";
            practivity[4] ="play mm";
        }
        else
            {
                practivity[0] ="Отдыхать";
                practivity[1] ="Анализ Реплеев";
                practivity[2] ="Стратегии";
                practivity[3] ="Стримить";
                practivity[4] ="Играть ММ";
            }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, practivity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for(int i=0;i<5;i++)
        {
            spin[i].setAdapter(adapter);
            spin[i].setSelection(i);
            activitys[i]=i;
            final int finalI = i;
            final int finalI1 = i;
            spin[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    activitys[finalI1]=position;
                }


                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
        }



        AllTeams.clear();
        TeamsCW=AllTeamsInit();

        final CWAdapter CWteamsAdapter=new CWAdapter();
        CWList.setAdapter(CWteamsAdapter);

        Teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                solotrainigLinear.setVisibility(View.INVISIBLE);
                nextday.setVisibility(View.INVISIBLE);
                scrollsolo.setVisibility(View.INVISIBLE);
                CWList.setVisibility(View.VISIBLE);
            }
        });
        Solo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextday.setVisibility(View.VISIBLE);
                solotrainigLinear.setVisibility(View.VISIBLE);
                scrollsolo.setVisibility(View.VISIBLE);
                CWList.setVisibility(View.INVISIBLE);
            }
        });

        nextday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (locknext==false)
                {
                    locknext=true;


                final String fans=fansbalansed;

                Mytimer=  new CountDownTimer(1000, 10) {
                    //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
                    public void onTick(long millisUntilFinished) {

                        fansbalansed=String.valueOf(Integer.parseInt(fansbalansed)+1);
                        FansNumber.setText(fansbalansed);

                    }
                    //Задаем действия после завершения отсчета (высвечиваем надпись "Бабах!"):
                    public void onFinish() {
                        int fansplus=0;
                        int xpsplus=0;
                        for(int k=0;k<5;k++)
                        {
                            if(activitys[k]==3)
                            {
                                fansplus++;
                            }
                            else if((activitys[k]==1)||(activitys[k]==2)||(activitys[k]==4))
                            {
                                xpsplus++;
                            }
                        }


                        FansNumber.setText(String.valueOf(Integer.parseInt(fans)+(fansplus*100)));
                        fansbalansed=String.valueOf(Integer.parseInt(fans)+(fansplus*100));
                        Mytimer.cancel();
                        SharedPreferences.Editor editor = mSettings.edit();
                        editor.putString(Fans,fansbalansed);
                        editor.putString(XPstatic,String.valueOf(XPint+xpsplus));


                        if(Dayint==30)
                        {
                            editor.putString(Day, "1");
                            if(Monthint==12)
                            {
                                editor.putString(Month, "0");
                                editor.putString(Year, String.valueOf(Yearint+1));
                            }
                            else{
                                editor.putString(Month, String.valueOf(Monthint+1));
                            }

                        }
                        else
                        {
                            editor.putString(Day,String.valueOf(Dayint+1));
                        }
                        editor.putString(GoldBalance, String.valueOf(Integer.parseInt(Gold)+(Integer.parseInt(fansbalansed)/100)));
                        editor.apply();
                        startActivity(Tomainstate);
                    }

                }
                        .start();



            }
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
