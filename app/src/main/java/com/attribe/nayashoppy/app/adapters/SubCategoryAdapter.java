package com.attribe.nayashoppy.app.adapters;

import android.app.Service;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.model.Children;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by Sabih Ahmed on 25-Jul-16.
 */
public class SubCategoryAdapter extends BaseExpandableListAdapter {

    private final ArrayList<Children> list;
    private LayoutInflater mInflater;


    public SubCategoryAdapter(Context context, ArrayList<Children> compoundList) {
        this.list = compoundList;
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
    public Object getGroup(int position) {
        return list.get(position).getTitle();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getChildren().get(childPosition).getTitle();
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

        parentName.setText(list.get(position).getTitle());

        return parentView;
    }

    @Override
    public View getChildView(int i, int i1, boolean isExpanded, View view, ViewGroup viewGroup) {
        View childView = mInflater.inflate(R.layout.child_category_item,viewGroup,false);

        TextView childName = (TextView)childView.findViewById(R.id.child_name);

        childName.setText(getChild(i,i1).toString());

        return childView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
