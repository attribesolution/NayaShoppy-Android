package com.attribe.nayashoppy.app.adapters.viewholders;

import android.view.View;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;


/**
 * Created by Sabih Ahmed on 25-Jul-16.
 */
public class ChildCategoryHolder {

    public TextView childName;

    public ChildCategoryHolder(View itemView) {

        childName = (TextView) itemView.findViewById(R.id.child_name);
    }
}
