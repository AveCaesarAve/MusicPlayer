package com.musicstructureapp.android.musicstructureapp;

public class SongModel {

    private String mSongTitle;
    private String mAuthorName;
    private int mMySong;

    public SongModel(String songTitle, String authorName) {
        mSongTitle = songTitle;
        mAuthorName = authorName;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getAuthorName() {
        return mAuthorName;
    }
}