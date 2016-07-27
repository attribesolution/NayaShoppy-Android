package com.attribe.nayashoppy.app.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.MainScreenPagerAdapter;
import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.screens.*;
import com.attribe.nayashoppy.app.screens.categories.*;
import com.attribe.nayashoppy.app.screens.useraccount.*;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 18-Jul-16.
 */
public class NavigationUtils {


    public static final String KEY_MENU_ID = "parentCategory";
    public static final int DEFAULT_PARENT_CATEGORY=1;
    public static final String BUNDLE_FROM_MAIN = "bundle_category";
    public static final String KEY_CATEGORY_CHILD = "categoryChild";
    public static final String CHILD_MENU = "childMenu";

    public static void showHome(Context context) {

        Intent intent = new Intent(context,Main.class);
        context.startActivity(intent);

    }

    public static void showCategoryScreen(Context mContext, Bundle bundle) {
        Intent intent = new Intent(mContext, ShopByCategory.class);
        intent.putExtra(BUNDLE_FROM_MAIN,bundle);
        mContext.startActivity(intent);
    }

    public static ArrayList<RightDrawer> getRightDrawer() {
        RightDrawer rightDrawer1 = new RightDrawer("Login/Register",R.drawable.icon_login_register);
        RightDrawer rightDrawer2 = new RightDrawer("My Order",R.drawable.icon_myorder);
        RightDrawer rightDrawer3 = new RightDrawer("My Wallet",R.drawable.icon_mywallet);
        RightDrawer rightDrawer4 = new RightDrawer("Whish List",R.drawable.icon_whishlist);
        RightDrawer rightDrawer5 = new RightDrawer("Rate the app",R.drawable.icon_rate_the_app);
        RightDrawer rightDrawer6 = new RightDrawer("About Us",R.drawable.icon_user);

        ArrayList<RightDrawer> list = new ArrayList<RightDrawer>();
                list.add(rightDrawer1);
                list.add(rightDrawer2);
                list.add(rightDrawer3);
                list.add(rightDrawer4);
                list.add(rightDrawer5);
                list.add(rightDrawer6);


        return list;

    }

    public static MainScreenPagerAdapter getPagerAdapter(Context context, FragmentManager supportFragmentManager) {
        MainScreenPagerAdapter adapter = new MainScreenPagerAdapter(supportFragmentManager);
        ArrayList<Datum> parentCategories = DevicePreferences.getInstance().getMenu();
        if(context instanceof ShopByCategory){


            for(Datum menu:parentCategories){

                adapter.addFrag(new BasicFragment(),menu.getTitle(),menu.getChildren());
            }

//            adapter.addFrag(new MobilesAndTablets(),parentCategories.get(0).getTitle(),
//                    parentCategories.get(0).getChildren());
//
//            adapter.addFrag(new LaptopsAndPeripherals(),
//                    parentCategories.get(1).getTitle(), parentCategories.get(1).getChildren());
//
//            adapter.addFrag(new TelevisionsAndCameras(),parentCategories.get(2).getTitle(), parentCategories.get(2).getChildren());
//            adapter.addFrag(new Fashion(),parentCategories.get(3).getTitle(), parentCategories.get(3).getChildren());
//            adapter.addFrag(new Kids(),parentCategories.get(4).getTitle(), parentCategories.get(4).getChildren());
//            adapter.addFrag(new Beauty(),parentCategories.get(5).getTitle(), parentCategories.get(5).getChildren());
//            adapter.addFrag(new HomeAndKitchen(),parentCategories.get(6).getTitle(), parentCategories.get(6).getChildren());
//            adapter.addFrag(new SportsAndHealth(),parentCategories.get(7).getTitle(), parentCategories.get(7).getChildren());
//            adapter.addFrag(new Books(),parentCategories.get(8).getTitle(), parentCategories.get(8).getChildren());
        }

        if(context instanceof Main){

            adapter.addFrag(new Home(),"Home", null);
            adapter.addFrag(new DealsOfDay(),"Deals of the day", null);
        }

        return adapter;
    }

    public static String getScreenTitle(Context context) {

        String label="";

        if(context instanceof ScreenMyOrder){

            label = context.getResources().getString(R.string.label_my_order);

        }


        if(context instanceof ScreenWallet){

            label = context.getResources().getString(R.string.label_my_wallet);
        }

        if(context instanceof ScreenWhishList){

            label =context.getResources().getString(R.string.label_whish_list);
        }


        if(context instanceof ScreenRateApp){

            label = context.getResources().getString(R.string.label_rate_app);

        }

        if(context instanceof ScreenAboutUs){

            label = context.getResources().getString(R.string.label_about_us);
        }



        return label;
    }


    public static void showLoginScreen(Context context) {
        Intent intent = new Intent(context,ScreenLogin.class);
        context.startActivity(intent);
    }
    public static void showMyOrderScreen(Context context) {
        Intent intent = new Intent(context,ScreenMyOrder.class);
        context.startActivity(intent);
    }
    public static void showWalletScreen(Context context) {
        Intent intent = new Intent(context,ScreenWallet.class);
        context.startActivity(intent);
    }

    public static void showWhishListScreen(Context context) {
        Intent intent = new Intent(context,ScreenWhishList.class);
        context.startActivity(intent);
    }

    public static void showRateAppScreen(Context context) {
        Intent intent = new Intent(context,ScreenRateApp.class);
        context.startActivity(intent);
    }

    public static void showAbouUsScreen(Context context) {
        Intent intent = new Intent(context,ScreenAboutUs.class);
        context.startActivity(intent);
    }
}