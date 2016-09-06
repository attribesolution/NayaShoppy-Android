package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 28-Jul-16.
 */
public class DealsHolder extends RecyclerView.ViewHolder{

    public RelativeLayout parent;
    public TextView productName;
    public TextView productPrice;
    public ImageView wishIcon;
    public ImageView shareIcon;
    public ImageView productImage;
    public DealsHolder(View itemView) {
        super(itemView);

        parent = (RelativeLayout)itemView.findViewById(R.id.deal_item_parent);
        productName = (TextView)itemView.findViewById(R.id.deals_product_name);
        productPrice = (TextView)itemView.findViewById(R.id.deals_product_price);
        wishIcon = (ImageView) itemView.findViewById(R.id.deals_wish);
        shareIcon = (ImageView)itemView.findViewById(R.id.deals_share);
        productImage = (ImageView)itemView.findViewById(R.id.deals_product_image);

    }
}
