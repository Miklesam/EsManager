package com.miklesam.dota_manager;

import java.util.ArrayList;

public class PlayersInit {

    static String CoomanDescription=" Ну Куман на данный момент в СНГ и Европе просто вне конкуренции. Человек номер один 1 керри, живет в Чечне, реаллайфер при таком уровне игры, гоняет в Чечне на мерсе/камри, фоткается с ножами/стволами, репер, играет с Лилом в одной комманде .Типа никого даже близко нету сейчас";


    static ArrayList<Players> CorePlayers = new ArrayList<Players>();
    static ArrayList<Players> SupportPlayers = new ArrayList<Players>();
    static final Players Ramzes = new Players("Ramzes","Rak",500,R.drawable.russia4020,90,85,85,10);
    static final Players NoOne = new Players("NoOne","noone",500,R.drawable.ukraine4020,90,85,85,10);
    static final Players p9asha = new Players("9pasha","9pasha",500,R.drawable.russia4020,90,85,85,10);
    static final Players Daxak = new Players("Daxak","Daxak",500,R.drawable.russia4020,90,85,85,10);
    static final Players Afoninje = new Players("Afoninje","Afoninje",500,R.drawable.russia4020,90,85,85,10);
    static final Players AfterLife = new Players("AfterLife","AfterLife",500,R.drawable.russia4020,90,85,85,10);
    static final Players Crystallize = new Players("Crystallize","Crystallize",500,R.drawable.ukraine4020,90,85,85,10);
    static final Players Magical = new Players("Magical","Magical",500,R.drawable.ukraine4020,90,85,85,10);
    static final Players Blizzy = new Players("Blizzy","Blizzy",500,R.drawable.kirgistan4020,90,85,85,10);
    static final Players Silent = new Players("Silent","Silent",500,R.drawable.russia4020,90,85,85,10);
    static final Players Cooman = new Players("Cooman",CoomanDescription,500,R.drawable.russia4020,90,85,85,10);
    static final Players nongrata = new Players("nongrata","nongrata",500,R.drawable.russia4020,90,85,85,10);
    static final Players dream = new Players("dream'","dream'",500,R.drawable.kirgistan4020,90,85,85,10);
    static final Players Kodos = new Players("Kodos","Kodos",500,R.drawable.russia4020,90,85,85,10);
    static final Players Maden = new Players("Maden","Maden",500,R.drawable.russia4020,90,85,85,10);
    static final Players illidan = new Players("illidan","illidan",500,R.drawable.russia4020,90,85,85,10);
    static final Players G = new Players("G","G",500,R.drawable.russia4020,90,85,85,10);
    static final Players bzz = new Players("633","633",500,R.drawable.russia4020,90,85,85,10);
    static final Players Palantimos = new Players("Palantimos","Palantimos",500,R.drawable.belarus4020,90,85,85,10);
    static final Players Pikachu = new Players("Pikachu","Pikachu",500,R.drawable.ukraine4020,90,85,85,10);
    static final Players chshrct = new Players("chshrct","chshrct",500,R.drawable.belarus4020,90,85,85,10);






    static final Players Solo = new Players("Solo","322",1500,R.drawable.russia4020,90,85,85,10);





    public static ArrayList PlayersCoreInit(){
        CorePlayers.add(Ramzes);
        CorePlayers.add(NoOne);
        CorePlayers.add(p9asha);
        CorePlayers.add(Daxak);
        CorePlayers.add(Afoninje);
        CorePlayers.add(AfterLife);
        CorePlayers.add(Crystallize);
        CorePlayers.add(Magical);
        CorePlayers.add(Blizzy);
        CorePlayers.add(Silent);
        CorePlayers.add(Cooman);
        CorePlayers.add(nongrata);
        CorePlayers.add(dream);
        CorePlayers.add(Kodos);
        CorePlayers.add(Maden);
        CorePlayers.add(illidan);
        CorePlayers.add(G);
        CorePlayers.add(bzz);
        CorePlayers.add(Palantimos);
        CorePlayers.add(Pikachu);
        CorePlayers.add(chshrct);


        return CorePlayers;
    }



    public static ArrayList PlayersSupportInit(){
        SupportPlayers.add(Solo);
        return SupportPlayers;
    }








}
