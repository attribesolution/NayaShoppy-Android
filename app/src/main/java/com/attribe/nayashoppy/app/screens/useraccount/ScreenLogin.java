package com.attribe.nayashoppy.app.screens.useraccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.screens.Main;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class ScreenLogin extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSdkAspects();
        setContentView(R.layout.screen_login);

        initViews();
        callBacksOfAuthentication();
    }

    private void initSdkAspects() {

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    private void initViews() {
        loginButton = (LoginButton)findViewById(R.id.fbLogin_button);
    }

    private void callBacksOfAuthentication() {

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(ScreenLogin.this, "Login Successful !"+" "+" "+loginResult, Toast.LENGTH_SHORT).show();
                Intent homeIntent = new Intent(ScreenLogin.this, Main.class);
                startActivity(homeIntent);
            }

            @Override
            public void onCancel() {
                Toast.makeText(ScreenLogin.this, "Sorry LogIn UnSuccessful !", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(ScreenLogin.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


}
