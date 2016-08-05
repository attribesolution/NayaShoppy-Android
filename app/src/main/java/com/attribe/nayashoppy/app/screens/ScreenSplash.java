package com.attribe.nayashoppy.app.screens;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.network.bals.MenuBAL;
import com.attribe.nayashoppy.app.network.interfaces.MenuListener;
import com.attribe.nayashoppy.app.util.DevicePreferences;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.attribe.nayashoppy.app.util.ProgressLoader;


public class ScreenSplash extends AppCompatActivity {
    private static final boolean AUTO_HIDE = true;
    private ProgressLoader progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.screen_splash);
        progress = NavigationUtils.getProgress(false);
        progress.show(getSupportFragmentManager(),"");
        DevicePreferences.getInstance().init(getApplicationContext());

        //showHomeWithDelay();

        MenuBAL.getMenu(new MenuListener() {
            @Override
            public void onMenuReceived() {

                //TODO: show snackbar about progress
                progress.dismiss();
                Toast.makeText(ScreenSplash.this, "menu received", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onMenuStored() {
                progress.dismiss();
                Toast.makeText(ScreenSplash.this, "menu stored", Toast.LENGTH_SHORT).show();
                NavigationUtils.showHome(ScreenSplash.this);
            }

            @Override
            public void onFailure(String message) {
                progress.dismiss();
                Toast.makeText(ScreenSplash.this, message, Toast.LENGTH_SHORT).show();
                //TODO: show snackbar about exception
            }

            @Override
            public void onDataIssue(String message) {
                progress.dismiss();
                Toast.makeText(ScreenSplash.this, message, Toast.LENGTH_SHORT).show();
            }
        });





    }

    private void showHomeWithDelay() {
        long TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //progress.dismiss();
                NavigationUtils.showHome(ScreenSplash.this);

            }
        }, TIME_OUT);
    }
}



