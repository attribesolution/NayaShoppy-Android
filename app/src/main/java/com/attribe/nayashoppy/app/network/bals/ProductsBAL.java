package com.attribe.nayashoppy.app.network.bals;

import com.attribe.nayashoppy.app.model.popular_products.PopularProducts;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.model.product_category.ProductCategory;
import com.attribe.nayashoppy.app.network.RestClient;
import com.attribe.nayashoppy.app.network.interfaces.LatestProductsListener;
import com.attribe.nayashoppy.app.network.interfaces.PopularProductsListener;
import com.google.gson.JsonSyntaxException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sabih Ahmed on 02-Aug-16.
 */
public class ProductsBAL {


    public static void getNewProducts(int categoryID, int brandID, final LatestProductsListener listener  ) {

        Map<String,Integer> options= new HashMap<String, Integer>();
        options.put("category_id",categoryID);
        options.put("brand_id",brandID);

        Call<ProductCategory> allProducts = RestClient.getAdapter().getAllProducts(options);


        allProducts.enqueue(new Callback<ProductCategory>() {
            @Override
            public void onResponse(Call<ProductCategory> call, Response<ProductCategory> response) {

                if(response.isSuccessful()){
                    ArrayList<Datum> data = response.body().getData();
                    listener.onDataReceived(data);
                }

                else{

                    listener.onDataIssue(response.body().getMeta().getMessage());
                }

            }

            @Override
            public void onFailure(Call<ProductCategory> call, Throwable t) {

                listener.onFailure(t.getMessage());

            }
        });
    }

    public static void getPopularProducts(int categoryID, int brandID, int page,
                                          final PopularProductsListener listener) {

        Map<String,Integer> params= new HashMap<String, Integer>();
        params.put("category_id",categoryID);
        params.put("brand_id",brandID);
        params.put("page",page);

        Call<PopularProducts> popularProducts = RestClient.getAdapter().getPopularProducts(params);

        popularProducts.enqueue(new Callback<PopularProducts>() {
            @Override
            public void onResponse(Call<PopularProducts> call, Response<PopularProducts> response) {

                if(response.isSuccessful()){

                    if(response.body()!=null){

                        listener.onDataReceived(response.body().getData());
                    }


                }

                else{

                    listener.onDataIssue(response.message());
                }
            }

            @Override
            public void onFailure(Call<PopularProducts> call, Throwable t) {

                listener.onFailure(t.getMessage());
            }
        });
    }
}
