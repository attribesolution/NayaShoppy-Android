package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.AllProductListHolder;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.util.Common;

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
