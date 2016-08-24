package com.attribe.nayashoppy.app.model.popular_products;


import java.util.ArrayList;
import com.attribe.nayashoppy.app.model.product_category.Image;
import com.attribe.nayashoppy.app.model.product_category.Supplier;
/**
 * Created by Sabih Ahmed on 08-Aug-16.
 */
public class Data {

    public int product_id;
    public int categories_category_id;
    public int brands_brand_id;
    public String product_name;
    public String slug;
    public String image;
    public String product_description;
    public String model_number;
    public String cod;
    public String emi;
    public String return_policy;
    public String delivery;
    public String shipping;
    public String price;
    public String unique_id;
    public String discount;
    public String rating;
    public String rating_user_count;
    public String reviews;
    public String url;
    public String product_status;
    public String date_add;
    public String date_update;
    public String date_launch;
    public String lowest_price;
    public String original_price;
    public String highest_price;
    public String link_rewrite;
    public int supplier_count;
    public int store_name;
    public int store_id;
    public String meta_title;
    public String meta_keyword;
    public String meta_desc;
    public int show_home_page;
    public String active;
    public String created;
    public ArrayList<Image> images;
    public ArrayList<Supplier> suppliers;
    public ArrayList<FeaturesList> featuresList;

    public int getProduct_id() {
        return product_id;
    }

    public int getCategories_category_id() {
        return categories_category_id;
    }

    public int getBrands_brand_id() {
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

    public String getDate_add() {
        return date_add;
    }

    public String getDate_update() {
        return date_update;
    }

    public String getDate_launch() {
        return date_launch;
    }

    public String getLowest_price() {
        return lowest_price;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public String getHighest_price() {
        return highest_price;
    }

    public String getLink_rewrite() {
        return link_rewrite;
    }

    public int getSupplier_count() {
        return supplier_count;
    }

    public int getStore_name() {
        return store_name;
    }

    public int getStore_id() {
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

    public int getShow_home_page() {
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

    public ArrayList<FeaturesList> getFeaturesList() {
        return featuresList;
    }



    //=======================================================Inner classes============================================
    public class FeaturesList {

        public String featureGroupName;
        public ArrayList<FeatureValue> featureValues;


        public String getFeatureGroupName() {
            return featureGroupName;
        }

        public ArrayList<FeatureValue> getFeatureValues() {
            return featureValues;
        }

        public class FeatureValue {
            public String featureName;
            public String featureValue;


            public String getFeatureName() {
                return featureName;
            }

            public String getFeatureValue() {
                return featureValue;
            }
        }

    }



}
