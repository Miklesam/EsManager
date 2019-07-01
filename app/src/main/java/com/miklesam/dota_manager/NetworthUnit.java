package com.miklesam.dota_manager;

import java.io.Serializable;
import java.util.Comparator;

public class NetworthUnit implements Serializable {
    public int color;
    public int networth;
    public int hero;

    NetworthUnit(int color,int networth,int hero)
    {
        this.color=color;
        this.networth=networth;
        this.hero=hero;
    }
    public int getnetworth(){
        return networth;
    }
    @Override
    public String toString() {
        return "ModelMusic{" +
                "color='" + color + '\'' +
                ", networth=" + networth +
                ", hero='" + hero + '\'' +
                '}';
    }
    public static final Comparator<NetworthUnit> COMPARE_BY_Networth = new Comparator<NetworthUnit>() {
        @Override
        public int compare(NetworthUnit lhs, NetworthUnit rhs) {
            return rhs.getnetworth() - lhs.getnetworth();
        }
    };

}






