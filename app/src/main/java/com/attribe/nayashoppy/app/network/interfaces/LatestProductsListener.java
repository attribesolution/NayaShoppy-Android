package com.attribe.nayashoppy.app.network.interfaces;

import com.attribe.nayashoppy.app.model.product_category.Datum;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 08-Aug-16.
 */
public interface LatestProductsListener extends GeneralNetworkListener{

    void onDataReceived(ArrayList<Datum> data);


}
