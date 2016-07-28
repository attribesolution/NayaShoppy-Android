package com.attribe.nayashoppy.app.network.interfaces;

import com.attribe.nayashoppy.app.model.Deals.Datum;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 28-Jul-16.
 */
public interface DealsListener {

    void onDealsFetched(ArrayList<Datum> deals);
}
