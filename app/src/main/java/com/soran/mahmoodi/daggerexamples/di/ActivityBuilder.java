package com.soran.mahmoodi.daggerexamples.di;

import com.soran.mahmoodi.daggerexamples.di.auth.AuthViewModelModule;
import com.soran.mahmoodi.daggerexamples.ui.activity.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {AuthViewModelModule.class})
    abstract AuthActivity providerAuthActivity();
}
