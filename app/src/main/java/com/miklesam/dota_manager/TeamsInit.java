package com.miklesam.dota_manager;

import java.util.ArrayList;

import static com.miklesam.dota_manager.PlayersInit.Afoninje;
import static com.miklesam.dota_manager.PlayersInit.AfterLife;
import static com.miklesam.dota_manager.PlayersInit.BLACKARXANGEL;
import static com.miklesam.dota_manager.PlayersInit.Bignum;
import static com.miklesam.dota_manager.PlayersInit.Blizzy;
import static com.miklesam.dota_manager.PlayersInit.Cooman;
import static com.miklesam.dota_manager.PlayersInit.Crystallize;
import static com.miklesam.dota_manager.PlayersInit.Daxak;
import static com.miklesam.dota_manager.PlayersInit.Fng;
import static com.miklesam.dota_manager.PlayersInit.G;
import static com.miklesam.dota_manager.PlayersInit.Immersion;
import static com.miklesam.dota_manager.PlayersInit.KingR;
import static com.miklesam.dota_manager.PlayersInit.Kodos;
import static com.miklesam.dota_manager.PlayersInit.Lil;
import static com.miklesam.dota_manager.PlayersInit.Maden;
import static com.miklesam.dota_manager.PlayersInit.Magical;
import static com.miklesam.dota_manager.PlayersInit.NoFear;
import static com.miklesam.dota_manager.PlayersInit.NoOne;
import static com.miklesam.dota_manager.PlayersInit.Palantimos;
import static com.miklesam.dota_manager.PlayersInit.Pikachu;
import static com.miklesam.dota_manager.PlayersInit.Ramzes;
import static com.miklesam.dota_manager.PlayersInit.Rodjer;
import static com.miklesam.dota_manager.PlayersInit.Silent;
import static com.miklesam.dota_manager.PlayersInit.SoNNeikO;
import static com.miklesam.dota_manager.PlayersInit.Solo;
import static com.miklesam.dota_manager.PlayersInit.Vanskor;
import static com.miklesam.dota_manager.PlayersInit.Zayac;
import static com.miklesam.dota_manager.PlayersInit.bzz;
import static com.miklesam.dota_manager.PlayersInit.chshrct;
import static com.miklesam.dota_manager.PlayersInit.dream;
import static com.miklesam.dota_manager.PlayersInit.illidan;
import static com.miklesam.dota_manager.PlayersInit.nongrata;
import static com.miklesam.dota_manager.PlayersInit.p9asha;
import static com.miklesam.dota_manager.PlayersInit.sayuw;
import static com.miklesam.dota_manager.PlayersInit.velheor;

public class TeamsInit {
    static ArrayList<Teams> AllTeams = new ArrayList<Teams>();
    static ArrayList<Players> VPTeam=new ArrayList<Players>();
    static ArrayList<Players> GambitTeam=new ArrayList<Players>();
    static ArrayList<Players> NaviTeam=new ArrayList<Players>();
    static ArrayList<Players> TeamSpiritTeam=new ArrayList<Players>();
    static ArrayList<Players> EmpireTeam=new ArrayList<Players>();
    static ArrayList<Players> WinstrikeTeam=new ArrayList<Players>();
    static ArrayList<Players> BlackHornetsGamingTeam=new ArrayList<Players>();


    public static ArrayList VpInit(){
        VPTeam.add(Ramzes);
        VPTeam.add(NoOne);
        VPTeam.add(p9asha);
        VPTeam.add(Rodjer);
        VPTeam.add(Solo);
        return VPTeam;
    }

    public static ArrayList NaviInit(){
        NaviTeam.add(Crystallize);
        NaviTeam.add(Magical);
        NaviTeam.add(Blizzy);
        NaviTeam.add(Zayac);
        NaviTeam.add(SoNNeikO);
        return NaviTeam;
    }

    public static ArrayList GambitInit(){
        GambitTeam.add(Daxak);
        GambitTeam.add(Afoninje);
        GambitTeam.add(AfterLife);
        GambitTeam.add(Immersion);
        GambitTeam.add(Fng);
        return GambitTeam;
    }

    public static ArrayList TeamSpiritInit(){
        TeamSpiritTeam.add(illidan);
        TeamSpiritTeam.add(G);
        TeamSpiritTeam.add(bzz);
        TeamSpiritTeam.add(velheor);
        TeamSpiritTeam.add(Vanskor);
        return TeamSpiritTeam;
    }

    public static ArrayList EmpireInit(){
        EmpireTeam.add(dream);
        EmpireTeam.add(Kodos);
        EmpireTeam.add(Maden);
        EmpireTeam.add(sayuw);
        EmpireTeam.add(KingR);
        return EmpireTeam;
    }

    public static ArrayList WinstrikeInit(){
        WinstrikeTeam.add(Silent);
        WinstrikeTeam.add(Cooman);
        WinstrikeTeam.add(nongrata);
        WinstrikeTeam.add(Lil);
        WinstrikeTeam.add(NoFear);
        return WinstrikeTeam;
    }

    public static ArrayList BlackHornetsGamingInit(){
        BlackHornetsGamingTeam.add(Palantimos);
        BlackHornetsGamingTeam.add(Pikachu);
        BlackHornetsGamingTeam.add(chshrct);
        BlackHornetsGamingTeam.add(Bignum);
        BlackHornetsGamingTeam.add(BLACKARXANGEL);
        return BlackHornetsGamingTeam;
    }





    static final Teams VirtusPro = new Teams("Virtus Pro",VPTeam,0);
    static final Teams Navi = new Teams("NAVI",NaviTeam,1);
    static final Teams Gambit = new Teams("Gambit",GambitTeam,2);
    static final Teams TeamSpirit = new Teams("Team Spirit",TeamSpiritTeam,3);
    static final Teams Empire = new Teams("Empire",EmpireTeam,4);
    static final Teams Winstrike = new Teams("Winstrike",WinstrikeTeam,5);
    static final Teams BlackHornetsGaming = new Teams(" Black Hornets Gaming",BlackHornetsGamingTeam,6);





    public static ArrayList AllTeamsInit(){
        VpInit();
        NaviInit();
        GambitInit();
        TeamSpiritInit();
        EmpireInit();
        WinstrikeInit();
        BlackHornetsGamingInit();


        AllTeams.add(VirtusPro);
        AllTeams.add(Navi);
        AllTeams.add(Gambit);
        AllTeams.add(TeamSpirit);
        AllTeams.add(Empire);
        AllTeams.add(Winstrike);
        AllTeams.add(BlackHornetsGaming);


        return AllTeams;
    }





}
