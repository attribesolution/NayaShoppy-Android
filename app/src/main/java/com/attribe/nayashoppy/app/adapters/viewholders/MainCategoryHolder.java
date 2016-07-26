package com.attribe.nayashoppy.app.adapters.viewholders;

import android.view.View;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;

/**
 * Created by Sabih Ahmed on 25-Jul-16.
 */
public class MainCategoryHolder {



    public TextView name;

    public MainCategoryHolder(View itemView) {

        name = (TextView)itemView.findViewById(R.id.category_name);
    }
}
