package com.attribe.nayashoppy.app.screens.product_detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.ImagePagerAdapter;
import com.attribe.nayashoppy.app.adapters.ProductReviewAdapter;
import com.attribe.nayashoppy.app.adapters.SimilarProductAdapter;
import com.attribe.nayashoppy.app.adapters.SupplierAdapter;
import com.attribe.nayashoppy.app.custom_views.SnappyLinearLayoutManager;
import com.attribe.nayashoppy.app.model.popular_products.Data;
import com.attribe.nayashoppy.app.model.product_category.Image;
import com.attribe.nayashoppy.app.model.product_category.Supplier;
import com.attribe.nayashoppy.app.model.product_detail.Datum;
import com.attribe.nayashoppy.app.model.product_detail.ProductReview;
import com.attribe.nayashoppy.app.model.product_detail.SimilarProduct;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;
import com.attribe.nayashoppy.app.network.interfaces.ProductListener;
import com.attribe.nayashoppy.app.network.interfaces.ProductReviewListener;
import com.attribe.nayashoppy.app.network.interfaces.SimilarProductListener;
import com.attribe.nayashoppy.app.util.DevicePreferences;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import io.techery.properratingbar.ProperRatingBar;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 16-Aug-16.
 */
public class FragmentPrices extends Fragment implements SimilarProductAdapter.ISimilarProductClickListener{

