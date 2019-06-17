package com.miklesam.dota_manager;

import android.widget.ImageView;

public class Heroes {
    public int largeban;
    public int minban;
    public int picked;
    public int hero_icon;
    public boolean baned;
    public int seq;
    public int mipmap;
    public int laining;
    public int farm;
    public int fighting;
    public int late;


    Heroes(int largeban, int minban, int picked,int hero_icon, int seq,int mipmap,int laining,int farm,int fighting,int late,boolean baned) {
      this.largeban=largeban;
      this.minban=minban;
      this.picked=picked;
      this.hero_icon=hero_icon;
      this.seq=seq;
      this.mipmap=mipmap;
      this.laining=laining;
      this.farm=farm;
      this.fighting=fighting;
      this.late=late;
      this.baned=baned;


    }


}






