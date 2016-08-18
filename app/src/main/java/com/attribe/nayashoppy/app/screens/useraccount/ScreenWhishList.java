package com.attribe.nayashoppy.app.screens.useraccount;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.WishListAdapter;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import com.attribe.nayashoppy.app.util.NavigationUtils;

public class ScreenWhishList extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_wish_list);
        super.initToolbar(getWindow().getDecorView().findViewById(android.R.id.content));
        init();
    }



    @Override
    public void onToolbarInit(Toolbar toolbar, ActionBar actionBar) {


        toolbar.setTitle(NavigationUtils.getScreenTitle(this));

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setDisplayUseLogoEnabled(true);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){

            this.finish();
        }
        return true;
    }

    private void init() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_wish_List);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new WishListAdapter(this));


    }

}
