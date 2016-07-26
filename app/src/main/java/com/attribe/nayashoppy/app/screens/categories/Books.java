package com.attribe.nayashoppy.app.screens.categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.screens.BaseFragment;

/**
 * Created by Sabih Ahmed on 22-Jul-16.
 */
public class Books extends /**BaseFragment**/ Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.books,container,false);
    }
}
