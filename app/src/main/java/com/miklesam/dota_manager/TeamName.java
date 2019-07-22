package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Language;

public class TeamName extends AppCompatActivity {

    boolean lock;
    SharedPreferences mSettings;
    int languageshare;
    TextView yourName;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_team_name);
        ImageView Next = findViewById(R.id.next);
        final EditText TeamName = findViewById(R.id.TeamName);
        yourName=findViewById(R.id.yourName);

        final Intent YourTeamIntent = new Intent(this, YourTeam.class);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        if(mSettings.contains(Language)) {
            languageshare=Integer.parseInt(mSettings.getString(Language, "0"));
        }
        if(languageshare==2)
        {
            yourName.setText("Enter your team name");
        }
        else
        {
            yourName.setText("Введите название команды");
        }



        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable EditName= TeamName.getText();
                String TeamTag = EditName.toString();
                YourTeamIntent.putExtra("Name",TeamTag);
                startActivity(YourTeamIntent);

            }
        });


    }
}
