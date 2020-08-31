package com.soran.mahmoodi.daggerexamples.ui.activity.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.soran.mahmoodi.daggerexamples.model.User;
import com.soran.mahmoodi.daggerexamples.repository.network.AuthApi;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {
    private static final String TAG = "AuthViewModel";


    private AuthApi authApi;
    private MediatorLiveData<User> userMediatorLiveData = new MediatorLiveData<>();

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
    }

    public void authenticationId(int userId) {
        LiveData<User> userLiveData = LiveDataReactiveStreams
                .fromPublisher(authApi.getUser(userId)
                        .subscribeOn(Schedulers.io()));

        userMediatorLiveData.addSource(userLiveData, user -> {
            userMediatorLiveData.setValue(user);
            userMediatorLiveData.removeSource(userLiveData);
        });
    }

    public LiveData<User> getUserMediatorLiveData() {
        return userMediatorLiveData;
    }
}
