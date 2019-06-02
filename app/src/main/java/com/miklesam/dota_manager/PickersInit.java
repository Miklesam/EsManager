package com.miklesam.dota_manager;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.EmpireInit;
import static com.miklesam.dota_manager.TeamsInit.Gambit;
import static com.miklesam.dota_manager.TeamsInit.GambitInit;
import static com.miklesam.dota_manager.TeamsInit.NaviInit;
import static com.miklesam.dota_manager.TeamsInit.VpInit;

public class PickersInit {

    static ArrayList<Pickers> AllPickers= new ArrayList<Pickers>();

    static final VPPicker VPPickerMan = new VPPicker("VPPicker",0,VpInit());
    static final NaviPicker NaviPickerMan = new NaviPicker("NaviPicker",1,NaviInit());
    static final GambitPicker GambitPickerMan = new GambitPicker("GambitPicker",2,GambitInit());
    static final EmpirePicker EmpirePickerMan = new EmpirePicker("EmpirePicker",3,EmpireInit());


    public static ArrayList AllPickersInit() {
        AllPickers.add(VPPickerMan);
        AllPickers.add(NaviPickerMan);
        AllPickers.add(GambitPickerMan);
        AllPickers.add(EmpirePickerMan);

        return AllPickers;
    }


}
