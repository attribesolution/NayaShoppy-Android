package com.attribe.nayashoppy.app.network;

import com.attribe.nayashoppy.app.model.Deals.Deals;
import com.attribe.nayashoppy.app.model.Menu;
import com.attribe.nayashoppy.app.model.Product;
import com.attribe.nayashoppy.app.model.Slider.Slider;
import com.attribe.nayashoppy.app.model.arrival.NewArrival;
import com.attribe.nayashoppy.app.model.popular_products.PopularProducts;
import com.attribe.nayashoppy.app.model.product_category.CategoryFilter;
import com.attribe.nayashoppy.app.model.product_category.ProductCategory;
import com.attribe.nayashoppy.app.model.product_category.ProductSearch;
import com.attribe.nayashoppy.app.model.product_detail.ProductReview;
import com.attribe.nayashoppy.app.model.product_detail.SimilarProduct;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;
import java.util.logging.Filter;

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

    @GET("http://nsapi.nayashoppy.com/v1/catalog/")
    Call<ProductCategory> getAllProducts(@QueryMap Map<String,Integer> options);

    @GET("http://nsapi.nayashoppy.com/v1/catalog/popularproducts")
    Call<PopularProducts> getPopularProducts(@QueryMap Map<String,Integer> options);

    @GET(EndPoints.STAGE_PRODUCT_DETAIL)
    Call<Product> getProductDetail(@QueryMap Map<String, String> params);

    @GET(EndPoints.STAGE_SIMILAR_PRODUCTS)
    Call<SimilarProduct> getSimilarProducts(@QueryMap Map<String, String> params);

    @GET(EndPoints.STAGE_PRODUCT_REVIEWS)
    Call<ProductReview> getProductReviews(@Query("product_id") int product_id);

    @GET(EndPoints.STAGE_SLIDER)
    Call<Slider> getSlider();

    @GET("http://nsapi.nayashoppy.com/v1/search/products?")
    Call<CategoryFilter> getFilters(@Query("category_id[]") int category_id);

    @GET("http://nsapi.nayashoppy.com/v1/search/products?")
    Call<ProductSearch> getSearchedProduct(@Query("title") String product_title);
}
