package com.soran.mahmoodi.daggerexamples.di;

import androidx.lifecycle.ViewModelProvider;

import com.soran.mahmoodi.daggerexamples.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindsViewModelProvider(ViewModelProviderFactory viewModelProviderFactory);
}
