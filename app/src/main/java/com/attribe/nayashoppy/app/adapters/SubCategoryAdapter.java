package com.attribe.nayashoppy.app.adapters;

import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.model.Children;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 25-Jul-16.
 */
public class SubCategoryAdapter extends BaseExpandableListAdapter {

    private final ArrayList<Children> list;
    private Context mContext;
    private LayoutInflater mInflater;


    public SubCategoryAdapter(Context context, ArrayList<Children> compoundList) {
        this.list = compoundList;
        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int position) {
        return list.get(position).getChildren().size();
    }

    @Override
    public Children getGroup(int position) {
        return list.get(position);
    }

    @Override
    public Children getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getChildren().get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int position, boolean isExpanded, View view, ViewGroup viewGroup) {

        View parentView = mInflater.inflate(R.layout.parent_category_item,viewGroup,false);
        ImageView groupIndicator = (ImageView) parentView.findViewById(R.id.group_indicator);


        if(!isExpanded){

            groupIndicator.setImageResource(R.drawable.tab_arrow_down);


        }
        else{

            groupIndicator.setImageResource(R.drawable.tab_arrow_up);

        }

        TextView parentName = (TextView) parentView.findViewById(R.id.category_name);

        parentName.setText(getGroup(position).getTitle());

        return parentView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        View childView = mInflater.inflate(R.layout.child_category_item,viewGroup,false);

        TextView childName = (TextView)childView.findViewById(R.id.child_name);

        Children subCategory = getChild(groupPosition, childPosition);
        childName.setText(subCategory.getTitle());

        childView.setOnClickListener(new CategoryClickListener(subCategory));
        return childView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private class CategoryClickListener implements View.OnClickListener {
        private final int categoryID;
        private final int brandID;
        private String subCategoryName;

        public CategoryClickListener(Children subCategory) {


            this.categoryID = subCategory.category_id;
            this.brandID = subCategory.brand_id;
            this.subCategoryName = subCategory.getTitle();
        }

        @Override
        public void onClick(View view) {

            Bundle bundle = new Bundle();
            bundle.putInt(NavigationUtils.KEY_CATEGORY_ID,categoryID);
            bundle.putInt(NavigationUtils.KEY_BRAND_ID,brandID);
            bundle.putString(NavigationUtils.KEY_SUBCATEGORY_TITLE,subCategoryName);
            NavigationUtils.showProductScreen(mContext,bundle);
        }
    }
}
