package com.miklesam.dota_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;

public class PlayerChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_choose);

        Button NextStage = findViewById(R.id.NextStage);


        final Intent ToDraft = new Intent(this, Pick_Stage.class);


        NextStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           startActivity(ToDraft);

            }
        });



    }
}
