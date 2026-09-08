package com.example.moderntvlauncher;


import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;


public class FavoriteManager {


    static final String PREF =
        "favorite_apps";


    public static void add(
            Context context,
            String pkg){


        SharedPreferences sp =
            context.getSharedPreferences(
                PREF,
                Context.MODE_PRIVATE
            );


        Set<String> list =
            new HashSet<>(
                sp.getStringSet(
                    "apps",
                    new HashSet<String>()
                )
            );


        list.add(pkg);


        sp.edit()
        .putStringSet(
            "apps",
            list
        )
        .apply();

    }



    public static Set<String> getAll(
            Context context){


        SharedPreferences sp =
            context.getSharedPreferences(
                PREF,
                Context.MODE_PRIVATE
            );


        return sp.getStringSet(
            "apps",
            new HashSet<String>()
        );

    }

}
