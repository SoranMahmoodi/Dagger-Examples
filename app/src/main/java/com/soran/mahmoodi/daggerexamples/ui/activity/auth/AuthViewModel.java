package com.soran.mahmoodi.daggerexamples.ui.activity.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.soran.mahmoodi.daggerexamples.model.User;
import com.soran.mahmoodi.daggerexamples.repository.network.AuthApi;
import com.soran.mahmoodi.daggerexamples.utils.AuthResource;
import com.soran.mahmoodi.daggerexamples.utils.SessionManger;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {
    private static final String TAG = "AuthViewModel";


    private AuthApi authApi;
    private SessionManger sessionManger;

    @Inject
    public AuthViewModel(AuthApi authApi, SessionManger sessionManger) {
        this.authApi = authApi;
        this.sessionManger = sessionManger;
    }

    public void authenticationId(int userId) {
        sessionManger.userAuthentication(userLiveData(userId));
    }

    public LiveData<AuthResource<User>> userLiveData(int userId) {
        return LiveDataReactiveStreams
                .fromPublisher(authApi.getUser(userId)
                        .onErrorReturn(throwable -> {
                            User errorUser = new User();
                            errorUser.setId(-1);
                            return errorUser;
                        })
                        .map(user -> {
                            if (user.getId() == -1) {
                                return AuthResource.error("clod not authentication", (User) null);

                            }
                            return AuthResource.authenticated(user);
                        })
                        .subscribeOn(Schedulers.io()));

    }

    public LiveData<AuthResource<User>> getUserMediatorLiveData() {
        return sessionManger.getUserAuth();
    }
}
