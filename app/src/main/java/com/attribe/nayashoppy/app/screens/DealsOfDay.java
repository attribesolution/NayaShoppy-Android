package com.attribe.nayashoppy.app.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.DealsAdapter;
import com.attribe.nayashoppy.app.model.Deals.Datum;
import com.attribe.nayashoppy.app.network.bals.DealsBAL;
import com.attribe.nayashoppy.app.network.interfaces.DealsListener;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 18-Jul-16.
 */
public class DealsOfDay extends Fragment {

    private View view;
    public Datum dealsList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.deals_of_day,container,false);

        init();

        return view;
    }

    private void init() {

        DealsBAL.getDeals(new DealsListener() {


            @Override
            public void onDealsFetched(ArrayList<Datum> deals) {

                try {
                    dealsList = deals.get(1);
                    setList();
                }catch (Exception iobe){
                    //TODO: handle exception
                }


            }
        });



    }

    private void setList() {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_deals);
        GridLayoutManager grid = new GridLayoutManager(getActivity(),2);

        recyclerView.setAdapter(new DealsAdapter(getActivity(),dealsList));
        recyclerView.setLayoutManager(grid);

    }
}
