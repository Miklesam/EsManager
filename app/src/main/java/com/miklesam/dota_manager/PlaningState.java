package com.miklesam.dota_manager;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.miklesam.dota_manager.HeroInit.AllHeroes;

public class PlaningState extends AppCompatActivity {

    int [] Hero =  new int[5];
    String [] Gamer =  new String[5];
    ImageView[] GameHero= new ImageView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_planing_state);

        GameHero[0]=findViewById(R.id.GameHero1);
        GameHero[1]=findViewById(R.id.GameHero2);
        GameHero[2]=findViewById(R.id.GameHero3);
        GameHero[3]=findViewById(R.id.GameHero4);
        GameHero[4]=findViewById(R.id.GameHero5);




        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                Hero[0]= 0;
                Hero[1]= 0;
                Hero[2]= 0;
                Hero[3]= 0;
                Hero[4]= 0;
                Gamer[0]=null;
                Gamer[1]=null;
                Gamer[2]=null;
                Gamer[3]=null;
                Gamer[4]=null;


            } else {
                Hero[0]= extras.getInt("Hero1");
                Hero[1]= extras.getInt("Hero2");
                Hero[2]= extras.getInt("Hero3");
                Hero[3]= extras.getInt("Hero4");
                Hero[4]= extras.getInt("Hero5");

                Gamer[0]=extras.getString("Position1");
                Gamer[1]=extras.getString("Position2");
                Gamer[2]=extras.getString("Position3");
                Gamer[3]=extras.getString("Position4");
                Gamer[4]=extras.getString("Position5");

            }
        } else {
            Hero[0]= (int) savedInstanceState.getSerializable("Hero1");
            Hero[1]= (int) savedInstanceState.getSerializable("Hero2");
            Hero[2]= (int) savedInstanceState.getSerializable("Hero3");
            Hero[3]= (int) savedInstanceState.getSerializable("Hero4");
            Hero[4]= (int) savedInstanceState.getSerializable("Hero5");

            Gamer[0]= (String) savedInstanceState.getSerializable("Position1");
            Gamer[1]= (String) savedInstanceState.getSerializable("Position2");
            Gamer[2]= (String) savedInstanceState.getSerializable("Position3");
            Gamer[3]= (String) savedInstanceState.getSerializable("Position4");
            Gamer[4]= (String) savedInstanceState.getSerializable("Position5");

        }

for(int i=0;i<5;i++)
{
    GameHero[i].setImageResource(AllHeroes.get(Hero[i]).picked);
}










        final Spinner spinner1 = (Spinner)findViewById(R.id.Spiner1);
        final Spinner spinner2 = (Spinner)findViewById(R.id.Spiner2);
        final Spinner spinner3 = (Spinner)findViewById(R.id.Spiner3);
        final Spinner spinner4 = (Spinner)findViewById(R.id.Spiner4);
        final Spinner spinner5 = (Spinner)findViewById(R.id.Spiner5);

        final Spinner Lanespinner1 = (Spinner)findViewById(R.id.LineSpiner1);
        final Spinner Lanespinner2 = (Spinner)findViewById(R.id.LineSpiner2);
        final Spinner Lanespinner3 = (Spinner)findViewById(R.id.LineSpiner3);
        final Spinner Lanespinner4 = (Spinner)findViewById(R.id.LineSpiner4);
        final Spinner Lanespinner5 = (Spinner)findViewById(R.id.LineSpiner5);

        String[] data = {String.valueOf(Hero[0]), String.valueOf(Hero[1]), String.valueOf(Hero[2]), String.valueOf(Hero[3]), String.valueOf(Hero[4])};
        String[] Lane = {"top","mid","bottom"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, Gamer);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> Laneadapter = new ArrayAdapter<String>(this, R.layout.spinner_item, Lane);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setAdapter(adapter);
        //spinner.setPrompt("Title");
        spinner1.setSelection(0);

        spinner2.setAdapter(adapter);
        spinner2.setSelection(1);

        spinner3.setAdapter(adapter);
        spinner3.setSelection(2);

        spinner4.setAdapter(adapter);
        spinner4.setSelection(3);

        spinner5.setAdapter(adapter);
        spinner5.setSelection(4);

        Lanespinner1.setAdapter(Laneadapter);
        Lanespinner1.setSelection(0);

        Lanespinner2.setAdapter(Laneadapter);
        Lanespinner2.setSelection(0);

        Lanespinner3.setAdapter(Laneadapter);
        Lanespinner3.setSelection(0);

        Lanespinner4.setAdapter(Laneadapter);
        Lanespinner4.setSelection(0);

        Lanespinner5.setAdapter(Laneadapter);
        Lanespinner5.setSelection(0);







        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {


                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }



                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
        }
}
