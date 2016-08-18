package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.SupplierListHolder;
import com.attribe.nayashoppy.app.model.product_category.Supplier;
import com.attribe.nayashoppy.app.util.DevicePreferences;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 18-Aug-16.
 */
public class SupplierAdapter extends RecyclerView.Adapter<SupplierListHolder> {


    private ArrayList<Supplier> mDataset;
    private Context mContext;

    public SupplierAdapter(ArrayList<Supplier> suppliers) {
        this.mDataset = suppliers;
    }

    @Override
    public SupplierListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View row = LayoutInflater.from(mContext).inflate(R.layout.supplier_list_item, parent, false);

        SupplierListHolder holder = new SupplierListHolder(row);

        return holder;
    }

    @Override
    public void onBindViewHolder(SupplierListHolder holder, int position) {

        holder.price.setText(DevicePreferences.getInstance().getCurrency()+mDataset.get(position).getPrice());

        setDetails(holder.detailContainer);
    }

    private void setDetails(LinearLayout detailContainer) {

        detailContainer.removeAllViews();
        TextView textView = new TextView(mContext);

        textView.setText(mDataset.get(0).delivery);
        detailContainer.addView(textView);


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
