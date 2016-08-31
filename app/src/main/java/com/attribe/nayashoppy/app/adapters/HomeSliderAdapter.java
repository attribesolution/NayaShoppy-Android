package com.attribe.nayashoppy.app.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.util.Common;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Sabih Ahmed on 19-Jul-16.
 */
public class HomeSliderAdapter extends PagerAdapter{


    private Context mContext;
    private ArrayList<String> imageURLList;
    private LayoutInflater mLayoutInflater;

    public HomeSliderAdapter(Context mContext, ArrayList<String> imageURLs) {

        this.mContext = mContext;
        imageURLList = imageURLs;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageURLList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.home_slider_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        try {
            Common.setImage(mContext,imageURLList.get(position),imageView);
        }
        catch (Exception exc){

        }



        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout  )object);
    }
}
