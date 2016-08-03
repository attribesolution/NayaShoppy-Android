package com.attribe.nayashoppy.app.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.viewholders.LeftDrawerHolder;
import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.screens.Main;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 01-Aug-16.
 */
public class LeftDrawerAdapter extends RecyclerView.Adapter<LeftDrawerHolder> {

    private final ArrayList<Datum> dataset;
    private Context mContext;

    public LeftDrawerAdapter(Context context, ArrayList<Datum> parentCategories) {

        this.mContext = context;
        this.dataset= parentCategories;
    }




    /**
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ImageView icon = (ImageView)listItem.findViewById(R.id.optionIcon);

        name.setText(dataset.get(position).getTitle());

        listItem.setOnClickListener(new CategoryClickListener(position));
        return listItem;
    }   **/

    @Override
    public LeftDrawerHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LeftDrawerHolder holder = null;

        if(viewType == 0){
            View item = LayoutInflater.from(mContext).inflate(R.layout.drawer_left_header, parent, false);

            holder = new LeftDrawerHolder(item,viewType);
        }
        if(viewType ==1){

            View item = LayoutInflater.from(mContext).inflate(R.layout.drawer_left_item, parent, false);
            holder = new LeftDrawerHolder(item,viewType);
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(LeftDrawerHolder holder, int position) {

        if(position!=0){

            holder.optionName.setText(dataset.get(position).getTitle());
            holder.itemView.setOnClickListener(new CategoryClickListener(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position ==0)return 0;
        else return 1;
    }

    private class CategoryClickListener implements View.OnClickListener {
        private int position;

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
}
