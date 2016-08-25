package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.SimilarProductHolder;
import com.attribe.nayashoppy.app.model.product_detail.Datum;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 25-Aug-16.
 */
public class SimilarProductAdapter extends RecyclerView.Adapter<SimilarProductHolder>{

    private final ArrayList<Datum> mDataset;
    private Context mContext;

    public SimilarProductAdapter(ArrayList<Datum> similarProductList) {
        this.mDataset= similarProductList;
    }


    @Override
    public SimilarProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View row = LayoutInflater.from(mContext).inflate(R.layout.similar_prod_item, parent, false);

        SimilarProductHolder holder = new SimilarProductHolder(row);

        return holder;
    }

    @Override
    public void onBindViewHolder(SimilarProductHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
