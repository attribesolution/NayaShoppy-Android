package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 27-Jul-16.
 */
public class WhishListHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView productName;
    public TextView productPrice;
    public TextView productVendor;

    public WhishListHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.whish_image);
        productName = (TextView) itemView.findViewById(R.id.whish_product_name);

        productPrice = (TextView) itemView.findViewById(R.id.whish_product_price);
        productVendor = (TextView) itemView.findViewById(R.id.whish_vendor);
    }
}
