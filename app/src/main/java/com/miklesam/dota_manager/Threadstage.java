package com.miklesam.dota_manager;

import java.util.concurrent.TimeUnit;

public class Threadstage implements Runnable {
    public static int cnt=0;

    @Override
    public void run() {
        while(true)
        {
         if (Pick_Stage.had_choosen==true)
         {
             cnt++;
             Pick_Stage.had_choosen=false;
         }

        }

    }
}



