package com.attribe.nayashoppy.app.model.dummy_model;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 23-Aug-16.
 */
public class FilterKeys {

    public String key;
    public ArrayList<FilterValue> values;

    public FilterKeys(String key, ArrayList<FilterValue> values) {
        this.key = key;
        this.values = values;
    }

    public String getKey() {
        return key;
    }

    public ArrayList<FilterValue> getValues() {
        return values;
    }

}
