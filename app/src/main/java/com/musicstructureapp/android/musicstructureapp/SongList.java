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
        song.add(new SongModel("Take on me", "A Ha", R.raw.a_ha_take_on_me));
        song.add(new SongModel("Stand by me", "Ben E. King", R.raw.ben_e_king_stand_by_me));
        song.add(new SongModel("Brown girl in the ring", "Bonney M", R.raw.boney_m_brown_girl_in_the_ring));
        song.add(new SongModel("Daddy cool", "Bonney M", R.raw.boney_m_daddy_cool));
        song.add(new SongModel("Sweet dreams", "Eurythmics", R.raw.eurythmics_sweet_dream));
        song.add(new SongModel("I was made for loving you", "Kiss", R.raw.kiss_i_was_made_for_lovin_you));
        song.add(new SongModel("Cherry cherry lady", "Modern Talking", R.raw.modern_talking_cheri_cheri_lady));
        song.add(new SongModel("Never gonna give you up", "Rick Astley", R.raw.rick_astley_never_gonna_give_you_up));
        song.add(new SongModel("San Francisco", "Scott McKenzie", R.raw.san_francisco_scott_mckenzie));
        song.add(new SongModel("California dreaming", "The mamas the papas", R.raw.the_mamas_the_papas_california_dreamin));
        song.add(new SongModel("Every breath you take", "The police", R.raw.the_police_every_breath_you_take));
        song.add(new SongModel("Stayin Alive", "Bee Gees", R.raw.bee_gees_stayin_alive));






    }
}



