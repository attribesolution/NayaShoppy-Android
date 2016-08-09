package com.attribe.nayashoppy.app.network;

import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.model.Deals.Deals;
import com.attribe.nayashoppy.app.model.Menu;
import com.attribe.nayashoppy.app.model.arrival.NewArrival;
import com.attribe.nayashoppy.app.model.popular_products.PopularProducts;
import com.attribe.nayashoppy.app.model.product_category.ProductCategory;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Sabih Ahmed on 06-Jun-16.
 */
public interface ServicesInterface {

    @GET(EndPoints.STAGE_GET_MENU)
    Call<Menu> getMenu();


    @GET(EndPoints.STAGE_GET_DEALS)
    Call<Deals> getDeals();

    @GET(EndPoints.STAGE_GET_ARRIVALS)
    Call<NewArrival> getArrivals();

    @GET("http://api.nayashoppy.com/v1/catalog/")
    Call<ProductCategory> getAllProducts(@QueryMap Map<String,Integer> options);

    @GET("http://api.nayashoppy.com/v1/catalog/popularproducts")
    Call<PopularProducts> getPopularProducts(@QueryMap Map<String,Integer> options);
}
