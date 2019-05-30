package com.miklesam.dota_manager;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.EmpireInit;

public class PlanersInit {

    static ArrayList<Planers> AllPlaners= new ArrayList<Planers>();

    static final EmpirePlaner EmpirePlanerMan = new EmpirePlaner("EmpirePicker",0,EmpireInit());


    public static ArrayList AllPlanersInit() {
        AllPlaners.add(EmpirePlanerMan);

        return AllPlaners;
    }


}
