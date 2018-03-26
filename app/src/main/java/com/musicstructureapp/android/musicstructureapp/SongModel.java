package com.musicstructureapp.android.musicstructureapp;

/**
 * Created by narcy on 19.03.2018.
 */

public class SongModel {

    private String mSongTitle;
    private String mAuthorName;
    private int mCoverImgId;


    public SongModel(String songTitle, String authorName, int coverImgId) {
        mSongTitle = songTitle;
        mAuthorName = authorName;
        mCoverImgId = coverImgId;
    }

    public String getmSongTitle() {
        return mSongTitle;
    }


    public String getmAuthorName() {
        return mAuthorName;
    }


    public int getImageId() {
        return mCoverImgId;
    }
}
