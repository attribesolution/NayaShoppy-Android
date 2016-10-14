package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.AbstractClasses.WishIconListner;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.AllProductListHolder;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.util.Common;
import com.attribe.nayashoppy.app.util.WishProduct;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 12-Aug-16.
 */
public class AllProductListAdapter extends RecyclerView.Adapter<AllProductListHolder>{

    private final ArrayList<Datum> mDataset;
    private Context mContext;

    public AllProductListAdapter(ArrayList<Datum> data) {
        this.mDataset= data;
    }

    @Override
    public AllProductListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.all_product_list_item, parent, false);

        AllProductListHolder holder = new AllProductListHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AllProductListHolder holder, int position) {

        Datum product = mDataset.get(position);
        holder.productName.setText(product.getProduct_name());
        holder.productPrice.setText(product.getLowest_price()+" "+
                product.getDiscount());

        try {
            Common.setImage(mContext,product.getImages().get(0).getImage_path(),holder.productImage);
        }catch (Exception exc){

        }

        holder.shareIcon.setOnClickListener(new AllProductGridAdapter.ShareClickListener(product));
       // holder.wishIcon.setOnClickListener(new AllProductGridAdapter.WishIconListner(product));
        WishProduct wishProduct=new WishProduct(product.getProduct_id(),product.getProduct_name()
                ,product.getLowest_price(),product.getImages().get(0).getImage_path(),
                product.getSuppliers().get(0).getStore_name());
        holder.wishIcon.setOnClickListener(new WishIconListner(wishProduct,mContext));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
