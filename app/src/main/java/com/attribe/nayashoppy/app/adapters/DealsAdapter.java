package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.DealsHolder;
import com.attribe.nayashoppy.app.model.Deals.Child;
import com.attribe.nayashoppy.app.model.Deals.Datum;
import com.attribe.nayashoppy.app.util.Common;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 28-Jul-16.
 */
public class DealsAdapter extends RecyclerView.Adapter<DealsHolder> {

    private final Context mContext;
    private final ArrayList<Child> mDealsList;
    private final Datum deals;

    public DealsAdapter(Context context, Datum dealsList) {

        this.mContext = context;
        this.deals = dealsList;
        this.mDealsList = deals.getChildren();
    }

    @Override
    public DealsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(mContext).inflate(R.layout.deal_item, parent, false);

        DealsHolder holder = new DealsHolder(layout);


        return holder;
    }

    @Override
    public void onBindViewHolder(DealsHolder holder, int position) {

        Child product = mDealsList.get(position);

        holder.productName.setText(product.getTitle());
        holder.productPrice.setText(product.getOffer_price()+" "+
                product.getPrice());

        try {
            Common.setImage(mContext,product.getImage_path(),holder.productImage);

        }catch (Exception exc){

        }

        holder.parent.setOnClickListener(new ProductTapListener(product));
    }

    @Override
    public int getItemCount() {
        return mDealsList.size();
    }

    private class ProductTapListener implements View.OnClickListener {

        private Child mProduct;

        public ProductTapListener(Child product) {
            this.mProduct = product;
        }

        @Override
        public void onClick(View view) {
            NavigationUtils.showProductDetailScreen(mContext,mProduct);
        }
    }
}
