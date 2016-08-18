package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 16-Aug-16.
 */
public class PopularProductListHolder extends RecyclerView.ViewHolder{

    public TextView productName;
    public TextView productPrice;
    public ImageView productImage;

    public PopularProductListHolder(View itemView) {
        super(itemView);
        productImage = (ImageView)itemView.findViewById(R.id.popular_product_list_image);
        productName = (TextView) itemView.findViewById(R.id.popular_product_list_item_prod_name);
        productPrice = (TextView) itemView.findViewById(R.id.popular_product_list_item_prod_price);
    }
}
