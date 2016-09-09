package com.attribe.nayashoppy.app.screens.product_listings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

/**
 * Created by Sabih Ahmed on 23-Aug-16.
 */
public class ScreenFilter extends BaseActivity implements FilterAdapter.KeySelectListener{

    ListView keysListView;
    ListView valuesList;
    ArrayList<FilterValue> filterValues;
    ArrayList<FilterKeys> keysList;
    private ArrayList<CategoryFilter.Facets.Filter> filterList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_filter);
        super.initToolbar(getWindow().getDecorView().findViewById(android.R.id.content));
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);
        setKeysList();

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

        keysListView = (ListView) findViewById(R.id.keys_list);
        valuesList = (ListView)findViewById(R.id.values_list);

        filterValues = new ArrayList<FilterValue>();

        FilterValue value1 = new FilterValue("Samsung");
        FilterValue value2 = new FilterValue("Nokia");
        FilterValue value3 = new FilterValue("Micromax");
        FilterValue value4 = new FilterValue("Apple");
        FilterValue value5 = new FilterValue("HTC");
        FilterValue value6 = new FilterValue("Gionee");
        FilterValue value7 = new FilterValue("Oppo");
        FilterValue value8 = new FilterValue("Karbon");

        addAll(value1,value2,value3,value4,value5,value6,value7,value8);

        FilterKeys keys = new FilterKeys("Brand",filterValues);

        keysList = new ArrayList<FilterKeys>();

        keysList.add(keys);


    }

    private void addAll(FilterValue ...args) {

        for(FilterValue value:args){

            filterValues.add(value);
        }


    }

    @Override
    public void onKeySelected(int position) {

        valuesList.setAdapter(new FilterValuesAdapter(this,filterList.get(position).getValues()));
    }
}
