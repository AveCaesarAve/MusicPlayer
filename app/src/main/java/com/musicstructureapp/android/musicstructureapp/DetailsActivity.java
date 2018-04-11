package com.musicstructureapp.android.musicstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {


    int position;
    ArrayList<SongModel> songList;

    //layout elements
    TextView songTitle;
    TextView songAuthor;
    ImageView songCover;
    SongModel song;
    ImageButton playPause;
    ImageButton back;
    ImageButton forward;
    Button backToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        songTitle = findViewById(R.id.titleTxt);
        songAuthor = findViewById(R.id.authorTxt);
        songCover = findViewById(R.id.coverImage);
        playPause = findViewById(R.id.playPauseBtn);
        back = findViewById(R.id.backBtn);
        forward = findViewById(R.id.fowardBtn);
        backToList = findViewById(R.id.backToListBtn);

        //get songs list
        songList = SongList.getSong();

        //get data from previous activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            position = bundle.getInt("EXTRA_DATA");
            currentSong(position);

        } else {
            Toast.makeText(this, "ERROR :( - I can't load this song", Toast.LENGTH_LONG).show();
        }

       // CLICK LISTENER FOR BACK BUTTON
       backToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

    }

    //get currentSong
    private void currentSong(int currentPos) {
        song = songList.get(currentPos);
        setTitle(song.getSongTitle());

        songTitle.setText(song.getSongTitle());
        songAuthor.setText(song.getAuthorName());
    }
}