package com.musicstructureapp.android.musicstructureapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.musicstructureapp.android.musicstructureapp.helperClass.ChangeColourOfBar;

import java.util.ArrayList;

/**
 * Created by narcy on 19.03.2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    private ArrayList<SongModel> songsList;
    private Context context;

    public SongAdapter(Context context, ArrayList<SongModel> songs) {
        this.context = context;
        this.songsList = songs;
    }

    //inflate one_row layout
    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.one_row, viewGroup, false);
        return new SongHolder(myView);
    }

    //uses a holder to give elements to functionality
    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int pos) {
        songHolder.songTitle.setText(songsList.get(pos).getSongTitle());
        songHolder.authorName.setText(songsList.get(pos).getAuthorName());

        songHolder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(context, DetailsActivity.class);
                myIntent.putExtra("EXTRA_DATA", pos);
                context.startActivity(myIntent);
            }
        });

        //I give different colors to stripes in List - only decoration
        ChangeColourOfBar.choseColour(context, songHolder.colorBar);
    }

    //how many elements does my list have
    @Override
    public int getItemCount() {
        return songsList.size();
    }

    //finds all fields in layout
    class SongHolder extends RecyclerView.ViewHolder {
        TextView songTitle, authorName;
        ImageButton btnAction;
        View colorBar;

        SongHolder(View itemView) {
            super(itemView);
            songTitle = itemView.findViewById(R.id.textTitle);
            authorName = itemView.findViewById(R.id.textAuthor);
            btnAction = itemView.findViewById(R.id.playArrow);
            colorBar = itemView.findViewById(R.id.borderColor);
        }
    }
}