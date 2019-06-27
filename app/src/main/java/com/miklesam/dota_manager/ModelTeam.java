package com.miklesam.dota_manager;

import java.io.Serializable;
import java.util.Comparator;

public class ModelTeam implements Serializable
{
    String TeamName;
    int logo;
    int w;
    int l;
    int seq;

    ModelTeam(String TeamName, int logo,int w, int l,int seq ){
        this.TeamName=TeamName;
        this.logo=logo;
        this.w=w;
        this.l=l;
        this.seq=seq;
    }

    public int getw(){
        return w;
    }


    @Override
    public String toString() {
        return "ModelMusic{" +
                "TeamName='" + TeamName + '\'' +
                ", w=" + w +
                ", l='" + l + '\'' +
                '}';
    }

    public static final Comparator<ModelTeam> COMPARE_BY_Winning = new Comparator<ModelTeam>() {
        @Override
        public int compare(ModelTeam lhs, ModelTeam rhs) {
            return rhs.getw() - lhs.getw();
        }
    };
}