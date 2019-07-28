package com.miklesam.dota_manager;

import java.io.Serializable;
import java.util.Comparator;



public class Player_cost_shuffle implements Serializable
{
    Players Player;
    int Cost;


    Player_cost_shuffle(Players Player, int Cost){
        this.Player=Player;
        this.Cost=Cost;

    }

    public int getw(){
        return Cost;
    }


    @Override
    public String toString() {
        return "ModelMusic{" +
                ", Cost=" + Cost +
                '}';
    }

    public static final Comparator<Player_cost_shuffle> COMPARE_BY_Price = new Comparator<Player_cost_shuffle>() {
        @Override
        public int compare(Player_cost_shuffle lhs, Player_cost_shuffle rhs) {
            return lhs.getw() - rhs.getw()  ;
        }
    };



}