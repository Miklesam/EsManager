package com.miklesam.dota_manager;

import java.util.ArrayList;

public class Teams {

    public String teamname;
    public ArrayList<Players> Players;
    public int seq;


    Teams(String teamname, ArrayList<Players> Players,int seq) {
        this.teamname=teamname;
        this.Players=Players;
        this.seq=seq;

    }
}
