package com.attribe.nayashoppy.app.screens.useraccount;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.util.NavigationUtils;

public class ScreenAboutUs extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_about_us);
        super.initToolbar(getWindow().getDecorView().findViewById(android.R.id.content));
    }

    @Override
    public void onToolbarInit(Toolbar toolbar) {

        toolbar.setTitle(NavigationUtils.getScreenTitle(this));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
