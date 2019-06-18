package com.miklesam.dota_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Improve extends AppCompatActivity {
    Button backtomain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);


        backtomain=findViewById(R.id.backtomain);
        final Intent Tomainstate = new Intent(this, mainstate.class);
        backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(Tomainstate);



            }
        });

    }
}
