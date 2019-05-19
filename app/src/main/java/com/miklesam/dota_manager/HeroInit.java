package com.miklesam.dota_manager;

import java.util.ArrayList;


public class HeroInit {
    static ArrayList <Heroes> AllHeroes = new ArrayList<Heroes>();
    static final Heroes Abadon = new Heroes(R.drawable.abadon_large_ban,R.drawable.abadon_min_ban,R.drawable.abadon_picked,0);
    static final Heroes Alchemic = new Heroes(R.drawable.alcemic_large_ban,R.drawable.alcemic_min_ban,R.drawable.alcemic_picked,1);
    static final Heroes Axe = new Heroes(R.drawable.axe_large_ban,R.drawable.axe_min_ban,R.drawable.axe_picked,2);
    static final Heroes Beastmaster = new Heroes(R.drawable.beastmaster_large_ban,R.drawable.beastmaster_min_ban,R.drawable.beastmaster_picked,3);
    static final Heroes Brewmaster = new Heroes(R.drawable.brewmaster_ban,R.drawable.brewmaster_min_ban,R.drawable.brewmaster_picked,4);
    static final Heroes Bristleback = new Heroes(R.drawable.bristleback_ban,R.drawable.brewmaster_min_ban,R.drawable.bristleback_picked,5);
    static final Heroes Centaur = new Heroes(R.drawable.centaur_large_ban,R.drawable.centaur_min_ban,R.drawable.centaur_picked,6);


    public static ArrayList HeroInit(){
        AllHeroes.add(Abadon);
        AllHeroes.add(Alchemic);
        AllHeroes.add(Axe);
        AllHeroes.add(Beastmaster);
        AllHeroes.add(Brewmaster);
        AllHeroes.add(Bristleback);
        AllHeroes.add(Centaur);

        return AllHeroes;
    }

}
