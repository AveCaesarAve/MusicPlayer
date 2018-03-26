package com.musicstructureapp.android.musicstructureapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by narcy on 19.03.2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    private ArrayList<SongModel> songsList = new ArrayList<SongModel>();
    private Context context;


    public SongAdapter(Context context, ArrayList<SongModel> songs) {
        this.context = context;
        this.songsList = songs;
    }

    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.one_row,viewGroup,false);
        return new SongHolder(myView);
    }

    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int pos) {
        songHolder.songTitle.setText(songsList.get(pos).getmSongTitle());
        songHolder.authorName.setText(songsList.get(pos).getmAuthorName());
        songHolder.coverImg.setImageResource(songsList.get(pos).getImageId());

        songHolder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent myIntent = new Intent(context, DetailsActivity.class);
                myIntent.putExtra("EXTRA_DATA", pos);
                context.startActivity(myIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    class SongHolder extends RecyclerView.ViewHolder {
        TextView songTitle, authorName;
        ImageButton btnAction;
        ImageView coverImg;
        SongHolder(View itemView) {
            super(itemView);
            songTitle = itemView.findViewById(R.id.textTitle);
            authorName = itemView.findViewById(R.id.textAuthor);
            btnAction = itemView.findViewById(R.id.playArrow);
            coverImg = itemView.findViewById(R.id.imageAlbumCover);
        }
    }
}