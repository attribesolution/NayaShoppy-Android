package com.attribe.nayashoppy.app.network.interfaces;

import com.attribe.nayashoppy.app.model.arrival.Datum;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 29-Jul-16.
 */
public interface ArrivalListener {

    void onDataFetched(ArrayList<Datum> data);


    void onDataIssue();

    void onFailure();
}
