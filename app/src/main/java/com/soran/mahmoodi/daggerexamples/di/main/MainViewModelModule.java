package com.soran.mahmoodi.daggerexamples.di.main;

import androidx.lifecycle.ViewModel;

import com.soran.mahmoodi.daggerexamples.di.ViewModelKay;
import com.soran.mahmoodi.daggerexamples.ui.fargment.post.PostViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKay(PostViewModel.class)
    abstract ViewModel providerPostViewModel(PostViewModel postViewModel);

}
