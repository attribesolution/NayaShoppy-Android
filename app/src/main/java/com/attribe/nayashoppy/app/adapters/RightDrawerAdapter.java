package com.attribe.nayashoppy.app.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.util.NavigationUtils;
import com.attribe.nayashoppy.app.util.RightDrawer;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 22-Jul-16.
 */
public class RightDrawerAdapter extends BaseAdapter {


    private final Context mContext;
    private final ArrayList<RightDrawer> mDrawerList;

    public RightDrawerAdapter(Context context, ArrayList<RightDrawer> rightDrawer) {

        this.mContext = context;
        this.mDrawerList = rightDrawer;
    }

    @Override
    public int getCount() {
        return mDrawerList.size();
    }

    @Override
    public RightDrawer getItem(int i) {
        return mDrawerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(R.layout.drawer_right_item, viewGroup, false);


        TextView name = (TextView) listItem.findViewById(R.id.optionName);
        ImageView icon = (ImageView)listItem.findViewById(R.id.optionIcon);
        icon.setImageResource(mDrawerList.get(position).getIconResource());
        name.setText(mDrawerList.get(position).getOptionName());

        listItem.setOnClickListener(new DrawerItemListener(position));

        return listItem;
    }

    private class DrawerItemListener implements View.OnClickListener {

        private final int position;

        public DrawerItemListener(int position) {
                this.position = position;
        }

        @Override
        public void onClick(View view) {

            switch (position){

                case 0:
                    NavigationUtils.showLoginScreen(mContext);
                    break;

                case 1:
                    NavigationUtils.showMyOrderScreen(mContext);
                    break;

                case 2:
                    NavigationUtils.showWalletScreen(mContext);
                    break;

                case 3:
                    NavigationUtils.showWhishListScreen(mContext);
                    break;


                case 4:
                    NavigationUtils.showRateAppScreen(mContext);
                    break;

                case 5:
                    NavigationUtils.showAbouUsScreen(mContext);
                    break;
            }
        }
    }
}
