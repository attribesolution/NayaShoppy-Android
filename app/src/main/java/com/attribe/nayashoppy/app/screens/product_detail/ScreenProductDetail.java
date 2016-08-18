package com.attribe.nayashoppy.app.screens.product_detail;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.ProductScreenPager;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import com.attribe.nayashoppy.app.util.UINotifier;

import java.util.ArrayList;


public class ScreenProductDetail extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tabLayout;
    private CoordinatorLayout parentLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_product_detail);

        //super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));
        init();
    }

    private void init() {
        parentLayout = (CoordinatorLayout) findViewById(R.id.product_detail_parent);
        Bundle productBundle = null;

        try {
            productBundle = getIntent().getBundleExtra(NavigationUtils.BUNDLE_PRODUCTS);
            //int productID = productBundle.getInt(NavigationUtils.KEY_PRODUCT_ID,0);
        }catch (Exception exc){
            UINotifier.showSnackBar(parentLayout,exc.getLocalizedMessage());
        }


        toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        ArrayList<Fragment> fragmentList =  new ArrayList<Fragment>();
        ArrayList<String> fragmentTitleList= new ArrayList<String>();
        fragmentList.add(new FragmentPrices());
        fragmentList.add(new FragmentSpecification());
        fragmentList.add(new FragmentReviews());

        fragmentTitleList.add("PRICES");
        fragmentTitleList.add("SPECIFICATION");
        fragmentTitleList.add("REVIEWS");
        try {
            viewpager.setAdapter(NavigationUtils.getPagerAdapter(this,getSupportFragmentManager(),productBundle));


        }catch (Exception exc){

            Log.d(ScreenProductDetail.class.getSimpleName(),exc.getLocalizedMessage());
        }

        tabLayout.setupWithViewPager(viewpager);
    }

}
