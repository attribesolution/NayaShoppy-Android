package com.attribe.nayashoppy.app.screens.useraccount;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.util.NavigationUtils;

public class ScreenRateApp extends BaseActivity {

    private final String MARKET_URL= "market://details?id=" +getPackageName();
    private RatingBar ratebar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_rate_app);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));
        init();

    }

    private void init() {
        ratebar = (RatingBar)findViewById(R.id.ratingBar2);
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

        if (item.getItemId() == android.R.id.home) {

            this.finish();
        }
        return true;
    }


    public void submitRating(View view) {
        float rating = ratebar.getRating();
        if (rating >= 3) {
            launchMarket();
        } else if (rating == 0) {
            Toast.makeText(getApplicationContext(), "Kindly Rate the stars", Toast.LENGTH_SHORT).show();
        } else{

            Toast.makeText(getApplicationContext(), "Thanks for Rating", Toast.LENGTH_LONG).show();
            finish();
        }

    }

    public void  cencle(View view)
    {
        finish();
    }


    private void launchMarket()
    {
        Uri uri = Uri.parse(MARKET_URL);
        Intent linkToMarket = new Intent(Intent.ACTION_VIEW,uri);
        try{
            startActivity(linkToMarket);
        }catch (ActivityNotFoundException e)
        {
            Toast.makeText(this, " unable to find this app", Toast.LENGTH_LONG).show();
        }


    }



}
