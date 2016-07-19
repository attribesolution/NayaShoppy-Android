package com.attribe.nayashoppy.app.screens;

import com.attribe.nayashoppy.app.R;
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

        showHomeWithDelay();



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



