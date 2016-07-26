package com.attribe.nayashoppy.app.util;

/**
 * Created by Sabih Ahmed on 22-Jul-16.
 */
public class RightDrawer {

    private String optionIconURL;
    private String optionName;

    public RightDrawer(String optionName,String optionIconURL) {
        this.optionIconURL = optionIconURL;
        this.optionName = optionName;
    }

    public String getOptionIconURL() {
        return optionIconURL;
    }

    public void setOptionIconURL(String optionIconURL) {
        this.optionIconURL = optionIconURL;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
