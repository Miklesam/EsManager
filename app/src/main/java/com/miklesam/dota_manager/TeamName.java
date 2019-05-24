package com.miklesam.dota_manager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TeamName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_team_name);
        Button Next = findViewById(R.id.next);
        final EditText TeamName = findViewById(R.id.TeamName);


        final Intent YourTeamIntent = new Intent(this, YourTeam.class);


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
