package com.attribe.nayashoppy.app.screens;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.LeftDrawerAdapter;
import com.attribe.nayashoppy.app.adapters.RightDrawerAdapter;
import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.util.DevicePreferences;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import java.util.ArrayList;


public class Main extends BaseActivity {

    private DrawerLayout drawerLayout;
    private ArrayList<Datum> parentCategories;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_main);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));
        init();
        setupViewPager(viewPager);
        setupDrawer();


    }



    @Override
    public void onToolbarInit(Toolbar toolbar, ActionBar actionBar) {
        toolbar.setTitle(NavigationUtils.getScreenTitle(this));

        EditText editText =  (EditText)findViewById(R.id.search_field);

        editText.setHintTextColor(getResources().getColor(R.color.black));
        editText.setOnEditorActionListener(new SearchActionListener());
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

    }

    private void init() {
        parentCategories = DevicePreferences.getInstance().getMenu();
    }

    private void setupDrawer() {
        setUpLeftDrawerList();
        setupRightDrawerList();

        ActionBarDrawerToggle mDrawerToggle;
        final ActionBar actionBar = getSupportActionBar();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

            mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                    R.string.drawer_open, R.string.drawer_close)
            {

                public void onDrawerClosed(View view)
                {
                    supportInvalidateOptionsMenu();

                }

                public void onDrawerOpened(View drawerView)
                {
                    supportInvalidateOptionsMenu();

                }
            };
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            drawerLayout.setDrawerListener(mDrawerToggle);
            mDrawerToggle.syncState();
        }
    }

    private void setUpLeftDrawerList() {
        RecyclerView leftDrawer = (RecyclerView) findViewById(R.id.left_drawer);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        leftDrawer.setLayoutManager(layoutManager);
        leftDrawer.setAdapter(new LeftDrawerAdapter(this,parentCategories));


    }

    private void setupRightDrawerList() {

        ListView rightDrawer= (ListView) findViewById(R.id.right_drawer);
        rightDrawer.setAdapter(new RightDrawerAdapter(this, NavigationUtils.getRightDrawer()));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_settings).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){

            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;

            case R.id.action_settings:
                break;

            case R.id.my_account:
                drawerLayout.openDrawer(GravityCompat.END);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    //===================================private Methods=======================================================
    private void setupViewPager(ViewPager viewPager) {

        this.viewPager.setAdapter(NavigationUtils.getPagerAdapter(this,getSupportFragmentManager(),null));
        tabLayout.setupWithViewPager(this.viewPager);


    }




    //********************************************************************************************************






    //==========================================Inner classes/interfaces======================================

    private class SearchActionListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {

            if(actionID== EditorInfo.IME_ACTION_DONE){


                //TODO: handle keyboard done here
            }



            return false;
        }
    }

    //********************************************************************************************************


}
