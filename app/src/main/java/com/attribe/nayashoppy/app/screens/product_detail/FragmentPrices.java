package com.attribe.nayashoppy.app.screens.product_detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.HomeSliderAdapter;
import com.attribe.nayashoppy.app.adapters.SupplierAdapter;
import com.attribe.nayashoppy.app.model.popular_products.Data;
import com.attribe.nayashoppy.app.model.product_category.Image;
import com.attribe.nayashoppy.app.model.product_category.Supplier;
import com.attribe.nayashoppy.app.network.bals.ProductsBAL;
import com.attribe.nayashoppy.app.network.interfaces.ProductListener;
import com.attribe.nayashoppy.app.util.DevicePreferences;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 16-Aug-16.
 */
public class FragmentPrices extends Fragment {

    private View view;
    private static String DEFAULT_SLUG="apple-iphone-4s-black-8-gb";
    private String slug;
    private RecyclerView recycler_supplier;
    private ViewPager imagesPager;
    private HtmlTextView productPrice;
    private TextView productName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product_prices, container, false);

        init();
        return view;


    }

    private void init() {
        recycler_supplier = (RecyclerView) view.findViewById(R.id.recycler_supplier);
        imagesPager = (ViewPager) view.findViewById(R.id.product_image_pager);
        productPrice = (HtmlTextView) view.findViewById(R.id.product_price);
        productName= (TextView) view.findViewById(R.id.product_name);
        Bundle productBundle = getArguments();

        productBundle.getInt(NavigationUtils.KEY_PRODUCT_ID,0);
        slug = productBundle.getString(NavigationUtils.KEY_PRODUCT_SLUG, "");

        //slug = DEFAULT_SLUG;

        ProductsBAL.getProductDetail(slug, new ProductListener() {
            @Override
            public void onProductReceived(Data data) {

                setProductName(data.getProduct_name());
                setProductImages(data.getImages());
                setProductBestPrice(data.getLowest_price(),data.getOriginal_price());
                setSupplierList(data.getSuppliers());

            }

            @Override
            public void onDataIssue(String message) {

            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    private void setProductName(String product_name) {
        productName.setText(product_name);
    }

    private void setProductBestPrice(String lowestPrice, String originalPrice) {
        String currency = DevicePreferences.getInstance().getCurrency();

        String html="<html>\n" +
                "BEST PRICE<br>\n" +
                "<font color=\"#CD3132\" <big>"+
                currency+lowestPrice+
                "</font> <strike color=\"red\" >" +currency+originalPrice+ "</strike> <font color=\"#39B12C\"> (80% OFF)</font> \n" +
                "</html>";

        productPrice.setHtml(html);
    }

    private void setProductImages(ArrayList<Image> images) {
        ArrayList<String> imageList = new ArrayList<String>();
        for(Image image:images){

            imageList.add(image.getImage_path());

        }

        imagesPager.setAdapter(new HomeSliderAdapter(getActivity(),imageList));

    }

    private void setSupplierList(ArrayList<Supplier> data) {
        recycler_supplier.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_supplier.setAdapter(new SupplierAdapter(data));

    }
}
