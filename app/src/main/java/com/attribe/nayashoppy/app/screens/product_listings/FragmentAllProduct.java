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
import com.attribe.nayashoppy.app.adapters.AllProductGridAdapter;
import com.attribe.nayashoppy.app.adapters.AllProductListAdapter;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;
import com.attribe.nayashoppy.app.network.interfaces.LatestProductsListener;
import com.attribe.nayashoppy.app.util.InfiniteScroller;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 10-Aug-16.
 */
public class FragmentAllProduct extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private int categoryID=0;
    private int brandID=0;
    private ArrayList<Datum> mDataset;
    private AllProductGridAdapter gridViewAdapter;
    private AllProductListAdapter listViewAdapter;
    private AVLoadingIndicatorView progress;
    private boolean isGrid = true;
    private LinearLayout sortingArea;
    private LinearLayout filteringArea;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_all_product, container, false);

        init();
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.menu_all_product,menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.share:

                break;

            case R.id.grid:

                ToggleProductView();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**Initializes view, get intent / bundle extras
     * and initializes instance variables
     *
     */
    private void init() {
        progress = (AVLoadingIndicatorView)view.findViewById(R.id.progress_wheel);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_all_products);
        gridLayoutManager = new GridLayoutManager(getActivity(),2);

        sortingArea = (LinearLayout) view.findViewById(R.id.sorting_parent);
        sortingArea.setOnClickListener(new AllProductSortingListener());

        filteringArea = (LinearLayout) view.findViewById(R.id.filtering_parent);
        filteringArea.setOnClickListener(new AllProductFilterListener());

        recyclerView.setLayoutManager(gridLayoutManager);

        try {

            categoryID = getArguments().getInt(NavigationUtils.KEY_CATEGORY_ID);
            brandID = getArguments().getInt(NavigationUtils.KEY_BRAND_ID);

        }catch (Exception exc){

        }

        setAllProductList();
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
            recyclerView.addOnScrollListener(new EndlessScroller(linearLayoutManager));
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

    /**Fetches list of products
     *
     */
    private void setAllProductList() {
        int page=1;
        getProducts(categoryID,brandID,page, false);

    }

    /** Get products list asynchronously, and sets the view
     *
     * @param categoryID
     * @param brandID
     * @param page
     * @param scrolled
     */
    private void getProducts(int categoryID, int brandID, int page, final boolean scrolled) {
        progress.setVisibility(View.VISIBLE);
        ProductsBAL.getNewProducts(categoryID, brandID,page, new LatestProductsListener() {

            @Override
            public void onDataReceived(ArrayList<Datum> data) {

                progress.setVisibility(View.GONE);
                if (scrolled) {
                    mDataset.addAll(data);
                    if (isGrid) {
                        gridViewAdapter.notifyDataSetChanged();
                    } else {
                        listViewAdapter.notifyDataSetChanged();
                    }


                }

                if (!scrolled) {
                    mDataset = data;
                    gridViewAdapter = new AllProductGridAdapter(mDataset);
                    listViewAdapter = new AllProductListAdapter(mDataset);
                    if (isGrid) {
                        recyclerView.setAdapter(gridViewAdapter);
                        recyclerView.addOnScrollListener(new EndlessScroller(gridLayoutManager));
                    } else {

                        recyclerView.setAdapter(listViewAdapter);
                        recyclerView.addOnScrollListener(new EndlessScroller(linearLayoutManager));

                    }

                }
    }

            @Override
            public void onDataIssue(String message) {
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(String message) {
                progress.setVisibility(View.GONE);
            }
        });
    }


    private class EndlessScroller extends InfiniteScroller {

        public EndlessScroller(LinearLayoutManager layoutHorizontal) {
            super(layoutHorizontal);
        }

        @Override
        public boolean onLoadMore(int page, int totalItemsCount) {

            getProducts(categoryID,brandID,page,true);
            return true;
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

            NavigationUtils.showFilterScreen(getActivity(),categoryID,brandID);
        }
    }
}
