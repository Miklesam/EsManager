package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YourTeam extends AppCompatActivity {
    public static final String APP_PREFERENCES_NAME = "TeamName";
    public static final String GoldBalance = "50000";
    public static final String StaticPosition1 = "pos1";
    public static final String StaticPosition2 = "pos2";
    public static final String StaticPosition3 = "pos3";
    public static final String StaticPosition4 = "pos4";
    public static final String StaticPosition5 = "pos5";
    public static final String XPstatic= "xpstatic";
    public static final String Day= "daystatic";
    public static final String Mode= "modestatic";

    public static final String OpenTeam1= "open1";
    public static final String OpenTeam2= "open2";
    public static final String OpenTeam3= "open3";
    public static final String OpenTeam4= "open4";
    public static final String OpenTeam5= "open5";
    public static final String OpenTeam6= "open6";
    public static final String OpenTeam7= "open7";

    public static final String OpenScore1= "openscore1";
    public static final String OpenScore2= "openscore2";
    public static final String OpenScore3= "openscore3";
    public static final String OpenScore4= "openscore4";

    public static final String OpenScore5= "openscore5";
    public static final String OpenScore6= "openscore6";
    public static final String OpenScore7= "openscore7";
    public static final String OpenScore8= "openscore8";

    public static final String OpenQuaterFinals= "openquater";
    public static final String OpenSemiFinals= "opensemi";
    public static final String OpenFinals= "openfinals";

    public static final String QuaterWin= "QuaterWin";
    public static final String SemiWin= "SemiWin";
    public static final String FinalsWin= "FinalsWin";

    public static final String OpenScore9= "openscore9";
    public static final String OpenScore10= "openscore10";
    public static final String OpenScore11= "openscore11";
    public static final String OpenScore12= "openscore12";

    public static final String OpenQualiWinner= "OpenQualiWinner";


    public static final String ClosedSeries= "ClosedSeries";

    public static final String Closedwin= "Closedwin";
    public static final String Closedlose= "Closedlose";

    public static final String CloseWin7= "CloseWin7";
    public static final String CloseWin6= "CloseWin6";
    public static final String CloseWin5= "CloseWin5";
    public static final String CloseWin4= "CloseWin4";
    public static final String CloseWin3= "CloseWin3";
    public static final String CloseWin2= "CloseWin2";
    public static final String CloseWin1= "CloseWin1";


    public static final String CloseLose7= "CloseLose7";
    public static final String CloseLose6= "CloseLose6";
    public static final String CloseLose5= "CloseLose5";
    public static final String CloseLose4= "CloseLose4";
    public static final String CloseLose3= "CloseLose3";
    public static final String CloseLose2= "CloseLose2";
    public static final String CloseLose1= "CloseLose1";

    public static final String ExtraLaining= "ExtraLaining";
    public static final String ExtraFarming= "ExtraFarming";
    public static final String ExtraFighting= "ExtraFighting";
    public static final String ExtraLate= "ExtraLate";
    public static final String OpenShaffle= "OpenShaffle";
    public static final String CloseShaffle= "CloseShaffle";


    public static final String CloseTeam1= "close1";
    public static final String CloseTeam2= "close2";
    public static final String CloseTeam3= "close3";
    public static final String CloseTeam4= "close4";
    public static final String CloseTeam5= "close5";
    public static final String CloseTeam6= "close6";
    public static final String CloseTeam7= "close7";


    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_your_team);
        final Intent ChoosePlayer = new Intent(this, PlayerChoose.class);
        final TextView TeamTag=findViewById(R.id.TeamTag);
        TextView Gold=findViewById(R.id.gold);
        Button toPlayerChoose = findViewById(R.id.toPlayerChoose);
        mSettings = getSharedPreferences(APP_PREFERENCES_NAME , Context.MODE_PRIVATE);
        mSettings = getSharedPreferences(GoldBalance , Context.MODE_PRIVATE);



        final String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("Name");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("Name");
        }

        TeamTag.setText("Welcome\nTeam: "+newString);
        Gold.setText("У Вас 50000 рублей\n"+
        "Наберите игроков и управляйте командой");


        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_NAME, newString);
        editor.putString(GoldBalance, "50000");
        editor.apply();





        toPlayerChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoosePlayer.putExtra("TeamName",newString);
                startActivity(ChoosePlayer);

            }
        });




    }
}
