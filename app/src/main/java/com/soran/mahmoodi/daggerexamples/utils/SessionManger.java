package com.soran.mahmoodi.daggerexamples.utils;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.soran.mahmoodi.daggerexamples.model.User;
import com.soran.mahmoodi.daggerexamples.repository.network.AuthApi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManger {
    private static final String TAG = "SessionManger";
    private AuthApi authApi;
    private MediatorLiveData<AuthResource<User>> userAuth = new MediatorLiveData<>();

    @Inject
    public SessionManger() {

    }

    public void userAuthentication(LiveData<AuthResource<User>> resourceLiveData) {
        if (userAuth != null) {
            userAuth.setValue(AuthResource.loading((User) null));
            userAuth.addSource(resourceLiveData, new Observer<AuthResource<User>>() {
                @Override
                public void onChanged(AuthResource<User> userAuthResource) {
                    if (userAuthResource != null) {
                        userAuth.setValue(userAuthResource);
                        userAuth.removeSource(resourceLiveData);
                    }
                    if (userAuthResource.status.equals(AuthStatus.ERROR)) {
                        userAuth.setValue(AuthResource.<User>logout());
                    }
                }
            });
        }
    }

    public void logout() {
        Log.i(TAG, "logout: ");
        userAuth.setValue(AuthResource.<User>logout());
    }

    public LiveData<AuthResource<User>> getUserAuth() {
        return userAuth;
    }
}
