package com.miklesam.dota_manager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mainstate extends AppCompatActivity {

    TextView TeamPosition[]= new TextView[5];
    Button Play_game;
    TextView Goldbalance;
    TextView TeamName;

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
        final Intent ToPickStage = new Intent(this, Pick_Stage.class);

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

            } else {
                Pos1= extras.getString("Position1");
                Pos2= extras.getString("Position2");
                Pos3= extras.getString("Position3");
                Pos4= extras.getString("Position4");
                Pos5= extras.getString("Position5");
                Gold=extras.getString("Gold");
            }
        } else {
            Pos1= (String) savedInstanceState.getSerializable("Position1");
            Pos2= (String) savedInstanceState.getSerializable("Position2");
            Pos3= (String) savedInstanceState.getSerializable("Position3");
            Pos4= (String) savedInstanceState.getSerializable("Position4");
            Pos5= (String) savedInstanceState.getSerializable("Position5");
            Gold= (String) savedInstanceState.getSerializable("Gold");
        }


        TeamPosition[0].setText(Pos1);
        TeamPosition[1].setText(Pos2);
        TeamPosition[2].setText(Pos3);
        TeamPosition[3].setText(Pos4);
        TeamPosition[4].setText(Pos5);
        Goldbalance.setText(Gold);
        TeamName.setText("Команда");




        Play_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                              // YourTeamIntent.putExtra("Name",TeamTag);



                ToPickStage.putExtra("Position1",Pos1);
                ToPickStage.putExtra("Position2",Pos2);
                ToPickStage.putExtra("Position3",Pos3);
                ToPickStage.putExtra("Position4",Pos4);
                ToPickStage.putExtra("Position5",Pos5);

                startActivity(ToPickStage);

            }
        });



    }
}
