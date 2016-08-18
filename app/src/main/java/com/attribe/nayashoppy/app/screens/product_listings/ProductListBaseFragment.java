package com.attribe.nayashoppy.app.screens.product_listings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.PopularProductAdapter;
import com.attribe.nayashoppy.app.model.popular_products.Data;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;
import com.attribe.nayashoppy.app.network.interfaces.PopularProductsListener;
import com.attribe.nayashoppy.app.util.InfiniteScroller;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 15-Aug-16.
 */
public abstract class ProductListBaseFragment extends Fragment{

    private static final int GRID_SPAN_COUNT = 2;
    private View view;
    private AVLoadingIndicatorView progress;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private int categoryID;
    private int brandID;
    private ArrayList<Data> mPopularProductList;
    private ArrayList<Datum> mAllProductList;
    private PopularProductAdapter gridViewAdapter;
    private boolean isScrolled;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if(item.getItemId()==R.id.grid){


        }

        return super.onOptionsItemSelected(item);
    }

    private void togglePopularProductView() {

    }

    public void init(View view){

        //fetch view from child then initialize
        //fetch progress,
        // recycler view,
        // gridLayoutManager,
        // & initialize
        setHasOptionsMenu(true);

        gridLayoutManager = new GridLayoutManager(getActivity(),GRID_SPAN_COUNT);

        try {

            categoryID = getArguments().getInt(NavigationUtils.KEY_CATEGORY_ID);


        }catch (Exception exc){
            throw new RuntimeException("Failed to resolve categoryID");
        }

        try {


            brandID = getArguments().getInt(NavigationUtils.KEY_BRAND_ID);

        }catch (Exception exc){
            throw new RuntimeException("Failed to resolve brandID");
        }


        try {
            progress = (AVLoadingIndicatorView) view.findViewById(R.id.progress_wheel);
        }
        catch (NullPointerException npe){

            throw new RuntimeException("Progress view not added");
        }



        try {
            recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_popular);
        }
        catch (NullPointerException npe){

            throw new RuntimeException("Recycler view not added");
        }



        recyclerView.setLayoutManager(gridLayoutManager);



    }

    private void fetchData(int categoryID, int brandID, int page, boolean isScrolled){


        //fetch all Product/ popular product dynamically

    }
    private void fetchAllProductData(int categoryID, int brandID,int page) {
        //fetch data from Products bal and return data set
    }

    private void fetchPopularProductData(int categoryID, int brandID, int page, final boolean isScrolled){

        ProductsBAL.getPopularProducts(categoryID,brandID, page , new PopularProductsListener() {
            @Override
            public void onDataReceived(ArrayList<Data> data) {

                if(isScrolled){

                    mPopularProductList.addAll(data);
                    gridViewAdapter.notifyDataSetChanged();
                }
                if(!isScrolled){
                    mPopularProductList = data;
                    gridViewAdapter = new PopularProductAdapter(mPopularProductList);
                    recyclerView.setAdapter(gridViewAdapter);
                    recyclerView.addOnScrollListener(new EndlessScrollListener(gridLayoutManager));
                }


            }

            @Override
            public void onDataIssue(String message) {

                //TODO:Handle UI /exception here
            }

            @Override
            public void onFailure(String message) {

                //TODO: handle exception here
            }
        });
    }

    abstract void onDataFetched();
    abstract void onViewInitialized(int categoryID, int brandID, AVLoadingIndicatorView progress, RecyclerView recyclerView, GridLayoutManager gridLayoutManager);

    private class EndlessScrollListener extends InfiniteScroller {


        public EndlessScrollListener(LinearLayoutManager layoutHorizontal) {
            super(layoutHorizontal);
        }

        @Override
        public boolean onLoadMore(int page, int totalItemsCount) {


            fetchData(categoryID,brandID,page,true);
            return false;
        }
    }
}
