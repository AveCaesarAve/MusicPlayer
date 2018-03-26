package com.musicstructureapp.android.musicstructureapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    int position;
    TextView songTitle;
    TextView songAuthor;
    ImageView songCover;
    SongModel song;
    ArrayList<SongModel> songList;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        songTitle = findViewById(R.id.titleTxt);
        songAuthor = findViewById(R.id.authorTxt);
        songCover = findViewById(R.id.coverImage);

        songList = SongList.getSong(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            position = bundle.getInt("EXTRA_DATA");
            song = songList.get(position);

            songTitle.setText(song.getmSongTitle());
            songAuthor.setText(song.getmAuthorName());
            songCover.setImageResource(song.getImageId());

        }else{
            Toast.makeText(this, "ERROR :( - I can't load this song",Toast.LENGTH_LONG).show();
        }

    }
}
