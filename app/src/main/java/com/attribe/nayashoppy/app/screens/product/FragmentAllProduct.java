package com.attribe.nayashoppy.app.screens.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;

/**
 * Created by Sabih Ahmed on 10-Aug-16.
 */
public class FragmentAllProduct extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_all_product, container, false);

        init();
        return view;
    }

    private void init() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_all_products);

        setAllProductList();
    }

    private void setAllProductList() {


    }


}
