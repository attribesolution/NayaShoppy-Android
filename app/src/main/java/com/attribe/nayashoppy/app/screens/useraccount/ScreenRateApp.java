package com.attribe.nayashoppy.app.screens.useraccount;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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
    public void onToolbarInit(Toolbar toolbar, ActionBar actionBar) {

        //this.toolbar = toolbar ;
        toolbar.setTitle(NavigationUtils.getScreenTitle(this));


//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setLogo(R.drawable.logo);
//        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){

            this.finish();
        }
        return true;
    }


}
