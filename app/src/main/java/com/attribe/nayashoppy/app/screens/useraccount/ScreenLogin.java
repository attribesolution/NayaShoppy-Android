package com.attribe.nayashoppy.app.screens.useraccount;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.attribe.nayashoppy.app.R;
import com.attribe.nayashoppy.app.adapters.LeftDrawerAdapter;
import com.attribe.nayashoppy.app.adapters.viewholders.LeftDrawerHolder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class ScreenLogin extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 0;
    private GoogleApiClient mGoogleApiClient;
    private GoogleSignInOptions gso;
    private SignInButton signInButton;
    private TextView signUp;
    private Uri UserImageuri;
    private String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_login);
        init();
        startListener();
        initGoogleClient();



    }

    private void startListener() {
        signInButton.setOnClickListener(new SignButton());
        signUp.setOnClickListener(new SignButton());

    }

    private void init() {
        signInButton = (SignInButton)findViewById(R.id.sign_in_button);
        signUp = (TextView)findViewById(R.id.sign_up_tv);

        //signInButton.setSize(SignInButton.SIZE_STANDARD);
       // signInButton.setScopes(gso.getScopeArray());


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


//    public void googleSignIn(View view)
//    {
//        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }

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

    }

    private void handleSignInResults(GoogleSignInResult result) {
        if(result.isSuccess()){
            Toast.makeText(this,"SignIn successfully",Toast.LENGTH_LONG).show();
            GoogleSignInAccount account = result.getSignInAccount();
            UserImageuri = account.getPhotoUrl();
            Username = account.getDisplayName();

        }
        else
        {
            Toast.makeText(this,"SignInFailed",Toast.LENGTH_LONG).show();

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
}
