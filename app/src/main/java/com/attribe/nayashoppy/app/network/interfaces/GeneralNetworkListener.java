package com.attribe.nayashoppy.app.network.interfaces;

/**
 * Created by Sabih Ahmed on 08-Aug-16.
 */
public interface GeneralNetworkListener {

    void onDataIssue(String message);

    void onFailure(String message);
}
