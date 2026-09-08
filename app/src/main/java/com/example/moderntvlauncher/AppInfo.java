package com.example.moderntvlauncher;

import android.graphics.drawable.Drawable;

public class AppInfo {

    String name;
    String packageName;
    Drawable icon;

    public AppInfo(
        String name,
        String packageName,
        Drawable icon
    ){
        this.name = name;
        this.packageName = packageName;
        this.icon = icon;
    }
}
