package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.AbstractClasses.WishIconListner;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.PopularProductHolder;
import com.attribe.nayashoppy.app.model.popular_products.Data;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.util.*;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 09-Aug-16.
 */
public class PopularProductAdapter extends RecyclerView.Adapter<PopularProductHolder> {

    private ArrayList<Data> mDataset;
    private static Context mContext;

    public PopularProductAdapter(ArrayList<Data> data) {

        this.mDataset = data;
    }

    @Override
    public PopularProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(mContext).inflate(R.layout.popular_product_item, parent, false);
        PopularProductHolder holder = new PopularProductHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(PopularProductHolder holder, int position) {

        Data product = mDataset.get(position);
        holder.productName.setText(product.getProduct_name());
        holder.productPrice.setText(product.getLowest_price()+" "+
                product.getDiscount());

        try {
            Common.setImage(mContext,product.getImages().get(0).getImage_path(),holder.productImage);
        }catch (Exception exc){

        }

        holder.shareIcon.setOnClickListener(new ShareClickListener(product));
        holder.parent.setOnClickListener(new PopularProductClickListner(product));
        //holder.wishIcon.setOnClickListener(new AllProductGridAdapter.WishIconListner(product));
        WishProduct wishProduct=new WishProduct(product.getProduct_id(),
                     product.getProduct_name(),product.getLowest_price(),
                     product.getSuppliers().get(0).getStore_name(), "");

        try {
            wishProduct.setProductImageURL(product.getImages().get(0).getImage_path());
        }
        catch (IndexOutOfBoundsException e) {

        }

        holder.wishIcon.setOnClickListener(new WishIconListner(wishProduct,mContext));

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ShareClickListener implements View.OnClickListener {
        private Data product;

        public ShareClickListener(Data product) {
            this.product = product;
        }

        @Override
        public void onClick(View view) {

            Common.showShareChooser(mContext,product.getUrl());
        }
    }

    private class PopularProductClickListner implements View.OnClickListener {

        private Data mProduct;

        public PopularProductClickListner(Data product) {
            this.mProduct = product;
        }

        @Override
        public void onClick(View v) {

            NavigationUtils.showProductDetailScreen(mContext,mProduct);
            ViewedProduct viewedProduct=new ViewedProduct(mProduct.getProduct_name(),mProduct.getLowest_price()
                    ,mProduct.getSuppliers().get(0).getStore_name(),mProduct.getImages().get(0).getImage_path());
            RecentViewed.getIntstance().addrecentviewedItem(viewedProduct);
            notifyDataSetChanged();
        }
    }
}
