package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.WishListHolder;
import com.attribe.nayashoppy.app.util.DummyData;
import com.squareup.picasso.Picasso;
import com.attribe.nayashoppy.app.model.dummy_model.Product;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 27-Jul-16.
 */
public class WishListAdapter extends RecyclerView.Adapter<WishListHolder> {

    private Context mContext;
    private ArrayList<Product> wishList;

    public WishListAdapter(Context mContext) {
        wishList = DummyData.getDummyProducts();
        this.mContext = mContext;
    }

    @Override
    public WishListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.whish_list_item,parent,false);

        WishListHolder whishListHolder =  new WishListHolder(layout);
        return whishListHolder;
    }

    @Override
    public void onBindViewHolder(WishListHolder holder, int position) {

        holder.productName.setText(wishList.get(position).getProductName());
        holder.productPrice.setText(wishList.get(position).getProductPrice());
        Picasso.with(mContext).load(wishList.get(position).getProductImageURL()).into(holder.image);
        holder.productVendor.setText(wishList.get(position).getProductVendor());
    }


    @Override
    public int getItemCount() {
        return wishList.size();
    }
}
