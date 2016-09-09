package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.model.dummy_model.FilterValue;
import com.attribe.nayashoppy.app.model.product_category.CategoryFilter;
import com.attribe.nayashoppy.app.screens.product_listings.ScreenFilter;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 23-Aug-16.
 */
public class FilterValuesAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<CategoryFilter.Facets.Filter.Value> mDataset;
    private View row;


    public FilterValuesAdapter(Context context, ArrayList<CategoryFilter.Facets.Filter.Value> values) {
        this.mContext = context;
        this.mDataset = values;

    }

    @Override
    public int getCount() {
        return mDataset.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder ;
        if(view!=null){
            holder = (ViewHolder) view.getTag();
        }
        else{

            view = LayoutInflater.from(mContext).inflate(R.layout.filter_value_item, viewGroup,false);

            holder = new ViewHolder(view);

            view.setTag(holder);
        }

        holder.filterValue.setText(mDataset.get(position).getName());

        return view;
    }

    static class ViewHolder{
        @BindView(R.id.filter_value)TextView filterValue;

        public ViewHolder(View view) {

            filterValue= (TextView) view.findViewById(R.id.filter_value);
        }
    }
}
