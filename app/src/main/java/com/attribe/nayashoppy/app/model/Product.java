package com.attribe.nayashoppy.app.model;

import com.attribe.nayashoppy.app.model.popular_products.Data;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 17-Aug-16.
 */
public class Product {

    public Meta meta;
    public ArrayList<Data> data;

    public Meta getMeta() {
        return meta;
    }

    public ArrayList<Data> getData() {
        return data;
    }
}
