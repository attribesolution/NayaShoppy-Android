package com.attribe.nayashoppy.app.network.interfaces;

/**
 * Created by Sabih Ahmed on 25-Jul-16.
 */
public interface MenuListener {

    void onMenuReceived();
    void onMenuStored();

    void onFailure(String message);

    void onDataIssue(String message);
}
