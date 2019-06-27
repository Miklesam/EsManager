package com.miklesam.dota_manager;

public class Players {

    public String Name;
    public String Description;
    public int Cost;
    public int Flag;

    public int laining;
    public int fighting;
    public int farming;
    public int late;

    public int signature1;
    public int signature2;
    public int signature3;

    public int sequence;
    public int fans;



    Players(int fans,String Name, String Description, int Cost,int Flag,int laining,int fighting, int farming, int late,int signature1, int signature2, int signature3, int sequence) {
        this.fans=fans;
        this.Name=Name;
        this.Description=Description;
        this.Cost=Cost;
        this.Flag=Flag;

        this.laining=laining;
        this.fighting=fighting;
        this.farming=farming;
        this.late=late;

        this.signature1=signature1;
        this.signature2=signature2;
        this.signature3=signature3;
        this.sequence=sequence;

    }



}
