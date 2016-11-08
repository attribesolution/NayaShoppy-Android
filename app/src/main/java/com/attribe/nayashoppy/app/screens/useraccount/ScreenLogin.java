package com.attribe.nayashoppy.app.screens.useraccount;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.screens.Main;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class ScreenLogin extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private ImageButton fbButton;
    private ImageButton googleButton;
    private static final int RC_SIGN_IN = 0;
    private GoogleApiClient mGoogleApiClient;
    private GoogleSignInOptions gso;
    private Button signInButton;
    private TextView signUp;
    private Uri UserImageuri;
    private String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSdkAspects();
        setContentView(R.layout.screen_login);
        initGoogleClient();

        initViews();
        callBacksOfAuthentication();

        startListener();

    }

    private void initSdkAspects() {

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    private void initViews() {
        loginButton = (LoginButton)findViewById(R.id.fbLogin_button);
//        fbButton = (ImageButton)findViewById(R.id.fbcustombutton);
        signInButton = (Button)findViewById(R.id.sign_in_button);
//        googleButton = (ImageButton) findViewById(R.id.googleCustomBtn);
        signUp = (TextView)findViewById(R.id.sign_up_tv);
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

//    private void fbCustomCalling() {
//        fbButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loginButton.callOnClick();
//            }
//        });
//    }
//
//    private void googleCustomCalling() {
//        googleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signInButton.callOnClick();
//            }
//        });
//    }

    private void startListener() {
        signInButton.setOnClickListener(new SignButton());
        signUp.setOnClickListener(new SignButton());

    }

    private void initGoogleClient() {

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */,this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this,"GoogleSignInConnection Failed",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN)
        {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResults(result);

        }
        else{
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }

    }

    private void handleSignInResults(GoogleSignInResult result) {
        if(result.isSuccess()){
            Toast.makeText(this,"SignIn successfully",Toast.LENGTH_LONG).show();
            GoogleSignInAccount account = result.getSignInAccount();
            UserImageuri = account.getPhotoUrl();
            Username = account.getDisplayName();

            Intent homeIntent = new Intent(ScreenLogin.this, Main.class);
            startActivity(homeIntent);

        }
    }

    private class SignButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.sign_in_button:
                    Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                    startActivityForResult(signInIntent, RC_SIGN_IN);
                    break;

                case R.id.sign_up_tv:
                    Intent signUpIntent = new Intent(getApplicationContext(),ScreenSignUp.class);
                    startActivity(signUpIntent);

            }
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//    }


}