    private View view;
    private static String DEFAULT_SLUG="apple-iphone-4s-black-8-gb";
    private String slug;
    private RecyclerView recycler_supplier;
    private ViewPager imagesPager;
    private HtmlTextView productPrice;
    private TextView productName;
    private RecyclerView recycler_similar_prod;
    private Button fullSpecs;
    private FullSpecsListener fullSpecsListener;
    private ProperRatingBar ratingBar;
    private RecyclerView recycler_prod_review;
    private WebView specs_view;
    private ArrayList<Data.FeaturesList.FeatureValue> processedList;
    private FrameLayout no_review_frame;
    private NestedScrollView parentScroller;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState !=null){

            //extract from outstate bundle
        }
        else{
            getIntentData();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product_prices, container, false);
        bindViews();
        initData();
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            fullSpecsListener = (ScreenProductDetail)context;
        }catch (IllegalArgumentException exc){

        }

    }

    private void getIntentData() {
        Bundle productBundle = getArguments();
        //slug = DEFAULT_SLUG;

        try {
            productBundle.getInt(NavigationUtils.KEY_PRODUCT_ID,0);
            slug = productBundle.getString(NavigationUtils.KEY_PRODUCT_SLUG, "");
        }catch (Exception exc){

            //catch exception
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }



    private void bindViews() {
        parentScroller = (NestedScrollView) view.findViewById(R.id.parent_scroller);
        recycler_supplier = (RecyclerView) view.findViewById(R.id.recycler_supplier);
        recycler_similar_prod = (RecyclerView)view.findViewById(R.id.recycler_similar_prods);
        recycler_prod_review = (RecyclerView)view.findViewById(R.id.recycler_reviews);
        specs_view = (WebView) view.findViewById(R.id.specs_view);
        imagesPager = (ViewPager) view.findViewById(R.id.product_image_pager);
        productPrice = (HtmlTextView) view.findViewById(R.id.product_price);
        productName= (TextView) view.findViewById(R.id.product_name);
        fullSpecs = (Button)view.findViewById(R.id.button_full_specs);
        fullSpecs.setOnClickListener(new FullSpecsButtonListener());
        ratingBar = (ProperRatingBar) view.findViewById(R.id.prod_rating_bar);
        no_review_frame = (FrameLayout) view.findViewById(R.id.no_review_frame);
    }

    private void initData() {
        ProductsBAL.getProductDetail(slug, new ProductListener() {
            @Override
            public void onProductReceived(Data data) {

                setProductName(data.getProduct_name());
                setProductImages(data.getImages());
                setProductBestPrice(data.getLowest_price(),data.getOriginal_price());
                setSupplierList(data.getSuppliers());
                setProductKeySpecs(data.getFeaturesList());
                setProductRating(data.getRating());
                getProductReviews(data.getProduct_id());
                getSimilarProducts(data.getLowest_price(),data.getCategories_category_id());

            }

            @Override
            public void onDataIssue(String message) {

            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    private void setProductKeySpecs(ArrayList<Data.FeaturesList> featuresList) {

        processedList = new ArrayList<Data.FeaturesList.FeatureValue>();
        String htmlstart = "<html>\n" + "<body>\n" + "<table >";

        String htmltableRow = "";

        for(Data.FeaturesList featureGroup: featuresList){

            for(Data.FeaturesList.FeatureValue featureValue: featureGroup.getFeatureValues()){

                if(featureValue.isFilter){
                    processedList.add(featureValue);
                }

            }

        }

        for(Data.FeaturesList.FeatureValue featureIterator:processedList){
            htmltableRow += "<tr border=\"1\">\n" +
                    "    <td>"+featureIterator.getFeatureName()+"</td>\n" +
                    "    <td>"+featureIterator.getFeatureValue()+"</td>\n" +
                    "  </tr>";
        }

        String endHtml="</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        String finalHtml = htmlstart +htmltableRow +endHtml;

        specs_view.loadData(finalHtml,"text/html",null);



    }

    private void setProductName(String product_name) {
        productName.setText(product_name);
    }

    private void setProductImages(ArrayList<Image> images) {
        ArrayList<String> imageList = new ArrayList<String>();
        for(Image image:images){

            imageList.add(image.getImage_path());

        }

        try {
            imagesPager.setAdapter(new ImagePagerAdapter(getActivity(),imageList));
        }catch (Exception exc){

        }


    }

    private void setProductBestPrice(String lowestPrice, String originalPrice) {
        String currency = DevicePreferences.getInstance().getCurrency();

        String html="<html>\n" +
                "BEST PRICE<br>\n" +
                "<font color=\"#CD3132\" <big>"+
                currency+lowestPrice+
                "</font> <strike color=\"red\" >" +currency+originalPrice+ "</strike> " +"<br>"+
                "<font color=\"#39B12C\"> (80% OFF)</font> \n" +
                "</html>";

        productPrice.setHtml(html);
    }



    private void setSupplierList(ArrayList<Supplier> data) {
        recycler_supplier.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_supplier.setNestedScrollingEnabled(true);
        recycler_supplier.setAdapter(new SupplierAdapter(data));

    }

    private void setProductRating(String rating) {
        Double rate_in_double = 0.0;
        int rate_in_int= 0;

        //rating comes in string from server,
        //have to check if it contains decimal values
        //if it does, have to round off to nearest integer

        if(!rating.isEmpty()){
            try {
                rate_in_int = Integer.parseInt(rating);
                ratingBar.setRating(rate_in_int);
            }
            catch (NumberFormatException nfe){

                rate_in_double = Double.parseDouble(rating);
                rate_in_int = (int) Math.round(rate_in_double);
                ratingBar.setRating(rate_in_int);
            }
        }


    }

    private void getProductReviews(int product_id) {
        ProductsBAL.getProductReviews(product_id, new ProductReviewListener() {
            @Override
            public void onDataReceived(ArrayList<ProductReview.Datum> data) {

                if(!data.isEmpty()){

                    //hide no review frame
                    //show review list

                    no_review_frame.setVisibility(View.GONE);
                    recycler_prod_review.setVisibility(View.VISIBLE);

                    ProductReviewAdapter adapter = new ProductReviewAdapter(data);
                    SnappyLinearLayoutManager reviewLayoutManager = new SnappyLinearLayoutManager(getActivity(),
                            SnappyLinearLayoutManager.HORIZONTAL,false);

                    recycler_prod_review.setLayoutManager(reviewLayoutManager);

                    recycler_prod_review.setAdapter(adapter);

                    recycler_prod_review.setOnDragListener(new View.OnDragListener() {
                        @Override
                        public boolean onDrag(View view, DragEvent dragEvent) {
                            return false;
                        }
                    });
                }

            }

            @Override
            public void onDataEmpty() {

                //TODO:show empty review view
            }

            @Override
            public void onDataIssue(String message) {

            }

            @Override
            public void onFailure(String message) {

            }
        });

    }

    private void getSimilarProducts(String lowest_price, int categories_category_id) {

        ProductsBAL.getSimilarProducts(lowest_price,categories_category_id, new SimilarProductListener() {
            @Override
            public void onDataReceived(SimilarProduct body) {

                SimilarProductAdapter adapter = new SimilarProductAdapter(body.getData());
                adapter.setSimilarProductListener(FragmentPrices.this);
                recycler_similar_prod.setLayoutManager(
                        new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

                recycler_similar_prod.setAdapter(adapter);

            }

            @Override
            public void onDataIssue(String message) {

            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    @Override
    public void OnSimilarProductClick(Datum product) {


        slug = product.getSlug();
        initData();
        //parentScroller.setSmoothScrollingEnabled(true);
        parentScroller.smoothScrollTo(0,0);
    }

    public interface FullSpecsListener {

        void setOnFullSpecsClick();
    }



    private class FullSpecsButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            fullSpecsListener.setOnFullSpecsClick();
        }
    }
}
