package com.thingspeak.thingspeak.utils;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class ProgressUtill {
   static ProgressBar prog ;

    public static void showProgess(Context context,LinearLayout linear1){
        prog = new ProgressBar(context);
        prog.setVisibility(View.VISIBLE);
       linear1.addView(prog);
    }
    public static void hideProgess(Context context){
        prog.setVisibility(View.GONE);
    }
}
