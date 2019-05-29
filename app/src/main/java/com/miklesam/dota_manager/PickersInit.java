package com.miklesam.dota_manager;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.EmpireInit;

public class PickersInit {

    static ArrayList<Pickers> AllPickers= new ArrayList<Pickers>();

    static final EmpirePicker EmpirePickerMan = new EmpirePicker("EmpirePicker",0,EmpireInit());


    public static ArrayList AllPickersInit() {
        AllPickers.add(EmpirePickerMan);

        return AllPickers;
    }


}
