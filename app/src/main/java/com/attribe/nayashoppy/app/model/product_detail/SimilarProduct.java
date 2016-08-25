package com.attribe.nayashoppy.app.model.product_detail;

import com.attribe.nayashoppy.app.model.Meta;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 25-Aug-16.
 */
public class SimilarProduct {
    public Meta meta;
    public ArrayList<Datum> data;

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
