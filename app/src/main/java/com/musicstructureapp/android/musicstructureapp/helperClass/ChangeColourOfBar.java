package com.musicstructureapp.android.musicstructureapp.helperClass;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.musicstructureapp.android.musicstructureapp.R;

public class ChangeColourOfBar {

    private static int colors[]= {R.color.color_red, R.color.color_blue, R.color.color_yellow, R.color.color_green};
    private static int currentColor = 0;

    public static void choseColour(Context c, View v){

        if(currentColor>=colors.length){
            currentColor = 0;
        }

        v.setBackgroundColor(ContextCompat.getColor(c, colors[currentColor]));
        currentColor++;
    }
}
