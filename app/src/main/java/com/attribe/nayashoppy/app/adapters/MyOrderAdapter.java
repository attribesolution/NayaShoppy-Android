package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.MyOrderHolder;
import com.attribe.nayashoppy.app.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 28-Jul-16.
 */
public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderHolder> {

    private ArrayList<Product> productList;
    private Context mContext;
    public MyOrderAdapter(ArrayList<Product> productList) {

        this.productList = productList;
    }


    @Override
    public MyOrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View layout = LayoutInflater.from(mContext).inflate(R.layout.myorder_item,parent,false);

        MyOrderHolder holder = new MyOrderHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyOrderHolder holder, int position) {

        holder.productName.setText(productList.get(position).getProductName());
        Picasso.with(mContext).load(productList.get(position).getProductImageURL()).into(holder.productImage);


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
