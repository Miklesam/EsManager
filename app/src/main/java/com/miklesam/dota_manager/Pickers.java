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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=26;
        pick1[1]=80;
        pick1[2]=6;
        pick1[3]=4;
        pick1[4]=77;
        pick1[5]=9;


        pick2[0]=84;
        pick2[1]=98;
        pick2[2]=89;
        pick2[3]=76;
        pick2[4]=72;
        pick2[5]=0;
        pick2[6]=106;
        pick2[7]=115;


        pick3[0]=55;
        pick3[1]=68;
        pick3[2]=70;
        pick3[3]=38;
        pick3[4]=48;
        pick3[5]=59;
        pick3[6]=18;
        pick3[7]=69;
        pick3[8]=29;
        pick3[9]=51;

        pick4[0]=32;
        pick4[1]=57;
        pick4[2]=11;
        pick4[3]=34;
        pick4[4]=105;
        pick4[5]=94;
        pick4[6]=114;
        pick4[7]=58;
        pick4[8]=12;
        pick4[9]=20;
        pick4[10]=15;
        pick4[11]=27;

        pick5[0]=67;
        pick5[1]=99;
        pick5[2]=108;
        pick5[3]=16;
        pick5[4]=61;
        pick5[5]=83;
        pick5[6]=88;
        pick5[7]=96;
        pick5[8]=54;
        pick5[9]=42;
        pick5[10]=53;
        pick5[11]=1;
        pick5[12]=39;
        pick5[13]=65;


        mostbanned[0]=86;
        mostbanned[1]=9;
        mostbanned[2]=57;
        mostbanned[3]=80;
        mostbanned[4]=77;
        mostbanned[5]=99;
        mostbanned[6]=51;
        mostbanned[7]=26;
        mostbanned[8]=98;
        mostbanned[9]=44;
        mostbanned[10]=67;
        mostbanned[11]=0;
        mostbanned[12]=55;
        mostbanned[13]=6;
        mostbanned[14]=69;
        mostbanned[15]=32;
        mostbanned[16]=11;
        mostbanned[17]=95;
        mostbanned[18]=38;
        mostbanned[19]=91;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}

class VPPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    VPPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=80;
        pick1[1]=26;
        pick1[2]=77;
        pick1[3]=24;
        pick1[4]=30;
        pick1[5]=58;


        pick2[0]=112;
        pick2[1]=84;
        pick2[2]=23;
        pick2[3]=95;
        pick2[4]=98;
        pick2[5]=0;
        pick2[6]=115;
        pick2[7]=82;


        pick3[0]=11;
        pick3[1]=12;
        pick3[2]=105;
        pick3[3]=57;
        pick3[4]=104;
        pick3[5]=94;
        pick3[6]=34;
        pick3[7]=28;
        pick3[8]=87;
        pick3[9]=103;

        pick4[0]=29;
        pick4[1]=18;
        pick4[2]=69;
        pick4[3]=68;
        pick4[4]=66;
        pick4[5]=60;
        pick4[6]=56;
        pick4[7]=37;
        pick4[8]=51;
        pick4[9]=38;
        pick4[10]=42;
        pick4[11]=70;

        pick5[0]=45;
        pick5[1]=67;
        pick5[2]=108;
        pick5[3]=99;
        pick5[4]=88;
        pick5[5]=83;
        pick5[6]=100;
        pick5[7]=63;
        pick5[8]=61;
        pick5[9]=102;
        pick5[10]=52;
        pick5[11]=1;
        pick5[12]=10;
        pick5[13]=17;


        mostbanned[0]=15;
        mostbanned[1]=78;
        mostbanned[2]=6;
        mostbanned[3]=67;
        mostbanned[4]=86;
        mostbanned[5]=57;
        mostbanned[6]=9;
        mostbanned[7]=0;
        mostbanned[8]=98;
        mostbanned[9]=108;
        mostbanned[10]=29;
        mostbanned[11]=77;
        mostbanned[12]=45;
        mostbanned[13]=56;
        mostbanned[14]=18;
        mostbanned[15]=55;
        mostbanned[16]=99;
        mostbanned[17]=80;
        mostbanned[18]=26;
        mostbanned[19]=44;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}


class NaviPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    NaviPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=84;
        pick1[1]=114;
        pick1[2]=89;
        pick1[3]=72;
        pick1[4]=78;
        pick1[5]=76;


        pick2[0]=6;
        pick2[1]=80;
        pick2[2]=2;
        pick2[3]=26;
        pick2[4]=4;
        pick2[5]=30;
        pick2[6]=3;
        pick2[7]=36;


        pick3[0]=77;
        pick3[1]=11;
        pick3[2]=57;
        pick3[3]=105;
        pick3[4]=90;
        pick3[5]=104;
        pick3[6]=32;
        pick3[7]=94;
        pick3[8]=12;
        pick3[9]=33;

        pick4[0]=37;
        pick4[1]=18;
        pick4[2]=66;
        pick4[3]=70;
        pick4[4]=29;
        pick4[5]=69;
        pick4[6]=74;
        pick4[7]=48;
        pick4[8]=59;
        pick4[9]=68;
        pick4[10]=60;
        pick4[11]=47;

        pick5[0]=67;
        pick5[1]=45;
        pick5[2]=65;
        pick5[3]=51;
        pick5[4]=108;
        pick5[5]=1;
        pick5[6]=91;
        pick5[7]=100;
        pick5[8]=99;
        pick5[9]=54;
        pick5[10]=93;
        pick5[11]=83;
        pick5[12]=10;
        pick5[13]=96;


        mostbanned[0]=55;
        mostbanned[1]=98;
        mostbanned[2]=61;
        mostbanned[3]=9;
        mostbanned[4]=69;
        mostbanned[5]=86;
        mostbanned[6]=95;
        mostbanned[7]=80;
        mostbanned[8]=99;
        mostbanned[9]=108;
        mostbanned[10]=44;
        mostbanned[11]=105;
        mostbanned[12]=57;
        mostbanned[13]=26;
        mostbanned[14]=96;
        mostbanned[15]=49;
        mostbanned[16]=0;
        mostbanned[17]=18;
        mostbanned[18]=56;
        mostbanned[19]=1;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}

class GambitPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    GambitPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=11;
        pick1[1]=57;
        pick1[2]=79;
        pick1[3]=34;
        pick1[4]=81;
        pick1[5]=41;


        pick2[0]=49;
        pick2[1]=37;
        pick2[2]=69;
        pick2[3]=18;
        pick2[4]=74;
        pick2[5]=70;
        pick2[6]=48;
        pick2[7]=51;


        pick3[0]=76;
        pick3[1]=114;
        pick3[2]=78;
        pick3[3]=4;
        pick3[4]=112;
        pick3[5]=105;
        pick3[6]=104;
        pick3[7]=106;
        pick3[8]=84;
        pick3[9]=89;

        pick4[0]=6;
        pick4[1]=3;
        pick4[2]=19;
        pick4[3]=95;
        pick4[4]=80;
        pick4[5]=58;
        pick4[6]=30;
        pick4[7]=77;
        pick4[8]=26;
        pick4[9]=35;
        pick4[10]=5;
        pick4[11]=22;

        pick5[0]=99;
        pick5[1]=91;
        pick5[2]=63;
        pick5[3]=108;
        pick5[4]=16;
        pick5[5]=45;
        pick5[6]=61;
        pick5[7]=102;
        pick5[8]=54;
        pick5[9]=55;
        pick5[10]=65;
        pick5[11]=32;
        pick5[12]=17;
        pick5[13]=106;


        mostbanned[0]=29;
        mostbanned[1]=67;
        mostbanned[2]=15;
        mostbanned[3]=98;
        mostbanned[4]=45;
        mostbanned[5]=55;
        mostbanned[6]=26;
        mostbanned[7]=48;
        mostbanned[8]=77;
        mostbanned[9]=57;
        mostbanned[10]=80;
        mostbanned[11]=12;
        mostbanned[12]=69;
        mostbanned[13]=4;
        mostbanned[14]=61;
        mostbanned[15]=18;
        mostbanned[16]=51;
        mostbanned[17]=56;
        mostbanned[18]=99;
        mostbanned[19]=9;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }


        return hero;
    }



}



class OldButGoldPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    OldButGoldPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=26;
        pick1[1]=80;
        pick1[2]=6;
        pick1[3]=91;
        pick1[4]=95;
        pick1[5]=12;


        pick2[0]=98;
        pick2[1]=89;
        pick2[2]=115;
        pick2[3]=76;
        pick2[4]=112;
        pick2[5]=106;
        pick2[6]=114;
        pick2[7]=81;


        pick3[0]=32;
        pick3[1]=57;
        pick3[2]=28;
        pick3[3]=11;
        pick3[4]=12;
        pick3[5]=79;
        pick3[6]=34;
        pick3[7]=81;
        pick3[8]=105;
        pick3[9]=104;

        pick4[0]=63;
        pick4[1]=83;
        pick4[2]=67;
        pick4[3]=61;
        pick4[4]=93;
        pick4[5]=16;
        pick4[6]=45;
        pick4[7]=99;
        pick4[8]=108;
        pick4[9]=102;
        pick4[10]=54;
        pick4[11]=65;

        pick5[0]=7;
        pick5[1]=64;
        pick5[2]=51;
        pick5[3]=66;
        pick5[4]=38;
        pick5[5]=18;
        pick5[6]=69;
        pick5[7]=60;
        pick5[8]=68;
        pick5[9]=37;
        pick5[10]=70;
        pick5[11]=74;
        pick5[12]=29;
        pick5[13]=47;


        mostbanned[0]=15;
        mostbanned[1]=86;
        mostbanned[2]=78;
        mostbanned[3]=26;
        mostbanned[4]=98;
        mostbanned[5]=57;
        mostbanned[6]=77;
        mostbanned[7]=12;
        mostbanned[8]=55;
        mostbanned[9]=65;
        mostbanned[10]=9;
        mostbanned[11]=67;
        mostbanned[12]=30;
        mostbanned[13]=61;
        mostbanned[14]=96;
        mostbanned[15]=100;
        mostbanned[16]=3;
        mostbanned[17]=108;
        mostbanned[18]=89;
        mostbanned[19]=54;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}




class WinstrikePicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    WinstrikePicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=103;
        pick1[1]=15;
        pick1[2]=11;
        pick1[3]=12;
        pick1[4]=57;
        pick1[5]=109;


        pick2[0]=78;
        pick2[1]=76;
        pick2[2]=98;
        pick2[3]=28;
        pick2[4]=106;
        pick2[5]=112;
        pick2[6]=114;
        pick2[7]=115;


        pick3[0]=29;
        pick3[1]=37;
        pick3[2]=55;
        pick3[3]=45;
        pick3[4]=17;
        pick3[5]=48;
        pick3[6]=69;
        pick3[7]=18;
        pick3[8]=50;
        pick3[9]=74;

        pick4[0]=26;
        pick4[1]=3;
        pick4[2]=9;
        pick4[3]=6;
        pick4[4]=22;
        pick4[5]=95;
        pick4[6]=17;
        pick4[7]=4;
        pick4[8]=5;
        pick4[9]=8;
        pick4[10]=30;
        pick4[11]=35;

        pick5[0]=67;
        pick5[1]=108;
        pick5[2]=102;
        pick5[3]=99;
        pick5[4]=65;
        pick5[5]=63;
        pick5[6]=54;
        pick5[7]=1;
        pick5[8]=93;
        pick5[9]=61;
        pick5[10]=16;
        pick5[11]=83;
        pick5[12]=88;
        pick5[13]=96;


        mostbanned[0]=77;
        mostbanned[1]=87;
        mostbanned[2]=86;
        mostbanned[3]=29;
        mostbanned[4]=57;
        mostbanned[5]=98;
        mostbanned[6]=56;
        mostbanned[7]=26;
        mostbanned[8]=80;
        mostbanned[9]=95;
        mostbanned[10]=45;
        mostbanned[11]=67;
        mostbanned[12]=44;
        mostbanned[13]=69;
        mostbanned[14]=18;
        mostbanned[15]=93;
        mostbanned[16]=105;
        mostbanned[17]=0;
        mostbanned[18]=9;
        mostbanned[19]=19;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}





class BHGPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    BHGPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=98;
        pick1[1]=0;
        pick1[2]=76;
        pick1[3]=89;
        pick1[4]=106;
        pick1[5]=115;


        pick2[0]=54;
        pick2[1]=91;
        pick2[2]=67;
        pick2[3]=65;
        pick2[4]=108;
        pick2[5]=99;
        pick2[6]=83;
        pick2[7]=16;


        pick3[0]=77;
        pick3[1]=86;
        pick3[2]=26;
        pick3[3]=9;
        pick3[4]=27;
        pick3[5]=35;
        pick3[6]=23;
        pick3[7]=20;
        pick3[8]=8;
        pick3[9]=5;

        pick4[0]=57;
        pick4[1]=105;
        pick4[2]=12;
        pick4[3]=32;
        pick4[4]=11;
        pick4[5]=34;
        pick4[6]=103;
        pick4[7]=87;
        pick4[8]=104;
        pick4[9]=15;
        pick4[10]=94;
        pick4[11]=114;

        pick5[0]=51;
        pick5[1]=37;
        pick5[2]=69;
        pick5[3]=7;
        pick5[4]=49;
        pick5[5]=60;
        pick5[6]=56;
        pick5[7]=48;
        pick5[8]=18;
        pick5[9]=70;
        pick5[10]=68;
        pick5[11]=29;
        pick5[12]=17;
        pick5[13]=46;


        mostbanned[0]=80;
        mostbanned[1]=4;
        mostbanned[2]=61;
        mostbanned[3]=105;
        mostbanned[4]=99;
        mostbanned[5]=57;
        mostbanned[6]=86;
        mostbanned[7]=44;
        mostbanned[8]=55;
        mostbanned[9]=77;
        mostbanned[10]=98;
        mostbanned[11]=54;
        mostbanned[12]=9;
        mostbanned[13]=68;
        mostbanned[14]=49;
        mostbanned[15]=38;
        mostbanned[16]=60;
        mostbanned[17]=56;
        mostbanned[18]=45;
        mostbanned[19]=58;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}



class FantasticFivePicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    FantasticFivePicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=11;
        pick1[1]=41;
        pick1[2]=34;
        pick1[3]=22;
        pick1[4]=28;
        pick1[5]=33;


        pick2[0]=98;
        pick2[1]=84;
        pick2[2]=97;
        pick2[3]=76;
        pick2[4]=115;
        pick2[5]=104;
        pick2[6]=72;
        pick2[7]=114;


        pick3[0]=80;
        pick3[1]=26;
        pick3[2]=27;
        pick3[3]=77;
        pick3[4]=42;
        pick3[5]=2;
        pick3[6]=17;
        pick3[7]=31;
        pick3[8]=113;
        pick3[9]=6;

        pick4[0]=100;
        pick4[1]=99;
        pick4[2]=83;
        pick4[3]=1;
        pick4[4]=102;
        pick4[5]=93;
        pick4[6]=88;
        pick4[7]=116;
        pick4[8]=53;
        pick4[9]=110;
        pick4[10]=16;
        pick4[11]=67;

        pick5[0]=48;
        pick5[1]=46;
        pick5[2]=59;
        pick5[3]=50;
        pick5[4]=44;
        pick5[5]=29;
        pick5[6]=47;
        pick5[7]=55;
        pick5[8]=74;
        pick5[9]=49;
        pick5[10]=66;
        pick5[11]=64;
        pick5[12]=7;
        pick5[13]=38;


        mostbanned[0]=15;
        mostbanned[1]=78;
        mostbanned[2]=3;
        mostbanned[3]=42;
        mostbanned[4]=80;
        mostbanned[5]=77;
        mostbanned[6]=88;
        mostbanned[7]=13;
        mostbanned[8]=95;
        mostbanned[9]=99;
        mostbanned[10]=27;
        mostbanned[11]=46;
        mostbanned[12]=44;
        mostbanned[13]=14;
        mostbanned[14]=83;
        mostbanned[15]=22;
        mostbanned[16]=49;
        mostbanned[17]=45;
        mostbanned[18]=85;
        mostbanned[19]=60;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}



class CISRejectsPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    CISRejectsPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=112;
        pick1[1]=84;
        pick1[2]=98;
        pick1[3]=82;
        pick1[4]=76;
        pick1[5]=114;


        pick2[0]=104;
        pick2[1]=11;
        pick2[2]=13;
        pick2[3]=8;
        pick2[4]=28;
        pick2[5]=32;
        pick2[6]=34;
        pick2[7]=18;


        pick3[0]=46;
        pick3[1]=51;
        pick3[2]=48;
        pick3[3]=50;
        pick3[4]=47;
        pick3[5]=55;
        pick3[6]=74;
        pick3[7]=38;
        pick3[8]=70;
        pick3[9]=44;

        pick4[0]=99;
        pick4[1]=100;
        pick4[2]=83;
        pick4[3]=1;
        pick4[4]=102;
        pick4[5]=93;
        pick4[6]=88;
        pick4[7]=116;
        pick4[8]=67;
        pick4[9]=53;
        pick4[10]=63;
        pick4[11]=71;

        pick5[0]=80;
        pick5[1]=26;
        pick5[2]=9;
        pick5[3]=35;
        pick5[4]=21;
        pick5[5]=2;
        pick5[6]=17;
        pick5[7]=77;
        pick5[8]=31;
        pick5[9]=6;
        pick5[10]=5;
        pick5[11]=8;
        pick5[12]=30;
        pick5[13]=22;


        mostbanned[0]=15;
        mostbanned[1]=78;
        mostbanned[2]=29;
        mostbanned[3]=86;
        mostbanned[4]=67;
        mostbanned[5]=6;
        mostbanned[6]=77;
        mostbanned[7]=99;
        mostbanned[8]=55;
        mostbanned[9]=105;
        mostbanned[10]=50;
        mostbanned[11]=98;
        mostbanned[12]=3;
        mostbanned[13]=80;
        mostbanned[14]=57;
        mostbanned[15]=26;
        mostbanned[16]=18;
        mostbanned[17]=2;
        mostbanned[18]=52;
        mostbanned[19]=64;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}



class friendsPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    friendsPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=103;
        pick1[1]=90;
        pick1[2]=97;
        pick1[3]=98;
        pick1[4]=82;
        pick1[5]=112;


        pick2[0]=77;
        pick2[1]=27;
        pick2[2]=26;
        pick2[3]=2;
        pick2[4]=23;
        pick2[5]=17;
        pick2[6]=80;
        pick2[7]=6;


        pick3[0]=104;
        pick3[1]=11;
        pick3[2]=13;
        pick3[3]=8;
        pick3[4]=25;
        pick3[5]=36;
        pick3[6]=28;
        pick3[7]=85;
        pick3[8]=32;
        pick3[9]=34;

        pick4[0]=53;
        pick4[1]=88;
        pick4[2]=63;
        pick4[3]=65;
        pick4[4]=20;
        pick4[5]=45;
        pick4[6]=106;
        pick4[7]=102;
        pick4[8]=100;
        pick4[9]=16;
        pick4[10]=110;
        pick4[11]=108;

        pick5[0]=50;
        pick5[1]=48;
        pick5[2]=18;
        pick5[3]=46;
        pick5[4]=70;
        pick5[5]=56;
        pick5[6]=29;
        pick5[7]=55;
        pick5[8]=69;
        pick5[9]=74;
        pick5[10]=38;
        pick5[11]=47;
        pick5[12]=51;
        pick5[13]=68;


        mostbanned[0]=99;
        mostbanned[1]=57;
        mostbanned[2]=15;
        mostbanned[3]=48;
        mostbanned[4]=49;
        mostbanned[5]=27;
        mostbanned[6]=77;
        mostbanned[7]=52;
        mostbanned[8]=64;
        mostbanned[9]=104;
        mostbanned[10]=50;
        mostbanned[11]=98;
        mostbanned[12]=80;
        mostbanned[13]=65;
        mostbanned[14]=70;
        mostbanned[15]=26;
        mostbanned[16]=18;
        mostbanned[17]=55;
        mostbanned[18]=2;
        mostbanned[19]=44;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}




class ferzeePicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    ferzeePicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=76;
        pick1[1]=98;
        pick1[2]=89;
        pick1[3]=112;
        pick1[4]=106;
        pick1[5]=82;


        pick2[0]=49;
        pick2[1]=37;
        pick2[2]=69;
        pick2[3]=18;
        pick2[4]=74;
        pick2[5]=70;
        pick2[6]=48;
        pick2[7]=51;


        pick3[0]=32;
        pick3[1]=57;
        pick3[2]=11;
        pick3[3]=34;
        pick3[4]=105;
        pick3[5]=28;
        pick3[6]=95;
        pick3[7]=12;
        pick3[8]=81;
        pick3[9]=103;

        pick4[0]=99;
        pick4[1]=91;
        pick4[2]=108;
        pick4[3]=16;
        pick4[4]=45;
        pick4[5]=61;
        pick4[6]=102;
        pick4[7]=54;
        pick4[8]=55;
        pick4[9]=65;
        pick4[10]=32;
        pick4[11]=19;

        pick5[0]=6;
        pick5[1]=3;
        pick5[2]=17;
        pick5[3]=95;
        pick5[4]=80;
        pick5[5]=58;
        pick5[6]=30;
        pick5[7]=77;
        pick5[8]=26;
        pick5[9]=35;
        pick5[10]=5;
        pick5[11]=22;
        pick5[12]=9;
        pick5[13]=4;


        mostbanned[0]=15;
        mostbanned[1]=78;
        mostbanned[2]=29;
        mostbanned[3]=87;
        mostbanned[4]=98;
        mostbanned[5]=26;
        mostbanned[6]=99;
        mostbanned[7]=55;
        mostbanned[8]=105;
        mostbanned[9]=80;
        mostbanned[10]=67;
        mostbanned[11]=86;
        mostbanned[12]=6;
        mostbanned[13]=77;
        mostbanned[14]=52;
        mostbanned[15]=64;
        mostbanned[16]=57;
        mostbanned[17]=50;
        mostbanned[18]=48;
        mostbanned[19]=49;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}





class IcCupPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    IcCupPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=84;
        pick1[1]=76;
        pick1[2]=72;
        pick1[3]=112;
        pick1[4]=115;
        pick1[5]=82;


        pick2[0]=11;
        pick2[1]=15;
        pick2[2]=32;
        pick2[3]=57;
        pick2[4]=34;
        pick2[5]=28;
        pick2[6]=104;
        pick2[7]=105;


        pick3[0]=6;
        pick3[1]=26;
        pick3[2]=80;
        pick3[3]=49;
        pick3[4]=95;
        pick3[5]=22;
        pick3[6]=17;
        pick3[7]=8;
        pick3[8]=3;
        pick3[9]=5;

        pick4[0]=88;
        pick4[1]=100;
        pick4[2]=10;
        pick4[3]=99;
        pick4[4]=83;
        pick4[5]=102;
        pick4[6]=108;
        pick4[7]=116;
        pick4[8]=54;
        pick4[9]=65;
        pick4[10]=39;
        pick4[11]=25;

        pick5[0]=38;
        pick5[1]=51;
        pick5[2]=66;
        pick5[3]=69;
        pick5[4]=56;
        pick5[5]=68;
        pick5[6]=60;
        pick5[7]=47;
        pick5[8]=50;
        pick5[9]=46;
        pick5[10]=19;
        pick5[11]=48;
        pick5[12]=70;
        pick5[13]=74;


        mostbanned[0]=114;
        mostbanned[1]=36;
        mostbanned[2]=55;
        mostbanned[3]=52;
        mostbanned[4]=15;
        mostbanned[5]=3;
        mostbanned[6]=116;
        mostbanned[7]=105;
        mostbanned[8]=76;
        mostbanned[9]=80;
        mostbanned[10]=78;
        mostbanned[11]=29;
        mostbanned[12]=87;
        mostbanned[13]=98;
        mostbanned[14]=26;
        mostbanned[15]=99;
        mostbanned[16]=50;
        mostbanned[17]=48;
        mostbanned[18]=49;
        mostbanned[19]=95;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}





class MoscowFivePicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    MoscowFivePicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=98;
        pick1[1]=104;
        pick1[2]=84;
        pick1[3]=112;
        pick1[4]=76;
        pick1[5]=115;


        pick2[0]=102;
        pick2[1]=100;
        pick2[2]=10;
        pick2[3]=108;
        pick2[4]=83;
        pick2[5]=67;
        pick2[6]=45;
        pick2[7]=25;


        pick3[0]=11;
        pick3[1]=12;
        pick3[2]=32;
        pick3[3]=34;
        pick3[4]=8;
        pick3[5]=26;
        pick3[6]=57;
        pick3[7]=104;
        pick3[8]=105;
        pick3[9]=13;

        pick4[0]=6;
        pick4[1]=21;
        pick4[2]=77;
        pick4[3]=35;
        pick4[4]=9;
        pick4[5]=17;
        pick4[6]=95;
        pick4[7]=49;
        pick4[8]=22;
        pick4[9]=8;
        pick4[10]=27;
        pick4[11]=30;

        pick5[0]=47;
        pick5[1]=51;
        pick5[2]=50;
        pick5[3]=46;
        pick5[4]=64;
        pick5[5]=7;
        pick5[6]=48;
        pick5[7]=56;
        pick5[8]=19;
        pick5[9]=74;
        pick5[10]=53;
        pick5[11]=44;
        pick5[12]=70;
        pick5[13]=29;


        mostbanned[0]=23;
        mostbanned[1]=88;
        mostbanned[2]=15;
        mostbanned[3]=39;
        mostbanned[4]=52;
        mostbanned[5]=14;
        mostbanned[6]=36;
        mostbanned[7]=29;
        mostbanned[8]=78;
        mostbanned[9]=77;
        mostbanned[10]=67;
        mostbanned[11]=50;
        mostbanned[12]=93;
        mostbanned[13]=48;
        mostbanned[14]=60;
        mostbanned[15]=95;
        mostbanned[16]=22;
        mostbanned[17]=34;
        mostbanned[18]=55;
        mostbanned[19]=49;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}





class RebelsPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    RebelsPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=84;
        pick1[1]=82;
        pick1[2]=98;
        pick1[3]=115;
        pick1[4]=104;
        pick1[5]=106;


        pick2[0]=15;
        pick2[1]=28;
        pick2[2]=34;
        pick2[3]=105;
        pick2[4]=12;
        pick2[5]=11;
        pick2[6]=13;
        pick2[7]=57;


        pick3[0]=67;
        pick3[1]=102;
        pick3[2]=45;
        pick3[3]=108;
        pick3[4]=113;
        pick3[5]=88;
        pick3[6]=116;
        pick3[7]=54;
        pick3[8]=83;
        pick3[9]=99;

        pick4[0]=6;
        pick4[1]=8;
        pick4[2]=26;
        pick4[3]=3;
        pick4[4]=5;
        pick4[5]=9;
        pick4[6]=17;
        pick4[7]=95;
        pick4[8]=22;
        pick4[9]=49;
        pick4[10]=27;
        pick4[11]=77;

        pick5[0]=50;
        pick5[1]=51;
        pick5[2]=47;
        pick5[3]=29;
        pick5[4]=70;
        pick5[5]=74;
        pick5[6]=19;
        pick5[7]=56;
        pick5[8]=48;
        pick5[9]=7;
        pick5[10]=46;
        pick5[11]=64;
        pick5[12]=53;
        pick5[13]=44;


        mostbanned[0]=86;
        mostbanned[1]=30;
        mostbanned[2]=20;
        mostbanned[3]=106;
        mostbanned[4]=78;
        mostbanned[5]=67;
        mostbanned[6]=29;
        mostbanned[7]=77;
        mostbanned[8]=42;
        mostbanned[9]=40;
        mostbanned[10]=15;
        mostbanned[11]=47;
        mostbanned[12]=50;
        mostbanned[13]=52;
        mostbanned[14]=6;
        mostbanned[15]=26;
        mostbanned[16]=99;
        mostbanned[17]=98;
        mostbanned[18]=94;
        mostbanned[19]=93;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}




class RoxKisPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    RoxKisPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=78;
        pick1[1]=98;
        pick1[2]=82;
        pick1[3]=76;
        pick1[4]=72;
        pick1[5]=115;


        pick2[0]=102;
        pick2[1]=108;
        pick2[2]=10;
        pick2[3]=100;
        pick2[4]=88;
        pick2[5]=63;
        pick2[6]=83;
        pick2[7]=99;


        pick3[0]=15;
        pick3[1]=11;
        pick3[2]=12;
        pick3[3]=104;
        pick3[4]=105;
        pick3[5]=94;
        pick3[6]=13;
        pick3[7]=34;
        pick3[8]=32;
        pick3[9]=103;

        pick4[0]=48;
        pick4[1]=46;
        pick4[2]=38;
        pick4[3]=56;
        pick4[4]=51;
        pick4[5]=47;
        pick4[6]=50;
        pick4[7]=60;
        pick4[8]=68;
        pick4[9]=7;
        pick4[10]=70;
        pick4[11]=64;

        pick5[0]=6;
        pick5[1]=9;
        pick5[2]=8;
        pick5[3]=35;
        pick5[4]=21;
        pick5[5]=77;
        pick5[6]=80;
        pick5[7]=17;
        pick5[8]=95;
        pick5[9]=49;
        pick5[10]=22;
        pick5[11]=5;
        pick5[12]=26;
        pick5[13]=27;


        mostbanned[0]=112;
        mostbanned[1]=37;
        mostbanned[2]=29;
        mostbanned[3]=106;
        mostbanned[4]=15;
        mostbanned[5]=35;
        mostbanned[6]=80;
        mostbanned[7]=68;
        mostbanned[8]=60;
        mostbanned[9]=56;
        mostbanned[10]=95;
        mostbanned[11]=22;
        mostbanned[12]=34;
        mostbanned[13]=52;
        mostbanned[14]=14;
        mostbanned[15]=102;
        mostbanned[16]=108;
        mostbanned[17]=98;
        mostbanned[18]=99;
        mostbanned[19]=57;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}




class TheRetryPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    TheRetryPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=78;
        pick1[1]=75;
        pick1[2]=76;
        pick1[3]=82;
        pick1[4]=94;
        pick1[5]=115;


        pick2[0]=15;
        pick2[1]=79;
        pick2[2]=103;
        pick2[3]=104;
        pick2[4]=86;
        pick2[5]=34;
        pick2[6]=32;
        pick2[7]=3;


        pick3[0]=31;
        pick3[1]=8;
        pick3[2]=95;
        pick3[3]=6;
        pick3[4]=80;
        pick3[5]=71;
        pick3[6]=113;
        pick3[7]=9;
        pick3[8]=77;
        pick3[9]=27;

        pick4[0]=53;
        pick4[1]=100;
        pick4[2]=108;
        pick4[3]=63;
        pick4[4]=10;
        pick4[5]=99;
        pick4[6]=102;
        pick4[7]=67;
        pick4[8]=101;
        pick4[9]=91;
        pick4[10]=83;
        pick4[11]=93;

        pick5[0]=18;
        pick5[1]=50;
        pick5[2]=56;
        pick5[3]=47;
        pick5[4]=5;
        pick5[5]=51;
        pick5[6]=38;
        pick5[7]=37;
        pick5[8]=48;
        pick5[9]=19;
        pick5[10]=49;
        pick5[11]=51;
        pick5[12]=44;
        pick5[13]=46;


        mostbanned[0]=111;
        mostbanned[1]=45;
        mostbanned[2]=88;
        mostbanned[3]=100;
        mostbanned[4]=56;
        mostbanned[5]=99;
        mostbanned[6]=5;
        mostbanned[7]=75;
        mostbanned[8]=8;
        mostbanned[9]=74;
        mostbanned[10]=71;
        mostbanned[11]=9;
        mostbanned[12]=31;
        mostbanned[13]=108;
        mostbanned[14]=57;
        mostbanned[15]=79;
        mostbanned[16]=77;
        mostbanned[17]=19;
        mostbanned[18]=95;
        mostbanned[19]=82;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}




class DTSPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    DTSPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=11;
        pick1[1]=87;
        pick1[2]=103;
        pick1[3]=79;
        pick1[4]=86;
        pick1[5]=104;


        pick2[0]=3;
        pick2[1]=30;
        pick2[2]=26;
        pick2[3]=80;
        pick2[4]=27;
        pick2[5]=9;
        pick2[6]=21;
        pick2[7]=8;


        pick3[0]=78;
        pick3[1]=84;
        pick3[2]=112;
        pick3[3]=76;
        pick3[4]=115;
        pick3[5]=114;
        pick3[6]=82;
        pick3[7]=98;
        pick3[8]=72;
        pick3[9]=97;

        pick4[0]=25;
        pick4[1]=77;
        pick4[2]=108;
        pick4[3]=88;
        pick4[4]=100;
        pick4[5]=67;
        pick4[6]=10;
        pick4[7]=83;
        pick4[8]=99;
        pick4[9]=45;
        pick4[10]=54;
        pick4[11]=49;

        pick5[0]=7;
        pick5[1]=64;
        pick5[2]=60;
        pick5[3]=56;
        pick5[4]=68;
        pick5[5]=47;
        pick5[6]=50;
        pick5[7]=18;
        pick5[8]=5;
        pick5[9]=38;
        pick5[10]=37;
        pick5[11]=48;
        pick5[12]=19;
        pick5[13]=46;


        mostbanned[0]=15;
        mostbanned[1]=29;
        mostbanned[2]=102;
        mostbanned[3]=30;
        mostbanned[4]=114;
        mostbanned[5]=116;
        mostbanned[6]=67;
        mostbanned[7]=55;
        mostbanned[8]=86;
        mostbanned[9]=74;
        mostbanned[10]=95;
        mostbanned[11]=112;
        mostbanned[12]=106;
        mostbanned[13]=77;
        mostbanned[14]=52;
        mostbanned[15]=34;
        mostbanned[16]=99;
        mostbanned[17]=98;
        mostbanned[18]=57;
        mostbanned[19]=56;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}




class DuzaGamingPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    DuzaGamingPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=78;
        pick1[1]=112;
        pick1[2]=84;
        pick1[3]=82;
        pick1[4]=98;
        pick1[5]=76;


        pick2[0]=26;
        pick2[1]=17;
        pick2[2]=4;
        pick2[3]=3;
        pick2[4]=9;
        pick2[5]=21;
        pick2[6]=8;
        pick2[7]=27;


        pick3[0]=11;
        pick3[1]=32;
        pick3[2]=34;
        pick3[3]=28;
        pick3[4]=105;
        pick3[5]=104;
        pick3[6]=94;
        pick3[7]=103;
        pick3[8]=12;
        pick3[9]=57;

        pick4[0]=88;
        pick4[1]=45;
        pick4[2]=54;
        pick4[3]=100;
        pick4[4]=16;
        pick4[5]=10;
        pick4[6]=83;
        pick4[7]=99;
        pick4[8]=25;
        pick4[9]=73;
        pick4[10]=71;
        pick4[11]=31;

        pick5[0]=51;
        pick5[1]=47;
        pick5[2]=50;
        pick5[3]=60;
        pick5[4]=68;
        pick5[5]=56;
        pick5[6]=64;
        pick5[7]=66;
        pick5[8]=29;
        pick5[9]=46;
        pick5[10]=7;
        pick5[11]=18;
        pick5[12]=70;
        pick5[13]=19;


        mostbanned[0]=67;
        mostbanned[1]=102;
        mostbanned[2]=108;
        mostbanned[3]=105;
        mostbanned[4]=29;
        mostbanned[5]=60;
        mostbanned[6]=68;
        mostbanned[7]=57;
        mostbanned[8]=56;
        mostbanned[9]=99;
        mostbanned[10]=6;
        mostbanned[11]=5;
        mostbanned[12]=4;
        mostbanned[13]=3;
        mostbanned[14]=34;
        mostbanned[15]=36;
        mostbanned[16]=78;
        mostbanned[17]=52;
        mostbanned[18]=14;
        mostbanned[19]=80;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }





        return hero;
    }



}




class NoPangoPicker extends Pickers
{
    int[] mostpicked;
    String[] MaxValue;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    NoPangoPicker(String Pickername, int seq, ArrayList<Players> TeamRooster) {
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

    }


    @Override
    int Pick(int pickstate, ArrayList<Heroes> heroes) {
        int hero=0;
        int [] mostbanned = new int[20];
        int [] pick1 = new int[6];
        int [] pick2 = new int[8];
        int [] pick3 = new int[10];
        int [] pick4 = new int[12];
        int [] pick5 = new int[14];

        pick1[0]=3;
        pick1[1]=2;
        pick1[2]=6;
        pick1[3]=20;
        pick1[4]=86;
        pick1[5]=35;


        pick2[0]=11;
        pick2[1]=104;
        pick2[2]=81;
        pick2[3]=33;
        pick2[4]=103;
        pick2[5]=87;
        pick2[6]=24;
        pick2[7]=34;


        pick3[0]=92;
        pick3[1]=89;
        pick3[2]=82;
        pick3[3]=13;
        pick3[4]=115;
        pick3[5]=36;
        pick3[6]=76;
        pick3[7]=97;
        pick3[8]=94;
        pick3[9]=84;

        pick4[0]=48;
        pick4[1]=59;
        pick4[2]=49;
        pick4[3]=55;
        pick4[4]=29;
        pick4[5]=38;
        pick4[6]=18;
        pick4[7]=51;
        pick4[8]=74;
        pick4[9]=7;
        pick4[10]=47;
        pick4[11]=46;

        pick5[0]=93;
        pick5[1]=101;
        pick5[2]=99;
        pick5[3]=96;
        pick5[4]=10;
        pick5[5]=54;
        pick5[6]=108;
        pick5[7]=69;
        pick5[8]=45;
        pick5[9]=67;
        pick5[10]=106;
        pick5[11]=107;
        pick5[12]=39;
        pick5[13]=102;


        mostbanned[0]=15;
        mostbanned[1]=32;
        mostbanned[2]=16;
        mostbanned[3]=99;
        mostbanned[4]=14;
        mostbanned[5]=51;
        mostbanned[6]=20;
        mostbanned[7]=101;
        mostbanned[8]=34;
        mostbanned[9]=4;
        mostbanned[10]=61;
        mostbanned[11]=55;
        mostbanned[12]=3;
        mostbanned[13]=38;
        mostbanned[14]=114;
        mostbanned[15]=13;
        mostbanned[16]=29;
        mostbanned[17]=93;
        mostbanned[18]=103;
        mostbanned[19]=80;

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

        else if (pickstate==7)
        {
            for(int k=0;k<pick1.length;k++)
            {
                if (heroes.get(pick1[k]).baned==false)
                {
                    hero= pick1[k];
                    break;
                }

            }
        }
        else if (pickstate==8)
        {
            for(int k=0;k<pick2.length;k++)
            {
                if (heroes.get(pick2[k]).baned==false)
                {
                    hero= pick2[k];
                    break;
                }

            }
        }
        else if (pickstate==14)
        {
            for(int k=0;k<pick3.length;k++)
            {
                if (heroes.get(pick3[k]).baned==false)
                {
                    hero= pick3[k];
                    break;
                }

            }
        }
        else if (pickstate==16)
        {
            for(int k=0;k<pick4.length;k++)
            {
                if (heroes.get(pick4[k]).baned==false)
                {
                    hero= pick4[k];
                    break;
                }

            }
        }
        else if (pickstate==21)
        {
            for(int k=0;k<pick5.length;k++)
            {
                if (heroes.get(pick5[k]).baned==false)
                {
                    hero= pick5[k];
                    break;
                }

            }
        }




        return hero;
    }



}









