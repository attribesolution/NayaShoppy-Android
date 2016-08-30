package com.attribe.nayashoppy.app.network.interfaces;

import com.attribe.nayashoppy.app.model.product_detail.ProductReview;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 29-Aug-16.
 */
public interface ProductReviewListener extends GeneralNetworkListener{

    void onDataReceived(ArrayList<ProductReview.Datum> data);
    void onDataEmpty();
}
