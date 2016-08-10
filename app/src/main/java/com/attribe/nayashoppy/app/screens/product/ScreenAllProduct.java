package com.attribe.nayashoppy.app.screens.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.util.NavigationUtils;

/**
 * Created by Sabih Ahmed on 10-Aug-16.
 */
public class ScreenAllProduct extends BaseActivity{

    private int categoryID;
    private int brandID;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_all_product);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));
        init();
        setUpViewPager();

    }



    @Override
    public void onToolbarInit(Toolbar toolbar, ActionBar actionBar) {
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle(NavigationUtils.getScreenTitle(this));
        actionBar.setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) toolbar.getRootView().findViewById(R.id.viewpager);
        tabLayout= (TabLayout) toolbar.getRootView().findViewById(R.id.tabs);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                this.finish();
            break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void init() {
        if(getIntent().getBundleExtra(NavigationUtils.BUNDLE_PRODUCTS)!=null){

            Bundle bundle = getIntent().getBundleExtra(NavigationUtils.BUNDLE_PRODUCTS);
            categoryID = bundle.getInt(NavigationUtils.KEY_CATEGORY_ID);
            brandID = bundle.getInt(NavigationUtils.KEY_BRAND_ID);

        }


    }

    private void setUpViewPager() {

        viewPager.setAdapter(NavigationUtils.getPagerAdapter(this,getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }


}
