package com.attribe.nayashoppy.app.screens;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.util.NavigationUtils;


public class ShopByCategory extends BaseActivity {

    private Toolbar toolbar;
    private int categoryID;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_by_category);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));
        init();


    }


    @Override
    public void onToolbarInit(Toolbar toolbar, ActionBar actionBar) {

        this.toolbar = toolbar;
        this.actionBar = actionBar;


    }

    private void init() {

        try {
            categoryID = getIntent().getBundleExtra(NavigationUtils.BUNDLE_FROM_MAIN).getInt(NavigationUtils.KEY_MENU_ID);
            initToolBar(categoryID);
        }
        catch (NullPointerException npe){

            //TODO : Show Snack bar here
            throw new RuntimeException("Problem resolving category this time");
        }

    }
    private void initToolBar(int categoryID) {
        //toolbar = (Toolbar) findViewById(R.id.toolbar_shop);
        toolbar.getRootView().findViewById(R.id.search_field).setVisibility(View.INVISIBLE);
        toolbar.setTitle("Shop By Categories");


        //toolbar.removeView(toolbar.getRootView().findViewById(R.id.viewpager));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(categoryID);

//        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
    }

    private void setupViewPager(ViewPager viewPager) {

        viewPager.setAdapter(NavigationUtils.getPagerAdapter(this,getSupportFragmentManager(),null));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){

            this.finish();
        }
        return true;
    }
}
