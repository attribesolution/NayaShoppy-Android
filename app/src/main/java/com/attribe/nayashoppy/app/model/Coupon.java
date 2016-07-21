package com.attribe.nayashoppy.app.model;

/**
 * Created by Sabih Ahmed on 19-Jul-16.
 */
public class Coupon {

    private String couponName;
    private String couponImageURL;
    private String couponViewColor;

    public Coupon(String couponName, String couponImageURL, String couponViewColor) {
        this.couponName = couponName;
        this.couponImageURL = couponImageURL;
        this.couponViewColor = couponViewColor;
    }


    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponImageURL() {
        return couponImageURL;
    }

    public void setCouponImageURL(String couponImageURL) {
        this.couponImageURL = couponImageURL;
    }

    public String getCouponViewColor() {
        return couponViewColor;
    }

    public void setCouponViewColor(String couponViewColor) {
        this.couponViewColor = couponViewColor;
    }
}
