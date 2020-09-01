package com.soran.mahmoodi.daggerexamples.ui.activity.auth;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.soran.mahmoodi.daggerexamples.R;
import com.soran.mahmoodi.daggerexamples.ui.activity.main.MainActivity;
import com.soran.mahmoodi.daggerexamples.ui.base.BaseActivity;
import com.soran.mahmoodi.daggerexamples.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {
    private static final String TAG = "AuthActivity";

    private AuthViewModel authViewModel;
    private Button btnLogin;
    private EditText edtUserName;
    private ProgressBar pbLoading;
    @Inject
    Drawable logProfile;
    @Inject
    RequestManager requestManager;
    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        authViewModel = new ViewModelProvider(this, providerFactory).get(AuthViewModel.class);
        getUser();
        setProfile();
        setupViews();

    }

    private void setupViews() {
        btnLogin = findViewById(R.id.login_button);
        edtUserName = findViewById(R.id.user_id_input);
        pbLoading = findViewById(R.id.progress_bar);
        setBtnLogin();
        getEdtUserName();

    }

    private void setProfile() {
        requestManager.load(logProfile)
                .into((ImageView) findViewById(R.id.login_logo));
    }

    private void setBtnLogin() {
        btnLogin.setOnClickListener(view -> {
            getEdtUserName();
        });
    }

    private void getUser() {
        authViewModel.getUserMediatorLiveData()
                .observe(this, userAuthResource -> {
                    if (userAuthResource.status != null) {
                        switch (userAuthResource.status) {
                            case LOADING:
                                showProgressBar(true);
                                break;

                            case AUTHENTICATED:
                                Log.i(TAG, "getUser: Success login" + userAuthResource.data.getEmail());
                                showProgressBar(false);
                                onLoginSuccess();
                                break;

                            case ERROR:
                                Log.i(TAG, "getUser: Error Login" + userAuthResource.massage);
                                showProgressBar(false);
                                break;

                            case NOT_AUTHENTICATED:

                                showProgressBar(false);
                                break;
                        }
                    }
                });
    }

    private void getEdtUserName() {
        if (TextUtils.isEmpty(edtUserName.getText().toString())) {
            return;
        }
        authViewModel.authenticationId(Integer.parseInt(edtUserName.getText().toString()));
    }

    private void showProgressBar(boolean isVisible) {
        if (isVisible) {
            pbLoading.setVisibility(View.VISIBLE);
        } else {
            pbLoading.setVisibility(View.GONE);
        }
    }

    private void onLoginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
