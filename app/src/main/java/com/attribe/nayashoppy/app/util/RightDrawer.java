package com.attribe.nayashoppy.app.util;

/**
 * Created by Sabih Ahmed on 22-Jul-16.
 */
public class RightDrawer {

    private int optionIcon;
    private String optionName;

    public RightDrawer(String optionName, int optionIcon) {
        this.optionIcon = optionIcon;
        this.optionName = optionName;
    }

    public int getIconResource() {
        return optionIcon;
    }

    public void setOptionIconURL(int optionIcon) {
        this.optionIcon = optionIcon;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
