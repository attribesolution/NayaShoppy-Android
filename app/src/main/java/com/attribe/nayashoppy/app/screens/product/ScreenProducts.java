package com.attribe.nayashoppy.app.screens.product;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.MyOrderAdapter;
import com.attribe.nayashoppy.app.adapters.ProductArrivalAdapter;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.screens.useraccount.ScreenMyOrder;
import com.attribe.nayashoppy.app.util.DummyData;
import com.attribe.nayashoppy.app.util.NavigationUtils;

public class ScreenProducts extends BaseActivity {

    private int categoryID = 1;
    private int brandID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_products);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));

        init();
    }



    @Override
    public void onToolbarInit(Toolbar toolbar) {
        toolbar.setTitle(NavigationUtils.getScreenTitle(this));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);

//        TabLayout tab_layout = (TabLayout) findViewById(R.id.tabs);
//
//        tab_layout.setTabMode(TabLayout.MODE_FIXED);
//
//        tab_layout.addTab(tab_layout.newTab().setText("Tab 1").setCustomView(R.layout.tab));
//        tab_layout.addTab(tab_layout.newTab().setText("Tab 2"));
//        tab_layout.addTab(tab_layout.newTab().setText("Tab 3"));




    }

    private void init() {
        fetchIntent();
        setNewArrivalsList();


    }

    private void fetchIntent() {
        if(getIntent().getBundleExtra(NavigationUtils.BUNDLE_PRODUCTS)!=null){

            Bundle bundle = getIntent().getBundleExtra(NavigationUtils.BUNDLE_PRODUCTS);
            categoryID = bundle.getInt(NavigationUtils.KEY_CATEGORY_ID);
            brandID = bundle.getInt(NavigationUtils.KEY_BRAND_ID);

        }
    }


    private void setNewArrivalsList() {
        RecyclerView recycler_newArrivals = (RecyclerView) findViewById(R.id.recycler_products_new_arrival);
        LinearLayoutManager layoutHorizontal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recycler_newArrivals.setLayoutManager(layoutHorizontal);
        recycler_newArrivals.setAdapter(new MyOrderAdapter(DummyData.getDummyProducts()));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_products);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyOrderAdapter(DummyData.getDummyProducts()));
        ProductsBAL.getProducts(categoryID,brandID);
    }
}
