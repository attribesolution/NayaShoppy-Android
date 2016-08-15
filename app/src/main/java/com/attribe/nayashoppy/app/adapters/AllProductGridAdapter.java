package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.AllProductHolder;
import com.attribe.nayashoppy.app.adapters.viewholders.FooterProgress;
import com.attribe.nayashoppy.app.adapters.viewholders.PopularProductHolder;
import com.attribe.nayashoppy.app.model.product_category.Datum;
import com.attribe.nayashoppy.app.screens.product.ProgressFooter;
import com.attribe.nayashoppy.app.util.Common;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 11-Aug-16.
 */
public class AllProductGridAdapter extends RecyclerView.Adapter<PopularProductHolder> {

    private final ArrayList<Datum> mDataset;
    private Context mContext;
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
