package com.soran.mahmoodi.daggerexamples.di.main;

import com.soran.mahmoodi.daggerexamples.ui.fargment.post.PostFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract PostFragment providerFragmentPost();
}
