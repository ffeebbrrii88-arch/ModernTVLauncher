package com.example.moderntvlauncher;

import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.widget.*;
import android.widget.Toast;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.animation.ScaleAnimation;

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


        LinearLayout card =
                new LinearLayout(context);


        card.setOrientation(
                LinearLayout.VERTICAL
        );


        card.setGravity(
                Gravity.CENTER
        );


        card.setPadding(
                15,
                15,
                15,
                15
        );


        ImageView icon =
                new ImageView(context);


        icon.setImageDrawable(
                apps.get(position).icon
        );


        card.addView(
                icon,
                new LinearLayout.LayoutParams(
                    150,
                    150
                )
        );


        TextView title =
                new TextView(context);


        title.setText(
                apps.get(position).name
        );


        title.setTextColor(
                Color.WHITE
        );


        title.setTextSize(
                18
        );


        title.setTypeface(
                Typeface.DEFAULT_BOLD
        );


        title.setGravity(
                Gravity.CENTER
        );


        title.setSingleLine(
                true
        );


        card.addView(
                title,
                new LinearLayout.LayoutParams(
                    180,
                    50
                )
        );


        card.setFocusable(true);


        card.setFocusableInTouchMode(true);


        card.setBackgroundResource(
                R.drawable.card_focus
        );


        card.setOnFocusChangeListener(
            (v, focused) -> {

                if(focused){

                    ScaleAnimation zoom =
                        new ScaleAnimation(
                            1.0f,
                            1.10f,
                            1.0f,
                            1.10f,
                            Animation.RELATIVE_TO_SELF,
                            0.5f,
                            Animation.RELATIVE_TO_SELF,
                            0.5f
                        );

                    zoom.setDuration(150);

                    zoom.setFillAfter(true);

                    v.startAnimation(zoom);


                } else {

                    v.clearAnimation();

                }

            }
        );


        card.setOnClickListener(
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


        return card;

    }

}
