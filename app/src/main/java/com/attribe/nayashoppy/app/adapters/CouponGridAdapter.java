package com.attribe.nayashoppy.app.adapters;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.CouponHolder;
import com.attribe.nayashoppy.app.model.Coupon;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 19-Jul-16.
 */
public class CouponGridAdapter extends RecyclerView.Adapter<CouponHolder>{


    private final ArrayList<Coupon> mCouponList;
    private final Context mContext;

    public CouponGridAdapter(Context context, ArrayList<Coupon> couponList) {
        this.mContext = context;
        this.mCouponList = couponList;
    }

    @Override
    public CouponHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_grid_item, null);
        CouponHolder recyclerView = new CouponHolder(layoutView);

        return recyclerView;
    }

    @Override
    public void onBindViewHolder(CouponHolder holder, int position) {

        holder.couponCardView.setCardBackgroundColor(
                        Color.parseColor(mCouponList.get(position).getCouponViewColor()));
        holder.couponName.setText(mCouponList.get(position).getCouponName());

    }

    @Override
    public int getItemCount() {
        return this.mCouponList.size();
    }
}
