package com.attribe.nayashoppy.app.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.adapters.viewholders.NewProductArrivalHolder;
import com.attribe.nayashoppy.app.model.Product;
import com.attribe.nayashoppy.app.model.product_category.ProductCategory;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 04-Aug-16.
 */
public class ProductArrivalAdapter extends RecyclerView.Adapter<NewProductArrivalHolder> {
    public ProductArrivalAdapter(ProductCategory products) {
    }

    @Override
    public NewProductArrivalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NewProductArrivalHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
