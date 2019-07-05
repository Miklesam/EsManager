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
        mostbanned[0]=57;
        mostbanned[1]=77;
        mostbanned[2]=12;
        mostbanned[3]=55;
        mostbanned[4]=65;
        mostbanned[5]=98;
        mostbanned[6]=9;
        mostbanned[7]=67;
        mostbanned[8]=30;
        mostbanned[9]=78;
        mostbanned[10]=15;
        mostbanned[11]=61;
        mostbanned[12]=86;
        mostbanned[13]=96;
        mostbanned[14]=100;
        mostbanned[15]=3;
        mostbanned[16]=108;
        mostbanned[17]=26;
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
        mostbanned[11]=58;
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









