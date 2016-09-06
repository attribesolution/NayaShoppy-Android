package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 20-Jul-16.
 */
public class ArrivalHolder extends RecyclerView.ViewHolder{

    public RelativeLayout parent;
    public ImageView productImage;
    public TextView productName;
    public TextView productPrice;
    public TextView productVendor;

    public ArrivalHolder(View itemView) {
        super(itemView);
        parent = (RelativeLayout)itemView.findViewById(R.id.arrival_parent);
        productImage = (ImageView)itemView.findViewById(R.id.arrival_image);
        productName = (TextView)itemView.findViewById(R.id.arrival_product_name);
        productPrice = (TextView)itemView.findViewById(R.id.arrival_product_price);
        productVendor = (TextView)itemView.findViewById(R.id.arrival_product_vendor);
    }
}
