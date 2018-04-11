package com.musicstructureapp.android.musicstructureapp;

import java.util.ArrayList;

public class SongList {

    private static ArrayList<SongModel> song = new ArrayList<>();

    public static ArrayList<SongModel> getSong() {
        if (song.size() == 0)
            InitData();
        return song;
    }

    // Create a list of songs
    private static void InitData() {
        song.add(new SongModel("Enter Sandman", "Metallica"));
        song.add(new SongModel("Sad but True", "Metallica"));
        song.add(new SongModel("Holier Than Thou", "Metallica"));
        song.add(new SongModel("The Unforgiven", "Metallica"));
        song.add(new SongModel("Wherever I May Roam", "Metallica"));
        song.add(new SongModel("Don't Tread on Me", "Metallica"));
        song.add(new SongModel("Through the Never", "Metallica"));
        song.add(new SongModel("Nothing Else Matters", "Metallica"));
        song.add(new SongModel("Of Wolf and Man", "Metallica"));
        song.add(new SongModel("The God That Failed", "Metallica"));
        song.add(new SongModel("My Friend of Misery", "Metallica"));
        song.add(new SongModel("The Struggle Within", "Metallica"));
    }
}