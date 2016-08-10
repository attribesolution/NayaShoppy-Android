package com.attribe.nayashoppy.app.screens;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.attribe.nayashoppy.app.R;

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
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setLogo(R.drawable.logo);
            actionBar.setDisplayUseLogoEnabled(true);
            onToolbarInit(toolbar,actionBar);

        }catch (NullPointerException npe){
            throw new RuntimeException("Parent view must include toolbar ");
        }


    }

    public abstract void onToolbarInit(Toolbar toolbar, ActionBar actionBar);
}
