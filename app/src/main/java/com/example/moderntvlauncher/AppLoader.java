package com.example.moderntvlauncher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.*;

import java.util.ArrayList;
import java.util.List;


public class AppLoader {


    public static ArrayList<AppInfo> load(Context context){

        ArrayList<AppInfo> list =
                new ArrayList<>();

        PackageManager pm =
                context.getPackageManager();


        Intent intent =
                new Intent(Intent.ACTION_MAIN);

        intent.addCategory(
                Intent.CATEGORY_LAUNCHER
        );


        List<ResolveInfo> apps =
                pm.queryIntentActivities(
                        intent,0);


        for(ResolveInfo r:apps){

            String name =
                r.loadLabel(pm)
                .toString();


            String pkg =
                r.activityInfo.packageName;


            list.add(
                new AppInfo(
                    name,
                    pkg,
                    r.loadIcon(pm)
                )
            );
        }


        return list;
    }
}
