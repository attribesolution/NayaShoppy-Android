package com.attribe.nayashoppy.app.util;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;

/**
 * Created by Sabih Ahmed on 17-Aug-16.
 */
public class UINotifier {

    public static void showSnackBar(CoordinatorLayout coordinatorLayout, String message){
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }
}
