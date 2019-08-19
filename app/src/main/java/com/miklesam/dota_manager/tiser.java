package com.miklesam.dota_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RelativeLayout;

public class tiser extends AppCompatActivity {

    CountDownTimer Mytimer;
    int mycnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiser);

        final RelativeLayout view= (RelativeLayout)findViewById(R.id.mainfon);
        final Intent ToMainmenu = new Intent(this, MainActivity.class);


        final int movie[]= new int[17];



        movie[0]=R.drawable.m1;
        movie[1]=R.drawable.m2;
        movie[2]=R.drawable.m3;
        movie[3]=R.drawable.m4;
        movie[4]=R.drawable.m5;
        movie[5]=R.drawable.m6;
        movie[6]=R.drawable.m7;
        movie[7]=R.drawable.m8;
        movie[8]=R.drawable.m9;
        movie[9]=R.drawable.mm10;
        movie[10]=R.drawable.mm11;
        movie[11]=R.drawable.mm12;
        movie[12]=R.drawable.mm13;
        movie[13]=R.drawable.mvm14;
        movie[14]=R.drawable.mvm15;
        movie[15]=R.drawable.mvm16;
        movie[16]=R.drawable.mvm17;


        Mytimer=  new CountDownTimer(1760, 110) {
            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
            public void onTick(long millisUntilFinished) {

                if(mycnt <16)
                {
                    mycnt++;
                }
                else
                {
                    mycnt =0;
                }

                view.setBackgroundResource(movie[mycnt]);


            }
            //Задаем действия после завершения отсчета (высвечиваем надпись "Бабах!"):
            public void onFinish() {
            startActivity(ToMainmenu);
            }

        }
                .start();











    }
}
