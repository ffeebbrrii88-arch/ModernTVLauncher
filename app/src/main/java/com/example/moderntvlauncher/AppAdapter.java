package com.example.moderntvlauncher;

import android.content.Context;
import android.view.*;
import android.widget.*;

public class AppAdapter extends BaseAdapter {

    Context context;

    String[] apps={
        "YouTube",
        "IPTV",
        "Browser",
        "File",
        "Setting",
        "Play Store"
    };


    public AppAdapter(Context c){
        context=c;
    }


    public int getCount(){
        return apps.length;
    }


    public Object getItem(int p){
        return apps[p];
    }


    public long getItemId(int p){
        return p;
    }


    public View getView(int p, View v, ViewGroup parent){

        TextView t=new TextView(context);

        t.setText(apps[p]);

        t.setTextSize(24);

        t.setGravity(17);

        t.setFocusable(true);

        t.setPadding(20,50,20,50);

        t.setBackgroundResource(
            R.drawable.focus_background
        );

        return t;
    }
}
