package com.attribe.nayashoppy.app.model.product_category;



import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 02-Aug-16.
 */
public class Datum {
    public Integer product_id;
    public Integer categories_category_id;
    public Integer brands_brand_id;
    public String product_name;
    public String slug;
    public String image;
    public String product_description;
    public String model_number;
    public String cod;
    //public String emi;
    public String return_policy;
    public String delivery;
    public String shipping;
    //public String price;
    public String unique_id;
    public String discount;
    public Integer rating;
    //public Integer rating_user_count;
    //public String reviews;
    public String url;
    public String product_status;
    public String date_add;
    public String date_update;
    public String date_launch;
    public Integer lowest_price;
    public Integer original_price;
    public Integer highest_price;
    //public String link_rewrite;
    public Integer supplier_count;
    public Integer store_name;
    public Integer store_id;
    public String meta_title;
    public String meta_keyword;
    public String meta_desc;
    public Integer show_home_page;
    public String active;
    public String created;
    public ArrayList<Image> images = new ArrayList<Image>();
    public ArrayList<Supplier> suppliers = new ArrayList<Supplier>();

    public Integer getProduct_id() {
        return product_id;
    }

    public Integer getCategories_category_id() {
        return categories_category_id;
    }

    public Integer getBrands_brand_id() {
        return brands_brand_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getSlug() {
        return slug;
    }

    public String getImage() {
        return image;
    }

    public String getProduct_description() {
        return product_description;
    }

    public String getModel_number() {
        return model_number;
    }

    public String getCod() {
        return cod;
    }

//    public String getEmi() {
//        return emi;
//    }

    public String getReturn_policy() {
        return return_policy;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getShipping() {
        return shipping;
    }

//    public Object getPrice() {
//        return price;
//    }

    public String getUnique_id() {
        return unique_id;
    }

    public Object getDiscount() {
        return discount;
    }

    public Integer getRating() {
        return rating;
    }

//    public Integer getRating_user_count() {
//        return rating_user_count;
//    }

//    public String getReviews() {
//        return reviews;
//    }

    public String getUrl() {
        return url;
    }

    public String getProduct_status() {
        return product_status;
    }

    public String getDate_add() {
        return date_add;
    }

    public String getDate_update() {
        return date_update;
    }

    public String getDate_launch() {
        return date_launch;
    }

    public Integer getLowest_price() {
        return lowest_price;
    }

    public Integer getOriginal_price() {
        return original_price;
    }

    public Integer getHighest_price() {
        return highest_price;
    }

//    public String getLink_rewrite() {
//        return link_rewrite;
//    }

    public Integer getSupplier_count() {
        return supplier_count;
    }

    public Integer getStore_name() {
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

    public Integer getShow_home_page() {
        return show_home_page;
    }

    public String getActive() {
        return active;
    }

    public String getCreated() {
        return created;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
}
