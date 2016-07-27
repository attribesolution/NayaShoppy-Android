package com.attribe.nayashoppy.app.screens;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.ArrivalAdapter;
import com.attribe.nayashoppy.app.adapters.CouponGridAdapter;
import com.attribe.nayashoppy.app.adapters.CategoryGridAdapter;
import com.attribe.nayashoppy.app.adapters.HomeSliderAdapter;
import com.attribe.nayashoppy.app.model.Coupon;
import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.util.DevicePreferences;
import com.attribe.nayashoppy.app.util.DummyData;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sabih Ahmed on 18-Jul-16.
 */
public class Home extends Fragment {

    private View view;
    private ViewPager slider;
    private GridView gridView;
    private ArrayList<String> sliderImageURLList;
    private HomeSliderAdapter mImageAdapter;
    private Handler handler = new Handler();
    private Runnable Update;
    private TimerTask taskExecutor;
    private long DELAY = 2000;
    private GridLayoutManager categoryGrid;
    private GridLayoutManager couponsGrid;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home, container, false);

        initView();

        return view;
    }

    private void initView() {

        slider = (ViewPager) view.findViewById(R.id.image_slider);

        initSlider();
        initCategoryGrid();
        initCouponsGrid();
        initNewArrivals();
        initSimilarProducts();

    }


    //===================================private Methods=======================================================

    private void initSlider() {
        sliderImageURLList = new ArrayList<String>();
        sliderImageURLList.add("http://52.66.82.224/images/banner/1.jpg");
        sliderImageURLList.add("http://52.66.82.224/images/banner/3.jpg");
        sliderImageURLList.add("http://52.66.82.224/images/banner/2.jpg");

        mImageAdapter = new HomeSliderAdapter(this.getContext(), sliderImageURLList);

        slider.setAdapter(mImageAdapter);

        Update = new Runnable() {
            int position = 3;

            public void run() {
                // Change the position of view pager
                if (position == 3)
                    position = 0;
                slider.setCurrentItem(position++, true);

            }
        };

        taskExecutor = new TimerTask() {
            @Override
            public void run() {
                // to run on main thread
                handler.post(Update);

            }
        };


        // Timer Initialization
        Timer timer = new Timer();
        // Schedule the start time period and callback time period
        timer.schedule(taskExecutor, DELAY, 4000);


    }


    private void initCategoryGrid() {
        ArrayList<Datum> menuList = DevicePreferences.getInstance().getMenu();
        categoryGrid = new GridLayoutManager(getActivity(), 4);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recycler_category);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(categoryGrid);

        CategoryGridAdapter gridAdapter = new CategoryGridAdapter(getActivity(),menuList );
        rView.setAdapter(gridAdapter);

    }

    private void initCouponsGrid() {

        Coupon coupon1 = new Coupon("Mobile Recharge", "", "#E68D19");
        Coupon coupon2 = new Coupon("Travel", "", "#5CB59F");
        Coupon coupon3 = new Coupon("Food & Dining", "", "#BD66D9");
        Coupon coupon4 = new Coupon("Groceries", "", "#CA5132");
        Coupon coupon5 = new Coupon("Movie Tickets", "", "#8385F2");

        ArrayList<Coupon> couponList = new ArrayList<Coupon>();

        couponList.add(coupon1);
        couponList.add(coupon2);
        couponList.add(coupon3);
        couponList.add(coupon4);
        couponList.add(coupon5);

        couponsGrid = new GridLayoutManager(getActivity(), 5);
        RecyclerView recyclerCoupon = (RecyclerView) view.findViewById(R.id.recycler_coupons);

        CouponGridAdapter couponAdapter = new CouponGridAdapter(getActivity(), couponList);
        recyclerCoupon.setAdapter(couponAdapter);


        recyclerCoupon.setHasFixedSize(true);
        recyclerCoupon.setLayoutManager(couponsGrid);


    }


    private void initNewArrivals() {

//
//        ArrayList<Product> productList = new ArrayList<Product>();
//        Product product1 = new Product("Sony Experia T2 Ultra","Rs 1300","Amazon","http://52.66.82.224/images/product/samsung-gallaxy.jpg");
//
//        Product product2 = new Product("Leather Wallet","Rs 1300","Amazon","http://52.66.82.224/images/product/wallet.jpg");
//
//        Product product3 = new Product("Puma shoes","Rs 1300","Amazon","http://52.66.82.224/images/product/pumashoes.jpg");
//        Product product4 = new Product("Belt","Rs 1300","Amazon","http://52.66.82.224/images/product/belt.jpg");
//        Product product5 = new Product("Fat Analyzer","Rs 1300","Amazon","http://52.66.82.224/images/product/fat_analyzor.jpg");
//
//
//        productList.add(product1);
//        productList.add(product2);
//        productList.add(product3);
//        productList.add(product4);
//        productList.add(product5);
//        productList.add(product1);
//        productList.add(product2);
//        productList.add(product3);
//        productList.add(product4);
//        productList.add(product5);
//        productList.add(product1);
//        productList.add(product2);
//        productList.add(product3);
//        productList.add(product4);
//        productList.add(product5);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView arrivalsRecycler = (RecyclerView)view.findViewById(R.id.recycler_new_arrivals);
        arrivalsRecycler.setHasFixedSize(true);

        ArrivalAdapter adapter = new ArrivalAdapter(DummyData.getDummyProducts());
        arrivalsRecycler.setLayoutManager(layoutManager);
        arrivalsRecycler.setAdapter(adapter);



    }

    private void initSimilarProducts(){

        ArrivalAdapter adapter = new ArrivalAdapter(DummyData.getDummyProducts());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,false);

        RecyclerView similarRecycler = (RecyclerView)view.findViewById(R.id.recycler_recents);
        similarRecycler.setHasFixedSize(true);
        similarRecycler.setLayoutManager(layoutManager);
        similarRecycler.setAdapter(adapter);


    }


    //********************************************************************************************************


    //==========================================Inner classes/interfaces======================================


    //********************************************************************************************************

}