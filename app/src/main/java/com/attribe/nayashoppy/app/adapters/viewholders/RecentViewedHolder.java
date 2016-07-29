package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 29-Jul-16.
 */
public class RecentViewedHolder extends RecyclerView.ViewHolder{

    public ImageView productImage;
    public TextView productName;
    public TextView productPrice;
    public TextView productVendor;

    public RecentViewedHolder(View itemView) {
        super(itemView);
        productImage = (ImageView)itemView.findViewById(R.id.arrival_image);
        productName = (TextView)itemView.findViewById(R.id.arrival_product_name);
        productPrice = (TextView)itemView.findViewById(R.id.arrival_product_price);
        productVendor = (TextView)itemView.findViewById(R.id.arrival_product_vendor);
    }
}
