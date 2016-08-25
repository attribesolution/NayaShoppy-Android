package com.attribe.nayashoppy.app.network.interfaces;

import com.attribe.nayashoppy.app.model.product_detail.SimilarProduct;

/**
 * Created by Sabih Ahmed on 25-Aug-16.
 */
public interface SimilarProductListener extends GeneralNetworkListener{

    void onDataReceived(SimilarProduct body);

}
