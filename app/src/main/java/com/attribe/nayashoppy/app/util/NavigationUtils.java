package com.attribe.nayashoppy.app.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.MainScreenPagerAdapter;
import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.model.Deals.Child;
import com.attribe.nayashoppy.app.screens.*;
import com.attribe.nayashoppy.app.screens.categories.*;
import com.attribe.nayashoppy.app.screens.product_detail.FragmentPrices;
import com.attribe.nayashoppy.app.screens.product_detail.FragmentReviews;
import com.attribe.nayashoppy.app.screens.product_detail.FragmentSpecification;
import com.attribe.nayashoppy.app.screens.product_detail.ScreenProductDetail;
import com.attribe.nayashoppy.app.screens.product_listings.*;
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
    public static final String KEY_CATEGORY_ID = "category_id";
    public static final String KEY_BRAND_ID = "brand_id";
    public static final String BUNDLE_PRODUCTS = "bundle_products";
    public static final String KEY_SUBCATEGORY_TITLE = "subcategoryTitle";
    private static final String SUBCATEGORY_SCREEN_DEFAULT_TITLE = "";
    private static final String KEY_PRODUCT = "product";
    public static final String KEY_PRODUCT_ID = "product_id";
    public static final String KEY_PRODUCT_NAME = "productName";
    public static final String KEY_PRODUCT_SLUG = "slug";
    private static ProgressLoader progress;

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

    public static MainScreenPagerAdapter  getPagerAdapter(Context context,
                                                          FragmentManager supportFragmentManager,
                                                          @Nullable Bundle params) {
        MainScreenPagerAdapter adapter = new MainScreenPagerAdapter(supportFragmentManager);


        if(context instanceof ShopByCategory){

            ArrayList<Datum> parentCategories = DevicePreferences.getInstance().getMenu();

            for(Datum menu:parentCategories){
                Bundle bundle = new Bundle();
                bundle.putSerializable(CHILD_MENU,menu.getChildren());
                adapter.addFrag(new BasicFragment(),menu.getTitle(),bundle);
                //adapter.addFrag(new BasicFragment(),menu.getTitle(),menu.getChildren());
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

        if(context instanceof ScreenAllProduct){

            adapter.addFrag(new FragmentAllProduct(),"All Products",params);
            adapter.addFrag(new FragmentPopularProduct(),"Popular Products",params);
        }

        if(context instanceof ScreenProductDetail){
            adapter.addFrag(new FragmentPrices(),"PRICES",params);
            adapter.addFrag(new FragmentSpecification(),"SPECIFICATIONS",params);
            adapter.addFrag(new FragmentReviews(),"REVIEWS",params);
        }

        return adapter;
    }

    public static String getScreenTitle(Context context) {

        //set app name as default title
        String label = context.getString(R.string.app_name);

        if(context instanceof Main){

            label = context.getResources().getString(R.string.label_home);

        }


        if(context instanceof ScreenMyOrder){

            label = context.getResources().getString(R.string.label_my_order);

        }


        if(context instanceof ScreenWallet){

            label = context.getResources().getString(R.string.label_my_wallet);
        }

        if(context instanceof ScreenWishList){

            label =context.getResources().getString(R.string.label_whish_list);
        }


        if(context instanceof ScreenRateApp){

            label = context.getResources().getString(R.string.label_rate_app);

        }

        if(context instanceof ScreenAboutUs){

            label = context.getResources().getString(R.string.label_about_us);
        }

        if(context instanceof ScreenProducts){

            if(((ScreenProducts) context).getIntent().getBundleExtra(BUNDLE_PRODUCTS)!=null){

                label = ((ScreenProducts) context).getIntent().getBundleExtra(BUNDLE_PRODUCTS).getString(KEY_SUBCATEGORY_TITLE,
                        SUBCATEGORY_SCREEN_DEFAULT_TITLE);
            }

        }

        if(context instanceof ScreenAllProduct){
            if(((ScreenAllProduct) context).getIntent().getBundleExtra(BUNDLE_PRODUCTS)!=null){

                label = ((ScreenAllProduct) context).getIntent().getBundleExtra(BUNDLE_PRODUCTS).getString(KEY_SUBCATEGORY_TITLE,
                        SUBCATEGORY_SCREEN_DEFAULT_TITLE);
            }

        }

        if(context instanceof ScreenProductDetail){

            try {
                Bundle productBundle = ((ScreenProductDetail) context).getIntent().getBundleExtra(BUNDLE_PRODUCTS);
                int productID = productBundle.getInt(KEY_PRODUCT_ID,0);

                label =  productBundle.getString(KEY_PRODUCT_NAME,label);
            }
            catch (Exception exc){

            }


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
        Intent intent = new Intent(context,ScreenWishList.class);
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

    public static void showProductScreen(Context mContext, Bundle bundle) {

        //extract cat_id & brand_ID just to check which brand is this
        //ScreenProducts have to be shown in case of cat_id 1 & brand_id=0

        int categoryID = bundle.getInt(KEY_CATEGORY_ID);
        int brandID = bundle.getInt(KEY_BRAND_ID);

        if(categoryID ==1 && brandID ==0){
            Intent intent = new Intent(mContext, ScreenProducts.class);
            intent.putExtra(BUNDLE_PRODUCTS,bundle);
            mContext.startActivity(intent);
        }

        else{

            Intent intent = new Intent(mContext,ScreenAllProduct.class);
            intent.putExtra(BUNDLE_PRODUCTS,bundle);
            mContext.startActivity(intent);

        }


    }

    public static ProgressLoader getProgress(boolean attachText) {


        progress = new ProgressLoader();



        return progress;
    }

    /** Show WishProduct Detail
     * Overloaded method due to inconsistent product object received from webservice
     * @param mContext
     * @param product
     */
    public static void showProductDetailScreen(Context mContext,
                                               com.attribe.nayashoppy.app.model.product_category.Datum product) {
        Intent intent = new Intent(mContext, ScreenProductDetail.class);

        Bundle bundle = new Bundle();
        bundle.putString(NavigationUtils.KEY_PRODUCT_NAME,product.getProduct_name());
        bundle.putInt(NavigationUtils.KEY_PRODUCT_ID,product.getProduct_id());
        bundle.putString(NavigationUtils.KEY_PRODUCT_SLUG,product.getSlug());
        intent.putExtra(NavigationUtils.BUNDLE_PRODUCTS,bundle);

        mContext.startActivity(intent);

    }


    /**Show WishProduct Detail
     * Overloaded method due to inconsistent product object received from webservice
     *
     * @param mContext
     * @param product
     */
    public static void showProductDetailScreen(Context mContext,
                                               com.attribe.nayashoppy.app.model.arrival.Datum product) {
        Intent intent = new Intent(mContext, ScreenProductDetail.class);

        Bundle bundle = new Bundle();
        bundle.putString(NavigationUtils.KEY_PRODUCT_NAME,product.getProduct_name());
        bundle.putInt(NavigationUtils.KEY_PRODUCT_ID,product.getProduct_id());
        bundle.putString(NavigationUtils.KEY_PRODUCT_SLUG,product.getSlug());
        intent.putExtra(NavigationUtils.BUNDLE_PRODUCTS,bundle);

        mContext.startActivity(intent);

    }

    public static void showProductDetailScreen(Context mContext,
                                               com.attribe.nayashoppy.app.model.product_detail.Datum product) {
        Intent intent = new Intent(mContext, ScreenProductDetail.class);

        Bundle bundle = new Bundle();
        bundle.putString(NavigationUtils.KEY_PRODUCT_NAME,product.getProduct_name());
        bundle.putInt(NavigationUtils.KEY_PRODUCT_ID,product.getProduct_id());
        bundle.putString(NavigationUtils.KEY_PRODUCT_SLUG,product.getSlug());
        intent.putExtra(NavigationUtils.BUNDLE_PRODUCTS,bundle);
        mContext.startActivity(intent);
    }


    /** For popular products
     *
     * @param mContext
     * @param product
     */


    public static void showProductDetailScreen(Context mContext,
                                               com.attribe.nayashoppy.app.model.popular_products.Data product) {
        Intent intent = new Intent(mContext, ScreenProductDetail.class);

        Bundle bundle = new Bundle();
        bundle.putString(NavigationUtils.KEY_PRODUCT_NAME,product.getProduct_name());
        bundle.putInt(NavigationUtils.KEY_PRODUCT_ID,product.getProduct_id());
        bundle.putString(NavigationUtils.KEY_PRODUCT_SLUG,product.getSlug());
        intent.putExtra(NavigationUtils.BUNDLE_PRODUCTS,bundle);

        mContext.startActivity(intent);

    }



    /**For Deals of day
     *
     * @param mContext
     * @param mProduct
     */
    public static void showProductDetailScreen(Context mContext, Child mProduct) {

    }

    public static void showFilterScreen(Context context ,int categoryID, int brandID) {
        Intent intent = new Intent(context,ScreenFilter.class);
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_CATEGORY_ID,categoryID);
        bundle.putInt(KEY_BRAND_ID,brandID);

        context.startActivity(intent);

    }



}
