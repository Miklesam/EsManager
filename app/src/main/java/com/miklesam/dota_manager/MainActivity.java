package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Language;
import static com.miklesam.dota_manager.YourTeam.Mode;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

public class MainActivity extends AppCompatActivity {
    String Gold_to_Continie;
    String Your_team_name;
    int TournMode;
    ImageView language;
    boolean russian;
    int languageshare;

    SharedPreferences mSettings;
    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TypefaceUtil.overrideFont(getApplicationContext(), "SANS_SERIF", "fonts/16606.ttf");
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/16606.ttf");


        mSettings = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);


        final ImageView NewGame = findViewById(R.id.new_game);
        final ImageView Continue = findViewById(R.id.Continue);
        final ImageView Privacy=findViewById(R.id.Privacy);
        final ImageView Store = findViewById(R.id.shop);
        final ImageView Teams = findViewById(R.id.Teams);
        language=findViewById(R.id.language);

                //Continue.setTypeface(type);
                //NewGame.setTypeface(type);
                //Store.setTypeface(type);
                //Teams.setTypeface(type);

        final Intent NewGameIntent = new Intent(this, TeamName.class);
        final Intent ToMAinState = new Intent(this, mainstate.class);
        final Intent ToAbout = new Intent(this, about.class);
        final Intent ToTeamsShow = new Intent(this, TeamsShow.class);
        final Intent ToShop = new Intent(this, Shop.class);


        final String Player[]= new String[5];


        NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(NewGameIntent);

            }
        });

        if(mSettings.contains(StaticPosition1)) {
            Player[0]=mSettings.getString(StaticPosition1, "Position1");
        }

        if(mSettings.contains(StaticPosition2)) {
            Player[1]=mSettings.getString(StaticPosition2, "Position2");
        }

        if(mSettings.contains(StaticPosition3)) {
            Player[2]=mSettings.getString(StaticPosition3, "Position3");
        }

        if(mSettings.contains(StaticPosition4)) {
            Player[3]=mSettings.getString(StaticPosition4, "Position4");
        }

        if(mSettings.contains(StaticPosition5)) {
            Player[4]=mSettings.getString(StaticPosition5, "Position5");
        }


        if(mSettings.contains(Mode)) {
            TournMode=Integer.parseInt(mSettings.getString(Mode, "0"));
        }

        if(mSettings.contains(Language)) {
            languageshare=Integer.parseInt(mSettings.getString(Language, "0"));
        }




        if(languageshare==2)
        {
            russian=false;
            language.setImageResource(R.drawable.england);
            NewGame.setImageResource(R.drawable.new_game);
            Continue.setImageResource(R.drawable.continue_bttn);
            Privacy.setImageResource(R.drawable.about_project);
            Store.setImageResource(R.drawable.shop);
            Teams.setImageResource(R.drawable.teams);

        }
        else
        {
            russian=true;
            language.setImageResource(R.drawable.russia);
            NewGame.setImageResource(R.drawable.new_game_russian);
            Continue.setImageResource(R.drawable.continue_russian);
            Privacy.setImageResource(R.drawable.about_russian);
            Store.setImageResource(R.drawable.shop_russian);
            Teams.setImageResource(R.drawable.teams_russian);

        }



        if(mSettings.contains(GoldBalance)) {

            Gold_to_Continie =mSettings.getString(GoldBalance, "50000");

        }

        if(mSettings.contains(APP_PREFERENCES_NAME)) {

            Store.setVisibility(View.VISIBLE);
            Continue.setVisibility(View.VISIBLE);
            Your_team_name =mSettings.getString(APP_PREFERENCES_NAME, "Your Team");

        }


        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TournMode==1)
                {
                    //startActivity(ToOpenQuali);
                    startActivity(ToMAinState);

                }
                else
                {
                    ToMAinState.putExtra("Position1",Integer.parseInt(Player[0]));
                    ToMAinState.putExtra("Position2",Integer.parseInt(Player[1]));
                    ToMAinState.putExtra("Position3",Integer.parseInt(Player[2]));
                    ToMAinState.putExtra("Position4",Integer.parseInt(Player[3]));
                    ToMAinState.putExtra("Position5",Integer.parseInt(Player[4]));
                    ToMAinState.putExtra("Gold",Gold_to_Continie);
                    ToMAinState.putExtra("TeamName",Your_team_name);
                    startActivity(ToMAinState);
                }



            }
        });




        Teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToTeamsShow);

            }
        });

        Store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToShop);

            }
        });

        Privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(ToAbout);

            }
        });

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = mSettings.edit();
                if(russian==true)
                {
                    russian=false;
                    language.setImageResource(R.drawable.england);
                    NewGame.setImageResource(R.drawable.new_game);
                    Continue.setImageResource(R.drawable.continue_bttn);
                    Privacy.setImageResource(R.drawable.about_project);
                    Store.setImageResource(R.drawable.shop);
                    Teams.setImageResource(R.drawable.teams);
                    editor.putString(Language,"2");
                    editor.apply();
                }
                else
                {
                    russian=true;
                    language.setImageResource(R.drawable.russia);
                    NewGame.setImageResource(R.drawable.new_game_russian);
                    Continue.setImageResource(R.drawable.continue_russian);
                    Privacy.setImageResource(R.drawable.about_russian);
                    Store.setImageResource(R.drawable.shop_russian);
                    Teams.setImageResource(R.drawable.teams_russian);
                    editor.putString(Language,"1");
                    editor.apply();

                }



            }
        });



    }
}
