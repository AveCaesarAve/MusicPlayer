package com.musicstructureapp.android.musicstructureapp;

import java.util.ArrayList;

/**
 * Created by narcy on 19.03.2018.
 */

public class SongList {

    private static ArrayList<SongModel> song = new ArrayList<>();

    public static ArrayList<SongModel> getSong() {
        if (song.size() == 0)
            InitData();
        return song;
    }

    // Create a list of songs
    private static void InitData() {
        song.add(new SongModel("Wsciekłe pięści węża 1", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 2", "Adrian Skarpeta", R.raw.metallica_nothing_else_matters));
        song.add(new SongModel("Wsciekłe pięści węża 3", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 4", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 5", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 6", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 7", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 8", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 9", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 10", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 11", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));
        song.add(new SongModel("Wsciekłe pięści węża 12", "Adrian Skarpeta", R.raw.metallica_master_of_puppets));


    }
}



