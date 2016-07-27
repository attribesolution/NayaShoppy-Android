package com.attribe.nayashoppy.app.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.util.ExceptionHelper;

/**
 * Created by Sabih Ahmed on 18-Jul-16.
 */
public abstract class BaseActivity extends AppCompatActivity{

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void initToolbar(View view) {

        try {

            toolbar = (Toolbar) view.findViewById(R.id.toolbar_home);
            onToolbarInit(toolbar);

        }catch (NullPointerException npe){
            throw new RuntimeException("Parent view must include toolbar ");
        }


    }

    public abstract void onToolbarInit(Toolbar toolbar);
}
