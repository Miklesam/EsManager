package com.miklesam.dota_manager;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.EmpireInit;
import static com.miklesam.dota_manager.TeamsInit.NaviInit;
import static com.miklesam.dota_manager.TeamsInit.VpInit;

public class PlanersInit {

    static ArrayList<Planers> AllPlaners= new ArrayList<Planers>();

    static final VPPlaner VPPlanerMan = new VPPlaner("VpPlaner",0,VpInit());
    static final NaviPlaner NaviPlanerMan = new NaviPlaner("NaviPlaner",1,NaviInit());
    static final GambitPlaner GambitPlanerMan = new GambitPlaner("GambitPlaner",2,NaviInit());
    static final EmpirePlaner EmpirePlanerMan = new EmpirePlaner("EmpirePlaner",3,EmpireInit());


    public static ArrayList AllPlanersInit() {
        AllPlaners.add(VPPlanerMan);
        AllPlaners.add(NaviPlanerMan);
        AllPlaners.add(GambitPlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);
        AllPlaners.add(EmpirePlanerMan);

        return AllPlaners;
    }


}
