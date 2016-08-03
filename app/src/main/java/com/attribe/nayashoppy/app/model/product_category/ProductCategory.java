package com.attribe.nayashoppy.app.model.product_category;

import com.attribe.nayashoppy.app.model.Meta;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 02-Aug-16.
 */


public class ProductCategory {

    public Meta meta;
    public ArrayList<Datum> data = new ArrayList<Datum>();
    public Pagination pagination;

}
