package com.example.moderntvlauncher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {

        super.onCreate(b);

        setContentView(R.layout.activity_main);

        GridView grid=findViewById(R.id.appGrid);

        grid.setAdapter(new AppAdapter(this));
    }
}
