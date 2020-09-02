package com.soran.mahmoodi.daggerexamples.di.main;

import androidx.lifecycle.ViewModel;

import com.soran.mahmoodi.daggerexamples.di.ViewModelKay;
import com.soran.mahmoodi.daggerexamples.ui.fargment.post.PostsViewModel;
import com.soran.mahmoodi.daggerexamples.ui.fargment.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKay(ProfileViewModel.class)
    abstract ViewModel providerProfileViewModel(ProfileViewModel profileViewModel);

    @Binds
    @IntoMap
    @ViewModelKay(PostsViewModel.class)
    abstract ViewModel providerPostViewModel(PostsViewModel postsViewModel);
}
