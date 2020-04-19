package com.thavaredaily.util;

import android.content.Context;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

public class CommonUtils {

    public static CircularProgressDrawable getCircularProgressDrawable(Context context){
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(36f);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }
}
