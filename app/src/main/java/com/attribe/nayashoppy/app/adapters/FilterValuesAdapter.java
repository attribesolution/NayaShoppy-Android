package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
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
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final ViewHolder holder ;

        final CategoryFilter.Facets.Filter.Value value = mDataset.get(position);
        if(view!=null){
            holder = (ViewHolder) view.getTag();
        }
        else{

            view = LayoutInflater.from(mContext).inflate(R.layout.filter_value_item, viewGroup,false);

            holder = new ViewHolder(view);

            holder.filterValueCheck.setChecked(value.isSelected);
            holder.filterValue.setText(value.getName());

            view.setTag(holder);


        }

        holder.filterValueCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();

                if(checked){
                    value.setSelected(checked);

                }
                else {
                    value.setSelected(checked);
                }

            }
        });



        return view;
    }

    static class ViewHolder{
        @BindView(R.id.filter_value)CheckedTextView filterValue;

        CheckBox filterValueCheck;
        public ViewHolder(View view) {

            filterValue= (CheckedTextView) view.findViewById(R.id.filter_value);
            filterValueCheck = (CheckBox) view.findViewById(R.id.values_selector);
        }
    }
}
