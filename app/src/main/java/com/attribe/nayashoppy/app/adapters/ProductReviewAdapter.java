package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.ProductReviewHolder;
import com.attribe.nayashoppy.app.model.product_detail.ProductReview;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 29-Aug-16.
 */
public class ProductReviewAdapter extends RecyclerView.Adapter<ProductReviewHolder>{

    private ArrayList<ProductReview.Datum> mDataset;
    private Context mContext;

    public ProductReviewAdapter(ArrayList<ProductReview.Datum> data) {
        this.mDataset= data;

    }

    @Override
    public ProductReviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext() ;

        View row = LayoutInflater.from(mContext).inflate(R.layout.prod_review_item, parent, false);

        ProductReviewHolder holder = new ProductReviewHolder(row);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProductReviewHolder holder, int position) {

        if(!mDataset.get(position).getUser().isEmpty()){
            holder.userName.setText(mDataset.get(position).getUser().get(0).getUsername());
        }

        holder.reviewDate.setText(mDataset.get(position).getCreated());
        holder.review.setText(mDataset.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
