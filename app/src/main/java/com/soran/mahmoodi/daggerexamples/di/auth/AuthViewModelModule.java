package com.soran.mahmoodi.daggerexamples.di.auth;

import androidx.lifecycle.ViewModel;

import com.soran.mahmoodi.daggerexamples.di.ViewModelKay;
import com.soran.mahmoodi.daggerexamples.ui.activity.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKay(AuthViewModel.class)
    public abstract ViewModel bindViewModel(AuthViewModel authViewModel);
}
