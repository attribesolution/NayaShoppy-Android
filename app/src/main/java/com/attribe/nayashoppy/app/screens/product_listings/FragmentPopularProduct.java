package com.attribe.nayashoppy.app.screens.product_listings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.LinearLayout;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.PopularProductAdapter;
import com.attribe.nayashoppy.app.adapters.PopularProductListAdapter;
import com.attribe.nayashoppy.app.model.popular_products.Data;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;
import com.attribe.nayashoppy.app.network.interfaces.PopularProductsListener;
import com.attribe.nayashoppy.app.util.InfiniteScroller;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 10-Aug-16.
 */
public class FragmentPopularProduct extends Fragment {


    private View view;
    private int categoryID;
    private int brandID;
    private int page =1;
    private boolean isGrid = true;
    private ArrayList<Data> mPopularProductList;
    private PopularProductAdapter gridViewAdapter;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private static final int GRID_SPAN_COUNT = 2;
    private AVLoadingIndicatorView progress;
    private LinearLayoutManager linearLayoutManager;
    private PopularProductListAdapter listViewAdapter;
    private LinearLayout sortingArea;
    private LinearLayout filteringArea;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_popular_product, container, false);

        init();
        setHasOptionsMenu(true);
        return view;
    }


    /**Initializes view, get intent / bundle extras
     * and initializes instance variables
     *
     */
    private void init() {

        progress = (AVLoadingIndicatorView)view.findViewById(R.id.progress_wheel);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_popular);
        gridLayoutManager = new GridLayoutManager(getActivity(),GRID_SPAN_COUNT);



        recyclerView.setLayoutManager(gridLayoutManager);

        try {
            categoryID = getArguments().getInt(NavigationUtils.KEY_CATEGORY_ID);
            brandID = getArguments().getInt(NavigationUtils.KEY_BRAND_ID);

        }catch (Exception exc){

        }


        getProducts(categoryID,brandID,page,false);
    }

    /**Get products list asynchronously, and sets the view
     *
     */
    private void getProducts(int categoryID, int brandID, int page, final boolean isScrolled) {
        progress.setVisibility(View.VISIBLE);
        ProductsBAL.getPopularProducts(categoryID,brandID, page , new PopularProductsListener() {
            @Override
            public void onDataReceived(ArrayList<Data> data) {
                progress.setVisibility(View.GONE);

                if(isScrolled){
                    mPopularProductList.addAll(data);

                    if (isGrid) {
                        gridViewAdapter.notifyDataSetChanged();
                    } else {
                        listViewAdapter.notifyDataSetChanged();
                    }

                }
                if(!isScrolled){
                    mPopularProductList = data;
                    gridViewAdapter = new PopularProductAdapter(mPopularProductList);
                    listViewAdapter = new PopularProductListAdapter(mPopularProductList);
                    if (isGrid) {
                        recyclerView.setAdapter(gridViewAdapter);
                        recyclerView.addOnScrollListener(new EndlessScrollListener(gridLayoutManager));
                    } else {

                        recyclerView.setAdapter(listViewAdapter);
                        recyclerView.addOnScrollListener(new EndlessScrollListener(linearLayoutManager));

                    }
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

    /**This method toggles from grid view , to list view
     * & vice versa
     *
     */
    private void ToggleProductView(){

        if(isGrid){// if it is already grid, set List view
            linearLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.removeAllViews();
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.addOnScrollListener(new EndlessScrollListener(linearLayoutManager));
            recyclerView.setAdapter(listViewAdapter);

            isGrid = false;
        }
        else{// if it is list, set grid
            recyclerView.removeAllViews();
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(gridViewAdapter);
            isGrid = true;
        }


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_all_product,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.grid){
            ToggleProductView();
        }

        return true;
    }

    private class EndlessScrollListener extends InfiniteScroller {

        public EndlessScrollListener(LinearLayoutManager layoutHorizontal) {
            super(layoutHorizontal);
        }

        @Override
        public boolean onLoadMore(int page, int totalItemsCount) {
            getProducts(categoryID,brandID,page,true);
            return false;
        }
    }

    private class AllProductSortingListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

        }
    }

    private class AllProductFilterListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

        }
    }
}
