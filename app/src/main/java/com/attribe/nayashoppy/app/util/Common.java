package com.attribe.nayashoppy.app.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.model.Datum;
import com.squareup.picasso.Picasso;

/**
 * Created by Sabih Ahmed on 05-Aug-16.
 */
public class Common {


    public static String getImage(Context mContext, Datum.ApiIcon.Android android) {


        String imageURI = "";

        if(getDeviceDensity(mContext)==DisplayMetrics.DENSITY_MEDIUM){

            imageURI = android.getMdpi();

        }

        if(getDeviceDensity(mContext)==DisplayMetrics.DENSITY_HIGH){

            imageURI = android.getHdpi();
        }

        if(getDeviceDensity(mContext)==DisplayMetrics.DENSITY_XHIGH){

            imageURI = android.getXxdpi();

        }

        if(getDeviceDensity(mContext)==DisplayMetrics.DENSITY_XXHIGH){

            imageURI = android.getXxdpi();

        }

        return imageURI;

    }


    public static int getDeviceDensity(Context context){

        int density = context.getResources().getDisplayMetrics().densityDpi;

        return density;

    }

    public static void setImage(Context context, String imageURi, ImageView categoryImage) {
        try {
            //Glide.with(context).load(imageURi).placeholder(R.drawable.image_place_holder).crossFade().into(categoryImage);
            Picasso.with(context).load(imageURi).placeholder(R.drawable.image_place_holder).into(categoryImage);
        }catch (Exception e){

        }

    }

    public static void getDimension(Context context){

        WindowManager WindowManager = (android.view.WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = WindowManager.getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        int width = size.x;
        int height = size.y;

        Log.d("Display","Device width: "+Integer.toString(width)+" Device Height: "+Integer.toString(height));
    }

    public static ActionBar setBackButtonColor(Context context, ActionBar actionBar) {
        try {
            Drawable upArrow = context.getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            upArrow.setColorFilter(context.getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
            actionBar.setHomeAsUpIndicator(upArrow);
        }catch (Exception exc){
            //Todo: Handle Exception
        }


        return actionBar;

    }

    public static void showShareChooser(Context context, String productUrl) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, productUrl);
        sendIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(sendIntent, "Send to:"));
    }
}
