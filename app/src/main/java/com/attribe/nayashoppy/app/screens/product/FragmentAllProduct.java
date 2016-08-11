package com.attribe.nayashoppy.app.screens.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.AllProductAdapter;
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
    private GridLayoutManager layoutManager;
    private int categoryID=0;
    private int brandID=0;
    private ArrayList<Datum> mDataset;
    private AllProductAdapter adapter;
    private AVLoadingIndicatorView progress;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_all_product, container, false);

        init();
        return view;
    }

    private void init() {
        progress = (AVLoadingIndicatorView)view.findViewById(R.id.progress_wheel);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_all_products);
        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        try {

            categoryID = getArguments().getInt(NavigationUtils.KEY_CATEGORY_ID);
            brandID = getArguments().getInt(NavigationUtils.KEY_BRAND_ID);

        }catch (Exception exc){

        }

        setAllProductList();
    }

    private void setAllProductList() {
        int page=1;
        getProducts(categoryID,brandID,page, false);



    }

    private void getProducts(int categoryID, int brandID, int page, final boolean scrolled) {
//        progress.setVisibility(View.VISIBLE);
        ProductsBAL.getNewProducts(categoryID, brandID,page, new LatestProductsListener() {


            @Override
            public void onDataReceived(ArrayList<Datum> data) {

//                progress.setVisibility(View.GONE);
                if(scrolled){
                    mDataset.addAll(data);
                    adapter.notifyDataSetChanged();
                }

                if(!scrolled){
                    mDataset = data;
                    adapter = new AllProductAdapter(mDataset);
                    recyclerView.setAdapter(adapter);
                    recyclerView.addOnScrollListener(new EndlessScroller(layoutManager));
                }




            }

            @Override
            public void onDataIssue(String message) {
//                progress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(String message) {
//                progress.setVisibility(View.GONE);
            }
        });
    }


    private class EndlessScroller extends InfiniteScroller {

        public EndlessScroller(LinearLayoutManager layoutHorizontal) {
            super(layoutHorizontal);
        }

        @Override
        public boolean onLoadMore(int page, int totalItemsCount) {


            mDataset.add(new ProgressFooter());
            getProducts(categoryID,brandID,page,true);
            return true;
        }
    }
}
