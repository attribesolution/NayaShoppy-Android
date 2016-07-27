package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.WhishListHolder;
import com.attribe.nayashoppy.app.model.Product;
import com.attribe.nayashoppy.app.util.DummyData;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 27-Jul-16.
 */
public class WhishListAdapter extends RecyclerView.Adapter<WhishListHolder> {

    private Context mContext;
    private ArrayList<Product> whishList;

    public WhishListAdapter(Context mContext) {
        whishList = DummyData.getDummyProducts();
        this.mContext = mContext;
    }

    @Override
    public WhishListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.whish_list_item,parent,false);

        WhishListHolder whishListHolder =  new WhishListHolder(layout);
        return whishListHolder;
    }

    @Override
    public void onBindViewHolder(WhishListHolder holder, int position) {

        holder.productName.setText(whishList.get(position).getProductName());
        holder.productPrice.setText(whishList.get(position).getProductPrice());

        holder.productVendor.setText(whishList.get(position).getProductVendor());
    }


    @Override
    public int getItemCount() {
        return whishList.size();
    }
}
