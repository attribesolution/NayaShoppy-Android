package com.attribe.nayashoppy.app.screens;

import android.widget.Toast;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.network.bals.MenuBAL;
import com.attribe.nayashoppy.app.network.interfaces.MenuListener;
import com.attribe.nayashoppy.app.util.DevicePreferences;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;


public class ScreenSplash extends Activity {
    private static final boolean AUTO_HIDE = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.screen_splash);
        DevicePreferences.getInstance().init(getApplicationContext());

        //showHomeWithDelay();

        MenuBAL.getMenu(new MenuListener() {
            @Override
            public void onMenuReceived() {

                //TODO: show snackbar about progress
                Toast.makeText(ScreenSplash.this, "menu received", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onMenuStored() {
                Toast.makeText(ScreenSplash.this, "menu stored", Toast.LENGTH_SHORT).show();
                NavigationUtils.showHome(ScreenSplash.this);
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(ScreenSplash.this, message, Toast.LENGTH_SHORT).show();
                //TODO: show snackbar about exception
            }

            @Override
            public void onDataIssue(String message) {
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



