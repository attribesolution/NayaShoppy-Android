package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.AllProductListHolder;
import com.attribe.nayashoppy.app.adapters.viewholders.PopularProductListHolder;
import com.attribe.nayashoppy.app.model.popular_products.Data;
import com.attribe.nayashoppy.app.util.Common;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 16-Aug-16.
 */
public class PopularProductListAdapter extends RecyclerView.Adapter<PopularProductListHolder> {


    private final ArrayList<Data> mDataset;
    private Context mContext;

    public PopularProductListAdapter(ArrayList<Data> mPopularProductList) {

        mDataset = mPopularProductList;

    }



    @Override
    public PopularProductListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();

        View view = LayoutInflater.from(mContext).inflate(R.layout.popular_product_list_item, parent, false);

        PopularProductListHolder holder = new PopularProductListHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(PopularProductListHolder holder, int position) {
        holder.productName.setText(mDataset.get(position).getProduct_name());
        holder.productPrice.setText(mDataset.get(position).getLowest_price()+" "+
                mDataset.get(position).getDiscount());

        try {
            Common.setImage(mContext,mDataset.get(position).getImages().get(0).getImage_path(),holder.productImage);
        }catch (Exception exc){

        }

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
