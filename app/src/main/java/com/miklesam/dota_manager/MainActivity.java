package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.miklesam.dota_manager.YourTeam.APP_PREFERENCES_NAME;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettings = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);

        TextView TextName=findViewById(R.id.TestName);
        Button NewGame = findViewById(R.id.new_game);
        final Intent NewGameIntent = new Intent(this, TeamName.class);


        NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(NewGameIntent);

            }
        });

        if(mSettings.contains(APP_PREFERENCES_NAME)) {
            TextName.setText(mSettings.getString(APP_PREFERENCES_NAME, "TeamName"));
        }
    }
}
