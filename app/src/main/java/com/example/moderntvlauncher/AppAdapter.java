package com.example.moderntvlauncher;

import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.widget.*;
import android.graphics.Color;
import android.graphics.Typeface;

import java.util.ArrayList;


public class AppAdapter extends BaseAdapter {


    Context context;
    ArrayList<AppInfo> apps;


    public AppAdapter(Context c, ArrayList<AppInfo> list){

        context = c;
        apps = list;

    }


    @Override
    public int getCount(){

        return apps.size();

    }


    @Override
    public Object getItem(int position){

        return apps.get(position);

    }


    @Override
    public long getItemId(int position){

        return position;

    }


    @Override
    public View getView(
            int position,
            View convertView,
            ViewGroup parent){


        LinearLayout box =
                new LinearLayout(context);


        box.setOrientation(
                LinearLayout.VERTICAL
        );


        box.setGravity(
                Gravity.CENTER
        );


        box.setPadding(
                20,20,20,20
        );


        ImageView icon =
                new ImageView(context);


        icon.setImageDrawable(
                apps.get(position).icon
        );


        box.addView(
                icon,
                new LinearLayout.LayoutParams(
                    120,
                    120
                )
        );


        TextView text =
                new TextView(context);


        text.setText(
                apps.get(position).name
        );


        text.setTextColor(
                Color.WHITE
        );


        text.setTextSize(
                18
        );


        text.setTypeface(
                Typeface.DEFAULT_BOLD
        );


        text.setGravity(
                Gravity.CENTER
        );


        box.addView(
                text,
                new LinearLayout.LayoutParams(
                    180,
                    60
                )
        );


        box.setFocusable(true);


        box.setFocusableInTouchMode(true);


        box.setBackgroundResource(
                R.drawable.focus_background
        );


        box.setOnClickListener(
            v -> {

                Intent i =
                    context.getPackageManager()
                    .getLaunchIntentForPackage(
                        apps.get(position).packageName
                    );

                if(i != null){

                    context.startActivity(i);

                }

            }
        );


        return box;

    }

}
