package com.attribe.nayashoppy.app.screens.product_listings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.FilterAdapter;
import com.attribe.nayashoppy.app.adapters.FilterValuesAdapter;
import com.attribe.nayashoppy.app.model.dummy_model.FilterKeys;
import com.attribe.nayashoppy.app.model.dummy_model.FilterValue;
import com.attribe.nayashoppy.app.model.product_category.CategoryFilter;
import com.attribe.nayashoppy.app.network.RestClient;
import com.attribe.nayashoppy.app.screens.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Sabih Ahmed on 23-Aug-16.
 */
public class ScreenFilter extends BaseActivity implements FilterAdapter.KeySelectListener{

    private ListView keysListView;
    private ListView valuesList;
    private ArrayList<CategoryFilter.Facets.Filter> filterList;
    private Button buttonApplyFilter;
    private Button buttonResetFilter;
    private ArrayList<String> valuesNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_filter);
        super.initToolbar(getWindow().getDecorView().findViewById(android.R.id.content));

        initViews();
        setKeysList();

    }

    private void initViews() {
        valuesNameList = new ArrayList<String>();

        keysListView = (ListView) findViewById(R.id.keys_list);
        valuesList = (ListView)findViewById(R.id.values_list);
        buttonApplyFilter = (Button) findViewById(R.id.button_filter_apply);
        buttonApplyFilter.setOnClickListener(new ApplyFilterListener());
    }


    @Override
    public void onToolbarInit(Toolbar toolbar, ActionBar actionBar) {

        toolbar.setTitle("Filter");
        setSupportActionBar(toolbar);

    }

    private void setKeysList() {
        Call<CategoryFilter> filters = RestClient.getAdapter().getFilters(2);

        filters.enqueue(new Callback<CategoryFilter>() {
            @Override
            public void onResponse(Call<CategoryFilter> call, Response<CategoryFilter> response) {

                if(response.isSuccessful()){
                    if(response.body().facets!=null){

                        filterList = response.body().facets.getFilters();
                        FilterAdapter filterAdapter = new FilterAdapter(ScreenFilter.this, filterList);
                        keysListView.setAdapter(filterAdapter);
                        filterAdapter.setKeySelectListener(ScreenFilter.this);

                    }
                }

                for(CategoryFilter.Facets.Filter filter : response.body().facets.getFilters()){
                    filter.getName();

                    for(CategoryFilter.Facets.Filter.Value value: filter.getValues()){

                        value.getName();
                    }
                }
            }

            @Override
            public void onFailure(Call<CategoryFilter> call, Throwable t) {

            }
        });

    }


    @Override
    public void onKeySelected(int position) {

        valuesList.setAdapter(new FilterValuesAdapter(this,filterList.get(position).getValues()));
    }

    private class ApplyFilterListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            for(CategoryFilter.Facets.Filter filter : filterList){


                for(CategoryFilter.Facets.Filter.Value value : filter.getValues()){

                    if(value.isSelected){

                        valuesNameList.add(value.getName());
                    }


                }


            }

        }
    }


}
