package com.attribe.nayashoppy.app.model.arrival;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 29-Jul-16.
 */
public class NewArrival {
    public Meta meta;
    public ArrayList<Datum> data = new ArrayList<Datum>();

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }
}
