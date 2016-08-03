package com.attribe.nayashoppy.app.screens.product;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;
import com.attribe.nayashoppy.app.screens.BaseActivity;

public class ScreenProducts extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_products);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));

        init();
    }



    @Override
    public void onToolbarInit(Toolbar toolbar) {

        FrameLayout frame = (FrameLayout) toolbar.getRootView().findViewById(R.id.search_parent);
        EditText searchField = (EditText) toolbar.getRootView().findViewById(R.id.search_field);
        searchField.setVisibility(View.INVISIBLE);

        ViewPager pager = (ViewPager)toolbar.getRootView().findViewById(R.id.viewpager) ;
        pager.setVisibility(View.GONE);

        TabLayout tabs = (TabLayout) toolbar.getRootView().findViewById(R.id.tabs);
        tabs.setBackgroundColor(getResources().getColor(R.color.primary));

    }

    private void init() {
        setNewArrivalsList();

    }


    private void setNewArrivalsList() {
        ProductsBAL.getProducts(1,0);
    }
}
