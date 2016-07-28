package com.attribe.nayashoppy.app.network.bals;

import com.attribe.nayashoppy.app.model.Deals.Datum;
import com.attribe.nayashoppy.app.model.Deals.Deals;
import com.attribe.nayashoppy.app.network.RestClient;
import com.attribe.nayashoppy.app.network.interfaces.DealsListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 28-Jul-16.
 */
public class DealsBAL {


    public static void getDeals(final DealsListener dealsListener){

        Call<Deals> deals = RestClient.getAdapter().getDeals();

        deals.enqueue(new Callback<Deals>() {
            @Override
            public void onResponse(Call<Deals> call, Response<Deals> response) {

                if(response.isSuccessful()){

                    if(response.body()!=null){

                        ArrayList<Datum> deals = response.body().getData();
                        dealsListener.onDealsFetched(deals);

                    }
                }
            }

            @Override
            public void onFailure(Call<Deals> call, Throwable t) {

            }
        });

    }




}
