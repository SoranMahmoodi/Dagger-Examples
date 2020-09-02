package com.soran.mahmoodi.daggerexamples.di.main;

import com.soran.mahmoodi.daggerexamples.ui.fargment.post.PostsFragment;
import com.soran.mahmoodi.daggerexamples.ui.fargment.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract ProfileFragment providerProfileFragment();

    @ContributesAndroidInjector()
    abstract PostsFragment providerPostFragment();
}
