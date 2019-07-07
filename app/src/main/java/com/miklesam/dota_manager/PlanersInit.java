package com.miklesam.dota_manager;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.EmpireInit;
import static com.miklesam.dota_manager.TeamsInit.NaviInit;
import static com.miklesam.dota_manager.TeamsInit.VpInit;

public class PlanersInit {

    static ArrayList<Planers> AllPlaners= new ArrayList<Planers>();

    static final VPPlaner VPPlanerMan = new VPPlaner("VpPlaner",0);
    static final NaviPlaner NaviPlanerMan = new NaviPlaner("NaviPlaner",1);
    static final GambitPlaner GambitPlanerMan = new GambitPlaner("GambitPlaner",2);
    static final OldButGoldPlaner OldButGoldPlanerMan = new OldButGoldPlaner("OldButGoldPlanerMan",3);
    static final EmpirePlaner EmpirePlanerMan = new EmpirePlaner("EmpirePlaner",4);
    static final WinstrikePlaner WinstrikePlanerMan = new WinstrikePlaner("WinstrikePlanerMan",5);
    static final BHGPlaner BHGPlanerMan = new BHGPlaner("BHGPlanerMan",6);
    static final F5Planer F5PlanerMan = new F5Planer("F5PlanerMan",7);
    static final CISPlaner CisPlanerMan = new CISPlaner("CisPlanerMan",8);
    static final friendsPlaner friendsPlanerMan = new friendsPlaner("friendsPlanerMan",9);
    static final ferzeePlaner ferzeePlanerMan = new ferzeePlaner("ferzeePlanerMan",10);
    static final iccupPlaner iccupPlanerMan = new iccupPlaner("iccupPlanerMan",11);
    static final M5Planer M5PlanerMan = new M5Planer("M5PlanerMan",12);
    static final rebelsPlaner rebelsPlanerMan = new rebelsPlaner("rebelsPlanerMan",13);
    static final roxkisPlaner roxkisPlanerMan = new roxkisPlaner("roxkisPlanerMan",14);
    static final theretryPlaner theretryPlanerMan = new theretryPlaner("theretryPlanerMan",15);
    static final DTSPlaner DTSPlanerMan = new DTSPlaner("DTSPlanerMan",16);
    static final DuzaGamingPlaner DuzaPlanerMan = new DuzaGamingPlaner("DuzaPlanerMan",17);
    static final NoPangoPlaner NoPangoPlanerMan = new NoPangoPlaner("NoPangoPlanerMan",18);


    public static ArrayList AllPlanersInit() {
        AllPlaners.add(VPPlanerMan);
        AllPlaners.add(NaviPlanerMan);
        AllPlaners.add(GambitPlanerMan);
        AllPlaners.add(OldButGoldPlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(WinstrikePlanerMan);
        AllPlaners.add(BHGPlanerMan);
        AllPlaners.add(F5PlanerMan);
        AllPlaners.add(CisPlanerMan);
        AllPlaners.add(friendsPlanerMan);
        AllPlaners.add(ferzeePlanerMan);
        AllPlaners.add(iccupPlanerMan);
        AllPlaners.add(M5PlanerMan);
        AllPlaners.add(rebelsPlanerMan);
        AllPlaners.add(roxkisPlanerMan);
        AllPlaners.add(theretryPlanerMan);
        AllPlaners.add(DTSPlanerMan);
        AllPlaners.add(DuzaPlanerMan);
        AllPlaners.add(NoPangoPlanerMan);

        return AllPlaners;
    }


}
