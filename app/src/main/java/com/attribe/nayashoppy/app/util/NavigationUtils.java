package com.attribe.nayashoppy.app.util;

import android.content.Context;
import android.content.Intent;
import com.attribe.nayashoppy.app.screens.Main;

/**
 * Created by Sabih Ahmed on 18-Jul-16.
 */
public class NavigationUtils {


    public static void showHome(Context context) {

        Intent intent = new Intent(context,Main.class);
        context.startActivity(intent);

    }
}
