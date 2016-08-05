package com.attribe.nayashoppy.app.model.product_category;

import com.attribe.nayashoppy.app.model.Meta;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 02-Aug-16.
 */


public class ProductCategory {

    public Meta meta;

    public ArrayList<Datum> data = new ArrayList<Datum>();
//    public Pagination pagination;
//
//
//    public Meta getMeta() {
//        return meta;
//    }
//
//    public void setMeta(Meta meta) {
//        this.meta = meta;
//    }
//
    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }
//
//    public Pagination getPagination() {
//        return pagination;
//    }
//
//    public void setPagination(Pagination pagination) {
//        this.pagination = pagination;
//    }
}
