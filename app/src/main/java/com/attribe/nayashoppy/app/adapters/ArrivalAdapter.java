package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.ArrivalHolder;
import com.attribe.nayashoppy.app.model.arrival.Datum;
import com.attribe.nayashoppy.app.util.Common;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 20-Jul-16.
 */
public class ArrivalAdapter extends RecyclerView.Adapter<ArrivalHolder>{

    private ArrayList<Datum> mProductList;
    private Context mContext;


    public ArrivalAdapter(ArrayList<Datum> productList) {

        this.mProductList = productList;
    }

    @Override
    public ArrivalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_arrival_item, null);

        ArrivalHolder recycler = new ArrivalHolder(layoutView);



        return recycler;
    }

    @Override
    public void onBindViewHolder(ArrivalHolder holder, int position) {

        Datum product = mProductList.get(position);


        try {
            Common.setImage(mContext,product.getImages().get(0).getImage_path(),holder.productImage);
        }

        catch (Exception exc){


        }

        holder.productName.setText(product.product_name);
        holder.productPrice.setText(product.getLowest_price()+" ("+product.getDiscount()+"% OFF )");

        holder.productImage.setOnClickListener(new ProductTapListener(product));

    }


    @Override
    public int getItemCount() {

        return mProductList.size();
    }

    private class ProductTapListener implements View.OnClickListener {


        private Datum mProduct;

        public ProductTapListener(Datum product) {
            this.mProduct = product;
        }

        @Override
        public void onClick(View view) {

            NavigationUtils.showProductDetailScreen(mContext,mProduct);
        }
    }
}
