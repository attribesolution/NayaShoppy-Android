package com.attribe.nayashoppy.app.util;

import android.support.v7.widget.RecyclerView;
import com.attribe.nayashoppy.app.model.product_category.Datum;

import java.util.ArrayList;

/**
 * Created by attribe on 10/14/16.
 */
public class RecentViewed {
    private static RecentViewed recentViewed;
    public static ArrayList<ViewedProduct> recentviewedList=new ArrayList<ViewedProduct>();
    private RecentViewed(){

    }
    public static RecentViewed getIntstance()
    {
        if(recentViewed==null)
        {
            recentViewed = new RecentViewed();
        }
        return recentViewed;



    }
    public void addrecentviewedItem(ViewedProduct product)
    {

       recentviewedList.add(product);

    }
}
