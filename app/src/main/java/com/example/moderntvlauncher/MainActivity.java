package com.example.moderntvlauncher;


import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;


public class MainActivity extends Activity {


    TextView clock;


    @Override
    protected void onCreate(Bundle b){

        super.onCreate(b);


        getWindow().setFlags(
            1024,
            1024
        );


        setContentView(
            R.layout.activity_main
        );


        hideSystemUI();


        clock =
            findViewById(
                R.id.clockText
            );


        updateClock();


        ArrayList<AppInfo> apps =
            AppLoader.load(this);



        GridView all =
            findViewById(
                R.id.appGrid
            );


        all.setAdapter(
            new AppAdapter(
                this,
                apps
            )
        );



        GridView fav =
            findViewById(
                R.id.favoriteGrid
            );


        fav.setAdapter(
            new AppAdapter(
                this,
                FavoriteLoader.filter(
                    this,
                    apps
                )
            )
        );


    }



    void hideSystemUI(){

        getWindow()
        .getDecorView()
        .setSystemUiVisibility(
            5894
        );

    }



    void updateClock(){

        clock.setText(
            new SimpleDateFormat(
                "HH:mm"
            )
            .format(
                new Date()
            )
        );

    }


}
