package com.attribe.nayashoppy.app.model.product_category;

import java.io.Serializable;

/**
 * Created by Sabih Ahmed on 02-Aug-16.
 */


public class Supplier implements Serializable{

    public Integer id;
    public Integer product_id;
    public String cod;
    public String emi;
    public String return_policy;
    public String delivery;
    public String shipping;
    public String price;
    public String original_price;
    public String unique_id;
    public String discount;
    public String rating;
    public String rating_user_count;
    public String reviews;
    public String url;
    public String product_status;
    public String store_name;
    public Integer store_id;
    public String meta_title;
    public String meta_keyword;
    public String meta_desc;
    public Integer price_status;
    public String active;
    public String created;

    public Integer getId() {
        return id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public String getCod() {
        return cod;
    }

    public String getEmi() {
        return emi;
    }

    public String getReturn_policy() {
        return return_policy;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getShipping() {
        return shipping;
    }

    public String getPrice() {
        return price;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public String getDiscount() {
        return discount;
    }

    public String getRating() {
        return rating;
    }

    public String getRating_user_count() {
        return rating_user_count;
    }

    public String getReviews() {
        return reviews;
    }

    public String getUrl() {
        return url;
    }

    public String getProduct_status() {
        return product_status;
    }

    public String getStore_name() {
        return store_name;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public String getMeta_title() {
        return meta_title;
    }

    public String getMeta_keyword() {
        return meta_keyword;
    }

    public String getMeta_desc() {
        return meta_desc;
    }

    public Integer getPrice_status() {
        return price_status;
    }

    public String getActive() {
        return active;
    }

    public String getCreated() {
        return created;
    }
}
