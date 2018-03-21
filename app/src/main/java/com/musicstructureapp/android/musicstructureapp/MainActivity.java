package com.musicstructureapp.android.musicstructureapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SongAdapter adapter;
    private ArrayList<SongModel> song = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song = SongList.getSong(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewSong);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new SongAdapter(this, song);
        recyclerView.setAdapter(adapter);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);


        Window w = getWindow(); // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


    }


    //HEIGHT OF STATUS BAR
    private int getStatusBarHeight() {
        int height;

        Resources myResources = getResources();
        int idStatusBarHeight = myResources.getIdentifier(
                "status_bar_height", "dimen", "android");
        if (idStatusBarHeight > 0) {
            height = getResources().getDimensionPixelSize(idStatusBarHeight);
        }else{
            height = 0;
        }

        return height;
    }
}
