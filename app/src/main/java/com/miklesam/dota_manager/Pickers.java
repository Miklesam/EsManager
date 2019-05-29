package com.miklesam.dota_manager;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

abstract class Pickers {

    public String Pickername;
    public int seq;
    public ArrayList<Players> TeamRooster;

    Pickers(String Pickername,int seq, ArrayList<Players> TeamRooster)
    {
        this.Pickername=Pickername;
        this.seq=seq;
        this.TeamRooster=TeamRooster;
    }

    abstract int Pick(int pickstate, ArrayList<Heroes> heroes);


}


class EmpirePicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    EmpirePicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
        super(Pickername, seq, TeamRooster);



            for (int p=0;p<5;p++)
            {
                Integer count = map.get(TeamRooster.get(p).signature1);
                map.put(TeamRooster.get(p).signature1, (count == null) ? 1 : count + 1);
                Integer count2 = map.get(TeamRooster.get(p).signature2);
                map.put(TeamRooster.get(p).signature2, (count2 == null) ? 1 : count2 + 1);
                Integer count3 = map.get(TeamRooster.get(p).signature3);
                map.put(TeamRooster.get(p).signature3, (count3 == null) ? 1 : count3 + 1);

            }

       List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        String delimeter="=";
        mostpicked=new int[list.size()];
        for(int i = 0; i<list.size(); i++)
        {
            MaxValue=(String.valueOf(list.get(i))).split(delimeter);
            mostpicked[i]=Integer.parseInt(MaxValue[0]);
        }


        Log.v("map", String.valueOf(map));
        Log.v("list", String.valueOf(list));
        Log.v("first_elem", String.valueOf(list.get(0)));
        Log.v("MaxValue1", String.valueOf(MaxValue[0]));


        for(int i = 0; i < MaxValue.length; i++) {
           Log.v("MaxValue", String.valueOf(MaxValue[i]));
        }



    }



    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[6];
        mostbanned[0]=20;
        mostbanned[1]=21;
        mostbanned[2]=22;
        mostbanned[3]=23;
        mostbanned[4]=24;
        mostbanned[5]=25;

        if ((pickstate==1)||(pickstate==3)||(pickstate==5)||(pickstate==10)||(pickstate==12)||(pickstate==18))
        {

            for(int k=0;k<mostbanned.length;k++)
            {
                if (heroes.get(mostbanned[k]).baned==false)
                {
                    hero= mostbanned[k];
                    break;
                }

            }



        }
        else if ((pickstate==7)||(pickstate==8)||(pickstate==14)||(pickstate==16)||(pickstate==21))
        {
            for(int k=0;k<mostpicked.length;k++)
            {
                if (heroes.get(mostpicked[k]).baned==false)
                {
                    hero= mostpicked[k];
                    break;
                }

            }
        }





        return hero;
    }



}
