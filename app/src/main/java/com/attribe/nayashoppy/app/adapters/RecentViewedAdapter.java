package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.RecentViewedHolder;
import com.attribe.nayashoppy.app.model.dummy_model.Product;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.util.ViewedProduct;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 29-Jul-16.
 */
public class RecentViewedAdapter extends RecyclerView.Adapter<RecentViewedHolder>{

    private Context mContext;
    //private ArrayList<Product> mProductList;
    //private ArrayList<Datum> mProductList;
    private ArrayList<ViewedProduct> mProductList;

//    public RecentViewedAdapter(ArrayList<Product> dummyProducts) {
//        this.mProductList = dummyProducts;
//    }
    public RecentViewedAdapter(ArrayList<ViewedProduct> dummyProducts) {
        this.mProductList = dummyProducts;
    }

    @Override
    public RecentViewedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_arrival_item, null);
        RecentViewedHolder recycler = new RecentViewedHolder(layoutView);

        return recycler;
    }

    @Override
    public void onBindViewHolder(RecentViewedHolder holder, int position) {
       // Product product = mProductList.get(position);
        ViewedProduct product = mProductList.get(position);

        Picasso.with(mContext).load(product.getProductImageURL()).into(holder.productImage);
        holder.productName.setText(product.getProductName());
        holder.productPrice.setText(product.getProductPrice());
        holder.productVendor.setText(product.getProductVendor());

//        Picasso.with(mContext).load(product.getImages().get(0).getImage_path()).into(holder.productImage);
//        holder.productName.setText(product.getProduct_name());
//        holder.productPrice.setText(product.getPrice());
//        holder.productVendor.setText(product.getSuppliers().get(0).getStore_name());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();

    }
}
