package com.miklesam.dota_manager;

import java.util.ArrayList;

import javax.crypto.CipherOutputStream;

abstract class Planers {

    public String Planername;
    public int seq;


    Planers(String Planername,int seq)
    {
        this.Planername=Planername;
        this.seq=seq;

    }

    abstract ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5);

}

class EmpirePlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    EmpirePlaner(String Planername, int seq) {
        super(Planername, seq);



    }

    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(3);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);

        return HeroAndLanes;
    }



}

class VPPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    VPPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(3);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);

        return HeroAndLanes;
    }



}

class NaviPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    NaviPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);

        return HeroAndLanes;
    }



}


class GambitPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    GambitPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(2);

        return HeroAndLanes;
    }



}





class OldButGoldPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    OldButGoldPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(3);
        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}


class WinstrikePlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    WinstrikePlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(2);

        return HeroAndLanes;
    }



}

class BHGPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    BHGPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(3);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}


class F5Planer extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    F5Planer(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}



class CISPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    CISPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(3);

        return HeroAndLanes;
    }



}

class friendsPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    friendsPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}



class ferzeePlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    ferzeePlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(3);

        return HeroAndLanes;
    }



}

class iccupPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    iccupPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}


class M5Planer extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    M5Planer(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}



class rebelsPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    rebelsPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(3);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}


class roxkisPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    roxkisPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(3);

        return HeroAndLanes;
    }



}



class theretryPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    theretryPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}




class DTSPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    DTSPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}

class DuzaGamingPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    DuzaGamingPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}


class NoPangoPlaner extends Planers
{

    ArrayList<Integer> HeroAndLanes=new ArrayList<Integer>();
    NoPangoPlaner(String Planername, int seq) {
        super(Planername, seq);



    }



    @Override
    ArrayList<Integer> Plane(int hero1, int hero2, int hero3, int hero4, int hero5) {

        HeroAndLanes.add(1);
        HeroAndLanes.add(3);
        HeroAndLanes.add(1);
        HeroAndLanes.add(2);
        HeroAndLanes.add(1);

        return HeroAndLanes;
    }



}