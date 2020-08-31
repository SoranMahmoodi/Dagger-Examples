package com.soran.mahmoodi.daggerexamples.ui.activity.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.soran.mahmoodi.daggerexamples.R;
import com.soran.mahmoodi.daggerexamples.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {
    private static final String TAG = "AuthActivity";

    private AuthViewModel authViewModel;
    private Button btnLogin;
    private EditText edtUserName;
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
                .observe(this, user -> {
                    if (user != null) {
                        Toast.makeText(AuthActivity.this, user.getEmail(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void getEdtUserName() {
        if (TextUtils.isEmpty(edtUserName.getText().toString())) {
            return;
        }
        authViewModel.authenticationId(Integer.parseInt(edtUserName.getText().toString()));
    }
}