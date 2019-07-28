package com.miklesam.dota_manager;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.BlackHornetsGamingInit;
import static com.miklesam.dota_manager.TeamsInit.BlackHornetsGamingTeam;
import static com.miklesam.dota_manager.TeamsInit.CISRejects;
import static com.miklesam.dota_manager.TeamsInit.CISRejectsInit;
import static com.miklesam.dota_manager.TeamsInit.DTS;
import static com.miklesam.dota_manager.TeamsInit.DTSInit;
import static com.miklesam.dota_manager.TeamsInit.DuzaGaming;
import static com.miklesam.dota_manager.TeamsInit.DuzaGamingInit;
import static com.miklesam.dota_manager.TeamsInit.EmpireInit;
import static com.miklesam.dota_manager.TeamsInit.FRIENDS;
import static com.miklesam.dota_manager.TeamsInit.FRIENDSInit;
import static com.miklesam.dota_manager.TeamsInit.FantasticFive;
import static com.miklesam.dota_manager.TeamsInit.FantasticFiveInit;
import static com.miklesam.dota_manager.TeamsInit.Gambit;
import static com.miklesam.dota_manager.TeamsInit.GambitInit;
import static com.miklesam.dota_manager.TeamsInit.MoscowFive;
import static com.miklesam.dota_manager.TeamsInit.MoscowFiveInit;
import static com.miklesam.dota_manager.TeamsInit.NaviInit;
import static com.miklesam.dota_manager.TeamsInit.NoPango;
import static com.miklesam.dota_manager.TeamsInit.NoPangoInit;
import static com.miklesam.dota_manager.TeamsInit.OldButGoldInit;
import static com.miklesam.dota_manager.TeamsInit.Rebels;
import static com.miklesam.dota_manager.TeamsInit.RebelsInit;
import static com.miklesam.dota_manager.TeamsInit.RoxKis;
import static com.miklesam.dota_manager.TeamsInit.RoxKisInit;
import static com.miklesam.dota_manager.TeamsInit.TheRetry;
import static com.miklesam.dota_manager.TeamsInit.TheRetryInit;
import static com.miklesam.dota_manager.TeamsInit.VpInit;
import static com.miklesam.dota_manager.TeamsInit.WinstrikeInit;
import static com.miklesam.dota_manager.TeamsInit.ferzee;
import static com.miklesam.dota_manager.TeamsInit.ferzeeInit;
import static com.miklesam.dota_manager.TeamsInit.iCCupInit;

public class PickersInit {

    static ArrayList<Pickers> AllPickers= new ArrayList<Pickers>();

    static final VPPicker VPPickerMan = new VPPicker("VPPicker",0,VpInit());
    static final NaviPicker NaviPickerMan = new NaviPicker("NaviPicker",1,NaviInit());
    static final GambitPicker GambitPickerMan = new GambitPicker("GambitPicker",2,GambitInit());
    static final OldButGoldPicker OldButGoldPickerMan = new OldButGoldPicker("OldButGold",3,OldButGoldInit());
    static final EmpirePicker EmpirePickerMan = new EmpirePicker("EmpirePicker",4,EmpireInit());
    static final WinstrikePicker WinstrikePickerMan = new WinstrikePicker("WinstrikePicker",5,WinstrikeInit());
    static final BHGPicker BHGPicker = new BHGPicker("BHGPicker",6,BlackHornetsGamingInit());
    static final FantasticFivePicker F5Picker = new FantasticFivePicker("F5Picker",7,FantasticFiveInit());
    static final CISRejectsPicker CISrREJPicker = new CISRejectsPicker("CISrREJPicker",8,CISRejectsInit());
    static final friendsPicker frndsPicker = new friendsPicker("frndsPicker",9,FRIENDSInit());
    static final ferzeePicker frzPicker = new ferzeePicker("frzPicker",10,ferzeeInit());
    static final IcCupPicker iccPicker = new IcCupPicker("iccPicker",11,iCCupInit());
    static final MoscowFivePicker M5Picker = new MoscowFivePicker("M5Picker",12,MoscowFiveInit());
    static final RebelsPicker RblsPicker = new RebelsPicker("RblsPicker",13,RebelsInit());
    static final RoxKisPicker RoxPicker = new RoxKisPicker("RoxPicker",14,RoxKisInit());
    static final TheRetryPicker ThertrPicker = new TheRetryPicker("ThertrPicker",15,TheRetryInit());
    static final DTSPicker DigitalTSPicker = new DTSPicker("DigitalTSPicker",16,DTSInit());
    static final DuzaGamingPicker DzgmngPicker = new DuzaGamingPicker("DzgmngPicker",17,DuzaGamingInit());
    static final NoPangoPicker NPangoPicker = new NoPangoPicker("NPangoPicker",18,NoPangoInit());



    public static ArrayList AllPickersInit() {
        AllPickers.add(VPPickerMan);
        AllPickers.add(NaviPickerMan);
        AllPickers.add(GambitPickerMan);
        AllPickers.add(OldButGoldPickerMan);
        AllPickers.add(EmpirePickerMan);
        AllPickers.add(WinstrikePickerMan);
        AllPickers.add(BHGPicker);
        AllPickers.add(F5Picker);
        AllPickers.add(CISrREJPicker);
        AllPickers.add(frndsPicker);
        AllPickers.add(frzPicker);
        AllPickers.add(iccPicker);
        AllPickers.add(M5Picker);
        AllPickers.add(RblsPicker);
        AllPickers.add(RoxPicker);
        AllPickers.add(ThertrPicker);
        AllPickers.add(DigitalTSPicker);
        AllPickers.add(DzgmngPicker);
        AllPickers.add(NPangoPicker);



        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);
        AllPickers.add(NPangoPicker);

        return AllPickers;
    }


}
