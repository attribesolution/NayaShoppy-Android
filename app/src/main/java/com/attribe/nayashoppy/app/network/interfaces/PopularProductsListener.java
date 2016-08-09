package com.attribe.nayashoppy.app.network.interfaces;

import com.attribe.nayashoppy.app.model.popular_products.Data;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 09-Aug-16.
 */
public interface PopularProductsListener extends GeneralNetworkListener{

    void onDataReceived(ArrayList<Data> data);
}
