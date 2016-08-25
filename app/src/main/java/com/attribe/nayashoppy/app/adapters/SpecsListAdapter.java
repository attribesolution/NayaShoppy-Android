package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.model.popular_products.Data;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 25-Aug-16.
 */
public class SpecsListAdapter extends BaseExpandableListAdapter {

    private final Context mContext;
    private final ArrayList<Data.FeaturesList> mDataset;

    public SpecsListAdapter(Context context, ArrayList<Data.FeaturesList> featuresList) {

        this.mContext = context;
        this.mDataset = featuresList;
    }

    @Override
    public int getGroupCount() {
        return mDataset.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mDataset.get(i).getFeatureValues().size();
    }

    @Override
    public Data.FeaturesList getGroup(int i) {
        return mDataset.get(i);
    }

    @Override
    public Data.FeaturesList.FeatureValue getChild(int i, int i1) {
        return mDataset.get(i).getFeatureValues().get(i1);
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
    public View getGroupView(int i, boolean isExpanded, View view, ViewGroup viewGroup) {
        GroupViewHolder groupHolder = null;
        if(view !=null){

            groupHolder = (GroupViewHolder) view.getTag();

        }

        else{
            view = LayoutInflater.from(mContext).inflate(R.layout.specs_parent_item,viewGroup,false);

            groupHolder = new GroupViewHolder(view);

            view.setTag(groupHolder);

        }

        if(!isExpanded){

            groupHolder.groupIndicator.setImageResource(R.drawable.tab_arrow_down);


        }
        else{

            groupHolder.groupIndicator.setImageResource(R.drawable.tab_arrow_up);

        }
        groupHolder.groupName.setText(getGroup(i).getFeatureGroupName());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View childView, ViewGroup viewGroup) {

        ChildHolder childHolder ;
        if(childView != null){

            childHolder = (ChildHolder) childView.getTag();
        }

        else{
            childView = LayoutInflater.from(mContext).inflate(R.layout.specs_child_item,viewGroup,false);

            childHolder = new ChildHolder(childView);

            childView.setTag(childHolder);

        }

        childHolder.featureKey.setText(getChild(i,i1).getFeatureName());
        childHolder.featureValue.setText(getChild(i,i1).getFeatureValue());


        return childView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    private class GroupViewHolder {

        TextView groupName;
        public ImageView groupIndicator;

        public GroupViewHolder(View view) {

            groupIndicator = (ImageView)view.findViewById(R.id.specs_group_indicator);
            groupName = (TextView) view.findViewById(R.id.specs_feature_group);
        }
    }

    private class ChildHolder {
        TextView featureKey;
        TextView featureValue;
        public ChildHolder(View childView) {

            featureKey = (TextView) childView.findViewById(R.id.specs_feature_key);
            featureValue = (TextView)childView.findViewById(R.id.specs_feature_value);
        }
    }
}
