package com.attribe.nayashoppy.app.network.bals;

import com.attribe.nayashoppy.app.model.arrival.NewArrival;
import com.attribe.nayashoppy.app.network.RestClient;
import com.attribe.nayashoppy.app.network.interfaces.ArrivalListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sabih Ahmed on 29-Jul-16.
 */
public class ArrivalBAL {

    public static void getNewArrivals(final ArrivalListener listener){

        Call<NewArrival> arrivals = RestClient.getAdapter().getArrivals();

        arrivals.enqueue(new Callback<NewArrival>() {
            @Override
            public void onResponse(Call<NewArrival> call, Response<NewArrival> response) {

                if(response.isSuccessful()){

                    if(!response.body().getData().isEmpty()){

                        listener.onDataFetched(response.body().getData());
                    }
                }

                else{

                    listener.onDataIssue();
                }

            }

            @Override
            public void onFailure(Call<NewArrival> call, Throwable t) {

                listener.onFailure();
            }
        });

    }
}
