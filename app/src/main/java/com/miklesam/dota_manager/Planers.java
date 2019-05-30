package com.miklesam.dota_manager;

import java.util.ArrayList;

import javax.crypto.CipherOutputStream;

abstract class Planers {

    public String Planername;
    public int seq;
    public ArrayList<Players> TeamRooster;

    Planers(String Planername,int seq, ArrayList<Players> TeamRooster)
    {
        this.Planername=Planername;
        this.seq=seq;
        this.TeamRooster=TeamRooster;
    }

    abstract ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5);

}

class EmpirePlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    EmpirePlaner(String Planername, int seq, ArrayList<Players> TeamRooster) {
        super(Planername, seq, TeamRooster);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(3);
        HeroAndLanes.add(3);
        HeroAndLanes.add(3);

        return HeroAndLanes;
    }



}
