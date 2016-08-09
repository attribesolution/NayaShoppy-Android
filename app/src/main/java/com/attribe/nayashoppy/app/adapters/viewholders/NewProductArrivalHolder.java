package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 04-Aug-16.
 */
public class NewProductArrivalHolder extends RecyclerView.ViewHolder {

    public TextView productName;
    public TextView productPrice;
    public ImageView wishIcon;
    public ImageView shareIcon;
    public ImageView productImage;

    public NewProductArrivalHolder(View itemView) {
        super(itemView);
        productName = (TextView) itemView.findViewById(R.id.product_arrival_product_name);
        productPrice = (TextView) itemView.findViewById(R.id.product_arrival_product_price);
        wishIcon = (ImageView) itemView.findViewById(R.id.product_arrival_wish);
        shareIcon = (ImageView)itemView.findViewById(R.id.product_arrival_share);
        productImage = (ImageView) itemView.findViewById(R.id.product_arrival_product_image);
    }
}
