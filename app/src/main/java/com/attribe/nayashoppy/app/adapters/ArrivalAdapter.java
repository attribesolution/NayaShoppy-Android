package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.ArrivalHolder;
import com.attribe.nayashoppy.app.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 20-Jul-16.
 */
public class ArrivalAdapter extends RecyclerView.Adapter<ArrivalHolder>{

    private ArrayList<Product> mProductList;
    private Context mContext;

    public ArrivalAdapter(ArrayList<Product> productList) {

        this.mProductList = productList;
    }

    @Override
    public ArrivalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_arrival_item, null);

        ArrivalHolder recycler = new ArrivalHolder(layoutView);



        return recycler;
    }

    @Override
    public void onBindViewHolder(ArrivalHolder holder, int position) {

        Product product = mProductList.get(position);
        Picasso.with(mContext).load(product.getProductImageURL()).into(holder.productImage);
        holder.productName.setText(product.getProductName());
        holder.productPrice.setText(product.getProductPrice());
        holder.productVendor.setText(product.getProductVendor());

    }


    @Override
    public int getItemCount() {

        return mProductList.size();
    }
}
