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
import com.attribe.nayashoppy.app.adapters.*;
import com.attribe.nayashoppy.app.model.Coupon;
import com.attribe.nayashoppy.app.model.Datum;
import com.attribe.nayashoppy.app.model.Slider.Slider;
import com.attribe.nayashoppy.app.network.RestClient;
import com.attribe.nayashoppy.app.network.bals.ArrivalBAL;
import com.attribe.nayashoppy.app.network.interfaces.ArrivalListener;
import com.attribe.nayashoppy.app.util.DevicePreferences;
import com.attribe.nayashoppy.app.util.DummyData;
import com.attribe.nayashoppy.app.util.RecentViewed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private ImagePagerAdapter mImageAdapter;
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
        initRecentlyViewed();

    }


    //===================================private Methods=======================================================

    private void initSlider() {
        Call<Slider> slider = RestClient.getAdapter().getSlider();
        sliderImageURLList = new ArrayList<String>();


        slider.enqueue(new Callback<Slider>() {
            @Override
            public void onResponse(Call<Slider> call, Response<Slider> response) {
                if(response.isSuccessful())
                {

                    try {
                        if(response.body().getData()!=null || response.body().getData().size()>0){

                            try
                            {
                                ArrayList<Slider.Datum.Image> images = response.body().getData().get(0).getImages();
                                for(Slider.Datum.Image image: images){

                                    sliderImageURLList.add(image.getImage());

                                    mImageAdapter = new ImagePagerAdapter(getActivity(), sliderImageURLList);

                                    Home.this.slider.setAdapter(mImageAdapter);
                                }

                            }
                            catch (Exception exc){

                            }



                        }
                    }
                    catch (Exception exc){

                    }

                }
            }

            @Override
            public void onFailure(Call<Slider> call, Throwable t) {

            }
        });




        Update = new Runnable() {
            int position = 3;

            public void run() {
                // Change the position of view pager
                if (position == 3)
                    position = 0;
                Home.this.slider.setCurrentItem(position++, true);

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
        final LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        final RecyclerView arrivalsRecycler = (RecyclerView)view.findViewById(R.id.recycler_new_arrivals);
        arrivalsRecycler.setHasFixedSize(true);
        arrivalsRecycler.setLayoutManager(layoutManager);

        ArrivalBAL.getNewArrivals(new ArrivalListener() {
            @Override
            public void onDataFetched(ArrayList<com.attribe.nayashoppy.app.model.arrival.Datum> data) {
                ArrivalAdapter adapter = new ArrivalAdapter(data);
                arrivalsRecycler.setAdapter(adapter);
            }

            @Override
            public void onDataIssue() {
                //TODO: handle issue
            }

            @Override
            public void onFailure() {
                    //TODO: handle failure
            }
        });

    }

    private void initRecentlyViewed(){

       // RecentViewedAdapter recentsAdapter= new RecentViewedAdapter(DummyData.getDummyProducts());
        RecentViewedAdapter recentsAdapter= new RecentViewedAdapter(RecentViewed.recentviewedList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,false);

        RecyclerView similarRecycler = (RecyclerView)view.findViewById(R.id.recycler_recents);
        similarRecycler.setHasFixedSize(true);
        similarRecycler.setLayoutManager(layoutManager);
        similarRecycler.setAdapter(recentsAdapter);


    }


    //********************************************************************************************************


    //==========================================Inner classes/interfaces======================================


    //********************************************************************************************************

}