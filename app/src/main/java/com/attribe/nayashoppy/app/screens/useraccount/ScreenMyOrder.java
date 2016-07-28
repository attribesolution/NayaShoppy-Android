package com.attribe.nayashoppy.app.screens.useraccount;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.MyOrderAdapter;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.util.DummyData;
import com.attribe.nayashoppy.app.util.NavigationUtils;

public class ScreenMyOrder extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_my_order);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));
        init();
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


    private void init() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_myorder);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(new MyOrderAdapter(DummyData.getDummyProducts()));
        recyclerView.setLayoutManager(layoutManager);
    }
}
