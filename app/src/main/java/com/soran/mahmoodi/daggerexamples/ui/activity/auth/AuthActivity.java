package com.soran.mahmoodi.daggerexamples.ui.activity.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.soran.mahmoodi.daggerexamples.R;
import com.soran.mahmoodi.daggerexamples.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {
    private static final String TAG = "AuthActivity";

    private AuthViewModel authViewModel;

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
        setProfile();
    }

    private void setProfile() {
        requestManager.load(logProfile)
                .into((ImageView) findViewById(R.id.login_logo));
    }
}