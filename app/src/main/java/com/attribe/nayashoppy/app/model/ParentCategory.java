package com.attribe.nayashoppy.app.model;

/**
 * Created by Sabih Ahmed on 19-Jul-16.
 */
public class ParentCategory {

    private String categoryName;
    private String categoryImageURL;

    public ParentCategory(String categoryName, String categoryImageURL) {
        this.categoryName = categoryName;
        this.categoryImageURL = categoryImageURL;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageURL() {
        return categoryImageURL;
    }

    public void setCategoryImageURL(String categoryImageURL) {
        this.categoryImageURL = categoryImageURL;
    }
}


