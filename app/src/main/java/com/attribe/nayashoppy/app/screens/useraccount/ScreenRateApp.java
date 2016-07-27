package com.attribe.nayashoppy.app.screens.useraccount;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.util.NavigationUtils;

public class ScreenRateApp extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_rate_app);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));



    }

    @Override
    public void onToolbarInit(Toolbar toolbar) {

        //this.toolbar = toolbar ;
        toolbar.setTitle(NavigationUtils.getScreenTitle(this));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

}
