package com.miklesam.dota_manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class mainstate extends AppCompatActivity {

    TextView TeamPosition[]= new TextView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainstate);

        TeamPosition[0]=findViewById(R.id.teamposition1);
        TeamPosition[1]=findViewById(R.id.teamposition2);
        TeamPosition[2]=findViewById(R.id.teamposition3);
        TeamPosition[3]=findViewById(R.id.teamposition4);
        TeamPosition[4]=findViewById(R.id.teamposition5);

        String Pos1;
        String Pos2;
        String Pos3;
        String Pos4;
        String Pos5;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                Pos1= null;
                Pos2= null;
                Pos3= null;
                Pos4= null;
                Pos5= null;

            } else {
                Pos1= extras.getString("Position1");
                Pos2= extras.getString("Position2");
                Pos3= extras.getString("Position3");
                Pos4= extras.getString("Position4");
                Pos5= extras.getString("Position5");
            }
        } else {
            Pos1= (String) savedInstanceState.getSerializable("Position1");
            Pos2= (String) savedInstanceState.getSerializable("Position2");
            Pos3= (String) savedInstanceState.getSerializable("Position3");
            Pos4= (String) savedInstanceState.getSerializable("Position4");
            Pos5= (String) savedInstanceState.getSerializable("Position5");
        }


        TeamPosition[0].setText(Pos1);
        TeamPosition[1].setText(Pos2);
        TeamPosition[2].setText(Pos3);
        TeamPosition[3].setText(Pos4);
        TeamPosition[4].setText(Pos5);

    }
}
