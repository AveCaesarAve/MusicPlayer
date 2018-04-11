package com.musicstructureapp.android.musicstructureapp;

public class SongModel {

    private String mSongTitle;
    private String mAuthorName;
    private int mMySong;

    public SongModel(String songTitle, String authorName, int mySong) {
        mSongTitle = songTitle;
        mAuthorName = authorName;
        mMySong = mySong;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getAuthorName() {
        return mAuthorName;
    }

    public int getMyMusic() {
        return mMySong;
    }
}