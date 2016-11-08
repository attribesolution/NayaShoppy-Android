package com.attribe.nayashoppy.app.screens;

import android.content.Intent;
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
import com.attribe.nayashoppy.app.model.product_category.ProductSearch;
import com.attribe.nayashoppy.app.network.RestClient;
import com.attribe.nayashoppy.app.util.DevicePreferences;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Locale;


public class Main extends BaseActivity {

    private DrawerLayout drawerLayout;
    private ArrayList<Datum> parentCategories;
    private EditText edtSearchProduct;
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

        edtSearchProduct =  (EditText)findViewById(R.id.search_field);
        edtSearchProduct.setHintTextColor(getResources().getColor(R.color.black));
        edtSearchProduct.setOnEditorActionListener(new SearchActionListener());

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
            case R.id.share:
                shareApp();
                break;
            case R.id.action_settings:
                break;

            case R.id.my_account:
                drawerLayout.openDrawer(GravityCompat.END);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void shareApp() {

        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Naya Shoppy");
            String sAux = "\nLet me recommend you this application\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id="+getPackageName()+" \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));
        } catch(Exception e) {
            //e.toString();

        }
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

                searchProdeuct();
            }



            return false;
        }
    }

    private void searchProdeuct() {

        String text =  edtSearchProduct.getText().toString().toLowerCase(Locale.getDefault());
        Call<ProductSearch> searches = RestClient.getAdapter().getSearchedProduct(text);
        searches.enqueue(new Callback<ProductSearch>() {
            @Override
            public void onResponse(Call<ProductSearch> call, Response<ProductSearch> response) {
                if(response.isSuccessful()){
                    if(response.body().facets!=null){

//                        filterList = response.body().facets.getFilters();
//                        FilterAdapter filterAdapter = new FilterAdapter(ScreenFilter.this, filterList);
//                        keysListView.setAdapter(filterAdapter);
//                        filterAdapter.setKeySelectListener(ScreenFilter.this);

                    }
                }
            }

            @Override
            public void onFailure(Call<ProductSearch> call, Throwable t) {

            }
        });
    }


    //********************************************************************************************************


}
