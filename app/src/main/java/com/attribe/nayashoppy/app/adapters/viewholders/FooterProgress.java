package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.attribe.nayashoppy.app.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Sabih Ahmed on 11-Aug-16.
 */
public class FooterProgress extends PopularProductHolder {

    public AVLoadingIndicatorView progress;
    public FooterProgress(View view) {
        super(view);
        progress = (AVLoadingIndicatorView) view.findViewById(R.id.progress_wheel);
    }
}
