package com.miklesam.dota_manager;

import java.util.ArrayList;


public class HeroInit {
    static ArrayList <Heroes> AllHeroes = new ArrayList<Heroes>();
    static final Heroes Abadon = new Heroes(R.drawable.abadon_large_ban,R.drawable.abadon_min_ban,R.drawable.abadon_picked,0);
    static final Heroes Alchemic = new Heroes(R.drawable.alcemic_large_ban,R.drawable.alcemic_min_ban,R.drawable.alcemic_picked,1);
    static final Heroes Axe = new Heroes(R.drawable.axe_large_ban,R.drawable.axe_min_ban,R.drawable.axe_picked,2);
    static final Heroes Beastmaster = new Heroes(R.drawable.beastmaster_large_ban,R.drawable.beastmaster_min_ban,R.drawable.beastmaster_picked,3);
    static final Heroes Brewmaster = new Heroes(R.drawable.brewmaster_ban,R.drawable.brewmaster_min_ban,R.drawable.brewmaster_picked,4);
    static final Heroes Bristleback = new Heroes(R.drawable.bristleback_ban,R.drawable.bristleback_min_ban,R.drawable.bristleback_picked,5);
    static final Heroes Centaur = new Heroes(R.drawable.centaur_large_ban,R.drawable.centaur_min_ban,R.drawable.centaur_picked,6);
    static final Heroes Chaos = new Heroes(R.drawable.chaos_large_ban,R.drawable.chaos_min_ban,R.drawable.chaos_picked,7);
    static final Heroes Clockwerk = new Heroes(R.drawable.clockwerk_large_ban,R.drawable.clockwerk_min_ban,R.drawable.clockwerk_picked,8);
    static final Heroes Doom = new Heroes(R.drawable.doom_large_ban,R.drawable.doom_min_ban,R.drawable.doom_picked,9);
    static final Heroes DK = new Heroes(R.drawable.dk_large_ban,R.drawable.dk_min_ban,R.drawable.dk_picked,10);
    static final Heroes EarthSpirit = new Heroes(R.drawable.earthspirit_large_ban,R.drawable.earthspirit_min_ban,R.drawable.earthspirit_picked,11);
    static final Heroes EarthShaker = new Heroes(R.drawable.shaker_large_ban,R.drawable.shaker_min_ban,R.drawable.shaker_picked,12);
    static final Heroes ElderTitan = new Heroes(R.drawable.eldertitan_large_ban,R.drawable.eldertitan_min_ban,R.drawable.eldertitan_picked,13);
    static final Heroes Huskar = new Heroes(R.drawable.huskar_large_ban,R.drawable.huskar_min_ban,R.drawable.huskar_picked,14);
    static final Heroes IO = new Heroes(R.drawable.io_large_ban,R.drawable.io_min_ban,R.drawable.io_picked,15);
    static final Heroes Kunnka = new Heroes(R.drawable.kunnka_large_ban,R.drawable.kunnka_min_ban,R.drawable.kunnka_picked,16);
    static final Heroes LC = new Heroes(R.drawable.lc_large_ban,R.drawable.lc_min_ban,R.drawable.lc_picked,17);
    static final Heroes Lifestealer = new Heroes(R.drawable.lifestealer_large_ban,R.drawable.lifestealer_min_ban,R.drawable.lifestealer_picked,18);
    static final Heroes Lycan = new Heroes(R.drawable.lycan_large_ban,R.drawable.lycan_min_ban,R.drawable.lycan_picked,19);
    static final Heroes Magnus = new Heroes(R.drawable.magnus_large_ban,R.drawable.magnus_min_ban,R.drawable.magnus_picked,20);
    static final Heroes NS = new Heroes(R.drawable.ns_large_ban,R.drawable.ns_min_ban,R.drawable.ns_picked,21);
    static final Heroes Omniknight = new Heroes(R.drawable.omnik_large_ban,R.drawable.omnik_min_ban,R.drawable.omnik_picked,22);
    static final Heroes Phoenix = new Heroes(R.drawable.phoenix_large_ban,R.drawable.phoenix_min_ban,R.drawable.phoenix_picked,23);
    static final Heroes Pudge = new Heroes(R.drawable.pudge_large_ban,R.drawable.pudge_min_ban,R.drawable.pudge_picked,24);
    static final Heroes SandKing = new Heroes(R.drawable.sandking_large_ban,R.drawable.sandking_min_ban,R.drawable.sandking_picked,25);
    static final Heroes Slardar = new Heroes(R.drawable.slardar_large_ban,R.drawable.slardar_min_ban,R.drawable.slardar_picked,26);
    static final Heroes SpiritBreaker = new Heroes(R.drawable.spiritbraker_large_ban,R.drawable.spiritbreaker_min_ban,R.drawable.spiritbreaker_picked,27);
    static final Heroes Sven = new Heroes(R.drawable.sven_large_ban,R.drawable.sven_min_ban,R.drawable.sven_picked,28);
    static final Heroes Tidehunter = new Heroes(R.drawable.tidehunter_large_ban,R.drawable.tidehunter_min_ban,R.drawable.tidehunter_picked,29);


    public static ArrayList HeroInit(){
        AllHeroes.add(Abadon);
        AllHeroes.add(Alchemic);
        AllHeroes.add(Axe);
        AllHeroes.add(Beastmaster);
        AllHeroes.add(Brewmaster);
        AllHeroes.add(Bristleback);
        AllHeroes.add(Centaur);
        AllHeroes.add(Chaos);
        AllHeroes.add(Clockwerk);
        AllHeroes.add(Doom);
        AllHeroes.add(DK);
        AllHeroes.add(EarthSpirit);
        AllHeroes.add(EarthShaker);
        AllHeroes.add(ElderTitan);
        AllHeroes.add(Huskar);
        AllHeroes.add(IO);
        AllHeroes.add(Kunnka);
        AllHeroes.add(LC);
        AllHeroes.add(Lifestealer);
        AllHeroes.add(Lycan);
        AllHeroes.add(Magnus);
        AllHeroes.add(NS);
        AllHeroes.add(Omniknight);
        AllHeroes.add(Phoenix);
        AllHeroes.add(Pudge);
        AllHeroes.add(SandKing);
        AllHeroes.add(Slardar);
        AllHeroes.add(SpiritBreaker);
        AllHeroes.add(Sven);
        AllHeroes.add(Tidehunter);


        return AllHeroes;
    }

}
