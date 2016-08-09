package com.attribe.nayashoppy.app.model.popular_products;

import com.attribe.nayashoppy.app.model.Meta;
import com.attribe.nayashoppy.app.model.product_category.Pagination;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 08-Aug-16.
 */
public class PopularProducts {

    public Meta meta;
    public ArrayList<Data> data;
    public Pagination pagination;


    public Meta getMeta() {
        return meta;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
