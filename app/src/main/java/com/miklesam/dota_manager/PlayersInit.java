package com.miklesam.dota_manager;

import java.util.ArrayList;

public class PlayersInit {

    static String CoomanDescription=" Ну Куман на данный момент в СНГ и Европе просто вне конкуренции. Человек номер один 1 керри, живет в Чечне, реаллайфер при таком уровне игры, гоняет в Чечне на мерсе/камри, фоткается с ножами/стволами, репер, играет с Лилом в одной комманде .Типа никого даже близко нету сейчас";
    static String NoFearDecription="Понимаю ноуфира, наверное неприятно играть с предателями и мразями которые тебя кикнули, но и одновременно хочется выиграть и приходится с ними играть, ведь больше по факту, выбора нет.";



    static ArrayList<Players> CorePlayers = new ArrayList<Players>();
    static ArrayList<Players> SupportPlayers = new ArrayList<Players>();
    static final Players Ramzes = new Players("Ramzes","Rak",500,R.drawable.russia4020,90,85,85,10,18,70,48);
    static final Players NoOne = new Players("NoOne","noone",500,R.drawable.ukraine4020,90,85,85,100,10,100,67);
    static final Players p9asha = new Players("9pasha","9pasha",500,R.drawable.russia4020,90,85,85,100,80,20,6);
    static final Players Daxak = new Players("Daxak","Daxak",500,R.drawable.russia4020,90,85,85,100,74,67,38);
    static final Players Afoninje = new Players("Afoninje","Afoninje",500,R.drawable.russia4020,90,85,85,100,63,100,83);
    static final Players AfterLife = new Players("AfterLife","AfterLife",500,R.drawable.russia4020,90,85,85,100,80,17,77);
    static final Players Crystallize = new Players("Crystallize","Crystallize",500,R.drawable.ukraine4020,90,85,85,100,46,29,18);
    static final Players Magical = new Players("Magical","Magical",500,R.drawable.ukraine4020,90,85,85,100,67,110,88);
    static final Players Blizzy = new Players("Blizzy","Blizzy",500,R.drawable.kirgistan4020,90,85,85,100,86,20,2);
    static final Players Silent = new Players("Silent","Silent",500,R.drawable.russia4020,90,85,85,100,47,50,19);
    static final Players Cooman = new Players("Cooman",CoomanDescription,500,R.drawable.russia4020,90,85,85,100,69,48,68);
    static final Players nongrata = new Players("nongrata","nongrata",500,R.drawable.russia4020,90,85,85,100,77,100,8);
    static final Players dream = new Players("dream'","dream'",500,R.drawable.kirgistan4020,90,85,85,100,0,0,0);
    static final Players Kodos = new Players("Kodos","Kodos",500,R.drawable.russia4020,90,85,85,100,1,88,93);
    static final Players Maden = new Players("Maden","Maden",500,R.drawable.russia4020,90,85,85,100,9,95,114);
    static final Players illidan = new Players("illidan","illidan",500,R.drawable.russia4020,90,85,85,100,64,51,7);
    static final Players G = new Players("G","G",500,R.drawable.russia4020,90,85,85,100,102,63,99);
    static final Players bzz = new Players("633","633",500,R.drawable.russia4020,90,85,85,100,101,91,80);
    static final Players Palantimos = new Players("Palantimos","Palantimos",500,R.drawable.belarus4020,90,85,85,100,0,0,0);
    static final Players Pikachu = new Players("Pikachu","Pikachu",500,R.drawable.ukraine4020,90,85,85,100,88,63,1);
    static final Players chshrct = new Players("chshrct","chshrct",500,R.drawable.belarus4020,90,85,85,100,77,95,80);






    static final Players Solo = new Players("Solo","322",1500,R.drawable.russia4020,90,85,85,10,0,0,0);
    static final Players Rodjer = new Players("Rodjer","Rodjer",1500,R.drawable.russia4020,90,85,85,10,0,0,0);
    static final Players Fng = new Players("Fng","Fng",1500,R.drawable.belarus4020,90,85,85,10,0,0,0);
    static final Players Immersion = new Players("Immersion","Immersion",1500,R.drawable.russia4020,90,85,85,10,0,0,0);
    static final Players SoNNeikO = new Players("SoNNeikO","SoNNeikO",1500,R.drawable.russia4020,90,85,85,10,0,0,0);
    static final Players Zayac = new Players("Zayac","Zayac",1500,R.drawable.kirgistan4020,90,85,85,10,0,0,0);
    static final Players Lil = new Players("Lil","Lil",1500,R.drawable.ukraine4020,90,85,85,10,0,0,0);
    static final Players NoFear = new Players("NoFear",NoFearDecription,1500,R.drawable.russia4020,90,85,85,10,0,0,0);
    static final Players sayuw = new Players("sayuw","sayuw",1500,R.drawable.russia4020,90,85,85,10,9,10,11);
    static final Players KingR = new Players("KingR","KingR",1500,R.drawable.russia4020,90,85,85,10,15,16,17);
    static final Players velheor = new Players("velheor","velheor",1500,R.drawable.russia4020,90,85,85,10,0,0,0);
    static final Players Vanskor = new Players("Vanskor","Vanskor",1500,R.drawable.russia4020,90,85,85,10,0,0,0);
    static final Players Bignum = new Players("Bignum","Bignum",1500,R.drawable.ukraine4020,90,85,85,10,0,0,0);
    static final Players BLACKARXANGEL = new Players("BLACKARXANGEL","BLACKARXANGEL",1500,R.drawable.kazahstan4020,90,85,85,10,0,0,0);








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

        SupportPlayers.add(Rodjer);
        SupportPlayers.add(Fng);
        SupportPlayers.add(Immersion);
        SupportPlayers.add(SoNNeikO);
        SupportPlayers.add(Zayac);
        SupportPlayers.add(Lil);
        SupportPlayers.add(NoFear);
        SupportPlayers.add(sayuw);
        SupportPlayers.add(KingR);
        SupportPlayers.add(velheor);
        SupportPlayers.add(Vanskor);
        SupportPlayers.add(Bignum);
        SupportPlayers.add(BLACKARXANGEL);




        return SupportPlayers;
    }








}
