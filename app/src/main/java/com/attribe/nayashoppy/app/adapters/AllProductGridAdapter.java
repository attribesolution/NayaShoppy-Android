package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.PopularProductHolder;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.util.Common;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 11-Aug-16.
 */
public class AllProductGridAdapter extends RecyclerView.Adapter<PopularProductHolder> {

    private final ArrayList<Datum> mDataset;
    private static Context mContext;
    private Boolean isGrid;
    public AllProductGridAdapter(ArrayList<Datum> data) {

        this.mDataset=data;

    }


    @Override
    public PopularProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();

        PopularProductHolder holder = null;

        View view = LayoutInflater.from(mContext).inflate(R.layout.popular_product_item, parent, false);
        holder = new PopularProductHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(PopularProductHolder holder, int position) {

        Datum product = mDataset.get(position);
        holder.productName.setText(product.getProduct_name());
        holder.productPrice.setText(product.getLowest_price()+" "+
                product.getDiscount());

        try {
            Common.setImage(mContext,product.getImages().get(0).getImage_path(),holder.productImage);
        }catch (Exception exc){

        }

        holder.shareIcon.setOnClickListener(new ShareClickListener(product));
        holder.parent.setOnClickListener(new ProductClickListener(product));



    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    private class ProductClickListener implements View.OnClickListener {
        private Datum mProduct;

        public ProductClickListener(Datum product) {
            this.mProduct = product;
        }

        @Override
        public void onClick(View view) {



            NavigationUtils.showProductDetailScreen(mContext,mProduct);
        }
    }

    public static class ShareClickListener implements View.OnClickListener {

        private Datum product;

        public ShareClickListener(Datum product) {

            this.product = product;
        }

        @Override
        public void onClick(View view) {

            Common.showShareChooser(mContext, product.getUrl());

        }
    }
}
