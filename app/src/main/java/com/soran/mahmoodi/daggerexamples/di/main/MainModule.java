package com.soran.mahmoodi.daggerexamples.di.main;

import com.soran.mahmoodi.daggerexamples.adapter.PostsAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @MainScope
    @Provides
    static PostsAdapter adapter() {
        return new PostsAdapter();
    }

}
