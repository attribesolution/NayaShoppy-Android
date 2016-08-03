package com.attribe.nayashoppy.app.network.bals;

import com.attribe.nayashoppy.app.model.product_category.ProductCategory;
import com.attribe.nayashoppy.app.network.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sabih Ahmed on 02-Aug-16.
 */
public class ProductsBAL {


    public static void getProducts(int categoryID, int brandID) {

        Map<String,Integer> options= new HashMap<String, Integer>();
        options.put("category_id",categoryID);
        options.put("brand_id",brandID);

        Call<ProductCategory> allProducts = RestClient.getAdapter().getAllProducts(options);

        allProducts.enqueue(new Callback<ProductCategory>() {
            @Override
            public void onResponse(Call<ProductCategory> call, Response<ProductCategory> response) {

            }

            @Override
            public void onFailure(Call<ProductCategory> call, Throwable t) {

                //TODO: handle failure
            }
        });
    }
}
