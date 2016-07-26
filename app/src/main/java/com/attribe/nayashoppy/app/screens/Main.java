package com.attribe.nayashoppy.app.screens;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.DrawerAdapter;
import com.attribe.nayashoppy.app.adapters.MainScreenPagerAdapter;
import com.attribe.nayashoppy.app.util.NavigationUtils;


public class Main extends BaseActivity {

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_main);
        super.initToolbar(this.getWindow().getDecorView().findViewById(android.R.id.content));


    }

    @Override
    public void onToolbarInit(Toolbar toolbar) {
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        EditText editText =  (EditText)findViewById(R.id.search_field);

        editText.setHintTextColor(getResources().getColor(R.color.black));
        editText.setOnEditorActionListener(new SearchActionListener());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setupDrawer();


    }

    private void setupDrawer() {
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

    private void setupRightDrawerList() {

        ListView rightDrawer= (ListView) findViewById(R.id.right_drawer);
        rightDrawer.setAdapter(new DrawerAdapter(this, NavigationUtils.getRightDrawer()));

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



        }
        return super.onOptionsItemSelected(item);
    }


    //===================================private Methods=======================================================
    private void setupViewPager(ViewPager viewPager) {
        MainScreenPagerAdapter adapter = new MainScreenPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(NavigationUtils.getPagerAdapter(this,getSupportFragmentManager()));
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
