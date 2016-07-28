package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 28-Jul-16.
 */
public class MyOrderHolder extends RecyclerView.ViewHolder {


    public TextView orderID;
    public TextView productName;
    public TextView orderStatus;
    public TextView orderDate;
    public ImageView productImage;

    public MyOrderHolder(View itemView) {
        super(itemView);
        orderID = (TextView) itemView.findViewById(R.id.myorder_orderID);
        productName = (TextView) itemView.findViewById(R.id.myorder_product_name);
        orderStatus = (TextView) itemView.findViewById(R.id.myorder_status);
        orderDate = (TextView) itemView.findViewById(R.id.myorder_order_date);
        productImage = (ImageView) itemView.findViewById(R.id.myorder_image);
    }
}
