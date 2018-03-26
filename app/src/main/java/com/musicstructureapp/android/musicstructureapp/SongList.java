package com.musicstructureapp.android.musicstructureapp;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by narcy on 19.03.2018.
 */

public class SongList {

    private static ArrayList<SongModel> song = new ArrayList<SongModel>();
    public static ArrayList<SongModel> getSong(Context context) {
        if (song.size() == 0)
            InitData(context);
        return song;
    }

    // Create a list of song

    private static void InitData(Context context) {
        song.add(new SongModel("Wsciekle piesci weza 1", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));
        song.add(new SongModel("Wsciekle piesci weza", "Adrian Skarpeta", R.drawable.ic_audiotrack));


    }
}



