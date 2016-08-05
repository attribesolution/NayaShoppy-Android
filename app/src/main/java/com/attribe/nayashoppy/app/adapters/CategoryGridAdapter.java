package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.CategoryGridHolder;
import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.util.Common;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.attribe.nayashoppy.app.util.Common.getImage;

/**
 * Created by Sabih Ahmed on 19-Jul-16.
 */
public class CategoryGridAdapter extends RecyclerView.Adapter<CategoryGridHolder>{


    private ArrayList<Datum> mCategoryList;
    private Context mContext;

    public CategoryGridAdapter(Context context , ArrayList<Datum> categoryList) {
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

        Datum data = mCategoryList.get(position);

        holder.categoryName.setText(mCategoryList.get(position).getTitle());
        try {
            Datum.ApiIcon.Android images = data.getImages().getAndroid();
            if(images != null){

                try {
                    //Picasso.with(mContext).load(getImage(mContext,images)).into(holder.categoryImage);
                    Common.setImage(mContext,getImage(mContext,images),holder.categoryImage);
                }
                catch (IllegalArgumentException iae){

                    //TODO: handle exception
                }

            }
        }
        catch (NullPointerException npe){
            //TODO: handle exception

        }





        holder.parentView.setOnClickListener(new CategoryClickListener(position));

    }


    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }




    //==========================================Inner classes/interfaces======================================

    private class CategoryClickListener implements View.OnClickListener {

        private final int position;

        public CategoryClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {

            Bundle bundle = new Bundle();
            bundle.putInt(NavigationUtils.KEY_MENU_ID,position);
            NavigationUtils.showCategoryScreen(mContext,bundle);

        }
    }

    //********************************************************************************************************
}
