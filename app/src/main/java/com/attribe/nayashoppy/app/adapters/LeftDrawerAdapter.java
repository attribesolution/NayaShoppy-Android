package com.attribe.nayashoppy.app.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.screens.Main;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 01-Aug-16.
 */
public class LeftDrawerAdapter extends BaseAdapter {

    private final ArrayList<Datum> dataset;
    private final Context mContext;

    public LeftDrawerAdapter(Context context, ArrayList<Datum> parentCategories) {

        this.mContext = context;
        this.dataset= parentCategories;
    }


    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

        listItem = inflater.inflate(R.layout.drawer_left_item, viewGroup, false);

        TextView name = (TextView) listItem.findViewById(R.id.optionName);
        ImageView icon = (ImageView)listItem.findViewById(R.id.optionIcon);

        name.setText(dataset.get(position).getTitle());

        listItem.setOnClickListener(new CategoryClickListener(position));
        return listItem;
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
