package com.musicstructureapp.android.musicstructureapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.gresse.hugo.vumeterlibrary.VuMeterView;

public class DetailsActivity extends AppCompatActivity implements AudioManager.OnAudioFocusChangeListener {

    //data
    int position;
    int myCurrentSong;
    ArrayList<SongModel> songList;

    //layout elements
    TextView songTitle;
    TextView songAuthor;
    ImageView songCover;
    SongModel song;
    ImageButton playPause;
    ImageButton back;
    ImageButton forward;
    SeekBar seekBar;
    Button backToList;

    //media player
    Handler handler;
    Runnable runnable;
    MediaPlayer mediaPlayer;
    VuMeterView equalizerAnim;

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
        seekBar = findViewById(R.id.seekBar);
        equalizerAnim = findViewById(R.id.vumeter);
        backToList = findViewById(R.id.backToListBtn);

        //get songs list
        songList = SongList.getSong();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get data from previous activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            position = bundle.getInt("EXTRA_DATA");
            currentSong(position);

        } else {
            Toast.makeText(this, "ERROR :( - I can't load this song", Toast.LENGTH_LONG).show();
        }

        handler = new Handler();
        startPlayMusic();
        seekBarChangePosition();

        // CLICK LISTENERS
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playPause.setImageResource(R.drawable.ic_play);
                    equalizerAnim.stop(true);

                } else {
                    mediaPlayer.start();
                    seekBarMove();
                    playPause.setImageResource(R.drawable.ic_pause);
                    equalizerAnim.resume(true);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0)
                    back.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
                if (position > 0) {
                    currentSong(--position);
                    resetTintBtn();
                }
                mediaPlayer.release();
                startPlayMusic();
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == (songList.size() - 1))
                    forward.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
                if (position < (songList.size() - 1)) {
                    currentSong(++position);
                    resetTintBtn();
                }
                mediaPlayer.release();
                startPlayMusic();
            }
        });

        backToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.release();
                Intent myIntent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

    }// === END onCreate ===

    //get currentSong
    private void currentSong(int currentPos) {
        song = songList.get(currentPos);
        setTitle(song.getSongTitle());

        songTitle.setText(song.getSongTitle());
        songAuthor.setText(song.getAuthorName());
        myCurrentSong = song.getMyMusic();
    }

    //reset back and forward button background color
    private void resetTintBtn() {
        back.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
        forward.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
    }

    //start play music
    public void startPlayMusic() {
        mediaPlayer = MediaPlayer.create(this, myCurrentSong);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();

        seekBar.setMax(mediaPlayer.getDuration());

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                seekBarMove();
                mediaPlayer.start();
            }
        });
    }

    //seekBar current position and move
    public void seekBarMove() {
        try {
            if (mediaPlayer.isPlaying()) {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                runnable = new Runnable() {
                    @Override
                    public void run() {
                        seekBarMove();
                    }
                };
                handler.postDelayed(runnable, 1000);
            }
        } catch (Exception e) {
            Log.v("catch exception", "success");
        }
    }

    public void seekBarChangePosition() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                if (input) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    //activity life cycle and mediaPlayer behavior
    @Override
    protected void onDestroy() {

        super.onDestroy();
        mediaPlayer.release();
        handler.removeCallbacks(runnable);
    }

    //release MediaPlayer when come back to list view by arrow
    @Override
    public void onBackPressed() {
        mediaPlayer.release();
        super.onBackPressed();
    }

    //audiofocus changes
    @Override
    public void onAudioFocusChange(int focusChange) {

        if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
            //AUDIOFOCUS_LOSS_TRANSIENT lost audio focus for a short amount of time.
            //AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK continue playing sound but at a lower volume
            mediaPlayer.pause();
        } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
            //AUDIOFOCUS_GAIN regained focus and can resume playback.
            mediaPlayer.start();
        } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
            //AUDIOFOCUS_LOSS lost audio focus
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        }
    }
}