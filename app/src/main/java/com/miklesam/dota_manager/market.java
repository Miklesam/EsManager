package com.miklesam.dota_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class market extends AppCompatActivity {
Button Backtomain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);


        final Intent Tomainstate = new Intent(this, mainstate.class);
        Backtomain=findViewById(R.id.Backtomain);
        Backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(Tomainstate);



            }
        });



    }
}
