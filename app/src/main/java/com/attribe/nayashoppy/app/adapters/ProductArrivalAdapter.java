package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.NewProductArrivalHolder;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.util.Common;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 04-Aug-16.
 */
public class ProductArrivalAdapter extends RecyclerView.Adapter<NewProductArrivalHolder> {

    private ArrayList<Datum> mDataset;
    private Context mContext;
    public ProductArrivalAdapter(ArrayList<Datum> dataset) {

        this.mDataset = dataset;
    }

    @Override
    public NewProductArrivalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View layout = LayoutInflater.from(mContext).inflate(R.layout.product_new_arrival_item, parent, false);

        NewProductArrivalHolder holder = new NewProductArrivalHolder(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(NewProductArrivalHolder holder, int position) {

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
