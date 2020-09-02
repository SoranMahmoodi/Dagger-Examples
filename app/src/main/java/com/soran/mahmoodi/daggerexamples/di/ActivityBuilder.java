package com.soran.mahmoodi.daggerexamples.di;

import com.soran.mahmoodi.daggerexamples.di.auth.AuthModule;
import com.soran.mahmoodi.daggerexamples.di.auth.AuthScope;
import com.soran.mahmoodi.daggerexamples.di.auth.AuthViewModelModule;
import com.soran.mahmoodi.daggerexamples.di.main.MainFragmentBuilderModule;
import com.soran.mahmoodi.daggerexamples.di.main.MainScope;
import com.soran.mahmoodi.daggerexamples.di.main.MainViewModelModule;
import com.soran.mahmoodi.daggerexamples.ui.activity.auth.AuthActivity;
import com.soran.mahmoodi.daggerexamples.ui.activity.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @AuthScope
    @ContributesAndroidInjector(modules = {AuthViewModelModule.class})
    abstract AuthActivity providerAuthActivity();

    @MainScope
    @ContributesAndroidInjector(modules = {MainFragmentBuilderModule.class, MainViewModelModule.class})
    abstract MainActivity providerMainActivity();

}
