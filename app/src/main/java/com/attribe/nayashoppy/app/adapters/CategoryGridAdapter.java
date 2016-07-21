package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.CategoryGridHolder;
import com.attribe.nayashoppy.app.model.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 19-Jul-16.
 */
public class CategoryGridAdapter extends RecyclerView.Adapter<CategoryGridHolder>{


    private ArrayList<Category> mCategoryList;
    private Context mContext;

    public CategoryGridAdapter(Context context , ArrayList<Category> categoryList) {
        this.mContext = context;
        this.mCategoryList = categoryList;
    }

    @Override
    public CategoryGridHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_grid_item, null);
        CategoryGridHolder recyclerView = new CategoryGridHolder(layoutView);

        return recyclerView;


    }

    @Override
    public void onBindViewHolder(CategoryGridHolder holder, int position) {


        holder.categoryName.setText(mCategoryList.get(position).getCategoryName());
        if(!mCategoryList.get(position).getCategoryImageURL().isEmpty())
            Picasso.with(mContext).load(mCategoryList.get(position).getCategoryImageURL()).into(holder.categoryImage);

    }


    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }
}
