package com.soran.mahmoodi.daggerexamples.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.soran.mahmoodi.daggerexamples.model.User;
import com.soran.mahmoodi.daggerexamples.ui.activity.auth.AuthActivity;
import com.soran.mahmoodi.daggerexamples.utils.AuthResource;
import com.soran.mahmoodi.daggerexamples.utils.SessionManger;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity extends DaggerAppCompatActivity {
    private static final String TAG = "BaseActivity";
    @Inject
    public SessionManger sessionManger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObserver();
    }

    private void subscribeObserver() {
        sessionManger.getUserAuth()
                .observe(this, userAuthResource -> {
                    if (userAuthResource.status != null) {
                        switch (userAuthResource.status) {
                            case LOADING:
                                break;

                            case AUTHENTICATED:
                                Log.i(TAG, "getUser: Success login" + userAuthResource.data.getEmail());
                                break;

                            case ERROR:
                                Log.i(TAG, "getUser: Error Login" + userAuthResource.massage);
                                break;

                            case NOT_AUTHENTICATED:
                                navAuthScreen();
                                break;
                        }
                    }
                });
    }

    public void navAuthScreen() {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }

}
