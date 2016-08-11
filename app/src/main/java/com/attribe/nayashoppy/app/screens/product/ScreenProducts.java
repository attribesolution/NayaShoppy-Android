package com.attribe.nayashoppy.app.screens.product;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.PopularProductAdapter;
import com.attribe.nayashoppy.app.adapters.ProductArrivalAdapter;
import com.attribe.nayashoppy.app.model.popular_products.Data;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;
import com.attribe.nayashoppy.app.network.interfaces.LatestProductsListener;
import com.attribe.nayashoppy.app.network.interfaces.PopularProductsListener;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.util.InfiniteScroller;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

public class ScreenProducts extends BaseActivity {

    private int categoryID = 1;
    private int brandID = 0;
    private AVLoadingIndicatorView progress;
    private ArrayList<Datum> mNewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_products);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));

        init();
    }



    @Override
    public void onToolbarInit(Toolbar toolbar, ActionBar actionBar) {
        toolbar.setTitle(NavigationUtils.getScreenTitle(this));
        actionBar.setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();


//        actionBar.setLogo(R.drawable.logo);
//        actionBar.setDisplayUseLogoEnabled(true);

//        TabLayout tab_layout = (TabLayout) findViewById(R.id.tabs);
//
//        tab_layout.setTabMode(TabLayout.MODE_FIXED);
//
//        tab_layout.addTab(tab_layout.newTab().setText("Tab 1").setCustomView(R.layout.tab));
//        tab_layout.addTab(tab_layout.newTab().setText("Tab 2"));
//        tab_layout.addTab(tab_layout.newTab().setText("Tab 3"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                this.finish();
                break;
        }

        return true;
    }

    private void init() {
        progress = (AVLoadingIndicatorView) findViewById(R.id.progress_wheel);
        mNewProducts = new ArrayList<Datum>();
        fetchIntent();
        setNewArrivalsList();
        setPopularList();


    }

    private void fetchIntent() {
        if(getIntent().getBundleExtra(NavigationUtils.BUNDLE_PRODUCTS)!=null){

            Bundle bundle = getIntent().getBundleExtra(NavigationUtils.BUNDLE_PRODUCTS);
            categoryID = bundle.getInt(NavigationUtils.KEY_CATEGORY_ID);
            brandID = bundle.getInt(NavigationUtils.KEY_BRAND_ID);

        }
    }


    private void setNewArrivalsList() {
        progress.setVisibility(View.VISIBLE);
        final RecyclerView recycler_newArrivals = (RecyclerView) findViewById(R.id.recycler_products_new_arrival);
        final LinearLayoutManager layoutHorizontal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recycler_newArrivals.setLayoutManager(layoutHorizontal);

        ProductsBAL.getNewProducts(categoryID, brandID,0, new LatestProductsListener() {
            @Override
            public void onDataReceived(ArrayList<Datum> data) {
                mNewProducts = data;
                progress.setVisibility(View.GONE);
                recycler_newArrivals.setAdapter(new ProductArrivalAdapter(data));


            }

            @Override
            public void onDataIssue(String message) {

            }

            @Override
            public void onFailure(String message) {

            }
        });

        recycler_newArrivals.addOnScrollListener(new InfiniteScroller(layoutHorizontal) {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {

                return false;
            }
        });

    }

    private void setPopularList() {
        final AVLoadingIndicatorView progress_popular = (AVLoadingIndicatorView) findViewById(R.id.progress_popular);
        progress_popular.setVisibility(View.VISIBLE);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_products);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(layoutManager);


        ProductsBAL.getPopularProducts(categoryID,brandID,0, new PopularProductsListener() {
            @Override
            public void onDataReceived(ArrayList<Data> data) {
                progress_popular.setVisibility(View.GONE);
                recyclerView.setAdapter(new PopularProductAdapter(data));
            }

            @Override
            public void onDataIssue(String message) {
                progress_popular.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(String message) {
                progress_popular.setVisibility(View.GONE);
            }
        });

        }

}
