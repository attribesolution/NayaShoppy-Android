package com.attribe.nayashoppy.app.util;

/**
 * Created by attribe on 10/14/16.
 */
public class ViewedProduct {
    private String productName;
    private String productPrice;
    private String productVendor;
    private String productImageURL;
    public ViewedProduct(String productName, String productPrice, String productVendor, String productImageURL) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productVendor = productVendor;
        this.productImageURL = productImageURL;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

}
