package com.musicstructureapp.android.musicstructureapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by narcy on 19.03.2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    private ArrayList<SongModel> songsList = new ArrayList<SongModel>();
    private Context context;
    private SongAdapter mSongAdapter;

    public SongAdapter(Context context, ArrayList<SongModel> songs) {
        this.context = context;
        this.songsList = songs;
    }


    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
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

                Toast.makeText(context, pos+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView songTitle, authorName;
        ImageButton btnAction;
        ImageView coverImg;
        public SongHolder(View itemView) {
            super(itemView);
            songTitle = (TextView) itemView.findViewById(R.id.textTitle);
            authorName = (TextView) itemView.findViewById(R.id.textAuthor);
            btnAction = (ImageButton) itemView.findViewById(R.id.playArrow);
            coverImg = (ImageView) itemView.findViewById(R.id.imageAlbumCover);
        }
    }


}