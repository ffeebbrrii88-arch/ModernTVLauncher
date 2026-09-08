package com.example.moderntvlauncher;


import android.content.Context;

import java.util.ArrayList;
import java.util.Set;


public class FavoriteLoader {


    public static ArrayList<AppInfo> filter(

            Context context,

            ArrayList<AppInfo> apps){


        ArrayList<AppInfo> result =
            new ArrayList<>();


        Set<String> fav =
            FavoriteManager.getAll(
                context
            );


        for(AppInfo app: apps){


            if(
                fav.contains(
                    app.packageName
                )
            ){

                result.add(app);

            }

        }


        return result;

    }

}
