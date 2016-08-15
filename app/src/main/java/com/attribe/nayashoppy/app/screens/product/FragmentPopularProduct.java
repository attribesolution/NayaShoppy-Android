package com.attribe.nayashoppy.app.screens.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Sabih Ahmed on 10-Aug-16.
 */
public class FragmentPopularProduct extends ProductListBaseFragment {


    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_popular_product, container, false);

        super.init(view);


        return view;
    }



    @Override
    void onDataFetched() {

    }

    @Override
    void onViewInitialized(int categoryID, int brandID, AVLoadingIndicatorView progress, RecyclerView recyclerView, GridLayoutManager gridLayoutManager) {

    }
}
