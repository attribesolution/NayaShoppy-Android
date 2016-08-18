package com.attribe.nayashoppy.app.network.interfaces;

import com.attribe.nayashoppy.app.model.popular_products.Data;

/**
 * Created by Sabih Ahmed on 17-Aug-16.
 */
public interface ProductListener extends GeneralNetworkListener{

    void onProductReceived(Data data);

}
