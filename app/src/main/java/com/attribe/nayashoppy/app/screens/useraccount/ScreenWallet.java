package com.attribe.nayashoppy.app.screens.useraccount;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.util.NavigationUtils;

public class ScreenWallet extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_wallet);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));
    }

    @Override
    public void onToolbarInit(Toolbar toolbar) {
        this.toolbar =toolbar;

        toolbar.setTitle(NavigationUtils.getScreenTitle(this));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
    }
}
