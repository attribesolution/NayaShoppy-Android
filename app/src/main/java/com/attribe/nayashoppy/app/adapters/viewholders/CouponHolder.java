package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 19-Jul-16.
 */
public class CouponHolder extends RecyclerView.ViewHolder {

    public TextView couponName;
    public ImageView couponImage;
    public CardView couponCardView;

    public CouponHolder(View itemView) {
        super(itemView);

        couponName = (TextView)itemView.findViewById(R.id.coupon_name);
        couponImage = (ImageView)itemView.findViewById(R.id.coupon_image);
        couponCardView = (CardView)itemView.findViewById(R.id.card_coupon);
    }
}
