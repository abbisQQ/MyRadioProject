package com.example.babis.myradioproject.Services;

import com.example.babis.myradioproject.Model.Station;

import java.util.ArrayList;

/**
 * Created by Babis on 3/11/2017.
 */

public class DataService {

    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }


    public ArrayList<Station>getFeaturedStations(){
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes For Travel) ","flightplanmusic"));
        list.add(new Station("Two Wheelie   (Biking list) ","bicyclemusic"));
        list.add(new Station("Kids Jams (Music For Children) ","kidsmusic"));

        return list;
    }


    public ArrayList<Station>getRecentStations(){
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("All Time Classic ","vinylmusic"));
        list.add(new Station("Best Of Their kind ","socialmusic"));
        list.add(new Station("Relax Time ","keymusic"));


        return list;
    }


    public ArrayList<Station>getPartyStations(){
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Dont Stop ","kidsmusic"));
        list.add(new Station("The ","kidsmusic"));
        list.add(new Station("Party","kidsmusic"));

        return list;
    }






}
