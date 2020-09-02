package com.soran.mahmoodi.daggerexamples.ui.fargment.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.soran.mahmoodi.daggerexamples.model.User;
import com.soran.mahmoodi.daggerexamples.utils.AuthResource;
import com.soran.mahmoodi.daggerexamples.utils.SessionManger;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {
    private static final String TAG = "ProfileViewModel";
    private SessionManger sessionManger;

    @Inject
    public ProfileViewModel(SessionManger sessionManger) {
        this.sessionManger = sessionManger;
        Log.i(TAG, "ProfileViewModel: viewModel working....../ ");
    }

    public LiveData<AuthResource<User>> getUserDataProfile() {
        return sessionManger.getUserAuth();
    }
}
